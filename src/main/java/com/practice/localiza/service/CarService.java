package com.practice.localiza.service;

import com.practice.localiza.entity.Car;
import com.practice.localiza.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        return this.carRepository.save(car);
    }

    public Car findById(Long id) {
        if (id == 1){
            Car car = new Car();
            car.setId(id);
            return car;
        } else return null;
    }

    public Car update(Long id, Car carNovosDados) {


        Car carroExistente = this.findById(id);
        carroExistente.setName(carNovosDados.getName());
        carroExistente.setColor(carNovosDados.getColor());
        carroExistente.setPrice(carNovosDados.getPrice());
        carroExistente.setBrand(carNovosDados.getBrand());
        carroExistente.setManufactureYear(carNovosDados.getManufactureYear());
        carroExistente.setCarStatus(carNovosDados.isCarStatus());
        return this.carRepository.save(carroExistente);
    }

    public Car softDelete(Long id) {
        Car carroParaInativar = this.findById(id);
        carroParaInativar.setCarStatus(false);
        return this.carRepository.save(carroParaInativar);
    }
}
