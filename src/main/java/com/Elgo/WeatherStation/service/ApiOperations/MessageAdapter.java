package com.Elgo.WeatherStation.service.ApiOperations;

import com.Elgo.WeatherStation.model.WeatherMessageData;
import com.Elgo.WeatherStation.model.WeatherStationMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageAdapter {

    private static MessageAdapter instance;

    private MessageAdapter() { }

    public static MessageAdapter getInstance() {
        if (instance == null) {
            synchronized (MessageAdapter.class) {
                if (instance == null) {
                    instance = new MessageAdapter();
                }
            }
        }
        return instance;
    }


    public WeatherStationMessage createStationMessage(Long Station_id, String Battery_status, Long S_no){

        ApiWeatherStatusGetter apiWeatherStatusGetter = ApiWeatherStatusGetter.getInstance();

        JSONObject jsonObject = apiWeatherStatusGetter.getApiResponse();
        WeatherMessageData weatherMessageData=new WeatherMessageData();


        Integer temp;
        Integer hum;
        Integer speed;


        temp= jsonObject.getJSONObject("current_weather").getInt("temperature");
        speed= jsonObject.getJSONObject("current_weather").getInt("windspeed");

        Integer timeStamp = jsonObject.getJSONObject("current_weather").getInt("time");
        JSONArray allHours = jsonObject.getJSONObject("hourly").getJSONArray("time");
        int timeIndex = findInArray(timeStamp,allHours);
        hum=jsonObject.getJSONObject("hourly").getJSONArray("relativehumidity_2m").getInt(timeIndex);


        weatherMessageData.setTemperature(temp);
        weatherMessageData.setHumidity(hum);
        weatherMessageData.setWind_speed(speed);


        WeatherStationMessage weatherStationMessage=new WeatherStationMessage();
        weatherStationMessage.setStation_id(Station_id);
        weatherStationMessage.setBattery_status(Battery_status);
        weatherStationMessage.setS_no(S_no);
        weatherStationMessage.setStatus_timestamp(Long.valueOf(timeStamp));
        weatherStationMessage.setWeatherMessageData(weatherMessageData);

    return weatherStationMessage;
    }


    public static int findInArray(Integer target, JSONArray array) throws JSONException {

        for (int i = 0; i < array.length(); i++)
            if (array.getNumber(i).equals(target))
                return i;

        return -1;
    }


}
