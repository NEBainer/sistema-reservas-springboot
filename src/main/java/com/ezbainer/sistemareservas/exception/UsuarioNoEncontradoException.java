package com.ezbainer.sistemareservas.exception;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(Long id) {
        super("Usuario no encontrado (id=" + id + ")");
    }
}