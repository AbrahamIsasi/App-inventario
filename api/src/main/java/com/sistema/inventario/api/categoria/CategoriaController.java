package com.sistema.inventario.api.categoria;

import com.sistema.inventario.api.categoria.Categoria;
import com.sistema.inventario.api.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping("/categorias")
    public String listaCategorias(Model model){
        List<Categoria> listaCategorias = repository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }

    @GetMapping("/categorias/nuevo")
    public String mostrarFormularioDeNuevaCategoria(Model model){
      model.addAttribute("categoria", new Categoria());
      return "categoria_formulario";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria){
        repository.save(categoria);
        return "redirect:/categorias";
    }

}
