
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
	ArrayList<Integer> giocateAvv;
	String avversario = "";

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
					if (messaggio.equals("/")) {
						messaggio = in.readLine();
						if (messaggio.equals("confirm")) {
							f.setVisible(false);
							gioco = new Campo(s);
							gioco.setVisible(true);
							gioco.getLabel_11().setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
							giocate = new ArrayList<Integer>();
							giocateAvv = new ArrayList<Integer>();
							while (true) {
								boolean giocato = false;
								while (giocato == false) {
									gioco.getLabel_10().setText("E' IL TURNO DEL TUO AVVERSARIO");
									messaggio = in.readLine();
									int avv = Integer.parseInt(messaggio);
									giocato = true;
									switch (avv) {
									case 1:
										gioco.getLabel_1().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 2:
										gioco.getLabel_2().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 3:
										gioco.getLabel_3().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 4:
										gioco.getLabel_4().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 5:
										gioco.getLabel_5().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 6:
										gioco.getLabel_6().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 7:
										gioco.getLabel_7().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 8:
										gioco.getLabel_8().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									case 9:
										gioco.getLabel_9().setIcon(
												new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
										break;
									}
									giocateAvv.add(avv);
									Collections.sort(giocateAvv);
									if(giocateAvv.size()>2) {
										if(giocateAvv.get(0)==1) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 2) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 3) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
											flag1=false;
											flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 4) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 7) {
													flag2=true;
												}
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
											flag1=false;
											flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 5) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 9) {
													flag2=true;
												}
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
										boolean numer2=false;
										boolean numer3=false;
										boolean numer5=false;
										boolean numer7=false;
										for(int y=0;y<giocateAvv.size();y++) {
											if(giocateAvv.get(y) == 2) {
												numer2=true;
											}
											if(giocateAvv.get(y) == 3) {
												numer3=true;
											}
											if(giocateAvv.get(y) == 5) {
												numer5=true;
											}
											if(giocateAvv.get(y) == 7) {
												numer7=true;
											}
										}
										if(numer2==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 5) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 8) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
										if(numer3==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 5) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 7) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
											flag1=false;
											flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 6) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 9) {
													flag2=true;
												}
											}
										}
										if(numer5==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 6) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 7) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
										if(numer7==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 8) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 9) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
									}
								}
								while (giocato == true) {
									gioco.getLabel_10().setText("E' IL TUO TURNO");
									boolean occupato = false;
									for (int i = 0; i < giocate.size(); i++) {
										if (giocate.get(i) == gioco.getCampo()) {
											occupato = true;
										}
									}
									if (occupato == false && gioco.getCampo() != 0) {
										giocato = false;
										switch (gioco.getCampo()) {
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
										out.println("///");
										out.println(avversario);
										out.println(gioco.getCampo());
										Collections.sort(giocate);
										if(giocate.size()>2) {
											if(giocate.get(0)==1) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 2) {
														flag1=true;
													}
													if(giocate.get(i) == 3) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
												flag1=false;
												flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 4) {
														flag1=true;
													}
													if(giocate.get(i) == 7) {
														flag2=true;
													}
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
												flag1=false;
												flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 9) {
														flag2=true;
													}
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
											boolean numer2=false;
											boolean numer3=false;
											boolean numer4=false;
											boolean numer7=false;
											for(int y=0;y<giocate.size();y++) {
												if(giocate.get(y) == 2) {
													numer2=true;
												}
												if(giocate.get(y) == 3) {
													numer3=true;
												}
												if(giocate.get(y) == 4) {
													numer4=true;
												}
												if(giocate.get(y) == 7) {
													numer7=true;
												}
											}
											if(numer2==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 8) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
											if(numer3==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 7) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
												flag1=false;
												flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 6) {
														flag1=true;
													}
													if(giocate.get(i) == 9) {
														flag2=true;
													}
												}
											}
											if(numer4==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 6) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
											if(numer7==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 8) {
														flag1=true;
													}
													if(giocate.get(i) == 9) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
										}
									}
								}
							}
						}
					}
					if (messaggio.equals("//")) {
						messaggio = in.readLine();
						int partita = JOptionPane.showConfirmDialog(null, messaggio + " vuole giocare con te, accetti?",
								"RICHIESTA DI GIOCO", 0);
						if (partita == 0) {
							avversario = messaggio;
							out.println("//");
							out.println("accept");
							out.println(avversario);
							f.setVisible(false);
							gioco = new Campo(s);
							gioco.setVisible(true);
							gioco.getLabel_11()
									.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/cerchio.png")));
							giocate = new ArrayList<Integer>();
							giocateAvv = new ArrayList<Integer>();
							while (true) {
								boolean giocato = false;
								while (giocato == false) {
									gioco.getLabel_10().setText("E' IL TUO TURNO");
									boolean occupato = false;
									for (int i = 0; i < giocate.size(); i++) {
										if (giocate.get(i) == gioco.getCampo()) {
											occupato = true;
										}
									}
									if (occupato == false && gioco.getCampo() != 0) {
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
										out.println("///");
										out.println(avversario);
										out.println(gioco.getCampo());
										Collections.sort(giocate);
										if(giocate.size()>2) {
											if(giocate.get(0)==1) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 2) {
														flag1=true;
													}
													if(giocate.get(i) == 3) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
												flag1=false;
												flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 4) {
														flag1=true;
													}
													if(giocate.get(i) == 7) {
														flag2=true;
													}
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
												flag1=false;
												flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 9) {
														flag2=true;
													}
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
											boolean numer2=false;
											boolean numer3=false;
											boolean numer5=false;
											boolean numer7=false;
											for(int y=0;y<giocate.size();y++) {
												if(giocate.get(y) == 2) {
													numer2=true;
												}
												if(giocate.get(y) == 3) {
													numer3=true;
												}
												if(giocate.get(y) == 5) {
													numer5=true;
												}
												if(giocate.get(y) == 7) {
													numer7=true;
												}
											}
											if(numer2==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 8) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
											if(numer3==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 5) {
														flag1=true;
													}
													if(giocate.get(i) == 7) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
												flag1=false;
												flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 6) {
														flag1=true;
													}
													if(giocate.get(i) == 9) {
														flag2=true;
													}
												}
											}
											if(numer5==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 6) {
														flag1=true;
													}
													if(giocate.get(i) == 7) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
											if(numer7==true) {
												boolean flag1=false;
												boolean flag2=false;
												for(int i=0;i<giocate.size();i++) {
													if(giocate.get(i) == 8) {
														flag1=true;
													}
													if(giocate.get(i) == 9) {
														flag2=true;
													}
												}
												if(flag1==false) {
													flag2=false;
												}
												if(flag2==false) {
													flag1=false;
												}
												if(flag1 == true && flag2 == true) {
													JOptionPane.showMessageDialog(null, "HAI VINTO!", "VITTORIA", 3);
													System.exit(0);
												}
											}
										}
									}
								}
								while (giocato == true) {
									gioco.getLabel_10().setText("E' IL TURNO DEL TUO AVVERSARIO");
									messaggio = in.readLine();
									int avv = Integer.parseInt(messaggio);
									giocato = false;
									switch (avv) {
									case 1:
										gioco.getLabel_1()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 2:
										gioco.getLabel_2()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 3:
										gioco.getLabel_3()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 4:
										gioco.getLabel_4()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 5:
										gioco.getLabel_5()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 6:
										gioco.getLabel_6()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 7:
										gioco.getLabel_7()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 8:
										gioco.getLabel_8()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									case 9:
										gioco.getLabel_9()
												.setIcon(new ImageIcon(Campo.class.getResource("/Immagini/x.png")));
										break;
									}
									giocateAvv.add(avv);
									Collections.sort(giocateAvv);
									if(giocateAvv.size()>2) {
										if(giocateAvv.get(0)==1) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 2) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 3) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
											flag1=false;
											flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 4) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 7) {
													flag2=true;
												}
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
											flag1=false;
											flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 5) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 9) {
													flag2=true;
												}
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
										boolean numer2=false;
										boolean numer3=false;
										boolean numer5=false;
										boolean numer7=false;
										for(int y=0;y<giocateAvv.size();y++) {
											if(giocateAvv.get(y) == 2) {
												numer2=true;
											}
											if(giocateAvv.get(y) == 3) {
												numer3=true;
											}
											if(giocateAvv.get(y) == 5) {
												numer5=true;
											}
											if(giocateAvv.get(y) == 7) {
												numer7=true;
											}
										}
										if(numer2==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 5) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 8) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
										if(numer3==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 5) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 7) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
											flag1=false;
											flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 6) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 9) {
													flag2=true;
												}
											}
										}
										if(numer5==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 6) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 7) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
										if(numer7==true) {
											boolean flag1=false;
											boolean flag2=false;
											for(int i=0;i<giocateAvv.size();i++) {
												if(giocateAvv.get(i) == 8) {
													flag1=true;
												}
												if(giocateAvv.get(i) == 9) {
													flag2=true;
												}
											}
											if(flag1==false) {
												flag2=false;
											}
											if(flag2==false) {
												flag1=false;
											}
											if(flag1 == true && flag2 == true) {
												JOptionPane.showMessageDialog(null, "HAI PERSO!", "SCONFITTA", 0);
												System.exit(0);
											}
										}
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
