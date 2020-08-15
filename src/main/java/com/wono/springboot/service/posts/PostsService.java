package com.wono.springboot.service.posts;

import com.wono.springboot.domain.posts.Posts;
import com.wono.springboot.domain.posts.PostsRepository;
import com.wono.springboot.web.dto.PostsCreateRequestDto;
import com.wono.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long create(PostsCreateRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
