package com.darkmode.tema4.controllers;

import com.darkmode.tema4.dto.CarDTO;
import com.darkmode.tema4.dto.DarkModeDTO;
import com.darkmode.tema4.dto.ResponseDTO;
import com.darkmode.tema4.services.CarService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")

    public ResponseEntity<ResponseDTO> getAllCars(@CookieValue(value = "darkmode", defaultValue = "false") String darkModeValue) {
        boolean darkMode = Boolean.parseBoolean(darkModeValue);
        List<CarDTO> cars = carService.getAllCars();
        return ResponseEntity.ok(new ResponseDTO(darkMode, cars));
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<Void> setDarkMode(@RequestBody DarkModeDTO darkModeDTO, HttpServletResponse response) {
        Cookie darkModeCookie = new Cookie("darkmode", String.valueOf(darkModeDTO.isDarkMode()));
        response.addCookie(darkModeCookie);

        return ResponseEntity.ok().build();
    }


}
