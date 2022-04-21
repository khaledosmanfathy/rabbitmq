<div id="top"></div>



### Built With


* [Java Spring Boot](https://spring.io/projects/spring-boot)
* [RabbitMQ 3.9.15](https://www.rabbitmq.com/)
* [Docker](https://www.docker.com/)
* [REST API](https://restfulapi.net/)

<!-- GETTING STARTED -->
## Getting Started

This is an application to produce and consume a message using REST API and Rabbit MQ

### Prerequisites

*install Rabbit MQ 3.9.15
*docker

## Usage

 *  use this API to produce a message.
        - localhost:9091/rabbitmq/producer/{message}
 * use this API to consume the previous message message.
        - localhost:9091/rabbitmq/consumer/{message}
