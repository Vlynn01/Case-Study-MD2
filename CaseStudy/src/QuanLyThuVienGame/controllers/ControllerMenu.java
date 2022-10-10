package QuanLyThuVienGame.controllers;

import QuanLyThuVienGame.service.MenuMainService;
import QuanLyThuVienGame.views.MenuMainView;

public class ControllerMenu {
    public MenuMainView menuMainView;

    public MenuMainService menuMainService;

    public ControllerMenu() {
        menuMainView = new MenuMainView();
        menuMainService = new MenuMainService();
    }
}
