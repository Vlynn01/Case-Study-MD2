package QuanLyThuVienGame.service;

import QuanLyThuVienGame.io.ReadAndWrite;
import QuanLyThuVienGame.models.Account;
import QuanLyThuVienGame.validate.Validate;

import java.util.ArrayList;

public class AccountService {
    public static ArrayList<Account> accounts = new ArrayList<>();

    public static Account account;

    ReadAndWrite<Account> readAndWrite = new ReadAndWrite<>();

    public AccountService() {
        accounts = readAndWrite.read("E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\account.csv");
    }

    //Thêm
    public void addAccount(Account account) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(account.getUserName())) {
                return;
            }
        }
        accounts.add(account);
        System.out.println("Add account " + account.getUserName() + " success");
        readAndWrite.write(accounts, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\account.csv");
    }

    //Đăng nhập
    public boolean login() {
        System.out.println("Nhập tài khoản: (Tên tài khoản phải có 6-10 chữ cái bao gồm các chữ cái và số)");
        String user = Validate.validateString(Validate.REGEX_ACCOUNT);
        System.out.println("Nhập mật khẩu : (Mật khẩu phải có 6-10 chữ cái bao gồm các chữ cái và số)");
        String pass = Validate.validateString(Validate.REGEX_ACCOUNT);

        for (Account acc : accounts) {
            if (acc.getUserName().equals(user) && acc.getPassWord().equals(pass)) {
                AccountService.account = acc;
                return true;
            }
        }
        return false;
    }

    //Tạo
    public Account createAccount() {
        String user;
        System.out.println("Nhập tên: (Tên phải có ít nhất 1 chữ cái viết hoa và không có số) ");
        String name = Validate.validateString(Validate.REGEX_STRING);
        while (true) {
            System.out.println("Nhập tài khoản: (Tên tài khoản phải có 6-10 chữ cái bao gồm các chữ cái và số)");
            user = Validate.validateString(Validate.REGEX_ACCOUNT);
            if (checkUserName(user)) {
                break;
            } else {
                System.err.println("Tên tài khoản đang tồn tại");
            }
        }
        System.out.println("Nhập mật khẩu : (Mật khẩu phải có 6-10 chữ cái bao gồm các chữ cái và số)");
        String pass = Validate.validateString(Validate.REGEX_ACCOUNT);
        System.out.println("Nhập email: (Email phải ở dạng: abcd@abc.com/vn)");
        String email = Validate.validateString(Validate.REGEX_EMAIL);
        return new Account(name, user, pass, "user", email);
    }

    //Sửa
    public Account createAccountEdit() {
        String user;
        System.out.println("Nhập tên: (Tên phải có ít nhất 1 chữ cái viết hoa và không có số) ");
        String name = Validate.validateString(Validate.REGEX_STRING);
        System.out.println("Nhập tài khoản: (Tên tài khoản phải có 6-10 chữ cái bao gồm các chữ cái và số)");
        user = Validate.validateString(Validate.REGEX_ACCOUNT);
        System.out.println("Nhập mật khẩu : (Mật khẩu phải có 6-10 chữ cái bao gồm các chữ cái và số)");
        String pass = Validate.validateString(Validate.REGEX_ACCOUNT);
        System.out.println("Nhập email: (Email phải ở dạng: abcd@abc.com/vn)");
        String email = Validate.validateString(Validate.REGEX_EMAIL);
        return new Account(name, user, pass, "user", email);
    }

    //Kiểm tra trùng
    public boolean checkUserName(String userName) {
        for (Account acc : accounts) {
            if (acc.getUserName().equals(userName)) {
                return false;
            }
        }
        return true;
    }

    //Tìm kiếm
    public int findIndex() {
        System.out.println("Nhập tên tài khoản để tìm kiếm (Tên tài khoản phải có 6-10 chữ cái bao gồm các chữ cái và số)");
        String user = Validate.validateString(Validate.REGEX_ACCOUNT);
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(user)) return i;
        }
        return -1;
    }

    //Xóa
    public void deleteAccount(int index) {
        if (index != -1) {
            accounts.remove(index);
            System.out.println("Xóa tài khoản thành công.");
            readAndWrite.write(accounts, "account.csv");
        } else System.out.println("Tài khoản chưa tồn tại.");
    }

    //Hiển thị
    public void displayAccount() {
        System.out.println("-------------------------------Account list-------------------------------");
        System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s", "Name", "User", "Password", "Rights", "Email");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        for (Account acc : accounts) {
            System.out.printf("| %-15s| %-15s| %-15s| %-15s| %-15s", acc.getName(), acc.getUserName(), acc.getPassWord(), acc.getRights(), acc.getEmail());
            System.out.println();
            System.out.println("--------------------------------------------------------------------------");
        }
    }

    //Sửa
    public void editAccount(int index) {
        if (index != -1) {
            accounts.set(index, createAccountEdit());
            System.out.println("Edit account success");
            readAndWrite.write(accounts, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\account.csv");
        } else System.out.println("This account not exist");
    }

    //Quyền
    public void upRight(int index) {
        if (index != -1) {
            if (accounts.get(index).getRights().equals("admin")) {
                accounts.get(index).setRights("user");
            } else accounts.get(index).setRights("admin");
        } else System.out.println("This account not exist");
    }
}
