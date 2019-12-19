REST Example:

This repository includes a  REST API built with RestController using Spring boot framework.

This project uses H2 database.



Run and Test :

To run the application type



Endpoints :

Important: Content-Type: application/json header must be present to use API.



Add a product :

/v1/products/product [POST]

Content-Type: application/json

{
	"name": String,
	"description": String,
	"brand": String,
	"tags": List,
	"category": String
}



Get products by category:

Example : v1/products/productsByCategory?category=apparel&page=1&size=10 [GET]
