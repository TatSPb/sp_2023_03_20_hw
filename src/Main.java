public class Main {
    public static void main(String[] args) throws WrongPasswordException, WrongLoginException {
        boolean success = Data.validate("Compote", "compote_20230322", "compote_20230322");
        if (success) {
            System.out.println("Логин и пароль введены корректно");
        } else {
            System.out.println("Ошибка в воде логина или пароля");
        }
    }
}