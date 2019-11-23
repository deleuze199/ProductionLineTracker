
# Production Line Tracker
**Scenario**

You have been hired to create software for a media player production facility that will keep track of what products are produced. Without the software, workers on the production floor are physically producing items and having to write down what is produced in a production log book. Management would like the production tracking to be more automated so the workers don't need to spend as much time recording what was produced, the log will be more accurate, and it will be easier to generate production reports. In addition to the ability to record production, the software also needs the ability to add to the product line (the catalog of products that are able to be produced).
-   **Goals** (high level intended outcomes; for software, a Product Backlog)
    -  Allow a user to add new products that are able to be produced and store them in a collection.
    - The collection of products that can be produced can be displayed at any time.
    - Allow a user to track production of products, including specifying how many items of that product were created. The program will then create a record for each of these items and store them in a collection.
     - The collection of created items can be displayed at any time.
     - Production statistics can be displayed – Total items produced, number of each item type, the number of unique products created etc.
     -  Employee accounts can be made.
     - Allow easy modification to handle different products.
-   **Constraints** (externally imposed limitations on system requirements, design, or implementation or on the process used to develop or modify a system)
    -   The program will be a GUI database program written in Java.
    -   The program must be flexible to allow for future expansion.
    -   Code should be saved to a private GitHub repository.
    -   Follow best practices for style, documentation, and quality.
-   **Timelines** (a breakdown of the Product Backlog into time-bound smaller, more detailed tasks in Sprint Backlogs)
    -   Three 5-week sprints.

## Demonstration
Add Product to Tracker

![Sample GIF](docs/AddProductGif.gif)

Recording Production of Product

![Sample GIF](docs/RecordProductionGif.gif)

## Documentation

Create a docs folder in your project. If using Java, generate JavaDoc in your IDE. If using C++, use Doxygen. Change repository settings (using Settings at top of page) to use GitHub Pages with your docs folder. Add a link to the javadoc/doxygen index.html file with this markdown: \[Text to appear]\(URL) <br />
The URL will be YourGitHubUserName.github.io/YourRepositoryName/foldername/filename<br /> 
Do not include the docs folder name in your URL. <br />
Sample: \[JavaDoc]\(https://pv-cop.github.io/PV-README-TEMPLATE/javadoc/index.html) <br /> <br />
[JavaDoc](https://pv-cop.github.io/PV-README-TEMPLATE/javadoc/index.html)

## Diagrams

Class Diagram <br /> 
 ![Sample Image](docs/ClassDiagram.png)
 
 ## Built With

* IntelliJ IDEA  
* SceneBuilder

## Contributing

Create table in database to store employee information inorder to keep track of which employee edited to logs.

 
 ## Author
Benjamin Deleuze
 
 ## License

Public repositories on GitHub are often used to share open source software. For your repository to truly be open source, you'll need to license it so that others are free to use, change, and distribute the software. https://help.github.com/articles/licensing-a-repository/ <br />
You have the option to choose a license when you first create your repository. </br>
If you need to create a license for an existing repository...
1. Go to your repository.
2. Click on "Create new file" Button.
3. Type the file name as License.txt or License.md in the input box next to your repository name, a drop down button appears towards right side.
4. Choose the type of license of your choice.
5. Click "Commit new file" button at the bottom (Green button)
Credit https://stackoverflow.com/questions/31639059/how-to-add-license-to-an-existing-github-project <br />
To choose a license, see https://choosealicense.com/ 

## Acknowledgments

* Web sites utilized
* Classmates who helped
* Your professor or TA if they helped

## History

Information about what has changed. 

## Key Programming Concepts Utilized

This section would not necessarily be in a real README.  <br />
It is a reference for you and a place to impress potential employers with your knowledge. 
Identify what concepts you utilize so when you need to use them again you will know that you will find them here. Include a brief description of the concepts in your own words to help you prepare for related interview questions. 






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
