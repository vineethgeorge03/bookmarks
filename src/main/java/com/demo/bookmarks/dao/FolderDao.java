package com.demo.bookmarks.dao;

import com.demo.bookmarks.entity.Folder;

import java.util.List;

public interface FolderDao {
    List<Folder> getFoldersOfClient(int clientId);
    void update(Folder folder);
    Folder get(int folderId);
    void delete(int folderId);
}

