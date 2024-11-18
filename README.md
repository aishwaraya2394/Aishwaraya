README.md

This is a Retail Product Catalog application with Fuzzy Search Capabilities that supports searching of products to accommodate for user input errors and approximations.

We have the following endpoints:
⦁	/products - POST - Accepts Data to add a new Product
⦁	/products - GET - Returns and Displays list of all products in repository
⦁	/search - GET - Returns and Displays list of products based on value entered. This uses fuzzy search to allow approximations and user input errors
⦁	/products/{id} - GET - Returns details for a specific Product based on input Id value

And we have the following Views:
⦁	Search Product View - This displays the list of roducts in repository wither all or based on the search bar input, Products are navigatable and redirect to the Details page
⦁	Product Details View - This displays the details of the selected Product


Endpoints:
⦁	http://localhost:8082/products
⦁	http://localhost:8082/search?name={query} , where query is the search term
⦁	http://localhost:8082/product{id} , where id is the search id 

The application has pre-defined data in local memory to initialize it on startup.
It can be run using the command 
mvn spring-boot:run 

 

The Edit Distance limit for the fuzzy search is handled via the application.properties and is currently set to 3.
