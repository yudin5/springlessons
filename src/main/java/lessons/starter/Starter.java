package lessons.starter;

import lessons.services.BeanWithDependency;
import lessons.services.GreetingService;
import lessons.LessonsConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Starter {

    private static final Logger logger = LogManager.getLogger(Starter.class);

    public static void main(String[] args) {
        logger.info("Starting configuration...");

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(LessonsConfiguration.class);
        GreetingService greetingService = context.getBean(GreetingService.class);
//      GreetingService greetingService = (GreetingService) context.getBean("first");
        BeanWithDependency withDependency = context.getBean(BeanWithDependency.class);
        logger.info(greetingService.sayGreeting()); // "Greeting, user!"
        logger.info(withDependency.printServiceName());
        context.registerShutdownHook();
    }
}
