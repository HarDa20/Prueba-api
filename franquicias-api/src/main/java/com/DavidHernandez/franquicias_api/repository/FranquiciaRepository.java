package com.DavidHernandez.franquicias_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DavidHernandez.franquicias_api.model.Franquicia;

public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {
}