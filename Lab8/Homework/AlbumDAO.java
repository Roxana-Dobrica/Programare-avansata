package lab8homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class AlbumDAO {

    public void create(int year, String title, String artist, String genre) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist, genre) values (?,?,?,?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
        ArtistDAO artistDAO = new ArtistDAO();
        if (artistDAO.findByName(artist) == null) {
            artistDAO.create(artist);
        }
        GenreDAO genreDAO = new GenreDAO();
        AlbumGenreDAO albumToGenreDAO = new AlbumGenreDAO();
        List<String> genres = List.of(genre.split(","));
        for (String genreName : genres) {
            if (genreDAO.findByName(genreName) == null) {
                genreDAO.create(genreName);
                albumToGenreDAO.create(findByTitleArtistYear(title, artist, year), genreDAO.findByName(genreName).getId());
            }
        }
        con.close();
    }

    public List<Album> findAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select * from albums");
            rs = stmt.executeQuery();
            List<Album> albums = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                String artist = rs.getString("artist");
                List<String> genres = List.of(rs.getString("genre").split(","));
                List<Genre> genresList = new ArrayList<>();
                GenreDAO genreDAO = new GenreDAO();
                for (String genre : genres) {
                    genresList.add(genreDAO.findByName(genre));
                }
                Artist artist1 = new ArtistDAO().findByName(artist);
                Album album = new Album(id, title, artist1, releaseYear, genresList);
                albums.add(album);
            }
            return albums;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public List<Album> findByTitle(String title) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select id,release_year,artist,genre from albums where title=?");
            stmt.setString(1, title);
            rs = stmt.executeQuery();
            List<Album> albums = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String artist = rs.getString("artist");
                List<String> genres = List.of(rs.getString("genre").split(","));
                List<Genre> genresList = new ArrayList<>();
                GenreDAO genreDAO = new GenreDAO();
                for (String genre : genres) {
                    genresList.add(genreDAO.findByName(genre));
                }
                Artist artist1 = new ArtistDAO().findByName(artist);
                Album album = new Album(id, title, artist1, releaseYear, genresList);
                albums.add(album);
                return albums;
            }
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public List<Album> findByArtist(String artist) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select * from albums where artist='" + artist + "'")) {
            List<Album> albums = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int releaseYear = rs.getInt("release_year");
                String title = rs.getString("title");
                List<String> genres = List.of(rs.getString("genre").split(","));
                List<Genre> genresList = new ArrayList<>();
                GenreDAO genreDAO = new GenreDAO();
                for (String genre : genres) {
                    ;
                    genresList.add(genreDAO.findByName(genre));
                }
                Artist artist1 = new ArtistDAO().findByName(artist);
                Album album = new Album(id, title, artist1, releaseYear, genresList);
                albums.add(album);
            }
            con.close();
            return albums;
        }
    }

    public Album findById(int id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(
                "select * from albums where id=" + id)) {
            con.close();
            if (rs.next()) {
                List<Genre> genres = new ArrayList<>();
                String[] genresString = rs.getString("genre").split(",");
                for (String genre : genresString) {
                    genres.add(new GenreDAO().findByName(genre));
                }
                return new Album(id, rs.getString("title"), new ArtistDAO().findById(rs.getInt("artist")), rs.getInt("release_year"), genres);
            } else {
                return null;
            }

        }
    }

    public Integer findByTitleArtistYear(String title, String artist, int year) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("select id from albums where title=? and artist=? and release_year=?");
            stmt.setString(1, title);
            stmt.setString(2, artist);
            stmt.setInt(3, year);
            rs = stmt.executeQuery();
            return rs.next() ? rs.getInt(1) : null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
