
Feature: Verify the Appointment Details

  @regression
  Scenario: Verify and edit the Appointment detail
    Given "Superadmin" login into the application
    When user click on "Appointment Details"
    And user select date range "01/December/2019" to "18/January/2020"
    And user select number of entry per page All
    Then user verify the appointment record by name "Lady gaga"
    And user search "131" and click on plus button to see the patient details
    And user cancel appointment by name "168"
    Then user should navigate to APPOINTMENTS DETAILS page
