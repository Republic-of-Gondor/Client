import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection {
	private String serverAddress = "127.0.0.1";
	private int port = 9898;

	private BufferedReader inStream;
	private PrintWriter outStream;

	public ServerConnection() {
		try {
			Socket socket = new Socket(serverAddress, port);
			inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outStream = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.err.println("Failed to open socket connection to server: " + serverAddress + ":" + port);
		}
	}

	public void listen()	{
		while (inStream != null)	{
			try {
				System.out.println(inStream.readLine());
			} catch (IOException e)	{
				System.err.println("Failed to read from socket connection");
			}
		}
	}
}
