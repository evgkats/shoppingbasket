# ShoppingBasket
A simple shopping basket built with Spring Boot and React

## How to run
1. Clone project
2. Run command: 
    ```
    mvn spring-boot:run
    ```

## About
A simple web application with a basic HTML front-end where from the user can add/remove items into their basket from a pool of priced items (dummy, hard-coded within the application). 

Basket displays total price and allows for quantity changes. 

When total exceeds €100 then a 10% discount is applied and displayed to user. 

On top of the total end price, the shipping costs are calculated via a fixed €5 per item multiplied by the item weight factor (ranging from 0 to 1). 

Basket survives browser refreshes via usage of the http session.
