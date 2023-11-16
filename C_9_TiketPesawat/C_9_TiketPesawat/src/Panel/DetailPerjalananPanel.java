/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;

import Model.StatusType;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Model.*;
import Control.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class DetailPerjalananPanel extends javax.swing.JPanel {
    private DetailPerjalananControl dPCon = new DetailPerjalananControl();
    private KendaraanControl kCon = new KendaraanControl();
    private SeatControl sCon = new SeatControl();
    private KelasControl keCon = new KelasControl();
    private TiketControl tiCon = new TiketControl();
    private List<DetailPerjalanan> listDp = dPCon.showAllDetailPerjalanan();
    private List<DetailPerjalanan> tempListDp;
    private List<Kendaraan> listK = kCon.showAllDataKendaraan();
    private String action = "";
    private DefaultTableModel model = null;
    private boolean bool = false;
    
    
    /**
     * Creates new form DetailPerjalananPanel
     */
    
    public void setModel(){
        model = (DefaultTableModel) tableDataKeberangkatanAdmin.getModel();
    }
    public DetailPerjalananPanel() {
        
        
        initComponents();
        init();
        setDeleteUpdate(false);
        initCbKendaraan();
        
        showAllDetailPerjalanan(listDp);
        setModel();
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Aksi yang akan dijalankan saat ada penambahan teks
                String inputText = searchInput.getTextInput().getText();
                System.out.println("added: " + inputText);
                 model.setRowCount(0);
                 tempListDp = dPCon.searchingDetailPerjalanan(inputText);
                 showAllDetailPerjalanan(tempListDp);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Aksi yang akan dijalankan saat ada penghapusan teks
                String inputText = searchInput.getTextInput().getText();
                System.out.println("Removed: " + inputText);
                model.setRowCount(0);
                tempListDp = dPCon.searchingDetailPerjalanan(inputText);
                showAllDetailPerjalanan(tempListDp);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        };
        
        searchInput.getTextInput().getDocument().addDocumentListener(documentListener);
        
//        searchInput.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("haha");
//            }
//        });
        
        tableDataKeberangkatanAdmin.addMouseListener(new MouseAdapter() {
            @Override
            
            public void mouseClicked(MouseEvent e) {
                setDeleteUpdate(true);
                int selectedRow = tableDataKeberangkatanAdmin.getSelectedRow();
                int selectedColumn = tableDataKeberangkatanAdmin.getSelectedColumn();
                
                if (StatusType.DETAIL.equals(tableDataKeberangkatanAdmin.getValueAt(selectedRow, selectedColumn))) {
                    String no = tableDataKeberangkatanAdmin.getValueAt(selectedRow,0).toString();
                    System.out.println("id pemesanan yang dipilih : " + no);
                    
                    setForm(new ComingSoonPanel()); 
                   
                }else {
                    System.out.println("Katuk");  
                    
                }
            }  
        });    
    }
    
    public void setDeleteUpdate(boolean value){
        deleteLbl.setEnabled(value);
        editLbl.setEnabled(value);
    }
    
    public void showDetailPerjalanan(DetailPerjalanan dP){
           tableDataKeberangkatanAdmin.addRow(new Object[]{dP.getNomorKeberangkatan(),
               dP.getKendaraan().getNamaKendaraan(), 
               dP.getKotaKeberangkatan() + " - " + dP.getKotaKedatangan() , 
               dP.getTanggalKeberangkatan() + " - " + dP.getTanggalKedatangan(), 
               dP.getKendaraan().getJenisKendaraan(), 
               StatusType.DETAIL});
    }
    
    public void showAllDetailPerjalanan(List<DetailPerjalanan> list){
        System.out.println("List Detail Perjalanan size : " + list.size());
        for(DetailPerjalanan dP : list){
            System.out.println("add row  " + dP.getDetailPerjalanId());
            showDetailPerjalanan(dP); 
        }
    }
    
    public void initCbKendaraan(){
        
        for(Kendaraan k : listK){
            kendaraanIDCb.addItem(k);
        }
        
        
    }
    
    public DetailPerjalanan inputDetailPerjalanan(){
        
        //int detailPerjalanId, String nomorKeberangkatan, String kotaKeberangkatan, String kotaKedatangan, 
           // String tanggalKeberangkatan, String tanggalKedatangan, String waktuKeberangkatan, String waktuKedatangan
        int max = Integer.parseInt(dPCon.searchNomorPenerbanganTerakhir());
        max++;
        String nomorPenerbangan = Integer.toString(max);
        int index = kendaraanIDCb.getSelectedIndex();
        //Kendaraan k = kCon.searchKendaraan(kendaraanIDCb.getSelectedItem());
        DetailPerjalanan dP = new DetailPerjalanan(
                0,
                nomorPenerbangan,
                kotaKeberangkatanInput1 .getText(),
                kotaKedatanganInput.getText(),
                tanggalKeberangkatanInput.getText(),
                tanggalKedatanganInput.getText(),
                waktuKeberangkatanInput.getText(),
                waktuKedatanganInput.getText()
                
        );
        
        dP.setKendaraan(listK.get(index));
        dPCon.insertDetailPerjalanan(dP);
        clearText();
        listDp = dPCon.showAllDetailPerjalanan();
        return dP;
    }
    
    public void clearText(){
        searchInput.getTextInput().getText();
        kotaKedatanganInput.setText("");
        kotaKeberangkatanInput1.setText("");
        tanggalKeberangkatanInput.setText("");
        tanggalKedatanganInput.setText("");
        waktuKedatanganInput.setText("");
        waktuKeberangkatanInput.setText("");
        
    }
    
    public void setTombol(boolean value){
        kotaKedatanganInput.setEnabled(value);
        kotaKeberangkatanInput1.setEnabled(value);
        tanggalKeberangkatanInput.setEnabled(value);
        tanggalKedatanganInput.setEnabled(value);
        waktuKedatanganInput.setEnabled(value);
        waktuKeberangkatanInput.setEnabled(value);
        deleteLbl.setEnabled(value);
        simpanLbl.setEnabled(value);
        editLbl.setEnabled(value);
    }
    
    public void init(){
        sp.setVerticalScrollBar(new ScrollBar.ScrollBarCustom());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        sp.getViewport().setBackground(Color.WHITE);
        
    }
    
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    public void setInputText(DetailPerjalanan dP){
        dP.showDetailPerjalanan();
        kotaKeberangkatanInput1.setText(dP.getKotaKeberangkatan());
        kotaKedatanganInput.setText(dP.getKotaKedatangan());
        tanggalKeberangkatanInput.setText(dP.getTanggalKeberangkatan());
        tanggalKedatanganInput.setText(dP.getTanggalKedatangan());
        waktuKedatanganInput.setText(dP.getWaktuKedatangan());
        waktuKeberangkatanInput.setText(dP.getWaktuKeberangkatan());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        matakuliahLabel1 = new javax.swing.JLabel();
        matakuliahLabel2 = new javax.swing.JLabel();
        kotaKedatanganInput = new javax.swing.JTextField();
        matakuliahLabel3 = new javax.swing.JLabel();
        tanggalKeberangkatanInput = new javax.swing.JTextField();
        waktuKedatanganInput = new javax.swing.JTextField();
        matakuliahLabel7 = new javax.swing.JLabel();
        waktuKeberangkatanInput = new javax.swing.JTextField();
        matakuliahLabel6 = new javax.swing.JLabel();
        kendaraanIDCb = new javax.swing.JComboBox<>();
        matakuliahLabel5 = new javax.swing.JLabel();
        tanggalKedatanganInput = new javax.swing.JTextField();
        matakuliahLabel4 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tableDataKeberangkatanAdmin = new Table.Table();
        simpanPanel = new Panel.PanelBorder();
        simpanLbl = new javax.swing.JLabel();
        kotaKeberangkatanInput1 = new javax.swing.JTextField();
        searchInput = new Panel.SearchPanel();
        panelBorder1 = new Panel.PanelBorder();
        addPanel = new Panel.PanelBorder();
        addLbl = new javax.swing.JLabel();
        deletePanel = new Panel.PanelBorder();
        deleteLbl = new javax.swing.JLabel();
        editLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        matakuliahLabel1.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel1.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel1.setText("Kota Keberangkatan");

        matakuliahLabel2.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel2.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel2.setText("Kota Kedatangan");

        kotaKedatanganInput.setBackground(new java.awt.Color(255, 255, 255));
        kotaKedatanganInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kotaKedatanganInput.setForeground(new java.awt.Color(0, 0, 0));
        kotaKedatanganInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        matakuliahLabel3.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel3.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel3.setText("Tanggal Keberangkatan");

        tanggalKeberangkatanInput.setBackground(new java.awt.Color(255, 255, 255));
        tanggalKeberangkatanInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tanggalKeberangkatanInput.setForeground(new java.awt.Color(0, 0, 0));
        tanggalKeberangkatanInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        waktuKedatanganInput.setBackground(new java.awt.Color(255, 255, 255));
        waktuKedatanganInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        waktuKedatanganInput.setForeground(new java.awt.Color(0, 0, 0));
        waktuKedatanganInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        matakuliahLabel7.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel7.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel7.setText("Waktu Kedatangan");

        waktuKeberangkatanInput.setBackground(new java.awt.Color(255, 255, 255));
        waktuKeberangkatanInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        waktuKeberangkatanInput.setForeground(new java.awt.Color(0, 0, 0));
        waktuKeberangkatanInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        matakuliahLabel6.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel6.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel6.setText("Waktu Keberangkatan");

        kendaraanIDCb.setBackground(new java.awt.Color(255, 255, 255));
        kendaraanIDCb.setForeground(new java.awt.Color(0, 0, 0));
        kendaraanIDCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kendaraanIDCbActionPerformed(evt);
            }
        });

        matakuliahLabel5.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel5.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel5.setText("Kendaraan ID");

        tanggalKedatanganInput.setBackground(new java.awt.Color(255, 255, 255));
        tanggalKedatanganInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tanggalKedatanganInput.setForeground(new java.awt.Color(0, 0, 0));
        tanggalKedatanganInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        matakuliahLabel4.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        matakuliahLabel4.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel4.setText("Tanggal Kedatangan");

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableDataKeberangkatanAdmin.setBackground(new java.awt.Color(244, 244, 244));
        tableDataKeberangkatanAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Number", "Flight", "Destinasi", "Time", "Plane", "Choose"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDataKeberangkatanAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataKeberangkatanAdminMouseClicked(evt);
            }
        });
        sp.setViewportView(tableDataKeberangkatanAdmin);

        simpanPanel.setBackground(new java.awt.Color(0, 153, 204));
        simpanPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        simpanPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPanel1MouseExited(evt);
            }
        });

        simpanLbl.setBackground(new java.awt.Color(0, 153, 204));
        simpanLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        simpanLbl.setForeground(new java.awt.Color(255, 255, 255));
        simpanLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        simpanLbl.setText("Simpan");
        simpanLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout simpanPanelLayout = new javax.swing.GroupLayout(simpanPanel);
        simpanPanel.setLayout(simpanPanelLayout);
        simpanPanelLayout.setHorizontalGroup(
            simpanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simpanLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        simpanPanelLayout.setVerticalGroup(
            simpanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simpanLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        kotaKeberangkatanInput1.setBackground(new java.awt.Color(255, 255, 255));
        kotaKeberangkatanInput1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kotaKeberangkatanInput1.setForeground(new java.awt.Color(0, 0, 0));
        kotaKeberangkatanInput1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        panelBorder1.setBackground(new java.awt.Color(0, 91, 110));

        addPanel.setBackground(new java.awt.Color(0, 204, 204));
        addPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        addPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPanelMouseExited(evt);
            }
        });

        addLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addLbl.setForeground(new java.awt.Color(255, 255, 255));
        addLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addLbl.setText("Add");
        addLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
            .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        deletePanel.setBackground(new java.awt.Color(255, 0, 0));
        deletePanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        deletePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletePanelMouseExited(evt);
            }
        });

        deleteLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteLbl.setForeground(new java.awt.Color(255, 255, 255));
        deleteLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteLbl.setText("Delete");
        deleteLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
        deletePanel.setLayout(deletePanelLayout);
        deletePanelLayout.setHorizontalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
            .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(deleteLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanelLayout.setVerticalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(deleteLbl)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        editLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editLbl.setForeground(new java.awt.Color(255, 255, 255));
        editLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/9.png"))); // NOI18N
        editLbl.setText("Edit");
        editLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editLblMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ADMIN");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addComponent(editLbl)
                        .addGap(30, 30, 30))))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(editLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(matakuliahLabel5)
                        .addComponent(kendaraanIDCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(matakuliahLabel1)
                    .addComponent(kotaKeberangkatanInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matakuliahLabel3)
                    .addComponent(tanggalKeberangkatanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matakuliahLabel2)
                    .addComponent(kotaKedatanganInput, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tanggalKedatanganInput, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matakuliahLabel4)
                    .addComponent(matakuliahLabel6)
                    .addComponent(waktuKeberangkatanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(matakuliahLabel7)
                    .addComponent(waktuKedatanganInput, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(simpanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp)
                .addContainerGap())
            .addComponent(searchInput, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(matakuliahLabel1)
                                    .addGap(34, 34, 34))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(matakuliahLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kotaKedatanganInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kotaKeberangkatanInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(matakuliahLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(waktuKeberangkatanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(matakuliahLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kendaraanIDCb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(matakuliahLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tanggalKeberangkatanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(matakuliahLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tanggalKedatanganInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(matakuliahLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(waktuKedatanganInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableDataKeberangkatanAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataKeberangkatanAdminMouseClicked
        // TODO add your handling code here:
        // kalau ini yang di klik pesan penerbangan ini

    }//GEN-LAST:event_tableDataKeberangkatanAdminMouseClicked

    private void deletePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseEntered
        
    }//GEN-LAST:event_deletePanelMouseEntered

    private void deletePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseExited
        deletePanel.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_deletePanelMouseExited

    private void editLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLblMouseEntered
        editLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        editLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font originalFont = editLbl.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        attributes.put(TextAttribute.FONT, originalFont.deriveFont(Font.BOLD));

        editLbl.setFont(originalFont.deriveFont(attributes));
    }//GEN-LAST:event_editLblMouseEntered

    private void editLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLblMouseExited
        editLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
        editLbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_editLblMouseExited

    private void kendaraanIDCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kendaraanIDCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kendaraanIDCbActionPerformed

    private void addLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLblMouseClicked
        action = "Tambah";
    }//GEN-LAST:event_addLblMouseClicked

    private void deleteLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLblMouseClicked
        System.out.println("Masuk Delete");
        int choice = JOptionPane.showConfirmDialog(null, "Apakah Yakin Delete Data Detail Perjalanan Ini?");

        // Menampilkan pesan berdasarkan pilihan
            if (choice == JOptionPane.YES_OPTION) {
                int selectedRow = tableDataKeberangkatanAdmin.getSelectedRow();
                if (selectedRow != -1) {
                   
                    int idPerjalanan = dPCon.showDataDetailPerjalanan(
                    tableDataKeberangkatanAdmin.getValueAt(selectedRow, 0).toString()).getDetailPerjalanId();
                    model.removeRow(selectedRow);
                    System.out.println("Id Perjalanan : " + idPerjalanan + " Nomor Penerbangan " );
                    dPCon.deteleDetailPerjalanan(idPerjalanan);
                    sCon.deleteSeatPerjalanan(idPerjalanan);
                    tiCon.deteleTiket(idPerjalanan);
                    JOptionPane.showMessageDialog(null, "Berhasil Detele");
                }
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Batal Detele");
            }
        
    }//GEN-LAST:event_deleteLblMouseClicked

    private void editLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLblMouseClicked
       int selectedRow = tableDataKeberangkatanAdmin.getSelectedRow();
       int selectedColumn = tableDataKeberangkatanAdmin.getSelectedColumn();
       
       if(selectedRow != -1) {
           System.out.println("isi data");
           DetailPerjalanan dP = dPCon.showDataDetailPerjalanan(tableDataKeberangkatanAdmin.getValueAt(selectedRow, 0).toString());
           setInputText(dP);
           dP.setKendaraan(listK.get(kendaraanIDCb.getSelectedIndex()));
           dP.showDetailPerjalanan();
           addLbl.setEnabled(false);
       }
       action = "edit";
    }//GEN-LAST:event_editLblMouseClicked


    
    private void addPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseExited
        
    }//GEN-LAST:event_addPanelMouseExited

    private void addPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseEntered
        
    }//GEN-LAST:event_addPanelMouseEntered

    private void addPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_addPanel1MouseExited

    private void addPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addPanel1MouseEntered

    private void simpanLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanLblMouseClicked
        if(action.equalsIgnoreCase("Tambah")){
            DetailPerjalanan dP = inputDetailPerjalanan();
            dP = dPCon.showDataDetailPerjalanan(dPCon.searchNomorPenerbanganTerakhir());
            int seat = dP.getKendaraan().getJumlahSeat();
            int temp = seat/2;
            KelasPenerbangan ke = keCon.showKelas("Ekonomi");
            KelasPenerbangan kb = keCon.showKelas("Bisnis");
            for(int i=1;i<=temp;i++){
                sCon.insertSeat(new Seat(0, "A"+i, 300000, false, ke), dP.getDetailPerjalanId());
            }

            System.out.println("test2");
            for(int i=temp+1; i<=seat;i++){
                sCon.insertSeat(new Seat(0, "A"+i, 600000, false, kb), dP.getDetailPerjalanId());
            }
            action = "";
        }else if(action.equalsIgnoreCase("Edit")){

            DetailPerjalanan dP = new DetailPerjalanan(
                listDp.get(tableDataKeberangkatanAdmin.getSelectedRow()).getDetailPerjalanId(),
                "",
                kotaKeberangkatanInput1.getText(),
                kotaKedatanganInput.getText(),
                tanggalKeberangkatanInput.getText(),
                tanggalKedatanganInput.getText(),
                waktuKeberangkatanInput.getText(),
                waktuKedatanganInput.getText()

            );
            dP.setKendaraan(listK.get(kendaraanIDCb.getSelectedIndex()));
            dPCon.updateDetailPerjalanan(dP);
            model.setRowCount(0);
            tempListDp = dPCon.showAllDetailPerjalanan();
            showAllDetailPerjalanan(tempListDp);

            clearText();
            action = "";
            addLbl.setEnabled(true);
        } else if(action.equalsIgnoreCase("Delete")){
            action = "";
        }
    }//GEN-LAST:event_simpanLblMouseClicked

    private void addLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLblMouseEntered
        addPanel.setBackground(new Color(0,153,153));
        addLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_addLblMouseEntered

    private void addLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLblMouseExited
        addPanel.setBackground(new Color(0,204,204));
    }//GEN-LAST:event_addLblMouseExited

    private void deleteLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLblMouseEntered
        deletePanel.setBackground(new Color(204,0,0));
        deleteLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_deleteLblMouseEntered

    private void deleteLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLblMouseExited
        deletePanel.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_deleteLblMouseExited

    private void simpanLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanLblMouseEntered
        simpanLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        simpanPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_simpanLblMouseEntered

    private void simpanLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanLblMouseExited
        simpanPanel.setBackground(new Color(0,153,204));
    }//GEN-LAST:event_simpanLblMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLbl;
    private Panel.PanelBorder addPanel;
    private javax.swing.JLabel deleteLbl;
    private Panel.PanelBorder deletePanel;
    private javax.swing.JLabel editLbl;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<Kendaraan> kendaraanIDCb;
    private javax.swing.JTextField kotaKeberangkatanInput1;
    private javax.swing.JTextField kotaKedatanganInput;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel matakuliahLabel1;
    private javax.swing.JLabel matakuliahLabel2;
    private javax.swing.JLabel matakuliahLabel3;
    private javax.swing.JLabel matakuliahLabel4;
    private javax.swing.JLabel matakuliahLabel5;
    private javax.swing.JLabel matakuliahLabel6;
    private javax.swing.JLabel matakuliahLabel7;
    private Panel.PanelBorder panelBorder1;
    private Panel.SearchPanel searchInput;
    private javax.swing.JLabel simpanLbl;
    private Panel.PanelBorder simpanPanel;
    private javax.swing.JScrollPane sp;
    private Table.Table tableDataKeberangkatanAdmin;
    private javax.swing.JTextField tanggalKeberangkatanInput;
    private javax.swing.JTextField tanggalKedatanganInput;
    private javax.swing.JTextField waktuKeberangkatanInput;
    private javax.swing.JTextField waktuKedatanganInput;
    // End of variables declaration//GEN-END:variables
}
