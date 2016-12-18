package com.hell.dynamic;

/**
 * Created by Rayee on 16/12/18.
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] b, int off, int len){
        return super.defineClass(b, off, len);
    }

}
