
package Table;

import Model.StatusType;
import Panel.CellStatus;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Table extends JTable{
    
    public Table(){
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");
                if(column==6){
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            } 
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(column !=5){
                    Component com =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    com.setBackground(Color.WHITE);
                    setBorder(noFocusBorder);
                    if(isSelected){
                        
                        com.setForeground(new Color(54,180,234));
                    }else{
                        com.setForeground(new Color(102,102,102));
                    }
                    return com;
                }else{
                    StatusType type=(StatusType)value;
                    CellStatus cell = new CellStatus(type);
                    
                    return cell;
                }
                
            }
            
        });
    }
    
    public void addRow(Object[] row){
        DefaultTableModel model=(DefaultTableModel) getModel();
        model.addRow(row);
    }
}
