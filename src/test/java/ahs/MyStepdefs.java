package ahs;

import ahs.pageObjects.*;
import ahs.support.BrowserFactory;
import ahs.support.Utilites;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class MyStepdefs {
    LoginPageObject loginPageObject;
    MasterPageObject masterPageObject;
    MasterPageObject_AssignGroupTest masterPageObject_AGT;
    MasterPageObject_SubTest masterPageObject_subTest;
    RegisterPageObject registerPageObject;
    AppointmentsPageObject appointmentsPageObject;
    MasterPageObject_user masterPageObjectUser;


//===================master  user detail=========================suresh

    @Given("^\"([^\"]*)\" login into the application$")
    public void something_logs_into_the_application(String user) throws Throwable {
        loginPageObject = new LoginPageObject();
        loginPageObject.login(user);
        Utilites.waitFor(10);
    }
    @When("^admin click on master link$")
    public void admin_click_on_master_link() throws Throwable {
        masterPageObject=new MasterPageObject();
        masterPageObject.validateMasterLink();
    }
    @When("^admin navigate to User details$")
    public void admin_navigate_to_user_details() throws Throwable {
        masterPageObjectUser =new MasterPageObject_user();
        masterPageObjectUser.validateUserTab();
    }
    @And("^create a new user \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void create_a_new_user_somethingsomethingsomethingsomethingsomething_and_something
            (String name, String mobilenumber, String emailid, String password, String userType, String branch) throws Throwable {
        masterPageObjectUser.inputDetail(name,mobilenumber,emailid,password,userType,branch);
    }
    @Then("^the user should be created successfully$")
    public void the_user_should_be_created_successfully() throws Throwable {
        masterPageObjectUser.submitButton();
    }
    @Then("^admin should navigate to user detail page$")
    public void admin_should_navigate_to_user_detail_page() throws Throwable {
        String text=masterPageObjectUser.pageText();
        Assert.assertEquals(text,"USER DETAILS");
    }
    @Then("^admin should see the record with Name \"([^\"]*)\"$")
    public void admin_should_see_the_record_with_name_something(String strArg1) throws Throwable {
        boolean text=masterPageObjectUser.verifyUserDetailsInList(strArg1);
        Assert.assertTrue(text);
    }
    @Then("^admin should see the error message for duplicate data$")
    public void admin_should_see_the_error_message_for_duplicate_data() throws Throwable {
        boolean errorMessage=masterPageObjectUser.verifyErrorMessage();
        Assert.assertTrue(errorMessage);
    }
    @And("^admin should click on cancel button$")
    public void admin_should_click_on_cancel_button() throws Throwable {
        masterPageObjectUser.cancelButton();
    }
    @And("^admin should edit available user (.+) detail$")
    public void admin_should_edit_available_user_detail(String name) throws Throwable {
        masterPageObjectUser.editDetail(name);
    }
    @And("^admin should delete available user (.+) detail$")
    public void admin_should_delete_available_user_detail(String name) throws Throwable {
        masterPageObjectUser.deleteDetail(name);
    }
    @When("^admin enter deleted user (.+) by search$")
    public void admin_enter_deleted_user_by_search(String name) throws Throwable {
        masterPageObjectUser.searchDeletedName(name);
    }
    @Then("^admin should see the display message$")
    public void admin_should_see_the_display_message() throws Throwable {
        boolean message=masterPageObjectUser.verifyDisplayMessage1();
        Assert.assertTrue(message);
    }

    //========master group test features step- def=========================suresh==

    @When("^admin click on group test$")
    public void admin_click_on_group_test() throws Throwable {
        masterPageObject.validateGroupTest();
    }
    @Then("^admin should be on GROUP TEST NAMES page$")
    public void admin_should_be_on_group_test_names_page() throws Throwable {
        String text=masterPageObject.validatePageText();
        Assert.assertEquals(text,"GROUP TEST NAMES");
    }
    @And("^admin click on Add New sign to add new group test name$")
    public void admin_click_on_add_new_sign_to_add_new_group_test_name() throws Throwable {
        masterPageObject.validateAddnewButton();
        masterPageObject.validateGroupTestNameBox();
    }
    @And("^admin can able to change entries$")
    public void admin_can_able_to_change_entries() throws Throwable {
        masterPageObject.validateNameEntry();
    }
    @And("^admin use page button to see next entries$")
    public void admin_use_page_button_to_see_next_entries() throws Throwable {
        masterPageObject.validateNextPageSign();
        masterPageObject.validatePreviousPageSign();
        masterPageObject.validatePageNumber();
    }
    @And("^admin search group test name from the table \"([^\"]*)\"$")
    public void admin_search_group_test_name_from_the_table_something(String name) throws Throwable {
        masterPageObject.validateSearchBox(name);
    }
    @Then("^admin should found the group test name \"([^\"]*)\" from table$")
    public void admin_should_found_the_group_test_name_something_from_table(String testName) throws Throwable {
        boolean presentTestNamed=masterPageObject.searchGroupTestByName(testName);
        Assert.assertTrue(presentTestNamed);
    }
    @Then("^admin should able to change status of the group test name$")
    public void admin_should_able_to_change_status_of_the_group_test_name() throws Throwable {
        boolean nameStatus=masterPageObject.changeGroupTestNameStatus();
        Assert.assertTrue("Inactive",true);
    }

    //=============assignGroupTest========================suresh

    @When("^admin navigate to assign group test$")
    public void admin_navigate_to_assign_group_test() throws Throwable {
        masterPageObject_AGT=new MasterPageObject_AssignGroupTest();
        masterPageObject_AGT.validateAssignGroupTest();
    }
    @Then("^admin should should be on ASSIGN GROUPTEST LIST page$")
    public void admin_should_shold_be_on_assign_grouptest_list_page() throws Throwable {
        boolean text=masterPageObject_AGT.verifyPageText();
        Assert.assertTrue(text);
    }
    @And("^admin create assign group test and add to list$")
    public void admin_create_assign_group_test_and_add_to_list() throws Throwable {
        masterPageObject_AGT.validateTestAddBtn();
        masterPageObject_AGT.validateAddTestBox();
    }
    @Then("^admin should able to verify the added sub test name \"([^\"]*)\" from the list$")
    public void admin_should_able_to_verify_the_added_sub_test_name_something_from_the_list(String subtest) throws Throwable {
        boolean text=masterPageObject_AGT.varifyTestNameInTestList(subtest);
        Assert.assertTrue(text);
    }
    @And("^admin should able to delete the test from the list$")
    public void admin_should_able_to_delete_the_test_from_the_list() throws Throwable {
       masterPageObject_AGT.deleteAddedTest();
    }

    //========================subtest=========================================suresh

    @When("^admin navigate to sub test link$")
    public void admin_navigate_to_sub_test_link() throws Throwable {
        masterPageObject_subTest=new MasterPageObject_SubTest();
        masterPageObject_subTest.validateSubTest();
    }
    @Then("^admin should be on SUB TEST PRICE LIST page$")
    public void admin_should_be_on_sub_test_price_list_page() throws Throwable {
        String msg=masterPageObject_subTest.verifyPageText();
        Assert.assertEquals(msg,"SUB TEST PRICE LIST");
    }
    @And("^admin click on add new button to add sub test$")
    public void admin_click_on_add_new_button_to_add_sub_test() throws Throwable {
        masterPageObject_subTest.validateAddButton();
    }
    @Then("^admin should be on ADD SUBTEST NAME page$")
    public void admin_should_be_on_add_subtest_name_page() throws Throwable {
       String subTestPage =masterPageObject_subTest.verifySubTestPage();
       Assert.assertEquals(subTestPage,"ADD SUBTEST NAME");
    }
    @And("^admin enter test name \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void admin_enter_test_name_something_and_price_something(String subtest, String price) throws Throwable {
        masterPageObject_subTest.addDetailsInMainTest(subtest, price);
    }
    @And("^admin enter Age,Unit,Male Interval,feMale Interval data in table$")
    public void admin_enter_ageunitmale_intervalfemale_interval_data_in_table(DataTable data) throws Throwable {
        masterPageObject_subTest.enterDataToTable(data);
    }
    @And("^admin should click on submit button$")
    public void admin_should_click_on_submit_button() throws Throwable {
        masterPageObject_subTest.validateSubmiteBtn();
    }
    @Then("^admin should return to SUB TEST PRICE LIST page$")
    public void admin_should_retuen_to_sub_test_price_list_page() throws Throwable {
        String url=masterPageObject_subTest.validateReturnPage();
        Assert.assertEquals(url,"http://ahs.bananaapps.co.uk/Master/SubTestPricesList");
    }
    @And("^admin click on delete button$")
    public void admin_click_on_delete_button() throws Throwable {
        masterPageObject_subTest.useDeleteButton();
    }
    @Then("^admin should see the error massage$")
    public void admin_should_see_the_error_massage() throws Throwable {
        String errorMasg= masterPageObject_subTest.validateErrorMsg();
        Assert.assertEquals(errorMasg,"×\n" +
                "Oops!Unable to delete");
    }



    //==================registration===================================suresh

    @When("^user click on Registration link$")
    public void user_click_on_Registration_link() throws Throwable {
        registerPageObject=new RegisterPageObject();
        registerPageObject.validateRegisterLink();
    }
    @Then("^user should be on NEW USER REGISTER page$")
    public void user_should_be_on_new_user_register_page() throws Throwable {
        String text=registerPageObject.validateInnerText();
        Assert.assertEquals(text,"NEW USER REGISTER");
    }
    @And("^user verify the \"([^\"]*)\" button by click$")
    public void user_verify_the_something_button_by_click(String status) throws Throwable {
        registerPageObject.select_Status(status);
    }
    @And("^user select gender \"([^\"]*)\"$")
    public void user_select_gender_something(String gender) throws Throwable {
        registerPageObject.genderSelection(gender);
    }
    @And("^user enter (.+),(.+),(.+),(.+),(.+) and (.+)$")
    public void user_enter_and(String name, String age, String refdoctor, String mobilenumber, String emailaddress, String address) throws Throwable {
        registerPageObject.enterValidDetail(name,age,refdoctor,mobilenumber,emailaddress,address);
    }
    @And("^user enter available (.+) and (.+)$")
    public void user_enter_available_and(String date, String time) throws Throwable {
       registerPageObject.selectDate(date);
       registerPageObject.selectTime(time);
    }
    @And("^user select branch \"([^\"]*)\"$")
    public void user_select_branch_something(String branch) throws Throwable {
        registerPageObject.appointmentBranch(branch);
    }
    @And("^user select Test HAEMATOLOGY$")
    public void user_select_test_haematology() throws Throwable {
        registerPageObject.selectTest();
    }
    @And("^user Book the appointment$")
    public void user_book_the_appointment() throws Throwable {
       appointmentsPageObject=registerPageObject.confirmBooking();
    }
    @Then("^user should navigate to appointment page$")
    public void user_should_navigate_to_appointment_page() throws Throwable {
        String text=registerPageObject.verifyReturnPge();
        Assert.assertEquals(text,"APPOINTMENTS DETAILS");
    }

    //========================Appointment======================suresh===============

    @When("^user click on \"([^\"]*)\"$")
    public void user_click_on_something(String Appointment_page) throws Throwable {
        appointmentsPageObject=new AppointmentsPageObject();
        appointmentsPageObject.validateAppoinmentLink(Appointment_page);
    }
    @And("^user select date range \"([^\"]*)\" to \"([^\"]*)\"$")
    public void user_select_date_range_something_to_something(String fromDate, String toDate) throws Throwable {
         appointmentsPageObject.enterDateRange(fromDate,toDate);
    }
    @And("^user select number of entry per page All$")
    public void user_select_number_of_entry_per_page_All() throws Throwable {
        appointmentsPageObject.validateEntryFunction();
    }
    @Then("^user verify the appointment record by name \"([^\"]*)\"$")
    public void user_verify_the_appointment_record_by_name_something(String name) throws Throwable {
        boolean text=appointmentsPageObject.verifyPatientEntry(name);
        Assert.assertTrue(text);
    }
    @And("^user search \"([^\"]*)\" and click on plus button to see the patient details$")
    public void user_search_something_and_click_on_plus_button_to_see_the_patient_details(String name) throws Throwable {
     appointmentsPageObject.searchEntry(name);
    }
    @And("^user cancel appointment by name \"([^\"]*)\"$")
    public void user_cancel_appointment_by_name_something(String name) throws Throwable {
           appointmentsPageObject.verifyCancelAction(name);
    }
    @Then("^user should navigate to APPOINTMENTS DETAILS page$")
    public void user_should_navigate_to_appointments_details_page() throws Throwable {
        String text=appointmentsPageObject.verifyReturnPge();
        Assert.assertEquals(text,"APPOINTMENTS DETAILS");
    }
}
