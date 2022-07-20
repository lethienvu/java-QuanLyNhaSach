/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.KhachHangDTO;
import javax.swing.*;
import GUI.*;
import java.awt.event.*;
/**
 *
 * @author thienvu
 */
public class MenuBarGUI implements ActionListener {
    private JMenuBar mb;
    private JMenu heThong, hoaDon, sanPham, phieuNhap, khachHang, nhanVien, taiKhoan;
    private JMenuItem heThongItem, hoaDonItem, sanPhamItem, phieuNhapItem, khachHangItem, nhanVienItem, taiKhoanItem;
    public MenuBarGUI(){}

    public JMenuBar createMenuBar(){
        mb = new JMenuBar();
        //Các menu
        heThong = new JMenu("Hệ thống");
        hoaDon = new JMenu("Hóa đơn");
        sanPham = new JMenu("Sản phẩm");
        phieuNhap = new JMenu("Phiếu nhập");
        khachHang = new JMenu("Khách hàng");
        nhanVien = new JMenu("Nhân viên");
        taiKhoan = new JMenu("Tài khoản");
        
        //Các MenuItem
        heThongItem = new JMenuItem("Trang chủ");
        hoaDonItem = new JMenuItem("Quản lý hóa đơn");
        sanPhamItem = new JMenuItem("Quản lý sản phẩm");
        phieuNhapItem = new JMenuItem("Quản lý phiếu nhập");
        nhanVienItem = new JMenuItem("Quản lý nhân viên");
        khachHangItem = new JMenuItem("Quản lý khách hàng");
        taiKhoanItem = new JMenuItem("Quản lý tài khoản");
        
        heThong.add(heThongItem);
        hoaDon.add(hoaDonItem);
        sanPham.add(sanPhamItem);
        phieuNhap.add(phieuNhapItem);
        nhanVien.add(nhanVienItem);
        khachHang.add(khachHangItem);
        taiKhoan.add(taiKhoanItem);
        
        heThongItem.addActionListener(this);
        hoaDonItem.addActionListener(this);
        sanPham.addActionListener(this);
        phieuNhapItem.addActionListener(this);
        nhanVienItem.addActionListener(this);
        khachHangItem.addActionListener(this);
        taiKhoanItem.addActionListener(this);
       
        mb.add(heThong); mb.add(hoaDon); mb.add(sanPham); mb.add(phieuNhap); mb.add(khachHang); mb.add(nhanVien);   mb.add(taiKhoan);   
        
        return mb;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == heThongItem){
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == hoaDonItem){
            LoginGUI.ht.setVisible(false);
            HeThongGUI.hd.setVisible(true);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == sanPhamItem){
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(true);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == phieuNhapItem){
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(true);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == khachHangItem){
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(true);
            HeThongGUI.tk.setVisible(false);  
        }
        if(e.getSource() == nhanVienItem){
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(true);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
        }
        if(e.getSource() == taiKhoanItem){
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(true);
        }
    }
}
