import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

interface UI_Interface {
	void initUI();
}


public abstract class UI_Listener extends JFrame implements ActionListener, UI_Interface, ChangeListener {
	public abstract void changeDate();
	public abstract void toggleEnabled(String elementName);
	public abstract void buttonPress(String buttonName);
	public abstract void stateChanged(ChangeEvent e);

	public void actionPerformed(ActionEvent event){
		String ev = event.getActionCommand();
		String[] buttons = {"Pridėti naują", "Pervadinti", "Ištrinti", "PDF"};
		String[] checkboxes = {"Iki", "Visos"};
		if (Arrays.asList(buttons).contains(ev))
			buttonPress(ev);
		else if (ev == "Date selected")
			changeDate();
		else if (Arrays.asList(checkboxes).contains(ev))
			toggleEnabled(ev);
		else
			System.out.println("Unidentified even received");

		System.out.println(event.getActionCommand());
	}
}
