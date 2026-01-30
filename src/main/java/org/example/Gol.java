package org.example;

public class Gol {
    String atleta;
    String tipo; // "Penalty", "Gol Contra" ou ""

    public Gol(String atleta, String tipo) {
        this.atleta = atleta;
        this.tipo = tipo;
    }

    String getAtleta() { return atleta; }
    String getTipo() { return tipo; }
}
