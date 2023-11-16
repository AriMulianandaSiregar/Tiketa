/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JTextField;
import Model.*;
import Control.*;
import java.util.List;
import javax.swing.JOptionPane;
import Exception.*;


public class NextFlightPanel extends javax.swing.JPanel {
    private TransaksiControl tCon = new TransaksiControl();
    private SeatControl sCon = new SeatControl();
    private TiketControl tiCon = new TiketControl();
    private KelasControl kCon = new KelasControl();
    
    public NextFlightPanel(Member m,Pemesanan p,DetailPerjalanan dP,int jumlahPenumpang) {
        initComponents();
        next(m,p,dP,jumlahPenumpang);

    }
    
    private void inputKosongException() throws InputKosongException{
        if(namaInput.getText().isBlank() || idCardInput.getText().isBlank() || kewarganegaraanInput.getText().isBlank() || emailInput.getText().isBlank()){
            throw new InputKosongException("Field Input Kosong!!!");
        }
    }
    
    public void next(Member m,Pemesanan p,DetailPerjalanan dP,int jumlahPenumpang){
        try{
            kotaKeberangkatanLbl.setText(dP.getKotaKeberangkatan());
            kotaKedatanganLbl.setText(dP.getKotaKedatangan());
            jamKeberangkatanLbl.setText(dP.getWaktuKeberangkatan());
            jamKedatanganLbl.setText(dP.getWaktuKedatangan());
            nomorPenerbanganLbl.setText(dP.getNomorKeberangkatan());
            pesawatLbl.setText(dP.getKendaraan().getNamaKendaraan());
            List<Seat> listS = sCon.showSeatPerjalanan(dP.getDetailPerjalanId());
            List<KelasPenerbangan> listK = kCon.showAllKelas();
            for(KelasPenerbangan k : listK){
                kelasSeatCb.addItem(k);
            }
            //init awal seatnya
            for(Seat i : listS){
                if(i.isStatusSeat() == false && listS.get(0).getKelas().getJenisKelas().equalsIgnoreCase(i.getKelas().getJenisKelas())){
                   noSeatCb.addItem(i); 
                }
            }
               
            //init harga
            hargaSeatLbl.setText(Double.toString(sCon.getHargaSeat(listS.get(0).getNomorSeat(), dP.getDetailPerjalanId())));
            // tampilkan item combobox yang seat kosong dan sesuai dengan kelas seatnya
            kelasSeatCb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    noSeatCb.removeAllItems();
                    for(Seat i : listS){
                        if(i.isStatusSeat() == false && kelasSeatCb.getSelectedItem().toString().equalsIgnoreCase(i.getKelas().getJenisKelas())){
                           noSeatCb.addItem(i); 
                        }
                    }
                    hargaSeatLbl.setText(Double.toString(sCon.getHargaSeat(noSeatCb.getSelectedItem().toString(), dP.getDetailPerjalanId())));
                }
            });
            findPanel.addMouseListener(new MouseAdapter() {
                
                @Override
                public void mouseClicked(MouseEvent e) {   
                    try{
                        inputKosongException();
                        Integer.parseInt(idCardInput.getText());
                        Pelanggan pel = new Pelanggan(namaInput.getText(),emailInput.getText(),kewarganegaraanInput.getText(),idCardInput.getText());
                        System.out.println("Id Transaksi " + p.getTransaksiId());
                        //insert tiket
                        System.out.println(noSeatCb.getSelectedItem().toString());
                        Tiket t = new Tiket(0,"Belum Bayar",noSeatCb.getSelectedItem().toString(),pel,dP);
                        tiCon.insertTiket(t, p.getTransaksiId());
                        t = tiCon.showDataTiketPesananTerakhir(p.getTransaksiId());
                        Seat s = sCon.showSeat(noSeatCb.getSelectedItem().toString(),dP.getDetailPerjalanId());
                        sCon.inSeat(s.getSeatId());

                        //variable sementara
                        tCon.updateStatusPemesanan(p.getTransaksiId(), "Belum Bayar");
                        double totalHarga = sCon.getHargaSeat(noSeatCb.getSelectedItem().toString(),dP.getDetailPerjalanId());
                        tCon.updateTotalHargaPesanan(p.getTransaksiId(), totalHarga);
                        p.tambahTotalTagihan(totalHarga);
                        //String statusPemesanan, double totalTagihan, int transaksiId
                        p.addTiket(t);
                        tCon.addTiket(p.getTransaksiId());
                            System.out.println("\t\tJumlah Pesanan Tiket : " + p.getJumlahPesanan());
                            if(jumlahPenumpang != 0){
                                setForm(new NextFlightPanel(m,p,dP,jumlahPenumpang-1));
                            } else {
                                setForm(new PaymentPanel(m,p));  
                            }
                    } catch (InputKosongException ex){
                        JOptionPane.showMessageDialog(mainPanel, "Field Input Masih Kosong!!!");
                    } catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(mainPanel, "Nomor KTP Harus Angka Semua!!");
                    }
                }
            });
            //set text ui
        }catch(Exception e){
            System.out.println("Error nextFlight ");
            System.out.println(e.getMessage());
        }
        
    }

    public void setText(){
        
    }
    
    private static boolean isNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
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
        mainPanel = new Panel.PanelBorder();
        namaInput = new javax.swing.JTextField();
        nomorSeat = new javax.swing.JLabel();
        namaLengkapLbl = new javax.swing.JLabel();
        noKtpLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        kewarganegaraanLbl = new javax.swing.JLabel();
        kelasSeatLbl = new javax.swing.JLabel();
        noSeatCb = new javax.swing.JComboBox<>();
        idCardInput = new javax.swing.JTextField();
        kewarganegaraanInput = new javax.swing.JTextField();
        emailInput = new javax.swing.JTextField();
        kelasSeatCb = new javax.swing.JComboBox<>();
        isiDataLbl = new javax.swing.JLabel();
        headerHistory2 = new Panel.HeaderHistory();
        hargaSeatLbl = new javax.swing.JLabel();
        rpLbl = new javax.swing.JLabel();
        kotaKeberangkatanLbl = new javax.swing.JLabel();
        kotaKedatanganLbl = new javax.swing.JLabel();
        pesawatLbl = new javax.swing.JLabel();
        nomorPenerbanganLbl = new javax.swing.JLabel();
        tanggalKeberangkatanLbl = new javax.swing.JLabel();
        jamKeberangkatanLbl = new javax.swing.JLabel();
        jamKedatanganLbl = new javax.swing.JLabel();
        penghubungLbl = new javax.swing.JLabel();
        penghubungLbl1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        findPanel = new Panel.PanelBorder();
        bayarLbl = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        namaInput.setBackground(new java.awt.Color(255, 255, 255, 80));
        namaInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        namaInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                namaInputMouseEntered(evt);
            }
        });
        namaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaInputActionPerformed(evt);
            }
        });

        nomorSeat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nomorSeat.setForeground(new java.awt.Color(0, 0, 0));
        nomorSeat.setText("Nomor Seat");

        namaLengkapLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        namaLengkapLbl.setForeground(new java.awt.Color(0, 0, 0));
        namaLengkapLbl.setText("Nama Lengkap");

        noKtpLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noKtpLbl.setForeground(new java.awt.Color(0, 0, 0));
        noKtpLbl.setText("No Ktp");

        emailLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        emailLbl.setForeground(new java.awt.Color(0, 0, 0));
        emailLbl.setText("E-Mail");

        kewarganegaraanLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kewarganegaraanLbl.setForeground(new java.awt.Color(0, 0, 0));
        kewarganegaraanLbl.setText("Kewarganegaraan");

        kelasSeatLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kelasSeatLbl.setForeground(new java.awt.Color(0, 0, 0));
        kelasSeatLbl.setText("Kelas Seat");

        noSeatCb.setBackground(new java.awt.Color(255, 255, 255));
        noSeatCb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        noSeatCb.setForeground(new java.awt.Color(0, 0, 0));
        noSeatCb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        noSeatCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noSeatCbActionPerformed(evt);
            }
        });

        idCardInput.setBackground(new java.awt.Color(255, 255, 255, 80));
        idCardInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        idCardInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                idCardInputMouseEntered(evt);
            }
        });
        idCardInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCardInputActionPerformed(evt);
            }
        });

        kewarganegaraanInput.setBackground(new java.awt.Color(255, 255, 255, 80));
        kewarganegaraanInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        kewarganegaraanInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kewarganegaraanInputMouseEntered(evt);
            }
        });
        kewarganegaraanInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kewarganegaraanInputActionPerformed(evt);
            }
        });

        emailInput.setBackground(new java.awt.Color(255, 255, 255, 80));
        emailInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        emailInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailInputMouseEntered(evt);
            }
        });
        emailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailInputActionPerformed(evt);
            }
        });

        kelasSeatCb.setBackground(new java.awt.Color(255, 255, 255));
        kelasSeatCb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kelasSeatCb.setForeground(new java.awt.Color(0, 0, 0));
        kelasSeatCb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        isiDataLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        isiDataLbl.setForeground(new java.awt.Color(0, 0, 0));
        isiDataLbl.setText("Isi Data");

        hargaSeatLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        hargaSeatLbl.setForeground(new java.awt.Color(255, 255, 255));
        hargaSeatLbl.setText("0");

        rpLbl.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        rpLbl.setForeground(new java.awt.Color(255, 255, 255));
        rpLbl.setText("Rp");

        kotaKeberangkatanLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kotaKeberangkatanLbl.setForeground(new java.awt.Color(255, 255, 255));
        kotaKeberangkatanLbl.setText("\"\"");

        kotaKedatanganLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kotaKedatanganLbl.setForeground(new java.awt.Color(255, 255, 255));
        kotaKedatanganLbl.setText("\"\"");

        pesawatLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pesawatLbl.setForeground(new java.awt.Color(255, 255, 255));
        pesawatLbl.setText("\"\"");

        nomorPenerbanganLbl.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        nomorPenerbanganLbl.setForeground(new java.awt.Color(255, 255, 255));
        nomorPenerbanganLbl.setText("\"\"");

        tanggalKeberangkatanLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tanggalKeberangkatanLbl.setForeground(new java.awt.Color(255, 255, 255));
        tanggalKeberangkatanLbl.setText("Tanggal Keberangkatan");

        jamKeberangkatanLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jamKeberangkatanLbl.setForeground(new java.awt.Color(255, 255, 255));
        jamKeberangkatanLbl.setText("Jam Keberangkatan");

        jamKedatanganLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jamKedatanganLbl.setForeground(new java.awt.Color(255, 255, 255));
        jamKedatanganLbl.setText("Jam Kedatangan");

        penghubungLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        penghubungLbl.setForeground(new java.awt.Color(255, 255, 255));
        penghubungLbl.setText("-");

        penghubungLbl1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        penghubungLbl1.setForeground(new java.awt.Color(255, 255, 255));
        penghubungLbl1.setText("-");

        javax.swing.GroupLayout headerHistory2Layout = new javax.swing.GroupLayout(headerHistory2);
        headerHistory2.setLayout(headerHistory2Layout);
        headerHistory2Layout.setHorizontalGroup(
            headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerHistory2Layout.createSequentialGroup()
                .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerHistory2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headerHistory2Layout.createSequentialGroup()
                                .addComponent(rpLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hargaSeatLbl))
                            .addComponent(tanggalKeberangkatanLbl)))
                    .addGroup(headerHistory2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jamKeberangkatanLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(penghubungLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jamKedatanganLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headerHistory2Layout.createSequentialGroup()
                        .addComponent(kotaKeberangkatanLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(penghubungLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kotaKedatanganLbl))
                    .addComponent(pesawatLbl)
                    .addComponent(nomorPenerbanganLbl))
                .addGap(33, 33, 33))
        );
        headerHistory2Layout.setVerticalGroup(
            headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerHistory2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaSeatLbl)
                    .addComponent(rpLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tanggalKeberangkatanLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jamKedatanganLbl)
                    .addComponent(penghubungLbl)
                    .addComponent(jamKeberangkatanLbl))
                .addGap(27, 27, 27))
            .addGroup(headerHistory2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(nomorPenerbanganLbl)
                .addGap(5, 5, 5)
                .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerHistory2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(headerHistory2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kotaKeberangkatanLbl)
                            .addComponent(kotaKedatanganLbl)
                            .addComponent(penghubungLbl1)))
                    .addGroup(headerHistory2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pesawatLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        findPanel.setBackground(new java.awt.Color(0, 153, 153));
        findPanel.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        findPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                findPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                findPanelMouseExited(evt);
            }
        });

        bayarLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bayarLbl.setForeground(new java.awt.Color(255, 255, 255));
        bayarLbl.setText("Next");

        javax.swing.GroupLayout findPanelLayout = new javax.swing.GroupLayout(findPanel);
        findPanel.setLayout(findPanelLayout);
        findPanelLayout.setHorizontalGroup(
            findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(bayarLbl)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        findPanelLayout.setVerticalGroup(
            findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bayarLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noKtpLbl)
                    .addComponent(namaLengkapLbl)
                    .addComponent(isiDataLbl)
                    .addComponent(kelasSeatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelasSeatLbl)
                    .addComponent(idCardInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLbl)
                    .addComponent(kewarganegaraanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kewarganegaraanLbl)
                    .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomorSeat)
                    .addComponent(noSeatCb, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(719, Short.MAX_VALUE)
                .addComponent(findPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerHistory2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(headerHistory2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(isiDataLbl)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(namaLengkapLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(kelasSeatLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kelasSeatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(noKtpLbl)
                        .addGap(18, 18, 18)
                        .addComponent(idCardInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(kewarganegaraanLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(kewarganegaraanInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(emailLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nomorSeat)
                        .addGap(18, 18, 18)
                        .addComponent(noSeatCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addGap(26, 26, 26)
                .addComponent(findPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void namaInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_namaInputMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_namaInputMouseEntered

    private void namaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaInputActionPerformed

    private void idCardInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_idCardInputMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_idCardInputMouseEntered

    private void idCardInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCardInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCardInputActionPerformed

    private void kewarganegaraanInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kewarganegaraanInputMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_kewarganegaraanInputMouseEntered

    private void kewarganegaraanInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kewarganegaraanInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kewarganegaraanInputActionPerformed

    private void emailInputMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailInputMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputMouseEntered

    private void emailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailInputActionPerformed

    private void findPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findPanelMouseEntered
        findPanel.setBackground(new Color(0,102,102));
        findPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_findPanelMouseEntered

    private void findPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findPanelMouseExited
        findPanel.setBackground(new Color(0,153,153));
    }//GEN-LAST:event_findPanelMouseExited

    private void noSeatCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noSeatCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noSeatCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bayarLbl;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel emailLbl;
    private Panel.PanelBorder findPanel;
    private javax.swing.JLabel hargaSeatLbl;
    private Panel.HeaderHistory headerHistory2;
    private javax.swing.JTextField idCardInput;
    private javax.swing.JLabel isiDataLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jamKeberangkatanLbl;
    private javax.swing.JLabel jamKedatanganLbl;
    private javax.swing.JComboBox<KelasPenerbangan> kelasSeatCb;
    private javax.swing.JLabel kelasSeatLbl;
    private javax.swing.JTextField kewarganegaraanInput;
    private javax.swing.JLabel kewarganegaraanLbl;
    private javax.swing.JLabel kotaKeberangkatanLbl;
    private javax.swing.JLabel kotaKedatanganLbl;
    private Panel.PanelBorder mainPanel;
    private javax.swing.JTextField namaInput;
    private javax.swing.JLabel namaLengkapLbl;
    private javax.swing.JLabel noKtpLbl;
    private javax.swing.JComboBox<Seat> noSeatCb;
    private javax.swing.JLabel nomorPenerbanganLbl;
    private javax.swing.JLabel nomorSeat;
    private javax.swing.JLabel penghubungLbl;
    private javax.swing.JLabel penghubungLbl1;
    private javax.swing.JLabel pesawatLbl;
    private javax.swing.JLabel rpLbl;
    private javax.swing.JLabel tanggalKeberangkatanLbl;
    // End of variables declaration//GEN-END:variables
}
