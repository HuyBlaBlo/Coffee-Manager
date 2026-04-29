package main;

import controller.LoginController;
import controller.MainController;
import ui.LoginDialog;
import ui.MainFrame;

public class App {
	public static void main(String[] args) {
//		MainFrame mainFrame = new MainFrame();
//
//        new MainController(mainFrame);
//        
//        // để visible set cuối cùng
//        mainFrame.setVisible(true);
		
		LoginDialog loginDialog = new LoginDialog();
		new LoginController(loginDialog);
		loginDialog.setVisible(true);
	}
}
