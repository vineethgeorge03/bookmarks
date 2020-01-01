package com.demo.bookmarks.service;

import com.demo.bookmarks.entity.Link;

import java.util.List;

public interface LinkService {
    List<Link> getLinksInFolder( int folderId);
    Link save(int folderId, Link link);
    void delete(int linkId);
}
