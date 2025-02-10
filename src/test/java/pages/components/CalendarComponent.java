package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.generateRandomDate;

public class CalendarComponent {
        public static String fullDate;

        public String[] dateComponents = generateRandomDate();
        public void setRandomDate() {
                String month = dateComponents[0];
                String year = dateComponents[1];
                String day = dateComponents[2];
                fullDate = day + " " + month + "," + year;
                $(".react-datepicker__month-select").selectOption(month);
                $(".react-datepicker__year-select").selectOption(year);
                $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        }
}