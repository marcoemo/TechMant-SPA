package com.example.Catalogo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Catalogo.model.Catalogo;
import com.example.Catalogo.service.CatalogoService;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {

    private final CatalogoService CS;
    public CatalogoController(CatalogoService CS){
        this.CS=CS;
    }
    @GetMapping
    public List<Catalogo> listaCatalogo(){
        return CS.obtenerCatalogo();
    }


}
