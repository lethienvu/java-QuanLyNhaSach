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
public class ChiTietPhieuNhapGUI extends JFrame implements ActionListener{
    private ChiTietPhieuNhapBLL ctpnBLL = new ChiTietPhieuNhapBLL();
    private PhieuNhapBLL pnBLL = new PhieuNhapBLL();
    private Vector<ChiTietPhieuNhapDTO> listCTPN = new Vector<ChiTietPhieuNhapDTO>();
    private JTextField maSPTF, soLuongTF, sdtTF, donGiaTF;
    private JButton addBtn, deleteBtn, paymentBtn;
    private JTable chiTietPhieuNhapTB;
    private String tenNCC;
    private DefaultTableModel dtm;
    private String newIDPhieuNhap = pnBLL.taoIDTuDong();
    public ChiTietPhieuNhapGUI(){
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
        listArea.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm nhập hàng"));
        listArea.add(loadCTPNList(), BorderLayout.CENTER);
        
        
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
        container.add(createPhieuNhapInfo(), gbc);
        
        add(container, BorderLayout.CENTER);
    }
    private JPanel addProductArea(){
        JPanel addArea = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel maSPLB = new JLabel("Nhập mã sản phẩm: ");
        maSPTF = new JTextField(20);
        JLabel soLuongLB = new JLabel("         Nhập số lượng: ");
        soLuongTF = new JTextField(20);
        JLabel donGiaLB = new JLabel("         Nhập đơn giá: ");
        donGiaTF = new JTextField(20);
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
        gbc.gridx = 0;
        gbc.gridy = 2;
        addArea.add(donGiaLB, gbc);
        gbc.gridx = 1;
        addArea.add(donGiaTF, gbc);
//        gbc.fill = GridBagConstraints.NONE;
//        gbc.anchor = GridBagConstraints.SOUTHEAST;
        gbc.gridx = 4;
//        gbc.gridy = 4;
//        gbc.insets = new Insets(10, 0, 0, 0);
        addArea.add(addBtn, gbc);
        return addArea;
    }
    private JScrollPane loadCTPNList(){
        chiTietPhieuNhapTB = new JTable();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã sản phẩm");
        dtm.addColumn("Tên sản phẩm");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Thành tiền");
        chiTietPhieuNhapTB.setModel(dtm);
       
        JScrollPane sp = new JScrollPane(chiTietPhieuNhapTB);
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
    private JPanel createPhieuNhapInfo(){
        JPanel receiptInfoArea = new JPanel(new GridBagLayout());
        receiptInfoArea.setBorder(BorderFactory.createTitledBorder("Thông tin nhà cung cấp"));
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel nccLB = new JLabel("Chọn nhà cung cấp: ");
        Vector<String> tenNCCList = ctpnBLL.listTenNCC();
        JComboBox chonNCC = new JComboBox(tenNCCList);
        tenNCC = (String) chonNCC.getSelectedItem();
        paymentBtn = new JButton("Nhập hàng", new ImageIcon("image/check-payment.png"));
        paymentBtn.setPreferredSize(new Dimension(150, 30));
        paymentBtn.setBackground(Color.ORANGE);
        paymentBtn.addActionListener(this);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 150, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        receiptInfoArea.add(nccLB, gbc);
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 1;
        receiptInfoArea.add(chonNCC, gbc);
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
            nhapHang();
        }
    }
    public void themSPVaoHD(){
        if(getSoLuongNhap() > 0 && getDonGiaNhap() > 0){
            if(maSPTF.getText() != null && !maSPTF.getText().trim().equals("")){
                if(ctpnBLL.existID(maSPTF.getText())){
                    SanPhamDTO sp = ctpnBLL.getSanPhamInfo(maSPTF.getText());
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(newIDPhieuNhap, sp.getMaSP(), sp.getTenSP(), getDonGiaNhap(), getSoLuongNhap(), getDonGiaNhap()*getSoLuongNhap());
                    listCTPN.add(ctpn);
                    loadDataTable();
                } else{
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else{
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Giá trị số lượng và đơn giá phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);            
    }
    public void xoaSPDaThem(){
        int row = chiTietPhieuNhapTB.getSelectedRow();
        if(row >= 0){
            listCTPN.remove(row);
            loadDataTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hàng cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void nhapHang(){
        if(tenNCC != null && !tenNCC.trim().equals("")){
                JComponent[] data = new JComponent[]{
                    new JLabel("Mã phiếu nhập: " + newIDPhieuNhap),
                    new JLabel("Tên nhà cấp: " + tenNCC),
                    new JLabel("Tổng tiền thanh toán: " + tinhTongTienPN())
                };
                JOptionPane.showMessageDialog(this, data, "Hóa đơn", JOptionPane.PLAIN_MESSAGE);
                taoPhieuNhap(LoginGUI.maNVLogin, tenNCC);
                this.setVisible(false);
                HeThongGUI.pn.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin nhà cung cấp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            //Chưa xử lý trường hợp không nhập thông tin khách hàng
        }
    }
    public int getSoLuongNhap(){
        int soLuong = 0;
        if(soLuongTF.getText() == null || soLuongTF.getText().trim().equals(""))
            JOptionPane.showMessageDialog(this, "Bắt buộc phải nhập số lượng!", "Lỗi", JOptionPane.ERROR_MESSAGE);            
        else{
            try{
                soLuong = Integer.valueOf(soLuongTF.getText());
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Định dạng số lượng không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        return soLuong;
    }
    public int getDonGiaNhap(){
        int donGia = -1;
        if(donGiaTF.getText() == null || donGiaTF.getText().trim().equals(""))
            JOptionPane.showMessageDialog(this, "Bắt buộc phải nhập đơn giá!", "Lỗi", JOptionPane.ERROR_MESSAGE);            
        else{
                try{
                    donGia = Integer.valueOf(donGiaTF.getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this, "Định dạng đơn giá không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        return donGia;
    }
    public void taoPhieuNhap(String maNV, String ten){
        PhieuNhapDTO pn = new PhieuNhapDTO();
        pn.setMaNCC(getIDNCC(ten));
        pn.setMaNV(maNV);
        LocalDate date = LocalDate.now();
        pn.setNgayNhap(date.getDayOfMonth() + "/" + date.getMonth().getValue() + "/" + date.getYear());
        pn.setTongTien(tinhTongTienPN());
        pn.setTinhTrang(1);
        pn.setMaPN(newIDPhieuNhap);
        JOptionPane.showMessageDialog(this, pnBLL.addPhieuNhap(pn));
        for(ChiTietPhieuNhapDTO ctpn : listCTPN){
            if(ctpnBLL.themChiTietPhieuNhap(ctpn) == false)
                JOptionPane.showMessageDialog(this, "Không thể thêm chi tiết phiếu nhập", "Lỗi", JOptionPane.ERROR_MESSAGE);
            else
                ctpnBLL.capNhatSoLuong(ctpn);
        }
    }
    public void loadDataTable(){
        dtm.setRowCount(0);
        for(ChiTietPhieuNhapDTO ctpn : listCTPN){
            Vector<Object> record = new Vector<>();
            record.add(ctpn.getMaSP());
            record.add(ctpn.getTenSP());
            record.add(ctpn.getDonGia());
            record.add(ctpn.getSoLuong());
            record.add(ctpn.getThanhTien());
            dtm.addRow(record);
        }
    }
    public int tinhTongTienPN(){
        int tong = 0;
        for(ChiTietPhieuNhapDTO ctpn : listCTPN){
            tong += ctpn.getThanhTien();
        }
        return tong;
    }
    public String getIDNCC(String ten){
        return ctpnBLL.getNCCInfo(ten).getMaNCC();
    }
}
