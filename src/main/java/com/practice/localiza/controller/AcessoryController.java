package com.practice.localiza.controller;
import java.util.List;

import com.practice.localiza.entity.Acessory;
import com.practice.localiza.service.AcessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/acessory")
@CrossOrigin("*")
public class AcessoryController {

    @Autowired
    private AcessoryService acessoryService;

    @GetMapping("/findAll/{numPage}/{qtdePerPage}")
    public ResponseEntity<Page<Acessory>> findAll(
            @PathVariable("numPage") int numPage,
            @PathVariable("qtdePerPage") int qtdePerPage){
        Page<Acessory> lista = this.acessoryService.findAll(numPage, qtdePerPage);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findByNome")
    public ResponseEntity<List<Acessory>> findByNome(@RequestParam("name") String name){
        List<Acessory> lista = this.acessoryService.findByName(name);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id){
        try {
            Acessory acessory = this.acessoryService.findById(id);
            return new ResponseEntity<>(acessory, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Error finding accessory", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id){
        String mensage = this.acessoryService.deleteById(id);
        return new ResponseEntity<>(mensage, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Acessory acessory){
        try{
            Acessory savedAcc = acessoryService.save(acessory);
            return new ResponseEntity<>("Acessory saved successfully", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error on saving",  HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Acessory acessory, @PathVariable("id") long id){
        String mensage = this.acessoryService.update(acessory, id);
        return new ResponseEntity<>(mensage, HttpStatus.OK);
    }

}