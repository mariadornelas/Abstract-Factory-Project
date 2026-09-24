package com.faculdade.sensor;

/**
 * Abstract Product A do padrão Abstract Factory.
 *
 * <p>Define o contrato comum a todo sensor de temperatura, não importa
 * de qual "família" (perfil de instalação) ele venha.</p>
 */
public interface SensorTemperatura {

    /**
     * Interpreta o valor medido pelo sensor e classifica a leitura.
     *
     * @param valorMedido valor bruto medido pelo sensor, em °C
     * @return o status da leitura: "NORMAL", "ALERTA" ou "CRITICO"
     */
    String ler(double valorMedido);
}
