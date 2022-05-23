#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@AddPlace
Feature: Verify add place ,get place and delete place

  Scenario Outline: Verify add place ,get place and delete place
    Given Add place with payload with "<name>" "<address>" "<language>"
    When user calls "AddPlaceAPI" with http "POST" method
    Then  get the "place_id" from response body
    And user calls "GetPlaceAPI" to verify details of place like "<name>" "<address>" "<language>"
    And user call "DeletePlaceAPI" with http "DELETE" method to delete "place_id"
    Examples: 
      | name     | address | language |
      | Pasaydan | Kaman   | Marathi  |
