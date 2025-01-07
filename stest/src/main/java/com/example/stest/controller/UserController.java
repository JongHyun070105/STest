package com.example.stest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stest.model.Movie;
import com.example.stest.model.Person;
import com.example.stest.myclass.BmiCalc;
import com.example.stest.repository.PersonRepository;

import org.springframework.ui.Model;

@Controller
public class UserController {

    @Autowired PersonRepository personRepository; 
    @Autowired BmiCalc calc;

    // private final BmiCalc calcc;
    // public UserController(BmiCalc clac){
    //     this.calcc = calc;
    // } 두번째 방법

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
        personRepository.save(new Person(null,name,age)); // insert
        return "person";
    }

    @GetMapping("/form2")
    public String form2( Model model){
        return "form2";
    }    

    @GetMapping("/sum")
    public String sum( @RequestParam("number1") int number1 , 
                          @RequestParam("number2") int number2 , 
                          Model model)
    {
        model.addAttribute("add", number1+number2);
        return "sum";
    }

    @GetMapping("/show")
    public String show( Model model){
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "show";
    }   
    
    @GetMapping("/bmiform")
    public String form3( Model model){
        return "bmiform";
    }   

    @GetMapping("/bmiresult")
    public String bmiresult(
        @RequestParam("height") double height,
        @RequestParam("weight") double weight,
        Model model
    ) {
        model.addAttribute("height", height);
        model.addAttribute("weight", weight);

        // double stdWeight = (height - 100) * 0.85;
        // double BMI = weight/stdWeight*100;
        // String result = "";
        
        // if(BMI < 90) result = "저체중";
        // else if(BMI >= 90 && BMI < 110) result = "정상";
        // else if(BMI >= 110 && BMI < 120) result = "과체중";
        // else result = "비만";

        // model.addAttribute("result",result);
        // return "bmiresult";

        
        BmiCalc calc = new BmiCalc();
        String result = calc.clacBMI(height, weight);
        model.addAttribute("height", height);
        model.addAttribute("weight", weight);
        model.addAttribute("result", result);
        return "bmiresult";
    }
}

