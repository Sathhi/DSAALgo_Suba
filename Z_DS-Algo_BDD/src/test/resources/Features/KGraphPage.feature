
@LinkedListPage
Feature: user validates the Linked List Page
  
  Background: User  Login with  valid "username" and "password"
    When The user clicks the Get Started button  
    And user clicks on SignIn button he is directed to login page   
    When User enters valid username "sdet" and password "sdet1234"
    And User clicks on login button
    Then It should navigate to the home page with a message " You are logged in  "

  @pageverification
  Scenario: User selects the Graph item and verifies the Page Title 
    Given user is on Home Page
    And user clicks the Graph getstart link 
    Then user is on the Graph Page 
    Then user checks for the title "Graph" in the Graph page  
    
    @validpythoncode
  Scenario Outline: User checks each of the topics in Graph with valid python code
    Given user clicks the Graph getstart link 
    When The user select all option "<option>" from the graph page and Verifies the tryeditor Page with the valid python code for each option  "<sheetName>" and <Rownumber>     
    Then user should be presented with the run result in the screen "<outputresult>"
    Examples:
      | option                           | sheetName                | Rownumber|outputresult|
      | Graph                            | LLIntroduction           |   0      | hello world |
      | Graph Representations            | LLCLinkedList            |   0      | hello world |
    
    @invalidpythoncode
  Scenario Outline: User checks each of the topics in Graph with invalid python code
    Given user clicks the Graph getstart link 
    When The user select all option "<option>" and Verifies the tryeditor Page with the Invalid python code for each option  "<sheetName>" and <Rownumber>  in the graph page   
    Then user should get the "<erroroutput>" on the screen 
    
    Examples:
      |  option                            | sheetName                | Rownumber|erroroutput                       |
      |  Graph                             | LLIntroduction           |   1      |SyntaxError: bad input on line   |  
      |  Graph Representations             | LLCLinkedList            |   1      |SyntaxError: bad input on line  |
     
 