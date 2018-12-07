package GUI;

import java.awt.Component;

import javax.swing.AbstractCellEditor;

import javax.swing.JButton;

import javax.swing.JCheckBox;

import javax.swing.JDialog;

import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableCellEditor;

import javax.swing.table.TableCellRenderer;
import javax.swing.JSpinner;

public class Test22 extends JDialog {

	public static void main(String[] args) {

		new Test22();

	}

	private JFrame jf;

	private DefaultTableModel dtm;

	private JTable jtable;

	private JScrollPane jsp;

	public Test22() {

		jf = new JFrame("테이블에 버튼 추가 이벤트");

		jf.setLocationRelativeTo(null);

		jf.setSize(500, 300);

		dtm = new DefaultTableModel(new Object[][] { 
				{ "데이터1", "데이터2", "데이터3" },
				{ "데이터4", "데이터5", "데이터6" },
				{ "데이터7", "데이터8", "데이터9" } }, new Object[] { "필드1", "필드2", "필드3" });

		jtable = new JTable(dtm);
		jsp = new JScrollPane(jtable);
		jsp.setBounds(0, 0, 484, 88);

		jtable.getColumnModel().getColumn(0).setCellRenderer(new TableCell());
		jtable.getColumnModel().getColumn(0).setCellEditor(new TableCell());
		jf.getContentPane().setLayout(null);
		
		jf.getContentPane().add(jsp);
		jf.setVisible(true);

	}

	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {

		JButton jb;

		public TableCell() {

			jb = new JButton("버튼");

		}

		@Override

		public Object getCellEditorValue() {
			return null;
		}

		@Override

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return jb;

		}

		@Override

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			return jb;

		}

	}

}
