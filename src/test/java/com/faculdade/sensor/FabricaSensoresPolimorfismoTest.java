package com.faculdade.sensor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testa o desacoplamento que o Abstract Factory proporciona ao
 * cliente, usando uma fábrica "fake" (subclasse anônima de
 * {@link FabricaSensores}) que devolve sensores igualmente fake. Isso
 * prova que qualquer código que dependa apenas de {@link FabricaSensores},
 * {@link SensorTemperatura} e {@link SensorPressao} funciona
 * corretamente sem nunca precisar conhecer as classes concretas reais
 * ({@code SensorTemperaturaInterno}, {@code SensorPressaoExterno}, etc.)
 * — que é exatamente o objetivo do padrão.
 */
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

        // Este trecho simula "código cliente": só conhece a abstração
        // FabricaSensores, nunca uma classe concreta.
        String statusTemperatura = fabricaFake.criarSensorTemperatura().ler(50.0);
        String statusPressao = fabricaFake.criarSensorPressao().ler(5.0);

        assertEquals("NORMAL", statusTemperatura);
        assertEquals("NORMAL", statusPressao);
    }

    @Test
    void trocarAFabricaConcretaNaoDeveExigirMudarOCodigoCliente() {
        // O mesmo tipo de variável, declarado como a abstração
        // FabricaSensores, funciona igualmente bem com qualquer
        // família concreta.
        FabricaSensores fabricaInterno = new FabricaSensoresInterno();
        assertDoesNotThrow(() -> fabricaInterno.criarSensorTemperatura().ler(50.0));

        FabricaSensores fabricaExterno = new FabricaSensoresExterno();
        assertDoesNotThrow(() -> fabricaExterno.criarSensorTemperatura().ler(50.0));
    }
}
