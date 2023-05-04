package lab8homework;

import java.sql.*;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String args[]) {
        try {
            var artists = new ArtistDAO();
            /*artists.create("Pink Floyd");
            artists.create("Michael Jackson");*/
            var genres = new GenreDAO();
            /*genres.create("Rock");
            genres.create("Funk");
            genres.create("Soul");
            genres.create("Pop");
            Database.getConnection().commit();*/
            var albums = new AlbumDAO();
            /*albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "Thriller", "Michael Jackson", "Funk,Soul,Pop");
            Database.getConnection().commit();*/
            System.out.println("Albums:");
            System.out.println("Finding the albums with the name 'The Wall': " + albums.findByTitle("The Wall"));
            System.out.println("Finding the albums with the name 'Thriller': " + albums.findByTitle("Thriller"));
            System.out.println("All the albums: " + albums.findAll());

            System.out.println("Genres:");
            System.out.println("Finding the genre with the id=2: " + genres.findById(2));
            System.out.println("Finding the genre with the name 'Folk' " + genres.findByName("Folk"));
            System.out.println("All the genres: " + genres.findAll());
            
            System.out.println("Artists:");
            System.out.println("Finding the artists with the id-1: " + artists.findById(1));
            System.out.println("Finding the artists with the name-Michael Jackson: " + artists.findByName("Michael Jackson"));
            ConnectionPool.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
