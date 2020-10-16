import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMaker {
	static ServerSocket serverSocket;
	static Socket socket;
	static DataOutputStream out;

	public static void main(String[] args) throws Exception {
		System.out.println("Starting server...");
		serverSocket = new ServerSocket(7777);
		System.out.println("Sever started...");
		while (true) {
			socket = serverSocket.accept();
			System.out.println("Connection from:" + socket.getInetAddress());
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Did the connection work?");
			System.out.println("Data has been sent.");
		}
	}
}
