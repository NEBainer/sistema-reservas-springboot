package com.ezbainer.sistemareservas.dto;

import com.ezbainer.sistemareservas.model.Rol;

import java.time.LocalDate;

public class UsuarioResponseDTO {

    private Long id;
    private String telefono;
    private String nombre;
    private String email;
    private Rol rol;
    private LocalDate fechaDeIngreso;

    public UsuarioResponseDTO(Long id, String telefono, String nombre,
                              String email, Rol rol, LocalDate fechaDeIngreso) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    // getters
    public Long getId(){
        return id;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }

    public Rol getRol(){
        return rol;
    }

    public LocalDate getFechaDeIngreso(){
        return fechaDeIngreso;
    }
}
