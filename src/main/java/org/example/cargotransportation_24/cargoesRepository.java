package org.example.barbershop_23;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface barbershopRepository extends JpaRepository<Clients, Long> {
    @Query("SELECT p FROM Clients p WHERE CONCAT(p.clientName, '', p.date, '', p.service) LIKE %?1%")
    List<Clients> search(String keyword);
}
