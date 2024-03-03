package com.sistema.inventario.api.marca;

import com.sistema.inventario.api.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45,nullable = false, unique = true)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "marca_id")
    private List<Categoria> categorias = new ArrayList<>();



    public Marca(Integer id, String nombre, List<Categoria> categorias) {
        this.id = id;
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Marca(Integer id) {
        this.id = id;
    }

    public Marca(String nombre, List<Categoria> categorias) {
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public Marca() {
    }



}
