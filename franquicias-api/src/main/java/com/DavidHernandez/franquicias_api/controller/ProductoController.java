package com.DavidHernandez.franquicias_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DavidHernandez.franquicias_api.model.Producto;
import com.DavidHernandez.franquicias_api.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/sucursal/{sucursalId}")
    public ResponseEntity<Producto> agregarProducto(
            @PathVariable Long sucursalId,
            @RequestBody Producto producto) {

        return ResponseEntity.ok(
                productoService.agregarProducto(sucursalId, producto)
        );
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long productoId) {
        productoService.eliminarProducto(productoId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{productoId}/stock")
    public ResponseEntity<Producto> actualizarStock(
            @PathVariable Long productoId,
            @RequestParam Integer stock) {

        return ResponseEntity.ok(
                productoService.actualizarStock(productoId, stock)
        );
    }

    @GetMapping("/mayor-stock/franquicia/{franquiciaId}")
    public ResponseEntity<List<Producto>> obtenerMayorStockPorFranquicia(
            @PathVariable Long franquiciaId) {

        return ResponseEntity.ok(
                productoService.obtenerMayorStockPorFranquicia(franquiciaId)
        );
    }

    @PatchMapping("/{id}/nombre")
    public ResponseEntity<Producto> actualizarNombre(
        @PathVariable Long id,
        @RequestParam String nombre) {

    return ResponseEntity.ok(
            productoService.actualizarNombre(id, nombre)
    );
    }
    
}
