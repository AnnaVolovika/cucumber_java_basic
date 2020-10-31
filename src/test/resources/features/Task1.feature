@regression
Feature: Anna Volovika Task 1

  @debugs
  Scenario Outline: Insert test
    Given I navigate to base page
    When I enter the text: "<text>"
    And I click submit input text
    Then I see a message: "<message>"
  @working
    Examples:
      | text | message               |
      | 35   | Number is too small   |
      | 500  | Number is too big     |
      | abcd | Please enter a number |
  @not_working
    Examples:
      | text | message               |
      | 81   | Square root of 81 is 9.00   |
      | 60   | Square root of 60 is 7.75   |



