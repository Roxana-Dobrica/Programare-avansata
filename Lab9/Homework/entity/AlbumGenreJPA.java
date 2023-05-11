package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="album_genres")
public class AlbumGenreJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumJPA albumId;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreJPA genreId;

    public AlbumGenreJPA(){}

    public AlbumGenreJPA(AlbumJPA albumId, GenreJPA genreId) {
        this.albumId = albumId;
        this.genreId = genreId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlbumId() {
        return albumId.getId();
    }

    public Long getGenreId() {
        return genreId.getId();
    }

    @Override
    public String toString() {
        return "AlbumGenreJPA{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", genreId=" + genreId +
                '}';
    }
}



