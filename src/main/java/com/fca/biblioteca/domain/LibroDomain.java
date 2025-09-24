package com.fca.biblioteca.domain;

import com.fca.biblioteca.data.Libro;
import com.fca.biblioteca.data.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LibroDomain {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> buscarLibroPorTitulo(String titulo, String edicion){
        if (titulo == null || titulo.isEmpty() || edicion == null || edicion.isEmpty()){
            return new ArrayList<>();
        }
        Predicate<Libro> filtroTitulo = libro -> libro.getTitulo().equals(titulo);
        Predicate<Libro> filtroEdicion = libro -> libro.getEdicion().equals(edicion);
        Predicate<Libro> disponible = libro -> libro.getExistencia() > 0;
        Predicate<Libro> filtroLibro=  filtroTitulo.and(filtroEdicion).and(disponible);

        return libroRepository.findAll()
                .stream()
                .filter(Libro -> Libro.getTitulo().equals(titulo))
                .filter( Libro -> Libro.getEdicion().equals(edicion))
                .filter(filtroLibro)
                .collect(Collectors.toList());
    }

    public List<Libro> buscarLibros(String titulo, String edicion) {
        if (titulo == null || titulo.isEmpty() || edicion == null || edicion.isEmpty()){
            return new ArrayList<>();
        }

        Predicate <Libro> filtroTitulo = Libro -> Libro.getTitulo().equals(titulo);
        Predicate <Libro> filtroEdicion = Libro -> Libro.getEdicion().equals(edicion);

        Predicate <Libro> filtroLibro = filtroTitulo.and(filtroEdicion);

        return libroRepository.findAll()
                .stream()
                .filter(filtroLibro)
                .collect(Collectors.toList());
    }

    public List<Libro> buscarLibrosDisponibles(String titulo, String edicion) {
        if (titulo == null || titulo.isEmpty() || edicion == null || edicion.isEmpty()){
            return new ArrayList<>();
        }

        Predicate <Libro> filtroTitulo = Libro -> Libro.getTitulo().equals(titulo);
        Predicate <Libro> filtroEdicion = Libro -> Libro.getEdicion().equals(edicion);
        Predicate <Libro> disponible = Libro -> Libro.getExistencia() > 0;

        Predicate <Libro> filtroLibro = filtroTitulo.and(filtroEdicion).and(disponible);

        return libroRepository.findAll()
                .stream()
                .filter(filtroLibro)
                .collect(Collectors.toList());
    }
}