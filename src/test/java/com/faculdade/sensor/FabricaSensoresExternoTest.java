package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaSensoresExternoTest {

    private final FabricaSensores fabrica = new FabricaSensoresExterno();

    @Test
    void deveCriarUmSensorDeTemperaturaDaFamiliaExterno() {
        SensorTemperatura sensor = fabrica.criarSensorTemperatura();
        assertInstanceOf(SensorTemperaturaExterno.class, sensor);
    }

    @Test
    void deveCriarUmSensorDePressaoDaFamiliaExterno() {
        SensorPressao sensor = fabrica.criarSensorPressao();
        assertInstanceOf(SensorPressaoExterno.class, sensor);
    }

    @Test
    void osDoisSensoresCriadosDevemSerDaMesmaFamilia() {
        assertInstanceOf(SensorTemperaturaExterno.class, fabrica.criarSensorTemperatura());
        assertInstanceOf(SensorPressaoExterno.class, fabrica.criarSensorPressao());
    }
}
