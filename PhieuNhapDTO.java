/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author thienvu
 */
public class PhieuNhapDTO {
    private String maPN;
    private String maNCC;
    private String maNV;
    private String ngayNhap;
    private int tongTien;
    private int tinhTrang;

    public PhieuNhapDTO() {
    }

    public PhieuNhapDTO(String maPN, String maNCC, String maNV, String ngayNhap, int tongTien, int tinhTrang) {
        this.maPN = maPN;
        this.maNCC = maNCC;
        this.maNV = maNV;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
    }

    public String getMaPN() {
        return maPN;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
