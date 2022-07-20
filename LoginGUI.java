/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import BLL.*;
/**
 *
 * @author thienvu
 */
public class LoginGUI extends JFrame implements ActionListener {
    private JTextField usernameTF;
    private JPasswordField passwordTF;
    private JButton loginBtn;
    private TaiKhoanBLL taiKhoanBLL = new TaiKhoanBLL();
    public static HeThongGUI ht = new HeThongGUI();
    public static String maNVLogin = "";
    public LoginGUI(){
        initComponents();
    }
    public void initComponents(){
        setTitle("Phần mềm quản lý cửa hàng sách");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        //set Icon
        ImageIcon img = new ImageIcon("image/book.png");
        setIconImage(img.getImage());
        contentArea();
    }
    public void contentArea(){
        JPanel container = new JPanel();
        container.setLayout(null);
        setContentPane(container);
        
        JLabel titleLB = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
        titleLB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        titleLB.setBounds(150, 50, 250, 50);
        container.add(titleLB);
        
        JLabel usernameLB = new JLabel("Tên đăng nhập:");
        usernameLB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameLB.setBounds(100, 125, 150, 25);
        container.add(usernameLB);
        
        usernameTF = new JTextField(25);
        usernameTF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        usernameTF.setBounds(250, 125, 150, 25);
        container.add(usernameTF);
        
        JLabel passwordLB = new JLabel("         Mật khẩu:");
        passwordLB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordLB.setBounds(100, 175, 150, 25);
        container.add(passwordLB);
        
        passwordTF = new JPasswordField(25);
        passwordTF.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordTF.setBounds(250, 175, 150, 25);
        container.add(passwordTF);
        
        loginBtn = new JButton("Đăng nhập");
        loginBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        loginBtn.setBackground(Color.ORANGE);
        loginBtn.setBounds(175, 225, 150, 25);
        loginBtn.addActionListener(this);
        container.add(loginBtn);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginBtn){
            if(taiKhoanBLL.checkLogin(usernameTF.getText(), String.valueOf(passwordTF.getPassword()))){
                maNVLogin = taiKhoanBLL.getMaNV(usernameTF.getText(), String.valueOf(passwordTF.getPassword()));
                ht.setVisible(true);
                this.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);                              
        }
    }
    
}
