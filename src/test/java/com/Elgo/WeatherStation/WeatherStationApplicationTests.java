package com.Elgo.WeatherStation;

import com.Elgo.WeatherStation.model.WeatherMessageData;
import org.apache.avro.Schema;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class WeatherStationApplicationTests {
	public static String getAvroSchemaString() {
		Schema schema = Schema.createRecord("WeatherStationMessage", "com.example.avro", null, false);
		schema.setFields(Arrays.asList(
				new Schema.Field("station_id", Schema.create(Schema.Type.LONG), null, null),
				new Schema.Field("s_no", Schema.create(Schema.Type.LONG), null, null),
				new Schema.Field("battery_status", Schema.create(Schema.Type.STRING), null, null),
				new Schema.Field("status_timestamp", Schema.create(Schema.Type.LONG), null, null),
				new Schema.Field("weatherMessageData", WeatherMessageData.getWeatherMessageDataAvroSchema(), null, null)
		));
		return schema.toString();
	}
	@Test
	void contextLoads() {

		System.out.println(getAvroSchemaString());
	}

}
