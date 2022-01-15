package mayya.siv.homework;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchTest {

    @Test

    void checkSoftAssertionsPage() {

        Configuration.browserSize = "1440x900";

//        Открыть страницу Selenide в Github
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();

//        Перейти в раздел Wiki проекта
        $("#wiki-tab").click();

//        Убедиться, что в списке страниц (Pages) есть страница SoftAssertions и открытье ее
        $(".js-wiki-more-pages-link").click();
        $("#wiki-pages-box").$(withText("SoftAssertions")).click();

//        Проверить что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
