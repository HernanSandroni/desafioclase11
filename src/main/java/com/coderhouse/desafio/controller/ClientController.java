package com.coderhouse.desafio.controller;

import com.coderhouse.desafio.middleware.ResponseHandler;
import com.coderhouse.desafio.model.Client;
import com.coderhouse.desafio.model.ClientDTO;
import com.coderhouse.desafio.service.ClientService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //Creo al Cliente
    @PostMapping
    public ResponseEntity<Object> postClient (@RequestBody Client client) {
        try {
            System.out.println(client);
            Client clientSave = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client stored successfully",
                    HttpStatus.OK,
                    clientSave
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    //Creo un Get para buscar al cliente por id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClient(@PathVariable int id){
        try{
            System.out.println(id);
            ClientDTO clientDTO = clientService.getClient(id);
            System.out.println(clientDTO);
            return ResponseHandler.generateResponse(
                    "Client retrieved successfully",
                    HttpStatus.OK,
                    clientDTO
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}
