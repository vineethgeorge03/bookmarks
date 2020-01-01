package com.demo.bookmarks.dao;

import com.demo.bookmarks.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Autowired
    public ClientDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Client> getAll() {
        Session currentSession = this.getSession();
        Query<Client> query =  currentSession.createQuery("from Client", Client.class);

        return query.getResultList();
    }

    @Override
    public Client get(int id) {
        Session currentSession = this.getSession();
        return currentSession.get(Client.class, id);
    }

    @Override
    public Client save(Client client) {
        Session currentSession = this.getSession();
        currentSession.saveOrUpdate(client);
        return client;

    }

    @Override
    public void delete(int userId) {
        Session currentSession = this.getSession();
        Client client = currentSession.get(Client.class , userId);
        currentSession.delete(client);
        /* for cascading the above methods should be used*/
        /*Query<Client> query = currentSession.createQuery("delete from Client where id=:id");
        query.setParameter("id", userId);
        query.executeUpdate();*/
    }
}
