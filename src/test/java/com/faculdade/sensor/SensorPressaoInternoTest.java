package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SensorPressaoInternoTest {

    private final SensorPressao sensor = new SensorPressaoInterno();

    @Test
    void deveClassificarComoNormalAbaixoDoLimiteDeAlerta() {
        assertEquals("NORMAL", sensor.ler(4.0));
    }

    @Test
    void deveClassificarComoAlertaEntreOsLimites() {
        assertEquals("ALERTA", sensor.ler(7.0));
    }

    @Test
    void deveClassificarComoCriticoAcimaDoLimiteCritico() {
        assertEquals("CRITICO", sensor.ler(11.0));
    }
}
