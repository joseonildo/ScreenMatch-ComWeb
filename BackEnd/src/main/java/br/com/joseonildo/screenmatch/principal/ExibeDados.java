package br.com.joseonildo.screenmatch.principal;

import br.com.joseonildo.screenmatch.model.Serie;

public class ExibeDados {

    public static String menuInicial() {
        return """
                
                ####################### MENU #####################<br>
                <br>
                1 -> Cadastrar Serie + Episodios<br>
                2 -> Listar Series (Resumida)<br>
                3 -> Listar Series (Detalhada)<br>
                4 -> Escolher Série e listar episodios<br>
                5 -> Listar Series por Ator e Avaliação<br>
                6 -> Listar TOP 5 Series<br>
                7 -> Listar Séries por Categoria<br>
                8 -> Listar Series por Temporadas e Avaliação<br>
                9 -> Listar Episodios por trecho<br>
                10-> Listar TOP 5 Episodios por Série<br>
                11-> Listar episódios a partir de um ano<br>
                12-> Listar Series a partir de um ano<br>
                <br>
                20-> Acrescentar Ator na Serie<br>
                0 -> Sair<br>
                <br>
                #################################################<br>
                """;
    }

    public static String exibeSerie(Serie dadosSerie, Boolean exibeEpisodios) {
        return String.format("""
                        Genero:            %s
                        Nome da série:     %s
                        Ano de lançamento: %s
                        Período ativa:     %s
                        Qtd de temporadas: %s
                        Avaliação:         %s
                        Atores:            %s
                        Poster:            %s
                        Sinopse:           %s
                        Episodios:         %s
                        """,
                dadosSerie.getGenero(),
                dadosSerie.getTitulo(),
                dadosSerie.getDataLancamento(),
                dadosSerie.getPeriodoAtiva(),
                dadosSerie.getTotalTemporadas(),
                dadosSerie.getAvaliacao(),
                dadosSerie.getAtores(),
                dadosSerie.getPoster(),
                dadosSerie.getSinopse(),
                exibeEpisodios ? dadosSerie.getEpisodios() : dadosSerie.getEpisodios().size());
    }
}