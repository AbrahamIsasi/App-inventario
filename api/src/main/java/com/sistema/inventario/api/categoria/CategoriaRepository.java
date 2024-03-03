package com.sistema.inventario.api.categoria;

import com.sistema.inventario.api.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
