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
public class TaiKhoanGUI extends JFrame implements ActionListener {
    private TaiKhoanBLL taiKhoanBLL = new TaiKhoanBLL();
    private JButton showList, deleteBtn, addBtn, searchBtn, changePassword;
    private JTable taiKhoanTB;
    private DefaultTableModel dtm;
    private Vector<TaiKhoanDTO> listTaiKhoan = new Vector<TaiKhoanDTO>();
    private JTextField inputSearchTF;
    public TaiKhoanGUI(){
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
        JLabel inputSearchLB = new JLabel("Nhập mã tài khoản: ");
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
        listArea.add(loadTaiKhoanList(), BorderLayout.CENTER);
        
        //Button area
        JPanel btnArea = new JPanel(new GridLayout(1, 4, 100, 0));
        //btnArea.setPreferredSize(new Dimension(1000, 40));
        
        
        deleteBtn = new JButton("Xóa", new ImageIcon("image/delete.png"));
        deleteBtn.addActionListener(this);
        btnArea.add(deleteBtn);
        
        showList = new JButton("Xem danh sách", new ImageIcon("image/invoice-btn.png"));
        showList.addActionListener(this);
        btnArea.add(showList);
        
        changePassword = new JButton("Đổi mật khẩu", new ImageIcon("image/edit.png"));
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
    
    public JScrollPane loadTaiKhoanList(){
        taiKhoanTB = new JTable();
        dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã tài khoản");
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Username");
        dtm.addColumn("Password");
        taiKhoanTB.setModel(dtm);
        JScrollPane sp = new JScrollPane(taiKhoanTB);
        loadDataTable();
        return sp;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == showList){
            taiKhoanTB.setModel(dtm);
        }
        if(e.getSource() == addBtn){
            dialogTaoTaiKhoan();
        }
        if(e.getSource() == deleteBtn){
            xoaTaiKhoan();
        }
        if(e.getSource() == searchBtn){
            timKiem();
        }
        if(e.getSource() == changePassword){
            doiMatKhau();
        }
    }
    
    public void xoaTaiKhoan(){
        int i = taiKhoanTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(taiKhoanTB.getValueAt(i, 1));
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản " + id + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
                if(taiKhoanBLL.deleteTaiKhoan(id)){
                JOptionPane.showMessageDialog(this, "Đã xóa tài khoản");
                loadDataTable();
            }
            else
                JOptionPane.showMessageDialog(this, "Không thể xóa tài khoản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã tài khoản: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(taiKhoanBLL.existID(inputID)){
                    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa tài khoản " + inputID + " không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if(confirm == JOptionPane.YES_OPTION){
                        if(taiKhoanBLL.deleteTaiKhoan(inputID)){
                            JOptionPane.showMessageDialog(this, "Đã xóa tài khoản");
                            loadDataTable();
                        }
                        else
                            JOptionPane.showMessageDialog(this, "Không thể xóa tài khoản!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        }
                    
                    }
                else
                    JOptionPane.showMessageDialog(this, "Mã tài khoản không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void timKiem(){
        DefaultTableModel searchDtm = new DefaultTableModel();
        searchDtm.addColumn("STT");
        searchDtm.addColumn("Mã tài khoản");
        searchDtm.addColumn("Mã nhân viên");
        searchDtm.addColumn("Username");
        searchDtm.addColumn("Password");
        boolean result = false;
        if(inputSearchTF.getText() != null && !inputSearchTF.getText().trim().equals("")){
            for(int i = 0; i < listTaiKhoan.size(); i++){
                TaiKhoanDTO taiKhoan = listTaiKhoan.get(i);
                if(taiKhoan.getMaTK().equals(inputSearchTF.getText())){
                    searchDtm.addRow(new Object[]{
                    1, taiKhoan.getMaTK(), taiKhoan.getMaNV(), taiKhoan.getUsername(), taiKhoan.getPassword()
                    });
                    taiKhoanTB.setModel(searchDtm);
                    result = true;
                }
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã tài khoản!", "Lỗi", JOptionPane.ERROR_MESSAGE);                 
    }
    public void loadDataTable(){
        listTaiKhoan = taiKhoanBLL.getAllTaiKhoan();
        dtm.setRowCount(0);
        int stt = 1;
        for(TaiKhoanDTO tk : listTaiKhoan){
            Vector<Object> record = new Vector<>();
            record.add(stt);
            record.add(tk.getMaTK());
            record.add(tk.getMaNV());
            record.add(tk.getUsername());
            record.add(tk.getPassword());
            dtm.addRow(record);
            stt++;
        }
    }
    public void doiMatKhau(){
        int i = taiKhoanTB.getSelectedRow();
        if(i >= 0){
            String id = String.valueOf(taiKhoanTB.getValueAt(i, 1));
            String newPass =JOptionPane.showInputDialog("Nhập mật khẩu mới: ");
            if(newPass != null && !newPass.trim().equals("")) {
                JOptionPane.showMessageDialog(this, taiKhoanBLL.updateTaiKhoan(id, newPass));
            }
            else
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu mới!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String inputID =JOptionPane.showInputDialog("Nhập mã tài khoản: ");
            if(inputID != null && !inputID.trim().equals("")) {
                if(taiKhoanBLL.existID(inputID)){
                    String newPass =JOptionPane.showInputDialog("Nhập mật khẩu mới: ");
                    if(newPass != null && !newPass.trim().equals(""))
                        JOptionPane.showMessageDialog(this, taiKhoanBLL.updateTaiKhoan(inputID, newPass));
                    else
                        JOptionPane.showMessageDialog(this, "Bạn chưa nhập mật khẩu mới!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(this, "Mã tài khoản không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void dialogTaoTaiKhoan(){
        JDialog dialog = new JDialog(this, "Tạo tài khoản", true);
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setSize(500,350);
        
        JLabel titleLB = new JLabel("TẠO TÀI KHOẢN MỚI");
        titleLB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        titleLB.setBounds(150, 50, 250, 50);
        contentPanel.add(titleLB);
        
        JLabel usernameLB = new JLabel("Tên đăng nhập:");
        usernameLB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameLB.setBounds(100, 125, 150, 25);
        contentPanel.add(usernameLB);
        
        JTextField usernameTF = new JTextField(25);
        usernameTF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameTF.setBounds(250, 125, 150, 25);
        contentPanel.add(usernameTF);
        
        JLabel passwordLB = new JLabel("         Mật khẩu:");
        passwordLB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordLB.setBounds(100, 175, 150, 25);
        contentPanel.add(passwordLB);
        
        JTextField passwordTF = new JPasswordField(25);
        passwordTF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordTF.setBounds(250, 175, 150, 25);
        contentPanel.add(passwordTF);
        
        JLabel maNVLB = new JLabel("   Mã nhân viên:");
        maNVLB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        maNVLB.setBounds(100, 225, 150, 25);
        contentPanel.add(maNVLB);
        
        JTextField maNVTF = new JTextField(25);
        maNVTF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        maNVTF.setBounds(250, 225, 150, 25);
        contentPanel.add(maNVTF);
        
        JButton createAccBtn = new JButton("Tạo tài khoản");
        createAccBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        createAccBtn.setBackground(Color.ORANGE);
        createAccBtn.setBounds(175, 275, 150, 25);
        contentPanel.add(createAccBtn);
              
        createAccBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String maTK = taiKhoanBLL.taoIDTuDong();
                if(usernameTF.getText() != null && !usernameTF.getText().trim().equals("") && passwordTF.getText() != null && !passwordTF.getText().trim().equals("") && maNVTF.getText() != null && !maNVTF.getText().trim().equals("")){
                    if(taiKhoanBLL.checkMV(maNVTF.getText())){
                        if(taiKhoanBLL.kiemTraMaTKOfNV(maNVTF.getText())){
                            int confirm = JOptionPane.showConfirmDialog(dialog, "Nhân viên " + maNVTF.getText() + " đã có tài khoản. Bạn muốn thay đổi nó không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                            if(confirm == JOptionPane.YES_OPTION){
                                TaiKhoanDTO tk = new TaiKhoanDTO(maTK, usernameTF.getText(), passwordTF.getText());
                                JOptionPane.showMessageDialog(dialog, taiKhoanBLL.addTaiKhoan(tk));
                                taiKhoanBLL.setMaTK(maTK, maNVTF.getText());
                                dialog.setVisible(false);
                                loadDataTable();
                            }
                        }
                        else{
                            TaiKhoanDTO tk = new TaiKhoanDTO(maTK, usernameTF.getText(), passwordTF.getText());
                            JOptionPane.showMessageDialog(dialog, taiKhoanBLL.addTaiKhoan(tk));
                            taiKhoanBLL.setMaTK(maTK, maNVTF.getText());
                            dialog.setVisible(false);
                            loadDataTable();
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(dialog, "Mã nhân viên không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(dialog, "Vui lòng nhập đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.setSize(500, 400);
        dialog.setContentPane(contentPanel);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
}
