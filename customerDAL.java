package DAL;

import DTO.customerDTO;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class customerDAL {
    private Connection con;
    
    public boolean openConnection(){
        try{
            Class.forName(DatabaseInfo.driverName);
            con = DriverManager.getConnection(DatabaseInfo.dbUrl, DatabaseInfo.username, DatabaseInfo.password);
            return true;
        }catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
    public void closeConnection(){
        try{
            if(con != null)
                con.close();
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public Vector<customerDTO> getAllCustomers(){
        Vector<customerDTO> arr = new Vector<customerDTO>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM KhachHang";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    customerDTO cus = new customerDTO();
                    cus.setMaKH(rs.getString("MaKH"));
                    cus.setHoDem(rs.getString("HoDem"));
                    cus.setTen(rs.getString("Ten"));
                    cus.setDiaChi(rs.getString("DiaChi"));
                    cus.setNgaySinh(rs.getString("NgaySinh")); 
                    cus.setGioiTinh(rs.getString("GioiTinh"));
                    cus.setEmail(rs.getString("Email"));
                    cus.setDienThoai(rs.getString("DienThoai"));
                    cus.setTinhTrang(rs.getInt("TinhTrang"));
                    arr.add(cus);
                }
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return arr;
    }
    
    public boolean hasCustomerID(String id){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                result = rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    
    public boolean addCustomer(customerDTO cus){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO KhachHang VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cus.getMaKH());
                stmt.setString(2, cus.getHoDem());
                stmt.setString(3, cus.getTen());
                stmt.setString(4, cus.getDiaChi());
                stmt.setString(5, cus.getNgaySinh()); 
                stmt.setString(6, cus.getGioiTinh());
                stmt.setString(7, cus.getEmail());
                stmt.setString(8, cus.getDienThoai());
                stmt.setInt(9, cus.getTinhTrang());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }

    public boolean updateCustomer(customerDTO cus){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "UPDATE KhachHang SET HoDem = ?, Ten = ?, DiaChi = ?, NgaySinh = ?, GioiTinh = ?, Email = ?, DienThoai = ? WHERE MaKH = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cus.getHoDem());
                stmt.setString(2, cus.getTen());
                stmt.setString(3, cus.getDiaChi());
                stmt.setString(4, cus.getNgaySinh());
                stmt.setString(5, cus.getGioiTinh());
                stmt.setString(6, cus.getEmail());
                stmt.setString(7, cus.getDienThoai());
               // stmt.setInt(8, cus.getTinhTrang());
                stmt.setString(8, cus.getMaKH());               
                if(stmt.executeUpdate() >= 1)
                   result = true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
    public boolean deleteCustomer(customerDTO cus){
        boolean result = false;
        if(openConnection()){
            try{
               // String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
               String sql = "UPDATE KhachHang SET TinhTrang = 0 WHERE MaKH = ?"; 
               PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, cus.getMaKH());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                closeConnection();
            }
        }
        return result;
    }
}
