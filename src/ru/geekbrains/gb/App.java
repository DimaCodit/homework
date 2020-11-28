package ru.geekbrains.gb;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class App extends JFrame {

    final String CSV_DELIMITER = ";";
    private JFileChooser fileChooser = new JFileChooser();
    private JTable table;

    public App() {

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "CSV", "csv");
        fileChooser.setFileFilter(filter);

        setSize(800, 400);
        setTitle("CSV reader");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        addTable();

        addFileSelectionButton();

        setVisible(true);
    }

    private void addTable(){

        DataTableResult tableData = parseFile(new File("default.csv"));

        String[][] rowData = tableData.getRows();
        Object[] columnNames = tableData.getHeader();

        table = new JTable(rowData, columnNames);

        add(new JScrollPane(table));

    }

    private void addFileSelectionButton() {
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
        JButton button = new JButton();
        button.setText("Открыть CSV файл");
        panel.add(button, BorderLayout.EAST);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFile();
            }
        });
    }

    private void readFile() {
        int res = fileChooser.showDialog(null, "Открыть файл");
        if (res == JFileChooser.APPROVE_OPTION) {
            File chosenFile = fileChooser.getSelectedFile();
            DataTableResult tableData = parseFile(chosenFile);
            String[][] rowData = tableData.getRows();
            Object[] columnNames = tableData.getHeader();
            table.setModel(new AbstractTableModel() {
                public String getColumnName(int column) { return columnNames[column].toString(); }
                public int getRowCount() { return rowData.length; }
                public int getColumnCount() { return columnNames.length; }
                public Object getValueAt(int row, int col) { return rowData[row][col]; }
                public boolean isCellEditable(int row, int column) { return true; }
                public void setValueAt(String value, int row, int col) {
                    rowData[row][col] = value;
                    fireTableCellUpdated(row, col);
                }
            });
        }
    }

    private DataTableResult parseFile(File parsingFile) {

        HashMap results = new HashMap();
        ArrayList<String[]> records = new ArrayList();
        String[] header = new String[0];
        String[][] rows;

        String filePath = parsingFile.getAbsolutePath();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(CSV_DELIMITER);
                if (values.length != 0) {
                    header = values;
                    break;
                }
            }

            while ((line = br.readLine()) != null) {

                String[] values = line.split(CSV_DELIMITER, header.length);
                if (values.length > 0) {
                    records.add(values);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        rows = new String[records.size()][];

        for (int i = 0; i < records.size(); i++) {
            rows[i] = records.get(i);
        }
        return new DataTableResult(header, rows);
    }

    public class DataTableResult {
        private String[] header;

        public String[] getHeader() {
            return header;
        }

        public String[][] getRows() {
            return rows;
        }

        private String[][] rows;

        public DataTableResult(String[] header, String[][] rows) {
            this.header = header;
            this.rows = rows;
        }
    }
}