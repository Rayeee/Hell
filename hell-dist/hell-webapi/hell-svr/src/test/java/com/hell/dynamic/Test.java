package com.hell.dynamic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rayee on 16/12/18.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        InputStream input = new FileInputStream(file.getCanonicalPath() + "/hell-dist/hell-webapi/hell-svr/target/test-classes/com/hell/dynamic/Person.class");
        byte[] result = new byte[10240];
        int count = input.read(result);
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.defineMyClass(result, 0, count);
        System.out.println(clazz);
        try {
            Object object = clazz.newInstance();
            clazz.getMethod("speak", String.class, Integer.class).invoke(object, "something", 2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
