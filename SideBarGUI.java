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
public class SideBarGUI implements ActionListener {
    private JPanel panelSB;
    private JButton hoaDonBtn, sanPhamBtn, phieuNhapBtn, khachHangBtn, nhanVienBtn;
    private ImageIcon hoaDonIcon, sanPhamIcon, phieuNhapIcon, khachHangIcon, nhanVienIcon;
    
    public SideBarGUI() {}
    
    public JPanel createSideBar(){
        panelSB = new JPanel();
        panelSB.setPreferredSize(new Dimension(200, 800));
        panelSB.setBackground(Color.ORANGE);
        panelSB.setLayout(new GridLayout(5, 1));

        
        //Các button
        final int BtnSB_WIDTH = 150;
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
        
        panelSB.add(hoaDonBtn); 
        panelSB.add(sanPhamBtn); 
        panelSB.add(phieuNhapBtn); 
        panelSB.add(khachHangBtn); 
        panelSB.add(nhanVienBtn);
        
        return panelSB;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == hoaDonBtn){
            HeThongGUI.hd.setVisible(true);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == sanPhamBtn){
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(true);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == phieuNhapBtn){
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(true);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == khachHangBtn){
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(true);
            HeThongGUI.tk.setVisible(false);  
        }
        if(e.getSource() == nhanVienBtn){
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(true);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
    }
}
