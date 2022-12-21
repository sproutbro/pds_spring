package cf.eisp.pds_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PdsSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdsSpringApplication.class, args);
    }

}
