package com.nme.filter;

/**
 * Created by chakrabhandari on 22/04/2017.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

//public class BearerTokenFilter implements Filter {

public class BearerTokenFilter {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /*@Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("#### request = " + servletRequest.getRemoteHost());

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                System.out.println("Header: " + httpRequest.getHeader(headerNames.nextElement()));
            }
        }

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", String.format("%s %s", "Bearer ", httpRequest.getHeader("Authorization") ));
        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result = restTemplate.exchange(
                "https://obscure-fjord-89635.herokuapp.com/api/secure",
                HttpMethod.GET, null, String.class);

        System.out.println("#### get response = " + result);

        log.info("#### get response = " + result);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }*/
}