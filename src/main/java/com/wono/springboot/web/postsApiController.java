package com.wono.springboot.web;


import com.wono.springboot.service.posts.PostsService;
import com.wono.springboot.web.dto.PostsCreateRequestDto;
import com.wono.springboot.web.dto.PostsResponseDto;
import com.wono.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class postsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long create(@RequestBody PostsCreateRequestDto postsCreateRequestDto){
        return postsService.create(postsCreateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
g
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
        return postsService.update(id, postsUpdateRequestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
