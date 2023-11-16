    
package Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Model_Menu {
    private String icon;
    private String name;
    private MenuType  Type;

    public Model_Menu() {
    }

    public Model_Menu(String icon, String name, MenuType Type) {
        this.icon = icon;
        this.name = name;
        this.Type = Type;
    }
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/Icon/" + icon + ".png"));         
    }

    public static enum MenuType{
        TITLE, MENU, EMPTY;
    }
    
    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public MenuType getType() {
        return Type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(MenuType Type) {
        this.Type = Type;
    }
}
