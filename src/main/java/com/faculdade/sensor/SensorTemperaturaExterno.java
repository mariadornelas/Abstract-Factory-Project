package com.faculdade.sensor;

/**
 * Concrete Product A2: sensor de temperatura da família <b>Externo</b>
 * (instalado a céu aberto, exposto às intempéries da planta).
 *
 * <p>Equipamentos externos são projetados para suportar uma variação
 * natural maior de temperatura ao longo do dia, então os limiares de
 * alerta e crítico são mais altos do que os da família Interno.</p>
 */
public class SensorTemperaturaExterno implements SensorTemperatura {

    private static final double LIMITE_ALERTA = 80.0;
    private static final double LIMITE_CRITICO = 100.0;

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
