
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerModel {
	public static ArrayList<Socket> listaSocket = new ArrayList<Socket>();

	/**
	 * Invio un messaggio a tutti
	 * 
	 * @param message
	 *            // Il messaggio da inviare
	 * @param sender
	 *            // Chi invia il messaggio
	 */
	public static ArrayList<Persona> vett = new ArrayList<Persona>();

	public static void sendMessage(String message, Socket sender) {
		for (int i = 0; i < listaSocket.size(); i++) {
			try {
				Socket temp = listaSocket.get(i);
				PrintWriter out = new PrintWriter(temp.getOutputStream(), true);
				int c = 0;
				boolean flag = false;
				while (c < vett.size() && flag == false) {
					if (message.equals(vett.get(c).getUsername())) {
						flag = true;
					}
					c++;
				}
				if (flag == false) {
					Persona p = new Persona(message, listaSocket.get(i).getInetAddress().toString(),
							listaSocket.get(i).getPort());
					vett.add(p);
				}
				for (int y = 0; y < vett.size(); y++) {
					if (y != i) {
						out.println(vett.get(y).getUsername());
					}
				}
			} catch (IOException e) {
				// Nel caso ci sia qualche problema salta quel socket
				e.printStackTrace();
			}
		}
	}

	public static void creaPartita(String message, Socket sender) throws IOException {
		Socket temp = null;
		for (int y = 0; y < vett.size(); y++) {
			if (vett.get(y).getUsername().equals(message)) {
				temp = listaSocket.get(y);
			}
		}
		String mitt = "";
		for (int y = 0; y < listaSocket.size(); y++) {
			if (sender == listaSocket.get(y)) {
				mitt = vett.get(y).getUsername();
			}
		}
		PrintWriter out = new PrintWriter(temp.getOutputStream(), true);
		out.println("//");
		out.println(mitt);
	}

	public static void confermaPartita(String message) throws IOException {
		Socket temp = null;
		for (int y = 0; y < vett.size(); y++) {
			if (vett.get(y).getUsername().equals(message)) {
				temp = listaSocket.get(y);
			}
		}
		PrintWriter out = new PrintWriter(temp.getOutputStream(), true);
		out.println("/");
		out.println("confirm");
	}

	public static void partita(String dest, String numero) throws IOException {
		Socket temp = null;
		for (int y = 0; y < vett.size(); y++) {
			if (vett.get(y).getUsername().equals(dest)) {
				temp = listaSocket.get(y);
			}
		}
		PrintWriter out = new PrintWriter(temp.getOutputStream(), true);
		out.println(numero);
	}

	/**
	 * Chiudo tutti i socket
	 */
	public static void close() {
		for (int i = 0; i < listaSocket.size(); i++) {
			try {
				listaSocket.get(i).close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
