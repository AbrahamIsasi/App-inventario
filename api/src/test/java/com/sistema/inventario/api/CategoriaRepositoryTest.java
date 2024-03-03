package com.sistema.inventario.api;

import com.sistema.inventario.api.categoria.Categoria;
import com.sistema.inventario.api.categoria.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@DataJpaTest
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testCrearCategoria(){
        Categoria categoriaGuardada = categoriaRepository.save(new Categoria("electronicos"));
        assertThat(categoriaGuardada.getId()).isGreaterThan(0);

    }







}
