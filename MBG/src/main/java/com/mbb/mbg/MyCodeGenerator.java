package com.mbb.mbg;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

import java.util.Collections;

@Service
public class MyCodeGenerator {


    @Autowired
    private DatasourceProperties datasourceProperties;
    @Autowired
    private CodeGeneratorProperties codeGeneratorProperties;

    /**
     * 根据表名生成对应的实体类
     * tableName:表的名称,使用“，”分隔，如"a,b,c"
     */
    public void generateCode() {
        System.out.println(datasourceProperties);
        System.out.println(codeGeneratorProperties);
        // 数据源配置
        FastAutoGenerator.create(datasourceProperties.getUrl(), datasourceProperties.getUsername(), datasourceProperties.getPassword())
                .globalConfig(builder -> {
                    builder.author(codeGeneratorProperties.getAuthor())        // 设置作者
                            .commentDate(codeGeneratorProperties.getDate()) // 注释日期
                            .outputDir(System.getProperty("user.dir") + codeGeneratorProperties.getCodeDir()); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder.parent(codeGeneratorProperties.getParent()) // 父包模块名
                            .controller(codeGeneratorProperties.getControllerName())   //Controller 包名 默认值:controller
                            .entity(codeGeneratorProperties.getEntityName())           //Entity 包名 默认值:entity
                            .service(codeGeneratorProperties.getServiceName())         //Service 包名 默认值:service
                            .mapper(codeGeneratorProperties.getMapperName())           //Mapper 包名 默认值:mapper
                            //.moduleName("xxx")        // 设置父包模块名 默认值:无
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + codeGeneratorProperties.getMapperXmlPath())); // 设置mapperXml生成路径
                    //默认存放在mapper的xml下
                })

//                .injectionConfig(consumer -> {
//                    HashMap<String, String> customFile = new HashMap<>();
//                    // DTO、VO
//                    customFile.put("DTO.java", "/templates/entityDTO.java.ftl");
//                    customFile.put("VO.java", "/templates/entityVO.java.ftl");
//
//                    consumer.customFile(customFile);
//                })

                .strategyConfig(builder -> {
                    builder
                            .addInclude(codeGeneratorProperties.getTables()) // 设置需要生成的表名 "a,b,c"
//                            .addTablePrefix("tb_", "gms_") // 设置过滤表前缀
                            .serviceBuilder()//service策略配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()// 实体类策略配置
//                            .idType(IdType.ASSIGN_ID)//主键策略  雪花算法自动生成的id
//                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 自动填充配置
//                            .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                            .enableLombok() //开启lombok
                            .logicDeleteColumnName("deleted")// 说明逻辑删除是哪个字段
                            .enableTableFieldAnnotation()// 属性加上注解说明
                            .controllerBuilder() //controller 策略配置
                            .formatFileName("%sController")
                            .enableRestStyle() // 开启RestController注解
                            .mapperBuilder()// mapper策略配置
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()//@mapper注解开启
                            .formatXmlFileName("%sMapper")
                            .enableFileOverride();
                })


                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
//                .templateEngine(new EnhanceFreemarkerTemplateEngine())
                .execute();
    }


}
