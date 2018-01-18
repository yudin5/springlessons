package lessons.services;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class GreetingServiceImpl implements GreetingService {

    private ApplicationContext context;

//    @Required
//    public void setContext(ApplicationContext context) {
//        this.context = context;
//    }

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
