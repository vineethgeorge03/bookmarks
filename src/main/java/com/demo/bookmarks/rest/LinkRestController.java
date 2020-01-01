package com.demo.bookmarks.rest;

import com.demo.bookmarks.entity.Link;
import com.demo.bookmarks.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LinkRestController {
    private LinkService linkService;

    @Autowired
    public LinkRestController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/links/{folderId}")
    public List<Link> getAll(@PathVariable int folderId) {
        return linkService.getLinksInFolder(folderId);
    }


    @PostMapping("links/{folderId}")
    public Link add(@PathVariable int folderId, @RequestBody Link link) {
        return linkService.save(folderId,link);
    }

    @DeleteMapping("links/{linkId}")
    public void delete( @PathVariable int linkId) {
        linkService.delete(linkId);
    }

}
