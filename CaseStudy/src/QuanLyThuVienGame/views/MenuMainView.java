package QuanLyThuVienGame.views;

import java.util.Scanner;

public class MenuMainView {
    Scanner scanner = new Scanner(System.in);

    public int menuAdmin() {

        while (true) {
            try {
                String menuAdmin = """
                        ______________________________
                        1. Xem danh sách thư viện game
                        2. Thêm game
                        3. Cập nhật
                        4. Xóa game
                        5. Sắp xếp
                        6. Tìm game theo tên
                        7. Thông tin tài khoản
                        0. Thoát
                                           
                         Nhập số để chọn:
                        """;
                System.out.println(menuAdmin);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập số.");
            }
        }
    }

    public int menuUser() {
        while (true) {
            try {
                String menuUser = """
                        Chào mừng bạn đến với cửa hàng game Lazy
                         1. Hiển thị game.
                         2. Sắp xếp.
                         3. Tìm game theo tên.
                         4. Chơi thử(Coming soon).
                         
                         0. Thoát
                         """;
                System.out.println(menuUser);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập số.");
            }
        }
    }
}
