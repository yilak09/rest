package com.howtodoinjava.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmpService {
    public boolean isInFuture(int yearOfBirth) {

        boolean isInfuture =false;
        if(yearOfBirth>2019){
            isInfuture =true;

        }else{
            isInfuture=false;
        }
        return isInfuture;
    }

   public int calculateAge(int yearOfBirth){
        return 2019-yearOfBirth;
    }
}
