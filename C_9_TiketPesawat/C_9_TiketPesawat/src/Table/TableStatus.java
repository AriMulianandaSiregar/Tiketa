
package Table;

import Model.StatusType;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class TableStatus extends JLabel{
    
    private StatusType type;
    
    public TableStatus(){
        setForeground(Color.WHITE);
    }
    
    public void setType(StatusType type){
        this.type = type;
        setText(type.toString());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(type!=null){
            Graphics2D g2 =(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint g3;
            if(type == StatusType.AVAILABLE){
                g3 = new GradientPaint(0, 0, new Color(27,107,237), 0, getHeight(), new Color(27,107,237));
                g2.setPaint(g3);
            }else if(type == StatusType.DETAIL){
                g3 = new GradientPaint(0, 0, new Color(36,46,63), 0, getHeight(), new Color(36,46,63));
                g2.setPaint(g3);
            }else if(type == StatusType.PAY){
                g3 = new GradientPaint(0, 0, new Color(36,46,63), 0, getHeight(), new Color(36,46,63));
                g2.setPaint(g3);
            }
            
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        }
        super.paintComponent(g);
    }
    
    
}
