# gRPC-Chat

## Introduction

This project seeks to implement a Ring of servers running a **Chat** service.

Consists of a system with 3 entities: **Clients**, **Servers** and a **Ring Manager**. The **Servers** will be running the **Chat** service. The **Ring Manager** is essentially a server as well, that will manage the ring of operational servers. The **Clients** will register with a username and send messages to each other.

The packages for each can be found in the /packages folder.

## Usage

### ChatRingManager

> To execute ChatRingManager.jar use: 

```
java -jar ChatRingManager.jar --endpoint=<ip>:<port> --ring-size=<ringSize>
```
  
> Where **ip** and **port** make the **endpoint** where **Ring Manager** should be hosted, and **ringSize** is the number of servers expected to enroll in the ring. Example: 

```
java -jar ChatRingManager.jar --endpoint=localhost:9000 --ring-size=3
```

### ChatServer

> To execute ChatServer.jar use: 

```
java -jar ChatRingManager.jar --endpoint-ring-manager=<ringmanagerIp>:<ringManagerPort> --endpoint=<ip>:<port>
```

> Where **ringmanagerIp** and **ringManagerPort** make the endpoint where the **Ring Manager** is hosted, and **ip** and **port** make the **endpoint** where the **Chat Server** should be hosted. Example:

```
java -jar ChatRingManager.jar --endpoint-ring-manager=localhost:9000 --endpoint=localhost:9001
```

### ChatClient

> To execute ChatClient.jar use: 

```
java -jar ChatClient.jar --endpoint-ring-manager=<ringmanagerIp>:<ringManagerPort>
```

> Where **ringmanagerIp** and **ringManagerPort** make the endpoint where the **Ring Manager** is hosted. Example:

```
java -jar ChatClient.jar --endpoint-ring-manager=localhost:9000
```
