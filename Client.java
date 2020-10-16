import java.io.DataInputStream;
import java.net.Socket;

public class Client {

	static Socket socket;
	static DataInputStream in;

	public static void main(String[] args) throws Exception {

		System.out.println("Connecting...");
		socket = new Socket("192.168.0.166", 7777);
		socket.setSoTimeout(10 * 1000);
		System.out.println("Connection Successful.");
		in = new DataInputStream(socket.getInputStream());
		System.out.println("Receiving information...");
		String test = in.readUTF();
		System.out.println("Message from server: " + test);
	}

}
