package Adapter;

public class SensorAdapter implements Sensor{

private USTensorSensor usTensorSensor;

    public SensorAdapter(USTensorSensor usTensorSensor) {
        this.usTensorSensor = usTensorSensor;
    }

    @Override
    public Double getTemperatureInCelsius() {
        return usTensorSensor.getTemperature()+10;
    }
}
