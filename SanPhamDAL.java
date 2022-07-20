/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author thienvu
 */
public class SanPhamDAL {
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
    public Vector<SanPhamDTO> getAllSanPham(){
        Vector<SanPhamDTO> listSanPham = new Vector<SanPhamDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM SanPham WHERE TinhTrang = 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    SanPhamDTO sp = new SanPhamDTO();
                    sp.setMaSP(rs.getString("MaSP"));
                    sp.setTenSP(rs.getString("TenSP"));
                    sp.setMaLoai(rs.getString("MaLoai"));
                    sp.setGiaBan(rs.getInt("GiaBan"));
                    sp.setSoLuong(rs.getInt("SoLuong"));
                    sp.setNhaCungCap(rs.getString("NhaCC"));
                    listSanPham.add(sp);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return listSanPham;
    }
    public boolean addSanPham(SanPhamDTO sp){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "INSERT INTO SanPham (MaSP, TenSP, MaLoai, NhaCC, GiaBan, SoLuong, TinhTrang) VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, sp.getMaSP());
                stmt.setString(2, sp.getTenSP());
                stmt.setString(3, sp.getMaLoai());
                stmt.setString(4, sp.getNhaCungCap());
                stmt.setInt(5, sp.getGiaBan());
                stmt.setInt(6, sp.getSoLuong());
                stmt.setInt(7, sp.getTinhTrang());
                if(stmt.executeUpdate() >= 1)
                    result = true;
            } catch (SQLException ex){
                System.out.println("here" + ex);
            } finally{
                closeConnection();
            }
        }
        return result;
    }
    public boolean updateSanPham(SanPhamDTO sp){
        boolean result = false;
        con = openConnection();
        if(con != null){
            try{
                String query = "UPDATE SanPham SET TenSP = ?, GiaBan = ?, MaLoai = ?, SoLuong = ?, NhaCC = ? WHERE MaSP = ? AND TinhTrang = 1";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, sp.getTenSP());
                stmt.setInt(2, sp.getGiaBan());
                stmt.setString(3, sp.getMaLoai()); 
                stmt.setInt(4, sp.getSoLuong());
                stmt.setString(5, sp.getNhaCungCap());
                stmt.setString(6, sp.getMaSP());
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
    public boolean deleteSanPham(String id){
        boolean result = false;
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "UPDATE SanPham SET TinhTrang = 0 WHERE MaSP = ?";
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
                    sp.setMaLoai(rs.getString("MaLoai"));
                    sp.setNhaCungCap(rs.getString("NhaCC"));
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
    public String maLonNhat(){  //tìm trong database, trả về mã mới/lớn nhất
        String id = "";
        con = openConnection();
        if(con != openConnection()){
            try{
                String query = "SELECT * FROM SanPham ORDER BY MaSP DESC LIMIT 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                id = rs.getString("MaSP");
            } catch(SQLException ex){
                System.out.println(ex);
            } finally{
                closeConnection();
            }
        }
        return id;
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
    public Vector<LoaiSanPhamDTO> getTenLoaiSPList(){
        Vector<LoaiSanPhamDTO> tenLoaiList = new Vector<LoaiSanPhamDTO>();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM LoaiSP WHERE TinhTrang = 1";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()){
                    LoaiSanPhamDTO lsp = new LoaiSanPhamDTO();
                    lsp.setMaLoai(rs.getString("MaLoai"));
                    lsp.setTenLoai(rs.getString("TenLoai"));
                    tenLoaiList.add(lsp);
                }
            } catch(SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }
        }
        return tenLoaiList;
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
    public LoaiSanPhamDTO getLoaiSPInfo(String ten){
        LoaiSanPhamDTO lsp = new LoaiSanPhamDTO();
        con = openConnection();
        if(con != null){
            try{
                String query = "SELECT * FROM LoaiSP WHERE TenLoai = ?";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, ten);
                ResultSet rs = stmt.executeQuery();
                if(rs.next()){
                    lsp.setMaLoai(rs.getString("MaLoai"));
                    lsp.setTenLoai(rs.getString("TenLoai"));
                }
            } catch (SQLException ex){
                System.err.println(ex);
            } finally{
                closeConnection();
            }            
        }
        return lsp;
    }
}
