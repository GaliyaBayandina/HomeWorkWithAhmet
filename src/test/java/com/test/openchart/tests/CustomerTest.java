package com.test.openchart.tests;

import com.test.openchart.pages.CustomersPage;
import com.test.openchart.pages.MainPage;
import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.annotations.Test;

public class CustomerTest extends  OpenChartTestBase{
    @Test
    public  void addCustomerFunctionality () throws InterruptedException {

        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("demo","demo");
        Thread.sleep(1000);
        CustomersPage customersPage= new CustomersPage(driver);
        MainPage mainPage= new MainPage(driver);

        mainPage.GetToCustomersPage();
        customersPage.AddClickCustomer();
        customersPage.ProvideCustomerInformation(driver,"Galiya","Bayandina","bayandinagaliya362@gmail.com",
        "Galiya1974","Galiya1974");


    }
}
