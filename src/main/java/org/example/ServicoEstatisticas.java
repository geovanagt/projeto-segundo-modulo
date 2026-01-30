package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ServicoEstatisticas {

    List<Partida> partidas;
    List<Gol> gols;
    List<Cartao> cartoes;

    public ServicoEstatisticas(List<Partida> partidas, List<Gol> gols, List<Cartao> cartoes) {
        this.partidas = partidas;
        this.gols = gols;
        this.cartoes = cartoes;
    }

    public String obterTimeComMaisVitorias(int ano) {
        Map<String, Integer> vitorias = new HashMap<>();

        for (Partida p : partidas) {
            if (p.getAno() == ano) {
                if (p.getGolsMandante() > p.getGolsVisitante()) {
                    vitorias.merge(p.getTimeMandante(), 1, Integer::sum);
                } else if (p.getGolsVisitante() > p.getGolsMandante()) {
                    vitorias.merge(p.getTimeVisitante(), 1, Integer::sum);
                }
            }
        }

        return vitorias.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum dado encontrado");
    }

    public String obterEstadoComMenosJogos(int inicio, int fim) {
        Map<String, Integer> contagem = new HashMap<>();

        for (Partida p : partidas) {
            if (p.getAno() >= inicio && p.getAno() <= fim) {
                contagem.merge(p.getEstadoMandante(), 1, Integer::sum);
            }
        }

        return contagem.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum dado encontrado");
    }

    public String obterJogadorMaisGols() {
        return gols.stream()
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum gol encontrado");
    }

    public String obterJogadorMaisPenaltis() {
        return gols.stream()
                .filter(g -> g.getTipo().equalsIgnoreCase("Penalty"))
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum gol de pênalti registrado");
    }

    public String obterMaisGolsContra() {
        return gols.stream()
                .filter(g -> g.getTipo().equalsIgnoreCase("Gol Contra"))
                .collect(Collectors.groupingBy(Gol::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum gol contra registrado");
    }

    public String obterMaisCartoesAmarelos() {
        return cartoes.stream()
                .filter(c -> c.getTipo().equalsIgnoreCase("Amarelo"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum cartão amarelo encontrado");
    }

    public String obterMaisCartoesVermelhos() {
        return cartoes.stream()
                .filter(c -> c.getTipo().equalsIgnoreCase("Vermelho"))
                .collect(Collectors.groupingBy(Cartao::getAtleta, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhum cartão vermelho encontrado");
    }

    public Partida obterPartidaComMaisGols() {
        return partidas.stream()
                .max(Comparator.comparingInt(Partida::getTotalGols))
                .orElse(null);
    }
}
