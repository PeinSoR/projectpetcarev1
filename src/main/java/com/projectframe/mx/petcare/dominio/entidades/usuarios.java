package com.projectframe.mx.petcare.dominio.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class usuarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long idUsuario;

    // Considera el uso de @NotBlank y @JoinColumn para datos no vacios y relaciones entre entidades
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Considera el uso de @Email para validaciones de email
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "curp", nullable = false, length = 18)
    private String curp;

    @Column(name = "telefono_celular", nullable = false, length = 15)
    private String telefonoCelular;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", length = 20)
    private TipoUsuario tipo = TipoUsuario.Dueño;

    @Column(name = "verificado")
    private Boolean verificado = false;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @Column(name = "foto_perfil")
    private String fotoPerfil;

    @Column(name = "foto_portada")
    private String fotoPortada;

    @ManyToOne
    @JoinColumn(name = "colonia_id")
    private colonias colonia;

    // Enum para tipo de usuario
    public enum TipoUsuario {
        Dueño, Refugio, Empresa, Veterinario
    }
}
