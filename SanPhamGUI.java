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
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author thienvu
 */
public class SanPhamGUI  extends JFrame implements ActionListener {
    private SanPhamBLL sanPhamBLL = new SanPhamBLL();
    private JButton showList, deleteBtn, addBtn, searchBtn, changePassword;
    private JTable sanPhamTB;
    private DefaultTableModel dtm;
    private Vector<SanPhamDTO> listSanPham = new Vector<SanPhamDTO>();
    private JTextField inputSearchTF;
    public SanPhamGUI(){
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
        JLabel inputSearchLB = new JLabel("Nhập mã sản phẩm: ");
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
        listArea.add(loadSanPhamList(), BorderLayout.CENTER);
        
        //Button area
        JPanel btnArea = new JPanel(new GridLayout(1, 4, 100, 0));
        //btnArea.setPreferredSize(new Dimension(1000, 40));
        
        
        deleteBtn = new JButton("Xóa", new ImageIcon("image/delete.png"));
        deleteBtn.addActionListener(this);
        btnArea.add(deleteBtn);
        
        showList = new JButton("Xem danh sách", new ImageIcon("image/invoice-btn.png"));
        showList.addActionListener(this);
        btnArea.add(showList);
        
        changePassword = new JButton("Chỉnh sửa", new ImageIcon("image/edit.png"));
        changePassword.addActionListener(this);
        btnArea.add(changePassword);
        
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
    
    public JScrollPane loadSanPhamList(){
        sanPhamTB = new JTable();
        dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã sản phẩm");
        dtm.addColumn("Tên sản phẩm");
        dtm.addColumn("Mã loại");
        dtm.addColumn("Mã NCC");
        dtm.addColumn("Giá bán");
        dtm.addColumn("Số lượng");
        sanPhamTB.setModel(dtm);
        JScrollPane sp = new JScrollPane(sanPhamTB);
        loadDataTable();
        return sp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showList){
            loadDataTable();
            sanPhamTB.setModel(dtm);
        }
        if(e.getSource() == addBtn){
            dialogThemSanPham();
        }
        if(e.getSource() == deleteBtn){
            xoaSP();
        }
        if(e.getSource() == searchBtn){
            timKiem();
        }
        if(e.getSource() == changePassword){
            suaSP();
        }
    }
    
    public void xoaSP(){
        int i = sanPhamTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(sanPhamTB.getValueAt(i, 1));
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm " + id + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                if(sanPhamBLL.deleteSanPham(id)){
                JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm");
                loadDataTable();
            }
            else
                JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã sản phẩm: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(sanPhamBLL.existID(inputID)){
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa sản phẩm " + inputID + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        if(sanPhamBLL.deleteSanPham(inputID)){
                            JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm");
                            loadDataTable();
                        }
                        else
                            JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    
                    }
                else
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void timKiem(){
        DefaultTableModel searchDtm = new DefaultTableModel();
        searchDtm.addColumn("STT");
        searchDtm.addColumn("Mã sản phẩm");
        searchDtm.addColumn("Tên sản phẩm");
        searchDtm.addColumn("Mã loại");
        searchDtm.addColumn("Mã nhà cung cấp");
        searchDtm.addColumn("Giá bán");
        searchDtm.addColumn("Số lượng");
        boolean result = false;
        if(inputSearchTF.getText() != null && !inputSearchTF.getText().trim().equals("")){
            for(int i = 0; i < listSanPham.size(); i++){
                SanPhamDTO sanPham = listSanPham.get(i);
                if(sanPham.getMaSP().equals(inputSearchTF.getText())){
                    searchDtm.addRow(new Object[]{
                    1, sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMaLoai(), sanPham.getNhaCungCap(), sanPham.getGiaBan(), sanPham.getSoLuong()
                    });
                    sanPhamTB.setModel(searchDtm);
                    result = true;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);                 
    }
    public void loadDataTable(){
        listSanPham = sanPhamBLL.getAllSanPham();
        dtm.setRowCount(0);
        int stt = 1;
        for(SanPhamDTO sp : listSanPham){
            Vector<Object> record = new Vector<>();
            record.add(stt);
            record.add(sp.getMaSP());
            record.add(sp.getTenSP());
            record.add(sp.getMaLoai());
            record.add(sp.getNhaCungCap());
            record.add(sp.getGiaBan());
            record.add(sp.getSoLuong());
            dtm.addRow(record);
            stt++;
        }
    }
    public void suaSP(){
        int i = sanPhamTB.getSelectedRow();
        if(i >= 0){
            String maSP = String.valueOf(sanPhamTB.getValueAt(i, 1));
            String tenSP = String.valueOf(sanPhamTB.getValueAt(i, 2));
            String maLoai = String.valueOf(sanPhamTB.getValueAt(i, 3));
            String nhaCC = String.valueOf(sanPhamTB.getValueAt(i, 4));
            int giaBan = Integer.parseInt(String.valueOf(sanPhamTB.getValueAt(i, 5)));
            int soLuong = Integer.parseInt(String.valueOf(sanPhamTB.getValueAt(i, 6)));
            SanPhamDTO newSP = new SanPhamDTO(maSP, tenSP, maLoai, nhaCC, giaBan, soLuong);
            JDialog editDialog = dialogSuaSanPham(newSP);
            editDialog.setVisible(true);
        }
        else{
            String inputID = JOptionPane.showInputDialog("Nhập mã sản phẩm: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(sanPhamBLL.existID(inputID)){
                    SanPhamDTO sp = sanPhamBLL.getSanPhamInfo(inputID);
                    JDialog editDialog = dialogSuaSanPham(sp);
                    editDialog.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);   
        }
    }

    public void dialogThemSanPham(){
        JDialog dialog = new JDialog(this, "Thêm sản phẩm", true);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setSize(550,350);
        
        JLabel titleLB = new JLabel("THÊM SẢN PHẨM MỚI");
        titleLB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        titleLB.setBounds(150, 30, 250, 50);
        contentPanel.add(titleLB);
        
        JLabel tenSPLB = new JLabel("Tên sản phẩm:");
        tenSPLB.setBounds(100, 120, 200, 25);
        contentPanel.add(tenSPLB);
        
        JTextField tenSPTF = new JTextField(25);
        tenSPTF.setBounds(250, 120, 200, 25);
        contentPanel.add(tenSPTF);
        
        JLabel loaiSPLB = new JLabel("Loại sản phẩm: ");
        loaiSPLB.setBounds(100, 160, 200, 25);
        contentPanel.add(loaiSPLB);
        
        Vector<String> tenLoaiList = sanPhamBLL.listTenLoaiSP();
        JComboBox chonLoai = new JComboBox(tenLoaiList);
        String tenLoai = (String) chonLoai.getSelectedItem();
        chonLoai.setBounds(250, 160, 200, 25);
        contentPanel.add(chonLoai);
        
        JLabel nhaCCLB = new JLabel("Nhà cung cấp: ");
        nhaCCLB.setBounds(100, 190, 200, 25);
        contentPanel.add(nhaCCLB);
        
        Vector<String> tenNCCList = sanPhamBLL.listTenNCC();
        JComboBox chonNCC = new JComboBox(tenNCCList);
        String tenNCC = (String) chonNCC.getSelectedItem();
        chonNCC.setBounds(250, 190, 200, 25);
        contentPanel.add(chonNCC);
        
        JLabel giaBanLB = new JLabel("Giá bán:");
        giaBanLB.setBounds(100, 220, 200, 25);
        contentPanel.add(giaBanLB);
        
        JTextField giaBanTF = new JTextField(25);
        giaBanTF.setBounds(250, 220, 200, 25);
        contentPanel.add(giaBanTF);
        
        JLabel soLuongLB = new JLabel("Số lượng:");
        soLuongLB.setBounds(100, 250, 200, 25);
        contentPanel.add(soLuongLB);
        
        JTextField soLuongTF = new JTextField(25);
        soLuongTF.setBounds(250, 250, 200, 25);
        contentPanel.add(soLuongTF);
        
        JButton addProBtn = new JButton("Thêm sản phẩm");
        addProBtn.setBackground(Color.ORANGE);
        addProBtn.setBounds(175, 300, 150, 25);
        contentPanel.add(addProBtn);
              
        addProBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maSP= sanPhamBLL.taoIDTuDong();
                if(tenSPTF.getText() != null && !tenSPTF.getText().trim().equals("") && giaBanTF.getText() != null && !giaBanTF.getText().trim().equals("") && soLuongTF.getText() != null && !soLuongTF.getText().trim().equals("")){
                    int soLuong = getSoLuongNhap(soLuongTF.getText());
                    int giaBan = getDonGiaNhap(giaBanTF.getText());
                    if(soLuong > 0 && giaBan > 0){
                        SanPhamDTO sp = new SanPhamDTO(maSP, tenSPTF.getText(), getIDLSP(tenLoai), getIDNCC(tenNCC), giaBan, soLuong);
                        JOptionPane.showMessageDialog(dialog, sanPhamBLL.addSanPham(sp));
                        dialog.setVisible(false);
                        loadDataTable();
                    }                     
                    else
                        JOptionPane.showMessageDialog(dialog, "Số lượng và đơn giá phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(dialog, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.setSize(550, 400);
        dialog.setContentPane(contentPanel);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
    public JDialog dialogSuaSanPham(SanPhamDTO sp){
        JDialog dialog = new JDialog(this, "Chỉnh sửa thông tin sản phẩm", true);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setSize(550,350);
        
        JLabel titleLB = new JLabel("CẬP NHẬT SẢN PHẨM");
        titleLB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        titleLB.setBounds(150, 30, 250, 50);
        contentPanel.add(titleLB);
        
        JLabel tenSPLB = new JLabel("Tên sản phẩm:");
        tenSPLB.setBounds(100, 120, 200, 25);
        contentPanel.add(tenSPLB);
        
        JTextField tenSPTF = new JTextField(25);
        tenSPTF.setBounds(250, 120, 200, 25);
        tenSPTF.setText(sp.getTenSP());
        contentPanel.add(tenSPTF);
        
        JLabel loaiSPLB = new JLabel("Loại sản phẩm: ");
        loaiSPLB.setBounds(100, 160, 200, 25);
        contentPanel.add(loaiSPLB);
        
        Vector<String> tenLoaiList = sanPhamBLL.listTenLoaiSP();
        JComboBox chonLoai = new JComboBox(tenLoaiList);
        String tenLoai = (String) chonLoai.getSelectedItem();
        chonLoai.setBounds(250, 160, 200, 25);
        contentPanel.add(chonLoai);
        
        JLabel nhaCCLB = new JLabel("Nhà cung cấp: ");
        nhaCCLB.setBounds(100, 190, 200, 25);
        contentPanel.add(nhaCCLB);
        
        Vector<String> tenNCCList = sanPhamBLL.listTenNCC();
        JComboBox chonNCC = new JComboBox(tenNCCList);
        String tenNCC = (String) chonNCC.getSelectedItem();
        chonNCC.setBounds(250, 190, 200, 25);
        contentPanel.add(chonNCC);
        
        JLabel giaBanLB = new JLabel("Giá bán:");
        giaBanLB.setBounds(100, 220, 200, 25);
        contentPanel.add(giaBanLB);
        
        JTextField giaBanTF = new JTextField(25);
        giaBanTF.setBounds(250, 220, 200, 25);
        giaBanTF.setText(String.valueOf(sp.getGiaBan()));
        contentPanel.add(giaBanTF);
        
        JLabel soLuongLB = new JLabel("Số lượng:");
        soLuongLB.setBounds(100, 250, 200, 25);
        contentPanel.add(soLuongLB);
        
        JTextField soLuongTF = new JTextField(25);
        soLuongTF.setBounds(250, 250, 200, 25);
        soLuongTF.setText(String.valueOf(sp.getSoLuong()));
        contentPanel.add(soLuongTF);
        
        JButton addProBtn = new JButton("Cập nhật");
        addProBtn.setBackground(Color.ORANGE);
        addProBtn.setBounds(175, 300, 150, 25);
        contentPanel.add(addProBtn);
              
        addProBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maSP= sanPhamBLL.taoIDTuDong();
                if(tenSPTF.getText() != null && !tenSPTF.getText().trim().equals("") && giaBanTF.getText() != null && !giaBanTF.getText().trim().equals("") && soLuongTF.getText() != null && !soLuongTF.getText().trim().equals("")){
                    int soLuong = getSoLuongNhap(soLuongTF.getText());
                    int giaBan = getDonGiaNhap(giaBanTF.getText());
                    if(soLuong > 0 && giaBan > 0){
                        SanPhamDTO newSP = new SanPhamDTO(maSP, tenSPTF.getText(), getIDLSP(tenLoai), getIDNCC(tenNCC), giaBan, soLuong);
                        JOptionPane.showMessageDialog(dialog, sanPhamBLL.updateSanPham(newSP));
                        dialog.setVisible(false);
                        loadDataTable();
                    }                     
                    else
                        JOptionPane.showMessageDialog(dialog, "Số lượng và đơn giá phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(dialog, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.setSize(500, 400);
        dialog.setContentPane(contentPanel);
        dialog.setLocationRelativeTo(this);
        return dialog;
    }
    public int getSoLuongNhap(String soLuong){
        int sl = 0;
        if(soLuong != null || !soLuong.trim().equals("")){
            try{
                sl = Integer.valueOf(soLuong);
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Định dạng số lượng không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        return sl;
    }
    public int getDonGiaNhap(String donGia){
        int dg = -1;
        if(donGia != null || !donGia.trim().equals("")){
            try{
                dg = Integer.valueOf(donGia);
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Định dạng giá bán không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }   
        }
        return dg;
    }
    public String getIDNCC(String ten){
        return sanPhamBLL.getNCCInfo(ten).getMaNCC();
    }
    public String getIDLSP(String ten){
        return sanPhamBLL.getLoaiSPInfo(ten).getMaLoai();
    }
}
