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
@Table(name = "usuarios_colonias")
public class usuariosColonias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long usuarioId;

    @Column(name = "colonia_id", nullable = false)
    private Long coloniaId;

    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;

    @PrePersist
    protected void onCreate() { fechaRegistro = new Date(); }

    @PreUpdate
    protected void onUpdate() { fechaRegistro = new Date(); }
}

