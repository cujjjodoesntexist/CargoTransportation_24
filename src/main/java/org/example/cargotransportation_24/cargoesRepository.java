package org.example.cargotransportation_24;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface cargoesRepository extends JpaRepository<Cargoes, Long> {
    @Query("SELECT p FROM Cargoes p WHERE CONCAT(p.name, '', p.content, '', p.sendingCity, '', p.receiptCity) LIKE %?1%")
    List<Cargoes> search(String keyword);
}
