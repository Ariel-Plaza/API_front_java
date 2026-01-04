package com.aluracursos.screenmatch.controller;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//modelo rest
//@RestController
//public class SerieController {
//    @Autowired
//    private SerieRepository repository;
//    obtener datos de una ruta en especifico
//    @GetMapping("/series")
//  Mostrar mensaje en ruta
//    public String mostrarMensaje(){
//        return "Pobando live reloadd";
//}
//    Obtiene las series desde la BD
//    enviado a un service para separar y por buenas practicas
//    public List<SerieDTO> obtenerTodasLasSeries(){
//        return repository.findAll().stream()
//                .map(serie -> new SerieDTO(serie.getTitulo(), serie.getTotalTemporadas(), serie.getEvaluacion(), serie.getPoster()
//                , serie.getGenero(), serie.getActores(), serie.getSinopsis()))
//                .collect(Collectors.toList());
//    }
@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService servicio;

    @GetMapping()
    public List<SerieDTO> obtenerTodasLasSeries() {
        return servicio.obtenerTodasLasSeries();

    }

    @GetMapping("/top5")
    public List<SerieDTO> obtenerTop5(){
        return servicio.obtenerTop5();
    }

    @GetMapping("/lanzamientos")
    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return servicio.obtenerLanzamientosMasRecientes();
    }

    @GetMapping("/{id}")
    public SerieDTO obtenerPorId(@PathVariable Long id){
        return servicio.obtenerPorId(id);
    }
}
