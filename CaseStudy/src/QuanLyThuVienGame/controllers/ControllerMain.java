package QuanLyThuVienGame.controllers;

import QuanLyThuVienGame.io.ReadAndWrite;
import QuanLyThuVienGame.models.Account;
import QuanLyThuVienGame.service.AccountService;
import QuanLyThuVienGame.service.MenuMainService;

public class ControllerMain {
    public ControllerLogin controllerLogin;

    public ControllerMenu controllerMenu = new ControllerMenu();
    public ControllerAccount controllerAccount;

    ReadAndWrite<Account> accountReadAndWrite = new ReadAndWrite<>();

    public ControllerMain() {
        controllerAccount = new ControllerAccount();
        controllerLogin = new ControllerLogin();
    }

    public void menu() {
        while (true) {
            int choice = controllerLogin.loginView.menuLogin();
            switch (choice) {
                case 1 -> choiceLogin();
                case 2 -> controllerLogin.choiceRegister();
                case 0 -> {
                    System.out.println("Thoát!!");
                    System.exit(0);
                }
                default -> System.out.println("Chọn lại");
            }
        }
    }

    public void choiceLogin() {
//        Tài khoản admin
//        Account admin = new Account("Admin", "Admin", "VanLuan", "admin", "vlynn00@yahoo.com");
//        controllerLogin.accountService.addAccount(admin);


        if (controllerLogin.accountService.login()) {
            System.out.println("Đăng nhập thành công!");
            int choice = -1;
            //Admin
            if (AccountService.account.getRights().equals("admin")) {
                while (choice != 0) {
                    System.out.println("Hello " + AccountService.account.getName() + "!!");
                    choice = controllerMenu.menuMainView.menuAdmin();
                    switch (choice) {
                        case 1:
                            MenuMainService.show();
                            break;
                        case 2:
                            MenuMainService.add();
                            break;
                        case 3:
                            MenuMainService.update();
                            break;
                        case 4:
                            MenuMainService.delete();
                            break;
                        case 5:
                            MenuMainService.sort();
                            break;
                        case 6:
                            MenuMainService.SearchByName();
                            break;
                        case 7:
                            controllerAccount.choiceAccount();
                            break;
                        case 0: {
                            System.out.println("Đăng xuất ! Bye " + AccountService.account.getName());
                            accountReadAndWrite.write(AccountService.accounts, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\account.csv");
                        }
                        default:
                            System.out.println("Chọn lại");
                    }
                }
            } else {
                //User
                while (true) {
                    System.out.println("Hello " + AccountService.account.getName() + "!!");
                    choice = controllerMenu.menuMainView.menuUser();
                    switch (choice) {
                        case 1 -> MenuMainService.show();
                        case 2 -> MenuMainService.sort();
                        case 3 -> MenuMainService.SearchByName();
//                        case 4 -> ;

                        case 0 -> {
                            System.out.println("Đăng xuất ! Bye " + AccountService.account.getName());
                            accountReadAndWrite.write(AccountService.accounts, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\account.csv");
                            return;
                        }
                        default -> System.out.println("Chọn lại");
                    }
                }
            }
        }
    }
}
