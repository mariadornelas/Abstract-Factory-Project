package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaSensoresInternoTest {

    private final FabricaSensores fabrica = new FabricaSensoresInterno();

    @Test
    void deveCriarUmSensorDeTemperaturaDaFamiliaInterno() {
        SensorTemperatura sensor = fabrica.criarSensorTemperatura();
        assertInstanceOf(SensorTemperaturaInterno.class, sensor);
    }

    @Test
    void deveCriarUmSensorDePressaoDaFamiliaInterno() {
        SensorPressao sensor = fabrica.criarSensorPressao();
        assertInstanceOf(SensorPressaoInterno.class, sensor);
    }

    @Test
    void osDoisSensoresCriadosDevemSerDaMesmaFamilia() {

        assertInstanceOf(SensorTemperaturaInterno.class, fabrica.criarSensorTemperatura());
        assertInstanceOf(SensorPressaoInterno.class, fabrica.criarSensorPressao());
    }
}
