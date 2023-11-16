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
public class DoneHistoryPanel extends javax.swing.JPanel {

    private Member member;
    
    public void setMember(Member member){
        this.member = member;
    }

    List<Tiket> listTiket;
    List<Pemesanan> getListPemesanan;
    private DetailPerjalanan dP;
    
    public DoneHistoryPanel(){
        
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
    
    
    
    public DoneHistoryPanel(Member member) {
        setMember(member);
        initComponents();
        init();
        showAllDoneTiket();
        
        
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new Panel.PanelBorder();
        sp = new javax.swing.JScrollPane();
        tableDone = new Table.Table();

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
            .addComponent(sp)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Panel.PanelBorder mainPanel;
    private javax.swing.JScrollPane sp;
    private Table.Table tableDone;
    // End of variables declaration//GEN-END:variables
}
