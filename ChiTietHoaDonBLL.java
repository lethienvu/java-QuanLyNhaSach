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
public class ChiTietHoaDonBLL {
    ChiTietHoaDonDAL cthdDAL = new ChiTietHoaDonDAL();
    public Vector<ChiTietHoaDonDTO> getChiTietHoaDonList(String id){
        return cthdDAL.getChiTietHoaDonList(id);
    }
    public boolean themChiTietHoaDon(ChiTietHoaDonDTO cthd){
        return cthdDAL.themChiTietHoaDon(cthd);
    }
    public boolean existID(String id){
        return cthdDAL.existID(id);
    }
    public SanPhamDTO getSanPhamInfo(String id){
        return cthdDAL.getSanPhamInfo(id);
    }
    public boolean existKhachHangID(String soDT){
        return cthdDAL.existKhachHangID(soDT);
    }
    public KhachHangDTO getKhachHangInfo(String soDT){
        return cthdDAL.getKhachHangInfo(soDT);
    }
    public void capNhatSoLuong(ChiTietHoaDonDTO cthd){
        cthdDAL.capNhatSoLuong(cthd);
    }
}
