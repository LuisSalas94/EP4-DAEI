package com.ep4.fernando.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "tbl_visitas")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false, unique = true)
    private String dni_afiliado;

    @CreationTimestamp
    private LocalDateTime fecha;

    @Column(nullable = false)
    private String hora;

}
