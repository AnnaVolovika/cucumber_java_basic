@regression
Feature: Anna Volovika Task 2


 Scenario: Enter new person
 Given I am on the basepage
 When I click Add
 And I enter new name
 And I enter new surname
 And I enter new job
 And I enter new dob
 And I enter new language
 And I enter new gender
 And I enter new status
 And I click add button
 Then Person is added

 Scenario: Edit a person
  Given I am on the basepage
  When I click pencil
  And I edit surname
  And I press edit button
  Then I see edited person

  Scenario: Remove a person
   Given I am on the basepage
   When I click cross
   Then I do not see a person

   Scenario: Enter new person and reset
    Given I am on the basepage
    When I click Add
    And I enter new name
    And I enter new surname
    And I enter new job
    And I enter new dob
    And I enter new language
    And I enter new gender
    And I enter new status
    And I click add button
    And Person is added
    And I press reset list
    Then I do not see a new person

    Scenario: Edit a person and reset
     Given I am on the basepage
     When I click pencil
     And I edit surname
     And I press edit button
     And I see edited person
     And I press reset list
     Then I do not see edited person

    Scenario: Remove a person and reset
     Given I am on the basepage
     When I click cross
     And I do not see a person
     And I press reset list
     Then I see a deleted person

    Scenario: Enter new person and clear
      Given I am on the basepage
      When I click Add
      And I enter new name
      And I enter new surname
      And I enter new job
      And I enter new dob
      And I enter new language
      And I enter new gender
      And I enter new status
      And I click clear button
     Then Person form is empty