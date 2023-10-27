package com.mbb.mbg;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "code-generator")
public class CodeGeneratorProperties {
    private String parent;
    private String author;
    private String moduleName;
    private String controllerName;
    private String serviceName;
    private String serviceImplName;
    private String entityName;
    private String mapperName;
    private String formatEntity;
    private String formatService;
    private String formatServiceImpl;
    private String date;
    private String codeDir;
    private String mapperXmlPath;
    private String tables;
    private Boolean enableSwagger;

}
