package com.mbb.mbg;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.entity.BaseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class MbgApplicationTests {

	@Test
	void contextLoads() {
		FastAutoGenerator.create("jdbc:mysql://192.168.86.26:12306/dev", "dev", "$%^s=pIlI$%TGT#$GR#$R$CFscfds")
				.globalConfig(builder -> {
					builder.author("moubenben") // 设置作者
							.enableSwagger() // 开启 swagger 模式
							.commentDate("2023-10-27")
							.outputDir("/home/ming/Desktop/work/Project/mybatis_generator/MBG/out"); // 指定输出目录
				})
				.packageConfig(builder -> {
					builder.parent("com.mbb") // 设置父包名
							.pathInfo(Collections.singletonMap(OutputFile.xml, "/home/ming/Desktop/work/Project/mybatis_generator/MBG/out/xml")); // 设置mapperXml生成路径
				})
				.strategyConfig(builder -> {
					builder.entityBuilder()
							.superClass(BaseEntity.class)
							.enableChainModel()
							.enableLombok()
							.enableTableFieldAnnotation()
							.enableActiveRecord()
							.enableFileOverride()
							.addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
							.formatFileName("%sEntity");
				})
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();
	}

}
