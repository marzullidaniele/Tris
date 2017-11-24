import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.UIManager;

public class Finestra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel mod;
	private JButton btnEntra;
	private JLabel label;
	private JLabel lblUsername;

	/**
	 * Create the frame.
	 */
	public Finestra(PrintWriter out) {
		setResizable(false);
		setTitle("TRIS");
		WindowListener exitListener = new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(null, "Sei sicuro di voler uscire?", "USCITA", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	out.println("///");
		        	System.exit(0);
		        }
		    }
		};
		addWindowListener(exitListener);
		setBounds(100, 100, 577, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 126, 532, 303);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new EmptyBorder(3, 3, 3, 3));
		table.setBackground(UIManager.getColor("ScrollPane.background"));
		table.setCellSelectionEnabled(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		mod=new DefaultTableModel();
		table.setModel(mod);
		
		JLabel lblSelezionaPartita = new JLabel("SELEZIONA PARTITA");
		lblSelezionaPartita.setForeground(Color.RED);
		lblSelezionaPartita.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		lblSelezionaPartita.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelezionaPartita.setBounds(20, 72, 532, 43);
		contentPane.add(lblSelezionaPartita);
		
		btnEntra = new JButton("ENTRA");
		btnEntra.setBackground(UIManager.getColor("ScrollPane.background"));
		btnEntra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntra.setBounds(191, 456, 185, 43);
		contentPane.add(btnEntra);
		
		label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(132, 11, 81, 43);
		contentPane.add(label);
		
		lblUsername = new JLabel("USERNAME:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(10, 11, 81, 43);
		contentPane.add(lblUsername);
	}
	
	public JButton getBtnEntra() {
		return btnEntra;
	}

	public void setBtnEntra(JButton btnEntra) {
		this.btnEntra = btnEntra;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public DefaultTableModel getMod() {
		return mod;
	}

	public void setMod(DefaultTableModel mod) {
		this.mod = mod;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
