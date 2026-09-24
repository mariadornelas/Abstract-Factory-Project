package com.faculdade.sensor;

/**
 * Abstract Product B do padrão Abstract Factory.
 *
 * <p>Define o contrato comum a todo sensor de pressão, não importa
 * de qual "família" (perfil de instalação) ele venha.</p>
 */
public interface SensorPressao {

    /**
     * Interpreta o valor medido pelo sensor e classifica a leitura.
     *
     * @param valorMedido valor bruto medido pelo sensor, em bar
     * @return o status da leitura: "NORMAL", "ALERTA" ou "CRITICO"
     */
    String ler(double valorMedido);
}
