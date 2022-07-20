/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BLL.*;
import DTO.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.time.LocalDate;
/**
 *
 * @author thienvu
 */
public class ChiTietHoaDonGUI extends JFrame implements ActionListener{
    private ChiTietHoaDonBLL cthdBLL = new ChiTietHoaDonBLL();
    private HoaDonBLL hdBLL = new HoaDonBLL();
    private Vector<ChiTietHoaDonDTO> listCTHD = new Vector<ChiTietHoaDonDTO>();
    private JTextField maSPTF, soLuongTF, sdtTF;
    private JButton addBtn, deleteBtn, paymentBtn;
    private JTable chiTietHoaDonTB;
    private DefaultTableModel dtm;
    private String newIDHoaDon = hdBLL.taoIDTuDong();
    public ChiTietHoaDonGUI(){
        initComponents();
    }
    
    private void initComponents(){
        setTitle("Phần mềm quản lý cửa hàng sách");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Lấy kích thước màn hình của thiết bị
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize((int)width,(int)height);
        
        //set Icon
        ImageIcon img = new ImageIcon("image/book.png");
        setIconImage(img.getImage());
        setJMenuBar(new MenuBarGUI().createMenuBar());
        add(new SideBarGUI().createSideBar(), BorderLayout.WEST);
        contentArea();
    }
    
    private void contentArea(){
        JPanel container = new JPanel(new GridBagLayout());
        container.setPreferredSize(new Dimension(1300, 700));
        GridBagConstraints gbc = new GridBagConstraints();

        //List Area
        JPanel listArea = new JPanel(new BorderLayout());
        listArea.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm"));
        listArea.add(loadCTHDList(), BorderLayout.CENTER);
        
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        container.add(addProductArea());
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        container.add(listArea, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 2;
        container.add(createBtnArea(), gbc);
        gbc.gridy = 3;
        container.add(createReceiptInfo(), gbc);
        
        add(container, BorderLayout.CENTER);
    }
    private JPanel addProductArea(){
        JPanel addArea = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel maSPLB = new JLabel("Nhập mã sản phẩm: ");
        maSPTF = new JTextField(20);
        JLabel soLuongLB = new JLabel("         Nhập số lượng: ");
        soLuongTF = new JTextField(20);
        addBtn = new JButton("Thêm", new ImageIcon("image/add.png"));
        addBtn.setPreferredSize(new Dimension(100, 30));
        addBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        addArea.add(maSPLB, gbc);
        gbc.gridx = 1;
        addArea.add(maSPTF, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        addArea.add(soLuongLB, gbc);
        gbc.gridx = 1;
        addArea.add(soLuongTF, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        addArea.add(addBtn, gbc);
        return addArea;
    }
    private JScrollPane loadCTHDList(){
        chiTietHoaDonTB = new JTable();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã sản phẩm");
        dtm.addColumn("Tên sản phẩm");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Thành tiền");
        chiTietHoaDonTB.setModel(dtm);
       
        JScrollPane sp = new JScrollPane(chiTietHoaDonTB);
        return sp;
    }
    private JPanel createBtnArea(){
        JPanel btnArea = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        deleteBtn = new JButton("Xóa", new ImageIcon("image/delete.png"));  
        deleteBtn.addActionListener(this);
        gbc.weightx = 100;
        gbc.gridx = 3;
        gbc.gridy = 0;
        btnArea.add(deleteBtn, gbc);
        return btnArea;
    }
    private JPanel createReceiptInfo(){
        JPanel receiptInfoArea = new JPanel(new GridBagLayout());
        receiptInfoArea.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel sdtLB = new JLabel("Nhập số điện thoại khách hàng: ");
        sdtTF = new JTextField(20);
        paymentBtn = new JButton("Thanh toán", new ImageIcon("image/check-payment.png"));
        paymentBtn.setPreferredSize(new Dimension(150, 30));
        paymentBtn.setBackground(Color.ORANGE);
        paymentBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 150, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        receiptInfoArea.add(sdtLB, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 1;
        receiptInfoArea.add(sdtTF, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.ipadx = 20;
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 180, 0, 0);
        receiptInfoArea.add(paymentBtn, gbc);
        return receiptInfoArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addBtn){
            themSPVaoHD();
        }
        if(e.getSource() == deleteBtn){
            xoaSPDaThem();
        }
        if(e.getSource() == paymentBtn){
            thanhToan();    //Tạo hóa đơn và chi tiết hóa đơn, xuất thông tin hóa đơn
        }
    }
    public void themSPVaoHD(){
        if(maSPTF.getText() != null && !maSPTF.getText().trim().equals("")){
            if(cthdBLL.existID(maSPTF.getText())){
                if(getSoLuongNhap() > 0){
                    SanPhamDTO sp = cthdBLL.getSanPhamInfo(maSPTF.getText());
                    ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO(newIDHoaDon, sp.getMaSP(), sp.getTenSP(), sp.getGiaBan(), getSoLuongNhap(), sp.getGiaBan()*getSoLuongNhap());
                    listCTHD.add(cthd);
                    loadDataTable();
                }
                else
                    JOptionPane.showMessageDialog(this, "Giá trị số lượng phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);            

            } else{
                JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void xoaSPDaThem(){
        int row = chiTietHoaDonTB.getSelectedRow();
        if(row >= 0){
            listCTHD.remove(row);
            loadDataTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void thanhToan(){
        if(sdtTF.getText() != null && !sdtTF.getText().trim().equals("")){
            if(cthdBLL.existKhachHangID(sdtTF.getText())){
                KhachHangDTO kh = cthdBLL.getKhachHangInfo(sdtTF.getText());
                JComponent[] data = new JComponent[]{
                    new JLabel("Mã hóa đơn: " + newIDHoaDon),
                    new JLabel("Mã khách hàng: " + kh.getMaKH()),
                    new JLabel("Họ và tên KH: " + kh.getHoDem() + " " + kh.getTen()),
                    new JLabel("Tổng tiền thanh toán: " + tinhTongTienHD())
                };
                JOptionPane.showMessageDialog(this, data, "Hóa đơn", JOptionPane.PLAIN_MESSAGE);
                taoHoaDon(LoginGUI.maNVLogin, kh.getMaKH());
                this.setVisible(false);
                HeThongGUI.hd.setVisible(true);
            } else
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            //Chưa xử lý trường hợp không nhập thông tin khách hàng
        }
    }
    public int getSoLuongNhap(){
        int soLuong = 0;
        if(soLuongTF.getText() == null || soLuongTF.getText().trim().equals(""))
            soLuong = 1;
        else{
            try{
                soLuong = Integer.valueOf(soLuongTF.getText());
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Định dạng số lượng không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        return soLuong;
    }
    public void taoHoaDon(String maNV, String maKH){
        HoaDonDTO hd = new HoaDonDTO();
        hd.setMaKH(maKH);
        hd.setMaNV(maNV);
        LocalDate date = LocalDate.now();
        hd.setNgayLap(date.getDayOfMonth() + "/" + date.getMonth().getValue() + "/" + date.getYear());
        hd.setTongTien(tinhTongTienHD());
        hd.setTinhTrang(1);
        hd.setMaHD(newIDHoaDon);
        JOptionPane.showMessageDialog(this, hdBLL.addHoaDon(hd));
        for(ChiTietHoaDonDTO cthd : listCTHD){
            if(cthdBLL.themChiTietHoaDon(cthd) == false)
                JOptionPane.showMessageDialog(this, "Không thể thêm thông tin chi tiết hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            else
                cthdBLL.capNhatSoLuong(cthd);
        }
    }
    public void loadDataTable(){
        dtm.setRowCount(0);
        for(ChiTietHoaDonDTO cthd : listCTHD){
            Vector<Object> record = new Vector<>();
            record.add(cthd.getMaSP());
            record.add(cthd.getTenSP());
            record.add(cthd.getDonGia());
            record.add(cthd.getSoLuong());
            record.add(cthd.getThanhTien());
            dtm.addRow(record);
        }
    }
    public int tinhTongTienHD(){
        int tong = 0;
        for(ChiTietHoaDonDTO cthd : listCTHD){
            tong += cthd.getThanhTien();
        }
        return tong;
    }
}
