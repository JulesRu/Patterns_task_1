package delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateDate(int addDays) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
       var city = new String[]{"Барнаул", "Чита", "Краснодар", "Красноярск",
               "Пермь", "Владивосток", "Архангельск", "Астрахань", "Калуга", "Кострома", "Курск", "Киров", "Липецк",
               "Кострома", "Казань", "Чебоксары", "Абакан", "Ставрополь", "Хабаровск",
               "Владивосток", "Москва", "Липецк", "Белгород", "Владимир", "Вологда", "Воронеж", "Иркутск",
               "Псков", "Нижний Новгород"};
       return city[new Random().nextInt(city.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
        return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
