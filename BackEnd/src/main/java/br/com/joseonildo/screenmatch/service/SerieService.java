package br.com.joseonildo.screenmatch.service;

import br.com.joseonildo.screenmatch.dto.EpisodioDTO;
import br.com.joseonildo.screenmatch.dto.SerieDTO;
import br.com.joseonildo.screenmatch.model.Categoria;
import br.com.joseonildo.screenmatch.model.Episodio;
import br.com.joseonildo.screenmatch.model.Serie;
import br.com.joseonildo.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repositorio;

    private List<SerieDTO> converteDadosSerie(List<Serie> series) {
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

    private List<EpisodioDTO> converteDadosEpisodio(List<Episodio> episodios) {
        return episodios.stream()
                .map(e -> new EpisodioDTO(
                        e.getTemporada(),
                        e.getNumeroEpisodio(),
                        e.getTitulo(),
                        e.getAvaliacao()
                ))
                .toList();
    }

    public List<SerieDTO> obterTodasAsSeries() {
        return converteDadosSerie(repositorio.findAll());
    }

    public List<SerieDTO> obterTop5() {
        return converteDadosSerie(repositorio.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> obterLancamentos() {
        return converteDadosSerie(repositorio.encontrarEpisodiosMaisRecentes());
    }

    public SerieDTO obterSeriePorId(Long id) {
        Optional<Serie> serie = repositorio.findById(id);
        if (serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(
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
            );
        }
        return null;
    }

    public List<EpisodioDTO> obterTodasTemporadasPorId(Long id) {
        Optional<Serie> serie = repositorio.findById(id);
        if (serie.isPresent()){
            Serie s = serie.get();
            return converteDadosEpisodio(s.getEpisodios());
        }
        return null;
    }

    public List<EpisodioDTO> obterTemporadaPorNumero(Long id, Long numero) {
        return converteDadosEpisodio(repositorio.ObterEpisodiosPorTemporada(id, numero));
    }

    public List<SerieDTO> obterSeriesPorCategoria(String genero) {
        Categoria categoria = Categoria.fromPortugues(genero);
        return converteDadosSerie(repositorio.findByGenero(categoria));
    }

    public List<EpisodioDTO> obterTop5EpisodiosPorSerie(Long serieId) {
        return converteDadosEpisodio(repositorio.top5episodiosPorSerie(serieId));
    }
}
