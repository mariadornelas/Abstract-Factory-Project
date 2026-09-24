package com.faculdade.sensor;

import java.util.List;

/**
 * Classe cliente da demonstração.
 *
 * <p>Repare que este código conhece apenas os tipos abstratos
 * {@link FabricaSensores}, {@link SensorTemperatura} e
 * {@link SensorPressao}. Em nenhum momento ele escreve
 * {@code new SensorTemperaturaInterno()} ou {@code new SensorPressaoExterno()}
 * diretamente — ele só sabe que, ao escolher uma fábrica (Interno ou
 * Externo), os dois sensores que ela devolve serão sempre compatíveis
 * entre si.</p>
 */
public class App {

    public static void main(String[] args) {
        System.out.println("=== Central de Monitoramento Industrial (Abstract Factory) ===\n");

        List<FabricaSensores> fabricas = List.of(
                new FabricaSensoresInterno(),
                new FabricaSensoresExterno()
        );

        double[] leiturasTemperatura = {50.0, 75.0, 95.0};
        double[] leiturasPressao = {5.0, 9.0, 13.0};

        for (FabricaSensores fabrica : fabricas) {
            // A fábrica monta o kit inteiro: os dois sensores já vêm
            // compatíveis entre si, sem o cliente precisar saber qual
            // classe concreta está por trás de cada um.
            SensorTemperatura sensorTemperatura = fabrica.criarSensorTemperatura();
            SensorPressao sensorPressao = fabrica.criarSensorPressao();

            System.out.println("--- Kit montado por: " + fabrica.getClass().getSimpleName() + " ---");

            for (double valor : leiturasTemperatura) {
                System.out.printf("Temperatura %.1f -> %s%n", valor, sensorTemperatura.ler(valor));
            }
            for (double valor : leiturasPressao) {
                System.out.printf("Pressão %.1f     -> %s%n", valor, sensorPressao.ler(valor));
            }
            System.out.println();
        }
    }
}
