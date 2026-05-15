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
    
    private int stock;
    
    private String origen;//LOCAL O IMPORTADO
    
    
	public Producto() {
    }
	
	
	public Producto(String codigo, String nombre, double precio, int stock, String origen) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.origen = origen;
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
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock
				+ ", origen=" + origen + "]";
	}	
}
