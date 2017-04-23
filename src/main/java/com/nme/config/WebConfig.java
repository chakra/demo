package com.nme.config;


import com.nme.filter.BearerTokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chakrabhandari on 22/04/2017.
 */
//@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean greetingFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("greeting");
        BearerTokenFilter greetingFilter = new BearerTokenFilter();
        //registrationBean.setFilter(greetingFilter);
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
