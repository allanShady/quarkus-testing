package com.alsacad.quarkusTests;

import javax.enterprise.context.ApplicationScoped;

import com.alsacad.quarkusTests.services.GreetingServices;

import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
public class MockGreetingServices extends GreetingServices {

    @Override
    public String greeting(String name) {
        return "Java is not bad: " + name + "<<<<<<<<<<<<<<<<< from mock >>>>>>>>>>>>>>";
    }
}
