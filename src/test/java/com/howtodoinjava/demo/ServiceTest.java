package com.howtodoinjava.demo;
import com.howtodoinjava.demo.Service.EmpService;
import com.howtodoinjava.demo.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private Employee emp;
    @Autowired
    private EmpService empservice;


    @Test
    public void contextLoads() {
    }

    @Before
    public void setUp(){
        emp.setFirstName("yilak");
        emp.setEmail("example@gmail.com");
        emp.setLastName("Ayele");
        emp.setId(1);
    }
    @Test
    public void testCalculate (){
        int age =empservice.calculateAge(2013);
        assertEquals(age,6);
    }
    @Test
    public void testIsFuture (){
        boolean isfuture =empservice.isInFuture(2013);
        assertEquals(isfuture,false);
    }


}
