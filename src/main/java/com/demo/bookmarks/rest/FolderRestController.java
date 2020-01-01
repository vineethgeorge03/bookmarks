package com.demo.bookmarks.rest;

import com.demo.bookmarks.entity.Folder;
import com.demo.bookmarks.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FolderRestController {

    private FolderService folderService;
    @Autowired
    public FolderRestController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping("/folders/{clientId}")
    public List<Folder> getAll(@PathVariable int clientId)
    {
        return folderService.getFoldersOfClient(clientId);
    }

    @GetMapping("/folders/folder/{folderId}")
    public Folder get(@PathVariable int folderId)
    {
        return folderService.get(folderId);
    }
    @PostMapping("/folders/{clientId}")
    public void addFolder(@PathVariable int clientId,@RequestBody Folder folder) {
        folderService.add(clientId,folder);
    }

    @DeleteMapping("/folders/{folderId}")
    public void delete(@PathVariable int folderId) {
        folderService.delete(folderId);
    }

}
