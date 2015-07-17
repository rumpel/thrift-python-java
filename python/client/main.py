#!/usr/bin/env python

import sys
sys.path.append('../generated-sources')

from gen import SayHelloService
from gen.ttypes import *

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

def doEcho(count, client):
  for i in xrange(1, count):
    myStruct = MyStruct('This is a java server concatenated response');
    myStruct.number = i;
    print client.echo(myStruct);
    
try:
  # Make socket
  transport = TSocket.TSocket('localhost', 9090)

  # Buffering is critical. Raw sockets are very slow
  transport = TTransport.TBufferedTransport(transport)

  # Wrap in a protocol
  protocol = TBinaryProtocol.TBinaryProtocol(transport)

  # Create a client to use the protocol encoder
  client = SayHelloService.Client(protocol)

  # Connect!
  transport.open()
  
  doEcho(10, client);
    
  # Close!
  transport.close()

except Thrift.TException, tx:
  print '%s' % (tx.message)
  
