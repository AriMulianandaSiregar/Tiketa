/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Model.*;
import Control.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author USER
 */
public class KendaraanPanel extends javax.swing.JPanel {
    private DetailPerjalananControl dPCon = new DetailPerjalananControl();
    private KendaraanControl kCon = new KendaraanControl();
    private SeatControl sCon = new SeatControl();
    private KelasControl keCon = new KelasControl();
    private TiketControl tiCon = new TiketControl();
    private List<Kendaraan> listK = kCon.showAllDataKendaraan();
    private List<Kendaraan> tempListK;
    private List<DetailPerjalanan> listDp;
    private DefaultTableModel model;
    private String action = "";
    /**
     * Creates new form KendaraanPanel
     */
    public KendaraanPanel() {
        initComponents();
        init();
        showAllKendaraan(listK);
        this.model = (DefaultTableModel) tableKendaraan.getModel();
        
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Aksi yang akan dijalankan saat ada penambahan teks
                String inputText = searchInput.getTextInput().getText();
                System.out.println("added: " + inputText);
                 model.setRowCount(0);
                 tempListK = kCon.showKendaraan(inputText);
                 showAllKendaraan(tempListK);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Aksi yang akan dijalankan saat ada penghapusan teks
                String inputText = searchInput.getTextInput().getText();
                System.out.println("Removed: " + inputText);
                 model.setRowCount(0);
                 tempListK = kCon.showKendaraan(inputText);
                 showAllKendaraan(tempListK);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        };
        
        searchInput.getTextInput().getDocument().addDocumentListener(documentListener);
    }
    
    public Kendaraan inputKendaraan(){
        Kendaraan k = new Pesawat(
                "Pesawat",  
                Integer.parseInt(jumlahSeatInput.getText()),
                namaKendaraanInput.getText()
        );
        
        
        
        kCon.insertDataKendaraan(k);
        k.setKendaraanID(kCon.showDataTerakhir());
        showKendaraan(k);
        clearText();
        return k;
    }
    
    public void showKendaraan(Kendaraan k){
        tableKendaraan.addRow(new Object []{k.getKendaraanID(), k.getNamaKendaraan(),k.getJumlahSeat(), k.getJenisKendaraan()});
    }
    
    public void showAllKendaraan(List<Kendaraan> list){
        
        for(Kendaraan k : list){
            showKendaraan(k);
        }
    }
    
    public void init(){
        sp.setVerticalScrollBar(new ScrollBar.ScrollBarCustom());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        sp.getViewport().setBackground(Color.WHITE);
        
    }

    public void clearText(){
        namaKendaraanInput.setText("");
        jumlahSeatInput.setText("");
        
    }
    
    public void setInputText(Kendaraan k){
        namaKendaraanInput.setText(k.getNamaKendaraan());
        jumlahSeatInput.setText(Integer.toString(k.getJumlahSeat()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        matakuliahLabel = new javax.swing.JLabel();
        namaKendaraanInput = new javax.swing.JTextField();
        matakuliahLabel1 = new javax.swing.JLabel();
        jumlahSeatInput = new javax.swing.JTextField();
        sp = new javax.swing.JScrollPane();
        tableKendaraan = new Table.Table();
        addPanel = new Panel.PanelBorder();
        addLbl = new javax.swing.JLabel();
        deletePanel = new Panel.PanelBorder();
        deleteLbl = new javax.swing.JLabel();
        simpanPanel = new Panel.PanelBorder();
        simpanLbl = new javax.swing.JLabel();
        searchInput = new Panel.SearchPanel();
        panelBorder1 = new Panel.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        editLbl = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        matakuliahLabel.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        matakuliahLabel.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel.setText("Nama Kendaraan");

        namaKendaraanInput.setBackground(new java.awt.Color(255, 255, 255));
        namaKendaraanInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namaKendaraanInput.setForeground(new java.awt.Color(0, 0, 0));
        namaKendaraanInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        matakuliahLabel1.setBackground(new java.awt.Color(255, 255, 255));
        matakuliahLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        matakuliahLabel1.setForeground(new java.awt.Color(0, 0, 0));
        matakuliahLabel1.setText("Jumlah Seat");

        jumlahSeatInput.setBackground(new java.awt.Color(255, 255, 255));
        jumlahSeatInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jumlahSeatInput.setForeground(new java.awt.Color(0, 0, 0));
        jumlahSeatInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        sp.setBorder(null);

        tableKendaraan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Kendaraan", "Nama Kendaraan", "Jumlah Seat", "Jenis Kendaraan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sp.setViewportView(tableKendaraan);

        addPanel.setBackground(new java.awt.Color(0, 153, 153));
        addPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        addPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPanelMouseClicked(evt);
            }
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deletePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(deleteLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        deletePanelLayout.setVerticalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        simpanPanel.setBackground(new java.awt.Color(0, 153, 204));
        simpanPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        simpanPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                simpanPanelMouseExited(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, simpanPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(simpanLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        simpanPanelLayout.setVerticalGroup(
            simpanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(simpanLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelBorder1.setBackground(new java.awt.Color(0, 91, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADMIN");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );

        editLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        editLbl.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matakuliahLabel)
                            .addComponent(namaKendaraanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(matakuliahLabel1)
                                .addComponent(jumlahSeatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editLbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(simpanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addComponent(searchInput, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matakuliahLabel)
                    .addComponent(editLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(matakuliahLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlahSeatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(simpanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseEntered
        addPanel.setBackground(new Color(0,102,102));
        addPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_addPanelMouseEntered

    private void addPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseExited
        addPanel.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_addPanelMouseExited

    private void deletePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseEntered
        deletePanel.setBackground(new Color(204,0,0));
        deletePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
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

    private void simpanPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanPanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanPanelMouseEntered

    private void simpanPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanPanelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanPanelMouseExited

    private void addPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseClicked
        action = "tambah";
    }//GEN-LAST:event_addPanelMouseClicked

    private void addLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLblMouseClicked
        action = "tambah";
    }//GEN-LAST:event_addLblMouseClicked

    private void simpanLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanLblMouseClicked
        if(action.equalsIgnoreCase("tambah")){
            if(namaKendaraanInput.getText().equalsIgnoreCase("") || jumlahSeatInput.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong!");
            } else {
                inputKendaraan();
                action = "";
            }
        }else if(action.equalsIgnoreCase("edit")){
            int id = listK.get(tableKendaraan.getSelectedRow()).getKendaraanID();
            Kendaraan k = new Pesawat(
                    id,
                    "Pesawat",
                    Integer.parseInt(jumlahSeatInput.getText()),
                    namaKendaraanInput.getText()
            );
            
            kCon.updateDataKendaraan(k,id);
            model.setRowCount(0);
            this.listK = kCon.showAllDataKendaraan();
            showAllKendaraan(listK);
            clearText();
            action = "";
        }
    }//GEN-LAST:event_simpanLblMouseClicked

    private void editLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editLblMouseClicked

        int rowSelected = tableKendaraan.getSelectedRow();
        if(rowSelected!= -1){
            Kendaraan k = kCon.searchKendaraan(Integer.parseInt(tableKendaraan.getValueAt(rowSelected, 0).toString()));
            setInputText(k);
            action = "edit";
        }
        
    }//GEN-LAST:event_editLblMouseClicked

    private void deleteLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLblMouseClicked
        if(tableKendaraan.getSelectedRow() != -1){
            int kendaraanId = Integer.parseInt(tableKendaraan.getValueAt(tableKendaraan.getSelectedRow(), 0).toString());
            listDp = dPCon.searchDetailPerjalananBerdasarkanKendaraan(kendaraanId);
            for(DetailPerjalanan dP : listDp){
                tiCon.deteleTiket(dP.getDetailPerjalanId());
                dPCon.deteleDetailPerjalanan(dP.getDetailPerjalanId());
            }
            kCon.deleteDataKendaraan(kendaraanId);
            model.setRowCount(0);
            tempListK = kCon.showAllDataKendaraan();
            showAllKendaraan(tempListK);
        }
        
    }//GEN-LAST:event_deleteLblMouseClicked

    private void simpanLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanLblMouseEntered
        simpanLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        simpanPanel.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_simpanLblMouseEntered

    private void simpanLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanLblMouseExited
        simpanPanel.setBackground(new Color(0,153,204));
    }//GEN-LAST:event_simpanLblMouseExited

    private void deleteLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLblMouseEntered
        deleteLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deletePanel.setBackground(new Color(204,0,0));
    }//GEN-LAST:event_deleteLblMouseEntered

    private void deleteLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLblMouseExited
        deletePanel.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_deleteLblMouseExited

    private void addLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLblMouseEntered
        addLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPanel.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_addLblMouseEntered

    private void addLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLblMouseExited
        addPanel.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_addLblMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addLbl;
    private Panel.PanelBorder addPanel;
    private javax.swing.JLabel deleteLbl;
    private Panel.PanelBorder deletePanel;
    private javax.swing.JLabel editLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jumlahSeatInput;
    private javax.swing.JLabel matakuliahLabel;
    private javax.swing.JLabel matakuliahLabel1;
    private javax.swing.JTextField namaKendaraanInput;
    private Panel.PanelBorder panelBorder1;
    private Panel.SearchPanel searchInput;
    private javax.swing.JLabel simpanLbl;
    private Panel.PanelBorder simpanPanel;
    private javax.swing.JScrollPane sp;
    private Table.Table tableKendaraan;
    // End of variables declaration//GEN-END:variables
}
