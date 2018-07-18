package com.tulingedu.classloader;

import java.io.*;

/**
 * Created by tykang on 2018-7-18.
 */
public class MyClassLoader extends ClassLoader {

    private String path;//类加载类的路径
    private String name;//类加载器的名称

    public MyClassLoader(String name, String path) {
        super();//让系统类加载器成为该类的父加载器
        this.name = name;
        this.path = path;
    }

    public MyClassLoader(ClassLoader parent, String name, String path) {
        super(parent);//显式指定父加载器
        this.name = name;
        this.path = path;
    }


    /**
     * 加载我们自己定义的类，通过我们自定义的这个ClassLoader
     * com.tulingedu.classloader.Demo
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] date = readClassFileToByteArry(name);
        return this.defineClass(name, date, 0, date.length);
    }

    /**
     * 获取.class文件的字节数组
     * com.tulingedu.classloaderDemo
     * E:/temp/com/tulingedu/classloader/Demo.class
     *
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArry(String name) {
        InputStream is = null;
        byte[] returnData = null;

        name = name.replaceAll("\\.", "/");

        String filePath = this.path + name + ".class";
        File file = new File(filePath);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(file);
            int tmp = 0;
            while ((tmp = is.read()) != -1) {
                os.write(tmp);
            }
            returnData = os.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return returnData;
    }

    @Override
    public String toString() {
        return "MyClassLoader{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
