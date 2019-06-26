package com.mlaxn.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogBean {
    Logger logger = LoggerFactory.getLogger(LogBean.class);

    public void doSomething() {
        logger.info("Logger Check .....");
    }
}