package com.mbb.mbg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CodeGenerateTest {

    @Autowired
    private MyCodeGenerator myCodeGenerator;

    @Test
    void generatorCode() {
        myCodeGenerator.generateCode();
//        System.out.println(System.getProperty("user.dir"));
    }
}
