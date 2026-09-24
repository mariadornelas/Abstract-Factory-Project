package com.faculdade.sensor;

/**
 * Concrete Product B2: sensor de pressão da família <b>Externo</b>,
 * projetado para tubulações expostas da planta, com limiares mais
 * tolerantes do que a família Interno.
 */
public class SensorPressaoExterno implements SensorPressao {

    private static final double LIMITE_ALERTA = 10.0;
    private static final double LIMITE_CRITICO = 14.0;

    @Override
    public String ler(double valorMedido) {
        if (valorMedido >= LIMITE_CRITICO) {
            return "CRITICO";
        } else if (valorMedido >= LIMITE_ALERTA) {
            return "ALERTA";
        } else {
            return "NORMAL";
        }
    }
}
