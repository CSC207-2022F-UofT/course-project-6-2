# Group 70 - Drink Delivery Application

## Group members (alphabetical order by last name)
* Lisa Cheng
* Roy Fan
* Sancia Gao
* Xiyuan Jin
* Donna Qi ([donnaqi](https://github.com/donnaqi))
* Yuanyuan Qin
* Jessica Yuan

## Documents

[Milestone Documents Google Drive](https://drive.google.com/drive/folders/1LSEvoL295-J-YNdKq5guBFNt9Iiyg4x_)

## Introduction
### 1. Entities
#### 1.1 User

User is an abstract class that will be inheritanced by Customer class and Seller class. 

The user object has the following attributes:

* account name
* phone number 
* password
* address

Note: The phone number attribute is an unique identifier for each user object and will be used for login process.

#### 1.2 Customer

Customer is the subclass of User, and it is used to store information for each individual customer of our application.

The customer object has the following attributes:

* attributes of User (account name, phone number, password and address)
* age
* order history
* shopping cart

Note: The order history and shopping cart are not constructor parameters, they are initialized as empty and will be set when the customer placed orders and/or add items in the shopping cart.

#### 1.3 Seller
Seller is the subclass of User, and it is used to store information for each individual seller of our application.

The seller object has the following attributes:

* attributes of User (account name, phone number, password and address)
* store name
* all orders
* drink items (drinks that sellers sell)

Note: The all orders and drink items are not constructor parameters, they are initialized as empty and will be set when the seller get orders from customers add/or add drinks.

#### 1.4 Drink
Drink is a class that used to store information for each drink sold by sellers on our application.

The drink object has the following attributes:

* name
* price
* description
* ingredient
* volume
* production date
* expiration date
* discount
* store name

Notes: 
- Discount is 1 (meaning the price is now 100%) for drinks with no discount, and drink with discount will have the attribut as a float between 0 and 1 (i.e. 0.8 accounts for a 20% off discount).
- Store name is not a constructor parameter, and it will be set when the seller add the drink to its store. This attribute can not be modified.
- Every attributes except store name can be modified when the seller modify drink info. When the seller modify only the drink name, the application will delete this drink object and form a new drink object with the changed name and make other info identical.


#### 1.5 Order
Order is a class that used to store information for each order placed by customers on our application.

The order object has the following attributes:

* order number
* order list (drink and its quantity)
* order status

Notes:
- Order number is an unique identifier for each order and it will be set when the customer placed the order (click on check out buttom in shopping cart).
- The order number equals to the current total order to make sure the order number is not repetitive in the database.
- There is an overloading constructor used to reorder in the order history, which will change order number and make the other info identical to the previous order that the user want to reorder.
- The order list is an Hashmap that use drink object as the key and its coresponding quantity as value.
- Order status is set as "in progress" when the order placed and will be modified by sellers when the status changes (i.e. ready, pickedUp or delivered).

#### 1.6 Shopping Cart
Shopping Cart is a class that used to store information in customer's shopping cart.

The shopping cart object has the following attributes:

* total price
* item list (drink and its quantity)

Notes:
- The total price will be added up as drink quantity * price in the shopping cart.
- The order list is an Hashmap that use drink object as the key and its coresponding quantity as value.

***Important: We placed Sale Board, Warning Board and Customer Service as Entities in our CRC model by mistake, these three are NOT Entities but major features and we will explain them in detail in the following Use Cases Section.***

### 2. Use Cases

### 3. Controllers

### 4. Screens
