package com.ch.demo.apollo.listener;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author @ch
 * @description ApolloListener
 * @date 2020/8/25 16:18
 */
@Component
public class ApolloListener {

//    @PostConstruct
//    public void addListener() {
//        System.out.println("初始化apollo的配置变化监听器");
//        // ConfigService里面用了一个单例的内部变量
//        Config config = ConfigService.getAppConfig();
//        config.addChangeListener(new ConfigChangeListener() {
//            @Override
//            public void onChange(ConfigChangeEvent changeEvent) {
//                System.out.println("Changes for namespace " + changeEvent.getNamespace());
//                for (String key : changeEvent.changedKeys()) {
//                    ConfigChange change = changeEvent.getChange(key);
//                    System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
//                }
//            }
//        });
//    }


}
