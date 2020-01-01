package com.demo.bookmarks.dao;

import com.demo.bookmarks.entity.Client;

import java.util.List;

public interface ClientDao {

    List<Client> getAll() ;

    Client get(int clientId);

    Client save(Client client);

    void delete(int clientId);

}
