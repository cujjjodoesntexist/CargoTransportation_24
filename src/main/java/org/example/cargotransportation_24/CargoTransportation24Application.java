package org.example.cargotransportation_24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CargoTransportation24Application {

    public static void main(String[] args) {
        SpringApplication.run(CargoTransportation24Application.class, args);
    }

}
