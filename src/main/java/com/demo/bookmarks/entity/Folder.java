package com.demo.bookmarks.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="folders")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="folder_name")
    private String folder_name;

    /*@Column(name="user_id")
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name="user_id")*/

    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="folder_id")
    private List<Link> links;

    public Folder() {
    }

    public Folder(String folder_name) {
        this.folder_name = folder_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolder_name() {
        return folder_name;
    }

    public void setFolder_name(String folder_name) {
        this.folder_name = folder_name;
    }

    public void addLink(Link link) {
        if(this.links == null) {
            this.links = new ArrayList<>();
        }
        this.links.add(link);
    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", folder_name='" + folder_name + '\'' +
                '}';
    }
}
