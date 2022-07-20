/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DTO.*;
import DAL.*;
import java.util.*;
/**
 *
 * @author thienvu
 */
public class SanPhamBLL {
    SanPhamDAL sanPhamDAL = new SanPhamDAL();
    public Vector<SanPhamDTO> getAllSanPham(){
        return sanPhamDAL.getAllSanPham();
    }
    public String addSanPham(SanPhamDTO sp){
        if(sanPhamDAL.existID(sp.getMaSP()))
            return "Mã sản phẩm đã tồn tại!";
        if(sanPhamDAL.addSanPham(sp))
            return "Đã thêm sản phẩm. Mã sản phẩm là: " + sp.getMaSP();
        return "Không thể thêm sản phẩm. Vui lòng kiểm tra lại!";
    }
    public String updateSanPham(SanPhamDTO sp){
        if(sanPhamDAL.updateSanPham(sp))
            return "Đã cập nhật thành công!";
        return "Cập nhật thất bại!";
    }
    public boolean deleteSanPham(String id){
        return sanPhamDAL.deleteSanPham(id);
    }
    public boolean existID(String id){
        return sanPhamDAL.existID(id);
    }
    public String taoIDTuDong(){
        String id = sanPhamDAL.maLonNhat();
        int i = Integer.valueOf(id.substring(2));
        i++;
        if (i < 10)
            return "SP" + "00000" + i;
        else if (i >= 10 && i < 100)
                return "SP" + "0000" + i;
            else if (i >= 100 && i < 1000)
                    return "SP" + "000" + i;
                else
                    if (i >= 1000 && i < 10000)
                        return "SP" + "00" + i;
                    else
                        if(i >= 10000 && i < 100000)
                            return "SP" + "0" + i;
                         else
                            return "SP" + i;
    }
    public Vector<String> listTenNCC(){
        Vector<String> tenNCC = new Vector<String>();
        Vector<NhaCungCapDTO> nccList = sanPhamDAL.getNhaCCList();
        for(NhaCungCapDTO ncc : nccList){
            tenNCC.add(ncc.getTenNCC());
        }
        return tenNCC;
    }
    public Vector<String> listTenLoaiSP(){
        Vector<String> tenLoaiSP = new Vector<String>();
        Vector<LoaiSanPhamDTO> loaiSPList = sanPhamDAL.getTenLoaiSPList();
        for(LoaiSanPhamDTO lsp : loaiSPList){
            tenLoaiSP.add(lsp.getTenLoai());
        }
        return tenLoaiSP;
    }
    public NhaCungCapDTO getNCCInfo(String ten){
        return sanPhamDAL.getNCCInfo(ten);
    }
    public LoaiSanPhamDTO getLoaiSPInfo(String ten){
        return sanPhamDAL.getLoaiSPInfo(ten);
    }
    public SanPhamDTO getSanPhamInfo(String id){
        return sanPhamDAL.getSanPhamInfo(id);
    }
}
