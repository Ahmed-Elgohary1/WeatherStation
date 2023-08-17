package com.Elgo.WeatherStation;

import com.Elgo.WeatherStation.model.MessageAdapter;
import com.Elgo.WeatherStation.model.WeatherStationMessage;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.retrytopic.DestinationTopic;

import java.util.Properties;

import static com.Elgo.WeatherStation.model.WeatherStationMessage.getAvroSchema;


public class WeatherStationApplication {


	private static Properties getKafkaProducerProps(){
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		// the producer will receive a success response from the broker the
		//moment the leader replica received the message.
		props.put("acks", "1");
		//After receiving an error message from the server
		// how many times the producer will retry sending the message
		//before giving up
		props.put("retries", 1);
		//amount of memory in bytes (not messages!)
		//that will be used for each batch.
		props.put("batch.size", 16384);
		//Producer sends a batch of messages either when the current
		// batch is full or when the linger.ms limit is reached.
		props.put("linger.ms", 1);
		//memory the producer will use to buffer "messages" waiting to
		//be sent to brokers.
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		return props;
	}

	private static GenericRecord setRecordConfig(){
		Schema schema=getAvroSchema();
		GenericRecord avroRecord = new GenericData.Record(schema);
		return avroRecord;
	}

	public static void main(String[] args) {

	// Set Kafka producer properties
		Properties properties=getKafkaProducerProps();
		// Create a Kafka producer
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

		MessageAdapter messageAdapter=MessageAdapter.getInstance();

		// Send messages
		for (int i = 0; i < 10; i++) {


			WeatherStationMessage weatherStationMessage=messageAdapter.createStationMessage(1L,"Low",5L);
			producer.send(new ProducerRecord<String, String>("my-topic", weatherStationMessage.toString()));
		}

		// Close the producer
		producer.close();
	}

	}


