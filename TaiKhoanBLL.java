/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DTO.*;
import DAL.*;
import java.util.Vector;
/**
 *
 * @author thienvu
 */
public class TaiKhoanBLL {
    TaiKhoanDAL taiKhoanDAL = new TaiKhoanDAL();
    public Vector<TaiKhoanDTO> getAllTaiKhoan(){
        return taiKhoanDAL.getAllTaiKhoan();
    }
    public String addTaiKhoan(TaiKhoanDTO taiKhoan){
        if(taiKhoanDAL.existID(taiKhoan.getMaTK()))
            return "Mã tài khoản đã tồn tại!";
        if(taiKhoanDAL.addTaiKhoan(taiKhoan))
            return "Đã thêm tài khoản. Mã tài khoản là: " + taiKhoan.getMaTK();
        return "Không thể thêm tài khoản. Vui lòng kiểm tra lại!";
    }
    public String updateTaiKhoan(String id, String pass){
        if(taiKhoanDAL.updateTaiKhoan(id, pass))
            return "Đã cập nhật thành công!";
        return "Cập nhật thất bại!";
    }
    public boolean deleteTaiKhoan(String id){
        return taiKhoanDAL.deleteTaiKhoan(id);
    }
    public boolean existID(String id){
        return taiKhoanDAL.existID(id);
    }
    public String taoIDTuDong(){
        String id = taiKhoanDAL.maLonNhat();
        int i = Integer.valueOf(id.substring(2));
        i++;
        if (i < 10)
            return "TK" + "00000" + i;
        else if (i >= 10 && i < 100)
                return "TK" + "0000" + i;
            else if (i >= 100 && i < 1000)
                    return "TK" + "000" + i;
                else
                    if (i >= 1000 && i < 10000)
                        return "TK" + "00" + i;
                    else
                        if(i >= 10000 && i < 100000)
                            return "TK" + "0" + i;
                         else
                            return "TK" + i;
    }
    public boolean kiemTraMaTKOfNV(String id){
        return taiKhoanDAL.kiemTraMaTKOfNV(id);
    }
    public void setMaTK(String maTK, String maNV){
        taiKhoanDAL.setMaTK(maTK, maNV);
    }
    public boolean checkMV(String id){
        return taiKhoanDAL.checkMaNV(id);
    }
    public String getMaNV(String user, String pass){
        return taiKhoanDAL.getMaNV(user, pass);
    }
    public boolean checkLogin(String name, String pass){
        return taiKhoanDAL.checkLogin(name, pass);
    }
}
