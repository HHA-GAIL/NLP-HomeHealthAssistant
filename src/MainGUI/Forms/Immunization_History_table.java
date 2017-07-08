package MainGUI.Forms;

import MainGUI.Classes.ImmunizationsHistory;
import MainGUI.DAO.ImmunizationHistoryDAO;
import static MainGUI.MasterGUI.patient_ID;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * Done!
 *
 * @author Fan Hu, Zhiwei Chu
 */
public class Immunization_History_table extends JInternalFrame {

    private JTable table;
    private DefaultTableCellRenderer render;
    private ImmunizationHistoryDAO dao;
    private DefaultTableModel model;
    private JButton addRow;
    private JButton delete;
    private JButton update;
    private JButton insert;
    private JButton toggle;
    private JButton refresh;
    private boolean inEditMode = true;
    private Queue<Integer> addedRowNum; // store added row number, in order to apply change at one time
    private PriorityQueue<Integer> changedRowNum; // store changed row number, in order to apply change at one time
    private Stack<Integer> tempNum; // store changed row number, in order to apply change at one time
    private boolean flag = false;

    public Immunization_History_table() {
        initComponents();
    }

    private void initComponents() {
        setLocation(200, 100);
        setClosable(true);
        setIconifiable(true);
        setTitle("Immunization History");
        setSize(900, 600);
        setVisible(true);
        setLayout(new BorderLayout());

        addedRowNum = new LinkedList<>();
        changedRowNum = new PriorityQueue<>();
        tempNum = new Stack<>();
        table = new JTable();
        render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(SwingConstants.CENTER);

        initTable();
        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 6, 20, 0));
        addRow = new JButton("Add row");
        addRow.addActionListener(evt -> addRow());
        addRow.setEnabled(false);
        delete = new JButton("Delete");
        delete.addActionListener(evt -> deleteAction());
        delete.setEnabled(false);
        update = new JButton("Update");
        update.addActionListener(evt -> updateAction());
        update.setEnabled(false);
        insert = new JButton("Insert");
        insert.addActionListener(evt -> insertAction());
        insert.setEnabled(false);
        toggle = new JButton("Enable Editing");
        toggle.addActionListener(evt -> toggleAction());
        refresh = new JButton("Refresh");
        refresh.addActionListener(evt -> initTable());

        buttons.add(refresh);
        buttons.add(toggle);
        buttons.add(addRow);
        buttons.add(insert);
        buttons.add(update);
        buttons.add(delete);
        add(buttons, BorderLayout.SOUTH);
    }

    private void initTable() {
        dao = new ImmunizationHistoryDAO();
        model = dao.getTableModel();
        model.addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            if (!(row >= table.getRowCount()) && table.getRowCount() > 0) {
                if (table.getValueAt(row, 0) != null && dao.getCurrentId() > (int) table.getValueAt(row, 0)) {
                    if (!changedRowNum.contains(row)) {
                        changedRowNum.add(row);
                    }
                    if (!insert.isEnabled()) {
                        update.setEnabled(true);
                    }
                }
            }
        });
        table.setModel(model);
        table.setRowHeight(25);
        table.setEnabled(false);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setCellSelectionEnabled(true);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setSelectionBackground(Color.GRAY);
        table.setFont(new Font("", Font.PLAIN, 15));
        table.setDefaultRenderer(Object.class, render);
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                delete.setEnabled(true);
            }
        });

        TableColumn tm = table.getColumnModel().getColumn(0);
        TableColumn tm_id = table.getColumnModel().getColumn(1);
        tm.setCellRenderer(new ColorColumnRenderer(new Color(0x98, 0xAF, 0xC7), Color.BLACK));
        tm_id.setCellRenderer(new ColorColumnRenderer(new Color(0xAD, 0xAF, 0xC7), Color.BLACK));
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    private void addRow() {
        model.addRow(new Object[]{});
        table.setRowSelectionInterval(table.getRowCount() - 1, table.getRowCount() - 1);

        table.editCellAt(table.getRowCount() - 1, table.getRowCount() - 1);
        if (flag) {
            table.setValueAt((int) table.getValueAt(table.getSelectedRow() - 1, 0) + 1, table.getSelectedRow(), 0);
        } else {
            table.setValueAt(dao.getCurrentId(), table.getSelectedRow(), 0);
            flag = true;
        }

        table.setValueAt(Integer.parseInt(patient_ID), table.getSelectedRow(), 1);
        addedRowNum.add(table.getSelectedRow()); // add changed row number to the stack
        insert.setEnabled(true);
        update.setEnabled(false);
    }

    private void insertAction() {
        insert.setEnabled(false);
        addRow.setEnabled(true);

        int row;
        List<ImmunizationsHistory> immunizationsHistories = new ArrayList<>();

        String lineInfo = "<table style='font-size:12px;border:1px solid black;'>"
                + "<tr style='text-align:center'>"
                + "<th style='border:1px solid black;'>Immunization ID</th>"
                + "<th style='border:1px solid black;'>Patient ID</th>"
                + "<th style='border:1px solid black;'>Vaccine</th>"
                + "<th style='border:1px solid black;'>Immunization Date</th>"
                + "<th style='border:1px solid black;'>ExpirationDate Date</th>"
                + "<th style='border:1px solid black;'>Delivery</th>"
                + "<th style='border:1px solid black;'>Comments</th>"
                + "<th style='border:1px solid black;'>HCPId</th>"
                + "</tr>";

        while (!addedRowNum.isEmpty()) {
            row = addedRowNum.poll();
            tempNum.push(row);

            lineInfo += "<tr style='text-align:center'>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 0) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 1) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 2) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 3) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 4) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 5) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 6) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 7) + "</td>"
                    + "</tr>";

            ImmunizationsHistory immunizationHistory = new ImmunizationsHistory();
            immunizationHistory.setImmunizationsID((int) table.getValueAt(row, 0));
            immunizationHistory.setPatientID((int) table.getValueAt(row, 1));
            immunizationHistory.setVaccine((String) table.getValueAt(row, 2));
            immunizationHistory.setDelivery((String) table.getValueAt(row, 5));
            immunizationHistory.setComments((String) table.getValueAt(row, 6));
            immunizationHistory.setHCPId(Integer.parseInt((String) table.getValueAt(row, 7)));
            try {
                java.util.Date date;
                java.sql.Date sqlStartDate;
                if (table.getValueAt(row, 3) != null) {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 3));
                    sqlStartDate = new Date(date.getTime());
                    immunizationHistory.setExperationDate(sqlStartDate);
                }
                if (table.getValueAt(row, 4) != null) {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 4));
                    sqlStartDate = new Date(date.getTime());
                    immunizationHistory.setExperationDate(sqlStartDate);
                }
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            immunizationHistory.setDeleted(new Byte("0"));

            immunizationsHistories.add(immunizationHistory);
        }//end of while

        int n = JOptionPane.showConfirmDialog(null, "<html>"
                + "<span style='font-size:15px;font-family:Comic Sans MS;font-weight:bold;color:#3090C7'>"
                + "Insert information below?"
                + "</span><br/><br/>"
                + lineInfo + "</table></html>",
                "Confirm Insert", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            if (dao.add(immunizationsHistories)) {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Insert success!</span></html>");
                flag = false;
                while (!tempNum.isEmpty()) {
                    tempNum.pop();
                }
                initTable();
                table.setEnabled(true);
                table.setGridColor(Color.LIGHT_GRAY);
            } else {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Insert failed.</span></html>",
                        "Error", JOptionPane.ERROR_MESSAGE);
                while (!tempNum.isEmpty()) {
                    model.removeRow((int) tempNum.pop());
                }
            }
        } else if (n == 1) {
            insert.setEnabled(false);
            addRow.setEnabled(true);
            update.setEnabled(false);
            while (!tempNum.isEmpty()) {
                model.removeRow(tempNum.pop());
            }
        }
        changedRowNum.clear();
    }

    private void deleteAction() {
        List<ImmunizationsHistory> immunizationsHistories = new ArrayList<>();
        int[] rows = table.getSelectedRows();
        String lineInfo = "<table style='font-size:12px;border:1px solid black;'>"
                + "<tr style='text-align:center'>"
                + "<th style='border:1px solid black;'>Immunization ID</th>"
                + "<th style='border:1px solid black;'>Patient ID</th>"
                + "<th style='border:1px solid black;'>Vaccine</th>"
                + "<th style='border:1px solid black;'>Immunization Date</th>"
                + "<th style='border:1px solid black;'>ExperationDate Date</th>"
                + "<th style='border:1px solid black;'>Delivery</th>"
                + "<th style='border:1px solid black;'>Comments</th>"
                + "<th style='border:1px solid black;'>HCPId</th>"
                + "</tr>";

        for (int row : rows) {
            if (addedRowNum.contains(row)) {
                addedRowNum.remove(row);
                tempNum.add(row);
            } else {
                tempNum.add(row);
                lineInfo += "<tr style='text-align:center'>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 0) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 1) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 2) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 3) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 4) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 5) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 6) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 7) + "</td>"
                        + "</tr>";

                ImmunizationsHistory immunizationHistory = new ImmunizationsHistory();
                immunizationHistory.setImmunizationsID((int) table.getValueAt(row, 0));
                immunizationHistory.setPatientID((int) table.getValueAt(row, 1));
                immunizationHistory.setVaccine((String) table.getValueAt(row, 2));
                immunizationHistory.setDelivery((String) table.getValueAt(row, 5));
                immunizationHistory.setComments((String) table.getValueAt(row, 6));
                immunizationHistory.setHCPId((int) table.getValueAt(row, 7));
                try {
                    java.util.Date date;
                    java.sql.Date sqlStartDate;

                    if (table.getValueAt(row, 3) != null) {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 3));
                        sqlStartDate = new Date(date.getTime());
                        immunizationHistory.setExperationDate(sqlStartDate);
                    }

                    if (table.getValueAt(row, 4) != null) {
                        date = new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 4));
                        sqlStartDate = new Date(date.getTime());
                        immunizationHistory.setExperationDate(sqlStartDate);
                    }

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                immunizationHistory.setDeleted(new Byte("1"));

                immunizationsHistories.add(immunizationHistory);
            }
        }

        if (addedRowNum.isEmpty()) {
            flag = false;
            insert.setEnabled(false);
        }

        int n = JOptionPane.showConfirmDialog(null, "<html>"
                + "<span style='font-size:15px;font-family:Comic Sans MS;font-weight:bold;color:#3090C7'>"
                + "Delete these information?"
                + "</span><br/><br/>"
                + lineInfo + "</table></html>",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            if (dao.update(immunizationsHistories)) {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:12px;font-family:Comic Sans MS;color:red'>Delete success!</span></html>");
                while (!tempNum.isEmpty()) {
                    model.removeRow(tempNum.pop());
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:12px;font-family:Comic Sans MS;color:red'>Delete failed.</span></html>",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        changedRowNum.clear();
    }

    private void updateAction() {
        int row;
        List<ImmunizationsHistory> immunizationsHistories = new ArrayList<>();
        String lineInfo = "<table style='font-size:12px;border:1px solid black;'>"
                + "<tr style='text-align:center'>"
                + "<th style='border:1px solid black;'>Immunization ID</th>"
                + "<th style='border:1px solid black;'>Patient ID</th>"
                + "<th style='border:1px solid black;'>Vaccine</th>"
                + "<th style='border:1px solid black;'>Immunization Date</th>"
                + "<th style='border:1px solid black;'>ExperationDate Date</th>"
                + "<th style='border:1px solid black;'>Delivery</th>"
                + "<th style='border:1px solid black;'>Comments</th>"
                + "<th style='border:1px solid black;'>HCPId</th>"
                + "</tr>";

        while (!changedRowNum.isEmpty()) {
            row = changedRowNum.poll();
            lineInfo += "<tr style='text-align:center'>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 0) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 1) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 2) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 3) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 4) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 5) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 6) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 7) + "</td>"
                    + "</tr>";

            ImmunizationsHistory immunizationHistory = new ImmunizationsHistory();
            immunizationHistory.setImmunizationsID((int) table.getValueAt(row, 0));
            immunizationHistory.setPatientID((int) table.getValueAt(row, 1));
            immunizationHistory.setVaccine((String) table.getValueAt(row, 2));

            immunizationHistory.setDelivery((String) table.getValueAt(row, 5));
            immunizationHistory.setComments((String) table.getValueAt(row, 6));
            immunizationHistory.setHCPId((int) table.getValueAt(row, 7));
            try {

                if ((table.getValueAt(row, 3)) instanceof java.sql.Date) {
                    java.sql.Date sqlStartDate = (java.sql.Date) table.getValueAt(row, 3);
                    immunizationHistory.setImmunizationDate(sqlStartDate);
                } else {
                    java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 3));
                    java.sql.Date sqlStartDate = new Date(date.getTime());
                    immunizationHistory.setImmunizationDate(sqlStartDate);
                }

                if ((table.getValueAt(row, 4)) instanceof java.sql.Date) {
                    java.sql.Date sqlStartDate = (java.sql.Date) table.getValueAt(row, 4);
                    immunizationHistory.setExperationDate(sqlStartDate);
                } else {
                    java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) table.getValueAt(row, 4));
                    java.sql.Date sqlStartDate = new Date(date.getTime());
                    immunizationHistory.setExperationDate(sqlStartDate);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            immunizationHistory.setDeleted(new Byte("0"));
            immunizationsHistories.add(immunizationHistory);
        }

        int n = JOptionPane.showConfirmDialog(null, "<html>"
                + "<span style='font-size:15px;font-family:Comic Sans MS;font-weight:bold;color:#3090C7'>"
                + "Update information below?"
                + "</span><br/><br/>"
                + lineInfo + "</table></html>",
                "Confirm Update", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            if (dao.update(immunizationsHistories)) {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Update success!</span></html>");
                update.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Update failed.</span></html>",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (n == 1) {
            initTable();
            table.setGridColor(Color.WHITE);
            table.setEnabled(true);
            update.setEnabled(false);
        }
    }

    private void toggleAction() {
        if (inEditMode) {
            table.setBackground(Color.LIGHT_GRAY);
            table.setGridColor(Color.WHITE);
            table.setEnabled(true);
            addRow.setEnabled(true);
            refresh.setEnabled(false);
            toggle.setText("Quit Editing");
            inEditMode = false;
        } else {
            table.setBackground(null);
            table.setGridColor(Color.LIGHT_GRAY);
            table.clearSelection();
            table.setEnabled(false);
            addRow.setEnabled(false);
            delete.setEnabled(false);
            update.setEnabled(false);
            insert.setEnabled(false);
            refresh.setEnabled(true);
            toggle.setText("Enable Editing");
            inEditMode = true;
        }
    }
}
