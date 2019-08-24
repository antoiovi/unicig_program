package com.unicig.project.typec1;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.unicig.project.IPanel;

public class APInputData extends JPanel implements IPanel{
	private JTable table;
	private JTable table_1;
	private ProjectC1 projectC1;
	TableModel dataModelCond;
	/**
	 * Create the panel.
	 */
	public APInputData(ProjectC1 _projectC1) {
		this.projectC1 = _projectC1;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));

		dataModelCond =this.createTableModel();
		 table = new JTable(dataModelCond);
		panel.add(new JScrollPane(table));

		JScrollPane scrollPane = new JScrollPane(panel);
		add(scrollPane, BorderLayout.CENTER);

	}
	
	private  TableModel createTableModel() {
		return  new AbstractTableModel() {
			String[] headers=projectC1.getInputHeader();
			double[][] data=projectC1.getInputData();
			public int getColumnCount() {
				return projectC1.getInputHeader().length+1;
			}
			public int getRowCount() {
				return projectC1.N_Floors;
			}
			// the column header
			@Override
			public String getColumnName(int col) {
				if (col > 0)
					return headers[col - 1];
				else
					return "-";
			}

			public Object getValueAt(int row, int col) {
				if (col == 0)
					return String.format("Floor %d", row);
				else
					return new Double(data[row][col -1]);
			}
		};
	}

	public boolean project_Data(ProjectC1 project) {
			return false;		
	}

	public void setNFloors(int nFloors) {
		table.setModel(createTableModel());
	}

	public void setSectionR() {
		table.setModel(createTableModel());
		
	}

	public void setSectionC() {
		table.setModel(createTableModel());
		
	}

}
