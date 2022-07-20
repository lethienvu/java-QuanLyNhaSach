package BUS;
import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.Vector;

public class NhanVienBUS{
    NhanVienDAL nvDAL = new NhanVienDAL();
    public Vector<NhanVienDTO> getAllNhanVien(){
        return nvDAL.getAllNhanVien();
    }
    
    public String autoID(){
        String arg = nvDAL.getLastID();
            return arg;
    }
    
    public String addNhanVien(NhanVienDTO nv){
        if(nvDAL.getNhanVienID(nv.getMaNV()))
            return "Mã NV đã tồn tại";
        if(nvDAL.addNhanVien(nv))
            return "thêm thành công";
        return "thêm thất bại";
        
    }
    
    public String updateNhanVien(NhanVienDTO nv){
        if(nvDAL.updateNhanVien(nv)){
            return "Cập nhật thành công";   
            }
        return"Cập nhật thất bại";                              
    }
    
    public String deleteNhanVien(NhanVienDTO nv){
        if(nvDAL.deleteNhanVien(nv))
            return "Xoá thành công";
        return "Xoá thất bại";           
    }

}