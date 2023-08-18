package com.Elgo.WeatherStation.service.EncoderMangment;

import com.Elgo.WeatherStation.service.ApiOperations.MessageAdapter;


public class RecordManager {

 public MessageAdapter messageAdapter=MessageAdapter.getInstance();

/*
    private static GenericRecord createAvroRecord(WeatherStationMessage weatherStationMessage){
        GenericRecord avroRecord =setRecordConfig();


       return avroRecord;
    }
    public ProducerRecord<Object, Object> createProducerRecord(WeatherStationMessage weatherStationMessage){

    }

    private static GenericRecord setRecordConfig(){
        Schema schema=getAvroSchema();
        GenericRecord avroRecord = new GenericData.Record(schema);
        return avroRecord;
    }

 */
}
