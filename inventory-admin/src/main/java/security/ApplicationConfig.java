//package security;
//
//import org.springframework.context.annotation.*;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//import security.SecurityConfig;
//
///**
// * Created by Ugo on 02/05/2015.
// */
//
//@EnableWebMvc
//
//@ImportResource(value = {"classpath:applicationContext.xml"})
//@Import(value = { SecurityConfig.class })
//@ComponentScan(basePackages = { "controllers" })
//public class ApplicationConfig extends WebMvcConfigurerAdapter{
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/resources/**")
//                .addResourceLocations("/resources/")
//                .setCachePeriod(31556926);
//    }
//
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver
//                = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/pages/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
//
//}
