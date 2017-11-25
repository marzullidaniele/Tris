

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket client = null;
	String stringaModificata = null;
	String messaggio = null;
	BufferedReader input;

	public ServerThread(Socket socket) {
		this.client = socket;
	}

	public void run() {
		try {
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String dest="";
			while(true) {
				messaggio = input.readLine();
				if(messaggio.equals("///") == false && messaggio.equals("//") == false && messaggio.equals("/") == false) {
					ServerModel.sendMessage(messaggio, client); // lo ritrasmette 
				}
				if(messaggio.equals("/")){
					messaggio = input.readLine();
					ServerModel.creaPartita(messaggio,client);
				}
				if(messaggio.equals("//")){
					messaggio = input.readLine();
					if(messaggio.equals("accept")) {
						messaggio = input.readLine();
						ServerModel.confermaPartita(client,messaggio);
					}
					if(messaggio.equals("decline")) {
					}
				}
				if(messaggio.equals("///")){
					//ServerModel.elimina(client);
				}
				if(messaggio.equals("////")) {
					messaggio = input.readLine();
					dest = messaggio;
					messaggio = input.readLine();
					ServerModel.partita(dest,messaggio,client);
				}
			}		
			
		} catch (Exception e) {
			// esce e basta
		}
	}
}
