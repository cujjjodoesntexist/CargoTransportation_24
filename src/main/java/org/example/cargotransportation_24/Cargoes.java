package org.example.cargotransportation_24;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
public class Cargoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String sendingCity;
    private LocalDate sendingDate;
    private String receiptCity;
    private LocalDate receiptDate;

    protected Cargoes() {}
}
