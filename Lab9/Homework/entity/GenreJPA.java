package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "GenreJPA.findByName", query = "SELECT g FROM GenreJPA g WHERE g.name LIKE :name"),
        @NamedQuery(name = "GenreJPA.findAll", query = "SELECT g from GenreJPA g"),
        @NamedQuery(name = "GenreJPA.findById", query = "SELECT g from GenreJPA g WHERE g.id = :id")
})

public class GenreJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public GenreJPA() {
        this.albums = new ArrayList<>();
    }

    public GenreJPA(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreJPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "album_genres",
            joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"))
    private List<AlbumJPA> albums;

    public List<AlbumJPA> getAlbums() {
        return albums;
    }

}
