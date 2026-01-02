package com.ezbainer.sistemareservas.controller;
import com.ezbainer.sistemareservas.dto.UsuarioResponseDTO;
import com.ezbainer.sistemareservas.dto.UsuarioRequestDTO;
import com.ezbainer.sistemareservas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;


import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //GET /usuarios -> lista todos
    @GetMapping
    public List<UsuarioResponseDTO> obtenerTodos(){
        return usuarioService.obtenerTodos();
    }

    //GET /usuarios/{id} -> obtener uno por id
    @GetMapping("/{id}")
    public UsuarioResponseDTO obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    //POST /usuarios -> crea uno nuevo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO crearUsuario(@Valid @RequestBody UsuarioRequestDTO dto) {
        return usuarioService.crearUsuario(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarUsuario(@PathVariable Long id) {
        usuarioService.borrarUsuario(id);
    }


}
