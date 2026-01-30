package org.example;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeitorCsv {
    public List<Partida> carregarPartidas(String caminho) {
        List<Partida> lista = new ArrayList<>();
        try {
            URI uri = LeitorCsv.class.getResource(caminho).toURI();
            List<String> linhas = Files.lines(Paths.get(uri)).skip(1).toList();
            //List<String> linhas = Files.readAllLines(Paths.get(caminho));
            if (linhas.isEmpty()) return lista;
            //linhas.remove(0);

            for (String linha : linhas) {
                String[] c = linha.replace("\"", "").split(",", -1); //

                if (c.length < 15) continue;

                String data = c[2];
                int ano = 0;
                int barra = data.lastIndexOf("/");
                if (barra >= 0 && barra + 1 < data.length()) {
                    ano = Integer.parseInt(data.substring(barra + 1));
                }

                String mandante = c[4];
                String visitante = c[5];

                int golsMandante = parseIntSeguro(c[12]);
                int golsVisitante = parseIntSeguro(c[13]);

                String estadoMandante = c[14];

                Partida p = new Partida(ano, mandante, visitante, golsMandante, golsVisitante, estadoMandante);
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Erro lendo arquivo de partidas: " + e.getMessage());
        }
        return lista;
    }

    public List<Gol> carregarGols(String caminho) {
        List<Gol> lista = new ArrayList<>();
        try {
            URI uri = LeitorCsv.class.getResource(caminho).toURI();
            List<String> linhas = Files.lines(Paths.get(uri)).skip(1).toList();
            //List<String> linhas = Files.readAllLines(Paths.get(caminho));
            if (linhas.isEmpty()) return lista;
            //linhas.remove(0);

            for (String linha : linhas) {
                String[] c = linha.replace("\"", "").split(",", -1);

                if (c.length < 6) continue;

                String atleta = c[3];
                String tipo = c[5].trim(); // "Penalty", "Gol Contra" ou ""

                lista.add(new Gol(atleta, tipo));
            }
        } catch (Exception e) {
            System.out.println("Erro lendo arquivo de gols: " + e.getMessage());
        }
        return lista;
    }

    public List<Cartao> carregarCartoes(String caminho) {
        List<Cartao> lista = new ArrayList<>();
        try {
            URI uri = LeitorCsv.class.getResource(caminho).toURI();
            List<String> linhas = Files.lines(Paths.get(uri)).skip(1).toList();
            //List<String> linhas = Files.readAllLines(Paths.get(caminho));
            if (linhas.isEmpty()) return lista;
            //linhas.remove(0);

            for (String linha : linhas) {
                String[] c = linha.replace("\"", "").split(",", -1);
                if (c.length < 5) continue;

                String tipo = c[3];
                String atleta = c[4];

                lista.add(new Cartao(atleta, tipo));
            }
        } catch (Exception e) {
            System.out.println("Erro lendo arquivo de cartões: " + e.getMessage());
        }
        return lista;
    }

    int parseIntSeguro(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }
}
