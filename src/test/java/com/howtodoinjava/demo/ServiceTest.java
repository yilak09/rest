package com.howtodoinjava.demo;
import com.howtodoinjava.demo.Service.*;
import com.howtodoinjava.demo.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private Employee emp;
    @Autowired
    private EmpService empservice;

    CalculatorService service =mock(CalculatorService.class);
    Calculator c =null;
    Employee mockEmployee=mock(Employee.class);
    EmpService mockEmployeeService=mock(EmpService.class);
    @Before
    public void setUp(){

        emp.setFirstName("yilak");
        emp.setEmail("example@gmail.com");
        emp.setLastName("Ayele");
        emp.setId(1);
        c=new Calculator(service);
        mockEmployee.setLastName("Abere");
        mockEmployee.setFirstName("Tibebe");
        mockEmployee.setEmail("tibebe.abere@gmail.com");
        mockEmployee.setId(3);
    }
    @Test
    public void testCalculate (){
        int age =empservice.calculateAge(2013);
        System.out.println(age);
        assertEquals(age,6);
    }
    @Test
    public void testIsFuture (){
        boolean isfuture =empservice.isInFuture(2013);
        assertEquals(isfuture,false);
    }

    @Test
    public void testAddEmp (){
        List<Employee> lemp=empservice.addEmp(mockEmployee);
        when(mockEmployeeService.addEmp(mockEmployee)).thenReturn(lemp);
        assertEquals(1,lemp.size());
    }

    @Test
    public void testCalculator(){
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10,c.perform(2,3));
    }
}
