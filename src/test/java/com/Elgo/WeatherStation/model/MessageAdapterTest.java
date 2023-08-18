package com.Elgo.WeatherStation.model;

import com.Elgo.WeatherStation.service.ApiOperations.MessageAdapter;

class MessageAdapterTest {

    public static void main(String[] args) {
        MessageAdapter messageAdapter=MessageAdapter.getInstance();

        System.out.println(messageAdapter.createStationMessage(1L,"low",5L).toString());
    }

}