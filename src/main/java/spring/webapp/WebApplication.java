package spring.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import spring.webapp.database.Entity.Account;
import spring.webapp.database.Repository.AccountRepository;

@SpringBootApplication
@Configuration
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public CommandLineRunner demo(AccountRepository repository) {
        return (args) -> {
            //repository.save(new Account("bob@email.com", "1234", "customer"));
            //repository.save(new Account("zooey@email.com", "abcd", "customer"));
            Account account = repository.findByEmail("bob@email.com");
            account.setPassword("hello");
            repository.save(account);
        };
    }
}
