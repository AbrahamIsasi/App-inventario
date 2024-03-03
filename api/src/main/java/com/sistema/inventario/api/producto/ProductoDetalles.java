package com.sistema.inventario.api.producto;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "producto_detalles")
public class ProductoDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @Column(length = 45, nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;


    public ProductoDetalles(int id, String nombre, String valor, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalles(String nombre, String valor, Producto producto) {
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return nombre + " " + valor;
    }
}
