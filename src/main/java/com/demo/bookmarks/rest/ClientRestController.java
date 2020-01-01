package com.demo.bookmarks.rest;

import com.demo.bookmarks.dao.ClientDao;
import com.demo.bookmarks.entity.Client;
import com.demo.bookmarks.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getAll() {
        // return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
        return clientService.getAll();
    }

    @PostMapping("/clients")
    public Client save(@RequestBody Client client) {
        clientService.save(client);
        return client;
    }

    @GetMapping("/clients/{clientId}")
    public Client get(@PathVariable int clientId) {
        Client client =  clientService.get(clientId);
        return client;
    }

    @DeleteMapping("/clients/{clientId}")
    public void delete(@PathVariable int clientId) {
        clientService.delete(clientId);
    }

}
