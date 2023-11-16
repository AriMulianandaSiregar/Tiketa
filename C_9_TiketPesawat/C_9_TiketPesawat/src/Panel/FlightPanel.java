/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;

import Control.*;
import Exception.NotFoundAnyFlightException;
import Model.*;
import Model.StatusType;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author USER
 */
public class FlightPanel extends javax.swing.JPanel {
     
    private Member M;
    /**
     * Creates new form CardPanel
     */
    private DetailPerjalananControl detailPerjalananControl;
    private SeatControl seatControl;
    private TransaksiControl tCon = new TransaksiControl();
    private KendaraanControl kCon = new KendaraanControl();
    List<DetailPerjalanan> listPenerbangan;
    
    public void NotFoundAnyFlightException() throws NotFoundAnyFlightException{
            throw new NotFoundAnyFlightException("Jadwal Penerbangan tidak Ditemukan!");
    }
    
    public void showPerjalanan(String keberangkatan, String tujuan, String tanggal, int jumlahPenumpang){
        JPanel FlightPanel = new JPanel();
        String check = "kosong";
        
        
        try{
            
            listPenerbangan = detailPerjalananControl.showlistDataDetailPerjalanan(keberangkatan, tujuan, tanggal);
            if(listPenerbangan.isEmpty()){
                throw new NotFoundAnyFlightException("Jadwal Penerbangan tidak Ditemukan!");
               
            }
        
                for(int i = 0; i < listPenerbangan.size(); i++){
                    if(jumlahPenumpang < seatControl.cekJumlahSeat(listPenerbangan.get(i).getDetailPerjalanId())){
                            check = "ada";
                            tableOrder.addRow(new Object[]{listPenerbangan.get(i).getNomorKeberangkatan(),
                            listPenerbangan.get(i).getTanggalKeberangkatan() + " -> " + listPenerbangan.get(i).getTanggalKedatangan(),
                            listPenerbangan.get(i).getKotaKeberangkatan() + " -> " + listPenerbangan.get(i).getKotaKedatangan(),
                            listPenerbangan.get(i).getWaktuKeberangkatan(),
                            listPenerbangan.get(i).getKendaraan().getNamaKendaraan(), 
                            StatusType.AVAILABLE});
                            System.out.println("asdasdasdads : " + check);

                            
                    }else{
                                System.out.println("asdasdasdads 2: " + check);
                                throw new NotFoundAnyFlightException("Jadwal Penerbangan tidak Ditemukan!");
                    }
                }
            
        }catch(NotFoundAnyFlightException e1){
            JOptionPane.showMessageDialog(FlightPanel,"Jadwal Penerbangan tidak Ditemukan!");
        }
    }
    
    
    public FlightPanel(Member M,String keberangkatan, String tujuan, String tanggal, int jumlahPenumpang) {
        
        this.M = M;
        seatControl = new SeatControl();
        detailPerjalananControl = new DetailPerjalananControl();
        initComponents();
        showPerjalanan(keberangkatan, tujuan, tanggal, jumlahPenumpang);
        sp.setVerticalScrollBar(new ScrollBar.ScrollBarCustom());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        sp.getViewport().setBackground(Color.WHITE);
        
        tableOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableOrder.getSelectedRow();
                int selectedColumn = tableOrder.getSelectedColumn();
                
                if (StatusType.AVAILABLE.equals(tableOrder.getValueAt(selectedRow, selectedColumn))) {
                    System.out.println("Value Row 1 " + tableOrder.getValueAt(selectedRow,1));
                    Object a = (String) tableOrder.getValueAt(selectedRow,0);
                    String b = (String) a;
                    System.out.println("Value Dari id table Adalah " + a);
                    //generate pemesanan yang balum ada datanya
                    Pemesanan p = new Pemesanan("Proses Input",0,0);
                    tCon.insertPemesanan(p,M.getUserID());
                    //masukkan id nya ke dalam objek kita buat
                    p.setTransaksiId(tCon.getIdTerakhirPemesananTerakhir(M.getUserID())); 
                    //membuat bojek detail perjalanan yang datanya didapat dari apa yang kita ketik
                    DetailPerjalanan dP = detailPerjalananControl.showDataDetailPerjalanan(b);
                    
                    setForm(new NextFlightPanel(M,p,dP,jumlahPenumpang-1));
                    
                }
            }
            
            
        });     
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new Panel.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tableOrder = new Table.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Tickets");

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableOrder.setBackground(new java.awt.Color(244, 244, 244));
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Number", "Flight", "Destinasi", "Time", "Plane", "Choose"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrderMouseClicked(evt);
            }
        });
        sp.setViewportView(tableOrder);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrderMouseClicked
        // TODO add your handling code here:
        // kalau ini yang di klik pesan penerbangan ini
        
        
        
    }//GEN-LAST:event_tableOrderMouseClicked


    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private Panel.PanelBorder mainPanel;
    private javax.swing.JScrollPane sp;
    private Table.Table tableOrder;
    // End of variables declaration//GEN-END:variables
}
