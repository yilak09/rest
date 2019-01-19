package com.howtodoinjava.demo;
import com.howtodoinjava.demo.Service.EmpService;
import com.howtodoinjava.demo.controller.EmployeeController;
import com.howtodoinjava.demo.model.Employee;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class controllerTest {

    EmpService empMockservice= mock(EmpService.class);
    List<Employee> lemp =new ArrayList();
    EmployeeController employeeController = new EmployeeController();
    Employee emp = new Employee();

    @Before
    public void setUp(){

        emp.setFirstName("yilak");
        emp.setEmail("example@gmail.com");
        emp.setLastName("Ayele");
        emp.setId(1);
        lemp.add(emp);
        when(empMockservice.addEmp(emp)).thenReturn(lemp);

    }
     @Test
    public void testGet(){


        System.out.println(empMockservice.addEmp(emp));
        //verify(empMockservice).addEmp(emp);
       assertEquals(employeeController.getEmployees(),lemp);
     }


}
