package org.example.barbershop_23;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Entity
public class Clients {
    private Long id;
    @Getter
    private String clientName;
    @Getter
    private LocalDate date;
    @Getter
    private String service;
    @Getter
    private String master;

    protected Clients() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "barbershop [id=" + id + ", client name=" + clientName + ", date=" + date + ", service=" + service + ", master=" + master +"]";
    }
}
