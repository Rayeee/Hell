package com.hell.dynamic;

import com.hell.dynamic.impl.Station;
import com.hell.dynamic.proxy.StationProxy;

/**
 * Created by Rayee on 16/12/18.
 */
public class Mainer {

    private static StationProxy stationProxy = new StationProxy(new Station());

    public static void main(String[] args) throws Throwable {
        stationProxy.sellTicket();
        stationProxy.inquire();
        stationProxy.withdraw();
    }

}
