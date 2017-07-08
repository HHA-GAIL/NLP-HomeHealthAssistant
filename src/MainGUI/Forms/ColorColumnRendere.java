/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGUI.Forms;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * set cell color
 *
 * @author Zhiwei Chu
 */
class ColorColumnRenderer extends DefaultTableCellRenderer {

    Color bkgndColor, fgndColor;

    /**
     * construction
     *
     * @param bkgnd background color
     * @param foregnd foreground color
     */
    public ColorColumnRenderer(Color bkgnd, Color foregnd) {
        super();
        bkgndColor = bkgnd;
        fgndColor = foregnd;
        setHorizontalAlignment(0);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            cell.setBackground(Color.DARK_GRAY);
        } else {
            cell.setBackground(bkgndColor);
            cell.setForeground(fgndColor);
        }
        return cell;
    }
}
