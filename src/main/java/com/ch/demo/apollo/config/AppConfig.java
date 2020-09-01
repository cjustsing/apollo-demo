package com.ch.demo.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author @ch
 * @description AppConfig
 * @date 2020/8/25 17:08
 */
@Configuration
@EnableApolloConfig({"application","chTest.myNamespace"})
public class AppConfig {

}
