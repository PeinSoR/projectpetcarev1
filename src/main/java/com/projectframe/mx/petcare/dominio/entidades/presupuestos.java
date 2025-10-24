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
@Table(name = "presupuestos")
public class presupuestos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false, length = 7)
    private String mes;

    @Column(nullable = false)
    private Double monto;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() { createdAt = new Date(); }

    @PreUpdate
    protected void onUpdate() { createdAt = new Date(); }
}
