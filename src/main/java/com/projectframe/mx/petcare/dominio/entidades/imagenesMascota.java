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
@Table(name = "imagenes_mascota")
public class imagenesMascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mascota_id", nullable = false)
    private Long mascotaId;

    @Column(nullable = false, length = 255)
    private String ruta;

    @Column(name = "fecha_subida", nullable = false)
    private Date fechaSubida;

    @PrePersist
    public void prePersist() {
        fechaSubida = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        fechaSubida = new Date();
    }
}
