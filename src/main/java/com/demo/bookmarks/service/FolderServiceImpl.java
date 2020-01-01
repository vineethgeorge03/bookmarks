package com.demo.bookmarks.service;

import com.demo.bookmarks.dao.ClientDao;
import com.demo.bookmarks.dao.FolderDao;
import com.demo.bookmarks.entity.Client;
import com.demo.bookmarks.entity.Folder;
import com.demo.bookmarks.rest.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    private FolderDao folderDao;
    private ClientService clientService;

    @Autowired
    public FolderServiceImpl(FolderDao folderDao, ClientService clientService) {
        this.folderDao = folderDao;
        this.clientService = clientService;
    }

    @Override
    @Transactional
    public List<Folder> getFoldersOfClient(int clientId) {

        return  folderDao.getFoldersOfClient(clientId);
    }

    @Override
    @Transactional
    public Folder add(
            int clientId,
            Folder folder) {
        Client client = clientService.get(clientId);
        client.addFolder(folder);
        clientService.save(client);
        return folder;
    }

    @Override
    @Transactional
    public void update(Folder folder) {
        folderDao.update(folder);
    }


    @Override
    @Transactional
    public Folder get(int folderId) {
        Folder folder =  folderDao.get(folderId);
        if(folder == null) {
            throw new EntityNotFoundException("folder not found - " + folderId);
        }
        return folder;
    }

    @Override
    @Transactional
    public void delete(int folderId) {
        folderDao.delete(folderId);
    }
}
