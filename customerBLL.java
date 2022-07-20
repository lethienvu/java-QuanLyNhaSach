package BLL;

import DAL.customerDAL;
import DTO.customerDTO;
import java.util.Vector;

public class customerBLL {
    customerDAL cusDAL = new customerDAL();
    public Vector<customerDTO> getAllCustomers(){
        return cusDAL.getAllCustomers();
    }
    
    public String addCustomer(customerDTO cus){
        if(cusDAL.hasCustomerID(cus.getMaKH()))
           return "Mã KH đã tồn tại";
        if(cusDAL.addCustomer(cus))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String updateCustomer(customerDTO cus){
        if(cusDAL.updateCustomer(cus))
            return "Cập nhật thành công";
        return "Cập nhật thất bại";
    }
    
    public String deleteCustomer(customerDTO cus){
        if(cusDAL.deleteCustomer(cus))
            return "Xóa thành công";
        return "Xóa thất bại";
    }
}
