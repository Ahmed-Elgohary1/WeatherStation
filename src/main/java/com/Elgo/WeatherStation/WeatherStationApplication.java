package com.Elgo.WeatherStation;

import com.Elgo.WeatherStation.service.ApiOperations.MessageAdapter;
import com.Elgo.WeatherStation.model.WeatherStationMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;



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

		/*
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				org.apache.kafka.common.serialization.StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroSerializer.class);
		props.put("schema.registry.url", "http://localhost:8081");
		 */

		return props;
	}



	public static void main(String[] args) throws JsonProcessingException {

	// Set Kafka producer properties
		Properties properties=getKafkaProducerProps();


		// Create a Kafka producer
		KafkaProducer producer = new KafkaProducer(properties);

		MessageAdapter messageAdapter=MessageAdapter.getInstance();

		ObjectMapper mapper = new ObjectMapper();

		// Send messages
		for (int i = 0; i < 1; i++) {


			WeatherStationMessage weatherStationMessage=messageAdapter.createStationMessage(1L,"Low",5L);
           /*
			AvroEncoder avroEncoder=new AvroEncoder();
			GenericRecord avroRecord= avroEncoder.createEncodedRecord(weatherStationMessage);
			ProducerRecord<Object, Object> record = new ProducerRecord<>("my-topic", avroRecord);

			producer.send(record);
			*/

			System.out.println(weatherStationMessage.toJson());

			producer.send(new ProducerRecord<String, String>("my-topic", weatherStationMessage.toJson()));


		}

		// Close the producer
		producer.close();
	}

	}


