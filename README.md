
# Individual-Project-Aishwarya Paruchuri

## Problem Statement
The objective of the project is to develop a JAVA application for a user to purchase products online.The application should maintain an internal, static database. This means once we re-run the program, the changes to the data would not persist. The user is only allowed to buy a certain number of products from each category available. The order should satisfy the given requirements, and if it does, a bill amount should be generated. If the order does not satisfy the requirements, an output.txt file should be generated, stating the limitation should be generated.Output file type for a successfully processed order will be a .csv and for all other cases a .txt file.

# Steps to run the program
1. Create a folder by cloning the repository in which all the files are present.
2. Change the current directory to the src file.
3. To compile the source code run :  'Javac Billing.java' in src folder.
4. After compilation in src folder run : 'java Billing' or right click on Billing.java file and run the file.
5. Once you run the above command you would be asked to enter the input file path, there are 4 sample inputs provided in the resources folder.
6. NOTE : Before executing, please change the filepaths of 'itemfilepath, cardfilepath and outputfilepath' in  Billing.java file to the respective filepaths of cards.csv,items.csv available in resources folder in your local system. For output can give resources folder filepath available in your local system once you clone this repository.
7. NOTE : Makre sure you're running a configuration of jdk16 or newer. To check go to Files-> Project Structure and select jdk 16 from drop down before running Billing.java

## Design Patterns Used
### Singleton
* Singleton is a creational design pattern that lets you ensure that a class has only one instance, 
while providing a global access point to this instance.
Used this design pattern to create repository to store the incoming items and cards data of the application.
* Class Repository.java is the implementation of Singleton Design pattern.
* Every time a call to  Repository.getInstance() a same instance of Repository is returned.

![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/singleton.png)

### Factory
* A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for 
creating an object but let the subclasses decide which class to instantiate. 
In other words, subclasses are responsible to create the instance of the class
* Class ReaderFactory.java is the implementation of Factory design pattern.
* Objects of different reader types can be created by the ReaderFactory.
* getInstance method of ReaderFactory takes readerType as input and returns a new instance of respective reader.

![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/Factory.png)

### Builder
* Builder is a creational design pattern that lets you construct complex objects step by step. 
The pattern allows you to produce different types and representations of an object using the same construction code.
* Class Item.java class is the implementation of Builder design pattern.
* As Item constructor is private Item object can not be created using the default constructor it can only be created using ItemBuilder.

![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/Builder.png)


## Class Diagram

![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/Class_Diagram.jpeg)


## Screenshots of Test Cases

## Test case1:
* Here, I have given a list of items in the form of a csv file and it will output it in the form of csv file giving details of itemname, requested quantity and the total amount to be paid.
![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/sample_output1.png)


## Test case2:
* Here, for the input csv file containing the list of items to be purchased, I have entered a new card number so the application would identify and update it in the database. It will generate output in the form of csv file and will give details of the total amount to be paid along with the details of the items purchased and the quantity of those items.

![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/sample_output2.png)


## Test case3:
* In this assignment, we have set a capacity limit on items. For example, restricted Essentials to a maximum of 3, Luxury to 4, and Misc to 6. In this test case, I have exceeded Essential item's capacity on purpose. So, it would output a txt file saying which item has exceeded the capacity limit.
![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/sample_output3.png)


## Test case4:
* In this test case, I have tried to exceed the quantity of an item, i.e added 10k pens to be purchased in the csv input file. So, the application would give an error message in the form of txt file, saying stock not available as it has exceeded the capacity limit.
![](https://github.com/gopinathsjsu/individual-project-aishwarya95698/blob/master/sample_output4.png)









