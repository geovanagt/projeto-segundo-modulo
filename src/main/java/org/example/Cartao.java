package org.example;

public class Cartao {
    String atleta;
    String tipo;

    public Cartao(String atleta, String tipo) {
        this.atleta = atleta;
        this.tipo = tipo;
    }

    String getAtleta() { return atleta; }
    String getTipo() { return tipo; }
}
