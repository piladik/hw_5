import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeEach
    void setUp() {
        baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        browserSize = "1920x1080";
    }

    @Test
    void checkSuccessfulDragAndDropTest() {
        open(baseUrl);

        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");

        columnA.shouldHave(text("A"));
        columnB.shouldHave(text("B"));

        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();

        columnA.shouldHave(text("B"));
        columnB.shouldHave(text("A"));
    }
}
