/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ChiTietHoaDonDTO;
import java.sql.*;
import java.util.*;
import DTO.*;

/**
 *
 * @author thienvu
 */
public class ChiTietHoaDonDAL {
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
    public Vector<ChiTietHoaDonDTO> getChiTietHoaDonList(String id){
        Vector<ChiTietHoaDonDTO> cthdList = new Vector<ChiTietHoaDonDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT cthd.MaHD, cthd.MaSP, sp.TenSP, cthd.DonGia, cthd.SoLuong, cthd.ThanhTien FROM ChiTietHoaDon cthd INNER JOIN SanPham sp ON cthd.MaSP = sp.MaSP WHERE MaHD = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                    cthd.setMaHD(rs.getString("MaHD"));
                    cthd.setMaSP(rs.getString("MaSP"));
                    cthd.setTenSP(rs.getString("TenSP"));
                    cthd.setDonGia(rs.getInt("DonGia"));
                    cthd.setSoLuong(rs.getInt("SoLuong"));
                    cthd.setThanhTien(rs.getInt("ThanhTien"));
                    cthdList.add(cthd);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return cthdList;
    }
    public boolean themChiTietHoaDon(ChiTietHoaDonDTO cthd){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "INSERT INTO ChiTietHoaDon VALUES(?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, cthd.getMaHD());
                stmt.setString(2, cthd.getMaSP());
                stmt.setInt(3, cthd.getDonGia());
                stmt.setInt(4, cthd.getSoLuong());
                stmt.setInt(5, cthd.getThanhTien());
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
    public SanPhamDTO getSanPhamInfo(String id){
        SanPhamDTO sp = new SanPhamDTO();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM SanPham WHERE MaSP = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setGiaBan(rs.getInt("GiaBan"));
                    sp.setSoLuong(rs.getInt("SoLuong"));
                }
            } catch (SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }            
        }
        return sp;
    }
    public void capNhatSoLuong(ChiTietHoaDonDTO cthd){
        SanPhamDTO sp = getSanPhamInfo(cthd.getMaSP());
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE SanPham SET SoLuong = " + (sp.getSoLuong() - cthd.getSoLuong()) + " WHERE MaSP = '" + cthd.getMaSP() + "'";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
    }
    public KhachHangDTO getKhachHangInfo(String soDT){
        KhachHangDTO kh = new KhachHangDTO();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM KhachHang WHERE DienThoai = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, soDT);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    kh.setMaKH(rs.getString("MaKH"));
                    kh.setHoDem(rs.getString("HoDem"));
                    kh.setTen(rs.getString("Ten"));
                }
            } catch (SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }            
        }
        return kh;
    }
    public boolean existKhachHangID(String soDT){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM KhachHang WHERE DienThoai = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, soDT);
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
    
    public boolean existID(String id){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM SanPham WHERE MaSP = ?";
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
