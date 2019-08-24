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
		JTable table = new JTable(dataModelCond);
		panel.add(new JScrollPane(table));

		JScrollPane scrollPane = new JScrollPane(panel);
		add(scrollPane, BorderLayout.CENTER);

	}
	
	private  TableModel createTableModel() {
		return  new AbstractTableModel() {

			public int getColumnCount() {
				return ProjectC1.titlesCond.length + 1;
			}

			public int getRowCount() {
				return projectC1.N_Floors;
			}

			// the column header
			@Override
			public String getColumnName(int col) {
				if (col > 0)
					return projectC1.titlesCond[col - 1];
				else
					return "-";
			}

			public Object getValueAt(int row, int col) {
				if (col == 0)
					return String.format("Floor %d", row);
				else
					return new Double(projectC1.conduct[row][col - 1]);
			}
		};
	}

	public boolean project_Data(ProjectC1 project) {
			return false;		
	}

	public void setNFloors(int nFloors) {
		// TODO Auto-generated method stub
		
	}

	public void setSectionR() {
		// TODO Auto-generated method stub
		
	}

	public void setSectionC() {
		// TODO Auto-generated method stub
		
	}

}
