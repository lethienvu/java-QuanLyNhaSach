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
public class HoaDonGUI extends JFrame implements ActionListener{
    private HoaDonBLL hoaDonBLL = new HoaDonBLL();
    private ChiTietHoaDonBLL cthdBLL = new ChiTietHoaDonBLL();
    private JButton showList, deleteBtn, showDetailBtn, addBtn, searchBtn;
    private JTable hoaDonTB;
    private DefaultTableModel dtm;
    private Vector<HoaDonDTO> listHoaDon = new Vector<HoaDonDTO>();
    private JTextField inputSearchTF;
    public HoaDonGUI(){
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
        JLabel inputSearchLB = new JLabel("Nhập mã hóa đơn: ");
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
        listArea.add(loadHoaDonList(), BorderLayout.CENTER);
        
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
    
    public JScrollPane loadHoaDonList(){
        hoaDonTB = new JTable();
        dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã hóa đơn");
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Ngày lập");
        dtm.addColumn("Tổng tiền");
        hoaDonTB.setModel(dtm);
        JScrollPane sp = new JScrollPane(hoaDonTB);
        loadDataTable();
//        int stt = 0;
//        for(int i = 0; i < listHoaDon.size(); i++){
//            HoaDonDTO hoaDon = listHoaDon.get(i);
//            String maHD = hoaDon.getMaHD();
//            String maKH = hoaDon.getMaKH();
//            String maNV = hoaDon.getMaNV();
//            String ngayLap = hoaDon.getNgayLap();
//            int tongTien = hoaDon.getTongTien();
//            Object[] row = {++stt, maHD, maKH, maNV, ngayLap, tongTien};
//            dtm.addRow(row);
//        }
        return sp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showList){
            hoaDonTB.setModel(dtm);
        }
        if(e.getSource() == showDetailBtn){
            showDetail();
        }
        if(e.getSource() == addBtn){
            themHoaDon();
        }
        if(e.getSource() == deleteBtn){
            xoaHoaDon();
        }
        if(e.getSource() == searchBtn){
            timKiem();
        }
    }
    
    public void editBtnHoaDon(){
    }
    public void showDetail(){
        int i = hoaDonTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(hoaDonTB.getValueAt(i, 1));
            dialogChiTietHoaDon(id);
        }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã hóa đơn: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(hoaDonBLL.existID(inputID))
                    dialogChiTietHoaDon(inputID);
                else
                    JOptionPane.showMessageDialog(this, "Mã hóa đơn không tồn tại!");
            }
            else
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void xoaHoaDon(){
        int i = hoaDonTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(hoaDonTB.getValueAt(i, 1));
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản " + id + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                if(hoaDonBLL.deleteHoaDon(id)){
                    JOptionPane.showMessageDialog(this, "Đã xóa hóa đơn");
                    loadDataTable();
                }
                else
                    JOptionPane.showMessageDialog(this, "Không thể xóa hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã hóa đơn: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(hoaDonBLL.existID(inputID)){
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản " + inputID + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        if(hoaDonBLL.deleteHoaDon(inputID)){
                            JOptionPane.showMessageDialog(this, "Đã xóa hóa đơn");
                            loadDataTable();
                        }
                        else
                            JOptionPane.showMessageDialog(this, "Không thể xóa hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Mã hóa đơn không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void timKiem(){
        DefaultTableModel searchDtm = new DefaultTableModel();
        searchDtm.addColumn("STT");
        searchDtm.addColumn("Mã hóa đơn");
        searchDtm.addColumn("Mã khách hàng");
        searchDtm.addColumn("Mã nhân viên");
        searchDtm.addColumn("Ngày lập");
        searchDtm.addColumn("Tổng tiền");
        boolean result = false;
        if(inputSearchTF.getText() != null && !inputSearchTF.getText().trim().equals("")){
            for(int i = 0; i < listHoaDon.size(); i++){
                HoaDonDTO hoaDon = listHoaDon.get(i);
                if(hoaDon.getMaHD().equals(inputSearchTF.getText())){
                    searchDtm.addRow(new Object[]{
                    1, hoaDon.getMaHD(), hoaDon.getMaKH(), hoaDon.getMaNV(), hoaDon.getNgayLap(), hoaDon.getTongTien()
                    });
                    hoaDonTB.setModel(searchDtm);
                    result = true;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn!", "Lỗi", JOptionPane.ERROR_MESSAGE);                 
    }
    public JScrollPane tableCTHD(String id){
        JTable cthdTB = new JTable();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã sản phẩm");
        dtm.addColumn("Tên sản phẩm");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Thành tiền");
        cthdTB.setModel(dtm);
        JScrollPane sp = new JScrollPane(cthdTB);
        Vector<ChiTietHoaDonDTO> cthdList = new Vector<ChiTietHoaDonDTO>();
        cthdList = cthdBLL.getChiTietHoaDonList(id);
        int stt = 0;
        for(int i = 0; i < cthdList.size(); i++){
            ChiTietHoaDonDTO cthd = cthdList.get(i);
            String maSP = cthd.getMaSP();
            String tenSP = cthd.getTenSP();
            int donGia = cthd.getDonGia();
            int soLuong = cthd.getSoLuong();
            int thanhTien = cthd.getThanhTien();
            Object[] row = {++stt, maSP, tenSP, donGia, soLuong, thanhTien};
            dtm.addRow(row);
        }
        return sp;
    }
    public void themHoaDon(){
        ChiTietHoaDonGUI cthdGUI = new ChiTietHoaDonGUI();
        cthdGUI.setVisible(true);
        this.setVisible(false);
    }
    public void dialogChiTietHoaDon(String id){
        JDialog dialog = new JDialog(this, "Chi tiết hóa đơn", true);
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(tableCTHD(id), BorderLayout.CENTER);
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
        listHoaDon = hoaDonBLL.getAllHoaDon();
        dtm.setRowCount(0);
        int stt = 1;
        for(HoaDonDTO hd : listHoaDon){
            Vector<Object> record = new Vector<>();
            record.add(stt);
            record.add(hd.getMaHD());
            record.add(hd.getMaKH());
            record.add(hd.getMaNV());
            record.add(hd.getNgayLap());
            record.add(hd.getTongTien());
            dtm.addRow(record);
            stt++;
        }
    }
}
