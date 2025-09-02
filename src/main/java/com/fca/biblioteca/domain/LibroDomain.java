package com.fca.biblioteca.domain;

import com.fca.biblioteca.data.Libro;
import com.fca.biblioteca.data.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroDomain {
    @Autowired
    private LibroRepository libroRepository;
    private List<Libro> buscarLibroPorTitulo(String titulo){
        return libroRepository.findAll();
    }
}
