package Adapter;

import java.util.Objects;
import java.util.concurrent.Executors;

public class Weather {

    public static void main(String[] args) {

        USTensorSensor usTensorSensor=new USTensorSensor();

        SensorAdapter sensorAdapter=new SensorAdapter(usTensorSensor);
        Object obj=new Object();

        System.out.println(sensorAdapter.getTemperatureInCelsius());
    }
}
