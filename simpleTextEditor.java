import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;


public class simpleTextEditor extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar Mbar = new JMenuBar();
	private JMenu fileMenu, editMenu, cutsMenu;
	private JMenuItem cutItem, copyItem, pasteItem, selectItem, recentcutItem;
	private JMenuItem quitItem, openItem, saveItem;
	private JTextArea display = new JTextArea();
	private String scratchPad ="";
	private Vector<String> recentCuts = new Vector<String>();
	
	public  simpleTextEditor() {
	super("Paul's NotePad");
	this.getContentPane().setLayout(new BorderLayout());
	this.getContentPane().add("Center", display);
	this.getContentPane().add(new JScrollPane(display));
	display.setLineWrap(true);
	this.setJMenuBar(Mbar);
	initFileMenu();
	initEditMenu();
	}

	private void initEditMenu() {
		// TODO Auto-generated method stub
		editMenu = new JMenu("Edit");
		Mbar.add(editMenu);
		
		cutItem = new JMenuItem("Cut");
		cutItem.addActionListener(this);
		editMenu.add(cutItem);
		
		copyItem = new JMenuItem("Copy");
		copyItem.addActionListener(this);
		editMenu.add(copyItem);
		
		pasteItem = new JMenuItem("Paste");
		pasteItem.addActionListener(this);
		editMenu.add(pasteItem);
		editMenu.addSeparator();
		
		selectItem = new JMenuItem("Select");
		selectItem.addActionListener(this);
		editMenu.add(selectItem);
		editMenu.addSeparator();
		
		recentcutItem = new JMenuItem("Recent");
		recentcutItem.addActionListener(this);
		editMenu.add(recentcutItem);
		}
	

	private void initFileMenu() {
		// TODO Auto-generated method stub
		fileMenu = new JMenu("File");
		Mbar.add(fileMenu);
		
		openItem = new JMenuItem("Open");
		openItem.addActionListener(this);
		openItem.setEnabled(true);
		fileMenu.add(openItem);
		
		saveItem = new JMenuItem("Save");
		saveItem.addActionListener(this);
		saveItem.setEnabled(true);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		
		quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(this);
		quitItem.setEnabled(true);
		fileMenu.add(quitItem);
		}
	
	public void actionPerformed(ActionEvent e) {
		JMenuItem m = (JMenuItem)e.getSource();
		if(m ==quitItem) {
			dispose();
		}
		else if(m == cutItem) {
			scratchPad = display.getSelectedText();
			display.replaceRange("",
					display.getSelectionStart(), display.getSelectionEnd());
			addRecentCut(scratchPad);
		}
		else if(m == copyItem) {
			scratchPad = display.getSelectedText();
		}
		else if(m == pasteItem) {
			display.insert(scratchPad, display.getCaretPosition());
		}
		else if(m == selectItem) {
			display.selectAll();
		}
		else {
			JMenuItem item = (JMenuItem)e.getSource();
			scratchPad =item.getActionCommand();
		}
	}

	private void addRecentCut(String cut) {
		// TODO Auto-generated method stub
		recentCuts.insertElementAt(cut, 0);
		cutsMenu.removeAll();
		for(int k = 0; k < recentCuts.size(); k++) {
			JMenuItem item = new JMenuItem((String)recentCuts.elementAt(k));
			cutsMenu.add(item);
			item.addActionListener(this);
		}
	}
	public static void main(String[] args) {
		simpleTextEditor f= new simpleTextEditor(); 
			f.setSize(300,200);
			f.setResizable(true);
			f.setVisible(true);
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		 
	}
	

}
