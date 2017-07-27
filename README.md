# ping-pong
This application is a simple example of using Spring Cloud Stream together with RabbitMQ. 

There are two microservices here and the main idea of the app can be described as follows:

1. Service-1 sends messages to one destination ("ping") and is subscribed on another one ("pong"). 

2. Service-2, in its turn, consumes messages from the ("ping") and treat it in a simple way: 

	a) print message to console;

	b) sleep a bit;

	c) sends a message to "pong" destination. 
  
3. Service-1 consumes message from "pong", executes steps (a) and (b) sends a message to "ping" destination again.

Then actions (2) and (3) can be repeated again and again until services is stopped. A simple number of iteration serves as a message.

Please, be sure that RabbitMQ broker is running on your machine with default port configuration.


