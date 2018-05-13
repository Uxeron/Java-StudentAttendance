import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface UI_Interface {
	void initUI();
}


public abstract class UI_Listener extends JFrame implements ActionListener, UI_Interface {
	public void actionPerformed(ActionEvent event){
		// todo: add code
	}
}
