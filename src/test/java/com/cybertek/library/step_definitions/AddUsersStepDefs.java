package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashBoardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AddUsersStepDefs {
    LoginPage loginPage= new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    UsersPage usersPage = new UsersPage();
    LocalDate localDate= LocalDate.now();

    @Given("I access Users page as a librarian")
    public void i_access_Users_page_as_a_librarian() {

        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

        String email = ConfigurationReader.getProperty("librarian_email");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.login(email, password);

        dashBoardPage.users.click();

    }

    @When("I click on Add User")
    public void i_click_on_Add_User() {
        usersPage.addUsersButton.click();
    }

    @Then("start date should be today's date")
    public void start_date_should_be_today_s_date() {
        assertEquals(usersPage.startDate.getAttribute("value"), localDate.toString());
    }

    @Then("end date should be one month from today")
    public void end_date_should_be_one_month_from_today() {
        String endDateActual = usersPage.endDate.getAttribute("value");
        String currentDate =localDate.toString();
        String endDateExpected;
        if(localDate.getMonthValue()<10) {
            endDateExpected = currentDate.substring(0,5)+ 0 +(localDate.getMonthValue()+1) + currentDate.substring(7);
        }else if(localDate.getMonthValue()==11){
            endDateExpected = currentDate.substring(0,5) +(localDate.getMonthValue()+1) + currentDate.substring(7);
        }else{
            endDateExpected = currentDate.substring(0,5) + 01 + currentDate.substring(7);
        }

        assertEquals(endDateExpected, endDateActual);
    }
}
