package com.ezbainer.sistemareservas;

import com.ezbainer.sistemareservas.model.Usuario;
import com.ezbainer.sistemareservas.model.Rol;
import com.ezbainer.sistemareservas.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SistemaReservasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaReservasApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsuarioRepository usuarioRepository) {
        return (args) -> {

            Usuario u = new Usuario(
                    "1134567890",
                    "test123",
                    Rol.ADMIN,
                    LocalDate.now(),
                    "Eze",
                    "eze@example.com"
            );

            usuarioRepository.save(u);

            System.out.println("Usuario guardado: " + u.getId());
        };
    }
}
