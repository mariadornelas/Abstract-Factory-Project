package com.faculdade.sensor;

public class FabricaSensoresExterno implements FabricaSensores {

    @Override
    public SensorTemperatura criarSensorTemperatura() {
        return new SensorTemperaturaExterno();
    }

    @Override
    public SensorPressao criarSensorPressao() {
        return new SensorPressaoExterno();
    }
}
