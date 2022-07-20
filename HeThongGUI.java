/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import GUI.*;

/**
 *
 * @author thienvu
 */
public class HeThongGUI extends JFrame implements ActionListener {
    private JButton hoaDonBtn, phieuNhapBtn, sanPhamBtn, nhanVienBtn, khachHangBtn, taiKhoanBtn;
    private ImageIcon hoaDonIcon, sanPhamIcon, phieuNhapIcon, khachHangIcon, nhanVienIcon, taiKhoanIcon;
    static public HoaDonGUI hd = new HoaDonGUI();
    static public PhieuNhapGUI pn = new PhieuNhapGUI();
    static public SanPhamGUI sp = new SanPhamGUI();
    static public customerGUI kh = new customerGUI();      
    static public NhanVienGUI nv = new NhanVienGUI();
    static public TaiKhoanGUI tk = new TaiKhoanGUI();
    static public ChiTietHoaDonGUI cthd = new ChiTietHoaDonGUI();
    static public ChiTietPhieuNhapGUI ctpn = new ChiTietPhieuNhapGUI();
    public HeThongGUI(){
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
        contentArea();
    }
    
    public void contentArea(){
        JPanel container = new JPanel(new GridLayout(3, 2, 20, 20));
     
        //Các button
        final int BtnSB_WIDTH = 100;
        final int BtnSB_HEIGHT = 100;
        hoaDonIcon = new ImageIcon("image/receipt.png");
        hoaDonBtn = new JButton("Quản lý hóa đơn", hoaDonIcon);
        hoaDonBtn.setPreferredSize(new Dimension(BtnSB_WIDTH, BtnSB_HEIGHT));
        hoaDonBtn.setBackground(Color.ORANGE);
        hoaDonBtn.setBorder(null);
        hoaDonBtn.addActionListener(this);
        
        sanPhamIcon = new ImageIcon("image/products.png");
        sanPhamBtn = new JButton("Quản lý sản phẩm", sanPhamIcon);
        sanPhamBtn.setPreferredSize(new Dimension(BtnSB_WIDTH, BtnSB_HEIGHT));
        sanPhamBtn.setBackground(Color.ORANGE);
        sanPhamBtn.setBorder(null);
        sanPhamBtn.addActionListener(this);
        
        phieuNhapIcon = new ImageIcon("image/add.png");
        phieuNhapBtn = new JButton("Quản lý phiếu nhập", phieuNhapIcon);
        phieuNhapBtn.setPreferredSize(new Dimension(BtnSB_WIDTH, BtnSB_HEIGHT));
        phieuNhapBtn.setBackground(Color.ORANGE);
        phieuNhapBtn.setBorder(null);
        phieuNhapBtn.addActionListener(this);
        
        khachHangIcon = new ImageIcon("image/customer.png");
        khachHangBtn = new JButton("Quản lý khách hàng", khachHangIcon);
        khachHangBtn.setPreferredSize(new Dimension(BtnSB_WIDTH, BtnSB_HEIGHT));
        khachHangBtn.setBackground(Color.ORANGE);
        khachHangBtn.setBorder(null);
        khachHangBtn.addActionListener(this);
        
        nhanVienIcon = new ImageIcon("image/employees.png");
        nhanVienBtn = new JButton("Quản lý nhân viên", nhanVienIcon);
        nhanVienBtn.setPreferredSize(new Dimension(BtnSB_WIDTH, BtnSB_HEIGHT));
        nhanVienBtn.setBackground(Color.ORANGE);
        nhanVienBtn.setBorder(null);
        nhanVienBtn.addActionListener(this);
        
        taiKhoanIcon = new ImageIcon("image/employee.png");
        taiKhoanBtn = new JButton("Quản lý tài khoản", nhanVienIcon);
        taiKhoanBtn.setPreferredSize(new Dimension(BtnSB_WIDTH, BtnSB_HEIGHT));
        taiKhoanBtn.setBackground(Color.ORANGE);
        taiKhoanBtn.setBorder(null);
        taiKhoanBtn.addActionListener(this);
        
        container.add(hoaDonBtn); 
        container.add(sanPhamBtn); 
        container.add(phieuNhapBtn); 
        container.add(khachHangBtn); 
        container.add(nhanVienBtn);
        container.add(taiKhoanBtn);
        add(container, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == hoaDonBtn){
            setVisible(false);
            hd.setVisible(true);
            pn.setVisible(false);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(false);
            tk.setVisible(false);
        }
        if(e.getSource() == sanPhamBtn){
            setVisible(false);
            hd.setVisible(false);
            pn.setVisible(false);
            sp.setVisible(true);
            nv.setVisible(false);
            kh.setVisible(false);
            tk.setVisible(false);
        }
        if(e.getSource() == phieuNhapBtn){
            setVisible(false);
            hd.setVisible(false);
            pn.setVisible(true);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(false);
            tk.setVisible(false);
        }
        if(e.getSource() == khachHangBtn){
            setVisible(false);
            hd.setVisible(false);
            pn.setVisible(false);
            sp.setVisible(false);
            nv.setVisible(false);
            kh.setVisible(true);
            tk.setVisible(false);  
        }
        if(e.getSource() == nhanVienBtn){
            setVisible(false);
            hd.setVisible(false);
            pn.setVisible(false);
            sp.setVisible(false);
            nv.setVisible(true);
            kh.setVisible(false);
            tk.setVisible(false);
        }
    }
}
