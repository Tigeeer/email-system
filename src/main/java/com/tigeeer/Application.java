package com.tigeeer;

import com.tigeeer.pojo.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by tigeeer on 2016/10/10.
 */
@SpringBootApplication
@EnableConfigurationProperties(value = {Config.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
