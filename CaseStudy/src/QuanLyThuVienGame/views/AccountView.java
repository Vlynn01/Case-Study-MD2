package QuanLyThuVienGame.views;

import java.util.Scanner;

public class AccountView {
    Scanner scanner = new Scanner(System.in);

    public int menuAccount() {
        while (true) {
            try {
                String menuAcc = """
                        Menu Account
                        1. Thêm tài khoản.
                        2. Sửa tài khoản.
                        3. Xóa tài khoản.
                        4. Hiện thị tất cả tài khoản.
                        0. Thoát.
                        """;
                System.out.println(menuAcc);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập số.");
            }
        }
    }
}
