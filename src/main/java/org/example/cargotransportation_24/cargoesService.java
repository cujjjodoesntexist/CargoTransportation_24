package org.example.cargotransportation_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cargoesService {
    @Autowired
    private cargoesRepository repo;

    public List<Cargoes> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public Cargoes get(Long id) {
        return repo.findById(id).get();
    }

    public void save(Cargoes cargo) {
        repo.save(cargo);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Cargoes> getAllCargoesSorted(Sort sort) {
        return repo.findAll(sort);
    }
}
