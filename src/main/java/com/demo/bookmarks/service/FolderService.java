package com.demo.bookmarks.service;

import com.demo.bookmarks.entity.Folder;

import java.util.List;

public interface FolderService {
    List<Folder> getFoldersOfClient(int clientId);
    Folder get(int folderId);
    void update(Folder folder);
    Folder add(int clientId, Folder folder);
    void delete(int folderId);
}
