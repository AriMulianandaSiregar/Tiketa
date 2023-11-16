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
import Model.Transaksi;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author USER
 */
public class PendingHistoryPanel extends javax.swing.JPanel {

    private Member member;
    private TransaksiControl pemesananControl = new TransaksiControl();
    private TiketControl tCon = new TiketControl();

    public void setMember(Member member){
        this.member = member;
    }

    List<Tiket> listTiket;
    List<Pemesanan> getListPemesanan;
    private DetailPerjalanan dP;
    
    public void showAllPendingTiket(Member member){
        setMember(member);
        TransaksiControl tCon = new TransaksiControl();
        TiketControl tiCon = new TiketControl();
        DetailPerjalananControl dPCon = new DetailPerjalananControl();
        pemesananControl = new TransaksiControl();
        
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
                if(listP.get(i).getStatusPemesanan().equalsIgnoreCase("Belum bayar")){
                    //sementara
                    if(i>=1){
                        //listP.get(i).getTransaksiId() != (listP.get(i-1).getTransaksiId()
                        if(j == listT.size()-1){
                            System.out.println("id pemesanan = " + listP.get(i).getTransaksiId() + " id pemesanan sebelumnya = " + listP.get(i-1).getTransaksiId());
                            tablePending.addRow(new Object[]{listP.get(i).getTransaksiId(),  
                            listT.get(j).getdetailPerjalanan().getKotaKeberangkatan() + " - " 
                            + listT.get(j).getdetailPerjalanan().getKotaKedatangan(),
                            listT.get(j).getdetailPerjalanan().getTanggalKeberangkatan() + " - " + 
                            listT.get(j).getdetailPerjalanan().getTanggalKedatangan(),                
                            listP.get(i).getJumlahPesanan() , 
                            listP.get(i).getStatusPemesanan(),
                            StatusType.PAY});
                        }else{
//                            System.out.println("ini diaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//                        System.out.println("id pemesanan = " + listP.get(i).getTransaksiId() + " id pemesanan sebelumnya = " + listP.get(i-1).getTransaksiId());

                        }
                    }else{
                            tablePending.addRow(new Object[]{listP.get(i).getTransaksiId(),  
                            listT.get(j).getdetailPerjalanan().getKotaKeberangkatan() + " - " 
                            + listT.get(j).getdetailPerjalanan().getKotaKedatangan(),
                            listT.get(j).getdetailPerjalanan().getTanggalKeberangkatan() + " - " + 
                            listT.get(j).getdetailPerjalanan().getTanggalKedatangan(),                
                            listP.get(i).getJumlahPesanan() , 
                            listP.get(i).getStatusPemesanan(),
                            StatusType.PAY});
                    }
                    
                    
                }
            }
            
            
            
            
            
            
            
        }
    }
    
    public void getListTiket(){
        
    }

    
    public PendingHistoryPanel(Member member) {
        setMember(member);
        
        
        initComponents();
        init();
        showAllPendingTiket(member);
        
        tablePending.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tablePending.getSelectedRow();
                int selectedColumn = tablePending.getSelectedColumn();
                
                if (StatusType.PAY.equals(tablePending.getValueAt(selectedRow, selectedColumn))) {
                    Integer pemesananID =  (Integer) tablePending.getValueAt(selectedRow,0);
                    System.out.println("id pemesanan yang dipilih : " + pemesananID);
                    // cari pemesanan berdasarkan id
                    Pemesanan pemesanan = pemesananControl.searchPemesanan(pemesananID);
                    List<Tiket> listTi = tCon.showDataTiketPesanan(pemesanan.getTransaksiId());
                    pemesanan.setTiket(listTi);
                    setForm(new PaymentPanel_1(member, pemesanan));
                    
                }
            }  
        });
    }
    
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public void init(){
        sp.setVerticalScrollBar(new ScrollBar.ScrollBarCustom());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        sp.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        sp.getViewport().setBackground(Color.WHITE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        tablePending = new Table.Table();

        sp.setBorder(null);

        tablePending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pesanan", "Route", "Date", "Jumlah Ticket", "Status", "Choose"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sp.setViewportView(tablePending);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //private Panel.PanelBorder mainPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane sp;
    private Table.Table tablePending;
    // End of variables declaration//GEN-END:variables
}
