package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameLocator;

    @FindBy(id="middleName")
    public WebElement middleNameLocator;

    @FindBy(id="lastName")
    public WebElement lastNameLocator;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    @FindBy(id="personal_txtEmployeeId")
    public WebElement employeeId;

    @FindBy(id = "employeeId")
    public  WebElement addEmpId;

    @FindBy(id = "pdMainContainer")
    public WebElement saveSuccess;

    @FindBy(xpath = "(//span[contains(text(),'Required')])[1]")
    public WebElement firstNameError;

    @FindBy(xpath = "(//span[contains(text(),'Required')])[1]")
    public WebElement lastNameError;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

}
