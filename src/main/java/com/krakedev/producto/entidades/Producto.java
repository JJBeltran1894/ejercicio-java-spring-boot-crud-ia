package com.krakedev.producto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // Indica que esta clase es una entidad de base de datos
@Table(name = "productos") // Define el nombre de la tabla en la BD
public class Producto {

	@Id // Define el atributo 'codigo' como la llave primaria
	@Column(name = "id_codigo")
	private String codigo;

	@Column(nullable = false, length = 100)
	private String nombre;

    private double precio;
	
	public Producto() {
    }
	
	public Producto(String codigo, String nombre, double precio) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
	
	
}
