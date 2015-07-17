namespace java de.getbyte.thrift.service

struct MyStruct {
  1: required string echoString;
  2: optional i32 number;
}

service SayHelloService {
	string echo(1: MyStruct echoString);
}
