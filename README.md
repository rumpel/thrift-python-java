## Run the Java server
``` 
cd java-server-client
mvn test -Pserver
``` 

This command will run the server on port 9090

## Run the Java client
```
cd java-server-client
mvn test -Pclient
```

## Run the Python client
First, setup the required dependencies
```
git clone https://github.com/apache/thrift.git
cd ./thrift/lib/py
python setup.py install
```

Now you can easily run the python client

``` 
cd python/client
python main.py
```
