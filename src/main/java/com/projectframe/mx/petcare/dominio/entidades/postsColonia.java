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
@Table(name = "posts_colonia")
public class postsColonia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long usuarioId;

    @Column(name = "colonia_id", nullable = false)
    private Long coloniaId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "created_at", nullable = false)
    private Date fechaCreacion;

    @Column(name = "es_alerta")
    private Boolean esAlerta = false;

    @PrePersist
    protected void onCreate() { fechaCreacion = new Date(); }

    @PreUpdate
    protected void onUpdate() { fechaCreacion = new Date(); }
}

