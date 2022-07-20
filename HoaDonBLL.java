/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.HoaDonDAL;
import DTO.*;
import java.util.*;
/**
 *
 * @author thienvu
 */
public class HoaDonBLL {
    HoaDonDAL hoaDonDAL = new HoaDonDAL();
    public Vector<HoaDonDTO> getAllHoaDon(){
        return hoaDonDAL.getAllHoaDon();
    }
    public String addHoaDon(HoaDonDTO hoaDon){
        if(hoaDonDAL.existID(hoaDon.getMaHD()))
            return "Mã hóa đơn đã tồn tại!";
        if(hoaDonDAL.addHoaDon(hoaDon))
            return "Đã thêm hóa đơn";
        return "Không thể thêm hóa đơn. Vui lòng kiểm tra lại!";
    }
    public boolean existID(String id){
        return hoaDonDAL.existID(id);     
    }
    public boolean deleteHoaDon(String id){
        return hoaDonDAL.deleteHoaDon(id);
    }
    public String taoIDTuDong(){
        String id = hoaDonDAL.maLonNhat();
        int i = Integer.valueOf(id.substring(2));
        i++;
        if (i < 10)
            return "HD" + "00000" + i;
        else if (i >= 10 && i < 100)
                return "HD" + "0000" + i;
            else if (i >= 100 && i < 1000)
                    return "HD" + "000" + i;
                else
                    if (i >= 1000 && i < 10000)
                        return "HD" + "00" + i;
                    else
                        if(i >= 10000 && i < 100000)
                            return "HD" + "0" + i;
                         else
                            return "HD" + i;
    }
}
