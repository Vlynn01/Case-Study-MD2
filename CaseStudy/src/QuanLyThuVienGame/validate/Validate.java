package QuanLyThuVienGame.validate;

import java.util.Scanner;

public class Validate {
    public static final String REGEX_STRING = "[A-Z][\\sA-Za-z]+";
    public static final String REGEX_ACCOUNT = "[A-Za-z0-9]{6,10}";
    public static final String REGEX_EMAIL = "^[a-zA-Z]+[0-9_a-zA-z.]*@([a-z]+\\.[a-z]+)+";
    static Scanner scanner = new Scanner(System.in);

    public static String validateString(String regex) {
        while (true) {
            String name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }
            System.err.println("Sai định dạng, vui lòng nhập lại.");
        }
    }

}
