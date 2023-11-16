 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;

import Control.DetailPerjalananControl;
import Control.TiketControl;
import Control.TransaksiControl;
import Model.DetailPerjalanan;
import Model.Member;
import Model.Pemesanan;
import Model.StatusType;
import Model.Tiket;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author USER
 */
public class HistoryPanel extends javax.swing.JPanel {
    private Member member;
    private DetailPerjalanan dP;
    
    public void setMember(Member member){
        this.member = member;
    }
    
        
    
    public void showAllDoneTiket(){
        TransaksiControl tCon = new TransaksiControl();
        TiketControl tiCon = new TiketControl();
        DetailPerjalananControl dPCon = new DetailPerjalananControl();    
        List<Pemesanan> listP = new ArrayList();
        List<Tiket> listT = new ArrayList();
        List<DetailPerjalanan> ListD = new ArrayList();

        Tiket t;
        
        listP = tCon.showPesananUser(member.getUserID());
        System.out.println("member id = " + member.getUserID());
        
        for(int i = 0;i<listP.size();i++){
            listT = tiCon.showDataTiketPesanan(listP.get(i).getTransaksiId());
            listP.get(i).show();
            for(int j = 0;j<listT.size();j++){
                 dP = dPCon.showDataDetailPerjalanan(listT.get(j).getdetailPerjalanan().getDetailPerjalanId());
                 listT.get(j).setdP(dP);
                 listP.get(i).addTiket(listT.get(j));
                if(listP.get(i).getStatusPemesanan().equalsIgnoreCase("Sudah bayar")){
                    //sementara
                    if(i>=1){
                        if(j == listT.size()-1){
                            tableDone.addRow(new Object[]{listP.get(i).getTransaksiId(),  
                            listT.get(j).getdetailPerjalanan().getKotaKeberangkatan() + " - " 
                            + listT.get(j).getdetailPerjalanan().getKotaKedatangan(),
                            listT.get(j).getdetailPerjalanan().getTanggalKeberangkatan() + " - " + 
                            listT.get(j).getdetailPerjalanan().getTanggalKedatangan(),                
                            listP.get(i).getJumlahPesanan() , 
                            listP.get(i).getStatusPemesanan(),
                            StatusType.DETAIL});
                        }
                    }else{
                            tableDone.addRow(new Object[]{listP.get(i).getTransaksiId(),  
                            listT.get(j).getdetailPerjalanan().getKotaKeberangkatan() + " - " 
                            + listT.get(j).getdetailPerjalanan().getKotaKedatangan(),
                            listT.get(j).getdetailPerjalanan().getTanggalKeberangkatan() + " - " + 
                            listT.get(j).getdetailPerjalanan().getTanggalKedatangan(),                
                            listP.get(i).getJumlahPesanan() , 
                            listP.get(i).getStatusPemesanan(),
                            StatusType.DETAIL});
                    }
                    
                }
            }
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
 
    public HistoryPanel(Member member) {
        initComponents();  
        setMember(member);
        showAllDoneTiket();
        init();
        
        
        tableDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableDone.getSelectedRow();
                int selectedColumn = tableDone.getSelectedColumn();
                
                if (StatusType.DETAIL.equals(tableDone.getValueAt(selectedRow, selectedColumn))) {
                    Integer pemesananID =  (Integer) tableDone.getValueAt(selectedRow,0);
                    System.out.println("id pemesanan yang dipilih : " + pemesananID);
                    
                    setForm(new DataTicketPanel(pemesananID));
                   
                }
            }  
        });
        
        pendingLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==pendingLbl){
                    setForm(new PendingHistoryPanel(member));
                }
            }
        });
        
        selesaiLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==selesaiLbl){
                    setForm(new DoneHistoryPanel(member));
                }
            }
        });
        
        historyLbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==historyLbl){
                    setForm(new RiwayatPanel(member));
                }
            }
        });
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new Panel.PanelBorder();
        sp = new javax.swing.JScrollPane();
        tableDone = new Table.Table();
        headerHistory = new Panel.HeaderHistory();
        topicLbl = new javax.swing.JLabel();
        descLbl2 = new javax.swing.JLabel();
        descLbl = new javax.swing.JLabel();
        historyLbl = new javax.swing.JLabel();
        pendingLbl = new javax.swing.JLabel();
        selesaiLbl = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(244, 244, 244));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);

        tableDone.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pesanan", "Route", "Date", "Jumlah Ticket", "Status", "Choose"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sp.setViewportView(tableDone);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        headerHistory.setBackground(new java.awt.Color(0, 153, 153));

        topicLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        topicLbl.setForeground(new java.awt.Color(255, 255, 255));
        topicLbl.setText("Tiketa Easy Booking");

        descLbl2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descLbl2.setForeground(new java.awt.Color(255, 255, 255));
        descLbl2.setText("your favorite destination");

        descLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descLbl.setForeground(new java.awt.Color(255, 255, 255));
        descLbl.setText("It is possible to book a flight ticket ");

        historyLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        historyLbl.setForeground(new java.awt.Color(255, 255, 255));
        historyLbl.setText("Riwayat");
        historyLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyLblMouseExited(evt);
            }
        });

        pendingLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pendingLbl.setForeground(new java.awt.Color(255, 255, 255));
        pendingLbl.setText("Belum Dibayar");
        pendingLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pendingLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pendingLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pendingLblMouseExited(evt);
            }
        });

        selesaiLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selesaiLbl.setForeground(new java.awt.Color(254, 255, 134));
        selesaiLbl.setText("Sudah Dibayar ");
        selesaiLbl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selesaiLblFocusGained(evt);
            }
        });
        selesaiLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selesaiLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selesaiLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selesaiLblMouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerHistoryLayout = new javax.swing.GroupLayout(headerHistory);
        headerHistory.setLayout(headerHistoryLayout);
        headerHistoryLayout.setHorizontalGroup(
            headerHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerHistoryLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(selesaiLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pendingLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(historyLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(headerHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLbl2)
                    .addComponent(descLbl)
                    .addComponent(topicLbl))
                .addGap(57, 57, 57))
        );
        headerHistoryLayout.setVerticalGroup(
            headerHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerHistoryLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(headerHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headerHistoryLayout.createSequentialGroup()
                        .addGroup(headerHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selesaiLbl)
                            .addComponent(pendingLbl)
                            .addComponent(historyLbl))
                        .addGap(7, 7, 7))
                    .addGroup(headerHistoryLayout.createSequentialGroup()
                        .addComponent(topicLbl)
                        .addGap(11, 11, 11)
                        .addComponent(descLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descLbl2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(headerHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    private void selesaiLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selesaiLblMouseClicked

        
        selesaiLbl.setForeground(new Color(254,255,134));
        pendingLbl.setForeground(new Color(255,255,255));
        historyLbl.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_selesaiLblMouseClicked

    private void pendingLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingLblMouseClicked
        
        selesaiLbl.setForeground(new Color(255,255,255));
        pendingLbl.setForeground(new Color(254,255,134));
        historyLbl.setForeground(new Color(255,255,255));
        
        
    }//GEN-LAST:event_pendingLblMouseClicked

    private void historyLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyLblMouseClicked
        
        selesaiLbl.setForeground(new Color(255,255,255));
        pendingLbl.setForeground(new Color(255,255,255));
        historyLbl.setForeground(new Color(254,255,134));
    }//GEN-LAST:event_historyLblMouseClicked

    private void selesaiLblFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selesaiLblFocusGained
        
    }//GEN-LAST:event_selesaiLblFocusGained

    private void selesaiLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selesaiLblMouseEntered
        selesaiLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        selesaiLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font originalFont = selesaiLbl.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        attributes.put(TextAttribute.FONT, originalFont.deriveFont(Font.BOLD));
        selesaiLbl.setFont(originalFont.deriveFont(attributes));
    }//GEN-LAST:event_selesaiLblMouseEntered

    private void selesaiLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selesaiLblMouseExited
        selesaiLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        selesaiLbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_selesaiLblMouseExited

    private void pendingLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingLblMouseEntered
        pendingLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        pendingLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font originalFont = pendingLbl.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        attributes.put(TextAttribute.FONT, originalFont.deriveFont(Font.BOLD));
        pendingLbl.setFont(originalFont.deriveFont(attributes));
    }//GEN-LAST:event_pendingLblMouseEntered

    private void pendingLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pendingLblMouseExited
        pendingLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        pendingLbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_pendingLblMouseExited

    private void historyLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyLblMouseEntered
        historyLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        historyLbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Font originalFont = historyLbl.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        attributes.put(TextAttribute.FONT, originalFont.deriveFont(Font.BOLD));
        historyLbl.setFont(originalFont.deriveFont(attributes));
    }//GEN-LAST:event_historyLblMouseEntered

    private void historyLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyLblMouseExited
        historyLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        historyLbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_historyLblMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descLbl;
    private javax.swing.JLabel descLbl2;
    private Panel.HeaderHistory headerHistory;
    private javax.swing.JLabel historyLbl;
    private javax.swing.JPanel jPanel1;
    private Panel.PanelBorder mainPanel;
    private javax.swing.JLabel pendingLbl;
    private javax.swing.JLabel selesaiLbl;
    private javax.swing.JScrollPane sp;
    private Table.Table tableDone;
    private javax.swing.JLabel topicLbl;
    // End of variables declaration//GEN-END:variables
}
