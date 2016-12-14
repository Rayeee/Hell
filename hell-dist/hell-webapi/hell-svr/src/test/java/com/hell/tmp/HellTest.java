package com.hell.tmp;

import winter.hell.auth.dto.UserInfoDto;
import winter.hell.util.JsonGHelper;

/**
 * Created by Rayee on 16/12/6.
 */
public class HellTest extends BaseTest<String>{

    @Override
    protected Integer validate(UserInfoDto dto) {
        System.out.println("HellTest");
        return super.validate(dto);

    }

    @Override
    protected void build(String param) {
        System.out.println("hell ----- " + JsonGHelper.serialize(param));
    }
}
