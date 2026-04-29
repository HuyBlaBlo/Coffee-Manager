package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.LoginDialog;
import ui.MainFrame;
import ui.POS;
import utils.Auth;

public class MainController implements ActionListener{
	private MainFrame mainFrame;
	
	public MainController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
//		cái dòng này tao không biết viết vậy là có đúng hay không, hoặc thay 
//		nó bawnfgc cái hàm duowis anh em coi rồi sửa giúp tao
		this.mainFrame.addMenuAction(this);
		initPanel();
	}

//	hàm nay này	
//	private void initController() {
//        // Chỉ cần 1 dòng duy nhất để gắn sự kiện cho mọi nút!
//        mainFrame.addMenuAction(this);
//    }

	//// hàm này dùng để ĐÚT các cái panel của anh em mình vào cái pnlMain OK
	private void initPanel() {
		// ví dụ tao đã làm xong cái pos và controller cho pos thì tao làm cái này để khai báo
		POS posView = new POS();
	    new POSController(posView);
		mainFrame.addSubPanel(posView, "POS");
		mainFrame.showCard("POS");
		// tuowng tự cho các csai panel khác 
		
		
	}

	
	
	@Override
    public void actionPerformed(ActionEvent e) {
        // Lấy cái chuỗi command mình đã set trong View
        String command = e.getActionCommand(); 

        switch (command) {
            case "POS":
            	// show csai panel anh em viet a nha
            	mainFrame.showCard("POS");
                break;
            case "Invoice":
            	mainFrame.showCard("Invoice");
                break;
            case "Menu":
            	mainFrame.showCard("Menu");
                break;
            case "Staff":
            	mainFrame.showCard("Staff");
                break;
            case "Stats":
            	mainFrame.showCard("Stats");
                break;
            case "Logout":
                logout();
                break;
            default:
                System.out.println("Tính năng chưa phát triển!");
                break;
        }
    }
	
	private void logout() {
        // xoa nguoi dang nhap di
		Auth.clear();
		// tat cai mainFtame
        mainFrame.dispose();
        
        // hien thi cai mang hinh fdang nhap ra
        
        // CÁI NÀY VƯƠNG LÀM NÊN VƯƠNG COI RỒI GẮN VÔ NHA
//        LoginDialog loginView = new LoginDialog();
//        new LoginController();
//        loginView.setVisible(true);
    }
}
