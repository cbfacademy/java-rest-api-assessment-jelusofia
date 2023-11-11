package com.cbfacademy.apiassessment.api;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import com.cbfacademy.apiassessment.model.Client;
import com.cbfacademy.apiassessment.service.ClientService;

@RequestMapping("api/v1/pnlcalculator")
@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService =clientService;
    }

    @PostMapping
    public void addClient( @Validated @NonNull @RequestBody Client client){
        clientService.addClient(client);
    }
    //@valid and @nonnull not working

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") UUID id) {
        return clientService.getClientById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteClientById(@PathVariable("id") UUID id) {
        clientService.deleteClient(id);
    }
    @PutMapping(path = "{id}")
    public void updateClient(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody Client clientToUpdate ) {
        clientService.updateClient(id, clientToUpdate);
    }



    
}
