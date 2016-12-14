package com.hell.tmp;

import winter.hell.auth.dto.UserInfoDto;

/**
 * Created by Rayee on 16/12/6.
 */
public abstract class BaseTest<T> {

    protected abstract void build(T param);

    protected Integer validate(UserInfoDto dto){
        return 0;
    }

    public void doTest(T param){
        build(param);
        validate(new UserInfoDto("13862896586"));
    }

    String test(){
        return "";
    }

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("{}调用【{}】\n参数为【{}】\n");
        System.out.println(BaseTest.class.getDeclaredMethods()[1]);
    }

    static class DefaultValue{
        public static Object getDefaultValue(Class<?> clazz) {
            if (clazz.equals(boolean.class)) {
                return false;
            } else if (clazz.equals(char.class)) {
                return '\u0000';
            } else if (clazz.equals(byte.class)) {
                return 0;
            } else if (clazz.equals(short.class)) {
                return 0;
            } else if (clazz.equals(int.class)) {
                return 0;
            } else if (clazz.equals(long.class)) {
                return 0l;
            } else if (clazz.equals(float.class)) {
                return 0.0f;
            } else if (clazz.equals(double.class)) {
                return 0.0d;
            } else {
                return null;
            }
        }
    }

}
