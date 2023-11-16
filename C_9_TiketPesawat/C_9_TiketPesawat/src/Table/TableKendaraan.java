/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import Model.Kendaraan;

public class TableKendaraan extends AbstractTableModel{
    private List<Kendaraan> list;

    public TableKendaraan(List<Kendaraan> list) {
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0 : 
                return list.get(rowIndex).getKendaraanID();
            case 1 :
                return list.get(rowIndex).getNamaKendaraan();
            case 2 :
                return list.get(rowIndex).getJumlahSeat();
            case 3 :
                return list.get(rowIndex).getJenisKendaraan();
            default :
                return null;
        }
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0 :
                return "ID Kendaraan";
            case 1 :
                return "Nama Kendaraan";
            case 2 :
                return "Jumlah Seat Kendaraan";
            case 3 :
                return "Jenis Kendaraan";
            default :
                return null;
        }
    }
}
