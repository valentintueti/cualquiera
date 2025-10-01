package org.example.cualquiera;

import org.springframework.boot.SpringApplication;

public class TestCualquieraApplication {

    public static void main(String[] args) {
        SpringApplication.from(CualquieraApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
