package com.fca.biblioteca.domain;

import com.fca.biblioteca.data.Libro;
import com.fca.biblioteca.data.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroDomain {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> buscarLibroPorTitulo(String titulo, String edicion){
        return libroRepository.findAll()
                .stream()
                .filter(Libro -> Libro.getTitulo().equals(titulo))
                .filter( Libro -> Libro.getEdicion().equals(edicion))
                .collect(Collectors.toList());
    }

}
