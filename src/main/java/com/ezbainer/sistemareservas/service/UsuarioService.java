package com.ezbainer.sistemareservas.service;
import com.ezbainer.sistemareservas.dto.UsuarioResponseDTO;
import com.ezbainer.sistemareservas.model.Usuario;
import com.ezbainer.sistemareservas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ezbainer.sistemareservas.dto.UsuarioRequestDTO;
import java.util.List;
import java.time.LocalDate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuario no encontrado"
                ));

        return toResponseDTO(usuario);
    }


    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {

        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El email es obligatorio"
            );
        }

        Usuario usuario = new Usuario(
                dto.getTelefono(),
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
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Usuario no encontrado"
            );
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
