package lessons.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class GreetingServiceImpl implements GreetingService {
    public String sayGreeting() {
        return "Greeting, user!";
    }

    @PostConstruct
    public void before() {
        System.out.println("Before...");
    }

    @PreDestroy
    public void after() {
        System.out.println("After...");
    }
}
