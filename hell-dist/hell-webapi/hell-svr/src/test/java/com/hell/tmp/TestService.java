package com.hell.tmp;

import winter.hell.auth.dto.UserInfoDto;

/**
 * Created by Rayee on 16/12/6.
 */
public class TestService {

    static HellTest hellTest = new HellTest();

    public static Integer test(){
        return hellTest.validate(new UserInfoDto("1111111"));
    }

    public static void main(String[] args) {
        System.out.println(test());
    }

}
