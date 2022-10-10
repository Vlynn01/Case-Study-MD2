package QuanLyThuVienGame.views;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);

    public int menuLogin() {
        while (true) {
            try {
                String menuLogin = """
                        Menu Login
                        1. Đăng nhập.
                        2. Đăng ký.
                        0. Thoát.
                        """;
                System.out.println(menuLogin);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập số.");
            }
        }
    }
}
