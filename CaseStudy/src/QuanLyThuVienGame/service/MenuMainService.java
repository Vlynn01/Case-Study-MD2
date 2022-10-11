package QuanLyThuVienGame.service;

import QuanLyThuVienGame.io.ReadAndWrite;
import QuanLyThuVienGame.models.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMainService {

    static ReadAndWrite<Game> gameReadAndWrite = new ReadAndWrite<>();

    static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Game> games = new ArrayList<>();


    public ArrayList<Game> getGames() {

        return games;
    }

    public MenuMainService() {
        games = gameReadAndWrite.read("E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\game.csv");
    }

    //Tạo danh sách
    {
        games.add(new Game("NARAKA: BLADEPOINT", "Sinh tồn", "36gb", 2021, "NetEase", 360));
        games.add(new Game("Cyberpunk 2077", "Hành động", "67gb", 2020, "CD PROJEKT RED", 990));
        games.add(new Game("The crew 2", "Đua xe", "56gb", 2018, "Ubisoft", 825));
        games.add(new Game("FIFA 22", "Thể thao", "44gb", 2021, "EA", 990));
        games.add(new Game("NBA 2K222", "Thể thao", "118gb", 2021, "2K", 1000));
        gameReadAndWrite.write(games, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\game.csv");
    }


    //Thông tin
    public static Game infGame() {
        System.out.println("Nhập tên game: ");
        String ten = scanner.nextLine();

        System.out.println("Nhập thể loại: ");
        String theLoai = scanner.nextLine();

        System.out.println("Nhập dung lượng: ");
        String dungLuong = scanner.nextLine();

        System.out.println("Nhập năm sản xuất: ");
        int namSanXuat = 0;
        try {
            namSanXuat = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Sai định dạng.");
        }

        System.out.println("Nhập nhà phát hành: ");
        String nhaPhatHanh = scanner.nextLine();

        System.out.println("Nhập giá: ");
        double gia = 0;
        try {
            gia = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Sai định dạng");
        }


        Game game = new Game(ten, theLoai, dungLuong, namSanXuat, nhaPhatHanh, gia);
        System.out.println(game);
        return game;
    }

    //Hiển thị
    public static void show() {
        System.out.println("-----------------------------------------------Thư viện game Luz-----------------------------------------------");
        System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s", "Tên", "Thể loại", "Dung lượng", "Năm sản xuất", "Nhà phát hành", "Giá");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (Game game : games) {
            System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s", game.getTen(), game.getTheLoai(), game.getDungLuong(), game.getNamSanXuat(), game.getNhaPhatHanh(), game.getGia());
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------");
        }
    }

    //Thêm
    public static void add() {
        Game game = infGame();
        games.add(game);
        System.out.println("Add account " + game.getTen() + " success");
        gameReadAndWrite.write(games, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\game.csv");
    }

    //Sửa
    public static void update() {
        System.out.println("Nhập tên game muốn sửa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getTen().equals(ten)) {
                games.set(i, infGame());
            }
        }
        gameReadAndWrite.write(games, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\game.csv");
    }

    //Xóa
    public static void delete() {
        System.out.println("Nhập tên muốn xóa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getTen().equals(ten)) {
                games.remove(i);
                break;
            }
        }
        gameReadAndWrite.write(games, "E:\\Java\\CaseStudy\\src\\QuanLyThuVienGame\\file_text\\game.csv");
    }

    //Sắp xếp
    public static void sort() {
        int choose = 2;
        System.out.println("1. Giá tăng dần");
        System.out.println("2. Giá giảm dần");
        System.out.println("Nhập số để lựa chọn: ");

        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.err.println("Sai định dạng");
        }
        switch (choose) {
            case 1 -> ascending();
            case 2 -> decrease();
        }
    }

    //Sắp xếp tăng dần
    public static void ascending() {
        Game temp;
        for (int i = 0; i < games.size(); i++) {
            for (int j = i + 1; j < games.size(); j++) {
                if (games.get(i).getGia() > games.get(j).getGia()) {
                    temp = games.get(i);
                    games.set(i, games.get(j));
                    games.set(j, temp);
                }
            }
        }
        show();
    }

    //Sắp xếp giảm dần
    public static void decrease() {

        Game temp;
        for (int i = 0; i < games.size() - 1; i++) {
            for (int j = i + 1; j < games.size(); j++) {
                if (games.get(i).getGia() < games.get(j).getGia()) {
                    temp = games.get(i);
                    games.set(i, games.get(j));
                    games.set(j, temp);
                }
            }
        }

        show();

    }

    //Tìm theo tên
    public static void SearchByName() {
        System.out.println("Nhập tên game muốn tìm");
        String name = scanner.nextLine();
        for (Game game : games) {
            if (game.getTen().contains(name)) {
                System.out.println(game);
            }
        }
    }
}

