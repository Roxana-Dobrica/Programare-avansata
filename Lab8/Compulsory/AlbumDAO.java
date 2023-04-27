package com.mycompany.lab8compulsory;

import java.sql.*;

/**
 *
 * @author Roxana Dobrica
 */
public class AlbumDAO {
    public void create(int release_year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist, genre) values (?,?,?,?)")) {
            pstmt.setInt(1, release_year);
            pstmt.setString(2, title);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }
    
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from albums where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    
    public String findByArtist(String artist) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from albums where artist='" + artist + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public String findByGenre(String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from albums where genre='" + genre + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public void printAllAlbums() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }
        }
    }

}
