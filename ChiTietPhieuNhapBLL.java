/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DAL.*;
import DTO.*;
import java.util.*;
/**
 *
 * @author thienvu
 */
public class ChiTietPhieuNhapBLL {
    ChiTietPhieuNhapDAL ctpnDAL = new ChiTietPhieuNhapDAL();
    public Vector<ChiTietPhieuNhapDTO> getChiTietPhieuNhapList(String id){
        return ctpnDAL.getChiTietPhieuNhapList(id);
    }
    public boolean themChiTietPhieuNhap(ChiTietPhieuNhapDTO ctpn){
        return ctpnDAL.themChiTietPhieuNhap(ctpn);
    }
    public boolean existID(String id){
        return ctpnDAL.existID(id);
    }
    public SanPhamDTO getSanPhamInfo(String id){
        return ctpnDAL.getSanPhamInfo(id);
    }
    public boolean existKhachHangID(String soDT){
        return ctpnDAL.existKhachHangID(soDT);
    }
    public Vector<String> listTenNCC(){
        Vector<String> tenNCC = new Vector<String>();
        Vector<NhaCungCapDTO> nccList = ctpnDAL.getNhaCCList();
        for(NhaCungCapDTO ncc : nccList){
            tenNCC.add(ncc.getTenNCC());
        }
        return tenNCC;
    }
    public NhaCungCapDTO getNCCInfo(String ten){
        return ctpnDAL.getNCCInfo(ten);
    }
    public void capNhatSoLuong(ChiTietPhieuNhapDTO ctpn){
        ctpnDAL.capNhatSoLuong(ctpn);
    }
}
