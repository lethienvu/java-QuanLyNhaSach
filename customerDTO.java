package DTO;

public class customerDTO {
    private String maKH;
    private String hoDem;
    private String ten;
    private String diaChi;
    private String ngaySinh;
    private String gioiTinh;
    private String email;
    private String dienThoai;
    private int tinhTrang;

    public customerDTO(String maKH, String hoDem, String ten, String diaChi, String ngaySinh, String gioiTinh, String email, String dienThoai, int tinhTrang) {
        this.maKH = maKH;
        this.hoDem = hoDem;
        this.ten = ten;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.dienThoai = dienThoai;
        this.tinhTrang = tinhTrang;
    }

    public customerDTO() {
    }

    @Override
    public String toString() {
        return "customerDTO{" + "maKH=" + maKH + ", hoDem=" + hoDem + ", ten=" + ten + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", email=" + email + ", dienThoai=" + dienThoai + ", tinhTrang=" + tinhTrang + '}';
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {

        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
