package org.example.test;

import org.example.entity.AlbumJPA;
import org.example.entity.ArtistJPA;
import org.example.repository.AlbumRepository;
import org.example.repository.ArtistRepository;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeDataSetTest {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtistJPA");

    private static ArtistRepository artistRepository;

    private static AlbumRepository albumRepository;

    @BeforeAll
    public static void setup() {
        artistRepository = new ArtistRepository(emf);
        albumRepository = new AlbumRepository(emf);
    }

    @AfterAll
    public static void tearDown() {
        artistRepository.close();
        albumRepository.close();
    }

    @Test
    @DisplayName("Insert fake data")
    void insertFakeData(){
        Instant start = Instant.now();

        List<ArtistJPA> artists = new ArrayList<>();
        List<AlbumJPA> albums = new ArrayList<>();

        for(int i = 0; i < 100; i++)
        {
            ArtistJPA artist = new ArtistJPA("Artist " + i);
            artists.add(artist);
            //artistRepository.create(artist);
        }

        Random random = new Random();
        for(ArtistJPA artist : artists)
        {
            AlbumJPA album = new AlbumJPA(2000 + random.nextInt(31), "Album " + artist.getName(), artist.getId());
            albums.add(album);
            //albumRepository.create(album);
        }

        Instant finish = Instant.now();

        System.out.println("Inserted 100 artists and 100 albums in " + Duration.between(start, finish).toMillis() + " milliseconds");

        Assertions.assertEquals(100, artists.size());
        Assertions.assertEquals(100, albums.size());
    }
}
