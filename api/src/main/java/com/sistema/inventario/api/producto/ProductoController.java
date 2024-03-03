package com.sistema.inventario.api.producto;

import com.sistema.inventario.api.categoria.Categoria;
import com.sistema.inventario.api.categoria.CategoriaRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping("/productos/nuevo")
    public String MostrarFormularioDeNuevoProducto(Model model){
        List<Categoria> listaCategoria = categoriaRepository.findAll();

        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategoria", listaCategoria);
        return "producto_formulario";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(Producto producto, HttpServletRequest request){
        String[] detallesID = request.getParameterValues("detallesID");
        String[] detallesNombre = request.getParameterValues("detallesNombre");
        String[] detallesValor = request.getParameterValues("detallesValor");

        for(int i = 0; i < detallesNombre.length; i++){
            if (detallesID != null && detallesID.length >0){
                producto.setDetalle(Integer.valueOf(detallesID[i]),detallesNombre[i],detallesValor[i]);
            }else{
                producto.añadirDetalles(detallesNombre[i],detallesValor[i]);
            }
        }


        productoRepository.save(producto);
        return "redirect:/";

    }

    @GetMapping("/productos")
    public String listarProductos(Model model){
        List<Producto> listaProductos =productoRepository.findAll();
        model.addAttribute("listaProductos", listaProductos);
        return "productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioDeModificarProducto(@PathVariable ("id") Integer id, Model model){
        Producto producto = productoRepository.findById(id).get();
        model.addAttribute("producto", producto);

        List<Categoria> listaCategoria = categoriaRepository.findAll();
        model.addAttribute("listaCategoria", listaCategoria);
        return "producto_formulario";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Integer id, Model model){
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }






}
