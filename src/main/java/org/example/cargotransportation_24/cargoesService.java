package org.example.barbershop_23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class barbershopService {

    @Autowired
    private barbershopRepository repo;

    public List<Clients> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public Clients get(Long id) {
        return repo.findById(id).get();
    }

    public void save(Clients client) {
        repo.save(client);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Clients> getAllClientsSorted(Sort sort) {
        return repo.findAll(sort);
    }
}
