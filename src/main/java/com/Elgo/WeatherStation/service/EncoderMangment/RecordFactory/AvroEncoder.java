package com.Elgo.WeatherStation.service.EncoderMangment.RecordFactory;

import com.Elgo.WeatherStation.model.WeatherMessageData;
import com.Elgo.WeatherStation.model.WeatherStationMessage;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;


public class AvroEncoder implements MessageRecordConverter{
    @Override
    public GenericRecord createEncodedRecord(WeatherStationMessage weatherStationMessage) {

        GenericRecord avroStationRecord =setRecordConfig(weatherStationMessage.getWeatherStationMessageAvroSchema());

        avroStationRecord.put("station_id",weatherStationMessage.getStation_id());
        avroStationRecord.put("s_no",weatherStationMessage.getS_no());
        avroStationRecord.put("battery_status",weatherStationMessage.getBattery_status());
        avroStationRecord.put("status_timestamp",weatherStationMessage.getStatus_timestamp());


        WeatherMessageData weatherMessageData=weatherStationMessage.getWeatherMessageData();

        GenericRecord avroDataRecord=setRecordConfig(  weatherMessageData
                                                        .getWeatherMessageDataAvroSchema());

        avroDataRecord.put("temperature",weatherMessageData.getTemperature());
        avroDataRecord.put("humidity",weatherMessageData.getHumidity());
        avroDataRecord.put("wind_speed",weatherMessageData.getWind_speed());


        avroStationRecord.put("weatherMessageData",avroDataRecord);

     return avroStationRecord;
    }



    private static GenericRecord setRecordConfig(Schema schema){

        GenericRecord avroRecord = new GenericData.Record(schema);
        return avroRecord;
    }

}
