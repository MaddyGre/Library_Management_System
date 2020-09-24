# Library_Management_System
This repository contains the code for a library management system
## The STEM Library - Management System
> The application consists of a library management system dedicated to STEM subjects only. The main Object of the application is the administrator. The system allows the administrator to log into the online library, provide his details for registration, and finally perform CRUD operations (adding, updating, deleting a new book to the online library). 
## MOTIVATION
> This project exists to demonstrate my commitment and passion to become a better programmer and problem-solver. I am passionate about reading and I also have a degree in a STEM subject (which is Computer science). I therefore created an online library because I wanted to do something that resembled some of my interests and combined that with my willingness to improve my coding skills. 
## PREREQUISITES
>Before you continue, you will need JDK, MySQL JDBC Connector and Eclipse IDE.

- JDK for Windows Operating System: https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-61460339-5500-40CC-9006-D4FC3FBCFC0D
- JDK for Mac OS Operating System: https://docs.oracle.com/en/java/javase/13/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE
- JDK for Linux Operating System: 
https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8
- MySQL: https://dev.mysql.com/downloads/connector/j/
- Eclipse IDE: https://www.eclipse.org/downloads/
## VISUALS

![image](https://user-images.githubusercontent.com/45042001/94151855-ca2e9a00-fe72-11ea-969f-2aa076b40e8f.png)

![image](https://user-images.githubusercontent.com/45042001/94151916-de729700-fe72-11ea-9e1e-2210d5da4ed5.png)

![image](https://user-images.githubusercontent.com/45042001/94151956-ea5e5900-fe72-11ea-99dc-88d64dfd1f3f.png)

![image](https://user-images.githubusercontent.com/45042001/94151993-f8ac7500-fe72-11ea-8001-4302190313a7.png)

![image](https://user-images.githubusercontent.com/45042001/94152092-1a0d6100-fe73-11ea-98f3-7f25e4da4aaa.png)

![image](https://user-images.githubusercontent.com/45042001/94152141-25f92300-fe73-11ea-97d5-a73c5ee17a95.png)

![image](https://user-images.githubusercontent.com/45042001/94152185-31e4e500-fe73-11ea-8307-9dc466c1410f.png)

![image](https://user-images.githubusercontent.com/45042001/94152222-3d381080-fe73-11ea-8e47-474eaa2a5384.png)

![image](https://user-images.githubusercontent.com/45042001/94152274-4923d280-fe73-11ea-8037-bb20fda97a8d.png)

![image](https://user-images.githubusercontent.com/45042001/94152319-52ad3a80-fe73-11ea-8b0f-fde7d3c79c71.png)

## FUNCTIONAL REQUIREMENTS

- The background colour for all windows in the application will be light green and have Georgia as the predominant font. 
- The system validates the administrator details against the database’s information.
- The system should allow the administrator to add a new book
- The system should allow the administrator to update an existing book
- The system should allow the administrator to delete an existing book
- The system  should allow the administrator to view all books available. 

## NON-FUNCTIONAL REQUIREMENTS

- The system should be able to handle expected and unexpected exceptions.
- The system should be able to load fast and accurately.

## FEATURES
> The project performs form validation. 

When the user attempts to login, the password is validated against the database. If it doesn’t match, he won’t be able to successfully login. In addition, text fields such as “Name”, “Surname” only accept alphabets, the user cannot enter any digit number. On the contrary, the “Phone number” text field can only up to 10 digit numbers and the user is unable to enter any alphabet. All fields must be filled, otherwise submission would be unsuccessful. 

The purpose of the form validation is needed as a security measure and to prevent any SQL injection attack. 

## FUTURE IMPROVEMENTS/ADDITIONAL FEATURES
> The system can definitely be improved and some extra features can be added. 

Some improvements that I would implement is a better method of authentication through inline validation. For example, if the user enters a wrong email address, the system should be able to immediately notify the administrator that the email he has entered doesn’t follow the correct format. In addition, the system should not allow any duplicate name, surname or userID. 

Extra features that can be added are a search/filter bar that allows the administrator to filter the data by its author, title, subject, language or publisher. I would also add a reset password method (which at the moment hasn’t been implemented), that allows the administrator to recover his password. He would be sent an email with a random-generated code that he has to enter and then subsequently force him to change his password.

## LEARNING OUTCOMES
> The most important skills that I acquired when developing this application is the importance of knowing how to __debug__ and __troubleshoot__ software problems. I frequently came across bugs and issues and encountered unexpected problems. 

The first step that I took was to pause for a minute and ask myself what I expected the code to do and what happened instead. From there, I would gather all my assumptions and start testing different solutions that could possibly solve a problem. 

An example of this was when I was working on the UPDATE button and the program failed to update the record and wasn’t throwing any exception. In order to overcome this issue I inserted a series of print statements to understand the flow of the program and how the data changed before and after the update statement. This allowed me to overcome this software issue. 














