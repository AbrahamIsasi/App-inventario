package com.sistema.inventario.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {


    @GetMapping("")
    public String seePagInit(){
        return "index";
    }
}
