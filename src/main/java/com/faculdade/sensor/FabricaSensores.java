package com.faculdade.sensor;

/**
 * Abstract Factory do padrão Abstract Factory.
 *
 * <p>Declara os métodos para criar cada produto de uma <b>família</b>
 * de sensores compatíveis entre si (um sensor de temperatura e um
 * sensor de pressão pensados para o mesmo perfil de instalação). O
 * código cliente trabalha apenas com esta interface — nunca sabe se
 * está lidando com a família "Interno" ou "Externo".</p>
 */
public interface FabricaSensores {

    /**
     * @return um novo sensor de temperatura, compatível com esta família
     */
    SensorTemperatura criarSensorTemperatura();

    /**
     * @return um novo sensor de pressão, compatível com esta família
     */
    SensorPressao criarSensorPressao();
}
