import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть свій логін:");
        System.out.println("Логін повинен містити тільки латинські літери, цифри та знак підкреслення. К-ть символів повинна бути не більше 20");
        String login = scanner.nextLine();
        System.out.println("Введіть свій пароль:");
        System.out.println("Пароль повинен містити тільки латинські літери, цифри та знак підкреслення. К-ть символів повинна бути не більше 20");
        String password = scanner.nextLine();
        System.out.println("Підтвердіть свій пароль");
        String repeatPassword = scanner.nextLine();
        try {
            takeLogin(login, password, repeatPassword);
        } catch (ErrorLogException i) {
            System.out.println("Невірно введений логін, спробуйте будь ласка пізніше");
            i.getStackTrace();
        } catch (ErrorPassException j) {
            System.out.println("Невірно введений пароль, спробуйте буль ласка пізніше");
            j.getStackTrace();
        }
    }

    public static boolean takeLogin(String login, String password, String repeatPassword)
            throws ErrorLogException, ErrorPassException {
        String patternPassword = "(\"^[a-zA-Z0-9_]+$.{0,20}\")";
        if ((login.matches(patternPassword)) && (password.matches(patternPassword) && repeatPassword.equals(password))) {
            return true;
        } else if (!login.matches(patternPassword)) {
            throw new ErrorLogException();
        } else if (!password.matches(patternPassword) ) {
            throw new ErrorPassException();
        } else if (!repeatPassword.equals(password)) {
            throw new ErrorPassException();
        }return false;
    }
}