package com.tulingedu.classloader;

/**
 * Created by tykang on 2018-7-18.
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
       // MyClassLoader zhangFeiloader = new MyClassLoader("ZhangFei", "D:/tmp/");
//        MyClassLoader wuKongloader = new MyClassLoader(zhangFeiloader, "WuKong", "D:/tmp/");
        //null，即使用BootStrap ClassLoader
        MyClassLoader wuKongloader = new MyClassLoader(null, "WuKong", "D:/tmp/");

        Class c = wuKongloader.loadClass("com.tulingedu.classloader.Demo");
        c.newInstance();


    }

}

