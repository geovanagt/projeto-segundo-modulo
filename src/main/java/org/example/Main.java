package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LeitorCsv leitor = new LeitorCsv();
        List<Partida> partidas = leitor.carregarPartidas("/campeonato-brasileiro-full.csv");
        List<Gol> gols = leitor.carregarGols("/campeonato-brasileiro-gols.csv");
        List<Cartao> cartoes = leitor.carregarCartoes("/campeonato-brasileiro-cartoes.csv");

        ServicoEstatisticas servico = new ServicoEstatisticas(partidas, gols, cartoes);

        //Time que mais venceu jogos no ano 2008
        String timeMaisVitorias = servico.obterTimeComMaisVitorias(2008);
        System.out.println("Time que mais venceu em 2008: " + timeMaisVitorias);

        //Estado que teve menos jogos dentro do período 2003 e 2022
        String estadoMenosJogos = servico.obterEstadoComMenosJogos(2003, 2022);
        System.out.println("Estado com menos jogos (2003-2022): " + estadoMenosJogos);

        //Jogador que mais fez gols
        String maisGols = servico.obterJogadorMaisGols();
        System.out.println("Jogador com mais gols: " + maisGols);

        //Jogador que mais fez gols de pênaltis
        String jogadorMaisPenaltis = servico.obterJogadorMaisPenaltis();
        System.out.println("Jogador com mais gols de pênalti: " + jogadorMaisPenaltis);

        //Jogador que mais fez gols contras
        String maisGolsContra = servico.obterMaisGolsContra();
        System.out.println("Jogador com mais gols contra: " + maisGolsContra);

        //Jogador que mais recebeu cartões amarelos
        String maisAmarelos = servico.obterMaisCartoesAmarelos();
        System.out.println("Jogador com mais cartões amarelos: " + maisAmarelos);

        //Jogador que mais recebeu cartões vermelhos
        String maisVermelhos = servico.obterMaisCartoesVermelhos();
        System.out.println("Jogador com mais cartões vermelhos: " + maisVermelhos);

        //Placar da partida com mais gols.
        Partida partidaComMaisGols = servico.obterPartidaComMaisGols();
        if (partidaComMaisGols != null) {
            System.out.println("Partida com mais gols: "
                    + partidaComMaisGols.getTimeMandante() + " " + partidaComMaisGols.getGolsMandante()
                    + " x " + partidaComMaisGols.getGolsVisitante() + " " + partidaComMaisGols.getTimeVisitante());
        } else {
            System.out.println("Partida com mais gols: Nenhuma partida encontrada");
        }

    }
}