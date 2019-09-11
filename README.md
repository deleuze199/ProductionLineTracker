
## 

Problem Statement

**Scenario**

You have been hired to create software for a media player production facility that will keep track of what products are produced.

Without the software, workers on the production floor are physically producing items and having to write down what is produced in a production log book.

Management would like the production tracking to be more automated so the workers don't need to spend as much time recording what was produced, the log will be more accurate, and it will be easier to generate production reports.

In addition to the ability to record production, the software also needs the ability to add to the product line (the catalog of products that are able to be produced).

-   **Goals** (high level intended outcomes; for software, a Product Backlog)
    -   Hypothetical / Real world
        1.  Allow a user to add new products that are able to be produced and store them in a collection.
        2.  The collection of products that can be produced can be displayed at any time.
        3.  Allow a user to track production of products, including specifying how many items of that product were created. The program will then create a record for each of these items and store them in a collection.
        4.  The collection of created items can be displayed at any time.
        5.  Production statistics can be displayed – Total items produced, number of each item type, the number of unique products created etc.
        6.  Employee accounts can be made.
        7.  Allow easy modification to handle different products.
    -   Actual / For class
        1.  Solidify understanding of object oriented programming.
        2.  Practice Java.
        3.  Learn basic graphical user interface (GUI) programming.
        4.  Learn basic database programming.
-   **Boundaries / Scope** (where the functions and responsibilities of the solution start and end / what it should do and what is left to other systems to do)
    -   Hypothetical / Real world
        -   For this particular production facility you will only need to track music and movie players.
        -   The program does not need the ability to place or fulfill orders / reduce stock, just track production.
    -   Actual / For class
        -   TBD
-   **Success criteria** (set of conditions to be satisfied at completion; must be measurable and verifiable, like a test)
    -   Hypothetical / Real world
        -   Pass tests (in repl.it)
        -   Follow rules for documentation, style, and coding conventions
    -   Actual / For class
        -   Grading forms / rubrics (in Canvas)
            -   Documentation (see below)
            -   Style (see below)
            -   Quality (see below)
            -   Assignment Specifications - include full project in your repository so your program can be easily imported and run.
        -   Creation of artifact for portfolio
-   **Constraints** (externally imposed limitations on system requirements, design, or implementation or on the process used to develop or modify a system)
    -   Hypothetical / Real world
        -   The program will be a GUI database program written in Java.
        -   The program must be flexible to allow for future expansion.
        -   Code should be saved to a private GitHub repository.
        -   Follow best practices for style, documentation, and quality.
    -   Actual / For class
        -   Communication and collaboration with classmates is allowed but should not extend to sharing actual code.
-   **Assumptions** (things that are accepted as true or as certain to happen, without proof)
    -   You like to program.
    -   You have foundational knowledge of programming from prerequisite courses.
    -   You will spend at least 4 hours per week on the project.
    -   The project should not require more than 7 hours per week. If so, contact the professor for assistance.
    -   This will help you be successful in future classes and your career.
-   **Stakeholders** (individuals or organizations having a right, share, claim, or interest in a system or in its possession of characteristics that meet their needs and expectations )
    -   Hypothetical / Real world
        -   CEO
        -   CTO
        -   CIO
        -   users
            -   production facility workers
            -   inventory managers
        -   customers
        -   I.T. support
    -   Actual / For class
        -   Yourself
        -   Future potential employers
        -   Professor
-   **Timelines** (a breakdown of the Product Backlog into time-bound smaller, more detailed tasks in Sprint Backlogs)
    -   Three 5-week sprints, detailed below.

## 

Sprint 1

_GUI, basic database_

**Week 1**

-   Create JavaFX project [IntelliJ Help](https://www.google.com/url?q=https%3A%2F%2Fwww.jetbrains.com%2Fhelp%2Fidea%2Fpreparing-for-javafx-application-development.html&sa=D&sntz=1&usg=AFQjCNGfhsMWgBGucMqbhHbov50HxK9IPA)
-   Share to private repository on GitHub
-   Create README, use [https://stackedit.io/](https://www.google.com/url?q=https%3A%2F%2Fstackedit.io%2F&sa=D&sntz=1&usg=AFQjCNHcaAbmEE6xgZ64etrya5GzDSOF4w), review markdown

**Week 2**

-   Add a tab view with three tabs: Product Line, Record Production, and Production Log
-   Quality expectations, Inspect code, FindBugs
-   Style expectations, Google Style, Formatter, CheckStyle
-   Javadoc and other documentation expectations

**Week 3**

-   Add a button to each tab
    -   For now, just have the button print to the console (System.out.println)

**Week 4**

-   Install database software if necessary
-   Create database
    -   Similar to...

```
create table Product
```

```
(
```

```
  id int auto_increment,
```

```
  name varchar,
```

```
  type varchar,
```

```
  manufacturer varchar
```

```
);
```

  

```
create unique index Product_id_uindex
```

```
  on Product (id);
```

  

```
alter table Product
```

```
  add constraint Product_pk
```

```
    primary key (id);
```

  

```
create table ProductionRecord
```

```
(
```

```
 production_num int auto_increment,
```

```
 product_id int,
```

```
 serial_num varchar,
```

```
 date_produced datetime
```

```
);
```

-   Connect to database SELECT

**Week 5**

-   Other database operations
-   Prepare for submission

## 

Sprint 2

**Week 6 Enum, Interface, Abstract Class**

**Issue 1 - Product**

All items will have a pre-set type. Currently there are 4 types. Create an enum called ItemType that will

store the following information.

_Type_

Audio

Visual

AudioMobile

VisualMobile

_Code_

AU

VI

AM

VM

Create a ComboBox to allow the user to select a type.

Create an interface called Item that will force all classes to implement the following functions.

-   A method getId that would return an int
-   A method setName that would have one String parameter
-   A method getName that would return a String
-   A method setManufacturer that would have one String parameter
-   A method getManufacturer that would return a String

Create an abstract type called Product that will implement the Item interface. Product will implement the basic functionality that all items on a production line should have. Add the following fields to Product

-   int id
-   String type
-   String manufacturer
-   String name

Complete the methods from the interface Item.

Add a constructor that will take in the name of the product and set this to the field variable name.

Add a toString method that will return the following: (example data shown).

```
Name: iPod
```

```
Manufacturer: Apple
```

```
Type: AM
```

Create a database table for Product.

To test the Product class, temporarily create a Widget class that extends Product. Store a created Widget object to the database and a productLine collection.

**Week 7 Inheritance**

**Issue 2 - AudioPlayer**

All of the items on this production line will have basic media controls. Create an interface called MultimediaControl that will define the following methods which don't need to return anything.

-   play()
-   stop()
-   previous()
-   next();

We require a concrete class that will allow us to capture the details of an audio player. Create a class called AudioPlayer that is a subclass of Product and implements the MultimediaControl interface.

The class will have 2 fields

-   String audioSpecification
-   String mediaType

Create a constructor that will take in 3 parameters – name, manufacturer, and audioSpecification.

The constructor should call its parents constructor and also setup the media type.

Implement the methods from the MultimediaControl interface by simply writing the action to the console.

E.g. in play `System.out.println("Playing");` Normally we would have code that would instruct the media player to play, but we will simply display a message.

Create a toString method that will display the superclass's toString method, but also add rows for Audio Spec and Type.

Create a driver class for AudioPlayer that will test to see whether we can instantiate occurrences of it, use the media controls and print out their details to the console.

**Week 8 Polymorphism**

**Issue 3 - Production**

Allow the user to record production of a given product. Create a Production class and table. The user should be able to input a quantity. Create a production record for each produced item. Set manufacturedOn as the current date and time. Store each record in a productionRun collection. Store the contents of the collection to a Production table in the database. Display the contents of the Production table in a TextView.

**Week 9 Polymorphism**

**Issue 4 - MoviePlayer**

The production facility will also create portable movie players. The main difference between these and the audio players is that they contain screens. Create an enum called MonitorType that will store

Type

LCD

LED

Create an interface called ScreenSpec. This will define 3 methods:

-   public String getResolution();
-   public int getRefreshRate();
-   public int getResponseTime();

Create a class called Screen that implements ScreenSpec. Add three fields

-   String resolution
-   int refreshrate
-   int responsetime

Complete the methods from the ScreenSpec interface.

Add a toString method that will return the details of the 3 field in the same format as the Product Class.

Create a Driver class for Screen that tests the functionality of the screen class.

Create a class called MoviePlayer that extends Product and implements MultimediaControl.

Add 2 fields to this class called screen and monitor type and assign appropriate types to them.

Complete the methods from the MultimediaControl interface in a similar fashion to the audio player.

Create a toString method that calls the product toString, displays the monitor and the screen details.

Create a diver class to test the functionality of the movie player.

**Week 10 Encapsulation**

**Issue 5 - MultimediaControl**

The audio players and the movie players share the same control interface on the physical devices. The control interface does not care if the device is a video player or an audio player. Create a driver class that will demonstrate that any class that implements the MultimediaControl Interface would be able to be instantiated and use its methods used no matter if it was an audio or movie player.

## 

Sprint 3

**Week 11 Lists and ArrayLists**

**Issue 6 - Sorting and Searching**

Add functionality to your classes that would allow them to be sorted by name with the Collections.sort method.

Add functionality to your user interface to show production based on factors like product type, manufacturer, name, etc.

**Week 12 Lambda Expressions**

**Issue 7 - EmployeeInfo**

The program is required to create an audit trail on its tests of the production line so that it records which employee ran the test. To accomplish this you will need to create a class named EmployeeInfo that will allow the user to input their full name and then create a user id of their first initial and surname.

The class will have 2 fields

-   StringBuilder name;
-   String code;

The class will have the following methods defined:

-   public StringBuilder getName()
-   public String getCode()
-   private void setName()
-   private void createEmployeeCode(StringBuilder name)
-   private String inputName()
-   private boolean checkName(StringBuilder name)

The setName() method will be called from the constructor which will use inputName() to get a name (firstname and surname) as a single input from the user before checkName() is used to make sure that the name supplied has a space in it.

If a valid name is given then createEmployeeCode() is used to take the first initial from the first name and add it to the full surname to create the code. If there is no space then default value of guest is to be used as the value for code.

In the TestProductionLine class create an employee object using the EmployeeInfo class. Using the getCode() method display the employee code at the bottom of the product output.

**Week 13 Strings, Regular Expressions**

**Issue 8 - deptId**

An additional piece of information is required to be produced for the auditing with the users department information being required as well. The department code is made up of four letters and two numbers.

The format of the department code is the first letter must be in uppercase with the following three all being lowercase and no spaces.

The following three fields need to be added to the EmployeeInfo class:

-   String deptId;
-   Pattern p;
-   Scanner in;

The following new methods have to be defined:

-   public String getDeptId()
-   private void setDeptId()
-   private String getId()
-   private boolean validId(String id)

As there will be multiple inputs across the class now the scanner will need to be declared and closed in the constructor. The pattern to control the format of the input will also have to be declared in the constructor. In between opening and closing the scanner, the constructor will need to not only get the name but also the deptId of the user.

setDeptId() will call getDeptId() to get the id from the user before validId() is used to check if the input matches the pattern. If the pattern matches then the given id is set to deptId otherwise a default value of None01 should be assigned.

As there are now two values to be displayed (code, deptId) create a toString() method that will override the output and allow you to simply display the value of the object to the screen.

Update the TestProductionLine class to use the toString() method to display the values to the console.

**Week 14 Recursion, Modules**

**Issue 9a - Reverse deptId**

To ensure that sensitive information is not leaked it is important that the information saved to file is encoded. To meet these regulations you need to add a method to the EmployeeInfo class that will reverse the order of the text stored for the department id. This should be done recursively using a method named reverseString().

The following new methods have to be defined:

-   public String reverseString(String id)

If a valid department id is provided then reverseString() should be called before assigning the user input to the deptId field.

**Issue 9b**

Create a method called print that would take your collection and list all of the contents. It should handle all of your classes.

**Week 15 Quality Review and Deployment**

**Optional Challenge**

Create a static method called printType in Product that will iterate through your Collection and print all the classes of a particular type.

Example – print only AudioPlayer classes in the collection.

For an extra bonus you could modify it so that it would accept the Class that you want to print in the parameter list. This way we could use it against classes that we have not yet built.

Limit the collection to only use subclasses of Product.

### 

Style Expectations

Follow the [Google Java Style Guide](http://www.google.com/url?q=http%3A%2F%2Fgoogle.github.io%2Fstyleguide%2Fjavaguide.html&sa=D&sntz=1&usg=AFQjCNHakVdNSKMqEclvyGSEv-wy6JmZwg)

Add the [_google-java-format_](https://www.google.com/url?q=https%3A%2F%2Fplugins.jetbrains.com%2Fplugin%2F8527-google-java-format&sa=D&sntz=1&usg=AFQjCNHY4KpNb6zwecQt0BLTLJDIaS2e7w) plugin or download the IntelliJ Java Google Style Guide from [https://github.com/google/styleguide](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2Fgoogle%2Fstyleguide&sa=D&sntz=1&usg=AFQjCNGSP_1ER9KklGr_QvyDuQd7WK0IIw), unzip it, then import it into IntelliJ through File -> Settings -> Code Style -> Scheme:

Use Ctrl + Alt + L to auto format.

When specified, name everything exactly as instructed.

When not specified, give descriptive names using proper [naming conventions](http://www.google.com/url?q=http%3A%2F%2Fgoogle.github.io%2Fstyleguide%2Fjavaguide.html%23s5-naming&sa=D&sntz=1&usg=AFQjCNEygKwCiLmaD44ibWqYkkfvYe3xMg).

Your code will be tested using the CheckStyle plugin. File -> Settings -> Plugins -> type checkstyle in search box -> click Search in repositories.

Once installed, you should see CheckStyle at the bottom left of the window. Click it. Choose Google Checks in the dropdown box for Rules. Click the button to Check Project.

Single blank lines between methods and where it improves readability. No multiple consecutive blank lines.

### 

Documentation Expectations

**Javadoc Comments**

Javadoc sytle comments for all java files that includes brief and author.

Javadoc comments for all classes, fields, and methods that includes brief, param, and return if applicable.

Include generated external Javadoc in final submission.

**README**

A README.md file on your repository root page containing information about the program. If your repository doesn't already have one, there is a button on the bottom of the page on GitHub to add one.

[https://github.com/PV-COP/PV-README-TEMPLATE](https://www.google.com/url?q=https%3A%2F%2Fgithub.com%2FPV-COP%2FPV-README-TEMPLATE&sa=D&sntz=1&usg=AFQjCNEYeDjzctP1h9RM_QegW_5f5y_oAg)

There are _Markdown_ and _Markdown Navigator_ plugins for IntelliJ

[Mastering Markdown](https://www.google.com/url?q=https%3A%2F%2Fguides.github.com%2Ffeatures%2Fmastering-markdown%2F&sa=D&sntz=1&usg=AFQjCNHAQkBDtGjVnGZjbA4dDzm9-FeBWQ)

**Other Comments**

Comments in code that describe non-obvious code.

Cite any resources used such as web sites, classmates, etc.

**Diagrams**

Add as images in README or as PDF files with links in README

-   Class Diagrams
    -   From the IntelliJ plugin (or StarUML)
    -   IntelliJ: Right click package folder -> Diagrams -> Show Diagram -> Java Class Diagrams
    -   If you don't have a package, add one by right clicking the src folder and choosing New -> Package then drag your .java files into it, leaving option boxes unchecked.
    -   If you don't see Diagrams...
        -   The plugin is available on Ultimate edition only.
    -   It is installed by default but if you don't have it you can add it through File -> Settings -> Plugins -> search UML Support.
    -   Save the diagram as an image, put the image in your README.
-   Database Visualization
    -   Right click database in Database tab -> Diagrams -> Show Visualization

### 

Quality Expectations

**Code Inspection**

In IntelliJ IDEA, Analyze -> Inspect Code should find no warnings.

**FindBugs**

FindBugs should find no bugs.

To add FindBugs to IntelliJ IDEA, click File -> Settings -> Plugins -> search findbugs in search box -> click Search in repositories.

Once installed, you should see FindBugs-IDEA at the bottom left of the window. Click it. Click the icon to Analyze Project Files. Fix bugs or, if it is something you were specified to do, add a comment to lines that are identified as bugs to acknowledge them.

**Other**

All code that could cause an exception is in a try.

### 

Program Specifications

**Sprint 1**

JavaFX program with database connectivity.

**Sprint 2**

Pass tests (repl.it assignments for Issues 1-5) and include associated functionality within JavaFX program.

Use the one time link to join the repl.it classroom on the Canvas course home page.

After enrolling, you can just login to [repl.it](http://www.google.com/url?q=http%3A%2F%2Frepl.it&sa=D&sntz=1&usg=AFQjCNHq4zOq8zjY9dKX0cwOTg2f9LnwUQ) to access.

**Sprint 3**

Pass all tests (repl.it asssignments for Issues 1-10) and include associated functionality within JavaFX program.

Satisfy all specifications on this page.

## 

Resources

**Step 1**

-   Declaring interfaces
    -   [Java - Interfaces](https://www.google.com/url?q=https%3A%2F%2Fwww.tutorialspoint.com%2Fjava%2Fjava_interfaces.htm&sa=D&sntz=1&usg=AFQjCNFgbby7R0aifb91_APeXmoW4s7HqA) tutorialspoint

**Step 2**

-   enum
    -   [Enum Types](https://www.google.com/url?q=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2FjavaOO%2Fenum.html&sa=D&sntz=1&usg=AFQjCNEqSBXgT_50iDGl7XnYvKFMBKDmRQ) The Java™ Tutorials

**Step 3**

-   Implementation of interfaces
    -   [Java - Interfaces](https://www.google.com/url?q=https%3A%2F%2Fwww.tutorialspoint.com%2Fjava%2Fjava_interfaces.htm&sa=D&sntz=1&usg=AFQjCNFgbby7R0aifb91_APeXmoW4s7HqA) tutorialspoint
-   Date / Time
    -   [Java - Date and Time](https://www.google.com/url?q=https%3A%2F%2Fwww.tutorialspoint.com%2Fjava%2Fjava_date_time.htm&sa=D&sntz=1&usg=AFQjCNEcQVovCGrTY2WXWUYyFU7o7j_gYQ) tutorialspoint
-   Output tab and newline
    -   [Characters](https://www.google.com/url?q=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2Fdata%2Fcharacters.html&sa=D&sntz=1&usg=AFQjCNFWrw1Yi0xvwn3zFLHagyJBsGClOA) The Java™ Tutorials

  

-   [String formatting cheat sheet](https://www.google.com/url?q=https%3A%2F%2Falvinalexander.com%2Fprogramming%2Fprintf-format-cheat-sheet&sa=D&sntz=1&usg=AFQjCNH3LIs1TE6bYzyhzdpRcLVBq19x8Q)
-   [Escape sequences](https://www.google.com/url?q=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2Ftutorial%2Fjava%2Fdata%2Fcharacters.html&sa=D&sntz=1&usg=AFQjCNFWrw1Yi0xvwn3zFLHagyJBsGClOA)
