import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

interface UI_Interface {
	void initUI();
}


public abstract class UI_Listener extends JFrame implements ActionListener, UI_Interface, ChangeListener {
	// Custom functions
	public abstract void toggleEnabled(String elementName);
	public abstract void buttonPress(String buttonName);
	public abstract void updateTables();
	public abstract void stateChanged(ChangeEvent e);


	public void actionPerformed(ActionEvent event){
		String ev = event.getActionCommand();
		String[] buttons = {"Pridėti naują", "Pervadinti", "Ištrinti", "Sukurti naują", "Pakeisti vardą", "Perkelti", "Pašalinti", "PDF"};
		String[] checkboxes = {"Iki", "Visos"};
		if (Arrays.asList(buttons).contains(ev))
			buttonPress(ev);
		else if (ev == "Date selected" || ev == "comboBoxChanged")
			updateTables();
		else if (ev == "Iki" || ev == "Visos")
			toggleEnabled(ev);
		else
			System.out.println("Unidentified event received");

		System.out.println(event.getActionCommand());
	}
}
