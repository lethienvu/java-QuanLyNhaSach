package DAL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DTO.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author thienvu
 */
public class PhieuNhapDAL {
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
    public Vector<PhieuNhapDTO> getAllPhieuNhap(){
        Vector<PhieuNhapDTO> listPhieuNhap = new Vector<PhieuNhapDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM PhieuNhap WHERE TinhTrang = 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    PhieuNhapDTO phieuNhap = new PhieuNhapDTO();
                    phieuNhap.setMaPN(rs.getString("MaPN"));
                    phieuNhap.setMaNCC(rs.getString("MaNCC"));
                    phieuNhap.setMaNV(rs.getString("MaNV"));
                    phieuNhap.setTongTien(rs.getInt("TongTien"));
                    phieuNhap.setNgayNhap(rs.getString("NgayNhap"));
                    listPhieuNhap.add(phieuNhap);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return listPhieuNhap;
    }
    public boolean addPhieuNhap(PhieuNhapDTO phieuNhap){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "INSERT INTO PhieuNhap VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, phieuNhap.getMaPN());
                stmt.setString(2, phieuNhap.getMaNCC());
                stmt.setString(3, phieuNhap.getMaNV());
                stmt.setString(4, phieuNhap.getNgayNhap());
                stmt.setInt(5, phieuNhap.getTongTien());
                stmt.setInt(6, phieuNhap.getTinhTrang());
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
                String query = "SELECT * FROM PhieuNhap WHERE MaPN = ?";
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
    public boolean updatePhieuNhap(PhieuNhapDTO phieuNhap){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE PhieuNhap SET MaNCC = ?, MaNV = ?, NgayNhap = ? WHERE MaPN = " + phieuNhap.getMaPN();
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, phieuNhap.getMaNCC());
                stmt.setString(2, phieuNhap.getMaNV());
                stmt.setString(3, phieuNhap.getNgayNhap());
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
    public boolean deletePhieuNhap(String id){
        boolean result = false;
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "UPDATE PhieuNhap SET TinhTrang = 0 WHERE MaPN = ?";
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
                String query = "SELECT * FROM PhieuNhap ORDER BY MaPN DESC LIMIT 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                id = rs.getString("MaPN");
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return id;
    }
}
