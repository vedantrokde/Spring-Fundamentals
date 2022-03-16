package com.code;

import java.io.File;

import com.code.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args )
    {
        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON and map/convert to POJO
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // print object
            System.out.println("Student: " + student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
