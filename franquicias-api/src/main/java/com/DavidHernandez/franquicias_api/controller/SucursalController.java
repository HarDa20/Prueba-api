package com.DavidHernandez.franquicias_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DavidHernandez.franquicias_api.model.Sucursal;
import com.DavidHernandez.franquicias_api.service.SucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/franquicia/{franquiciaId}")
    public ResponseEntity<Sucursal> agregarSucursal(
            @PathVariable Long franquiciaId,
            @RequestBody Sucursal sucursal) {

        return ResponseEntity.ok(
                sucursalService.agregarSucursal(franquiciaId, sucursal)
        );
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<Sucursal> actualizarNombre(
        @PathVariable Long id,
        @RequestParam String nombre) {

    return ResponseEntity.ok(
            sucursalService.actualizarNombre(id, nombre)
    );
    }
    
}