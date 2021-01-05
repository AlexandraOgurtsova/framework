package service;

import model.User;

public class UserCreator {

    public static final String USER_LOGIN ="test.data.login";
    public static final String USER_PASSWORD="test.data.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(USER_LOGIN), TestDataReader.getTestData(USER_PASSWORD));
    }
}
