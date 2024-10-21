package org.example.cargotransportation_24;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Entity
public class Cargoes {
    private Long id;
    @Getter
    private String name;
    @Getter
    private String content;
    @Getter
    private String sendingCity;
    @Getter
    private LocalDate sendingDate;
    @Getter
    private String receiptCity;
    @Getter
    private LocalDate receiptDate;

    protected Cargoes() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cargo [id=" + id + ", name=" + name + ", content=" + content + ", sending city=" + sendingCity +
                ", sending date=" + sendingDate + ", city of receipt=" + receiptCity + ", date of receipt=" + receiptDate + "]";
    }
}
