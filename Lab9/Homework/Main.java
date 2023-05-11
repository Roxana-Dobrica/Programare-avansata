package org.example;

import org.example.entity.GenreJPA;
import org.example.repository.GenreRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtistJPA");
// -----------------------------------------
//        ArtistRepository artistRepository = new ArtistRepository(emf);
//
//        //System.out.println(artistRepository.findByName("AC"));
//
//        //System.out.println(artistRepository.findById(50L));
//
//        ArtistJPA artist = artistRepository.findById(1L);
//        artistRepository.create(artist);
//
//
//        artist.getAlbums().forEach(System.out::println);
//        //ArtistJPA persistedArtist = artistRepository.findById(artist.getId());
//        //System.out.println(persistedArtist);
//
//        artistRepository.close();

//---------------------------------------
//        AlbumRepository albumRepository = new AlbumRepository(emf);
//        System.out.println(albumRepository.findById(5L));
//        System.out.println("---------------------------------------");
//
//        AlbumJPA album = albumRepository.findById(5L);
//
//        System.out.println(album.getGenres());
//        System.out.println("---------------------------------------");
//
//        System.out.println(album.getArtist());
//
//        //System.out.println(albumRepository.findByTitle("album"));
//
//        albumRepository.close();
// -----------------------------------------
        GenreRepository genreRepository = new GenreRepository(emf);
        System.out.println(genreRepository.findById(1L));
        System.out.println("---------------------------------------");

        GenreJPA genre = genreRepository.findById(1L);

        System.out.println(genre.getAlbums());
        //System.out.println(genreRepository.findByName("ro"));

        genreRepository.close();

// -----------------------------------------


    }
}