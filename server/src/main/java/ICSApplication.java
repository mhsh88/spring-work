import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@ComponentScan("controllers")
@SpringBootApplication
@EnableJpaAuditing
public class ICSApplication {
    public static void main (String[] args){

        SpringApplication.run(ICSApplication.class, args);
    }
}
