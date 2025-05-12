package br.com.joseonildo.screenmatch.service;

import br.com.joseonildo.screenmatch.dto.SerieDTO;
import br.com.joseonildo.screenmatch.model.Serie;
import br.com.joseonildo.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repositorio;

    public List<SerieDTO> obterTodasAsSeries() {
        return converteDados(repositorio.findAll());
    }

    public List<SerieDTO> obterTop5() {
        return converteDados(repositorio.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDados(repositorio.findTop5ByOrderByDataLancamentoDesc());
    }

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(s -> new SerieDTO(
                        s.getId(),
                        s.getTitulo(),
                        s.getPeriodoAtiva(),
                        s.getTotalTemporadas(),
                        s.getAvaliacao(),
                        s.getGenero(),
                        s.getDataLancamento(),
                        s.getAtores(),
                        s.getPoster(),
                        s.getSinopse()
                ))
                .toList();
    }

}
