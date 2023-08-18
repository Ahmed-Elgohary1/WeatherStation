package com.Elgo.WeatherStation.service.EncoderMangment.RecordFactory;

import com.Elgo.WeatherStation.model.WeatherStationMessage;
import org.apache.avro.generic.GenericRecord;

public interface MessageRecordConverter {

   GenericRecord createEncodedRecord(WeatherStationMessage weatherStationMessage);
}
