import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    @BeforeEach
    void setUp() {
        baseUrl = "https://github.com";
        browserSize = "1920x1080";
    }

    @Test
    void checkEnterprisePageLoadedTest() {
        open(baseUrl);
        $("nav").find(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprises")).click();
        $("h1.enterprise-hero-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
