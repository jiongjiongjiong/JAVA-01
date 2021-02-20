package com.zc.week05;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {
    
    @Autowired
    private Klass klass;

    @Resource(name = "student100")
    Student student100;
    
    @Override
    public void ding(){
    
        System.out.println("Class1 have " + this.klass.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
