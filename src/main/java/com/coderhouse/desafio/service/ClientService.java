package com.coderhouse.desafio.service;

import com.coderhouse.desafio.model.Client;
import com.coderhouse.desafio.model.ClientDTO;
import com.coderhouse.desafio.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client postClient(Client client) throws Exception {
        return clientRepository.save(client);
    }

    public ClientDTO getClient(int id) throws Exception {
       Optional<Client> cliente = clientRepository.findById(id);
       if (cliente.isPresent()){
           // si el cliente existe guardo la edad en el clientDTO mediante un constructor
           LocalDate birthDate = cliente.get().getBirthDate();
           int edad = this.calculateAge(birthDate, LocalDate.now());
           return new ClientDTO(cliente.get().getName(), cliente.get().getLastName(), edad);
        }
       throw new Exception(); // si no existe lanza un exception
    }

    // creo un metodo que calcule la edad del cliente
    private int calculateAge(
            LocalDate birthDate,
            LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }
}
