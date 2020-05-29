package com.ai.ge.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value=1)
public class ConfigDataInitRunner implements CommandLineRunner {

    protected Logger logger = LoggerFactory.getLogger(ConfigDataInitRunner.class);

//    @Resource
//    private SsoAuthorizationService ssoAuthorizationService;

    @Override
    public void run(String... strings) throws Exception {

        logger.info(">>>>>>>>>>>>>>>服务启动，加载配置数据开始  <<<<<<<<<<<<<");
        //加载应用授权信息
//        ssoAuthorizationService.loadAppAuthorize();
        logger.info(">>>>>>>>>>>>>>>服务启动，加载配置数据结束  <<<<<<<<<<<<<");
    }
}
