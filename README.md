# SyncProject
First Use Spring Initializr Which provides an extensible API for JVM-based projects.In this Project I have added  ten Dependeicies which
are Lombok,Spring Data jpa,SpringBoot DevTools,MySql Driver,Spring Web, and Some Anothers.Then Import This Project in Spring
Tool Suite 4.14 .

After Import I Give All Connection Link In Application.Properties File like Server port Number,DataBase Name Which I created in Mysql
database,then User Id and Password and many more. 

Then I Created Different Packages For Different Class.First I create Model Package and inside Model Package I create Entity Class
where I used @Entity Annotatation so that Jvm Will be Consider it as Entity Class.Then I used @Table Annotation Which create Table
in MySql Database with given name.Then I created eleven Variable Which Represent Column Name in Mysql database.@Id Variable is Auto
Generated and Primary Key in Table. 

Then I created Controller Package and inside Controller Package I create Controller Class and used @RestController.In controller Class 
First AutoWired Service Class Then Created Three Apis. First Api is for Adding Some Data into CSV File at the Last Row.For That I am 
Using @RequestMapping and give "/addDataInCsvFile" Api Url to ckeck by Postman.First Method or First Api Call the Service class 
addDataInCsvFile().While Second Api use Delete Mapping To Delete The Data From Csv File By Id.It is Calling Service Class 
deleteDataFromCSVById(id) for deleting Data.We Are getting Id from The Postman.User Which Row want to delete He can be Delete
 And In The Last Api is PostMapping  which Called The Service Class addAllCSVDataIntoDatabase() which Read All Data From CSV File
 and Save them into DataBase.It's Not Required at Present Time Because This method is Run in every Two  Minutes But In future If we 
want to run only When we Call that time it will be Used.

In Service Class Used @Service for Indicate that this is Service Class. then Create String variable line and give our filepath to String 
filepath variable.In addDataInCsvFile() , Instantiating the CSVWriter Class with FileWriter and Filepath and Boolend Append Value true 
and then Creating Three String Array with data and adding those data into Csv File With the help of writeNext().Data is save in the Csv
File and In the Last Close the CSVWriter.

In Service Class deleteDataFromCSVById(id)  method we are Recived id From the Controller then Instantiating the CSVReader Class 
and creating list String Array and reading all Data from Csv File then Removing data from CSV File By Given Id From the postman.
then Instantiating the FileWriter Class With our filepath and give fileWriter Variable name to CSVWriter and then use writeAll Method 
to add Updated Data Into CSV File and Then Close CSVWriter.

In Service Class addAllCSVDataIntoDatabase Method I used Cron JOb For Scheduling. This method Will be run in Every Two Minutes.
then Initiating the BufferReader Class with FilePAth then Initiating the CSVParser and giving BufferReader Variable and CSV Format
then Creating SyncEntity List and Create Itrable with CSVRecords and getting all records in itrable Variable.then create For Each loop
for copying all data from CSVRecord and adding those data into CSVEntity By Constructor.then Adding SyncEntity data into ListEntity.
it is running in loop and all Data is Added into ListEntity. after Loop We Call deleteAll Method So that our database will be clean and
updated data not be added into next line of Previous Data.Only updated Data will be Avaliable into DataBase not Previous and present 
data.then call saveAll Method Which will be save the listEntity data into DataBase.

In Repository Package I create Repository Interface Which Extends The JpaRepository and We are Giving SyncEntity class and our 
id Type Which is Int so We Give Integer.I used @Repository Annotation For denoting that this is Repository Interface.

In the Last I checked Every Apis By PostMan and Every Api Is Working Good. I have Decrese the CSV file data because It Taking Too
time to upload i have tested on that file also.Everyathing Working Properly.

Thanks For Giving Such a wonderFull Task. I hope You Will be Like My Work.

