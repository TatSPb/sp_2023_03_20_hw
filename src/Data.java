public class Data {

    private static String VALID_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private Data() {
    }

    private static void check(String login,
                              String password,
                              String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!validate(login)) {
            throw new WrongLoginException("Логин не корректный");
        }

        if (!validate(password)) {
            throw new WrongPasswordException("Пароль не корректный");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean validate(String s) {
        if (s.length() >= 20 || s.length() < 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.copyValueOf(new char[]{s.charAt(i)}))) {
                return false;
            }
        }
        return true;
    }
}