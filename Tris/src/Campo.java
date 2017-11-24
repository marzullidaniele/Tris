import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Campo extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	int campo = 0;

	/**
	 * Create the frame.
	 */
	public Campo(String nome) {
		setResizable(false);
		setTitle(nome);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 262);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label_1 = new JLabel("");
		label_1.setBounds(70, 20, 50, 50);
		contentPane.add(label_1);
		label_1.addMouseListener(this);

		label_2 = new JLabel("");
		label_2.setBounds(135, 20, 50, 50);
		contentPane.add(label_2);
		label_2.addMouseListener(this);

		label_3 = new JLabel("");
		label_3.setBounds(200, 20, 50, 50);
		contentPane.add(label_3);
		label_3.addMouseListener(this);

		label_4 = new JLabel("");
		label_4.setBounds(65, 88, 50, 50);
		contentPane.add(label_4);
		label_4.addMouseListener(this);

		label_5 = new JLabel("");
		label_5.setBounds(135, 88, 50, 50);
		contentPane.add(label_5);
		label_5.addMouseListener(this);

		label_6 = new JLabel("");
		label_6.setBounds(200, 88, 50, 50);
		contentPane.add(label_6);
		label_6.addMouseListener(this);

		label_7 = new JLabel("");
		label_7.setBounds(65, 154, 50, 50);
		contentPane.add(label_7);
		label_7.addMouseListener(this);

		label_8 = new JLabel("");
		label_8.setBounds(135, 155, 50, 50);
		contentPane.add(label_8);
		label_8.addMouseListener(this);

		label_9 = new JLabel("");
		label_9.setBounds(200, 155, 50, 50);
		contentPane.add(label_9);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/Immagine.png")));
		label.setBounds(60, 11, 200, 202);
		contentPane.add(label);
		label_9.addMouseListener(this);

	}
	
	public void inserisci(int x,PrintWriter out) {
		out.println(x);
	}

	public int getCampo() {
		return campo;
	}

	public void setCampo(int campo) {
		this.campo = campo;
	}
	
	public JLabel getLabelTot(int i) {
		switch(i) {
		case 1:
			return label_1;
		case 2:
			return label_2;
		case 3:
			return label_3;
		case 4:
			return label_4;
		case 5:
			return label_5;
		case 6:
			return label_6;
		case 7:
			return label_7;
		case 8:
			return label_8;
		case 9:
			return label_9;
		}
		return null;
	}
	
	public JLabel getLabel_1() {
		return label_1;
	}

	public JLabel getLabel_2() {
		return label_2;
	}

	public JLabel getLabel_3() {
		return label_3;
	}

	public JLabel getLabel_4() {
		return label_4;
	}

	public JLabel getLabel_5() {
		return label_5;
	}

	public JLabel getLabel_6() {
		return label_6;
	}

	public JLabel getLabel_7() {
		return label_7;
	}

	public JLabel getLabel_8() {
		return label_8;
	}

	public JLabel getLabel_9() {
		return label_9;
	}

	public void setLabel_1(JLabel label_1) {
		this.label_1 = label_1;
	}

	public void setLabel_2(JLabel label_2) {
		this.label_2 = label_2;
	}

	public void setLabel_3(JLabel label_3) {
		this.label_3 = label_3;
	}

	public void setLabel_4(JLabel label_4) {
		this.label_4 = label_4;
	}

	public void setLabel_5(JLabel label_5) {
		this.label_5 = label_5;
	}

	public void setLabel_6(JLabel label_6) {
		this.label_6 = label_6;
	}

	public void setLabel_7(JLabel label_7) {
		this.label_7 = label_7;
	}

	public void setLabel_8(JLabel label_8) {
		this.label_8 = label_8;
	}

	public void setLabel_9(JLabel label_9) {
		this.label_9 = label_9;
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == label_1) {
			campo = 1;
		}
		if (e.getSource() == label_2) {
			campo = 2;
		}
		if (e.getSource() == label_3) {
			campo = 3;
		}
		if (e.getSource() == label_4) {
			campo = 4;
		}
		if (e.getSource() == label_5) {
			campo = 5;
		}
		if (e.getSource() == label_6) {
			campo = 6;
		}
		if (e.getSource() == label_7) {
			campo = 7;
		}
		if (e.getSource() == label_8) {
			campo = 8;
		}
		if (e.getSource() == label_9) {
			campo = 9;
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
