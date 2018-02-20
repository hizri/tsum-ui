package tsum.ui.automation.factories;

import com.github.javafaker.Faker;
import tsum.ui.automation.models.LoginModel;
import tsum.ui.automation.models.RegistrationModel;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseFactory {

    private static final Random random = new Random();
    private static final Faker faker = new Faker();
    private static final ArrayList<String> genders = new ArrayList<>(Arrays.asList("male", "female"));

    public static RegistrationModel randomRegistrationData() {
        RegistrationModel data = new RegistrationModel();
        UUID uuid = UUID.randomUUID();

        data.setName(String.format("%s ' - ' %s", faker.name().firstName(), faker.name().lastName()));
        data.setGender(genders.get(random.nextInt(genders.size())));
        data.setBirthDate(faker.date().between(faker.date().past(30000, TimeUnit.DAYS), new Date()));
        data.seteMail(faker.internet().safeEmailAddress());
        data.setPhoneNumber(String.valueOf(faker.number().randomNumber(11, true)));
        data.setPassword(String.format("pwd_%s", uuid));
        data.setSubscribed(random.nextBoolean());
        return data;
    }

    public static LoginModel randomLoginData() {
        LoginModel data = new LoginModel();
        UUID uuid = UUID.randomUUID();
        data.setEmail(faker.internet().safeEmailAddress());
        data.setPassword(String.format("pwd_%s", uuid));
        return data;
    }

    public static LoginModel toLoginModel(RegistrationModel registrationModel) {
        LoginModel data = new LoginModel();
        data.setEmail(registrationModel.geteMail());
        data.setPassword(registrationModel.getPassword());
        return data;
    }

}
