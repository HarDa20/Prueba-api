package com.DavidHernandez.franquicias_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DavidHernandez.franquicias_api.model.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
    List<Sucursal> findByFranquiciaId(Long franquiciaId);
}
