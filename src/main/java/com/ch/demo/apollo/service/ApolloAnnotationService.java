package com.ch.demo.apollo.service;

import com.ch.demo.apollo.entity.JsonBean;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author @ch
 * @description TestApolloAnnotationService
 * @date 2020/8/26 11:27
 */
@Service
public class ApolloAnnotationService {

    @ApolloConfig
    private Config config;
    @ApolloConfig("abc.yml")
    private Config ymlConfig;

    /**
     * ApolloJsonValue annotated on fields example, the default value is specified as empty list - []
     * <br />
     * jsonBeanProperty=[{"someString":"hello","someInt":100},{"someString":"world!","someInt":200}]
     */
    @ApolloJsonValue("${jsonBeanProperty:[]}")
    private List<JsonBean> anotherJsonBeans;

    /**
     * 默认application的变化监听
     */
    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        //update injected value of batch if it is changed in Apollo
        if (changeEvent.isChanged("key1")) {
            String value1 = config.getProperty("key1", "value1");
            System.out.println("value1 = " + value1);

        }
    }

    /**
     * 多个namespace的监听
     *
     * @param changeEvent
     */
    @ApolloConfigChangeListener({"application", "abc.yml"})
    private void yetAnotherOnChange(ConfigChangeEvent changeEvent) {
        System.out.println("changeEvent = " + changeEvent);
    }

    public Object getConfigByApolloAnnotation() {
        List<Object> result = new ArrayList<Object>();
        result.add(anotherJsonBeans);
        result.add(config.getProperty("key1","default1"));
        result.add(ymlConfig.getProperty("firstKey.secondKey","default2"));
        return result;
    }

}
