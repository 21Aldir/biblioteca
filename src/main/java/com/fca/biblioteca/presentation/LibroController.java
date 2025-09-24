package com.fca.biblioteca.presentation;

import com.fca.biblioteca.data.Libro;
import com.fca.biblioteca.domain.LibroDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LibroController {

    private LibroDomain libroDomain;

    LibroController(LibroDomain libroDomain) {
        this.libroDomain = libroDomain;
    }


    @RequestMapping(value = "/libros", method = RequestMethod.GET)
    @ResponseBody
    public List<Libro> buscarLibrosPorTitulo(
            @RequestParam String titulo,
            @RequestParam String edicion) {
        return libroDomain.buscarLibros(titulo, edicion);
    }


    @RequestMapping(value = "/libro", method = RequestMethod.GET)
    @ResponseBody
    public List<Libro> buscarLibroPorTitulo(
            @RequestParam String titulo,
            @RequestParam String edicion) {
        return libroDomain.buscarLibroPorTitulo(titulo, edicion);
    }


    @RequestMapping(value = "/libros-disponibles", method = RequestMethod.GET)
    @ResponseBody
    public List<Libro> buscarLibrosDisponibles(
            @RequestParam String titulo,
            @RequestParam String edicion) {
        return libroDomain.buscarLibrosDisponibles(titulo, edicion);
    }
}
