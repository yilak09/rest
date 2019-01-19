package com.howtodoinjava.demo.Service;

import com.howtodoinjava.demo.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpService {
    public boolean isInFuture(int yearOfBirth) {

        boolean isInfuture;
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

    public List<Employee> addEmp(Employee emp){
        List<Employee> lEmp = new ArrayList<Employee>();
        lEmp.add(emp);
        return lEmp;
    }
}
