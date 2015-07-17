package de.getbyte.thrift.server;

import org.apache.thrift.TException;
import de.getbyte.thrift.service.MyStruct;
import de.getbyte.thrift.service.SayHelloService;

public class SayHelloServiceHandler implements SayHelloService.Iface {

    public String echo(MyStruct echoString) throws TException {
        return "String: " + echoString.getEchoString() + " Int: " + echoString.getNumber();
    }
    
}
