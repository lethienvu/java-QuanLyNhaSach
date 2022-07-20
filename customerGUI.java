package GUI;

import javax.swing.JFrame;
import BLL.customerBLL;
import DTO.customerDTO;
import java.lang.System.Logger;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.MessageFormat;
import java.util.Vector;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
//
import java.util.regex.*;
public class customerGUI extends javax.swing.JFrame {
    customerBLL cusBLL = new customerBLL();
    public customerGUI() {        
        initComponents();      
        loadCustomerList();
        displayDateTime();
        setTitle("Phần mềm quản lý của hàng sách");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);        
    }
    public void loadCustomerList(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Họ đệm");
        dtm.addColumn("Tên");
        dtm.addColumn("Địa chỉ");
        dtm.addColumn("Ngày sinh");
        dtm.addColumn("Giới tính");
        dtm.addColumn("Email");
        dtm.addColumn("Điện thoại");
        dtm.addColumn("Tình trạng");
        table.setModel(dtm);
        Vector<customerDTO> arr = new Vector<customerDTO>();
        arr = cusBLL.getAllCustomers();
        for(int i = 0 ; i < arr.size() ; i++){
            customerDTO cus = arr.get(i);
            String maKH = cus.getMaKH();
            String hoDem = cus.getHoDem();
            String ten = cus.getTen();
            String diaChi = cus.getDiaChi();
            String ngaySinh = cus.getNgaySinh(); 
            String gioiTinh = cus.getGioiTinh();
            String email = cus.getEmail();
            String dienThoai = cus.getDienThoai();
           int tinhTrang = cus.getTinhTrang();
            if(tinhTrang == 1){
                Object[] row = {maKH,hoDem,ten,diaChi,ngaySinh,gioiTinh,email,dienThoai,tinhTrang};
                            dtm.addRow(row);
            }     
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        lbDateTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHoDem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        date_chooser = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDienThoai = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtEmailDialog = new javax.swing.JLabel();
        txtDienThoaiDialog = new javax.swing.JLabel();
        txtHoDemDialog = new javax.swing.JLabel();
        txtTenDialog = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));

        jButton3.setBackground(java.awt.Color.orange);
        jButton3.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/invoice.png")); // NOI18N
        jButton3.setText("Hóa đơn");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setBackground(java.awt.Color.orange);
        jButton7.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/products.png")); // NOI18N
        jButton7.setText("Sản phẩm");
        jButton7.setPreferredSize(new java.awt.Dimension(147, 73));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(java.awt.Color.orange);
        jButton8.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/customer.png")); // NOI18N
        jButton8.setText("Khách hàng");
        jButton8.setPreferredSize(new java.awt.Dimension(147, 73));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tìm khách hàng:");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 30));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jButton1.setBackground(java.awt.Color.orange);
        jButton1.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/search.png")); // NOI18N
        jButton1.setText("Tìm kiếm");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DANH SÁCH KHÁCH HÀNG");

        table.setForeground(java.awt.Color.red);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ đệm", "Tên", "Địa chỉ", "Ngày sinh", "Giới tính", "Email", "Điện thoại", "Tình trạng"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jButton9.setBackground(java.awt.Color.orange);
        jButton9.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/employees.png")); // NOI18N
        jButton9.setText("Nhân viên");
        jButton9.setPreferredSize(new java.awt.Dimension(147, 73));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btnAddCustomer.setBackground(java.awt.Color.orange);
        btnAddCustomer.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/add.png")); // NOI18N
        btnAddCustomer.setText("Thêm");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnDeleteCustomer.setBackground(java.awt.Color.orange);
        btnDeleteCustomer.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/delete.png")); // NOI18N
        btnDeleteCustomer.setText("Xóa");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setBackground(java.awt.Color.orange);
        btnUpdateCustomer.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/edit.png")); // NOI18N
        btnUpdateCustomer.setText("Sửa");
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        lbDateTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mã khách hàng ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Địa chỉ");

        txtMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKHKeyReleased(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Họ đệm");

        txtHoDem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoDemKeyReleased(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tên");

        txtTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenKeyReleased(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ngày sinh");

        jLabel8.setText("Giới tính");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Email");

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Điện thoại");

        txtDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDienThoaiKeyReleased(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.orange);
        jButton2.setIcon(new javax.swing.ImageIcon("/home/thienvu/NetBeansProjects/Java/ProjectJava_QLCHSach/image/clear.png")); // NOI18N
        jButton2.setText("Trống");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtEmailDialog.setForeground(java.awt.Color.red);

        txtDienThoaiDialog.setForeground(java.awt.Color.red);

        txtHoDemDialog.setForeground(java.awt.Color.red);

        txtTenDialog.setForeground(java.awt.Color.red);

        jLabel11.setForeground(java.awt.Color.red);

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", " " }));

        jMenuBar1.setPreferredSize(new java.awt.Dimension(100, 20));

        jMenu1.setText("Hệ thống");

        jMenuItem1.setText("Hệ thống");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Hóa đơn");

        jMenuItem2.setText("Quản lý hóa đơn");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sản phẩm");

        jMenuItem3.setText("Quản lý sản phẩm");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Khách hàng");

        jMenuItem4.setText("Quản lý khách hàng");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Nhân viên");

        jMenuItem5.setText("Quản lý nhân viên");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Tài khoản");

        jMenuItem6.setText("Tài khoản");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmailDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDienThoaiDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtHoDem, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtHoDemDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(txtTenDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTen))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtHoDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoDemDialog, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                    .addComponent(txtTenDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDienThoaiDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmailDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(124, 124, 124)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddCustomer)
                            .addComponent(btnUpdateCustomer)
                            .addComponent(btnDeleteCustomer)
                            .addComponent(jButton2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void search(String str){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String searchString = txtSearch.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchKeyReleased
    
    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)table.getModel();        
        try{
            if(txtMaKH.getText().trim().equals("") || txtHoDem.getText().trim().equals("") || txtTen.getText().trim().equals("") ||
                txtDiaChi.getText().trim().equals("") || date_chooser.getDate().equals("") ||
                txtEmail.getText().trim().equals("") || txtDienThoai.getText().trim().equals(""))
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            else{
                customerDTO cus = new customerDTO();
                cus.setMaKH(txtMaKH.getText());
                cus.setHoDem(txtHoDem.getText());
                cus.setTen(txtTen.getText());
                cus.setDiaChi(txtDiaChi.getText());             
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
                String date = sdf.format(date_chooser.getDate());
                cus.setNgaySinh(date);
                cus.setGioiTinh(combobox.getSelectedItem().toString());                
                cus.setEmail(txtEmail.getText());
                cus.setDienThoai(txtDienThoai.getText());
                //cus.setTinhTrang(Integer.parseInt(txtTinhTrang.getText()));
                cus.setTinhTrang(1);
                JOptionPane.showMessageDialog(this, cusBLL.addCustomer(cus));
                loadCustomerList();
                clearFields();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        if(row != -1){
            txtMaKH.setText(table.getValueAt(row, 0).toString());
            txtHoDem.setText(table.getValueAt(row, 1).toString());
            txtTen.setText(table.getValueAt(row, 2).toString());
            txtDiaChi.setText(table.getValueAt(row, 3).toString());
            try {
               Date date = (Date) new SimpleDateFormat("dd/MM/YYYY").parse((String)model.getValueAt(row, 4));
               date_chooser.setDate(date);
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(customerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }      
            combobox.setSelectedItem(table.getValueAt(row, 5).toString());
            txtEmail.setText(table.getValueAt(row, 6).toString());
            txtDienThoai.setText(table.getValueAt(row, 7).toString());
            //txtTinhTrang.setText(table.getValueAt(row, 8).toString());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        // TODO add your handling code here:
        customerDTO cusDTO = new customerDTO();
        cusDTO.setMaKH(txtMaKH.getText());
        customerBLL cusBLL = new customerBLL();
        int choice = JOptionPane.showConfirmDialog(this, "bạn muốn xóa", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            try{
                String result = cusBLL.deleteCustomer(cusDTO);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                int tinhTrang = cusDTO.getTinhTrang();            
                loadCustomerList();
                clearFields();     
            }catch(Exception e){
                     JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed
    public void clearFields(){
        txtMaKH.setText(null);
        txtHoDem.setText(null);
        txtTen.setText(null);
        txtDiaChi.setText(null);
        date_chooser.setCalendar(null);
       // txtGioiTinh.setText(null);
        txtEmail.setText(null);
        txtDienThoai.setText(null);
      //  txtTinhTrang.setText(null);
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)table.getModel();      
       try{
            if(txtMaKH.getText().trim().equals("") || txtHoDem.getText().trim().equals("") || txtTen.getText().trim().equals("") ||
                txtDiaChi.getText().trim().equals("") || date_chooser.getDate().equals("") || 
                txtEmail.getText().trim().equals("") || txtDienThoai.getText().trim().equals(""))
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
            else{
                customerDTO cus = new customerDTO();
                cus.setHoDem(txtHoDem.getText());
                cus.setTen(txtTen.getText());
                cus.setDiaChi(txtDiaChi.getText());     
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(date_chooser.getDate());
                cus.setNgaySinh(date);               
                cus.setGioiTinh(combobox.getSelectedItem().toString()); // ???               
                cus.setEmail(txtEmail.getText());
                cus.setDienThoai(txtDienThoai.getText());
                cus.setMaKH(txtMaKH.getText());
                //cus.setTinhTrang(Integer.parseInt(txtTinhTrang.getText()));
                //cus.setTinhTrang(1);
                JOptionPane.showMessageDialog(this, cusBLL.updateCustomer(cus));
                loadCustomerList();
                clearFields();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }           
    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[a-zA-z0-9]{0,30}[@][a-zA-Z0-9]{0,10}[.][a-zA-Z]{0,5}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtEmail.getText());
        if(!match.matches()){
            txtEmailDialog.setText("Không đúng định dạng email");
        }
        else{
           // txtEmailDialog.setText("Email is correct");
            txtEmailDialog.setText(null);
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtDienThoaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDienThoaiKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtDienThoai.getText());
        if(!match.matches()){
            txtDienThoaiDialog.setText("Không đúng định dạng số điện thoại");
        }else{
            txtDienThoaiDialog.setText(null);
        }
    }//GEN-LAST:event_txtDienThoaiKeyReleased

    private void txtHoDemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoDemKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[\\p{L} \\.\\-]+$"; 
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtHoDem.getText());
        if(!match.matches()){
            txtHoDemDialog.setText("Không đúng định dạng họ đệm");
        }else{
            txtHoDemDialog.setText(null);
        }
    }//GEN-LAST:event_txtHoDemKeyReleased

    private void txtTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[\\p{L} \\.\\-]+$"; 
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtTen.getText());
        if(!match.matches()){
            txtTenDialog.setText("Không đúng định dạng tên");
        }else{
            txtTenDialog.setText(null); 
        }
    }//GEN-LAST:event_txtTenKeyReleased

    private void txtMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKHKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[\\p{L} \\.\\-]+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtEmail.getText());
        if(!match.matches()){
            txtEmailDialog.setText("Không đúng định dạng email");
        }
        else{
           // txtEmailDialog.setText("Email is correct");
            txtEmailDialog.setText(null);
        }
    }//GEN-LAST:event_txtMaKHKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        LoginGUI.ht.setVisible(false);
            HeThongGUI.hd.setVisible(true);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(true);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(true);
            HeThongGUI.tk.setVisible(false);  
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(true);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        LoginGUI.ht.setVisible(true);
            HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(true);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(true);
            HeThongGUI.tk.setVisible(false); 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        LoginGUI.ht.setVisible(false);
            HeThongGUI.hd.setVisible(true);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(false);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        HeThongGUI.hd.setVisible(false);
            HeThongGUI.pn.setVisible(false);
            HeThongGUI.sp.setVisible(true);
            HeThongGUI.nv.setVisible(false);
            HeThongGUI.kh.setVisible(false);
            HeThongGUI.tk.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    public void displayDateTime(){
        Thread clock = new Thread(){
            public void run(){
                try{
                    for(;;){
                    Calendar cal = new GregorianCalendar();
                     int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int second = cal.get(Calendar.SECOND);
                int minute = cal.get(Calendar.MINUTE);
                int hour = cal.get(Calendar.HOUR);
                lbDateTime.setText("Time  "+hour+":"+minute+":"+second+"  Date "+year+"/"+month+"/"+day);
                    sleep(1000);
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        clock.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(customerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JComboBox<String> combobox;
    private com.toedter.calendar.JDateChooser date_chooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDateTime;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JLabel txtDienThoaiDialog;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtEmailDialog;
    private javax.swing.JTextField txtHoDem;
    private javax.swing.JLabel txtHoDemDialog;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    private javax.swing.JLabel txtTenDialog;
    // End of variables declaration//GEN-END:variables
}
