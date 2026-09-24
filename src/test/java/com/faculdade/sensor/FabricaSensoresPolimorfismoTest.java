package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaSensoresPolimorfismoTest {

    private static class SensorTemperaturaFake implements SensorTemperatura {
        @Override
        public String ler(double valorMedido) {
            return "NORMAL";
        }
    }

    private static class SensorPressaoFake implements SensorPressao {
        @Override
        public String ler(double valorMedido) {
            return "NORMAL";
        }
    }

    @Test
    void codigoClienteDeveFuncionarComQualquerImplementacaoDeFabricaSensores() {
        FabricaSensores fabricaFake = new FabricaSensores() {
            @Override
            public SensorTemperatura criarSensorTemperatura() {
                return new SensorTemperaturaFake();
            }

            @Override
            public SensorPressao criarSensorPressao() {
                return new SensorPressaoFake();
            }
        };

        String statusTemperatura = fabricaFake.criarSensorTemperatura().ler(50.0);
        String statusPressao = fabricaFake.criarSensorPressao().ler(5.0);

        assertEquals("NORMAL", statusTemperatura);
        assertEquals("NORMAL", statusPressao);
    }

    @Test
    void trocarAFabricaConcretaNaoDeveExigirMudarOCodigoCliente() {

        FabricaSensores fabricaInterno = new FabricaSensoresInterno();
        assertDoesNotThrow(() -> fabricaInterno.criarSensorTemperatura().ler(50.0));

        FabricaSensores fabricaExterno = new FabricaSensoresExterno();
        assertDoesNotThrow(() -> fabricaExterno.criarSensorTemperatura().ler(50.0));
    }
}
