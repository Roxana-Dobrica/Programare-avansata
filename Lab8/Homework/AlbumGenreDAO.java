package lab8homework;

import java.sql.*;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class AlbumGenreDAO {

    public void create(int id1, int id2) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        if (find(id1, id2) == null) {

            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into album_genre (album_id,genre_id) values (?,?)")) {
                pstmt.setInt(1, id1);
                pstmt.setInt(2, id2);
                pstmt.executeUpdate();
            }

        }
        con.close();
    }

    public RelationshipAlbumGenre find(int albumId, int genreId) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("select * from album_genre where album_id=? and genre_id=?");
            stmt.setInt(1, albumId);
            stmt.setInt(2, genreId);
            ResultSet rs = stmt.executeQuery();
            List<Integer> albumGenre = List.of(rs.getInt(1), rs.getInt(2));
            con.close();
            if (rs.next()) {
                return new RelationshipAlbumGenre(rs.getInt(1), new AlbumDAO().findById(rs.getInt(2)), new GenreDAO().findById(rs.getInt(3)));
            } else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
}
