package com.faculdade.sensor;

/**
 * Concrete Product A1: sensor de temperatura da família <b>Interno</b>
 * (instalado em ambientes climatizados/controlados da planta).
 *
 * <p>Como o ambiente é controlado, qualquer variação de temperatura já
 * é um indício de problema — por isso os limiares são mais apertados
 * do que os da família Externo.</p>
 */
public class SensorTemperaturaInterno implements SensorTemperatura {

    private static final double LIMITE_ALERTA = 60.0;
    private static final double LIMITE_CRITICO = 80.0;

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
