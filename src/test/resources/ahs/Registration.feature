
Feature: Verify the registration of the Appointment

@regression1
  Scenario Outline:Verify that user can register for Appointment
    Given "Superadmin" login into the application
    When user click on Registration link
    Then user should be on NEW USER REGISTER page
    And user verify the "Existing" button by click
    And user select gender "Female"
    And user enter <Name>,<Age>,<Ref.doctor>,<Mobile Number>,<EmailAddress> and <Address>
    And user enter available <date> and <time>
    And user select branch "Visakhapatnam"
    And user select Test HAEMATOLOGY
    And user Book the appointment
    Then user should navigate to appointment page
  Examples:
    | Name    | Age | Ref.doctor | Mobile Number | EmailAddress |Address| date        |time|
    |Lady gaga|35   |Darshan     |0123456789     |tedy@gmail.com|Harrow |19/March/2020|11:00|
    |Maddona  |40   |Umer        |0234567890     |anne@yahoo.com|Wembley|21/March/2020|12:30|

