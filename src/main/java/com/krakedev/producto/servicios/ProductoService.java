package com.krakedev.producto.servicios;

import com.krakedev.producto.entidades.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList; // Importación obligatoria
import java.util.Optional;

@Service
public class ProductoService {
    
    // Declaración usando ArrayList en lugar de la interfaz List
    private ArrayList<Producto> productos = new ArrayList<>();

    public Producto crear(Producto producto) {
        productos.add(producto);
        return producto;
    }

    // El tipo de retorno ahora es ArrayList
    public ArrayList<Producto> listarTodos() {
        return productos;
    }

    public Optional<Producto> buscarPorCodigo(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst();
    }

    public Producto actualizar(String codigo, Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productoActualizado.setCodigo(codigo); 
                productos.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        return productos.removeIf(p -> p.getCodigo().equals(codigo));
    }
}