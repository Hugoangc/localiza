package com.practice.localiza.controller;

import com.practice.localiza.entity.Car;
import com.practice.localiza.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Car car) {
        try {
            Car savedCar = carService.save(car);
            return  new ResponseEntity<>(savedCar.getId().toString(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Error on saving",  HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        try {
            Car car = this.carService.findById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car carNovosDados) {
        try {
            Car carroAtualizado = this.carService.update(id, carNovosDados);
            return new ResponseEntity<>(carroAtualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable Long id) {
        try {
            Car carroInativado = this.carService.softDelete(id);
            return ResponseEntity.ok(carroInativado);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
