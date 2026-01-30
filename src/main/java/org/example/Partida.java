package org.example;

public class Partida {

    int ano;
    String timeMandante;
    String timeVisitante;
    int golsMandante;
    int golsVisitante;
    String estadoMandante;

    public Partida(int ano, String timeMandante, String timeVisitante,
                   int golsMandante, int golsVisitante, String estadoMandante) {
        this.ano = ano;
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
        this.golsMandante = golsMandante;
        this.golsVisitante = golsVisitante;
        this.estadoMandante = estadoMandante;
    }

    public int getAno() { return ano; }
    public String getTimeMandante() { return timeMandante; }
    public String getTimeVisitante() { return timeVisitante; }
    public int getGolsMandante() { return golsMandante; }
    public int getGolsVisitante() { return golsVisitante; }
    public String getEstadoMandante() { return estadoMandante; }

    public int getTotalGols() { return golsMandante + golsVisitante; }
}
