package com.DavidHernandez.franquicias_api.service;

import org.springframework.stereotype.Service;

import com.DavidHernandez.franquicias_api.model.Franquicia;
import com.DavidHernandez.franquicias_api.model.Sucursal;
import com.DavidHernandez.franquicias_api.repository.FranquiciaRepository;
import com.DavidHernandez.franquicias_api.repository.SucursalRepository;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;
    private final FranquiciaRepository franquiciaRepository;

    public SucursalService(SucursalRepository sucursalRepository,
            FranquiciaRepository franquiciaRepository) {
        this.sucursalRepository = sucursalRepository;
        this.franquiciaRepository = franquiciaRepository;
    }

    public Sucursal agregarSucursal(Long franquiciaId, Sucursal sucursal) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new RuntimeException("Franquicia no encontrada"));

        sucursal.setFranquicia(franquicia);
        return sucursalRepository.save(sucursal);
    }

    public Sucursal actualizarNombre(Long id, String nombre) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        sucursal.setNombre(nombre);
        return sucursalRepository.save(sucursal);
    }
}
