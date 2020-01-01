package com.demo.bookmarks.dao;

import com.demo.bookmarks.entity.Link;

import java.util.List;

public interface LinkDao {
    List<Link> getLinksInFolder(int folderId);
    Link save(Link link);
    void delete(int linkId);
}
