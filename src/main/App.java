package main;

import controller.LoginController;
import controller.MainController;
import ui.LoginDialog;
import ui.MainFrame;

public class App {
	public static void main(String[] args) {

		LoginDialog loginDialog = new LoginDialog();
		new LoginController(loginDialog);
		loginDialog.setVisible(true);
	}
}