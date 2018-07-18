package com.tulingedu.classloader;

/**
 * Created by tykang on 2018-7-18.
 */
public class Demo2 {
    public static void main(String[] args) {
        System.out.println(Demo2.class.getClassLoader());
        ClassLoader loader = (Demo2.class.getClassLoader());

        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);

    }
}
