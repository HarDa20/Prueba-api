package com.DavidHernandez.franquicias_api.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DavidHernandez.franquicias_api.model.Producto;
import com.DavidHernandez.franquicias_api.model.Sucursal;
import com.DavidHernandez.franquicias_api.repository.ProductoRepository;
import com.DavidHernandez.franquicias_api.repository.SucursalRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository;

    public ProductoService(ProductoRepository productoRepository,
                           SucursalRepository sucursalRepository) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    public Producto agregarProducto(Long sucursalId, Producto producto) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        producto.setSucursal(sucursal);
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    public Producto actualizarStock(Long productoId, Integer stock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setStock(stock);
        return productoRepository.save(producto);
    }

    public List<Producto> obtenerMayorStockPorFranquicia(Long franquiciaId) {
        List<Sucursal> sucursales = sucursalRepository.findByFranquiciaId(franquiciaId);

        return sucursales.stream()
                .map(sucursal -> productoRepository.findBySucursalId(sucursal.getId())
                        .stream()
                        .max(Comparator.comparing(Producto::getStock))
                        .orElse(null))
                .filter(producto -> producto != null)
                .collect(Collectors.toList());
    }

    public Producto actualizarNombre(Long id, String nombre) {
    Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    producto.setNombre(nombre);
    return productoRepository.save(producto);
    }
    
}