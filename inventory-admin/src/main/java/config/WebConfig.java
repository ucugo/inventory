package config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import security.UserDetailsServiceImpl;
import security.UserLookupInterceptor;
import web.CurrentRequestInterceptor;

/**
 * Created by Ugo on 02/05/2015.
 */

@EnableWebMvc
@Configuration
@Import(value = {SecurityConfig.class})
@ComponentScan(basePackages = {"config","controllers"})
public class WebConfig extends WebMvcConfigurerAdapter{


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .setCachePeriod(31556926);
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(5242880);
        return commonsMultipartResolver;
    }

    @Bean
    public ResourceBundleMessageSource resourceBundleMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("/WEB-INF/messages");
        return resourceBundleMessageSource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addWebRequestInterceptor(currentRequestInterceptor());
        registry.addWebRequestInterceptor(userLookupInterceptor());
    }

    @Bean
    public CurrentRequestInterceptor currentRequestInterceptor(){
        return new CurrentRequestInterceptor();
    }

    @Bean
    public UserLookupInterceptor userLookupInterceptor(){
        return new UserLookupInterceptor();
    }

    @Bean
    public UserDetailsServiceImpl userDetailsServiceImpl(){
        return new UserDetailsServiceImpl();
    }


}
