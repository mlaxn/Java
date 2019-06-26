package com.mlaxn;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.filter.OrderedFilter;

import com.mlaxn.model.LogBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootRestMvc1Application {
	
	//@Slf4j does the same thing in the background using the lombort
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringBootRestMvc1Application.class);
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestMvc1Application.class, args);
		System.out.println("Hey Boot the Rest ..... !!!");	
	}
	
	
	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> executionTimeLoggingFilter() {
	  return new FilterRegistrationBean<OncePerRequestFilter>() {{
		  addUrlPatterns("/emp/*");
	  setOrder(OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER);
	  setFilter(new OncePerRequestFilter() {
		  

	    @Override
	    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
	    FilterChain chain) throws ServletException, IOException {
	    	
	        StopWatch watch = new StopWatch();
	        watch.start();
	        try {
	          chain.doFilter(req, res);
	        }finally {
	          watch.stop();
	          log.info("REQUEST: {} completed within {} ms",
	                  getUriWithMethodAndQuery(req), watch.getTotalTimeMillis());
	        }
	      }

	      private String getUriWithMethodAndQuery(HttpServletRequest req) {
	        return req.getMethod() + ": " + req.getRequestURI() +
	         (StringUtils.hasText(req.getQueryString()) ? "?" + req.getQueryString() : "");
	        
	      }

		
	    });
	  }};
	}
}


