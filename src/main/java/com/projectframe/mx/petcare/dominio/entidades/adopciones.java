package com.projectframe.mx.petcare.dominio.entidades;

import jakarta.persistence.*;
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
@Table(name = "adopciones")
public class adopciones implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mascota_id", nullable = false)
    private Long mascotaId;

    @Column(name = "usuario_publicador_id", nullable = false)
    private Long usuarioPublicadorId;

    @Column(name = "disponible")
    private Boolean disponible = true;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDateTime fechaPublicacion = LocalDateTime.now();
}
