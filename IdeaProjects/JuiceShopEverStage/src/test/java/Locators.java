import lombok.Getter;


public final class Locators {
    private Locators(){}

    @Getter private static final String BASE_BUTTON="//span[contains(text(),'%s')]//ancestor::button";
    @Getter private static final String LOGIN_EMAIL="//input[@id='email']";
    @Getter private static final String LOGIN_PASSWORD="//input[@id='password']";
    @Getter private static final String LOGIN_BUTTON="//button[@id='loginButton']";
    @Getter private static final String BUTTON_ME_WANT_IT="//div[@role='dialog']//descendant::a[contains(text(),'Me want it')]";
    @Getter private static final String BASE_PRODUCT="//div[contains(text(),'%s')]/../../following-sibling::div/button";
    @Getter private static final String TABLE_ROW="//mat-table[@role='table']/child::mat-row[@role='row']";
    @Getter private static final String TABLE_COLUMN="//mat-table[@role='table']/mat-row/mat-cell[@role='cell']";
    @Getter private static final String BASE_RADIOBUTTON="//mat-table[@role='table']/mat-row/mat-cell[@role='cell' and contains(text(),'%s')]/preceding-sibling::mat-cell/mat-radio-button";


}
