/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.*;
import java.sql.*;
import java.util.*;
import java.time.*;
/**
 *
 * @author thienvu
 */
public class HoaDonDAL {
    private Connection con;
    public Connection openConnection(){
        try{
            Class.forName(DatabaseInfo.driverName);
            con = DriverManager.getConnection(DatabaseInfo.dbUrl, DatabaseInfo.username, DatabaseInfo.password);
        }catch (ClassNotFoundException | SQLException ex){
            System.err.println("Kết nối CSDL thất bại" + ex.getMessage());
        }
        return con;
    }
    public void closeConnection(){
        try {
            if (con != null)
                con.close();
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
    }
    public Vector<HoaDonDTO> getAllHoaDon(){
        Vector<HoaDonDTO> listHoaDon = new Vector<HoaDonDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM HoaDon WHERE TinhTrang = 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    HoaDonDTO hoaDon = new HoaDonDTO();
                    hoaDon.setMaHD(rs.getString("MaHD"));
                    hoaDon.setMaKH(rs.getString("MaKH"));
                    hoaDon.setMaNV(rs.getString("MaNV"));
                    hoaDon.setTongTien(rs.getInt("TongTien"));
                    hoaDon.setNgayLap(rs.getString("NgayLap"));
                    listHoaDon.add(hoaDon);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return listHoaDon;
    }
    public boolean addHoaDon(HoaDonDTO hoaDon){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "INSERT INTO HoaDon VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, hoaDon.getMaHD());
                stmt.setString(2, hoaDon.getMaKH());
                stmt.setString(3, hoaDon.getMaNV());
                stmt.setString(4, hoaDon.getNgayLap());
                stmt.setInt(5, hoaDon.getTongTien());
                stmt.setInt(6, hoaDon.getTinhTrang());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
    public boolean existID(String id){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM HoaDon WHERE MaHD = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                result = rs.next();
            } catch (SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }            
        }
        return result;
    }
    public boolean updateHoaDon(HoaDonDTO hoaDon){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE HoaDon SET MaKH = ?, MaNV = ?, NgayLap = ? WHERE MaHD = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, hoaDon.getMaKH());
                stmt.setString(2, hoaDon.getMaNV());
                stmt.setString(3, hoaDon.getNgayLap());
                stmt.setString(4, hoaDon.getMaHD());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
    public boolean deleteHoaDon(String id){
        boolean result = false;
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "UPDATE HoaDon SET TinhTrang = 0 WHERE MaHD = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
    public String maLonNhat(){  //tìm trong database, trả về mã mới/lớn nhất
        String id = "";
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "SELECT * FROM HoaDon ORDER BY MaHD DESC LIMIT 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                id = rs.getString("MaHD");
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return id;
    }
}
