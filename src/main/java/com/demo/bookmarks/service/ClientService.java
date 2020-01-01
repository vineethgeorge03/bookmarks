package com.demo.bookmarks.service;

import com.demo.bookmarks.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll() ;

    Client get(int clientId);

    Client save(Client client);

    void delete(int clientId);
}
