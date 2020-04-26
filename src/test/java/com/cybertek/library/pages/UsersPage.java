package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

    @FindBy(css = ".btn.btn-lg")
    public WebElement addUsersButton;

    @FindBy(css = "#start_date>input")
    public WebElement startDate;

    @FindBy(css = "#end_date>input")
    public WebElement endDate;
}
