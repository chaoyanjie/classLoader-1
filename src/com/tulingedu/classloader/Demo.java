package com.tulingedu.classloader;

/**
 * Created by tykang on 2018-7-17.
 */
public class Demo {

    public Demo() {
        System.out.println("A demo" + this.getClass().getClassLoader());
    }
}
