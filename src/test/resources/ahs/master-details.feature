@master
Feature: Verify the master details of the super admin
  Background:
Given "Superadmin" login into the application
When admin click on master link

@master1
  Scenario Outline: Verify admin can create users with positive data
    When admin navigate to User details
    And create a new user "<Name>","<Mobile Number>","<EmailID>","<Password>","<UserType>" and "<Branch Name>"
    And the user should be created successfully
    Then admin should navigate to user detail page
    Then admin should see the record with Name "test1"
    Examples:
      | Name | Mobile Number | EmailID         | Password | UserType | Branch Name   |
      | test1 | 1234567811      | test@test12.com | London121 | Admin    | Vishakhapatnam|

  @master2
  Scenario Outline: Verify admin can create users with negative data,edit and delete user
    When admin navigate to User details
    And create a new user "<Name>","<Mobile Number>","<EmailID>","<Password>","<UserType>" and "<Branch Name>"
    Then admin should see the error message for duplicate data
    And admin should click on cancel button
    And admin should edit available user <Name> detail
    And admin should delete available user <Name> detail
    When admin enter deleted user <Name> by search
    Then admin should see the display message
    Examples:
     | Name | Mobile Number | EmailID         | Password | UserType | Branch Name   |
     | Test1 | 1234567811      | test@test12.com | London121 | Admin    | Vishakhapatnam|

  @master3
  Scenario: Verify admin can add sub test name and validate in sub test price list
    When admin navigate to sub test link
    Then admin should be on SUB TEST PRICE LIST page
    And admin click on add new button to add sub test
    Then admin should be on ADD SUBTEST NAME page
    And admin enter test name "Uren" and price "200"
    And admin enter Age,Unit,Male Interval,feMale Interval data in table
      |0-1   |2-6   |11-14        |9-11           |
      |2-10  |2-7   |15-16        |7-18           |
      |11-30 |3-4   |17-19        |11-20          |
      |30-60 |5-10  |29-50        |19-25          |
      |60-100|11-15 |22-99        |20-30          |
    And admin should click on submit button
    Then admin should return to SUB TEST PRICE LIST page
    And admin click on delete button
    Then admin should see the error massage

  @master4
    Scenario: Verify admin can create group test
      When admin click on group test
      Then admin should be on GROUP TEST NAMES page
      And admin click on Add New sign to add new group test name
      And admin can able to change entries
      And admin use page button to see next entries
      And admin search group test name from the table "TB3"
      Then admin should found the group test name "Arthritis Packages" from table
      Then admin should able to change status of the group test name

  @master5
  Scenario: Verify admin can create and validate assign group test
      When admin navigate to assign group test
      Then admin should should be on ASSIGN GROUPTEST LIST page
      And admin create assign group test and add to list
      Then admin should able to verify the added sub test name "Urea" from the list
      And admin should able to delete the test from the list