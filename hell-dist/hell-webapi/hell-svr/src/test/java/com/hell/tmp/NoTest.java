package com.hell.tmp;

import winter.hell.auth.dto.UserInfoDto;
import winter.hell.util.JsonGHelper;

/**
 * Created by Rayee on 16/12/6.
 */
public class NoTest extends BaseTest<Integer>{

    @Override
    protected Integer validate(UserInfoDto dto) {
        System.out.println("NoTest");
        return 2;
    }

    @Override
    protected void build(Integer param) {
        System.out.println("no -----" + JsonGHelper.serialize(param));
    }
}
