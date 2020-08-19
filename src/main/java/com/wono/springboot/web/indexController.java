package com.wono.springboot.web;

import com.google.gson.JsonArray;
import com.wono.springboot.api.NaverApi;
import com.wono.springboot.service.posts.PostsService;
import com.wono.springboot.web.dto.NaverSearchResultDto;
import com.wono.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@RequiredArgsConstructor
@Controller
public class indexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        ArrayList<NaverSearchResultDto> response = NaverApi.naverApiResult();
        model.addAttribute("result",response);
        return "index";
    }

    @GetMapping("/posts/create")
    public String create(){
        return "posts-create";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
