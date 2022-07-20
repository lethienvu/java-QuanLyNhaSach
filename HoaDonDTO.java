/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.*;

/**
 *
 * @author thienvu
 */
public class HoaDonDTO {
    private String maHD;
    private String maKH;
    private String maNV;
    private int tongTien;
    private String ngayLap;
    private int tinhTrang;
    private Vector<ChiTietHoaDonDTO> CTHD = new Vector<ChiTietHoaDonDTO>();

    public HoaDonDTO() {
        tinhTrang = 1;
    }

    public HoaDonDTO(String maHD, String maKH, String maNV, int tongTien, String ngayLap, int tinhTrang) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
        this.tinhTrang = tinhTrang;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public int getTongTien() {
        return tongTien;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public Vector<ChiTietHoaDonDTO> getCTHD() {
        return CTHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public void setCTHD(Vector<ChiTietHoaDonDTO> CTHD) {
        this.CTHD = CTHD;
    }
    
}
