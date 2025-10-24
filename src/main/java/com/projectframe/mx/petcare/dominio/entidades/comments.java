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
@Table(name = "comments")
public class comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @PrePersist
    public void prePersist() {
        fechaCreacion = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        fechaCreacion = new Date();
    }
}

