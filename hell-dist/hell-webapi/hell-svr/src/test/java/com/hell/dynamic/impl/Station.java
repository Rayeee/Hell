package com.hell.dynamic.impl;

import com.hell.dynamic.api.TicketService;

/**
 * Created by Rayee on 16/12/18.
 */
public class Station implements TicketService{

    @Override
    public void sellTicket() {
        System.out.println("售票。。。");
    }

    @Override
    public void inquire() {
        System.out.println("问询。。。");
    }

    @Override
    public void withdraw() {
        System.out.println("退票。。。");
    }

}
