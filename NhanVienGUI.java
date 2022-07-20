package GUI;

import javax.swing.JFrame;
import BUS.NhanVienBUS;
import BUS.CheckText;
import DTO.NhanVienDTO;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.System.Logger;
import java.security.interfaces.RSAKey;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhanVienGUI extends javax.swing.JFrame {
    NhanVienBUS nvBUS = new NhanVienBUS();

    public NhanVienGUI() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadNhanVienlist();
        loadId();
        setLocationRelativeTo(null); 
        
    }
    public void loadId(){
        txtManhanvien.setText(nvBUS.autoID());       
    }
    public void loadNhanVienlist(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã nhân viên");
        dtm.addColumn("Họ đệm");
        dtm.addColumn("Tên");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Email");
        dtm.addColumn("Sdt");
        Table.setModel(dtm);
        Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
        arr = nvBUS.getAllNhanVien();
        for(int i =0; i < arr.size(); i++){
            NhanVienDTO nv = arr.get(i);
            String MaNV = nv.getMaNV();
            String HoDem = nv.getHoDem();
            String Ten = nv.getTen();
            String DiaChi = nv.getDiaChi();
            String NgaySinh = nv.getNgaySinh();
            String GioiTinh = nv.getGioiTinh();
            String Email = nv.getEmail();
            String Sdt = nv.getSdt();
            int TrangThai = nv.getTrangThai();
            if(TrangThai == 1){
                Object[] row = {MaNV,HoDem,Ten,DiaChi,NgaySinh,GioiTinh,Email,Sdt,TrangThai};
                            dtm.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        paHoadon = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        paSanpham = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        paKhachhang = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        paNhanvien = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbTimnhanvien = new javax.swing.JLabel();
        btnTimkiem = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        lbDanhsach = new javax.swing.JLabel();
        Table_croll = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbManhanvien = new javax.swing.JLabel();
        txtManhanvien = new javax.swing.JTextField();
        checktxtManhanvien = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbHodem = new javax.swing.JLabel();
        txtHodem = new javax.swing.JTextField();
        checktxtHodem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbTen = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        checktxtTen = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        lbDiachi = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        checktxtDiachi = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbNgaysinh = new javax.swing.JLabel();
        txtNgaysinh = new javax.swing.JTextField();
        checktxtNgaysinh = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        lbGioitinh = new javax.swing.JLabel();
        cmbGioitinh = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        checktxtEmail = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        lbSdt = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        checktxtSdt = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        findMenubar = new javax.swing.JMenuBar();
        fmeuHethong = new javax.swing.JMenu();
        hethongItem = new javax.swing.JMenuItem();
        fmeuHoadon = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        fmeuSanpham = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        fmeuKhachhang = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        fmeuNhanvien = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        fmeuTaikhoan = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý cửa hàng sách");

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        paHoadon.setBackground(new java.awt.Color(255, 153, 0));

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/receipt.png")); // NOI18N
        jButton1.setText("Hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paHoadonLayout = new javax.swing.GroupLayout(paHoadon);
        paHoadon.setLayout(paHoadonLayout);
        paHoadonLayout.setHorizontalGroup(
            paHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paHoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paHoadonLayout.setVerticalGroup(
            paHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paHoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        paSanpham.setBackground(new java.awt.Color(255, 153, 0));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/products.png")); // NOI18N
        jButton2.setText("Sản phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paSanphamLayout = new javax.swing.GroupLayout(paSanpham);
        paSanpham.setLayout(paSanphamLayout);
        paSanphamLayout.setHorizontalGroup(
            paSanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paSanphamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paSanphamLayout.setVerticalGroup(
            paSanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paSanphamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        paKhachhang.setBackground(new java.awt.Color(255, 153, 0));

        jButton3.setBackground(new java.awt.Color(255, 153, 0));
        jButton3.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/customer.png")); // NOI18N
        jButton3.setText("Khách hàng");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paKhachhangLayout = new javax.swing.GroupLayout(paKhachhang);
        paKhachhang.setLayout(paKhachhangLayout);
        paKhachhangLayout.setHorizontalGroup(
            paKhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paKhachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paKhachhangLayout.setVerticalGroup(
            paKhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paKhachhangLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        paNhanvien.setBackground(new java.awt.Color(255, 153, 0));

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/employees.png")); // NOI18N
        jButton4.setText("Nhân viên");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paNhanvienLayout = new javax.swing.GroupLayout(paNhanvien);
        paNhanvien.setLayout(paNhanvienLayout);
        paNhanvienLayout.setHorizontalGroup(
            paNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paNhanvienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paNhanvienLayout.setVerticalGroup(
            paNhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paNhanvienLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paSanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paHoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paKhachhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paNhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(paSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(paNhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        lbTimnhanvien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTimnhanvien.setText("Tìm nhân viên:");

        btnTimkiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimkiem.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/search.png")); // NOI18N
        btnTimkiem.setText("Tìm kiếm");

        txtTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimkiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTimnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnTimkiem)
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTimnhanvien)
                    .addComponent(btnTimkiem)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbDanhsach.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbDanhsach.setText("Danh sách:");

        Table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Họ đệm", "Tên", "Địa chỉ", "Ngày sinh", "Giới tính", "Email", "Sđt"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        Table_croll.setViewportView(Table);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        lbManhanvien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbManhanvien.setText("MaNV:");

        txtManhanvien.setEditable(false);
        txtManhanvien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtManhanvienKeyReleased(evt);
            }
        });

        checktxtManhanvien.setEditable(false);
        checktxtManhanvien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checktxtManhanvien.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbManhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checktxtManhanvien)
                    .addComponent(txtManhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checktxtManhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbHodem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbHodem.setText("Họ đệm:");

        txtHodem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHodemKeyReleased(evt);
            }
        });

        checktxtHodem.setEditable(false);
        checktxtHodem.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHodem, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checktxtHodem)
                    .addComponent(txtHodem, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbHodem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHodem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checktxtHodem)
                .addContainerGap())
        );

        lbTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTen.setText("Tên:");

        txtTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenKeyReleased(evt);
            }
        });

        checktxtTen.setEditable(false);
        checktxtTen.setBorder(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checktxtTen)
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checktxtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbDiachi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDiachi.setText("Địa chỉ:");

        txtDiachi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiachiKeyReleased(evt);
            }
        });

        checktxtDiachi.setEditable(false);
        checktxtDiachi.setBorder(null);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checktxtDiachi)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDiachi)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checktxtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbNgaysinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgaysinh.setText("Ngày sinh:");

        txtNgaysinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNgaysinhKeyReleased(evt);
            }
        });

        checktxtNgaysinh.setEditable(false);
        checktxtNgaysinh.setBorder(null);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checktxtNgaysinh)
                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgaysinh)
                    .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checktxtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        lbGioitinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbGioitinh.setText("Giới tính:");

        cmbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGioitinh)
                    .addComponent(cmbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lbEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEmail.setText("Email:");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        checktxtEmail.setEditable(false);
        checktxtEmail.setBorder(null);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(checktxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checktxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbSdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbSdt.setText("Sdt:");

        txtSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSdtKeyReleased(evt);
            }
        });

        checktxtSdt.setEditable(false);
        checktxtSdt.setBorder(null);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checktxtSdt)
                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSdt)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(checktxtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/add.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/edit.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/delete.png")); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLammoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLammoi.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/clear.png")); // NOI18N
        btnLammoi.setText("Clean");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        fmeuHethong.setText("Hệ thống");
        fmeuHethong.setPreferredSize(new java.awt.Dimension(59, 19));

        hethongItem.setText("Trang chủ");
        hethongItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hethongItemActionPerformed(evt);
            }
        });
        fmeuHethong.add(hethongItem);

        findMenubar.add(fmeuHethong);

        fmeuHoadon.setText("Hóa đơn");

        jMenuItem1.setText("Quản lý hóa đơn");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fmeuHoadon.add(jMenuItem1);

        findMenubar.add(fmeuHoadon);

        fmeuSanpham.setText("Sản phẩm");

        jMenuItem2.setText("Quản lý sản phẩm");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        fmeuSanpham.add(jMenuItem2);

        findMenubar.add(fmeuSanpham);

        fmeuKhachhang.setText("Khách hàng");

        jMenuItem3.setText("Quản lý khách hàng");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        fmeuKhachhang.add(jMenuItem3);

        findMenubar.add(fmeuKhachhang);

        fmeuNhanvien.setText("Nhân viên");
        fmeuNhanvien.setVerifyInputWhenFocusTarget(false);

        jMenuItem4.setText("Quản lý nhân viên");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        fmeuNhanvien.add(jMenuItem4);

        findMenubar.add(fmeuNhanvien);

        fmeuTaikhoan.setText("Tài khoản");

        jMenuItem5.setText("Tài khoản");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        fmeuTaikhoan.add(jMenuItem5);

        findMenubar.add(fmeuTaikhoan);

        setJMenuBar(findMenubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Table_croll, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Table_croll, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   public void clearField(){
       txtManhanvien.setText(null);
       txtHodem.setText(null);
       txtTen.setText(null);
       txtSdt.setText(null);
       txtNgaysinh.setText(null);
       txtEmail.setText(null);
       txtDiachi.setText(null);
   }
   
   
       
    public void TimKiem(String str){
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        Table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    private void txtTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimkiemKeyReleased
        String serchString = txtTimkiem.getText();
        TimKiem(serchString);
    }//GEN-LAST:event_txtTimkiemKeyReleased
    
    
    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        int row = Table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)Table.getModel();
        if(row != -1){
            txtManhanvien.setText(Table.getValueAt(row, 0).toString());
            txtHodem.setText(Table.getValueAt(row, 1).toString());
            txtTen.setText(Table.getValueAt(row, 2).toString());
            txtDiachi.setText(Table.getValueAt(row, 3).toString());
            txtNgaysinh.setText(Table.getValueAt(row, 4).toString());
            cmbGioitinh.setSelectedItem(Table.getValueAt(row, 5).toString());
            txtEmail.setText(Table.getValueAt(row, 6).toString());
            txtSdt.setText(Table.getValueAt(row, 7).toString());
        }
    }//GEN-LAST:event_TableMouseClicked

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        clearField();
        loadId();
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       DefaultTableModel model = (DefaultTableModel)Table.getModel();
       boolean flag = true;
        try{
            if(txtManhanvien.getText().trim().equals("") || txtHodem.getText().trim().equals("") 
                    || txtTen.getText().trim().equals("") || txtSdt.getText().trim().equals("") ||
                    txtNgaysinh.getText().trim().equals("") || txtEmail.getText().trim().equals("") ||
                    txtDiachi.getText().trim().equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
                flag = false;
            }
            if(!txtEmail.getText().trim().equals("")){
                if(!CheckText.isGmail(txtEmail.getText())){
                    JOptionPane.showMessageDialog(this, "email không hợp lệ");
                    flag = false;
                }
            }
            if(!txtSdt.getText().trim().equals("")){
                if(!CheckText.isPhoneNumber(txtSdt.getText())){
                    JOptionPane.showMessageDialog(this, "Sdt không hợp lệ");
                    flag = false;
                }
            }
            if(!txtNgaysinh.getText().trim().equals("")){
                if(CheckText.Date(txtNgaysinh.getText()) == false){    
                    JOptionPane.showMessageDialog(this, "ngày sinh không hợp lệ");
                    flag = false;
                }
            }
            
            if(flag == true){
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(txtManhanvien.getText());
                nv.setHoDem(txtHodem.getText());
                nv.setTen(txtTen.getText());
                nv.setDiaChi(txtDiachi.getText());
                nv.setNgaySinh(txtNgaysinh.getText());
                nv.setGioiTinh(cmbGioitinh.getSelectedItem().toString());
                nv.setEmail(txtEmail.getText());
                nv.setSdt(txtSdt.getText());                
                nv.setTrangThai(1);                
                JOptionPane.showMessageDialog(this,nvBUS.addNhanVien(nv));
                loadNhanVienlist();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        NhanVienDTO nvDTO = new NhanVienDTO();
        nvDTO.setMaNV(txtManhanvien.getText());
        NhanVienBUS nvBUS = new NhanVienBUS();
        if(txtManhanvien.getText().isEmpty() ||txtHodem.getText().isEmpty() || txtTen.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Bạn chưa chọn nhân viên để xoá");
        }else{
            int choice = JOptionPane.showConfirmDialog(this, "bạn muốn xóa", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                try{
                String result = nvBUS.deleteNhanVien(nvDTO);
                int TrangThai = nvDTO.getTrangThai();
                loadNhanVienlist();
                clearField();
                }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        }
        loadId();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        DefaultTableModel model = (DefaultTableModel)Table.getModel();
        boolean flag = true;
        try{
           if(txtManhanvien.getText().trim().equals("") || txtHodem.getText().trim().equals("") 
                    || txtTen.getText().trim().equals("") || txtSdt.getText().trim().equals("") ||
                    txtNgaysinh.getText().trim().equals("") || txtEmail.getText().trim().equals("") ||
                    txtDiachi.getText().trim().equals("")){
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần sửa");
                flag = false;
           }
           if(!txtEmail.getText().trim().equals("")){
                if(!CheckText.isGmail(txtEmail.getText())){
                    flag = false;
                    JOptionPane.showMessageDialog(this, "email không hợp lệ");
                }
           }
           if( !txtSdt.getText().trim().equals("")){
                if(!CheckText.isPhoneNumber(txtSdt.getText())){
                    flag = false;
                    JOptionPane.showMessageDialog(this, "Sdt không hợp lệ");
                }
           }
           if(!txtNgaysinh.getText().trim().equals("")){
                if(CheckText.Date(txtNgaysinh.getText()) == false){
                    JOptionPane.showMessageDialog(this, "Sdt không hợp lệ");
                    flag = false;
                }
           }
            if(flag == true){
               NhanVienDTO nv = new NhanVienDTO();
               nv.setMaNV(txtManhanvien.getText());
               nv.setHoDem(txtHodem.getText());
               nv.setTen(txtTen.getText());
               nv.setDiaChi(txtDiachi.getText());
               nv.setNgaySinh(txtNgaysinh.getText());
               nv.setGioiTinh(cmbGioitinh.getSelectedItem().toString());
               nv.setEmail(txtEmail.getText());
               nv.setSdt(txtSdt.getText());
               JOptionPane.showMessageDialog(this, nvBUS.updateNhanVien(nv));
               loadNhanVienlist();
               clearField();
               loadId();
               }  
        }catch(Exception ex){
           JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
       }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtManhanvienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtManhanvienKeyReleased
       
    }//GEN-LAST:event_txtManhanvienKeyReleased

    private void txtHodemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHodemKeyReleased
        if(txtHodem.getText() != null){
            checktxtHodem.setText("vd: Đỗ Minh");
            if(CheckText.isName(txtHodem.getText()) == false)
                JOptionPane.showMessageDialog(null,"Vui lòng không nhập ký tự đặc biệt");
            if(CheckText.haveNumber(txtHodem.getText()) == true)
                JOptionPane.showMessageDialog(null,"Vui lòng không nhập số");   
        }
    }//GEN-LAST:event_txtHodemKeyReleased

    private void txtTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKeyReleased
        if(txtTen.getText() != null){
            checktxtTen.setText("vd: Hiếu");
            if(CheckText.isName(txtTen.getText()) == false)
                JOptionPane.showMessageDialog(null,"Vui lòng không nhập ký tự đặc biệt");
            if(CheckText.haveNumber(txtTen.getText()))
                JOptionPane.showMessageDialog(null,"Vui lòng không nhập số");   
        }
    }//GEN-LAST:event_txtTenKeyReleased

    private void txtDiachiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiachiKeyReleased
        if(txtDiachi.getText() != null){
            checktxtDiachi.setText("vd:214/32, Nguyễn Tri Phương");
            if(CheckText.isName(txtDiachi.getText()) == false)
                JOptionPane.showMessageDialog(null,"Vui lòng không nhập ký tự đặc biệt");
        }
    }//GEN-LAST:event_txtDiachiKeyReleased

    private void txtNgaysinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNgaysinhKeyReleased
        if(txtNgaysinh.getText() != null){
            checktxtNgaysinh.setText("vd:26/03/2002");
            if(CheckText.Date(txtNgaysinh.getText()) == false)
                checktxtNgaysinh.setText("không hợp lệ");
            else 
                checktxtNgaysinh.setText(null);
        }
    }//GEN-LAST:event_txtNgaysinhKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if(txtEmail.getText() != null){
            checktxtEmail.setText("vd:john@gmail.com");
            if(!CheckText.isGmail(txtEmail.getText())){
                checktxtEmail.setText("không hợp lệ.");
                if(CheckText.isUpper(txtEmail.getText()) == false)
                    JOptionPane.showMessageDialog(null,"Vui lòng không nhập ký tự hoa");
            }    
            else
                checktxtEmail.setText(null);

        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtSdtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSdtKeyReleased
        if(txtSdt.getText() != null){
            checktxtSdt.setText("vd:0373736119");
            if(!CheckText.isPhoneNumber(txtSdt.getText()))
                checktxtSdt.setText("Sdt không hợp lệ");
            else 
                checktxtSdt.setText(null);
        }
    }//GEN-LAST:event_txtSdtKeyReleased

    private void hethongItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hethongItemActionPerformed
            LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_hethongItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(true);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(true);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginGUI.ht.setVisible(false);
            HeThongGUI.hd.setVisible(true);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(true);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HeThongGUI.hd.setVisible(true);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(true);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(true);
            HeThongGUI.tk.setVisible(false);  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(true);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed
    
    

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane Table_croll;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTextField checktxtDiachi;
    private javax.swing.JTextField checktxtEmail;
    private javax.swing.JTextField checktxtHodem;
    private javax.swing.JTextField checktxtManhanvien;
    private javax.swing.JTextField checktxtNgaysinh;
    private javax.swing.JTextField checktxtSdt;
    private javax.swing.JTextField checktxtTen;
    private javax.swing.JComboBox<String> cmbGioitinh;
    private javax.swing.JMenuBar findMenubar;
    private javax.swing.JMenu fmeuHethong;
    private javax.swing.JMenu fmeuHoadon;
    private javax.swing.JMenu fmeuKhachhang;
    private javax.swing.JMenu fmeuNhanvien;
    private javax.swing.JMenu fmeuSanpham;
    private javax.swing.JMenu fmeuTaikhoan;
    private javax.swing.JMenuItem hethongItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbDanhsach;
    private javax.swing.JLabel lbDiachi;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGioitinh;
    private javax.swing.JLabel lbHodem;
    private javax.swing.JLabel lbManhanvien;
    private javax.swing.JLabel lbNgaysinh;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbTimnhanvien;
    private javax.swing.JPanel paHoadon;
    private javax.swing.JPanel paKhachhang;
    private javax.swing.JPanel paNhanvien;
    private javax.swing.JPanel paSanpham;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHodem;
    private javax.swing.JTextField txtManhanvien;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables

}
