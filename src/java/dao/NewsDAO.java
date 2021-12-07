/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class NewsDAO extends DBContext {

    public News getTop1News() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Request where dateCreated =(select max(dateCreated) from Request) and status =1";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7));
                return n;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<News> getTop5() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select top 5 * from News where timepost not  in( select max (timepost) from News) order by timepost desc";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<News> list = new ArrayList<>();
            while (rs.next()) {
                News n = new News(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getDate(6), 
                        rs.getString(7));
                list.add(n);

            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int countTotalPage(String txt) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select count (*) from News where title like ?";
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txt + "%");
            rs = ps.executeQuery();
            List<News> list = new ArrayList<>();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public List<News> searchByTitle(String title, int pageIndex, int pageSize) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            String query = "select * from (select ROW_NUMBER() over (order by id asc) as r ,\n"
                    + "  * from News where title like ?) as News\n"
                    + "   where r between (?-1) *?+1 and ?*?";
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + title + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageIndex);
            ps.setInt(5, pageSize);
            rs = ps.executeQuery();
            List<News> list = new ArrayList<>();
            while (rs.next()) {
                News n = new News(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"),
                        rs.getString("author"), 
                        rs.getDate("timePost"),
                        rs.getString("shortDes"));
                list.add(n);

            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public News getNewsById(int id) {
        DBContext db = new DBContext();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from News where id = ?";
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                News n = new News(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("image"), 
                        rs.getString("author"),
                        rs.getDate("timePost"),
                        rs.getString("shortDes"));
                return n;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

  

}
