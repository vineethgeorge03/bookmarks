package com.demo.bookmarks.dao;

import com.demo.bookmarks.entity.Link;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LinkDaoImpl implements LinkDao {

    private EntityManager entityManager;
    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public LinkDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Link> getLinksInFolder(int folderId) {
        Session currentSession = this.getSession();
        Query<Link> query = currentSession.createQuery("from Link where folder_id=:folderId");
        query.setParameter("folderId",folderId);
        return query.getResultList();
    }

    @Override
    public Link save(Link link) {
        /***
         * the method is not used at all
         */
        /* saving will be automatically done when the user updates itself inturn updating the folder too*/
        return null;
    }

    @Override
    public void delete(int linkId) {
        Session currentSession = this.getSession();
        Query<Link> theQuery = currentSession.createQuery("delete from Link where id=:linkId");
        theQuery.setParameter("linkId",linkId);
        System.out.println(theQuery.toString());
        theQuery.executeUpdate();
    }
}
