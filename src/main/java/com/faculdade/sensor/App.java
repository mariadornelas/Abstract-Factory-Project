package com.faculdade.sensor;

import java.util.List;

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
