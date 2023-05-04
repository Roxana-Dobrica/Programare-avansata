package lab8homework;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class ExtractDataset {

    public static void main(String[] args) throws Exception {
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Roxana\\Downloads\\archive\\albumlist.csv"));
            String[] nextLine;
            nextLine = reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                Connection conn = ConnectionPool.getConnection();
                AlbumDAO albumDAO = new AlbumDAO();
                if (albumDAO.findByTitleArtistYear(nextLine[2], nextLine[3], Integer.parseInt(nextLine[1])) == null) {
                    albumDAO.create(Integer.parseInt(nextLine[1]), nextLine[2], nextLine[3], nextLine[4]);
                }
                String genre = nextLine[4];
                GenreDAO genreDAO = new GenreDAO();
                List<String> genres = List.of(genre.split(","));
                for (String genreName : genres) {
                    if (genreDAO.findByName(genreName) == null) {
                        genreDAO.create(genreName);
                    }
                }
                String artist = nextLine[3];
                ArtistDAO artistDAO = new ArtistDAO();
                if (artistDAO.findByName(artist) == null) {
                    artistDAO.create(artist);
                }

                System.out.println("Album " + nextLine[2] + " added to the database");
                conn.close();
            }
            var albums = new AlbumDAO();
            System.out.println("All the albums: " + albums.findAll());
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
