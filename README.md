# classLoader
jvm自定义类加载器

在电脑D盘D:\tmp\com\tulingedu\classloader 下，添加java文件Demo.java

package com.tulingedu.classloader;

/**
 * Created by tykang on 2018-7-18.
 */
public class Demo {
    public static void main(String[] args) {

    }

    public Demo() {
        System.out.println("Demo," + this.getClass().getClassLoader());
    }
}

编译：javac Demo.java生成Demo.class文件

然后使用项目中的代码进行加载
