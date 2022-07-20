/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author thienvu
 */
public class LoaiSanPhamDTO {
    private String maLoai;
    private String tenLoai;
    private int tinhTrang;

    public LoaiSanPhamDTO() {
    }

    public LoaiSanPhamDTO(String maLoai, String tenLoai, int tinhTrang) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.tinhTrang = tinhTrang;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}
