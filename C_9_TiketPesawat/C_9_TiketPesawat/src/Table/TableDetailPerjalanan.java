/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import Model.DetailPerjalanan;

/**
 * Jeff Michael Anderson Budiono & I Komang Agus Tinar Virgo Tryana Putra
 * PBO C
 * 210711152 & 210711236
 * Kelompok 4
 */
public class TableDetailPerjalanan extends AbstractTableModel{
    private List<DetailPerjalanan> list;
    
    public TableDetailPerjalanan(List<DetailPerjalanan> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
