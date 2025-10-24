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
@Table(name = "likes_colonia")
public class likesColonia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "post_colonia_id", nullable = false)
    private Long postColoniaId;

    @Column(name = "created_at", nullable = false)
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

