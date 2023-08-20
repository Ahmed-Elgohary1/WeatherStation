package com.Elgo.WeatherStation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.avro.Schema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.time.Instant;

import java.util.Arrays;

@Data
public class WeatherStationMessage implements Serializable {

   private Long station_id;
   private Long s_no;
   private String battery_status;
   private Long status_timestamp;

   private WeatherMessageData weatherMessageData;



   public String toJson() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      mapper.addMixIn(WeatherStationMessage.class, ExcludeAvroSchemaMixin.class); // exclude the Avro schema field
      return mapper.writeValueAsString(this);
   }

   private abstract static class ExcludeAvroSchemaMixin {
      @JsonIgnore
      private Object weatherStationMessageAvroSchema;
   }
   /*
   public  Schema getWeatherStationMessageAvroSchema() {

      Schema schema = Schema.createRecord("WeatherStationMessage", null, null, false);
      schema.setFields(Arrays.asList(
              new Schema.Field("station_id", Schema.create(Schema.Type.LONG), null, null),
              new Schema.Field("s_no", Schema.create(Schema.Type.LONG), null, null),
              new Schema.Field("battery_status", Schema.create(Schema.Type.STRING), null, null),
              new Schema.Field("status_timestamp", Schema.create(Schema.Type.LONG), null, null),
              new Schema.Field("weatherMessageData", WeatherMessageData.getWeatherMessageDataAvroSchema(), null, null)
      ));
      return schema;
   }

    */
}
