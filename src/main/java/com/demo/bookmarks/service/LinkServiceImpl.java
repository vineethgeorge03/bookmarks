package com.demo.bookmarks.service;

import com.demo.bookmarks.dao.FolderDao;
import com.demo.bookmarks.dao.LinkDao;
import com.demo.bookmarks.entity.Folder;
import com.demo.bookmarks.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    private LinkDao linkDao;
    private FolderDao folderDao;

    @Autowired
    public LinkServiceImpl(LinkDao linkDao, FolderDao folderDao) {
        this.linkDao = linkDao;
        this.folderDao = folderDao;
    }

    @Override
    @Transactional
    public List<Link> getLinksInFolder(int folderId) {
        return this.linkDao.getLinksInFolder(folderId);
    }

    @Override
    @Transactional
    public Link save(int folderId, Link link) {
        Folder folder = folderDao.get(folderId);
        folder.addLink(link);
        folderDao.update(folder);
        return link;
    }

    @Override
    @Transactional
    public void delete(int linkId) {
        linkDao.delete(linkId);
    }
}
