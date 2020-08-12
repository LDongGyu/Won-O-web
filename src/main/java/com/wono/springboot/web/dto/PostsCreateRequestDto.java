package com.wono.springboot.web.dto;

import com.wono.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsCreateRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsCreateRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
