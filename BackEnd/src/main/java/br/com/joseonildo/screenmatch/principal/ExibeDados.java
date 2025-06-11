package br.com.joseonildo.screenmatch.principal;

import br.com.joseonildo.screenmatch.model.Serie;

public class ExibeDados {

    public static String menuInicial() {
        return """
                
                ####################### MENU #####################
                
                1 -> Cadastrar Serie + Episodios
                0 -> Sair
                
                #################################################
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