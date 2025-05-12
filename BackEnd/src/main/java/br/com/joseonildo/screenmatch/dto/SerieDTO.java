package br.com.joseonildo.screenmatch.dto;

import br.com.joseonildo.screenmatch.model.Categoria;
import java.time.LocalDate;

public record SerieDTO(
        Long id,
        String titulo,
        String periodoAtiva,
        Integer totalTemporadas,
        Double avaliacao,
        Categoria genero,
        LocalDate dataLancamento,
        String atores,
        String poster,
        String sinopse) {
}
