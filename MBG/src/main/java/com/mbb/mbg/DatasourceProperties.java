package com.mbb.mbg;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * spring:
 * application:
 * name: walker-dianping
 * datasource:
 * driver-class-name: com.mysql.cj.jdbc.Driver
 * url: jdbc:mysql://114.132.164.230:3306/walker-dianping?serverTimezone=UTC
 * username: root
 * password: walker123
 */
@Component
@Data
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

}
