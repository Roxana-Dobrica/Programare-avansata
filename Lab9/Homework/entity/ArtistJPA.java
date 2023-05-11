package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "ArtistJPA.findByName", query = "SELECT a FROM ArtistJPA a WHERE a.name LIKE :name"),
        @NamedQuery(name = "ArtistJPA.findAll", query = "SELECT a from ArtistJPA a"),
        @NamedQuery(name = "ArtistJPA.findById", query = "select a from ArtistJPA a where a.id = :id")
})

public class ArtistJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public ArtistJPA() {
        this.albums = new ArrayList<>();
    }
    public ArtistJPA(String name) {
        this.name = name;
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
        return "ArtistJPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "albums",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<AlbumJPA> albums;

    public List<AlbumJPA> getAlbums() {
        return albums;
    }

}


