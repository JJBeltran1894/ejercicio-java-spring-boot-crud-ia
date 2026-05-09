package com.krakedev.producto;

import com.krakedev.producto.entidades.Producto;
import com.krakedev.producto.servicios.ProductoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductoServiceTest {

    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        // Reiniciamos el servicio antes de cada prueba
        productoService = new ProductoService(); 
    }

    @Test
    void testCrearProducto() {
        Producto producto = new Producto("P001", "Laptop", 1200.50);
        Producto creado = productoService.crear(producto);

        assertEquals("P001", creado.getCodigo());
        assertEquals(1, productoService.listarTodos().size());
    }

    @Test
    void testBuscarPorCodigo() {
        productoService.crear(new Producto("P002", "Mouse", 25.0));

        Optional<Producto> encontrado = productoService.buscarPorCodigo("P002");
        assertTrue(encontrado.isPresent());
        assertEquals("Mouse", encontrado.get().getNombre());
    }

    @Test
    void testBuscarPorCodigoNoExiste() {
        Optional<Producto> encontrado = productoService.buscarPorCodigo("INEXISTENTE");
        assertFalse(encontrado.isPresent());
    }

    @Test
    void testActualizarProducto() {
        productoService.crear(new Producto("P003", "Teclado", 45.0));

        Producto actualizacion = new Producto("P003", "Teclado Mecánico", 65.0);
        Producto actualizado = productoService.actualizar("P003", actualizacion);

        assertNotNull(actualizado);
        assertEquals("Teclado Mecánico", actualizado.getNombre());
        assertEquals(65.0, actualizado.getPrecio());
    }

    @Test
    void testEliminarProducto() {
        productoService.crear(new Producto("P004", "Monitor", 200.0));
        
        boolean eliminado = productoService.eliminar("P004");
        assertTrue(eliminado);
        assertEquals(0, productoService.listarTodos().size());
    }
}