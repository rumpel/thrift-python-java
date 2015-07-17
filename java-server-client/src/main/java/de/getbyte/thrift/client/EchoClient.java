package de.getbyte.thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import de.getbyte.thrift.service.MyStruct;
import de.getbyte.thrift.service.SayHelloService;
import de.getbyte.thrift.service.SayHelloService.Client;

public class EchoClient {
	public static void main(String[] args) {
		try {
			TTransport transport;

			transport = new TSocket("localhost", 9090);
			transport.open();

			TProtocol protocol = new TBinaryProtocol(transport);
			Client echoClient = new SayHelloService.Client(protocol);
			
			sendEchos(echoClient, 10);

			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	private static void sendEchos(Client echoClient, int count) {
		for (int i=0; i<count; i++) {
			try {
				MyStruct myStruct = new MyStruct("This is a simple echo string");
				myStruct.setNumber(i);
				System.out.println(echoClient.echo(myStruct));
			} catch (TException e) {
				e.printStackTrace();
			}
		}
	}
}
