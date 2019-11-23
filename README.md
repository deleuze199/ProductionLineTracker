
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

* https://www.w3schools.com/sql/
* Classmates who helped
* Your professor or TA if they helped

## Key Programming Concepts Utilized

This section would not necessarily be in a real README.  <br />
It is a reference for you and a place to impress potential employers with your knowledge. 
Identify what concepts you utilize so when you need to use them again you will know that you will find them here. Include a brief description of the concepts in your own words to help you prepare for related interview questions. 

