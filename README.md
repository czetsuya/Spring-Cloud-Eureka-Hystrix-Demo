[![ko-fi](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/S6S0YXPX)

# Spring Cloud Demos
> This repository contains a set of projects that demonstrates the features of spring cloud.

 - spring-cloud-order-api - contains the order services
 - spring-cloud-order-business-api - a service use to aggregate data from order and product services
 - spring-cloud-order-config - project fetching configuration from local git
 - spring-cloud-order-discovery - service discovery
 - spring-cloud-order-product-api - contains the product services
 - spring-cloud-order-zuul-server - server side load balancer
 - order-git

## Features
 - External GIT configuration
 - API Composition
 - Health check - Actuator
 - Application matrx - Hystrix
 - Service discovery - Eureka
 - Documentation - Swagger
 - Load balancer - Ribbon / Zuul

## Technologies
 - Spring Cloud
 - Hystrix
 - Eureka
 - Swagger
 - Ribbon
 - Zuul
 - GIT
 
## Environment Setup

1. Initialize a local git repository and add the following 3 files, located in their respective project's src/main/resources folder:
    - orderservice.properties
    - productservice.properties
    - orderbusinessservice.properties
2. Replace the IP with your own IP. Note that I'm running the apps on 2 machines, you can use a VM.
    - 192.168.1.7 - is where I run all the applications except
    - 192.168.1.6 - a eureka server (discovery server) replica
3. Make sure to commit your changes as these property files will be use by the application.

## Development Setup
1. Clone and checkout the repository.
2. Initialized order-git git repository on your local machine and commit the files. Everytime you change a configuration on these files, you must commit the changes to your local repository.
3. Double check that the settings in your application and bootstrap properties are correct, specially the paths.
4. Run the project in this order:
    - spring-cloud-order-config
    - spring-cloud-order-discovery
    - spring-cloud-order-zuul-server
    - spring-cloud-order-api
    - spring-cloud-order-product-api
    - spring-cloud-order-business-api - see Environment Variables section
5. From spring-cloud-order-api, check if the url is accessible to see if the project successfully starts.
6. If all goes well, localhost:8762 should be accessible and all the sub-services.
7. Here are the available services accessible from zuul api gateway:
    - <NETWORK_IP>:8762/routes
    - <NETWORK_IP>:8762/orderservice/orders
    - <NETWORK_IP>:8762/productservice/products
    - <NETWORK_IP>:8762/productservice/products/1
    - <NETWORK_IP>:8762/orderbusinessservice/productOrders
8. Config profiles
    - <NETWORK_IP>:8000/productservice/env
    - <NETWORK_IP>:8000/orderservice/env
    - <NETWORK_IP>:8000/orderbusinessservice/env
    - env can be replace by the project's profile
9. Take advantage of the Spring profiles already available.

## Environment Variables
If you want to test Zuul load balancer, run at least 2 instances of project spring-cloud-order-business-api project on port 8003, 8004, and so on... 

## Prerequisites
 - Spring STS
 - Java 8
 - GIT

## Authors

* **Edward P. Legaspi** - *Architect* - [czetsuya](https://github.com/czetsuya)

## URLs
 * https://github.com/czetsuya

## Release History

 * 0.0.0.1-SNAPSHOT
    * Initial commit.
    * CHANGE: Update docs.

<!-- Markdown link & resource definitions -->
[czetsuya]: https://github.com/czetsuya
