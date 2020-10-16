
// Java program to illustrate Server side 
// Implementation using DatagramSocket 
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerMaker {
	public static void main(String[] args) throws IOException {
		// Step 1 : Create a socket to listen at port 7777
		DatagramSocket ds = new DatagramSocket(7777);
		byte[] receive = new byte[65535];
		InetAddress ip = InetAddress.getLocalHost();
		DatagramPacket DpReceive = null;
		while (true) {

			// Step 2 : create a DatgramPacket to receive the data.
			System.out.println("running");
			DpReceive = new DatagramPacket(receive, receive.length);
			System.out.println("running");
			// Step 3 : revive the data in byte buffer.
			ds.receive(DpReceive);

			System.out.println("Client:-" + data(receive));

			// Exit the server if the client sends "bye"
			if (data(receive).toString().equals("bye")) {
				System.out.println("Client sent bye.....EXITING");
				break;
			}
			// Clear the buffer after every message.
			String inp = data(receive).toString();
			InetAddress address = DpReceive.getAddress();
			int port = DpReceive.getPort();
			byte[] buf = inp.getBytes();
			DatagramPacket DpSend = new DatagramPacket(buf, buf.length, address, port);
			ds.send(DpSend);
			receive = new byte[65535];
		}
	}

	// A utility method to convert the byte array
	// data into a string representation.
	public static StringBuilder data(byte[] a) {
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0) {
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
