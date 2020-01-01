package com.demo.bookmarks.dao;

import com.demo.bookmarks.entity.Folder;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class FolderDaoImpl implements FolderDao {

    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Autowired
    public FolderDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Folder> getFoldersOfClient(int userId) {
        Session currentSession = this.getSession();
        Query<Folder> query =  currentSession.createQuery("from Folder where user_id=:id", Folder.class);
        query.setParameter("id", userId);
        return query.getResultList();
    }

    /*@Override
    @Transactional
    public Folder add(Folder folder) {
        *//***
         * the method is not used at all
         *//*
        *//* saving will be automatically done when the user updates itself inturn updating the folder too *//*

        Session currentSession = this.getSession();
        currentSession.saveOrUpdate(folder);
        return folder;
    }*/

    @Override
    public Folder get(int folderId) {
        Session currentSession = this.getSession();
        Folder folder = currentSession.get(Folder.class, folderId);
        return folder;
    }

    @Override
    public void delete(int folderId) {
        Session currentSession = this.getSession();
        Folder folder = currentSession.get(Folder.class, folderId);
        currentSession.delete(folder);
    }

    @Override
    public void update(Folder folder) {
        Session currentSession = this.getSession();
        currentSession.update(folder);
    }
}
