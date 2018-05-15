import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends UI_Listener {
	private JLabel statusBar;
	private JTabbedPane tabbedPane1;
	private JComboBox combo_0_GrupesNr;
	private JTextField text_0_GrupesNr;
	private JButton button_0_SukurtiNauja;
	private JButton button_0_Pervadinti;
	private JButton button_0_Istrinti;
	private JLabel label_0_Grupe;
	private JButton button_0_pridėtiNaują;
	private JButton button_0_pašalinti;
	private JButton button_0_pakeistiVardą;
	private JComboBox combo_gupePerkelti;
	private JButton button_0_perkelti;
	private JLabel label_0_studentas;
	private JComboBox combo_1_Grupe;
	private JTable table_1;
	private DefaultTableModel table_1_model;
	private JCheckBox check_2_Iki;
	private JCheckBox check_2_VisosGr;
	private JButton button_2_PDF;
	private JComboBox combo_2_Grupe;
	private JTable table_0;
	private DefaultTableModel table_0_model;
	private JDatePicker date_1;
	private JLabel label_1_Data;
	private JLabel label_1_Grupe;
	private JDatePicker date_2_Data;
	private JLabel label_2_Data;
	private JTable table_2;
	private DefaultTableModel table_2_model;
	private JDatePicker date_2_Iki;
	private JLabel label_2_Grupe;
	private DefaultComboBoxModel comboBoxModel;
	private DefaultComboBoxModel comboBoxModel2;
	private int prevTabIndex = 0;
	private Database database;
	private boolean tablePopulated = false;


	public UI() {
		initUI();
	}

	public void initUI() {
		database = new Database();

		// Set layout for main window
		setLayout(new BorderLayout(0, 0));
		CellConstraints cc = new CellConstraints();

		statusBar = new JLabel("Status bar");
		add(statusBar, BorderLayout.SOUTH);
		setUndecorated(true);

		// Create model for combo boxes
		comboBoxModel = new DefaultComboBoxModel();
		comboBoxModel2 = new DefaultComboBoxModel();


		// ----- Create base objects -----
		// Create the tabbed panel
		tabbedPane1 = new JTabbedPane();
		add(tabbedPane1, BorderLayout.CENTER);
		tabbedPane1.addChangeListener(this);

		// Add the tabs
		final JPanel pane0 = new JPanel();
		pane0.setLayout(new FormLayout("fill:60px:noGrow,left:4dlu:noGrow,fill:max(d;4px):grow,left:4dlu:noGrow,fill:max(d;4px):grow,left:4dlu:noGrow,fill:d:noGrow,left:4dlu:noGrow,fill:m:noGrow,left:4dlu:noGrow,fill:m:noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:noGrow,top:4dlu:noGrow,top:4dlu:noGrow,center:16px:noGrow,center:max(d;4px):noGrow,center:max(d;4px):noGrow,center:34px:noGrow,center:max(d;4px):noGrow,center:max(d;4px):noGrow,top:5dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:200px:noGrow"));
		tabbedPane1.addTab("Grupės", pane0);

		final JPanel pane1 = new JPanel();
		pane1.setLayout(new FormLayout("fill:60px:noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:60px:noGrow,left:4dlu:noGrow,fill:max(d;4px):grow", "center:d:noGrow,top:4dlu:noGrow,center:400px:noGrow"));
		tabbedPane1.addTab("Lankomumo suvedimas", pane1);

		final JPanel pane2 = new JPanel();
		pane2.setLayout(new FormLayout("fill:60px:noGrow,left:4dlu:noGrow,fill:p:grow,left:4dlu:noGrow,fill:p:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow,fill:60px:noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:365px:noGrow"));
		tabbedPane1.addTab("Lankomumo peržiūra", pane2);

		final JPanel paneBlank = new JPanel();
		paneBlank.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabbedPane1.addTab("                                         ", paneBlank);
		final JPanel paneMinimize = new JPanel();
		paneMinimize.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabbedPane1.addTab("_", paneMinimize);
		final JPanel paneExit = new JPanel();
		paneExit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		tabbedPane1.addTab("X", paneExit);

		FrameDragListener frameDragListener = new FrameDragListener(this);
		//addMouseListener(frameDragListener);
		//addMouseMotionListener(frameDragListener);

		tabbedPane1.addMouseListener(frameDragListener);
		tabbedPane1.addMouseMotionListener(frameDragListener);

		tabbedPane1.setEnabledAt(3, false);

		// ----- Add elements to the 1st tab -----
		// Group selection combo box
		combo_0_GrupesNr = new JComboBox(comboBoxModel);
		combo_0_GrupesNr.addActionListener(this);
		pane0.add(combo_0_GrupesNr, cc.xy(3, 1));

		// Group name entry field
		text_0_GrupesNr = new JTextField("1");
		pane0.add(text_0_GrupesNr, cc.xy(5, 1));

		// "Add new" button
		button_0_SukurtiNauja = new JButton("Sukurti naują");
		button_0_SukurtiNauja.addActionListener(this);
		pane0.add(button_0_SukurtiNauja, cc.xy(7, 1));

		// "Rename" button
		button_0_Pervadinti = new JButton("Pervadinti");
		button_0_Pervadinti.addActionListener(this);
		pane0.add(button_0_Pervadinti, cc.xy(9, 1));

		// "Remove" button
		button_0_Istrinti = new JButton("Ištrinti");
		button_0_Istrinti.addActionListener(this);
		pane0.add(button_0_Istrinti, cc.xy(11, 1));

		// "Grupė" label
		label_0_Grupe = new JLabel("Grupė");
		label_0_Grupe.setHorizontalAlignment(4);
		pane0.add(label_0_Grupe, cc.xy(1, 1));

		button_0_pridėtiNaują = new JButton("Pridėti naują");
		button_0_pridėtiNaują.addActionListener(this);
		pane0.add(button_0_pridėtiNaują, cc.xyw(9, 15, 3));

		button_0_perkelti = new JButton("Perkelti");
		button_0_perkelti.addActionListener(this);
		pane0.add(button_0_perkelti, cc.xyw(9, 10, 3));

		button_0_pašalinti = new JButton("Pašalinti");
		button_0_pašalinti.addActionListener(this);
		pane0.add(button_0_pašalinti, cc.xyw(9, 9, 3));

		button_0_pakeistiVardą = new JButton("Pakeisti vardą");
		button_0_pakeistiVardą.addActionListener(this);
		pane0.add(button_0_pakeistiVardą, cc.xyw(9, 8, 3));

		label_0_studentas = new JLabel("Studentas:");
		label_0_studentas.setHorizontalAlignment(0);
		pane0.add(label_0_studentas, cc.xyw(9, 6, 3));

		combo_gupePerkelti = new JComboBox(comboBoxModel2);
		pane0.add(combo_gupePerkelti, cc.xyw(9, 13, 3));

		// Student table
		table_0_model = new DefaultTableModel();
		table_0_model.addColumn("Studentas");
		table_0_model.addRow(new String[] {"man"});
		table_0_model.addRow(new String[] {"men"});
		table_0_model.addRow(new String[] {"mon"});
		table_0 = new JTable(table_0_model);
		table_0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_0.setDefaultEditor(Object.class, null);
		final JScrollPane scrollPane1 = new JScrollPane(table_0);
		pane0.add(scrollPane1, cc.xywh(1, 3, 7, 15, CellConstraints.FILL, CellConstraints.FILL));


		// ----- Add elements to the 2nd tab -----
		// Date picker
		date_1 = new JDatePicker();
		date_1.addActionListener(this);
		pane1.add(date_1, cc.xy(3, 1));

		label_1_Data = new JLabel("Data");
		label_1_Data.setHorizontalAlignment(4);
		pane1.add(label_1_Data, cc.xy(1, 1));

		label_1_Grupe = new JLabel("Grupė");
		label_1_Grupe.setHorizontalAlignment(4);
		pane1.add(label_1_Grupe, cc.xy(5, 1));

		combo_1_Grupe = new JComboBox(comboBoxModel);
		pane1.add(combo_1_Grupe, cc.xy(7, 1));


		table_1_model = new DefaultTableModel();
		table_1 = new JTable(table_1_model);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setDefaultEditor(Object.class, null);
		final JScrollPane scrollPane2 = new JScrollPane(table_1);
		pane1.add(scrollPane2, cc.xyw(1, 3, 7, CellConstraints.FILL, CellConstraints.FILL));

		// ----- Add elements to the 3rd tab -----

		date_2_Data = new JDatePicker();
		date_2_Data.addActionListener(this);
		pane2.add(date_2_Data, cc.xy(3, 1));

		label_2_Data = new JLabel("Data");
		label_2_Data.setHorizontalAlignment(4);
		pane2.add(label_2_Data, cc.xy(1, 1));


		table_2_model = new DefaultTableModel();
		table_2 = new JTable(table_2_model);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setDefaultEditor(Object.class, null);
		final JScrollPane scrollPane3 = new JScrollPane(table_2);
		pane2.add(scrollPane3, cc.xyw(1, 5, 8, CellConstraints.FILL, CellConstraints.FILL));

		date_2_Iki = new JDatePicker();
		date_2_Iki.addActionListener(this);
		pane2.add(date_2_Iki, cc.xy(3, 3));
		date_2_Iki.setEnabled(false);

		check_2_Iki = new JCheckBox("Iki");
		check_2_Iki.setHorizontalAlignment(4);
		check_2_Iki.addActionListener(this);
		pane2.add(check_2_Iki, cc.xy(1, 3));

		check_2_VisosGr = new JCheckBox("Visos");
		check_2_VisosGr.addActionListener(this);
		pane2.add(check_2_VisosGr, cc.xy(8, 1));

		button_2_PDF = new JButton("PDF");
		button_2_PDF.addActionListener(this);
		pane2.add(button_2_PDF, cc.xy(8, 3));

		label_2_Grupe = new JLabel("Grupė");
		label_2_Grupe.setHorizontalAlignment(4);
		pane2.add(label_2_Grupe, cc.xy(5, 1));

		combo_2_Grupe = new JComboBox(comboBoxModel);
		pane2.add(combo_2_Grupe, cc.xy(5, 3));

		// Finish setting up and display the UI
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(570, 470);
		setVisible(true);
	}

	// Toggle elements based on checkboxes
	public void toggleEnabled(String elementName) {
		Map<String, JComponent> element = new HashMap<String, JComponent>();
		element.put("Iki", date_2_Iki);
		element.put("Visos", combo_2_Grupe);
		element.get(elementName).setEnabled(!element.get(elementName).isEnabled());
	}

	// Handle button pressed events
	public void buttonPress(String buttonName) {
		DefaultTableModel model = (DefaultTableModel) table_0.getModel();
		if (buttonName == "Sukurti naują") {
			if (text_0_GrupesNr.getText().length() > 0) {
				if (!Arrays.asList(database.getGroups()).contains(text_0_GrupesNr.getText())) {
					database.addGroup(text_0_GrupesNr.getText());
					comboBoxModel.addElement(text_0_GrupesNr.getText());
					comboBoxModel2.addElement(text_0_GrupesNr.getText());
					statusBar.setText("Sukurta nauja grupė " + text_0_GrupesNr.getText());
					text_0_GrupesNr.setText("");
				}
			}
		} else if (buttonName == "Pervadinti") {
			if (text_0_GrupesNr.getText().length() > 0) {
				if (database.getGroups().length > 0) {
					if (!Arrays.asList(database.getGroups()).contains(text_0_GrupesNr.getText()) && database.getGroups().length > 0) {
						database.renameGroup(comboBoxModel.getSelectedItem().toString(), text_0_GrupesNr.getText());
						comboBoxModel.removeElement(comboBoxModel.getSelectedItem());
						comboBoxModel.addElement(text_0_GrupesNr.getText());
						comboBoxModel2.removeElement(comboBoxModel.getSelectedItem());
						comboBoxModel2.addElement(text_0_GrupesNr.getText());
						statusBar.setText("Grupė pervadinta");
						text_0_GrupesNr.setText("");
					}
				}
			}
		} else if (buttonName == "Ištrinti") {
			if (database.getGroups().length > 0) {
				if (JOptionPane.showConfirmDialog(null, "Ar tikrai ištrinti grupę?", "Patvirtinimas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					database.removeGroup(comboBoxModel.getSelectedItem().toString());
					comboBoxModel.removeElement(comboBoxModel.getSelectedItem());
					comboBoxModel2.removeElement(comboBoxModel.getSelectedItem());
					statusBar.setText("Grupė ištrinta");
				}
			} else {
				statusBar.setText("Nepasirinkta grupė");
			}
		} else if (buttonName == "Pridėti naują") {
			if (database.getGroups().length > 0) {
				String newName = JOptionPane.showInputDialog("Įvesti studento vardą ir pavardę:");
				if (newName.length() > 0) {
					if (!Arrays.asList(database.getStudentNames(comboBoxModel.getSelectedItem().toString())).contains(newName)) {
						database.addStudent(comboBoxModel.getSelectedItem().toString(), newName);
						model.addRow(new String[]{newName});
						statusBar.setText("Studentas sukurtas");
					} else {
						statusBar.setText("Toks studentas jau yra sistemoje");
					}
				} else {
					statusBar.setText("Neįvestas vardas");
				}
			} else {
				statusBar.setText("Nepasirinkta grupė");
			}
		} else if (buttonName == "Pakeisti vardą") {
			if(table_0.getSelectedRow() != -1) {
				String newName = JOptionPane.showInputDialog("Įvesti studento vardą ir pavardę:");
				if (newName.length() > 0) {
					if (!Arrays.asList(database.getStudentNames(comboBoxModel.getSelectedItem().toString())).contains(newName)) {
						database.renameStudent(comboBoxModel.getSelectedItem().toString(), model.getValueAt(table_0.getSelectedRow(), table_0.getSelectedColumn()).toString(), newName);
						model.setValueAt(newName, table_0.getSelectedRow(), table_0.getSelectedColumn());
						statusBar.setText("Studento vardas pakeistas");
					} else {
						statusBar.setText("Toks studentas jau yra sistemoje");
					}
				} else {
					statusBar.setText("Neįvestas vardas");
				}
			} else {
				statusBar.setText("Nepasirinkta grupė");
			}
		} else if (buttonName == "Pašalinti") {
			if(table_0.getSelectedRow() != -1) {
				if (JOptionPane.showConfirmDialog(null, "Ar tikrai pašalinti studentą?", "Patvirtinimas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					database.removeStudent(comboBoxModel.getSelectedItem().toString(), model.getValueAt(table_0.getSelectedRow(), table_0.getSelectedColumn()).toString());
					model.removeRow(table_0.getSelectedRow());
					statusBar.setText("Studentas pašalintas");
				}
			}
		} else if (buttonName == "Perkelti") {
			if(table_0.getSelectedRow() != -1) {
				if(database.getGroups().length > 1) {
					if(comboBoxModel.getSelectedItem().toString() != comboBoxModel2.getSelectedItem().toString()) {
						database.moveStudent(model.getValueAt(table_0.getSelectedRow(), table_0.getSelectedColumn()).toString(), comboBoxModel.getSelectedItem().toString(), comboBoxModel2.getSelectedItem().toString());
						model.removeRow(table_0.getSelectedRow());
					}
				}
			}
		}




		else if (buttonName == "PDF") {
			if (tablePopulated) {
				generatePDF();
			} else {
				statusBar.setText("Pirma pasirinkite duomenis");
			}
		}

		updateTables();
	}
	public void updateTables() {}

	// Functionality for close and minimize tabs
	public void stateChanged(ChangeEvent e) {
		if (tabbedPane1.getSelectedIndex() == 4) {
			tabbedPane1.setSelectedIndex(prevTabIndex);
			setState(Frame.ICONIFIED);
		} else if (tabbedPane1.getSelectedIndex() == 5) {
			dispose();
		} else {
			prevTabIndex = tabbedPane1.getSelectedIndex();
		}
	}

	private void generatePDF() {}
}