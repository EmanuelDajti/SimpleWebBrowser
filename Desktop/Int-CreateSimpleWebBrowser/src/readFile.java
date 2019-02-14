import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class readFile extends JFrame {

	private JTextField addressBar;
	private JEditorPane display;
	
	public readFile() {
		super("Emanuel's Browser ");
		addressBar = new JTextField("Enter a URL:");
		addressBar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						//Go read a html file and diplay it in the screen
						loadCrap(event.getActionCommand());
					}
				}
				);
		add(addressBar,BorderLayout.NORTH);
		display = new JEditorPane();
		display.setEditable(false);
		//sit on every link wait for you to click a link,grabs the url and 
		//gives it to loadcrap
		display.addHyperlinkListener(
			new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent event) {
				if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
				{
			     loadCrap(event.getURL().toString());		
				}
			}

			
			}
				);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	
    //loadcrap loads the html file
	private void loadCrap(String UserText) {
		try {
			display.setPage(UserText);
			addressBar.setText(UserText);
		}catch(Exception e) {
			System.out.println("Crap");
		}
	}
}
