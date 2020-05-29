package com.ai.ge.auth;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;
import java.util.ArrayList;

public class CodeGenerator {

    public static void main(String[] args) throws SQLException {
        generate(new String[]{"picture"});


    }

    private static void generate(String[] tables) {
        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) // 是否支持AR模式
                .setAuthor("wangshen") // 作者
                .setOutputDir("D:\\TEST") // 生成路径
                //.setOutputDir("/Users/mx/Downloads/work/code/工作助手/黑龙江/sso/sso-code-generator/src/main/java") // 生成路径
                .setFileOverride(true)  // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                // IEmployeeService
                .setBaseResultMap(true)//生成基本的resultMap
                .setBaseColumnList(true);//生成基本的SQL片段

        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        dsConfig.setDbType(DbType.ORACLE)  // 设置数据库类型
                .setDriverName("oracle.jdbc.driver.OracleDriver")
//                .setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.200.31)(PORT=1521)))(CONNECT_DATA=(SERVER=DEDICATED)(SID=mx)))")
//                .setUsername("mx_gw")
//                .setPassword("meixiao");
                .setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=127.0.0.1)(PORT=3306)))(CONNECT_DATA=(SERVICE_NAME=crm4)))")
                .setUsername("root")
                .setPassword("123456");
        //3. 策略配置globalConfiguration中
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
//                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                //.setTablePrefix("tbl_")
//                .setSuperControllerClass("com.ai.ge.auth.controller.BaseController")
                .setInclude(tables);  // 生成的表

        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.ai.ge")
                .setMapper("mapper.core.log")//dao
                .setService("service.core.log")//servcie
                .setServiceImpl("service.core.impl.log")
                .setController("controller.core.log")//controller
                .setEntity("entity.core.log")
                .setXml("mapper.core.log");//mapper.xml

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }

}
