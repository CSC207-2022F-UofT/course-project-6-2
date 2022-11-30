# Group 70 - Drink Delivery Application

## Group members
* Lisa Cheng ([lisa272](https://github.com/lisa272))([lisacheng12](https://github.com/lisacheng12))
* Roy Fan ([TingmingFan](https://github.com/TingmingFan))
* Sancia Gao ([sanciag17](https://github.com/sanciag17))
* Xiyuan Jin ([AdwinTazement](https://github.com/AdwinTazement))
* Donna Qi ([donnaqi](https://github.com/donnaqi))
* Yuanyuan Qin ([yyuan-qin](https://github.com/yyuan-qin))
* Jessica Yuan

## Documents

[Milestone Documents Google Drive](https://drive.google.com/drive/folders/1LSEvoL295-J-YNdKq5guBFNt9Iiyg4x_)

## Introduction
### 1. [Entities](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/entities)
#### 1.1 [User](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/entities/users/User.java)

User is an abstract class that will be inheritanced by Customer class and Seller class. 

The user object has the following attributes:

* account name
* phone number 
* password
* address

Note: The phone number attribute is an unique identifier for each user object and will be used for login process.

#### 1.2 [Customer](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/entities/users/Customer.java)

Customer is the subclass of User, and it is used to store information for each individual customer of our application.

The customer object has the following attributes:

* attributes of User (account name, phone number, password and address)
* age
* order history
* shopping cart

Note: The order history and shopping cart are not constructor parameters, they are initialized as empty and will be set when the customer placed orders and/or add items in the shopping cart.

#### 1.3 [Seller](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/entities/users/Seller.java)
Seller is the subclass of User, and it is used to store information for each individual seller of our application.

The seller object has the following attributes:

* attributes of User (account name, phone number, password and address)
* store name
* all orders
* drink items (drinks that sellers sell)

Note: The all orders and drink items are not constructor parameters, they are initialized as empty and will be set when the seller get orders from customers add/or add drinks.

#### 1.4 [Drink](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/entities/Drink.java)
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
* Discount is 1 (meaning the price is now 100%) for drinks with no discount, and drink with discount will have the attribut as a float between 0 and 1 (i.e. 0.8 accounts for a 20% off discount).
* Store name is not a constructor parameter, and it will be set when the seller add the drink to its store. This attribute can not be modified.
* Every attribute except store name can be modified when the seller modify drink info. When the seller modify only the drink name, the application will delete this drink object and form a new drink object with the changed name and make other info identical.


#### 1.5 [Order](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/entities/Order.java)
Order is a class that used to store information for each order placed by customers on our application.

The order object has the following attributes:

* order number
* order list (drink and its quantity)
* order status

Notes:
* Order number is an unique identifier for each order and it will be set when the customer placed the order (click on check out buttom in shopping cart).
* The order number equals to the current total order to make sure the order number is not repetitive in the database.
* There is an overloading constructor used to reorder in the order history, which will change order number and make the other info identical to the previous order that the user want to reorder.
* The order list is an Hashmap that use drink object as the key and its coresponding quantity as value.
* Order status is set as "in progress" when the order placed and will be modified by sellers when the status changes (i.e. ready, pickedUp or delivered).

#### 1.6 [Shopping Cart](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/entities/ShoppingCart.java)
Shopping Cart is a class that used to store information in customer's shopping cart.

The shopping cart object has the following attributes:

* total price
* item list (drink and its quantity)

Notes:
* The total price will be added up as drink quantity * price in the shopping cart.
* The order list is an Hashmap that use drink object as the key and its coresponding quantity as value.

***Important: We placed Sale Board, Warning Board and Customer Service as Entities in our CRC model by mistake, these three are NOT Entities but major features and we will explain them in detail in the following Use Cases Section.***

### 2. [Use Cases](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/usecases)

#### 2.1 [Login Register Use Case](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/usecases/loginregisterusecases)

* [login()](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/loginregisterusecases/LoginUser.java)
  * Receive login info and check if user should be authenticated.
  * Return String to indicate whether the user login is a customer, seller or does not exist in database.
  
* [register()](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/loginregisterusecases/RegisterUser.java)
  * Store user instance to corresponding database.
  * Return String to indicate whether the user input for registration is valid or not.

* [resetPassword()](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/loginregisterusecases/ResetUserPassword.java)
  * Receive newPassword and check if the new password is different from previous password, a user can only reset the password if and only if the phone number exists and newPass and confirmPass match
  * newPassword does not necessarily need to be different with the previous password.
  * Return Boolean to indicate if the password has been set successfully.

#### 2.2 [Customer Use Case](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/usecases/customerusecases)

#### 2.3 [Seller Use Case](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/usecases/sellerusecases)

#### 2.4 Order Use Case

#### 2.5 Drink Use Case

#### 2.6 [Database Use Case](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/usecases/userusercases)
* [constructUserData()](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/userusercases/ConstructUserDataBase.java)
  * Extract User objects from database and store to users in a ArrayList of HashMap.
  * HashMap at index 0 are seller objects and HashMap at index 1 are customer objects.

* [saveUserData()](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/userusercases/SaveUserDataBase.java)
  * Save User objects into database.

* [User Runtime Database](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/userusercases/UserRuntimeDataBase.java)
  * Save all sellers and customers data in the Runtime Database
  * Save current seller and customer who are viewing the application in a Runtime Database
  * We save these data as static variables to make sure every screen and/or use case that access these data will get the 
  same value instead of calling multiple instances of the class which might not be updated properly.
  * constructCurrentSeller() and constructCurrentCustomer(): When the user login, the login screen will pass his/her phone number 

### 3. Controllers

### 4. Screens

### 5. Helpers
