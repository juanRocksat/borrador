package ejemplo;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author charly
 */
public class MultiLineCellRenderer extends JTextArea
implements TableCellRenderer{
    public MultiLineCellRenderer(){
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
       
    }

    public static boolean BOLD;
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value,
                                   boolean isSelected, boolean hasFocus,
                                   int row, int column) {
        if(isSelected){
            setForeground(jtable.getSelectionForeground());
            setBackground(jtable.getSelectionBackground());
        }else{
            setForeground(jtable.getForeground());
            setBackground(jtable.getBackground());
        }
       
        Font font = null;
        if(BOLD)
            font = new Font(jtable.getFont().getFontName(), Font.BOLD, jtable.getFont().getSize() );
        else
            font = jtable.getFont();
       
        setToolTipText((String)value);
        setFont(font);
       
        setText((String)value);
        if(hasFocus){
            setBorder(UIManager.getBorder("Table.focusCellHighLightBroder"));
           
        }else{
            setBorder(new EmptyBorder(0,0,0,0));
        }
       
        return this;
    }
   
}