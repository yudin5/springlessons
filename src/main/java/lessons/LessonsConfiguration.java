package lessons;

import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import javax.annotation.PostConstruct;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
public class LessonsConfiguration {
    @Bean(name = "first")
    @Description("This is our first bean")
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}