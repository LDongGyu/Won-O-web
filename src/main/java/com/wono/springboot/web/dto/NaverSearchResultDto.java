package com.wono.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NaverSearchResultDto {
    private String title;
    private String link;
    private String description;

    @Builder
    public NaverSearchResultDto(String title, String link, String description){
        this.title = title;
        this.link = link;
        this.description = description;
    }
}
