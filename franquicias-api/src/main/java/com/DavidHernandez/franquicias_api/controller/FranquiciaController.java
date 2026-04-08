package com.DavidHernandez.franquicias_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DavidHernandez.franquicias_api.model.Franquicia;
import com.DavidHernandez.franquicias_api.service.FranquiciaService;

@RestController
@RequestMapping("/api/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping
    public ResponseEntity<Franquicia> crearFranquicia(
            @RequestBody Franquicia franquicia) {

        return ResponseEntity.ok(
                franquiciaService.crearFranquicia(franquicia)
        );
    }
    
    @PatchMapping("/{id}/nombre")
    public ResponseEntity<Franquicia> actualizarNombre(
        @PathVariable Long id,
        @RequestParam String nombre) {

    return ResponseEntity.ok(
            franquiciaService.actualizarNombre(id, nombre)
    );
}
}