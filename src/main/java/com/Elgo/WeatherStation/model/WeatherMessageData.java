package com.Elgo.WeatherStation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.avro.Schema;

import java.util.Arrays;

@Data

public class WeatherMessageData {
    private   Integer humidity;
    private   Integer temperature;
    private   Integer wind_speed;

    public static Schema getAvroSchema() {
        Schema schema = Schema.createRecord("WeatherMessageData", null, null, false);
        schema.setFields(Arrays.asList(
                new Schema.Field("temperature", Schema.create(Schema.Type.INT), null, null),
                new Schema.Field("humidity", Schema.create(Schema.Type.INT), null, null),
                new Schema.Field("wind_speed", Schema.create(Schema.Type.INT), null, null)
        ));
        return schema;
    }
}
