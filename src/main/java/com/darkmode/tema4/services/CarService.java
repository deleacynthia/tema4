package com.darkmode.tema4.services;

import com.darkmode.tema4.dto.CarDTO;
import com.darkmode.tema4.models.Car;
import com.darkmode.tema4.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public List<CarDTO> getAllCars(){
        List<Car> cars = carRepository.findAll();
        List<CarDTO> carsDTO = new ArrayList<>();
        for (Car car : cars) {
            carsDTO.add(new CarDTO(car.getName(), car.getModel()));
        }
        return carsDTO;
    }
}
