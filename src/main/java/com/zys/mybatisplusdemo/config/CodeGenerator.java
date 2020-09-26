package com.zys.mybatisplusdemo.config;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    public static void main(String[] args) {
        generator();
    }

    public static void generator() {
        // 代码生成器
        AutoGenerator map = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //配置生成文件的输出目录
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        //设置开发人员名称
        globalConfig.setAuthor("yushizhong");
        //是否打开输出目录
        globalConfig.setOpen(false);
        //mapper 命名方式
        globalConfig.setMapperName("%sDao");
        //service 命名方式
        globalConfig.setServiceName("%sService");
        map.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库的路径
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatisplus?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=CTT");
        //数据库驱动名称
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        //数据库的登录用户名
        dataSourceConfig.setUsername("root");
        //数据库的登录密码
        dataSourceConfig.setPassword("zys123456");
        map.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //设置父包名
        pc.setParent("com.zys.mybatisplusdemo");
        pc.setMapper("dao");
        map.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //设置xml的输出路径
                return System.getProperty("user.dir") + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        map.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        //在代码总不生成xml
        templateConfig.setXml(null);
        map.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略:把下划线变成大写
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略:把下划线变成大写
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否使用lombok
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        //表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");
        map.setStrategy(strategy);

        //执行
        map.execute();
    }


}
