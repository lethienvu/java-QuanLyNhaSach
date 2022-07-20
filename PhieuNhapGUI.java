/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import BLL.*;
import DTO.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
/**
 *
 * @author thienvu
 */
public class PhieuNhapGUI extends JFrame implements ActionListener{
    private PhieuNhapBLL phieuNhapBLL = new PhieuNhapBLL();
    private ChiTietPhieuNhapBLL ctpnBLL = new ChiTietPhieuNhapBLL();
    private JButton showList, deleteBtn, showDetailBtn, addBtn, searchBtn;
    private JTable phieuNhapTB;
    private DefaultTableModel dtm;
    private Vector<PhieuNhapDTO> listPhieuNhap = new Vector<PhieuNhapDTO>();
    private JTextField inputSearchTF;
    public PhieuNhapGUI(){
        initComponents();
    }
    
    public void initComponents(){
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
    
    public void contentArea(){
        JPanel container = new JPanel(new GridBagLayout());
        container.setPreferredSize(new Dimension(1300, 700));
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Search area
        JPanel searchArea = new JPanel();
        //searchArea.setPreferredSize(new Dimension(1000, 50));
        JLabel inputSearchLB = new JLabel("Nhập mã phiếu nhập: ");
        inputSearchTF = new JTextField(30);
        searchBtn = new JButton("Tìm kiếm", new ImageIcon("image/search.png"));
        searchBtn.addActionListener(this);
        searchBtn.setPreferredSize(new Dimension(150, 30));
        searchArea.add(inputSearchLB);
        searchArea.add(inputSearchTF);
        searchArea.add(searchBtn);

        //List area
        JPanel listArea = new JPanel(new BorderLayout());
        //listArea.setPreferredSize(new Dimension(1150, 600));
        listArea.add(loadPhieuNhapList(), BorderLayout.CENTER);
        
        //Button area
        JPanel btnArea = new JPanel(new GridLayout(1, 4, 100, 0));
        //btnArea.setPreferredSize(new Dimension(1000, 40));
        
        
        deleteBtn = new JButton("Xóa", new ImageIcon("image/delete.png"));
        deleteBtn.addActionListener(this);
        btnArea.add(deleteBtn);
        
        showList = new JButton("Xem danh sách", new ImageIcon("image/invoice-btn.png"));
        showList.addActionListener(this);
        btnArea.add(showList);
        
        showDetailBtn = new JButton("Xem chi tiết", new ImageIcon("image/search.png"));
        showDetailBtn.addActionListener(this);
        btnArea.add(showDetailBtn);
        
        addBtn = new JButton("Thêm", new ImageIcon("image/add.png"));
        addBtn.addActionListener(this);
        btnArea.add(addBtn);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        container.add(searchArea, gbc);
        gbc.gridy = 1;        
        container.add(listArea, gbc);
        gbc.gridy = 2;
        container.add(btnArea, gbc);
        add(container, BorderLayout.CENTER);
    }
    
    public JScrollPane loadPhieuNhapList(){
        phieuNhapTB = new JTable();
        dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã phiếu nhập");
        dtm.addColumn("Mã nhà cung cấp");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Ngày nhập");
        dtm.addColumn("Tổng tiền");
        phieuNhapTB.setModel(dtm);
        JScrollPane sp = new JScrollPane(phieuNhapTB);
        loadDataTable();
        return sp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showList){
           phieuNhapTB.setModel(dtm);
        }
        if(e.getSource() == showDetailBtn){
            showDetail();
        }
        if(e.getSource() == addBtn){
            themPhieuNhap();
        }
        if(e.getSource() == deleteBtn){
            xoaPhieuNhap();
        }
        if(e.getSource() == searchBtn){
            timKiem();
        }
    }
    
    public void editBtnHoaDon(){
    }
    public void showDetail(){
        int i = phieuNhapTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(phieuNhapTB.getValueAt(i, 1));
            dialogChiTietPhieuNhap(id);
        }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã phiếu nhập: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(phieuNhapBLL.existID(inputID))
                    dialogChiTietPhieuNhap(inputID);
                else
                    JOptionPane.showMessageDialog(this, "Mã phiếu nhập không tồn tại!");
            }
        }
    }
    public void xoaPhieuNhap(){
        int i = phieuNhapTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(phieuNhapTB.getValueAt(i, 1));
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản " + id + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                if(phieuNhapBLL.deletePhieuNhap(id)){
                    JOptionPane.showMessageDialog(this, "Đã xóa phiếu nhập");
                    loadDataTable();
                }
                else
                    JOptionPane.showMessageDialog(this, "Không thể xóa phiếu nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã phiêú nhập: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(phieuNhapBLL.existID(inputID)){
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản " + inputID + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        if(phieuNhapBLL.deletePhieuNhap(inputID)){
                            JOptionPane.showMessageDialog(this, "Đã xóa phiếu nhập");
                            loadDataTable();
                        }
                        else
                            JOptionPane.showMessageDialog(this, "Không thể xóa phiếu nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE); 
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Mã phiếu nhập không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã hóa đơn!");
        }
    }
    public void timKiem(){
        DefaultTableModel searchDtm = new DefaultTableModel();
        searchDtm.addColumn("STT");
        searchDtm.addColumn("Mã phiếu nhập");
        searchDtm.addColumn("Mã nhà cung cấp");
        searchDtm.addColumn("Mã nhân viên");
        searchDtm.addColumn("Ngày lập");
        searchDtm.addColumn("Tổng tiền");
        boolean result = false;
        if(inputSearchTF.getText() != null && !inputSearchTF.getText().trim().equals("")){
            for(int i = 0; i < listPhieuNhap.size(); i++){
                PhieuNhapDTO phieuNhap = listPhieuNhap.get(i);
                if(phieuNhap.getMaPN().equals(inputSearchTF.getText())){
                    searchDtm.addRow(new Object[]{
                    1, phieuNhap.getMaPN(), phieuNhap.getMaNCC(), phieuNhap.getMaNV(), phieuNhap.getNgayNhap(), phieuNhap.getTongTien()
                    });
                    phieuNhapTB.setModel(searchDtm);
                    result = true;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã phiếu nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);                 
    }
    public JScrollPane tableCTPN(String id){
        JTable ctpnTB = new JTable();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã sản phẩm");
        dtm.addColumn("Tên sản phẩm");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Thành tiền");
        ctpnTB.setModel(dtm);
        JScrollPane sp = new JScrollPane(ctpnTB);
        Vector<ChiTietPhieuNhapDTO> ctpnList = new Vector<ChiTietPhieuNhapDTO>();
        ctpnList = ctpnBLL.getChiTietPhieuNhapList(id);
        int stt = 0;
        for(int i = 0; i < ctpnList.size(); i++){
            ChiTietPhieuNhapDTO ctpn = ctpnList.get(i);
            String maSP = ctpn.getMaSP();
            String tenSP = ctpn.getTenSP();
            int donGia = ctpn.getDonGia();
            int soLuong = ctpn.getSoLuong();
            int thanhTien = ctpn.getThanhTien();
            Object[] row = {++stt, maSP, tenSP, donGia, soLuong, thanhTien};
            dtm.addRow(row);
        }
        return sp;
    }
    public void themPhieuNhap(){
        HeThongGUI.ctpn.setVisible(true);
        this.setVisible(false);
    }
    public void dialogChiTietPhieuNhap(String id){
        JDialog dialog = new JDialog(this, "Chi tiết phiếu nhập", true);
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(tableCTPN(id), BorderLayout.CENTER);
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton close = new JButton("OK");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.setVisible(false);
            }
        });
        btnPanel.add(close);
        contentPanel.add(btnPanel, BorderLayout.SOUTH);
        dialog.setSize(1200, 600);
        dialog.setContentPane(contentPanel);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    public void loadDataTable(){
        listPhieuNhap = phieuNhapBLL.getAllPhieuNhap();
        dtm.setRowCount(0);
        int stt = 1;
        for(PhieuNhapDTO pn : listPhieuNhap){
            Vector<Object> record = new Vector<>();
            record.add(stt);
            record.add(pn.getMaPN());
            record.add(pn.getMaNCC());
            record.add(pn.getMaNV());
            record.add(pn.getNgayNhap());
            record.add(pn.getTongTien());
            dtm.addRow(record);
            stt++;
        }
    }
}
