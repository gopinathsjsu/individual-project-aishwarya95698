
# Individual-Project-Aishwarya Paruchuri

## Contents

 * [Problem Statement](#understanding-customer-churn)
 * [Steps to run the program](#quick-start)


## Problem Statement
The objective of the project is to develop a JAVA application for a user to purchase products online.The application should maintain an internal, static database. This means once we re-run the program, the changes to the data would not persist. The user is only allowed to buy a certain number of products from each category available. The order should satisfy the given requirements, and if it does, a bill amount should be generated. If the order does not satisfy the requirements, an output.txt file should be generated, stating the limitation should be generated.Output file type for a successfully processed order will be a .csv and for all other cases a .txt file.

# Steps to run the program
1. Create a folder by cloning the repository in which all the files are present.
2. Change the current directory to the src file.
3. To compile the source code run :  'Javac Billing.java' in src folder.
4. After compilation in src folder run : 'java Billing' or right click on Billing.java file and run the file.
5. Once you run the above command you would be asked to enter the input file path, there are 4 sample inputs provided in the resources folder.
6. NOTE : Before executing, please change the filepaths of 'itemfilepath, cardfilepath and outputfilepath' in  Billing.java file to the respective filepaths of cards.csv,items.csv available in resources folder in your local system. For output can give resources folder filepath available in your local system once you clone this repository.

## Design Patterns Used
### Singleton
* Singleton is a creational design pattern that lets you ensure that a class has only one instance, 
while providing a global access point to this instance.
Used this design pattern to create repository to store the incoming items and cards data of the application.
* Class Repository.java is the implementation of Singleton Design pattern.
* Every time a call to  Repository.getInstance() a same instance of Repository is returned.
![](file:///home/aishu/CMPE202/individual-project-aishwarya95698/singleton.png)




