/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author thienvu
 */
public class TaiKhoanDAL {
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
    public Vector<TaiKhoanDTO> getAllTaiKhoan(){
        Vector<TaiKhoanDTO> listTaiKhoan = new Vector<TaiKhoanDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT tk.MaTK, tk.Username, tk.Password, nv.MaNV FROM TaiKhoan tk INNER JOIN NhanVien nv ON tk.MaTK = nv.MaTK WHERE tk.TinhTrang = 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    TaiKhoanDTO taiKhoan = new TaiKhoanDTO();
                    taiKhoan.setMaTK(rs.getString("MaTK"));
                    taiKhoan.setMaNV(rs.getString("MaNV"));
                    taiKhoan.setUsername(rs.getString("Username"));
                    taiKhoan.setPassword(rs.getString("Password"));
                    listTaiKhoan.add(taiKhoan);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return listTaiKhoan;
    }
    public boolean addTaiKhoan(TaiKhoanDTO taiKhoan){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "INSERT INTO TaiKhoan VALUES(?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, taiKhoan.getMaTK());
                stmt.setString(2, taiKhoan.getUsername());
                stmt.setString(3, taiKhoan.getPassword());
                stmt.setInt(4, taiKhoan.getTinhTrang());
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
    public boolean updateTaiKhoan(String id, String pass){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE TaiKhoan SET Password = ? WHERE MaTK = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                stmt.setString(2, pass);
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
    public boolean deleteTaiKhoan(String id){
        boolean result = false;
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "UPDATE TaiKhoan SET TinhTrang = 0 WHERE MaTK = ?";
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
    public boolean checkLogin(String user, String pass){
        boolean result = false;
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "SELECT * FROM TaiKhoan WHERE Username = ? AND Password = ? AND TinhTrang = 1";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, user);
                stmt.setString(2, pass);
                ResultSet rs = stmt.executeQuery();
                result = rs.next();
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
    public String getMaNV(String user, String pass){
        String maNV = "";
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "SELECT nv.MaNV FROM TaiKhoan tk INNER JOIN NhanVien nv ON tk.MaTK = nv.MaTK WHERE tk.Username = ? AND tk.Password = ? AND tk.TinhTrang = 1";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, user);
                stmt.setString(2, pass);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                maNV = rs.getString("MaNV");
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return maNV;
    }
    public boolean existID(String id){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM TaiKhoan WHERE MaTK = ?";
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
    public String maLonNhat(){  //tìm trong database, trả về mã mới/lớn nhất
        String id = "";
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "SELECT * FROM TaiKhoan ORDER BY MaTK DESC LIMIT 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                id = rs.getString("MaTK");
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return id;
    }
    public boolean kiemTraMaTKOfNV(String id){  //kiểm tra xem nhân viên đã có tài khoản hay chưa
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM NhanVien WHERE MaNV = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                if(rs.getString("MaTK") != null && !rs.getString("MaTK").trim().equals(""))
                    result = true;
            } catch (SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }            
        }
        return result;
    }
    public void setMaTK(String maTK, String maNV){
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE NhanVien SET MaTK = ? WHERE MaNV = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, maTK);
                stmt.setString(2, maNV);
                stmt.executeUpdate();
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
    }
    public boolean checkMaNV(String id){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM NhanVien WHERE MaNV = ?";
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
}
