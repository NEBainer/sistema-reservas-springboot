package com.ezbainer.sistemareservas.service;

import com.ezbainer.sistemareservas.dto.UsuarioRequestDTO;
import com.ezbainer.sistemareservas.dto.UsuarioResponseDTO;
import com.ezbainer.sistemareservas.exception.UsuarioNoEncontradoException;
import com.ezbainer.sistemareservas.model.Usuario;
import com.ezbainer.sistemareservas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public UsuarioResponseDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));

        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {

        // validación simple (opcional, ya la tenés por @Valid)
        if (!dto.getTelefono().matches("\\d+")) {
            throw new IllegalArgumentException("El teléfono debe contener solo números");
        }

        Usuario usuario = new Usuario(
                dto.getTelefono(),   // 👈 String
                dto.getPassword(),
                dto.getRol(),
                LocalDate.now(),
                dto.getNombre(),
                dto.getEmail()
        );

        return toResponseDTO(usuarioRepository.save(usuario));
    }

    public void borrarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNoEncontradoException(id);
        }
        usuarioRepository.deleteById(id);
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getTelefono(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol(),
                usuario.getFechaDeIngreso()
        );
    }
}
