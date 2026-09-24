package com.faculdade.sensor;

/**
 * Concrete Factory: monta o kit de sensores completo da família
 * <b>Externo</b> — garante que o sensor de temperatura e o sensor de
 * pressão entregues são sempre compatíveis entre si (ambos projetados
 * para suportar exposição às intempéries da planta).
 */
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
