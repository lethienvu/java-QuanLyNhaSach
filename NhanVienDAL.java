package DAL;

import DTO.NhanVienDTO;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class NhanVienDAL{
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
    
    public Vector<NhanVienDTO> getAllNhanVien(){
        Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
        if(openConnection()){
            try{
                String sql = "SELECT * FROM NhanVien";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    NhanVienDTO nv = new NhanVienDTO();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setHoDem(rs.getString("HoDem"));
                    nv.setTen(rs.getString("Ten"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setNgaySinh(rs.getString("NgaySinh")); 
                    nv.setGioiTinh(rs.getString("GioiTinh"));
                    nv.setEmail(rs.getString("Email"));
                    nv.setSdt(rs.getString("DienThoai"));
                    nv.setTrangThai(rs.getInt("TinhTrang"));
                    arr.add(nv);
                }
            }catch(SQLException ex){
                System.out.println(ex+"2");
            }finally{ closeConnection();}
        }
        return arr;
    }
    

    public String getLastID(){
        String txt_final =null;
        if(openConnection()){
            try{
                String sql ="SELECT MaNV FROM NhanVien ORDER BY MaNV DESC LIMIT 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);               
                if(rs.next()){
                    String arg = rs.getString("MaNV");
                    int a = arg.length();
                    String txt = arg.substring(0, 2);
                    String num = arg.substring(2, a);
                    int n = Integer.parseInt(num);
                    n++;
                    String num_added = Integer.toString(n);
                    if(n<10)
                        txt_final = txt +"000" + num_added;
                    else if(n>10)
                            txt_final = txt + "00" + num_added;
                        else if(n>100)
                                txt_final = txt + "0" + num_added;
                            else if(n>1000)
                                    txt_final = txt + num_added;
                }
                else
                    txt_final = "NV0001";     
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{ closeConnection();}
        }
        return txt_final;
    }
    
    public boolean getNhanVienID(String id){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "SELECT * FROM NhanVien WHERE MaNV =?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                result = rs.next();
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{ closeConnection();}
        }
        return result;
    }   
 
    public boolean addNhanVien(NhanVienDTO nv){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nv.getMaNV());
                stmt.setString(2, nv.getHoDem());
                stmt.setString(3, nv.getTen());
                stmt.setString(4, nv.getDiaChi());
                stmt.setString(5, nv.getNgaySinh()); 
                stmt.setString(6, nv.getGioiTinh());
                stmt.setString(7, nv.getEmail());
                stmt.setString(8, nv.getSdt());
                stmt.setInt(9, nv.getTrangThai());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            }catch(SQLException ex){
                System.out.println(ex+"3");
            }finally{ closeConnection();}
        }
        return result;
    }
    
    public boolean updateNhanVien(NhanVienDTO nv){
        boolean result = false;
        if(openConnection()){
            try{
                String sql = "UPDATE NhanVien SET HoDem = ?, Ten = ?, DiaChi = ?, NgaySinh = ?, GioiTinh = ?, Email = ?, DienThoai = ? WHERE MaNV = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nv.getHoDem());
                stmt.setString(2, nv.getTen());
                stmt.setString(3, nv.getDiaChi());
                stmt.setString(4, nv.getNgaySinh());
                stmt.setString(5, nv.getGioiTinh());
                stmt.setString(6, nv.getEmail());
                stmt.setString(7, nv.getSdt());
                stmt.setString(8, nv.getMaNV());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            }catch(SQLException ex){
                System.out.println(ex+"4");
            }finally{ closeConnection();}
        }
        return result;
    }
    
    public boolean deleteNhanVien(NhanVienDTO nv){
        boolean result = false;
        if(openConnection()){
            try{
                 String sql = "UPDATE NhanVien SET TinhTrang = 0 WHERE MaNV = ?";
                 PreparedStatement stmt = con.prepareStatement(sql);
                 stmt.setString(1, nv.getMaNV());
                 if(stmt.executeUpdate() >= 1)
                     result = true;                 
            }catch(SQLException ex){
                 System.out.println(ex+"5");
             }finally{ closeConnection();}
        }
        return result;
    }
}



