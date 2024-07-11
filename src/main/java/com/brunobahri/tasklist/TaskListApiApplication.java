package com.brunobahri.tasklist;

import com.brunobahri.tasklist.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

@SpringBootApplication
public class TaskListApiApplication {

    @Autowired
    private JwtFilter jwtFilter;

    public static void main(String[] args) {
        SpringApplication.run(TaskListApiApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> jwtFilter() {
        FilterRegistrationBean<OncePerRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
        registrationBean.addUrlPatterns("/api/*"); // Apply to your protected routes
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }
}
