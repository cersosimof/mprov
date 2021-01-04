package com.provee;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
public class Application {

    /**
     * Application's main method
     *
     * @param args the console arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    public class MessagingRestService {

        @GetMapping(path = "/user/message")
        public String getUserMessage() {


            return "Hello, User";
        }
    }
}