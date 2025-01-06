package com.example.stest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stest.model.Movie;

import org.springframework.ui.Model;
@Controller
public class UserController {

    @GetMapping("/")
    public String index( Model model){
        model.addAttribute("hello", "hi, hello");
        model.addAttribute("school", "세명컴퓨터고등학교");
        model.addAttribute("user", "Park"); 
        List<Movie> movies = Arrays.asList(
            new Movie(1L, "https://img.megabox.co.kr/SharedImg/2021/02/01/qDLdOQKdvIeLyniUM7DX567IaJeyJmbv_420.jpg",
            "무한열차편", "2021.01.27", "하나에 나츠키", "소토자키 하루오"),
            new Movie(2L, "https://img.megabox.co.kr/SharedImg/2021/06/10/7deO12OmPdV0fCZlT1YA68dpI6mOGDKI_420.jpg",
            "캐시트럭", "2021.06.09", "제이슨 스타뎀", "가이 리치"),
           new Movie(3L, "https://img.megabox.co.kr/SharedImg/2021/05/21/L1u1sOkUsSQ0Ut8erY62YQxGtOMcInj2_420.jpg",
            "500일의 썸머", "2021.05.26", "클로이 모레츠", "마크 웹")
        ); 
        model.addAttribute("movies", movies);
        return "index";
    }  

    @GetMapping("/test")
    public String test( Model model){
        return "test";
    }

    @GetMapping("/my")
    public String my( Model model){
        return "my";
    }

    @GetMapping("/form")
    public String form( Model model){
        return "form";
    }    
    
    @GetMapping("/person")
    public String person( @RequestParam("name") String name , 
                          @RequestParam("age") int age , 
                          Model model)
    {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "person";
    }

    
}
