package com.practice.localiza.service;

import java.util.List;
import com.practice.localiza.entity.Acessory;
import com.practice.localiza.repository.AcessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class AcessoryService {

    @Autowired
    private AcessoryRepository acessoryRepository;

    public Page<Acessory> findAll(int numPage, int qtdePerPage){

        PageRequest config = PageRequest.of(numPage-1, qtdePerPage);

        return this.acessoryRepository.findAll(config);
    }

    public Acessory findById(long id) {
        return this.acessoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Accessory not found"));
    }

    public List<Acessory> findByName(String name) {
        return this.acessoryRepository.findByNameContainingIgnoreCase(name);
    }

    public Acessory save(Acessory acessory) {
        return this.acessoryRepository.save(acessory);

    }

    public String update(Acessory acessory, long id) {
        Acessory existingAcessory = this.findById(id);
        existingAcessory.setName(acessory.getName());
        existingAcessory.setDescription(acessory.getDescription());
        this.acessoryRepository.save(existingAcessory);

        return "Acessory updated successfully";
    }

    public String deleteById(long id) {
        this.acessoryRepository.deleteById(id);
        return "Acessory deleted successfully";
    }

}