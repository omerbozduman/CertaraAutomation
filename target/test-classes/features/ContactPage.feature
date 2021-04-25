@contact
Feature: Contact Page

  As an user I want to contact with the Certara

  @positive
  Scenario: verify contact Certara form with valid credentials
    Given I open the certara website
    Then I navigate to "Contact" page
    And I verify "Contact Certara" is displayed
    Then I fill out the form with valid credentials
    And I click Contact Us button
    Then I verify "Thank You!" message is displayed


  @negative
  Scenario Outline: verify contact Certara form with invalid credentials. <type>
    Given I open the certara website
    Then I navigate to "Contact" page
    And I verify "Contact Certara" is displayed
    Then I fill out the form with below informations "<firstName>", "<lastName>", "<emailAddress>", "<organization>" "<topicOfInterest>"
    And I click Contact Us button
    Then I verify related "<errorMessage>" is displayed


    Examples:
      | type                       | firstName | lastName | emailAddress   | organization | topicOfInterest          | errorMessage            |
      | first name is blank        |           | Applesed | me@example.com | Apple        | Evidence, Value & Access | This field is required. |
      | last name is blank         | Jane      |          | me@example.com | Apple        | Evidence, Value & Access | This field is required. |
      | email is blank             | Jane      | Applesed |                | Apple        | Evidence, Value & Access | Must be valid email.    |
      | email is without @         | Jane      | Applesed | meexample.com  | Apple        | Evidence, Value & Access | Must be valid email.    |
      | email is without .com      | Jane      | Applesed | me@example     | Apple        | Evidence, Value & Access | Invalid Input           |
      | organization is blank      | Jane      | Applesed | me@example.com |              | Evidence, Value & Access | This field is required. |
      | topic of interest is blank | Jane      | Applesed | me@example.com | Apple        |                          | This field is required. |




