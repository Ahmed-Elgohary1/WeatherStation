package com.Elgo.WeatherStation.model;

import net.minidev.json.JSONUtil;
import org.apache.avro.Schema;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ApiWeatherStatusGetterTest {

    public static int findInArray(String target, JSONArray array) throws JSONException {

        for (int i = 0; i < array.length(); i++) {
            if (array.getString(i).equals(target)) {
               return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws JSONException {
        /*ApiWeatherStatusGetter apiWeatherStatusGetter = new ApiWeatherStatusGetter();

        JSONObject jsonObject = apiWeatherStatusGetter.getApiResponse();
        WeatherMessageData weatherMessageData=new WeatherMessageData();

        Integer temp;
        Integer hum;
        Integer speed;


        temp= jsonObject.getJSONObject("current_weather").getInt("temperature");
        speed= jsonObject.getJSONObject("current_weather").getInt("windspeed");

        String timeStamp = jsonObject.getJSONObject("current_weather").getString("time");
        JSONArray allHours = jsonObject.getJSONObject("hourly").getJSONArray("time");
        int timeIndex = findInArray(timeStamp,allHours);
        hum=jsonObject.getJSONObject("hourly").getJSONArray("relativehumidity_2m").getInt(timeIndex);


        weatherMessageData.setTemperature(temp);
        weatherMessageData.setHumidity(hum);
        weatherMessageData.setWind_speed(speed);

WeatherStationMessage weatherStationMessage=new WeatherStationMessage();
weatherStationMessage.setStation_id(1L);
weatherStationMessage.setBattery_status("low");
weatherStationMessage.setS_no(5L);
weatherStationMessage.setWeatherMessageData(weatherMessageData);

        System.out.println(
                weatherStationMessage
        );*/



    }



}