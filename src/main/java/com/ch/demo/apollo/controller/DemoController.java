package com.ch.demo.apollo.controller;

import com.ch.demo.apollo.service.DemoService;
import com.ch.demo.apollo.service.ApolloAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author @ch
 * @description DemoController
 * @date 2020/8/25 15:12
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private ApolloAnnotationService apolloAnnotationService;

    @RequestMapping("getConfigBySpring")
    public Object getConfigBySpring() {
        return demoService.getConfigBySpring();
    }

    @RequestMapping("getConfigByApolloApi")
    public Object getConfigByApolloApi() {
        return demoService.getConfigByApolloApi();
    }

    @RequestMapping("getConfigByApolloAnnotation")
    public Object getConfigByApolloAnnotation() {
        return apolloAnnotationService.getConfigByApolloAnnotation();
    }


}
