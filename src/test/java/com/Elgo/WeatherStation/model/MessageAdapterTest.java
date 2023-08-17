package com.Elgo.WeatherStation.model;

import static org.junit.jupiter.api.Assertions.*;

class MessageAdapterTest {

    public static void main(String[] args) {
        MessageAdapter messageAdapter=MessageAdapter.getInstance();

        System.out.println(messageAdapter.createStationMessage(1L,"low",5L).toString());
    }

}