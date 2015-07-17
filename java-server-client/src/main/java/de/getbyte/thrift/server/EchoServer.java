package de.getbyte.thrift.server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import de.getbyte.thrift.service.SayHelloService;

public class EchoServer {
    public static void main(String[] args) {
        try {
            SayHelloServiceHandler handler = new SayHelloServiceHandler();
            SayHelloService.Processor<SayHelloServiceHandler> processor;
            
            processor = new SayHelloService.Processor<SayHelloServiceHandler>(handler);

            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(
              new Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new
            // TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
           } catch (Exception e) {
            e.printStackTrace();
           }
    }
}
