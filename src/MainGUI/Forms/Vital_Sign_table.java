package MainGUI.Forms;

import MainGUI.Classes.VitalSign;
import MainGUI.DAO.VitalSignDAO;
import static MainGUI.MasterGUI.patient_ID;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
 *
 * @author Fan Hu
 */
public class Vital_Sign_table extends JInternalFrame {

    private JTable table;
    private DefaultTableCellRenderer render;
    private VitalSignDAO dao;
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

    public Vital_Sign_table() {
        initComponents();
    }

    private void initComponents() {
        setLocation(150, 100);
        setClosable(true);
        setIconifiable(true);
        setTitle("Vital Signs");
        setSize(1100, 600);
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
        dao = new VitalSignDAO();
        model = dao.getTableModel();
        model.addTableModelListener((TableModelEvent e) -> {
            int row = e.getFirstRow();
            if (row < table.getRowCount()) {
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
        /*change the size of table*/
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
        List<VitalSign> vitalsigns = new ArrayList<>();

        String lineInfo = "<table style='font-size:12px;border:1px solid black;'>"
                + "<tr style='text-align:center'>"
                + "<th style='border:1px solid black;'>Encounter ID</th>"
                + "<th style='border:1px solid black;'>Patient ID</th>"
                + "<th style='border:1px solid black;'>PETime</th>"
                + "<th style='border:1px solid black;'>Ht</th>"
                + "<th style='border:1px solid black;'>Ht_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>Wt</th>"
                + "<th style='border:1px solid black;'>Wt_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>HR</th>"
                + "<th style='border:1px solid black;'>RR</th>"
                + "<th style='border:1px solid black;'>HeadCircumference</th>"
                + "<th style='border:1px solid black;'>Head_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>BodyMassIndex</th>"
                + "<th style='border:1px solid black;'>BPSYS1</th>"
                + "<th style='border:1px solid black;'>BPDIAS1</th>"
                + "<th style='border:1px solid black;'>BP1Position</th>"
                + "<th style='border:1px solid black;'>BP1Location</th>"
                + "<th style='border:1px solid black;'>BPSYS2</th>"
                + "<th style='border:1px solid black;'>BPDIAS2</th>"
                + "<th style='border:1px solid black;'>BP2Position</th>"
                + "<th style='border:1px solid black;'>BP2Location</th>"
                + "<th style='border:1px solid black;'>BPSYS3</th>"
                + "<th style='border:1px solid black;'>BPDIAS3</th>"
                + "<th style='border:1px solid black;'>BP3Position</th>"
                + "<th style='border:1px solid black;'>BP3Location</th>"
                + "<th style='border:1px solid black;'>Temperature</th>"
                + "<th style='border:1px solid black;'>Temperature_unit</th>"
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
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 8) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 9) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 10) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 11) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 12) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 13) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 14) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 15) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 16) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 17) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 18) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 19) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 20) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 21) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 22) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 23) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 24) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 25) + "</td>"
                    //                     + "<td style='border:1px solid black;'>" + table.getValueAt(row, 26) + "</td>"
                    + "</tr>";

            VitalSign vitalSign = new VitalSign();
            vitalSign.setEncounterID((int) table.getValueAt(row, 0));
            vitalSign.setPatientID((int) table.getValueAt(row, 1));
            vitalSign.setPETime((String) table.getValueAt(row, 2));
            if (table.getValueAt(row, 3) == null) {
                vitalSign.setHt(0);
            } else {
                vitalSign.setHt(Double.parseDouble(String.valueOf(table.getValueAt(row, 3))));
            }

            vitalSign.setHt_Unit_of_Measurement((String) table.getValueAt(row, 4));
            if (table.getValueAt(row, 5) == null) {
                vitalSign.setWt(0);
            } else {
                vitalSign.setWt(Double.parseDouble(String.valueOf(table.getValueAt(row, 5))));
            }
            vitalSign.setWt_Unit_of_Measurement((String) table.getValueAt(row, 6));
            if (table.getValueAt(row, 7) == null) {
                vitalSign.setHR(0);
            } else {
                vitalSign.setHR(Integer.parseInt(String.valueOf(table.getValueAt(row, 7))));
            }
            if (table.getValueAt(row, 8) == null) {
                vitalSign.setRR(0);
            } else {
                vitalSign.setRR(Integer.parseInt(String.valueOf(table.getValueAt(row, 8))));
            }
            if (table.getValueAt(row, 9) == null) {
                vitalSign.setHeadCircumference(0);
            } else {
                vitalSign.setHeadCircumference(Double.parseDouble(String.valueOf(table.getValueAt(row, 9))));
            }
            vitalSign.setHead_Unit_of_Measurement((String) table.getValueAt(row, 10));
            if (table.getValueAt(row, 10) == null) {
                vitalSign.setBodyMassIndex(0);
            } else {
                vitalSign.setBodyMassIndex(Double.parseDouble(String.valueOf(table.getValueAt(row, 11))));
            }
            if (table.getValueAt(row, 11) == null) {
                vitalSign.setBPSYS1(0);
            } else {
                vitalSign.setBPSYS1(Integer.parseInt(String.valueOf(table.getValueAt(row, 12))));
            }
            if (table.getValueAt(row, 12) == null) {
                vitalSign.setBPDIAS1(0);
            } else {
                vitalSign.setBPDIAS1(Integer.parseInt(String.valueOf(table.getValueAt(row, 13))));
            }
            vitalSign.setBP1Position((String) table.getValueAt(row, 14));
            vitalSign.setBP1Location((String) table.getValueAt(row, 15));
            if (table.getValueAt(row, 16) == null) {
                vitalSign.setBPSYS2(0);
            } else {
                vitalSign.setBPSYS2(Integer.parseInt(String.valueOf(table.getValueAt(row, 16))));
            }
            if (table.getValueAt(row, 17) == null) {
                vitalSign.setBPDIAS2(0);
            } else {
                vitalSign.setBPDIAS2(Integer.parseInt(String.valueOf(table.getValueAt(row, 17))));
            }
            vitalSign.setBP2Position((String) table.getValueAt(row, 18));
            vitalSign.setBP2Location((String) table.getValueAt(row, 19));
            if (table.getValueAt(row, 20) == null) {
                vitalSign.setBPSYS3(0);
            } else {
                vitalSign.setBPSYS3(Integer.parseInt(String.valueOf(table.getValueAt(row, 20))));
            }
            if (table.getValueAt(row, 21) == null) {
                vitalSign.setBPDIAS3(0);
            } else {
                vitalSign.setBPDIAS3(Integer.parseInt(String.valueOf(table.getValueAt(row, 21))));
            }
            vitalSign.setBP3Position((String) table.getValueAt(row, 22));
            vitalSign.setBP3Location((String) table.getValueAt(row, 23));
            if (table.getValueAt(row, 24) == null) {
                vitalSign.setTemperature(0);
            } else {
                vitalSign.setTemperature(Double.parseDouble(String.valueOf(table.getValueAt(row, 24))));
            }
            vitalSign.setTemperature_unit((String) table.getValueAt(row, 25));
            vitalSign.setDeleted(new Byte("0"));

            vitalsigns.add(vitalSign);

        } //end of while   

        int n = JOptionPane.showConfirmDialog(null, "<html>"
                + "<span style='font-size:15px;font-family:Comic Sans MS;font-weight:bold;color:#3090C7'>"
                + "Insert information below?"
                + "</span><br/><br/>"
                + lineInfo + "</table></html>",
                "Confirm Insert", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            if (dao.add(vitalsigns)) {
                JOptionPane.showMessageDialog(null, "<html><span style='font-size:15px;font-family:Comic Sans MS;color:red;'>Insert success!</span></html>");
                flag = false;
                while (!tempNum.isEmpty()) {
                    tempNum.pop();
                }
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
        List<VitalSign> vitalsigns = new ArrayList<>();
        int[] rows = table.getSelectedRows();

        String lineInfo = "<table style='font-size:12px;border:1px solid black;'>"
                + "<tr style='text-align:center'>"
                + "<th style='border:1px solid black;'>Encounter ID</th>"
                + "<th style='border:1px solid black;'>Patient ID</th>"
                + "<th style='border:1px solid black;'>PETime</th>"
                + "<th style='border:1px solid black;'>Ht</th>"
                + "<th style='border:1px solid black;'>Ht_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>Wt</th>"
                + "<th style='border:1px solid black;'>Wt_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>HR</th>"
                + "<th style='border:1px solid black;'>RR</th>"
                + "<th style='border:1px solid black;'>HeadCircumference</th>"
                + "<th style='border:1px solid black;'>Head_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>BodyMassIndex</th>"
                + "<th style='border:1px solid black;'>BPSYS1</th>"
                + "<th style='border:1px solid black;'>BPDIAS1</th>"
                + "<th style='border:1px solid black;'>BP1Position</th>"
                + "<th style='border:1px solid black;'>BP1Location</th>"
                + "<th style='border:1px solid black;'>BPSYS2</th>"
                + "<th style='border:1px solid black;'>BPDIAS2</th>"
                + "<th style='border:1px solid black;'>BP2Position</th>"
                + "<th style='border:1px solid black;'>BP2Location</th>"
                + "<th style='border:1px solid black;'>BPSYS3</th>"
                + "<th style='border:1px solid black;'>BPDIAS3</th>"
                + "<th style='border:1px solid black;'>BP3Position</th>"
                + "<th style='border:1px solid black;'>BP3Location</th>"
                + "<th style='border:1px solid black;'>Temperature</th>"
                + "<th style='border:1px solid black;'>Temperature_unit</th>"
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
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 8) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 9) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 10) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 11) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 12) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 13) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 14) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 15) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 16) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 17) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 18) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 19) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 20) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 21) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 22) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 23) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 24) + "</td>"
                        + "<td style='border:1px solid black;'>" + table.getValueAt(row, 25) + "</td>"
                        //                     + "<td style='border:1px solid black;'>" + table.getValueAt(row, 26) + "</td>"
                        + "</tr>";

                VitalSign vitalSign = new VitalSign();
                vitalSign.setEncounterID((int) table.getValueAt(row, 0));
                vitalSign.setPatientID((int) table.getValueAt(row, 1));
                vitalSign.setPETime((String) table.getValueAt(row, 2));
                vitalSign.setHt(Double.parseDouble(String.valueOf(table.getValueAt(row, 3))));
                vitalSign.setHt_Unit_of_Measurement((String) table.getValueAt(row, 4));
                vitalSign.setWt(Double.parseDouble(String.valueOf(table.getValueAt(row, 5))));
                vitalSign.setWt_Unit_of_Measurement((String) table.getValueAt(row, 6));
                vitalSign.setHR(Integer.parseInt(String.valueOf(table.getValueAt(row, 7))));
                vitalSign.setRR(Integer.parseInt(String.valueOf(table.getValueAt(row, 8))));
                vitalSign.setHeadCircumference(Double.parseDouble(String.valueOf(table.getValueAt(row, 9))));
                vitalSign.setHead_Unit_of_Measurement((String) table.getValueAt(row, 10));
                vitalSign.setBodyMassIndex(Double.parseDouble(String.valueOf(table.getValueAt(row, 11))));
                vitalSign.setBPSYS1(Integer.parseInt(String.valueOf(table.getValueAt(row, 12))));
                vitalSign.setBPDIAS1(Integer.parseInt(String.valueOf(table.getValueAt(row, 13))));
                vitalSign.setBP1Position((String) table.getValueAt(row, 14));
                vitalSign.setBP1Location((String) table.getValueAt(row, 15));
                vitalSign.setBPSYS2(Integer.parseInt(String.valueOf(table.getValueAt(row, 16))));
                vitalSign.setBPDIAS2(Integer.parseInt(String.valueOf(table.getValueAt(row, 17))));
                vitalSign.setBP2Position((String) table.getValueAt(row, 18));
                vitalSign.setBP2Location((String) table.getValueAt(row, 19));
                vitalSign.setBPSYS3(Integer.parseInt(String.valueOf(table.getValueAt(row, 20))));
                vitalSign.setBPDIAS3(Integer.parseInt(String.valueOf(table.getValueAt(row, 21))));
                vitalSign.setBP3Position((String) table.getValueAt(row, 22));
                vitalSign.setBP3Location((String) table.getValueAt(row, 23));
                vitalSign.setTemperature(Double.parseDouble(String.valueOf(table.getValueAt(row, 24))));
                vitalSign.setTemperature_unit((String) table.getValueAt(row, 25));

                vitalSign.setDeleted(new Byte("1"));

                vitalsigns.add(vitalSign);
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
            if (dao.update(vitalsigns)) {
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
        List<VitalSign> vitalsigns = new ArrayList<>();
        int row;

        String lineInfo = "<table style='font-size:12px;border:1px solid black;'>"
                + "<tr style='text-align:center'>"
                + "<th style='border:1px solid black;'>Encounter ID</th>"
                + "<th style='border:1px solid black;'>Patient ID</th>"
                + "<th style='border:1px solid black;'>PETime</th>"
                + "<th style='border:1px solid black;'>Ht</th>"
                + "<th style='border:1px solid black;'>Ht_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>Wt</th>"
                + "<th style='border:1px solid black;'>Wt_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>HR</th>"
                + "<th style='border:1px solid black;'>RR</th>"
                + "<th style='border:1px solid black;'>HeadCircumference</th>"
                + "<th style='border:1px solid black;'>Head_Unit_of_Measurement</th>"
                + "<th style='border:1px solid black;'>BodyMassIndex</th>"
                + "<th style='border:1px solid black;'>BPSYS1</th>"
                + "<th style='border:1px solid black;'>BPDIAS1</th>"
                + "<th style='border:1px solid black;'>BP1Position</th>"
                + "<th style='border:1px solid black;'>BP1Location</th>"
                + "<th style='border:1px solid black;'>BPSYS2</th>"
                + "<th style='border:1px solid black;'>BPDIAS2</th>"
                + "<th style='border:1px solid black;'>BP2Position</th>"
                + "<th style='border:1px solid black;'>BP2Location</th>"
                + "<th style='border:1px solid black;'>BPSYS3</th>"
                + "<th style='border:1px solid black;'>BPDIAS3</th>"
                + "<th style='border:1px solid black;'>BP3Position</th>"
                + "<th style='border:1px solid black;'>BP3Location</th>"
                + "<th style='border:1px solid black;'>Temperature</th>"
                + "<th style='border:1px solid black;'>Temperature_unit</th>"
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
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 8) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 9) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 10) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 11) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 12) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 13) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 14) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 15) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 16) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 17) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 18) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 19) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 20) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 21) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 22) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 23) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 24) + "</td>"
                    + "<td style='border:1px solid black;'>" + table.getValueAt(row, 25) + "</td>"
                    //                     + "<td style='border:1px solid black;'>" + table.getValueAt(row, 26) + "</td>"
                    + "</tr>";
            VitalSign vitalSign = new VitalSign();
            vitalSign.setEncounterID((int) table.getValueAt(row, 0));
            vitalSign.setPatientID((int) table.getValueAt(row, 1));
            vitalSign.setPETime((String) table.getValueAt(row, 2));
            vitalSign.setHt(Double.parseDouble(String.valueOf(table.getValueAt(row, 3))));
            vitalSign.setHt_Unit_of_Measurement((String) table.getValueAt(row, 4));
            vitalSign.setWt(Double.parseDouble(String.valueOf(table.getValueAt(row, 5))));
            vitalSign.setWt_Unit_of_Measurement((String) table.getValueAt(row, 6));
            vitalSign.setHR(Integer.parseInt(String.valueOf(table.getValueAt(row, 7))));
            vitalSign.setRR(Integer.parseInt(String.valueOf(table.getValueAt(row, 8))));
            vitalSign.setHeadCircumference(Double.parseDouble(String.valueOf(table.getValueAt(row, 9))));
            vitalSign.setHead_Unit_of_Measurement((String) table.getValueAt(row, 10));
            vitalSign.setBodyMassIndex(Double.parseDouble(String.valueOf(table.getValueAt(row, 11))));
            vitalSign.setBPSYS1(Integer.parseInt(String.valueOf(table.getValueAt(row, 12))));
            vitalSign.setBPDIAS1(Integer.parseInt(String.valueOf(table.getValueAt(row, 13))));
            vitalSign.setBP1Position((String) table.getValueAt(row, 14));
            vitalSign.setBP1Location((String) table.getValueAt(row, 15));
            vitalSign.setBPSYS2(Integer.parseInt(String.valueOf(table.getValueAt(row, 16))));
            vitalSign.setBPDIAS2(Integer.parseInt(String.valueOf(table.getValueAt(row, 17))));
            vitalSign.setBP2Position((String) table.getValueAt(row, 18));
            vitalSign.setBP2Location((String) table.getValueAt(row, 19));
            vitalSign.setBPSYS3(Integer.parseInt(String.valueOf(table.getValueAt(row, 20))));
            vitalSign.setBPDIAS3(Integer.parseInt(String.valueOf(table.getValueAt(row, 21))));
            vitalSign.setBP3Position((String) table.getValueAt(row, 22));
            vitalSign.setBP3Location((String) table.getValueAt(row, 23));
            vitalSign.setTemperature(Double.parseDouble(String.valueOf(table.getValueAt(row, 24))));
            vitalSign.setTemperature_unit((String) table.getValueAt(row, 25));

            vitalSign.setDeleted(new Byte("0"));
            vitalsigns.add(vitalSign);
        }

        int n = JOptionPane.showConfirmDialog(null, "<html>"
                + "<span style='font-size:15px;font-family:Comic Sans MS;font-weight:bold;color:#3090C7'>"
                + "Update information below?"
                + "</span><br/><br/>"
                + lineInfo + "</table></html>",
                "Confirm Update", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            if (dao.update(vitalsigns)) {
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
