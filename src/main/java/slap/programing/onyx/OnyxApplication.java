package slap.programing.onyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication ()
public class OnyxApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnyxApplication.class, args);
    }

}
