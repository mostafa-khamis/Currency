Run project on docker
  1- Add all projects in on directory 
  2- Open CMD in this directory 
  3- Run this commant "docker compose up"

URLs to test:
http://localhost:8000/exchange/USD/to/EGP
http://localhost:8000/exchange/USD/to/SA
http://localhost:8000/exchange/USD/to/UAE

http://localhost:8100/conversion/USD/to/EGP/quantity/100
http://localhost:8100/conversion/USD/to/SA/quantity/100
http://localhost:8100/conversion/USD/to/UAE/quantity/100

Through API Gateway 
http://localhost:8765/CURRENCY-EXCHANGE/exchange/USD/to/EGP
http://localhost:8765/CURRENCY-EXCHANGE/exchange/USD/to/SA
http://localhost:8765/CURRENCY-EXCHANGE/exchange/USD/to/UAE

http://localhost:8765/CURRENCY-CONVERSION/conversion/USD/to/EGP/quantity/100
http://localhost:8765/CURRENCY-CONVERSION/conversion/USD/to/SA/quantity/100
http://localhost:8765/CURRENCY-CONVERSION/conversion/USD/to/UAE/quantity/100

Eureka:
localhost:8761
