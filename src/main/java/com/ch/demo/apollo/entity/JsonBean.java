package com.ch.demo.apollo.entity;

import java.io.Serializable;

/**
 * @author @ch
 * @description JsonBean
 * @date 2020/8/26 11:38
 */
public class JsonBean {
    private String someString;
    private int someInt;

    public String getSomeString() {
        return someString;
    }

    public void setSomeString(String someString) {
        this.someString = someString;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }
}
