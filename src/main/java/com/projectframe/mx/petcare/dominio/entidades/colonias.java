package com.projectframe.mx.petcare.dominio.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "colonias")
public class colonias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(name = "codigo_invitacion", nullable = false, length = 10, unique = true)
    private String codigoInvitacion;

    @Column(name = "user_id", nullable = false)
    private Long userId;
}

