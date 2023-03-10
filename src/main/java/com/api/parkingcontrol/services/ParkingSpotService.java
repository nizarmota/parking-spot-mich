package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

///Pode ser injetado utilizando um @Autowired, porem foi injetado usando o construtor
    final ParkingSpotRepository parkingSpotRepository;
///Na injeção de dependência via construtor, as dependências de uma classe são fornecidas por meio de um construtor. Isso significa que as dependências são passadas como parâmetros no momento da criação do objeto.
// Essa técnica é muito útil quando uma classe tem várias dependências e pode ajudar a simplificar a criação de objetos e torná-los mais testáveis.
    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }




    @Transactional
    public ParkingSpotModel salvar(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }


    public Page<ParkingSpotModel> getAllParkingSpots(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }


    public Optional<ParkingSpotModel> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void deletar(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
