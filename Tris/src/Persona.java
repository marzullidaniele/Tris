
public class Persona {
	private String username;
	private String ip;
	private int port;
	public Persona(String username, String ip,int port) {
		this.username = username;
		this.ip = ip;
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
