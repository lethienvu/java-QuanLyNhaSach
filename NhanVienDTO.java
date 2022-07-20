
package DTO;

public class NhanVienDTO {
    private String MaNV;
    private String HoDem;
    private String Ten;
    private String DiaChi;
    private String NgaySinh;
    private String GioiTinh;
    private String Email;
    private String Sdt;
    private int TrangThai;
    
    public NhanVienDTO(String MaNV, String HoDem, String Ten, String DiaChi, String NgaySinh, String GioiTinh, String Email, String Sdt, int TrangThai){
        this.MaNV = MaNV;
        this.HoDem = HoDem;
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
        this.Sdt = Sdt; 
        this.TrangThai = TrangThai;
    }
    
    public NhanVienDTO(){
    
    }
    
    public String getMaNV(){
        return MaNV;
    }    
    public String getHoDem(){
        return HoDem;
    }    
    public String getTen(){
        return Ten;
    }    
    public String getDiaChi(){
        return DiaChi;
    }   
    public String getNgaySinh(){
        return NgaySinh;
    }    
    public String getGioiTinh(){
        return GioiTinh;
    }   
    public String getEmail(){
        return Email;
    }
    
    public String getSdt(){
        return Sdt;
    }   
    public int getTrangThai(){
        return TrangThai;
    }    
    public void setMaNV(String MaNV){
        this.MaNV = MaNV;
    }

    public void setHoDem(String HoDem){
        this.HoDem = HoDem;
    }
    public void setTen(String Ten){
        this.Ten = Ten;
    }
    public void setDiaChi(String DiaChi){
        this.DiaChi = DiaChi;
    }
    public void setNgaySinh(String NgaySinh){
        this.NgaySinh = NgaySinh;
    }
    public void setGioiTinh(String GioiTinh){
        this.GioiTinh = GioiTinh;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public void setSdt(String Sdt){
        this.Sdt = Sdt;
    }
    public void setTrangThai(int TrangThai){
        this.TrangThai = TrangThai;
    }
}
