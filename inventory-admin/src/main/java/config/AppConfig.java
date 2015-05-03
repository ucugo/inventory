package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import security.UserLookupInterceptor;

/**
 * Created by Ugo on 03/05/2015.
 */

@Component
@ImportResource({"classpath:applicationContext.xml"})
public class AppConfig {
    @Bean
    public UserLookupInterceptor userLookupInterceptor(){
        return new UserLookupInterceptor();
    }
}
