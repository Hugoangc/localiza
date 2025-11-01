package com.practice.localiza.repository;

import com.practice.localiza.entity.Brand;
import com.practice.localiza.entity.Car;
import com.practice.localiza.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    public List<Car> findByBrand(Brand brand);

    public List<Car> findByOwners(List<Owner> owners);
    public List<Car> findByName(String name);
    public List<Car> findByBrandName(String name);
//    @Query("SELECT c FROM Car c WHERE c.manufactureYear >= :manufactureYear")

    @Query("FROM Car c WHERE c.manufactureYear >= :manufactureYear and c.carStatus = true")
    public List<Car> findByYearGte(Integer manufactureYear);
}
