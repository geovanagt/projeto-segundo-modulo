
# Projeto de Estatísticas do Campeonato Brasileiro

Este projeto realiza a leitura de arquivos CSV contendo informações sobre partidas, gols e cartões do Campeonato Brasileiro, e gera diversas estatísticas úteis por meio da classe `ServicoEstatisticas`.


## Estrutura do Projeto
```
ProjetoSegundoModulo/
├── pom.xml
└── src/
    └── main/
        ├── java/
        │     └── org/
        │       └── example/                   
        │          ├── Main.java
        │          ├── LeitorCsv.java
        │          ├── Partida.java
        │          ├── Gol.java
        │          ├── Cartao.java
        │          └── ServicoEstatisticas.java
        └── resources/
            ├── campeonato-brasileiro-full.csv
            ├── campeonato-brasileiro-gols.csv
            ├── campeonato-brasileiro-estatisticas-full.csv
            └── campeonato-brasileiro-cartoes.csv                     
```
## Lógica e classes

- **`Partida`**: representa uma partida, com `ano`, `timeMandante`, `timeVisitante`, `golsMandante`, `golsVisitante`, `estadoMandante` e `getTotalGols()`.
- **`Gol`**: representa um gol, com `atleta` e `tipo` (Penalty, Gol Contra, ou vazio).
- **`Cartao`**: representa um cartão, com `atleta` e `tipo` (Amarelo/Vermelho).
- **`LeitorCsv`**: carrega e transforma linhas dos CSVs em objetos de domínio (`Partida`, `Gol`, `Cartao`).
- **`ServicoEstatisticas`**: calcula as estatísticas solicitadas:
    - `obterTimeComMaisVitorias(ano)`
    - `obterEstadoComMenosJogos(inicio, fim)`
    - `obterJogadorMaisGols()`
    - `obterJogadorMaisPenaltis()`
    - `obterMaisGolsContra()`
    - `obterMaisCartoesAmarelos()`
    - `obterMaisCartoesVermelhos()`
    - `obterPartidaComMaisGols()`

> Todos os métodos retornam um valor **seguro** (mensagens como “Nenhum dado encontrado”) quando não há dados suficientes, evitando `NoSuchElementException`.
## Como Executar
1. Coloque os arquivos CSV na pasta do projeto.
2Execute o arquivo `Main.java`.

## Tecnologias
- Java
- Manipulação de arquivos CSV

"# projeto-segundo-modulo" 
