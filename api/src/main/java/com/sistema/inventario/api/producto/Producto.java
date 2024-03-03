package com.sistema.inventario.api.producto;

import com.sistema.inventario.api.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoDetalles> detalles = new ArrayList<>();

    public void setDetalle(Integer id, String nombre, String valor){
        this.detalles.add(new ProductoDetalles(id, nombre, valor,this));
    }
    public List<ProductoDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoDetalles> detalles) {
        this.detalles = detalles;
    }

    public Producto(int id, String nombre, float precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;

    }

    public Producto(String nombre, float precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public void añadirDetalles(String nombre, String valor){
        this.detalles.add(new ProductoDetalles(nombre,valor,this));
    }


}
