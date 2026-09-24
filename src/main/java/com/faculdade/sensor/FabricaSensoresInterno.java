package com.faculdade.sensor;

/**
 * Concrete Factory: monta o kit de sensores completo da família
 * <b>Interno</b> — garante que o sensor de temperatura e o sensor de
 * pressão entregues são sempre compatíveis entre si (ambos pensados
 * para ambientes climatizados/controlados da planta).
 */
public class FabricaSensoresInterno implements FabricaSensores {

    @Override
    public SensorTemperatura criarSensorTemperatura() {
        return new SensorTemperaturaInterno();
    }

    @Override
    public SensorPressao criarSensorPressao() {
        return new SensorPressaoInterno();
    }
}
