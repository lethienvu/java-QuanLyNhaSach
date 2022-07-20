/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author thienvu
 */
public class KhachHangDTO {
    private String maKH;
    private String hoDem;
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private int gioiTinh;
    private String email;
    private String soDT;

    public KhachHangDTO() {
    }

    public KhachHangDTO(String maKH, String hoDem, String ten, String diaChi, String ngaySinh, int gioiTinh, String email, String soDT) {
        this.maKH = maKH;
        this.hoDem = hoDem;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.soDT = soDT;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getHoDem() {
        return hoDem;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    
}
