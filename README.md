# Group 70 - Drink Delivery Application

## Group members
* Lisa Cheng ([lisa272](https://github.com/lisa272))([lisacheng12](https://github.com/lisacheng12))
* Roy Fan ([TingmingFan](https://github.com/TingmingFan))
* Sancia Gao ([sanciag17](https://github.com/sanciag17))
* Xiyuan Jin ([AdwinTazement](https://github.com/AdwinTazement))
* Donna Qi ([donnaqi](https://github.com/donnaqi))
* Yuanyuan Qin ([yyuan-qin](https://github.com/yyuan-qin))
* Jessica Yuan([yuanjiat](https://github.com/yuanjiat))

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

#### 2.2 Customer Use Case
* [AddToShoppingCart](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/customerusecases/AddToShoppingCart.java)
  * 

#### 2.3 Seller Use Case
* [ModifyDrink](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/sellerusecases/ModifyDrink.java)
  * 
* [ModifyOrderStatus](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/sellerusecases/ModifyOrderStatus.java)
  * It receives the oreder number and the new order status that the seller wants to change, get the current seller using 
  the getCurrentSeller method in UserRuntimeDataBase class in userusercases package. Then finds the corresponding order 
  with order number, and change the order status.
  
* [SellerModifyDrink](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/sellerusecases/SellerModifyDrink.java)
  * The class has a private static variable that keep track of the drink that the seller wants to modify.
  * The searchedDrinkToModify method receives the drink name and get the drink using DrinkRuntimeDataBase and store it in 
  the static variable searchedDrink.
  * The modifyDrink method receives the attributes of a modified drink including drink name, drink price, drink description, drink
  ingredient, volume, production date, expiration date and discount. If the seller modify the drink name, then it remove 
  the seachedDrink from alldrinks and add the new drink. If the drink name is not changed, then replace the drink in alldrinks
  with the current modified drink. At last, modify the items(Arraylist of drink that the seller sell) attribute in Seller.
  * The addDrink method receives the attributes of a new drink including drink name, drink price, drink description, drink 
  ingredient, volume, production date, expiration date and discount. It checks if the new drink is included in the database,
  if not, then add it into the database.
  * The deleteDrink method receives the attributes of a drink including drink name, drink price, drink description, drink
    ingredient, volume, production date, expiration date and discount, and delete the corresponding drink from the database.

#### 2.4 Order Use Case

#### 2.5 Drink Use Case
* [SearchDrinks()](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/drinkusecases/SearchDrinks.java)
  * Get all drinks by the searching keyword,return the vector form of drinks which can be used in JTable.

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
  * constructCurrentSeller() and constructCurrentCustomer(): When the user login, the login screen will pass his/her 
  phone number, and we will find the user object in the runtime database and save it as the static variable, so whenever 
  a use cases modify the user object attributes (i.e. reset password, customer make a new order, seller add drinks), 
  other use cases will have the variable updated.

#### 2.7 [user response model](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/usecases/userresponsemodel)
* [Login Response Model](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/userresponsemodel/LoginResponseModel.java)
  * Providing the corresponding message to users when login in. Either successfully logged in. Or incorrect  phone number or password.

* [Question Response Model](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/userresponsemodel/QuestionResponseModel.java)
  * Provide preprogrammed answers to the user when pressing the corresponding button.(common q&a for users)
  * Provide Store's contact information to user.

* [Register Response Model](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/usecases/userresponsemodel/RegisterResponseModel.java)
  * Providing the corresponding message to users when registering. Inform users whether they have successfully registered, or something going wrong, the password doesn't match, provide name already exists etc.


### 3. Controllers
TODO

### 4. [Screens](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/screens)
* Login Register Screens

* Customer Main Screens
  * [SearchingDrinksPanel](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/screens/customerscreens/SearchingDrinksPanel.java)
    * This class is a panel in customer main page. This class is a feature which allowed customer searching drinks' 
    keyword and drinks will be presented as a table. Also allowed customers adding drinks to shopping cart in the same 
    page.

* Seller Main Screens
  * [AddDrinkScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/AddDrinkScreen.java)
    * When the add drink button on the seller main screen is clicked, this screen would be open.
    * This screen contains text box of all the attributes of the drink class, and it prompts the seller to enter all attributes, 
    including drink name, drink price, drink description, drink ingredient, volume, production date, expiration date 
    and discount. (It also prompt the seller for the format of the production date, expiration date and discount)
    * The screen contains two buttons, add drink button and cancel button. 
    * When the add drink button is clicked, the project would use the addDrink method in SellerModifyDrink class in sellerusecases package.
    * When the cancel button is clicked by the seller, the AddDrinkScreen would be closed, and the SellerMainScreen would open.
    
  * [DeleteDrinkScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/DeleteDrinkScreen.java)
    * When the delete drink button on the seller main screen is clicked, this screen would be open.
    * This screen contains a text box which let the seller to enter the drink name that he/she wants to delete. 
    * This screen also contains a delete drink button and cancel button. When the delete drink button is clicked, 
    the project would use the searchedDrinkToModify method in the SellerModifyDrink class in sellerusecases package, if 
    the drink name that seller entered is not in his/her current drinks, then it would tell the user that drink name not
    match. If the drink name is in the seller's drinks, then it will use the deleteDrink method in SellerMo
    * When the cancel button is clicked by the seller, the DeleteDrinkScreen would be closed, and the SellerMainScreen would open.
    
  * [SearchModifyDrinkScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/SearchModifyDrinkScreen.java)
    * When the modify drink button on the seller main screen is clicked, this screen would be open.
    * This screen contains a text box which let the seller enter the drink name that he/she wants to modify.
    * This screen also contains a search drink button and cancel button. When the search drink button is clicked,
      the project would use the searchedDrinkToModify method in the SellerModifyDrink class in sellerusecases package, if
      the drink name that seller entered is not in his/her current drinks, then it would tell the user that drink name not
      match. If the drink name is in the seller's drinks, then it will close the SearchModifyDrink Screen and open the ModifyDrinkScreen.
    * When the cancel button is clicked by the seller, the SearchModifyDrinkScreen would be closed, and the SellerMainScreen would open.

  * [ModifyDrinkScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/ModifyDrinkScreen.java)
    * When the search drink button on the search modify drink screen is clicked, this screen would be open. 
    * This screen contains text box of all the attributes of the drink class, and it prompts the seller to enter all attributes,
    including drink name, drink price, drink description, drink ingredient, volume, production date, expiration date 
    and discount.
    * The screen contains two buttons, modify drink button and cancel button. 
    * When the modify drink button is clicked, the drink that seller entered in the search modify drink screen would be modified
    using the modifyDrink method in the sellerModifyDrink class in the sellerusecases package.
    * When the cancel button is clicked by the seller, the ModifyDrinkScreen would be closed, and the SellerMainScreen would open.
    
  * [OrderStatusScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/OrderStatusScreen.java)
    * When the modify status button on the seller main screen is clicked, this screen would be open.
    * This screen contains all the order that customers has ordered in this login seller's store, and two buttons which are modify button and back button.
    * When the modify button is clicked, the OrderStatusScreen would be closed, and the ModifyStatusScreen would open.
    * When the back button is clicked by the seller, the OrderStatusScreen would be closed, and the SellerMainScreen would open.

  * [ModifyStatusScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/ModifyStatusScreen.java)
    * When the modify button on the order status screen is clicked, this screen would be open.
    * This screen contains two text box that prompt the seller to enter the order number that he/she wants to modify and the new order status.
    * This screen also contains two buttons, modify button and back button.
    * When the modify button is clicked, the project would first check if the order number is included in the seller's 
    orders, and if it is included, it would then check if the new order status that the seller entered is different from 
    the previous order status. If it all satisfied, then the project would use the ModifyOrderStatus method in 
    ModifyOrderStatus class in the sellerusecases packege to modify the seller order status and prompt the seller that 
    he/she have changed the order status. If any of the condition is not satisfied, it would prompt the seller that the 
    order number does not exist or the order status is the same.
    * When the back button is clicked by the seller, the ModifyStatusScreen would be closed, and the SearchedModifyDrinkScreen would open.

  * [SellerMainScreen](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/screens/sellerscreens/SellerMainScreen.java)
    * This screen contains all the drink of the login seller and four buttons which are add drink button, delete drink button, modify drink button and modify order status button.
    * When each button is clicked by the seller, the seller main screen is closed and open the corresponding function screens.

* Other Swing Components
  * [SearchingTable](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/screens/customerscreens/SearchingTable.java)
    * This class is a JTable of swing and this table is used in searching drinks panel. Set the table grid line colour 
    as black so that each lines of drinks and variables of drinks can be seperated clearly.
  * [SearchingTableModel](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/screens/customerscreens/SearchingTableModel.java)
    * This class is a table model of the JTable. In this class, set the default model of table which includes headers 
    and initialize the table.
### 5. [Helpers](https://github.com/CSC207-2022F-UofT/course-project-6-2/tree/main/src/main/java/helpers)
* [Serializer](https://github.com/CSC207-2022F-UofT/course-project-6-2/blob/main/src/main/java/helpers/Serializer.java)
  * The lowest level object integrating with file system, converting object input stream to file output stream.

* [Deserializer]()
  * The reverse process of converting file input stream to object output stream.

Note: Since only the objects implement the Serializable interface can be serialized, User, Drink, Order and Shopping 
Cart classes all implement the interface.