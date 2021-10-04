package com.alsacad.quarkusTests.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServices {
    public String greeting(String name) {
        return "Java is not bad: " + name;
    }
}
