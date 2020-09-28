package com.zys.mybatisplusdemo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongyushi
 * @date 2020/9/16 0016
 * @dec 获取spring创建的工厂
 */
@Configuration
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    //把非spring创建好的工厂赋值给applicationContext，applicationContext在这个应用中是唯一的
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //此创建好工厂后再获取对象
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
