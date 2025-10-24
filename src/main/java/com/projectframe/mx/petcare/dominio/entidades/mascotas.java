package com.projectframe.mx.petcare.dominio.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mascotas")
public class mascotas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 50)
    private String especie;

    @Column(length = 100)
    private String raza;

    private Integer edad;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Genero genero = Genero.Macho;

    @Column(length = 100)
    private Double peso;

    private Boolean vacunado = false;

    private Boolean esterilizado = false;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 255)
    private String imagen;

    @Column(name = "user_id", nullable = false)
    private Long usuarioId;

    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;

    private Boolean tieneSeguro = false;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaRegistro = new Date();
    }

    public enum Genero {
        Macho, Hembra
    }
}

