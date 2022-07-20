/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author thienvu
 */
public class TaiKhoanDTO {
    private String maTK;
    private String username;
    private String password;
    private int tinhTrang = 1;
    private String maNV;

    public TaiKhoanDTO() {
    }

    public TaiKhoanDTO(String maTK, String username, String password) {
        this.maTK = maTK;
        this.username = username;
        this.password = password;
    }

    public TaiKhoanDTO(String maTK, String username, String password, int tinhTrang, String maNV) {
        this.maTK = maTK;
        this.username = username;
        this.password = password;
        this.tinhTrang = tinhTrang;
        this.maNV = maNV;
    }

    public String getMaTK() {
        return maTK;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    
}
