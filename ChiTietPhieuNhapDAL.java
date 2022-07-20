/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.*;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author thienvu
 */
public class ChiTietPhieuNhapDAL {
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
    public Vector<ChiTietPhieuNhapDTO> getChiTietPhieuNhapList(String id){
        Vector<ChiTietPhieuNhapDTO> ctpnList = new Vector<ChiTietPhieuNhapDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT ctpn.MaPN, ctpn.MaSP, sp.TenSP, ctpn.DonGia, ctpn.SoLuong, ctpn.ThanhTien FROM ChiTietPhieuNhap ctpn INNER JOIN SanPham sp ON ctpn.MaSP = sp.MaSP WHERE MaPN = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, id);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
                    ctpn.setMaPN(rs.getString("MaPN"));
                    ctpn.setMaSP(rs.getString("MaSP"));
                    ctpn.setTenSP(rs.getString("TenSP"));
                    ctpn.setDonGia(rs.getInt("DonGia"));
                    ctpn.setSoLuong(rs.getInt("SoLuong"));
                    ctpn.setThanhTien(rs.getInt("ThanhTien"));
                    ctpnList.add(ctpn);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return ctpnList;
    }
    public boolean themChiTietPhieuNhap(ChiTietPhieuNhapDTO ctpn){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "INSERT INTO ChiTietPhieuNhap VALUES(?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, ctpn.getMaPN());
                stmt.setString(2, ctpn.getMaSP());
                stmt.setInt(3, ctpn.getDonGia());
                stmt.setInt(4, ctpn.getSoLuong());
                stmt.setInt(5, ctpn.getThanhTien());
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
    public Vector<NhaCungCapDTO> getNhaCCList(){
        Vector<NhaCungCapDTO> nccList = new Vector<NhaCungCapDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM NhaCungCap WHERE TinhTrang = 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    NhaCungCapDTO ncc = new NhaCungCapDTO();
                    ncc.setMaNCC(rs.getString("MaNCC"));
                    ncc.setTenNCC(rs.getString("TenNCC"));
                    ncc.setDiaChi(rs.getString("DiaChi"));
                    ncc.setSoDT(rs.getString("DienThoai"));
                    nccList.add(ncc);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return nccList;
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
    public NhaCungCapDTO getNCCInfo(String ten){
        NhaCungCapDTO ncc = new NhaCungCapDTO();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM NhaCungCap WHERE TenNCC = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, ten);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    ncc.setMaNCC(rs.getString("MaNCC"));
                    ncc.setTenNCC(rs.getString("TenNCC"));
                    ncc.setDiaChi(rs.getString("DiaChi"));
                    ncc.setSoDT(rs.getString("DienThoai"));
                }
            } catch (SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }            
        }
        return ncc;
    }
    public void capNhatSoLuong(ChiTietPhieuNhapDTO ctpn){
        SanPhamDTO sp = getSanPhamInfo(ctpn.getMaSP());
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE SanPham SET SoLuong = " + (sp.getSoLuong() + ctpn.getSoLuong()) + " WHERE MaSP = '" + ctpn.getMaSP() + "'";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
    }
}
