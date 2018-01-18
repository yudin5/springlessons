package lessons;

import lessons.services.BeanWithDependency;
import lessons.services.CommandManager;
import lessons.services.GreetingService;
import lessons.services.GreetingServiceImpl;
import org.springframework.context.annotation.*;

/**
 * Конфигурационный класс Spring IoC контейнера
 */
@Configuration
@ComponentScan
@Import(AnotherConfiguration.class)
public class LessonsConfiguration {
    //@Bean(name = "first")
    @Description("This is our first bean")
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }

    @Bean
    @Scope("prototype")
    public Object asyncCommand() {
        return new Object();
    }

    @Bean
    public CommandManager commandManager() {
        // возвращаем новую анонимную реализацию CommandManager
        // с новым объектом
        return new CommandManager() {
            protected Object createCommand() {
                return asyncCommand();
            }
        };
    }

//    @Bean
//    BeanWithDependency beanWithDependency() {
//        return new BeanWithDependency(greetingService());
//    }
}