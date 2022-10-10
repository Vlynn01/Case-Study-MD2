package QuanLyThuVienGame.controllers;

import QuanLyThuVienGame.service.AccountService;
import QuanLyThuVienGame.views.AccountView;

public class ControllerAccount {
    public AccountService accountService;

    public AccountView accountView;

    public ControllerAccount() {
        accountService = new AccountService();
        accountView = new AccountView();
    }

    public void choiceAccount() {

        int choice = -1;
        while (choice != 5) {
            choice = accountView.menuAccount();
            switch (choice) {
                case 1 -> accountService.addAccount(accountService.createAccount());
                case 2 -> accountService.editAccount(accountService.findIndex());
                case 3 -> accountService.deleteAccount(accountService.findIndex());
                case 4 -> accountService.displayAccount();
                case 0 -> {
                    System.out.println("Back menu!");
                    return;
                }
            }
        }
    }
}
