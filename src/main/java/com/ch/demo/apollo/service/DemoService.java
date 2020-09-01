package com.ch.demo.apollo.service;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author @ch
 * @description DemoService
 * @date 2020/8/25 15:46
 */
@Service
public class DemoService {

    @Value("${key1}")
    private String key1;

    @Value("${chTest.myNamespace.key1:localValue1}")
    private String myNamespaceKey1;



    public Object getConfigBySpring() {
        List<String> result = new ArrayList<String>();
        result.add("key1 = " + key1);
        result.add("myNamespaceKey1 = " + myNamespaceKey1);
        System.out.println("result = " + result);
        return result;
    }

    public Object getConfigByApolloApi() {
        List<String> result = new ArrayList<String>();
        String someKey = "jsonBeanProperty";
        String someDefaultValue = "defaultValue1";

        // 默认的namespace - application
        Config config = ConfigService.getAppConfig();
        String value = config.getProperty(someKey, someDefaultValue);
        String appResult = String.format("appConfig[%s - %s]", someKey, value);
        System.out.println(appResult);
        result.add(appResult);

        // 自定义的namespace
        Config myNamespaceConfig = ConfigService.getConfig("chTest.myNamespace");
        String myNamespaceConfigProperty = myNamespaceConfig.getProperty(someKey, someDefaultValue);
        String myNamespceResult = String.format("myNamespceResult[%s - %s]", someKey, myNamespaceConfigProperty);
        System.out.println(myNamespceResult);
        result.add(myNamespceResult);

        // yml类型的数据，从1.3.0版本开始友好支持，包括xml等也是支持的
        Config ymlConfig = ConfigService.getConfig("abc.yml");
        String ymlKey = "firstKey.secondKey";
        String ymlConfigProperty = ymlConfig.getProperty(ymlKey, someDefaultValue);
        String ymlResult = String.format("ymlResult[%s - %s]", ymlKey, ymlConfigProperty);
        System.out.println(ymlResult);
        result.add(ymlResult);

        return result;
    }

}
