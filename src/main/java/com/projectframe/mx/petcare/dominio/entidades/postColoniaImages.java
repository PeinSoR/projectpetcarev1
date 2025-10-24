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
@Table(name = "post_colonia_images")
public class postColoniaImages implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_colonia_id", nullable = false)
    private Long postColoniaId;

    @Column(name = "image_path", length = 255)
    private String imagePath;

    @Column(name = "created_at", nullable = false)
    private Date fechaCreacion;

    @Column(name = "user_id", nullable = false)
    private Long usuarioId;

    @PrePersist
    protected void onCreate() { fechaCreacion = new Date(); }

    @PreUpdate
    protected void onUpdate() { fechaCreacion = new Date(); }
}

