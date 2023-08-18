package com.Elgo.WeatherStation.model.RecordFactory;

import com.Elgo.WeatherStation.service.ApiOperations.MessageAdapter;
import com.Elgo.WeatherStation.model.WeatherStationMessage;
import com.Elgo.WeatherStation.service.EncoderMangment.RecordFactory.AvroEncoder;
import org.junit.jupiter.api.Test;

class AvroEncoderTest {


    public static void main(String[] args) {

    }

    @Test
    void createEncodedRecord() {
        MessageAdapter messageAdapter=MessageAdapter.getInstance();
        WeatherStationMessage weatherStationMessage=messageAdapter.createStationMessage(1L,"Low",5L);

        AvroEncoder avroEncoder=new AvroEncoder();

        System.out.println("Elgo is on the Go \n"+avroEncoder.createEncodedRecord(weatherStationMessage));

    }
}