package com.example.stest.myclass;

import org.springframework.stereotype.Component;

@Component
public class BmiCalc {
    public String clacBMI(double height, double weight){
        
        double stdWeight = (height - 100) * 0.85;
        double BMI = weight/stdWeight*100;
        
        if(BMI < 90) 
            return  "저체중";
        else if(BMI >= 90 && BMI < 110) 
            return "정상";
        else if(BMI >= 110 && BMI < 120) 
            return "과체중";
        else 
            return "비만";

        
    }
}
