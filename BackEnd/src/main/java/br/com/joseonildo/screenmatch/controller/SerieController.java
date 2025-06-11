package br.com.joseonildo.screenmatch.controller;

import br.com.joseonildo.screenmatch.dto.EpisodioDTO;
import br.com.joseonildo.screenmatch.dto.SerieDTO;
import br.com.joseonildo.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    /*@GetMapping("/menu")
    public String obterMenu() {
        return "Menu inicial!";
    }*/

    @GetMapping
    public List<SerieDTO> obterSeries() {
        return servico.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5() {
        return servico.obterTop5();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos() {
        return servico.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterSeriePorId(@PathVariable Long id) {
        return servico.obterSeriePorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadasPorId(@PathVariable Long id) {
        return servico.obterTodasTemporadasPorId(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterTemporadaPorNumero(@PathVariable Long id, @PathVariable Long numero) {
        return servico.obterTemporadaPorNumero(id, numero);
    }

    @GetMapping("/categoria/{genero}")
    public List<SerieDTO> obterSeriesPorCategoria(@PathVariable String genero){
        return servico.obterSeriesPorCategoria(genero);
    }

    @GetMapping("/{serieId}/temporadas/top5")
    public List<EpisodioDTO> obterTop5Episodios(@PathVariable Long serieId) {
        return servico.obterTop5EpisodiosPorSerie(serieId);
    }
}
