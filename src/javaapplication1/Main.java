/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Ken
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



import javax.swing.Timer;

public final class Main extends javax.swing.JFrame {
    	private String pattern;
	private Timer timer;
	private int delay;
        Object currentWindow = this;
        
        
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        int curRow = 0;
        int sellitem = 1;
        int restockitem = 1;
        int globalstock = 0;
        
        boolean addbtn  = false;
        boolean addbtn_E = false;
        boolean addbtn_C = false;
        boolean customsell = false;
        boolean customrestock = false;
        boolean custom_pass_will_enter_loop = false;
        boolean select_car_type = false;
        boolean select_car_trans = false;
        boolean select_E_bd = false;
        boolean select_gender_E = false;
        



    /**
     * Creates new form Main
     */
    
    
    public Main(String pattern) {

       this.pattern = pattern;
		this.delay = 1000;
		createTimer();
		timer.start();
    }
    public Main(String pattern, int delay){
		this.pattern = pattern;
		this.delay = delay;
		createTimer();
		timer.start();
    }
    public Main() {


        initComponents();

        setVisible(true);
        DoConnect_Inventory(); 
        
        Reload_Table_Inventory();    

        pattern = "hh:mm:ss a";
	this.delay = 1000;
	createTimer();
	timer.start();
        

    }
 
    
    
     public void DoConnect_Inventory( ) {
        
        try {
            
            String host = "jdbc:mysql://localhost/autoplanet";
            String uName = "ken";
            String uPass = "ken";
            con = DriverManager.getConnection(host, uName, uPass);            
            
          
            
        }
        catch (SQLException err) {
        JOptionPane.showMessageDialog(null, err.getMessage());
        }

    }   
     public void Reload_Table_Inventory(){
        
    try{
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM vehicle";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            Inventory_Values();       
            

    }
    catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());
    
    }
    }
     public void Inventory_Values(){
     try{
            int chasis_num_i = rs.getInt("v_cs");
            String chasis_num = Integer.toString(chasis_num_i);
            int stock_i = rs.getInt("v_stock");
            globalstock = stock_i;
            String stock = Integer.toString(stock_i);
            String name = rs.getString("v_name");
            String v_model = rs.getString("v_model");
            String v_brand = rs.getString("v_brand");
            String v_type = rs.getString("v_type");
            String v_trans = rs.getString("v_trans");
            String description = rs.getString("v_desc");
            
            field_chasis.setText(chasis_num);
            field_name.setText(name);
            field_model.setText(v_model);
            field_brand.setText(v_brand);
            field_type.setText(v_type);
            field_trans.setText(v_trans);
            field_stock.setText(stock);
            field_des.setText(description);
     
     }
     catch(SQLException err){
          JOptionPane.showMessageDialog(null, err.getMessage());     
     }
     }
     
    
     public void DoConnect_Employee( ) {
                
        try {
            
            String host = "jdbc:mysql://localhost/autoplanet";
            String uName = "ken";
            String uPass = "ken";
            con = DriverManager.getConnection(host, uName, uPass);            
          
                      
            
        }
        catch (SQLException err) {
        JOptionPane.showMessageDialog(null, err.getMessage());
        }

     }
     public void Reload_Table_Employee(){
        
    try{
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM employee";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            Employee_Values();       
            

    }
    catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());
    
    }
    }
     public void Employee_Values(){
     try{
            int id_i = rs.getInt("id_number");
            String id = Integer.toString(id_i);
            int bday_m_i = rs.getInt("bd_month");
            String bday_num_to_word = "";
            switch(bday_m_i){
                case 1:
                    bday_num_to_word = "January";
                    break;
                case 2:
                    bday_num_to_word = "Febuary";
                    break;
                case 3:
                    bday_num_to_word = "March";
                    break;
                case 4:
                    bday_num_to_word = "April";
                    break;
                case 5:
                    bday_num_to_word = "May";
                    break;
                case 6:
                    bday_num_to_word = "June";
                    break;
                case 7:
                    bday_num_to_word = "July";
                    break;
                case 8:
                    bday_num_to_word = "August";
                    break;
                case 9:
                    bday_num_to_word = "September";
                    break;
                case 10:
                    bday_num_to_word = "October";
                    break;
                case 11:
                    bday_num_to_word = "November";
                    break;
                case 12:
                    bday_num_to_word = "December";
                    break;
            
            }
            String bday_m = bday_num_to_word;
            int bday_d_i = rs.getInt("bd_day");            
            String bday_d = Integer.toString(bday_d_i);
            int bday_y_i = rs.getInt("bd_year");
            String bday_y = Integer.toString(bday_y_i);
            int sss_i = rs.getInt("sss_number");
            String sss = Integer.toString(sss_i);
            int mobile_i = rs.getInt("m_number");
            String mobile = Integer.toString(mobile_i);
            String f_name = rs.getString("f_name");
            f_name = f_name.substring(0,1).toUpperCase() + f_name.substring(1);
            String m_name = rs.getString("m_name");
            m_name = m_name.toUpperCase();
            String l_name = rs.getString("l_name");
            l_name = l_name.substring(0,1).toUpperCase() + l_name.substring(1);
            String address = rs.getString("address");
            address = address.substring(0,1).toUpperCase() + address.substring(1);
            String gender = rs.getString("gender");
            gender = gender.substring(0,1).toUpperCase() + gender.substring(1);
            String department = rs.getString("department");
            String position = rs.getString("position");
            position = position.substring(0,1).toUpperCase() + position.substring(1);
            
            field_E_ID.setText(id);
            field_E_f_name.setText(f_name);
            field_E_m_name.setText(m_name);
            field_E_l_name.setText(l_name);
            field_E_gender.setText(gender);
            field_E_bd_m.setText(bday_m);
            field_E_bd_d.setText(bday_d);
            field_E_bd_y.setText(bday_y);
            field_E_add.setText(address);
            field_E_mobile.setText(mobile);
            field_E_sss.setText(sss);
            field_E_position.setText(position);
            field_E_dept.setText(department);
            
     
     }
    
     catch(SQLException err){
          JOptionPane.showMessageDialog(null, err.getMessage());     
     }
     }
    public void Reload_Table_Client(){
        
    try{
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM client";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            Client_Values();       
            

    }
    catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());
    
    }
    }
     public void Client_Values(){
     try{
            int id_i = rs.getInt("c_id");
            String id = Integer.toString(id_i);            
            String name = rs.getString("c_name");
            String add = rs.getString("c_add");
            
            field_C_ID.setText(id);
            field_C_name.setText(name);
            field_C_add.setText(add);
     
     }
     catch(SQLException err){
          JOptionPane.showMessageDialog(null, err.getMessage());     
     }
     }
    
     public int Current_Row(){
     
         try {curRow = rs.getRow( );}
         catch(SQLException err){}
         
         return curRow;
     }
     
     
    
    
    	private void createTimer(){
		timer = new Timer(delay, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time_label.setText(new SimpleDateFormat(pattern).format(new Date()));                            
                                String month = new SimpleDateFormat("MM").format(new Date());
                                switch(month){
                                    
                                    case "01":{
                                        month_label.setText("January");
                                        break;
                                    }
                                    case "02":{
                                        month_label.setText("February");
                                        break;
                                    }
                                    case "03":{
                                        month_label.setText("March");
                                        break;
                                    }
                                    case "04":{
                                        month_label.setText("April");
                                        break;
                                    }
                                    case "05":{
                                        month_label.setText("May");
                                        break;
                                    }
                                    case "06":{
                                        month_label.setText("June");
                                        break;
                                    }
                                    case "07":{
                                        month_label.setText("July");
                                        break;
                                    }
                                    case "08":{
                                        month_label.setText("August");
                                        break;
                                    }
                                    case "09":{
                                        month_label.setText("September");
                                        break;
                                    }
                                    case "10":{
                                        month_label.setText("October");
                                        break;
                                    }
                                    case "11":{
                                        month_label.setText("November");
                                        break;
                                    }
                                    case "12":{
                                        month_label.setText("December");
                                        break;
                                    }
                                }
                                
                                
                                date_label.setText(new SimpleDateFormat("dd, yyyy").format(new Date()));
                                
			}
		});
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        inventory_panel = new javax.swing.JPanel();
        add_new_product_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        field_chasis = new javax.swing.JTextField();
        field_model = new javax.swing.JTextField();
        field_name = new javax.swing.JTextField();
        field_brand = new javax.swing.JTextField();
        field_stock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_des = new javax.swing.JTextArea();
        btnRestock = new javax.swing.JButton();
        btnSell = new javax.swing.JButton();
        sell_combo = new javax.swing.JComboBox();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        restock_combo = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        btn_Previous = new javax.swing.JButton();
        btn_Next = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        field_quant_sell = new javax.swing.JTextField();
        field_quant_rstock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        field_type = new javax.swing.JTextField();
        field_trans = new javax.swing.JTextField();
        employee_panel = new javax.swing.JPanel();
        add_new_employee = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        field_E_ID = new javax.swing.JTextField();
        field_E_f_name = new javax.swing.JTextField();
        field_E_gender = new javax.swing.JTextField();
        field_E_bd_m = new javax.swing.JTextField();
        field_E_position = new javax.swing.JTextField();
        field_E_sss = new javax.swing.JTextField();
        field_E_mobile = new javax.swing.JTextField();
        field_E_add = new javax.swing.JTextField();
        field_E_dept = new javax.swing.JTextField();
        field_E_m_name = new javax.swing.JTextField();
        field_E_l_name = new javax.swing.JTextField();
        field_E_bd_d = new javax.swing.JTextField();
        field_E_bd_y = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_E_edit = new javax.swing.JButton();
        btn_E_ok = new javax.swing.JButton();
        btn_E_delete = new javax.swing.JButton();
        btn_E_cancel = new javax.swing.JButton();
        btn_E_next = new javax.swing.JButton();
        btn_E_previous = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        add_new_client = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_E_edit1 = new javax.swing.JButton();
        btn_E_ok1 = new javax.swing.JButton();
        btn_E_delete1 = new javax.swing.JButton();
        btn_E_cancel1 = new javax.swing.JButton();
        btn_E_next1 = new javax.swing.JButton();
        btn_E_previous1 = new javax.swing.JButton();
        field_C_ID = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        field_C_name = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        field_C_add = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        time_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        month_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        create_user = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoPlanet Inventory System");
        setFocusTraversalPolicyProvider(true);
        setMaximumSize(null);
        setMinimumSize(null);
        setName("ken");
        setPreferredSize(new java.awt.Dimension(750, 600));
        setResizable(false);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setInheritsPopupMenu(true);

        inventory_panel.setPreferredSize(new java.awt.Dimension(750, 348));
        inventory_panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                inventory_panelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                inventory_panelComponentShown(evt);
            }
        });

        add_new_product_btn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_new_product_btn.setText("Add New Car");
        add_new_product_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_product_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Chasis #");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Model");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Brand");

        btn_edit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Stock");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Description");

        field_chasis.setEditable(false);
        field_chasis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_chasis.setText(" ");

        field_model.setEditable(false);
        field_model.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_model.setText(" ");

        field_name.setEditable(false);
        field_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_name.setText(" ");

        field_brand.setEditable(false);
        field_brand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_brand.setText(" ");

        field_stock.setEditable(false);
        field_stock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_stock.setText(" ");

        field_des.setColumns(20);
        field_des.setEditable(false);
        field_des.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_des.setRows(5);
        jScrollPane1.setViewportView(field_des);

        btnRestock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRestock.setText("Restock");
        btnRestock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestockActionPerformed(evt);
            }
        });

        btnSell.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSell.setText("Sell");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        sell_combo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sell_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "5", "10", "20", "custom" }));
        sell_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sell_comboActionPerformed(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_save.setText("OK");
        btn_save.setEnabled(false);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.setEnabled(false);
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        restock_combo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        restock_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "5", "10", "20", "custom" }));
        restock_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restock_comboActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_Previous.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Previous.setText("Previous Car");
        btn_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PreviousActionPerformed(evt);
            }
        });

        btn_Next.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Next.setText("Next Car");
        btn_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NextActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Pre Quantity");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Quantity");

        field_quant_sell.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_quant_sell.setEnabled(false);

        field_quant_rstock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_quant_rstock.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Type");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Transmission");

        field_type.setEditable(false);
        field_type.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_type.setText(" ");
        field_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_typeMouseClicked(evt);
            }
        });
        field_type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_typeKeyTyped(evt);
            }
        });

        field_trans.setEditable(false);
        field_trans.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_transMouseClicked(evt);
            }
        });
        field_trans.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_transKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout inventory_panelLayout = new javax.swing.GroupLayout(inventory_panel);
        inventory_panel.setLayout(inventory_panelLayout);
        inventory_panelLayout.setHorizontalGroup(
            inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(inventory_panelLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(288, 288, 288))
                        .addGroup(inventory_panelLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(297, 297, 297))
                        .addGroup(inventory_panelLayout.createSequentialGroup()
                            .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(inventory_panelLayout.createSequentialGroup()
                                    .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(field_chasis)
                                        .addComponent(field_name)
                                        .addComponent(field_model)
                                        .addComponent(field_brand)
                                        .addComponent(field_type)
                                        .addComponent(field_stock, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(field_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_cancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(inventory_panelLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(261, 261, 261)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_panelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(inventory_panelLayout.createSequentialGroup()
                        .addComponent(btnSell, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sell_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(field_quant_sell, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inventory_panelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnRestock)
                        .addGap(6, 6, 6)
                        .addComponent(restock_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(field_quant_rstock, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(add_new_product_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(inventory_panelLayout.createSequentialGroup()
                            .addComponent(btn_Previous)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(929, 929, 929))
        );
        inventory_panelLayout.setVerticalGroup(
            inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventory_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inventory_panelLayout.createSequentialGroup()
                        .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(inventory_panelLayout.createSequentialGroup()
                                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(field_chasis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(inventory_panelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel6))
                                    .addGroup(inventory_panelLayout.createSequentialGroup()
                                        .addComponent(field_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(field_model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(field_brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(field_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(field_trans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(field_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(inventory_panelLayout.createSequentialGroup()
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(inventory_panelLayout.createSequentialGroup()
                        .addComponent(add_new_product_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(11, 11, 11)
                        .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sell_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_quant_sell, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(inventory_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restock_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_quant_rstock, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventory", inventory_panel);

        employee_panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                employee_panelComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                employee_panelComponentShown(evt);
            }
        });

        add_new_employee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_new_employee.setText("Add New Employee");
        add_new_employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_employeeActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("ID #");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Name");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Birthdate");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Address");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("SSS #");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Mobile Number");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Department");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Position");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Gender");

        field_E_ID.setEditable(false);
        field_E_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_ID.setText(" ");

        field_E_f_name.setEditable(false);
        field_E_f_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_f_name.setText(" ");

        field_E_gender.setEditable(false);
        field_E_gender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_gender.setText(" ");
        field_E_gender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_E_genderMouseClicked(evt);
            }
        });

        field_E_bd_m.setEditable(false);
        field_E_bd_m.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_bd_m.setText(" ");
        field_E_bd_m.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_E_bd_mMouseClicked(evt);
            }
        });
        field_E_bd_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_E_bd_mActionPerformed(evt);
            }
        });

        field_E_position.setEditable(false);
        field_E_position.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_position.setText(" ");

        field_E_sss.setEditable(false);
        field_E_sss.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_sss.setText(" ");

        field_E_mobile.setEditable(false);
        field_E_mobile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_mobile.setText(" ");

        field_E_add.setEditable(false);
        field_E_add.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_add.setText(" ");

        field_E_dept.setEditable(false);
        field_E_dept.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_dept.setText(" ");

        field_E_m_name.setEditable(false);
        field_E_m_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_m_name.setText(" ");

        field_E_l_name.setEditable(false);
        field_E_l_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_l_name.setText(" ");

        field_E_bd_d.setEditable(false);
        field_E_bd_d.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_bd_d.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_E_bd_dMouseClicked(evt);
            }
        });

        field_E_bd_y.setEditable(false);
        field_E_bd_y.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_E_bd_y.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                field_E_bd_yMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btn_E_edit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_edit.setText("Edit");
        btn_E_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_editActionPerformed(evt);
            }
        });

        btn_E_ok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_ok.setText("OK");
        btn_E_ok.setEnabled(false);
        btn_E_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_okActionPerformed(evt);
            }
        });

        btn_E_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_delete.setText("Delete");
        btn_E_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_deleteActionPerformed(evt);
            }
        });

        btn_E_cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_cancel.setText("Cancel");
        btn_E_cancel.setEnabled(false);
        btn_E_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_cancelActionPerformed(evt);
            }
        });

        btn_E_next.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_next.setText("Next");
        btn_E_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_nextActionPerformed(evt);
            }
        });

        btn_E_previous.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_previous.setText("Previous");
        btn_E_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_previousActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_E_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_E_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_E_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_E_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btn_E_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_E_previous, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_E_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_E_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_E_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_E_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_E_next, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_E_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout employee_panelLayout = new javax.swing.GroupLayout(employee_panel);
        employee_panel.setLayout(employee_panelLayout);
        employee_panelLayout.setHorizontalGroup(
            employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employee_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_new_employee)
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(employee_panelLayout.createSequentialGroup()
                                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employee_panelLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(40, 40, 40)))
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_E_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_E_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(employee_panelLayout.createSequentialGroup()
                                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, employee_panelLayout.createSequentialGroup()
                                        .addComponent(field_E_bd_m, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(field_E_bd_d, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(field_E_bd_y))
                                    .addGroup(employee_panelLayout.createSequentialGroup()
                                        .addComponent(field_E_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(field_E_m_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_E_l_name, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(field_E_add)
                            .addComponent(field_E_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_E_position, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_E_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_E_sss, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        employee_panelLayout.setVerticalGroup(
            employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employee_panelLayout.createSequentialGroup()
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(employee_panelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(add_new_employee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(4, 4, 4)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(field_E_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_E_m_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_E_l_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_bd_m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(field_E_bd_d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_E_bd_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(4, 4, 4)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_sss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_E_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(employee_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(field_E_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employees", employee_panel);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        add_new_client.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_new_client.setText("Add New Client");
        add_new_client.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_clientActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operations"));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btn_E_edit1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_edit1.setText("Edit");
        btn_E_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_edit1ActionPerformed(evt);
            }
        });

        btn_E_ok1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_ok1.setText("OK");
        btn_E_ok1.setEnabled(false);
        btn_E_ok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_ok1ActionPerformed(evt);
            }
        });

        btn_E_delete1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_delete1.setText("Delete");
        btn_E_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_delete1ActionPerformed(evt);
            }
        });

        btn_E_cancel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_cancel1.setText("Cancel");
        btn_E_cancel1.setEnabled(false);
        btn_E_cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_cancel1ActionPerformed(evt);
            }
        });

        btn_E_next1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_next1.setText("Next");
        btn_E_next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_next1ActionPerformed(evt);
            }
        });

        btn_E_previous1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_E_previous1.setText("Previous");
        btn_E_previous1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_E_previous1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_E_delete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_E_edit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_E_ok1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_E_cancel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btn_E_next1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_E_previous1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_E_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_E_ok1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_E_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_E_cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_E_next1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_E_previous1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        field_C_ID.setEditable(false);
        field_C_ID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_C_ID.setText(" ");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("ID #");

        field_C_name.setEditable(false);
        field_C_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_C_name.setText(" ");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Name");

        field_C_add.setEditable(false);
        field_C_add.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_C_add.setText(" ");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Address");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add_new_client)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_C_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(field_C_name)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(field_C_add, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(add_new_client)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_C_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(field_C_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(field_C_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customers", jPanel2);

        time_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        time_label.setText("00:00:00 XX");
        time_label.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                time_labelFocusGained(evt);
            }
        });

        date_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        date_label.setText("00,0000");
        date_label.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                date_labelFocusGained(evt);
            }
        });

        month_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        month_label.setText("XXXXX");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ken\\Documents\\NetBeansProjects\\asymptotic_approach_Bago\\images\\head.jpg")); // NOI18N

        jMenu1.setText("File");

        create_user.setText("Create New User");
        create_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_userActionPerformed(evt);
            }
        });
        jMenu1.add(create_user);

        logout.setText("Logout");
        jMenu1.add(logout);

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });
        jMenu1.add(quit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem3.setText("about");
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(time_label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(month_label, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(600, 600, 600)
                .addComponent(date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time_label)
                    .addComponent(month_label)
                    .addComponent(date_label)))
        );

        getAccessibleContext().setAccessibleName("");

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-766)/2, (screenSize.height-598)/2, 766, 598);
    }// </editor-fold>//GEN-END:initComponents

    private void time_labelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_time_labelFocusGained

    }//GEN-LAST:event_time_labelFocusGained

    private void date_labelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_date_labelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_date_labelFocusGained

    private void add_new_product_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_product_btnActionPerformed
        // TODO add your handling code here:
        
            try{
        
            curRow = rs.getRow( ); 
            field_chasis.setEditable(true);
            field_name.setEditable(true);
            field_model.setEditable(true);
            field_brand.setEditable(true);
            field_type.setEditable(true);
            field_trans.setEditable(true);
            field_des.setEditable(true);
            
            field_chasis.setText("");
            field_name.setText("");
            field_model.setText("");
            field_brand.setText("");
            field_type.setText("");
            field_trans.setText("");
            field_des.setText("");
            field_stock.setText("");
            
            btn_save.setEnabled(true);
            btn_cancel.setEnabled(true);
            
            select_car_trans = true;
            select_car_type = true;
            
            addbtn = true;
            }
            
            catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            }
    }//GEN-LAST:event_add_new_product_btnActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        
            field_chasis.setEditable(true);
            field_name.setEditable(true);
            field_model.setEditable(true);
            field_brand.setEditable(true);
            field_type.setEditable(true);
            field_trans.setEditable(true);
            field_des.setEditable(true);
            
            btn_save.setEnabled(true);
            btn_cancel.setEnabled(true);
            
            select_car_trans = true;
            select_car_type = true;
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
            
        try{ 
            int i=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION) {JOptionPane.showMessageDialog(null, "Deleted");
            rs.deleteRow();
            
            stmt.close( );
            rs.close( );
            
            
            
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM vehicle";
            rs = stmt.executeQuery(sql);
            
            rs.first();
            Inventory_Values();
            }
            else{
            }
            
           
            }
            catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void add_new_employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_employeeActionPerformed
        // TODO add your handling code here:
        try{
        
            curRow = rs.getRow( ); 
            field_E_ID.setEditable(true);
            field_E_f_name.setEditable(true);
            field_E_m_name.setEditable(true);
            field_E_l_name.setEditable(true);
            field_E_gender.setEditable(true);
            field_E_bd_m.setEditable(true);
            field_E_bd_d.setEditable(true);
            field_E_bd_y.setEditable(true);
            field_E_add.setEditable(true);
            field_E_mobile.setEditable(true);
            field_E_sss.setEditable(true);
            field_E_position.setEditable(true);
            field_E_dept.setEditable(true);
            
            btn_E_ok.setEnabled(true);
            btn_E_ok.setEnabled(true);
            
            
            
            field_E_ID.setText("");
            field_E_f_name.setText("");
            field_E_m_name.setText("");
            field_E_l_name.setText("");
            field_E_gender.setText("");
            field_E_bd_m.setText("");
            field_E_bd_d.setText("");
            field_E_bd_y.setText("");
            field_E_add.setText("");
            field_E_mobile.setText("");
            field_E_sss.setText("");
            field_E_position.setText("");
            field_E_dept.setText("");
            
            select_car_trans = true;
            select_car_type = true;
            select_gender_E = true;
            
            
            
            
            addbtn_E = true;
            
            select_E_bd = true;
            
            }
            
            catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
            }
        
        
      
       
    }//GEN-LAST:event_add_new_employeeActionPerformed

    private void create_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_create_userActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        // TODO add your handling code here:
        
     int i=JOptionPane.showConfirmDialog(null, "Are you sure?","Quit",JOptionPane.YES_NO_OPTION);
     if(i==JOptionPane.YES_OPTION){
     System.exit(0);
     }
     else{}
    }//GEN-LAST:event_quitActionPerformed

    private void btnRestockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestockActionPerformed
       
        if(customrestock) {
                String stock_def = field_quant_rstock.getText();
                int stock_def_i = Integer.parseInt(stock_def);
                
                restockitem = stock_def_i;
                customrestock = false;
            }
            int i=JOptionPane.showConfirmDialog(null, "Are you sure you want to Restock?\nNumber of current stock: "+globalstock+"\nNumber of items requested to Restock: "+restockitem,"Restock",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION){
            
            
            try{
            curRow = rs.getRow( ); 
        
            int new_stock = globalstock + restockitem;
       
                
            rs.updateInt("v_stock", new_stock);
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Restocked Success");
            
            rs.absolute( curRow );
            Inventory_Values();
                      
            
            
          
      
            }
            catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());  
        }
             }
            else{
            }
        
        
    }//GEN-LAST:event_btnRestockActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
            
        
                String stock_def = field_quant_sell.getText();
               
           
                
            if(customsell) {
                 int stock_def_i = Integer.parseInt(stock_def);
                
                sellitem = stock_def_i;
                customsell = false;
          
                
            }
                
                
            int i=JOptionPane.showConfirmDialog(null, "Are you sure you want to Sell?\nNumber of current stock: "+globalstock+"\nNumber of items requested to sell: "+sellitem,"Sell",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION){
            
            
            try{
            curRow = rs.getRow( ); 
        
           
                 
  
            int new_stock = globalstock - sellitem;
            
            
            if(new_stock>=0){

                
            rs.updateInt("v_stock", new_stock);
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Sold Success");
            
            rs.absolute( curRow );
            Inventory_Values();
           
            
            }
            else if(new_stock<0){
             JOptionPane.showMessageDialog(null, "You have not enough stock to sell\nNumber of current stock: "+globalstock+"\nNumber of items requested to sell: "+sellitem);  
            }
      
            }
            catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());  
        }
             }
            else{
            }
            
            
        
        
    }//GEN-LAST:event_btnSellActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        String chasis_num = field_chasis.getText();
        String stock_def = "0";
        String name = field_name.getText();
        String v_model = field_model.getText();
        String v_brand = field_brand.getText();
        String v_type = field_type.getText();
        String v_trans = field_trans.getText();
        String description = field_des.getText();
               
        int chasis_num_i = Integer.parseInt(chasis_num);
        int stock_def_i = Integer.parseInt(stock_def);
        
            
        
        if(addbtn){
            
            try{
            curRow = rs.getRow( ); 
            rs.moveToInsertRow( );
            
            rs.updateInt("v_cs", chasis_num_i);
            rs.updateInt("v_stock", stock_def_i);
            rs.updateString("v_name", name);
            rs.updateString("v_model", v_model);
            rs.updateString("v_brand", v_brand);
            rs.updateString("v_type", v_type);
            rs.updateString("v_trans",v_trans);
            rs.updateString("v_desc", description);
            
            rs.insertRow( );
            
            stmt.close( );
            rs.close( );
            
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM vehicle";
            rs = stmt.executeQuery(sql);
            
            rs.absolute( curRow );
            Inventory_Values();
             JOptionPane.showMessageDialog(null, "Added Successfully");  
             
             addbtn = false;
             
            field_chasis.setEditable(false);
            field_name.setEditable(false);
            field_model.setEditable(false);
            field_brand.setEditable(false);
            field_type.setEditable(false);
            field_trans.setEditable(false);
            field_des.setEditable(false);
            
            btn_save.setEnabled(false);
            btn_cancel.setEnabled(false);
        
            
            }
            catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());  
        }
        }
        else{
        
        try{
            
            rs.updateInt("v_cs", chasis_num_i);
            rs.updateString("v_name", name);
            rs.updateString("v_model", v_model);
            rs.updateString("v_brand", v_brand);
            rs.updateString("v_type", v_type);
            rs.updateString("v_trans",v_trans);
            rs.updateString("v_desc", description);
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Updated");
            
            
            field_chasis.setEditable(false);
            field_name.setEditable(false);
            field_model.setEditable(false);
            field_brand.setEditable(false);
            field_type.setEditable(false);
            field_trans.setEditable(false);
            field_des.setEditable(false);
            
            btn_save.setEnabled(false);
            btn_cancel.setEnabled(false);
            
            select_car_trans = false;
            select_car_type = false;
            
       
        }
        catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());  
        }
        }
        
         
            select_car_trans = false;
            select_car_type = false;
        

    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        try{ 
        curRow = rs.getRow( ); 
        
        rs.absolute( curRow );
        Inventory_Values();
        
         field_chasis.setEditable(false);
            field_name.setEditable(false);
            field_model.setEditable(false);
            field_brand.setEditable(false);
            field_type.setEditable(false);
            field_trans.setEditable(false);
            field_des.setEditable(false);
            
            btn_save.setEnabled(false);
            btn_cancel.setEnabled(false);
            
             
            select_car_trans = false;
            select_car_type = false;
        
       }
       catch(SQLException err){
       JOptionPane.showMessageDialog(null,err.getMessage());
       }
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PreviousActionPerformed
        // TODO add your handling code here:
         try{
            if(rs.previous()){
            Inventory_Values();
            }      
             else{
                rs.next();                
        
        }
        }
        catch(SQLException err){
         JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
    }//GEN-LAST:event_btn_PreviousActionPerformed

    private void btn_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NextActionPerformed
        // TODO add your handling code here:
        
        try{
            if(rs.next()){
            Inventory_Values();
            }
            else{
                rs.previous();                
        
        }
        }
        catch(SQLException err){
         JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_NextActionPerformed

    private void sell_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sell_comboActionPerformed
            
        String s = (String) sell_combo.getSelectedItem();
        
                switch (s) {
                    case "1":
                         sellitem = 1;  
                         field_quant_sell.setText("");
                         field_quant_sell.setEnabled(false);
                        break;
                    case "2":
                         sellitem = 2;
                          field_quant_sell.setText("");
                         field_quant_sell.setEnabled(false);
                        break;
                    case "5":
                         sellitem = 5; 
                          field_quant_sell.setText("");
                         field_quant_sell.setEnabled(false);
                        break;
                    case "10":
                         sellitem = 10;
                          field_quant_sell.setText("");
                         field_quant_sell.setEnabled(false);
                         custom_pass_will_enter_loop = false;
                        break;                    
                    case "20":
                         sellitem = 20;  
                          field_quant_sell.setText("");
                         field_quant_sell.setEnabled(false);
                         custom_pass_will_enter_loop = false;
                        break;
                    case "custom":
                        field_quant_sell.setEnabled(true);
                        field_quant_sell.setText("1");
                        custom_pass_will_enter_loop = true;
                        customsell = true;
                        break;
            
                                            
                }
 
    }//GEN-LAST:event_sell_comboActionPerformed

    private void restock_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restock_comboActionPerformed
       
        String restock_items = (String) restock_combo.getSelectedItem();
        
                switch (restock_items) {
                    case "1":
                         restockitem = 1; 
                         field_quant_rstock.setText("");
                         field_quant_rstock.setEnabled(false);
                        break;
                    case "2":
                         restockitem = 2;    
                         field_quant_rstock.setText("");
                         field_quant_rstock.setEnabled(false);
                        break;
                    case "5":
                         restockitem = 5; 
                         field_quant_rstock.setText("");
                         field_quant_rstock.setEnabled(false);
                        break;
                    case "10":
                         restockitem = 10;
                         field_quant_rstock.setText("");
                         field_quant_rstock.setEnabled(false);
                        break;                    
                    case "20":
                         restockitem = 20; 
                         field_quant_rstock.setText("");
                         field_quant_rstock.setEnabled(false);
                        break;
                    case "custom":
                        field_quant_rstock.setEnabled(true);
                        field_quant_rstock.setText("1");
                        customrestock = true;
                        break;
            
                                            
                }
    }//GEN-LAST:event_restock_comboActionPerformed

    private void btn_E_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_editActionPerformed
        
        
            field_E_ID.setEditable(true);
            field_E_f_name.setEditable(true);
            field_E_m_name.setEditable(true);
            field_E_l_name.setEditable(true);
            field_E_gender.setEditable(true);
            field_E_bd_m.setEditable(true);
            field_E_bd_d.setEditable(true);
            field_E_bd_y.setEditable(true);
            field_E_add.setEditable(true);
            field_E_mobile.setEditable(true);
            field_E_sss.setEditable(true);
            field_E_position.setEditable(true);
            field_E_dept.setEditable(true);
          
            
            btn_E_ok.setEnabled(true);
            btn_E_cancel.setEnabled(true);  
            
            select_E_bd = true;
            select_gender_E = true;
            
            
            
            
           
    }//GEN-LAST:event_btn_E_editActionPerformed

    private void btn_E_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_deleteActionPerformed
         try{ 
            int i=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION) {JOptionPane.showMessageDialog(null, "Deleted");
            rs.deleteRow();
            
            stmt.close( );
            rs.close( );
            
            
            
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM employee";
            rs = stmt.executeQuery(sql);
            
            rs.first();
            Employee_Values();
            }
            else{
            }
            
           
            }
            catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_E_deleteActionPerformed

    private void btn_E_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_nextActionPerformed
         try{
            if(rs.next()){
            Employee_Values();
            }
            else{
                rs.previous();                
        
        }
        }
        catch(SQLException err){
         JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_E_nextActionPerformed

    private void btn_E_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_previousActionPerformed
         try{
            if(rs.previous()){
            Employee_Values();
            }
            else{
                rs.previous();                
        
        }
        }
        catch(SQLException err){
         JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_E_previousActionPerformed

    private void btn_E_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_okActionPerformed
            
        
            String id = field_E_ID.getText();
            String f_name = field_E_f_name.getText();
            String m_name = field_E_m_name.getText();
            String l_name = field_E_l_name.getText();
            String gender = field_E_gender.getText();
            String bd_m = field_E_bd_m.getText();
            String bd_d = field_E_bd_d.getText();
            String bd_y = field_E_bd_y.getText();
            String add = field_E_add.getText();
            String mobile = field_E_mobile.getText();
            String sss = field_E_sss.getText();
            String position = field_E_position.getText();
            String dept = field_E_dept.getText();
            
            int id_i = Integer.parseInt(id);
            int bd_m_i = 0;
            
            switch(bd_m){
                case "January":
                    bd_m_i = 1;
                    break;
                case "Febuary":
                    bd_m_i = 2;
                    break;
                case "March":
                    bd_m_i = 3;
                    break;
                case "April":
                    bd_m_i = 4;
                    break;
                case "May":
                    bd_m_i = 5;
                    break;
                case "June":
                    bd_m_i = 6;
                    break;
                case "July":
                    bd_m_i = 7;
                    break;
                case "August":
                    bd_m_i = 8;
                    break;
                case "September":
                    bd_m_i = 9;
                    break;
                case "October":
                    bd_m_i = 10;
                    break;
                case "November":
                    bd_m_i = 11;
                    break;
                case "December":
                    bd_m_i = 12;
                    break;
            
            }
            int bd_d_i = Integer.parseInt(bd_d);
            int bd_y_i = Integer.parseInt(bd_y);
            int mobile_i = Integer.parseInt(mobile);
            int sss_i = Integer.parseInt(sss);
            
             if(addbtn_E){
                 
                 try{
            curRow = rs.getRow( ); 
            rs.moveToInsertRow( );
            
            rs.updateInt("id_number", id_i);
            rs.updateInt("bd_month", bd_m_i);
            rs.updateInt("bd_day", bd_d_i);
            rs.updateInt("bd_year", bd_y_i);
            rs.updateInt("m_number", mobile_i);
            rs.updateInt("sss_number", sss_i);
            rs.updateString("f_name", f_name);
            rs.updateString("m_name", m_name);
            rs.updateString("l_name", l_name);
            rs.updateString("gender", gender);
            rs.updateString("address", add);
            rs.updateString("position", position);
            rs.updateString("department", dept);
            
            rs.insertRow( );
            
            stmt.close( );
            rs.close( );
            
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM employee";
            rs = stmt.executeQuery(sql);
            
            rs.absolute( curRow );
            Employee_Values();
             JOptionPane.showMessageDialog(null, "Added Successfully");  
             
            addbtn_E = false; 
            
            
            
            field_E_ID.setEditable(false);
            field_E_f_name.setEditable(false);
            field_E_m_name.setEditable(false);
            field_E_l_name.setEditable(false);
            field_E_gender.setEditable(false);
            field_E_bd_m.setEditable(false);
            field_E_bd_d.setEditable(false);
            field_E_bd_y.setEditable(false);
            field_E_add.setEditable(false);
            field_E_mobile.setEditable(false);
            field_E_sss.setEditable(false);
            field_E_position.setEditable(false);
            field_E_dept.setEditable(false);
        
            
            }
            catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());  
        }
             }
             else{
        
        try{
            
            rs.updateInt("id_number", id_i);
            rs.updateInt("bd_month", bd_m_i);
            rs.updateInt("bd_day", bd_d_i);
            rs.updateInt("bd_year", bd_y_i);
            rs.updateInt("m_number", mobile_i);
            rs.updateInt("sss_number", sss_i);
            rs.updateString("f_name", f_name);
            rs.updateString("m_name", m_name);
            rs.updateString("l_name", l_name);
            rs.updateString("gender", gender);
            rs.updateString("address", add);
            rs.updateString("position", position);
            rs.updateString("department", dept);
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Updated");
            
            
            field_E_ID.setEditable(false);
            field_E_f_name.setEditable(false);
            field_E_m_name.setEditable(false);
            field_E_l_name.setEditable(false);
            field_E_gender.setEditable(false);
            field_E_bd_m.setEditable(false);
            field_E_bd_d.setEditable(false);
            field_E_bd_y.setEditable(false);
            field_E_add.setEditable(false);
            field_E_mobile.setEditable(false);
            field_E_sss.setEditable(false);
            field_E_position.setEditable(false);
            field_E_dept.setEditable(false);
            
       
        }
        catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());  
        }
        }
            select_E_bd = false;
            select_gender_E = false;
            
            
            
       
    }//GEN-LAST:event_btn_E_okActionPerformed

    private void btn_E_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_cancelActionPerformed
        try{ 
        curRow = rs.getRow( ); 
        
        rs.absolute( curRow );
        Employee_Values();
        
            field_E_ID.setEditable(false);
            field_E_f_name.setEditable(false);
            field_E_m_name.setEditable(false);
            field_E_l_name.setEditable(false);
            field_E_gender.setEditable(false);
            field_E_bd_m.setEditable(false);
            field_E_bd_d.setEditable(false);
            field_E_bd_y.setEditable(false);
            field_E_add.setEditable(false);
            field_E_mobile.setEditable(false);
            field_E_sss.setEditable(false);
            field_E_position.setEditable(false);
            field_E_dept.setEditable(false);
            
            select_E_bd = false;
            select_gender_E = false;
        
       }
       catch(SQLException err){
       JOptionPane.showMessageDialog(null,err.getMessage());
       }
    }//GEN-LAST:event_btn_E_cancelActionPerformed

    private void employee_panelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_employee_panelComponentShown
        // TODO add your handling code here:
        
            Reload_Table_Employee();
    }//GEN-LAST:event_employee_panelComponentShown

    private void inventory_panelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_inventory_panelComponentShown
        // TODO add your handling code here:
        Reload_Table_Inventory();
       
        
    }//GEN-LAST:event_inventory_panelComponentShown

    private void employee_panelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_employee_panelComponentHidden
  
       
          
        
    }//GEN-LAST:event_employee_panelComponentHidden

    private void field_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_typeMouseClicked
        // TODO add your handling code here:
        if(select_car_type){
        Car_Type t = new Car_Type(this, true);
        
        String i = t.type;
        field_type.setText(i);
        }
        
        
    }//GEN-LAST:event_field_typeMouseClicked

    private void field_transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_transMouseClicked
        // TODO add your handling code here:
        if(select_car_trans){
        Transmission t = new Transmission(this, true);
        
        String i = t.trans;
        field_trans.setText(i);
        }
        
        
    }//GEN-LAST:event_field_transMouseClicked

    private void field_typeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_typeKeyTyped
        // TODO add your handling code here:
        if(select_car_type){
        Car_Type t = new Car_Type(this, true);
        
        String i = t.type;
        field_type.setText("");
        field_type.setText(i);
        }
    }//GEN-LAST:event_field_typeKeyTyped

    private void field_transKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_transKeyTyped
        // TODO add your handling code here:
        if(select_car_trans){
        Transmission t = new Transmission(this, true);
        
        String i = t.trans;
        field_trans.setText("");
        field_trans.setText(i);
        }
    }//GEN-LAST:event_field_transKeyTyped

    private void inventory_panelComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_inventory_panelComponentHidden
     
 
    }//GEN-LAST:event_inventory_panelComponentHidden

    private void field_E_bd_mMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_E_bd_mMouseClicked
       
        
        if(select_E_bd){
        Months m = new Months(this, true);
        String months = m.m;
        String day = m.days;
        String year = m.years;
        
        field_E_bd_m.setText(months);
        field_E_bd_d.setText(day);
        field_E_bd_y.setText(year);
        }
        
        
        
        
    }//GEN-LAST:event_field_E_bd_mMouseClicked

    private void field_E_bd_dMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_E_bd_dMouseClicked
         
        
        if(select_E_bd){
             Months m = new Months(this, true);
        String months = m.m;
        String day = Integer.toString(m.d);
        String year = Integer.toString(m.y);
        
        field_E_bd_m.setText(months);
        field_E_bd_d.setText(day);
        field_E_bd_y.setText(year);
        }
    }//GEN-LAST:event_field_E_bd_dMouseClicked

    private void field_E_bd_yMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_E_bd_yMouseClicked
        
        
        if(select_E_bd){
             Months m = new Months(this, true);
        String months = m.m;
        String day = Integer.toString(m.d);
        String year = Integer.toString(m.y);
        
        field_E_bd_m.setText(months);
        field_E_bd_d.setText(day);
        field_E_bd_y.setText(year);
        }
    }//GEN-LAST:event_field_E_bd_yMouseClicked

    private void btn_E_previous1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_previous1ActionPerformed
        try{
            if(rs.previous()){
            Client_Values();
            }
            else{
                rs.previous();                
        
        }
        }
        catch(SQLException err){
         JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_E_previous1ActionPerformed

    private void btn_E_next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_next1ActionPerformed
        try{
            if(rs.next()){
            Client_Values();
            }
            else{
                rs.previous();                
        
        }
        }
        catch(SQLException err){
         JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_E_next1ActionPerformed

    private void btn_E_cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_cancel1ActionPerformed
         try{ 
        curRow = rs.getRow( ); 
        
        rs.absolute( curRow );
        Client_Values();
        
               
            field_C_ID.setEditable(false);
            field_C_name.setEditable(false);
            field_C_add.setEditable(false);
            
            btn_E_ok1.setEnabled(false);
            btn_E_cancel1.setEnabled(false);
        
       }
       catch(SQLException err){
       JOptionPane.showMessageDialog(null,err.getMessage());
       }
    }//GEN-LAST:event_btn_E_cancel1ActionPerformed

    private void btn_E_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_delete1ActionPerformed
        try{ 
            int i=JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION) {JOptionPane.showMessageDialog(null, "Deleted");
            rs.deleteRow();
            
            stmt.close( );
            rs.close( );
            
            
            
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM client";
            rs = stmt.executeQuery(sql);
            
            rs.first();
            Client_Values();
            }
            else{
            }
            
           
            }
            catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }//GEN-LAST:event_btn_E_delete1ActionPerformed

    private void btn_E_ok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_ok1ActionPerformed
        String id = field_C_ID.getText();
        String name = field_C_name.getText();
        String add = field_C_add.getText();
        
        int id_i = Integer.parseInt(id);
        
        if(addbtn_C){
        try{
            curRow = rs.getRow( ); 
            rs.moveToInsertRow( );
            
            rs.updateInt("c_id", id_i);
            rs.updateString("c_name", name);
            rs.updateString("c_add", add);
            
             
            rs.insertRow( );
            
            stmt.close( );
            rs.close( );
            
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
            String sql = "SELECT * FROM client";
            rs = stmt.executeQuery(sql);
            
            rs.absolute( curRow );
            Client_Values();
            JOptionPane.showMessageDialog(null, "Added Successfully");  
             
            addbtn_C = false; 
            
            
            field_C_ID.setEditable(false);
            field_C_name.setEditable(false);
            field_C_add.setEditable(false);
            
            btn_E_ok1.setEnabled(false);
            btn_E_cancel1.setEnabled(false);
        }
        catch(Exception e){
            
        }
        }
        else{
        
        try{
            rs.updateInt("c_id", id_i);
            rs.updateString("c_name", name);
            rs.updateString("c_add", add);
            rs.updateRow( );
            JOptionPane.showMessageDialog(null, "Updated");
            
            field_C_ID.setEditable(false);
            field_C_name.setEditable(false);
            field_C_add.setEditable(false);
            
            btn_E_ok1.setEnabled(false);
            btn_E_cancel1.setEnabled(false);
            
       
        }
        catch(SQLException err){
        JOptionPane.showMessageDialog(null, err.getMessage());  
        }
        }
        
        
        
    }//GEN-LAST:event_btn_E_ok1ActionPerformed

    private void btn_E_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_E_edit1ActionPerformed
             field_C_ID.setEditable(true);
            field_C_name.setEditable(true);
            field_C_add.setEditable(true);
            
            btn_E_ok1.setEnabled(true);
            btn_E_cancel1.setEnabled(true);
    }//GEN-LAST:event_btn_E_edit1ActionPerformed

    private void add_new_clientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_clientActionPerformed
            
            try{
            curRow = rs.getRow( ); 
            field_C_ID.setEditable(true);
            field_C_name.setEditable(true);
            field_C_add.setEditable(true);
            
            btn_E_ok1.setEnabled(true);
            btn_E_cancel1.setEnabled(true);
            
            
            field_C_ID.setText("");
            field_C_name.setText("");
            field_C_add.setText("");
            
            addbtn_C = true;
            
            }
            catch(Exception e){}


  }//GEN-LAST:event_add_new_clientActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
       Reload_Table_Client();
    }//GEN-LAST:event_jPanel2ComponentShown

    private void field_E_bd_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_E_bd_mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_E_bd_mActionPerformed

    private void field_E_genderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_field_E_genderMouseClicked
       
       if(select_gender_E){
       Gender gen = new Gender(this, true);
       String gens = gen.g;
       field_E_gender.setText(gens);
       }
       
    }//GEN-LAST:event_field_E_genderMouseClicked

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


                new Main();
                

    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_new_client;
    private javax.swing.JButton add_new_employee;
    private javax.swing.JButton add_new_product_btn;
    private javax.swing.JButton btnRestock;
    private javax.swing.JButton btnSell;
    private javax.swing.JButton btn_E_cancel;
    private javax.swing.JButton btn_E_cancel1;
    private javax.swing.JButton btn_E_delete;
    private javax.swing.JButton btn_E_delete1;
    private javax.swing.JButton btn_E_edit;
    private javax.swing.JButton btn_E_edit1;
    private javax.swing.JButton btn_E_next;
    private javax.swing.JButton btn_E_next1;
    private javax.swing.JButton btn_E_ok;
    private javax.swing.JButton btn_E_ok1;
    private javax.swing.JButton btn_E_previous;
    private javax.swing.JButton btn_E_previous1;
    private javax.swing.JButton btn_Next;
    private javax.swing.JButton btn_Previous;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_save;
    private javax.swing.JMenuItem create_user;
    private javax.swing.JLabel date_label;
    private javax.swing.JPanel employee_panel;
    private javax.swing.JTextField field_C_ID;
    private javax.swing.JTextField field_C_add;
    private javax.swing.JTextField field_C_name;
    private javax.swing.JTextField field_E_ID;
    private javax.swing.JTextField field_E_add;
    private javax.swing.JTextField field_E_bd_d;
    private javax.swing.JTextField field_E_bd_m;
    private javax.swing.JTextField field_E_bd_y;
    private javax.swing.JTextField field_E_dept;
    private javax.swing.JTextField field_E_f_name;
    private javax.swing.JTextField field_E_gender;
    private javax.swing.JTextField field_E_l_name;
    private javax.swing.JTextField field_E_m_name;
    private javax.swing.JTextField field_E_mobile;
    private javax.swing.JTextField field_E_position;
    private javax.swing.JTextField field_E_sss;
    private javax.swing.JTextField field_brand;
    private javax.swing.JTextField field_chasis;
    private javax.swing.JTextArea field_des;
    private javax.swing.JTextField field_model;
    private javax.swing.JTextField field_name;
    private javax.swing.JTextField field_quant_rstock;
    private javax.swing.JTextField field_quant_sell;
    private javax.swing.JTextField field_stock;
    private javax.swing.JTextField field_trans;
    private javax.swing.JTextField field_type;
    private javax.swing.JPanel inventory_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JLabel month_label;
    private javax.swing.JMenuItem quit;
    private javax.swing.JComboBox restock_combo;
    private javax.swing.JComboBox sell_combo;
    private javax.swing.JLabel time_label;
    // End of variables declaration//GEN-END:variables
}


		
