package com.demo.bookmarks.service;

import com.demo.bookmarks.dao.ClientDao;
import com.demo.bookmarks.entity.Client;
import com.demo.bookmarks.rest.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl  implements ClientService{

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public List<Client> getAll() {
        return this.clientDao.getAll();
    }

    @Override
    @Transactional
    public Client get(int clientId) {
        Client client = this.clientDao.get(clientId);
        if(client == null) {
            throw new EntityNotFoundException("Client not found - " + clientId);
        }
        return client;
    }

    @Override
    @Transactional
    public Client save(Client client) {
        return this.clientDao.save(client);
    }

    @Override
    @Transactional
    public void delete(int clientId) {
        this.clientDao.delete(clientId);
    }
}
