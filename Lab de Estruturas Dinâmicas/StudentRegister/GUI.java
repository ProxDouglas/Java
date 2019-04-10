import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.io.*;

public class GUI extends JFrame
{//GUI para sistema
	public static final Dimension FRAME_SIZE = new Dimension(600,425);
	public static final Dimension MIN_FRAME_SIZE = new Dimension(375,300);
	public static final Point FRAME_ORIGIN = new Point(450,250);

	public static final String NEW = "New";
	public static final String OPEN = "Open";
	public static final String SAVE = "Save";
	public static final String SAVE_AS = "Save As...";
	public static final String QUIT = "Quit";
	public static final String ADD_STUDENT = "Add Student";
	public static final String DELETE_STUDENT = "Delete Student";
	public static final String SORT_NAME = "Sort by Name";
	public static final int NO_STUDENT_DATA_MODE = 0;
	public static final int ARRAY_UNSORTED_MODE = 1;
	public static final int ARRAY_SORTED_MODE = 2;

	private JTextArea displayArea;
	private JMenuItem[][] items;
	private int mode;

	public GUI(EventListener listener)
	{
		Container contentPane;
		JMenuBar menuBar;
		JMenu[] menus;
		JScrollPane scrollPane;
		JPanel displayPanel;
		
		setSize(FRAME_SIZE);
		setMinimumSize(MIN_FRAME_SIZE);
		setResizable(false);
        setTitle("PUC Registration System");
		setLocation(FRAME_ORIGIN);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) listener);
		
		contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		String[] menuNames = {"File", "Edit", "Process"};
		String[][] itemNames = {
			{"New", "Open", "Save", "Save As...", "Quit"},
			{"Add Student", "Delete Student"},
			{"Sort by Name"} 
		};
		String[][] commands = {
			{NEW, OPEN, SAVE, SAVE_AS, QUIT},
			{ADD_STUDENT, DELETE_STUDENT},
			{SORT_NAME} 
		};
		
		assert menuNames.length == itemNames.length :
			"menuNames and itemNames do not have matching lengths.";
		assert itemNames.length == commands.length :
			"itemNames and commands do not have matching lengths.";
		for (int i = 0; i < itemNames.length; i++)
			assert itemNames[i].length == commands[i].length :
				"itemNames[" + i + "] and commands[" + i + "] do not have matching lengths.";
			
		menuBar = new JMenuBar();
		menus = new JMenu[menuNames.length];
		items = new JMenuItem[menus.length][];
		for (int i = 0; i < menus.length; i++){
			menus[i] = new JMenu(menuNames[i]);
			items[i] = new JMenuItem[itemNames[i].length];
			for (int j = 0; j < items[i].length; j++){
				items[i][j] = new JMenuItem(itemNames[i][j]);
				menus[i].add(items[i][j]);
				items[i][j].addActionListener((ActionListener) listener);
				items[i][j].setActionCommand(commands[i][j]);
				items[i][j].setVisible(true);
			}
			menus[i].setVisible(true);
			menuBar.add(menus[i]);
		}
		setJMenuBar(menuBar);
		
		displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.LINE_AXIS));
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.setFont(new Font("Courier", Font.PLAIN, 12));
		displayArea.setMinimumSize(new Dimension(400,50));
		scrollPane = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		displayPanel.add(scrollPane);
		
		contentPane.add(displayPanel);
		displayPanel.setVisible(true);
		
		changeMode(NO_STUDENT_DATA_MODE);
		setVisible(true);
	} 

	public int getMode()
	{//retornar o tipo de mode que o usuário setou
		return mode;
	}

	public void changeMode(int newMode)
	{//tipo do modo que o array está setado
		setFocusHere();
		this.mode = newMode;
		if (mode == NO_STUDENT_DATA_MODE) {
			items[0][2].setEnabled(false);
			items[0][3].setEnabled(false);
			items[1][0].setEnabled(false);
			items[1][1].setEnabled(false);
			items[2][0].setEnabled(false);
            displayArea.setText("");
		} else if (mode == ARRAY_UNSORTED_MODE) {
			items[0][2].setEnabled(true);
			items[0][3].setEnabled(true);
			items[1][0].setEnabled(true);
			items[1][1].setEnabled(true);
			items[2][0].setEnabled(true);
			items[2][1].setEnabled(true);
            items[2][2].setEnabled(true);
            items[2][3].setEnabled(true);
		} else if (mode == ARRAY_SORTED_MODE) {
			items[0][2].setEnabled(true);
			items[0][3].setEnabled(true);
			items[1][0].setEnabled(true);
			items[1][1].setEnabled(true);
			items[2][0].setEnabled(true);
			items[2][1].setEnabled(true);
            items[2][2].setEnabled(true);
            items[2][3].setEnabled(true);
		}
	}
    public void changeSortName() 
    {//sort por nome
        items[2][0].setEnabled(true);
        items[2][1].setEnabled(false);
        items[2][2].setEnabled(true);
        items[2][3].setEnabled(true);
    }
	
	public void setFocusHere()
	{
		setEnabled(true);
		toFront();
	} 

	public File selectOpenFile()
	{//abrir arquivo
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Input File");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile(), "");
		return f;
	}

	public File selectSaveFile()
	{//salvar arquivo
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Select Save File");
		chooser.showSaveDialog(null);
		File f = new File(chooser.getSelectedFile(), "");
		return f;
	} 

	public void displayText(String[][] s)
	{//display principal de registro de estudantes
		displayArea.setText("");
		String temp;
		temp = String.format("%18s |%10s |%18s |", "Name", "RA", "Course");
		displayArea.append(temp + "\n");
		temp = ("-------------------|-----------|----------------" +  "---|");
		displayArea.append(temp + "\n");
		for (int i = 0; i < s.length; i++){
			temp = String.format("%18s |%8s |%18s |",
				s[i][0], s[i][1], s[i][2]);
			displayArea.append(temp);
			if (i+1 != s.length)
				displayArea.append("\n");
		}
	}
}