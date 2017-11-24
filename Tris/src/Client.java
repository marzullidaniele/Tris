
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Client {
	String nomeServer = "localhost";
	int portaServer = 6789;
	Socket socket;
	PrintWriter out;
	String messaggio;
	BufferedReader in;
	String s = "";
	ArrayList<String> v = new ArrayList<String>();
	Finestra f;
	Campo gioco;
	ArrayList<Integer> giocate;
	String avversario ="";

	private class ClientThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			String messaggio;
			f.getBtnEntra().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = f.getTable().getSelectedRow();
					out.println("/");
					avversario = (String) f.getTable().getValueAt(row, 0);
					out.println(avversario);
				}
			});
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					messaggio = in.readLine();
					int c = 0;
					boolean flag = false;
					if (messaggio.equals("confirm")) {
						f.setVisible(false);
						gioco = new Campo(s);
						gioco.setVisible(true);
						giocate = new ArrayList<Integer>();
						while (true) {
							boolean giocato = false;
							while (giocato == false) {
								while(messaggio.equals("1") == false && messaggio.equals("2") == false && messaggio.equals("3") == false && messaggio.equals("4") == false && messaggio.equals("5") == false && messaggio.equals("6") == false && messaggio.equals("7") == false && messaggio.equals("8") == false && messaggio.equals("9") == false) {
									messaggio = in.readLine();
								}
								int avv = Integer.parseInt(messaggio);
								giocato = true;
								switch (avv) {
								case 1:
									gioco.getLabel_1()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(1);
									break;
								case 2:
									gioco.getLabel_2()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(2);
									break;
								case 3:
									gioco.getLabel_3()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(3);
									break;
								case 4:
									gioco.getLabel_4()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(4);
									break;
								case 5:
									gioco.getLabel_5()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(5);
									break;
								case 6:
									gioco.getLabel_6()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(6);
									break;
								case 7:
									gioco.getLabel_7()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(7);
									break;
								case 8:
									gioco.getLabel_8()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(8);
									break;
								case 9:
									gioco.getLabel_9()
											.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
									giocate.add(9);
									break;
								}
							}
							while (giocato == true) {
								//System.out.println(gioco.getCampo());
								boolean occupato = false;
								for (int i = 0; i < giocate.size(); i++) {
									if (giocate.get(i) == gioco.getCampo()) {
										occupato = true;
									}
								}
								if (occupato == false && gioco.getCampo()!=0) {
									giocato = false;
									switch (gioco.getCampo()) {
									case 1:
										gioco.getLabel_1().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(1);
										break;
									case 2:
										gioco.getLabel_2().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(2);
										break;
									case 3:
										gioco.getLabel_3().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(3);
										break;
									case 4:
										gioco.getLabel_4().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(4);
										break;
									case 5:
										gioco.getLabel_5().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(5);
										break;
									case 6:
										gioco.getLabel_6().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(6);
										break;
									case 7:
										gioco.getLabel_7().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(7);
										break;
									case 8:
										gioco.getLabel_8().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(8);
										break;
									case 9:
										gioco.getLabel_9().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(9);
										break;
									}
									out.println("////");
									out.println(avversario);
									out.println(gioco.getCampo()); 
									Collections.sort(giocate);
								}
							}
						}
					}
					if (messaggio.equals("//")) {
						messaggio = in.readLine();
						int partita = JOptionPane.showConfirmDialog(null, messaggio + " vuole giocare con te, accetti?",
								"RICHIESTA DI GIOCO", 0);
						if (partita == 0) {
							avversario=messaggio;
							out.println("//");
							out.println("accept");
							f.setVisible(false);
							gioco = new Campo(s);
							gioco.setVisible(true);
							giocate = new ArrayList<Integer>();
							while (true) {
								boolean giocato = false;
								while (giocato == false) {
									System.out.println(gioco.getCampo());
									boolean occupato = false;
									for (int i = 0; i < giocate.size(); i++) {
										if (giocate.get(i) == gioco.getCampo()) {
											occupato = true;
										}
									}
									if (occupato == false && gioco.getCampo()!=0) {
										giocato = true;
										switch (gioco.getCampo()) {
										case 1:
											gioco.getLabel_1().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(1);
											break;
										case 2:
											gioco.getLabel_2().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(2);
											break;
										case 3:
											gioco.getLabel_3().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(3);
											break;
										case 4:
											gioco.getLabel_4().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(4);
											break;
										case 5:
											gioco.getLabel_5().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(5);
											break;
										case 6:
											gioco.getLabel_6().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(6);
											break;
										case 7:
											gioco.getLabel_7().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(7);
											break;
										case 8:
											gioco.getLabel_8().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(8);
											break;
										case 9:
											gioco.getLabel_9().setIcon(
													new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
											giocate.add(9);
											break;
										}
										out.println("////");
										out.println(avversario);
										out.println(gioco.getCampo()); 
										Collections.sort(giocate);
									}
								}
								if (giocato == true) {
									while(messaggio.equals("1") == false && messaggio.equals("2") == false && messaggio.equals("3") == false && messaggio.equals("4") == false && messaggio.equals("5") == false && messaggio.equals("6") == false && messaggio.equals("7") == false && messaggio.equals("8") == false && messaggio.equals("9") == false) {
										messaggio = in.readLine();
										System.out.println(messaggio);
									}
									int avv = Integer.parseInt(messaggio);
									giocato = false;
									switch (avv) {
									case 1:
										gioco.getLabel_1()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(1);
										break;
									case 2:
										gioco.getLabel_2()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(2);
										break;
									case 3:
										gioco.getLabel_3()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(3);
										break;
									case 4:
										gioco.getLabel_4()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(4);
										break;
									case 5:
										gioco.getLabel_5()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(5);
										break;
									case 6:
										gioco.getLabel_6()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(6);
										break;
									case 7:
										gioco.getLabel_7()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(7);
										break;
									case 8:
										gioco.getLabel_8()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(8);
										break;
									case 9:
										gioco.getLabel_9()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										giocate.add(9);
										break;
									}
								}
							}
						} else {
							out.println("//");
							out.println("decline");
						}
						flag = true;
					}
					while (c < v.size() && flag == false) {
						if (messaggio.equals(v.get(c).toString())) {
							flag = true;
						}
						c++;
					}
					if (flag == false) {
						v.add(messaggio);
					}
					DefaultTableModel mod = new DefaultTableModel();
					mod.addColumn("USERNAME");
					for (int i = 0; i < v.size(); i++) {
						mod.addRow(new String[] { v.get(i).toString() });
					}
					f.getTable().setModel(mod);
				}
			} catch (

			IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Socket connetti() {
		try {
			socket = new Socket(nomeServer, portaServer);
			out = new PrintWriter(socket.getOutputStream(), true);
			f = new Finestra(out);

			// Attivo un socket per la ricezione
			ClientThread ct = new ClientThread();
			ct.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return socket;
	}

	public void nome() {
		while (s.equals("")) {
			s = JOptionPane.showInputDialog(null, "INSERISCI IL TUO USERNAME", "LOGIN", 1);
		}
		out.println(s);
		f.getLabel().setText(s);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Client cliente = new Client();
		cliente.connetti();
		cliente.nome();
	}
}
