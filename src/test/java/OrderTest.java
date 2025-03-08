import org.junit.Test;
import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;

import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest {

    @Test
    public void orderByHeaderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Вика")
                .sendClientLastName("Бекхэм")
                .sendDeliveryAddress("Москва, Кутузовский, 06")
                .selectMetroStation("Марьина Роща")
                .sendDeliveryClientPhoneNumber("74956789000")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("25.03.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Жду!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Ой, что-то пошло не так...", isDisplayed);
    }

    @Test
    public void orderByMiddleButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Девид")
                .sendClientLastName("Бекхэм")
                .sendDeliveryAddress("Москва, Измайловская, 12")
                .selectMetroStation("Павелецкая")
                .sendDeliveryClientPhoneNumber("74956789001")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("26.03.2025")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Грей")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Не удалось выполнить заказ!", isDisplayed);
    }
}