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
@Table(name = "posts")
public class posts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long usuarioId;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    @Column(length = 255)
    private String imagen;

    @Column(name = "likes_count")
    private Integer likesCount = 0;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "colonia_id")
    private Long coloniaId;

    @PrePersist
    protected void onCreate() { createdAt = new Date(); }

    @PreUpdate
    protected void onUpdate() { createdAt = new Date(); }
}

