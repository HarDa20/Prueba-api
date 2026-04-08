package com.DavidHernandez.franquicias_api.service;

import org.springframework.stereotype.Service;

import com.DavidHernandez.franquicias_api.model.Franquicia;
import com.DavidHernandez.franquicias_api.repository.FranquiciaRepository;

@Service
public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    public Franquicia crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Franquicia actualizarNombre(Long id, String nombre) {
    Franquicia franquicia = franquiciaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

    franquicia.setNombre(nombre);
    return franquiciaRepository.save(franquicia);
}
}