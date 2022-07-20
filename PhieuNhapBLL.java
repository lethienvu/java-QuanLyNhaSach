/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.*;
import DTO.*;
import java.util.Vector;

/**
 *
 * @author thienvu
 */
public class PhieuNhapBLL {
    PhieuNhapDAL phieuNhapDAL = new PhieuNhapDAL();
    public Vector<PhieuNhapDTO> getAllPhieuNhap(){
        return phieuNhapDAL.getAllPhieuNhap();
    }
    public String addPhieuNhap(PhieuNhapDTO phieuNhap){
        if(phieuNhapDAL.existID(phieuNhap.getMaPN()))
            return "Mã phiếu nhập đã tồn tại!";
        if(phieuNhapDAL.addPhieuNhap(phieuNhap))
            return "Đã thêm phiếu nhập";
        return "Không thể thêm phiếu nhập. Vui lòng kiểm tra lại!";
    }
    public boolean existID(String id){
        return phieuNhapDAL.existID(id);     
    }
    public boolean deletePhieuNhap(String id){
        return phieuNhapDAL.deletePhieuNhap(id);
    }
    public String taoIDTuDong(){
        String id = phieuNhapDAL.maLonNhat();
        int i = Integer.valueOf(id.substring(2));
        i++;
        if (i < 10)
            return "PN" + "00000" + i;
        else if (i >= 10 && i < 100)
                return "PN" + "0000" + i;
            else if (i >= 100 && i < 1000)
                    return "PN" + "000" + i;
                else
                    if (i >= 1000 && i < 10000)
                        return "PN" + "00" + i;
                    else
                        if(i >= 10000 && i < 100000)
                            return "PN" + "0" + i;
                         else
                            return "PN" + i;
    }
}
