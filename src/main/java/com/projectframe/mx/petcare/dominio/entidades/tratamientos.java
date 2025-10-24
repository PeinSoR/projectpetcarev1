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
@Table(name = "tratamientos")
public class tratamientos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "mascota_id", nullable = false)
    private Long mascotaId;

    @Column(name = "tipo_tratamiento", nullable = false, length = 100)
    private String tipoTratamiento;

    @Column(nullable = false)
    private Date fecha;

    @Column(length = 100)
    private String veterinario;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Double costo;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        createdAt = new Date();
    }
}

