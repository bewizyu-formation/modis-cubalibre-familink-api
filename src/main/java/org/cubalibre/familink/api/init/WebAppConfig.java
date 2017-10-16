package org.cubalibre.familink.api.init;

import org.cubalibre.familink.api.config.DataSourceMySQLConfig;
import org.cubalibre.familink.api.config.JpaConfig;
import org.cubalibre.familink.api.config.ServicesConfig;
import org.cubalibre.familink.api.web.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@CrossOrigin
@Configuration
@EnableWebMvc
@Import({ServicesConfig.class, JpaConfig.class, DataSourceMySQLConfig.class})
public class WebAppConfig {

    @Bean
    public ViewResolver viewResolver() {

        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }

    @Bean
    public TokenInterceptor getTokenInterceptor(){
        return new TokenInterceptor();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                        .allowedHeaders("Content-Type", "Authorization");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(getTokenInterceptor())
                        .excludePathPatterns("/profil");
                        //.excludePathPatterns("/auth");
                        //.excludePathPatterns("/reinitPass");
                       // .excludePathPatterns("/user/create");
                      }
        };
    }


}
