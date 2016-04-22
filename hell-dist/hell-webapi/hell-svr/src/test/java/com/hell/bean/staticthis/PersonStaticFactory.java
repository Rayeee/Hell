package com.hell.bean.staticthis;

import com.hell.bean.Person;

/**
 * Created by Rayee on 16/4/22.
 */
public class PersonStaticFactory {

    public static Person create(){
        return new Person();
    }

    public static Person create(String name){
        return new Person("jack");
    }


}
