package org.example.entity;

import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "AlbumJPA.findByTitle", query = "SELECT a FROM AlbumJPA a WHERE a.title LIKE :title"),
        @NamedQuery(name = "AlbumJPA.findAll", query = "SELECT a from AlbumJPA a"),
        @NamedQuery(name = "AlbumJPA.findByArtist", query = "select a from AlbumJPA a where a.artistId = :artistId"),
        @NamedQuery(name = "AlbumJPA.findById", query = "select a from AlbumJPA a where a.id = :id")
})
public class AlbumJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "title")
    private String title;

    @Column(name = "artist_id")
    private Long artistId;

    public AlbumJPA() {
        this.genres = new ArrayList<>();
    }

    public AlbumJPA(int releaseYear, String title, Long artistId) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artistId = artistId;
        this.genres = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "AlbumJPA{" +
                "id=" + id +
                ", release_year='" + releaseYear + '\'' +
                ", title='" + title + '\'' +
                ", artist_id='" + artistId + '\'' +
                '}';
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "artists",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "artist_id"))
    private ArtistJPA artist;

    public ArtistJPA getArtist() {
        return artist;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "album_genres",
            joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    private List<GenreJPA> genres;

    public List<GenreJPA> getGenres() {
        return genres;
    }
}


