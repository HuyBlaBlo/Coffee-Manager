package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class POS extends JPanel {

	private JTextField txtTienDoanhThu;
	private JTextField txtDonHang;
	private JTextField txtTienLoiNhuan;
	private JCheckBox cbTaiCho;
	private JCheckBox cbMangDi;
	private JTextField txtTimMon;
	private JButton btnBan1;
	private JButton btnBan2;
	private JButton btnBan3;
	private JButton btnBan4;
	private JButton btnBan5;
	private JButton btnBan6;
	private JComboBox<String> comboBoxDanhMuc;
	private JButton btnCaPheDen;
	private JButton btnCaPheSua;
	private JButton btnBacXiu;
	private JButton btnTraDao;
	private JButton btnTraVai;
	private JButton btnMatcha;
	private JButton btnTiramisu;
	private JButton btnBanhSungTrau;
	private JButton btnBanhDonut;
	private JButton btnTimMon;
	private JButton btnDelete;
	private JButton btnTienMat;
	private JButton btnCheckout;
	private DefaultTableModel orderTableModel;
	private JTable tblOrder;
	private JButton btnBanking;
	private JButton btnVi;
	private JLabel lblStatusOrder;
	
	public JTextField getTxtTienDoanhThu() {
		return txtTienDoanhThu;
	}

	public void setTxtTienDoanhThu(JTextField txtTienDoanhThu) {
		this.txtTienDoanhThu = txtTienDoanhThu;
	}

	public JTextField getTxtDonHang() {
		return txtDonHang;
	}

	public void setTxtDonHang(JTextField txtDonHang) {
		this.txtDonHang = txtDonHang;
	}

	public JTextField getTxtTienLoiNhuan() {
		return txtTienLoiNhuan;
	}

	public void setTxtTienLoiNhuan(JTextField txtTienLoiNhuan) {
		this.txtTienLoiNhuan = txtTienLoiNhuan;
	}

	public JCheckBox getCbTaiCho() {
		return cbTaiCho;
	}

	public void setCbTaiCho(JCheckBox cbTaiCho) {
		this.cbTaiCho = cbTaiCho;
	}

	public JCheckBox getCbMangDi() {
		return cbMangDi;
	}

	public void setCbMangDi(JCheckBox cbMangDi) {
		this.cbMangDi = cbMangDi;
	}

	public JTextField getTxtTimMon() {
		return txtTimMon;
	}

	public void setTxtTimMon(JTextField txtTimMon) {
		this.txtTimMon = txtTimMon;
	}

	public JButton getBtnBan1() {
		return btnBan1;
	}

	public void setBtnBan1(JButton btnBan1) {
		this.btnBan1 = btnBan1;
	}

	public JButton getBtnBan2() {
		return btnBan2;
	}

	public void setBtnBan2(JButton btnBan2) {
		this.btnBan2 = btnBan2;
	}

	public JButton getBtnBan3() {
		return btnBan3;
	}

	public void setBtnBan3(JButton btnBan3) {
		this.btnBan3 = btnBan3;
	}

	public JButton getBtnBan4() {
		return btnBan4;
	}

	public void setBtnBan4(JButton btnBan4) {
		this.btnBan4 = btnBan4;
	}

	public JButton getBtnBan5() {
		return btnBan5;
	}

	public void setBtnBan5(JButton btnBan5) {
		this.btnBan5 = btnBan5;
	}

	public JButton getBtnBan6() {
		return btnBan6;
	}

	public void setBtnBan6(JButton btnBan6) {
		this.btnBan6 = btnBan6;
	}

	public JComboBox<String> getComboBoxDanhMuc() {
		return comboBoxDanhMuc;
	}

	public void setComboBoxDanhMuc(JComboBox<String> comboBoxDanhMuc) {
		this.comboBoxDanhMuc = comboBoxDanhMuc;
	}

	public JButton getBtnCaPheDen() {
		return btnCaPheDen;
	}

	public void setBtnCaPheDen(JButton btnCaPheDen) {
		this.btnCaPheDen = btnCaPheDen;
	}

	public JButton getBtnCaPheSua() {
		return btnCaPheSua;
	}

	public void setBtnCaPheSua(JButton btnCaPheSua) {
		this.btnCaPheSua = btnCaPheSua;
	}

	public JButton getBtnBacXiu() {
		return btnBacXiu;
	}

	public void setBtnBacXiu(JButton btnBacXiu) {
		this.btnBacXiu = btnBacXiu;
	}

	public JButton getBtnTraDao() {
		return btnTraDao;
	}

	public void setBtnTraDao(JButton btnTraDao) {
		this.btnTraDao = btnTraDao;
	}

	public JButton getBtnTraVai() {
		return btnTraVai;
	}

	public void setBtnTraVai(JButton btnTraVai) {
		this.btnTraVai = btnTraVai;
	}

	public JButton getBtnMatcha() {
		return btnMatcha;
	}

	public void setBtnMatcha(JButton btnMatcha) {
		this.btnMatcha = btnMatcha;
	}

	public JButton getBtnTiramisu() {
		return btnTiramisu;
	}

	public void setBtnTiramisu(JButton btnTiramisu) {
		this.btnTiramisu = btnTiramisu;
	}

	public JButton getBtnBanhSungTrau() {
		return btnBanhSungTrau;
	}

	public void setBtnBanhSungTrau(JButton btnBanhSungTrau) {
		this.btnBanhSungTrau = btnBanhSungTrau;
	}

	public JButton getBtnBanhDonut() {
		return btnBanhDonut;
	}

	public void setBtnBanhDonut(JButton btnBanhDonut) {
		this.btnBanhDonut = btnBanhDonut;
	}

	public JButton getBtnTimMon() {
		return btnTimMon;
	}

	public void setBtnTimMon(JButton btnTimMon) {
		this.btnTimMon = btnTimMon;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnTienMat() {
		return btnTienMat;
	}

	public void setBtnTienMat(JButton btnTienMat) {
		this.btnTienMat = btnTienMat;
	}

	public JButton getBtnCheckout() {
		return btnCheckout;
	}

	public void setBtnCheckout(JButton btnCheckout) {
		this.btnCheckout = btnCheckout;
	}

	public DefaultTableModel getOrderTableModel() {
		return orderTableModel;
	}

	public void setOrderTableModel(DefaultTableModel orderTableModel) {
		this.orderTableModel = orderTableModel;
	}

	public JTable getTblOrder() {
		return tblOrder;
	}

	public void setTblOrder(JTable tblOrder) {
		this.tblOrder = tblOrder;
	}

	public JButton getBtnBanking() {
		return btnBanking;
	}

	public void setBtnBanking(JButton btnBanking) {
		this.btnBanking = btnBanking;
	}

	public JButton getBtnVi() {
		return btnVi;
	}

	public void setBtnVi(JButton btnVi) {
		this.btnVi = btnVi;
	}

	public JLabel getLblStatusOrder() {
		return lblStatusOrder;
	}

	public void setLblStatusOrder(JLabel lblStatusOrder) {
		this.lblStatusOrder = lblStatusOrder;
	}

	public POS() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		
		// 1. Tạo Giao diện Header
		JPanel pHeader = createHeader();
		this.add(pHeader , BorderLayout.NORTH);

		// 2. Tạo giao diện đặt món (chứa giao diện chọn bàn và giao diện chọn món)
		JPanel pDatMon = createGiaoDienDatMon();
		
		// 3. TẠO GIAO DIỆN HÓA ĐƠN VÀ GHÉP VÀO MAIN
		JPanel pHoaDon = createGiaoDienDonHang();
		
		
		// Đưa pDatMon và pHoaDon vào chung pMain như ý định của bạn
		JPanel pMain = new JPanel(new BorderLayout(20,0));
		pMain.setBackground(Color.decode("#e2dbd3"));
		pMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pMain.add(pDatMon, BorderLayout.CENTER); 
		pMain.add(pHoaDon, BorderLayout.EAST);   
		
		this.add(pMain, BorderLayout.CENTER);
	}
	
	// 1. TẠO HEADER
	public JPanel createHeader() {
		JPanel pHeader = new JPanel();
		Box boxHeader = Box.createHorizontalBox();
		boxHeader.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		boxHeader.setOpaque(true);
		boxHeader.setBackground(Color.decode("#e3e3e3"));
		Box boxTitle = Box.createHorizontalBox();
		Box boxInfoHeader = Box.createHorizontalBox();
		Box boxUser = Box.createHorizontalBox();
		
		JLabel lblTitle = new JLabel("Bán Hàng (POS)");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel lblToday = new JLabel("Hôm nay:");
		JLabel lblDoanhThu = new JLabel("Doanh thu: ");
		JLabel lblDonHang = new JLabel("Đơn: ");
		JLabel lblLoiNhuan = new JLabel("Lợi nhuận: ");
		JLabel lblThoiGian = new JLabel("Thời gian");

		txtTienDoanhThu = new JTextField(10);
		txtDonHang = new JTextField(4);
		txtTienLoiNhuan = new JTextField(10);
		txtTienDoanhThu.setMaximumSize(txtTienDoanhThu.getPreferredSize());
		txtDonHang.setMaximumSize(txtDonHang.getPreferredSize());
		txtTienLoiNhuan.setMaximumSize(txtTienLoiNhuan.getPreferredSize());
		txtTienDoanhThu.setBorder(null);
		txtTienLoiNhuan.setBorder(null);
		txtDonHang.setBorder(null);
		txtTienDoanhThu.setEditable(false);
		txtTienLoiNhuan.setEditable(false);
		txtDonHang.setEditable(false);
		txtTienDoanhThu.setBackground(Color.decode("#e3e3e3"));
		txtTienLoiNhuan.setBackground(Color.decode("#e3e3e3"));
		txtDonHang.setBackground(Color.decode("#e3e3e3"));

		boxTitle.add(lblTitle);
		boxInfoHeader.add(lblToday);
		boxInfoHeader.add(Box.createHorizontalStrut(10));
		boxInfoHeader.add(lblDoanhThu);
		boxInfoHeader.add(txtTienDoanhThu);
		boxInfoHeader.add(Box.createHorizontalStrut(10));
		boxInfoHeader.add(new JLabel("|"));
		boxInfoHeader.add(Box.createHorizontalStrut(10));
		boxInfoHeader.add(lblDonHang);
		boxInfoHeader.add(txtDonHang);
		boxInfoHeader.add(Box.createHorizontalStrut(10));
		boxInfoHeader.add(new JLabel("|"));
		boxInfoHeader.add(Box.createHorizontalStrut(10));
		boxInfoHeader.add(lblLoiNhuan);
		boxInfoHeader.add(txtTienLoiNhuan);
		boxUser.add(lblThoiGian);
		
		boxHeader.add(boxTitle);
		boxHeader.add(Box.createHorizontalStrut(250));
		boxHeader.add(boxInfoHeader);
		boxHeader.add(Box.createHorizontalStrut(250));
		boxHeader.add(boxUser);
		pHeader.add(boxHeader);
		return pHeader;
	}
	
	
	public JPanel createGiaoDienDatMon() {
		// 2. TẠO GIAO DIỆN ĐẶT MÓN
		JPanel pDatMon = new JPanel(new BorderLayout());
		
		JPanel pTacVu = new JPanel(new BorderLayout()); 
		pTacVu.setBackground(Color.decode("#e3e3e3"));
		cbTaiCho = new JCheckBox("Tại chỗ");
		cbTaiCho.setBackground(Color.decode("#e3e3e3"));
		cbMangDi = new JCheckBox("Mang đi");
		cbMangDi.setBackground(Color.decode("#e3e3e3"));
		ButtonGroup group = new ButtonGroup();
		group.add(cbMangDi);
		group.add(cbTaiCho);
		btnTimMon = new JButton("Tìm Món");
		btnTimMon.setPreferredSize(new Dimension(90,25));
		btnTimMon.setMaximumSize(new Dimension(90, 25));
		txtTimMon = new JTextField(20);
		txtTimMon.setMaximumSize(new Dimension(400, txtTimMon.getPreferredSize().height));
		Box boxTacVu = Box.createHorizontalBox();
		boxTacVu.setPreferredSize(new Dimension(Integer.MAX_VALUE,50));
		boxTacVu.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxTacVu.getPreferredSize().height));
		boxTacVu.add(cbTaiCho);
		boxTacVu.add(Box.createHorizontalStrut(15));
		boxTacVu.add(cbMangDi);
		boxTacVu.add(Box.createHorizontalGlue());
		boxTacVu.add(btnTimMon);
		boxTacVu.add(Box.createHorizontalStrut(15));
		boxTacVu.add(txtTimMon);
		
		pTacVu.add(boxTacVu);
		pDatMon.add(pTacVu, BorderLayout.NORTH);

		
		
		//tạo giao diện chọn bàn
		Box boxChonBan = Box.createVerticalBox();
		boxChonBan.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		boxChonBan.setPreferredSize(new Dimension(320, boxChonBan.getPreferredSize().height));
		boxChonBan.setMaximumSize(new Dimension(320, Integer.MAX_VALUE));
		
		//Tạo row box chứa title
		Box boxTableTitle = Box.createHorizontalBox();
		//tạo các row chứa tên các bàn
		Box boxBanRowLabel1 = Box.createHorizontalBox();
		Box boxBanRowLabel2 = Box.createHorizontalBox();
		//tạo các row chứa ảnh của bàn
		Box boxBanRowTable1 = Box.createHorizontalBox();
		Box boxBanRowTable2 = Box.createHorizontalBox();
		
		//tạo label của phần box chọn bàn
		JLabel lblTableTitle = new JLabel("Khu Vực Bàn");
		lblTableTitle.setFont(new Font("Arial",Font.BOLD,16));
		JLabel lblTable1 = new JLabel("Bàn 01");
		JLabel lblTable2 = new JLabel("Bàn 02");
		JLabel lblTable3 = new JLabel("Bàn 03");
		JLabel lblTable4 = new JLabel("Bàn 04");
		JLabel lblTable5 = new JLabel("Bàn 05");
		JLabel lblTable6 = new JLabel("Bàn 06");
		ImageIcon iconTable = getScaledIcon("/images/table.png", 50, 50);
		
		btnBan1 = new JButton(iconTable);
		chinhSuaButton(btnBan1);
		btnBan2 = new JButton(iconTable);
		chinhSuaButton(btnBan2);
		btnBan3 = new JButton(iconTable);
		chinhSuaButton(btnBan3);
		btnBan4 = new JButton(iconTable);
		chinhSuaButton(btnBan4);
		btnBan5 = new JButton(iconTable);
		chinhSuaButton(btnBan5);
		btnBan6 = new JButton(iconTable);
		chinhSuaButton(btnBan6);

		boxTableTitle.add(lblTableTitle);
		boxTableTitle.add(Box.createHorizontalGlue());
		boxBanRowLabel1.add(Box.createHorizontalStrut(20));
		boxBanRowLabel1.add(lblTable1);
		boxBanRowLabel1.add(Box.createHorizontalStrut(55));
		boxBanRowLabel1.add(lblTable2);
		boxBanRowLabel1.add(Box.createHorizontalStrut(55));
		boxBanRowLabel1.add(lblTable3);
		boxBanRowLabel1.add(Box.createHorizontalStrut(55));
		
		boxBanRowTable1.add(btnBan1);
		boxBanRowTable1.add(Box.createHorizontalStrut(10));
		boxBanRowTable1.add(btnBan2);
		boxBanRowTable1.add(Box.createHorizontalStrut(10));
		boxBanRowTable1.add(btnBan3);
		boxBanRowTable1.add(Box.createHorizontalStrut(10));
		
		boxBanRowLabel2.add(Box.createHorizontalStrut(20));
		boxBanRowLabel2.add(lblTable4);
		boxBanRowLabel2.add(Box.createHorizontalStrut(55));
		boxBanRowLabel2.add(lblTable5);
		boxBanRowLabel2.add(Box.createHorizontalStrut(55));
		boxBanRowLabel2.add(lblTable6);
		boxBanRowLabel1.add(Box.createHorizontalStrut(55));
		
		boxBanRowTable2.add(btnBan4);
		boxBanRowTable2.add(Box.createHorizontalStrut(10));
		boxBanRowTable2.add(btnBan5);
		boxBanRowTable2.add(Box.createHorizontalStrut(10));
		boxBanRowTable2.add(btnBan6);
		boxBanRowTable2.add(Box.createHorizontalStrut(10));
		
		boxBanRowLabel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxBanRowLabel1.getPreferredSize().height));
		boxBanRowTable1.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxBanRowTable1.getPreferredSize().height));
		boxBanRowLabel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxBanRowLabel2.getPreferredSize().height));
		boxBanRowTable2.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxBanRowTable2.getPreferredSize().height));
		
		boxChonBan.add(Box.createVerticalStrut(15));
		boxChonBan.add(boxTableTitle);
		boxChonBan.add(Box.createVerticalStrut(30));
		boxChonBan.add(boxBanRowLabel1);
		boxChonBan.add(Box.createVerticalStrut(5));
		boxChonBan.add(boxBanRowTable1);
		boxChonBan.add(Box.createVerticalStrut(25));
		boxChonBan.add(boxBanRowLabel2);
		boxChonBan.add(Box.createVerticalStrut(5));
		boxChonBan.add(boxBanRowTable2);
		boxChonBan.add(Box.createVerticalGlue());
		

		Box boxChonMon = Box.createVerticalBox();
		Box boxDanhMuc = Box.createHorizontalBox();
		String[] danhMuc = {"Tất cả","Cà phê","Trà & Matcha","Bánh ngọt"};
		comboBoxDanhMuc = new JComboBox<>(danhMuc);
		boxDanhMuc.add(comboBoxDanhMuc);
		boxDanhMuc.setMaximumSize(new Dimension(400, boxDanhMuc.getPreferredSize().height));
		boxChonMon.add(Box.createVerticalStrut(20));
		boxChonMon.add(boxDanhMuc);
		boxChonMon.add(Box.createVerticalStrut(20));
		
		Box boxLabelMonRow1 = Box.createHorizontalBox();
		Box boxLabelMonRow2 = Box.createHorizontalBox();
		Box boxLabelMonRow3 = Box.createHorizontalBox();
		Box boxMonRow1 = Box.createHorizontalBox();
		Box boxMonRow2 = Box.createHorizontalBox();
		Box boxMonRow3 = Box.createHorizontalBox();
		

		JLabel lblCaPheDen = new JLabel("Cà phê đen đá");
		JLabel lblCaPheSua = new JLabel("Cà phê sữa đá");
		JLabel lblBacXiu = new JLabel("Bạc xỉu");
		JLabel lblTraDao = new JLabel("Trà đào");
		JLabel lblTraVai = new JLabel("Trà vải");
		JLabel lblMathca = new JLabel("Matcha Latte");
		JLabel lblTiramisu = new JLabel("Bánh Tiramisu");
		JLabel lblBanhSungTrau = new JLabel("Bánh sừng trâu");
		JLabel lblBanhDonut = new JLabel("Bánh Donut");
		
		btnCaPheDen = new JButton(getScaledIcon("/images/CaPheDen.png", 100, 100));
		chinhSuaButton(btnCaPheDen);
		btnCaPheSua = new JButton(getScaledIcon("/images/CaPheSua.png", 100, 100));
		chinhSuaButton(btnCaPheSua);
		btnBacXiu = new JButton(getScaledIcon("/images/BacXiu.png", 100, 100));
		chinhSuaButton(btnBacXiu);
		btnTraDao = new JButton(getScaledIcon("/images/TraDao.png", 100, 100));
		chinhSuaButton(btnTraDao);
		btnTraVai = new JButton(getScaledIcon("/images/TraVai.png", 100, 100));
		chinhSuaButton(btnTraVai);
		btnMatcha = new JButton(getScaledIcon("/images/Matcha.png", 100, 100));
		chinhSuaButton(btnMatcha);
		btnTiramisu = new JButton(getScaledIcon("/images/Tiramisu.png", 100, 100));
		chinhSuaButton(btnTiramisu);
		btnBanhSungTrau = new JButton(getScaledIcon("/images/BanhSungTrau.png", 100, 100));
		chinhSuaButton(btnBanhSungTrau);
		btnBanhDonut = new JButton(getScaledIcon("/images/BanhDonut.png", 100, 100));
		chinhSuaButton(btnBanhDonut);
		
		boxLabelMonRow1.add(Box.createHorizontalStrut(90));
		boxLabelMonRow1.add(lblCaPheDen);
		boxLabelMonRow1.add(Box.createHorizontalStrut(65));
		boxLabelMonRow1.add(lblCaPheSua);
		boxLabelMonRow1.add(Box.createHorizontalStrut(85));
		boxLabelMonRow1.add(lblBacXiu);
		
		boxLabelMonRow2.add(Box.createHorizontalStrut(110));
		boxLabelMonRow2.add(lblTraDao);
		boxLabelMonRow2.add(Box.createHorizontalStrut(105));
		boxLabelMonRow2.add(lblTraVai);
		boxLabelMonRow2.add(Box.createHorizontalStrut(95));
		boxLabelMonRow2.add(lblMathca);
		
		boxLabelMonRow3.add(Box.createHorizontalStrut(90));
		boxLabelMonRow3.add(lblTiramisu);
		boxLabelMonRow3.add(Box.createHorizontalStrut(65));
		boxLabelMonRow3.add(lblBanhSungTrau);
		boxLabelMonRow3.add(Box.createHorizontalStrut(70));
		boxLabelMonRow3.add(lblBanhDonut);
		
		
		
		boxMonRow1.add(Box.createHorizontalStrut(65));
		boxMonRow1.add(btnCaPheDen);
		boxMonRow1.add(Box.createHorizontalStrut(15));
		boxMonRow1.add(btnCaPheSua);
		boxMonRow1.add(Box.createHorizontalStrut(15));
		boxMonRow1.add(btnBacXiu);
		boxMonRow1.add(Box.createHorizontalStrut(15));
		
		boxMonRow2.add(Box.createHorizontalStrut(65));
		boxMonRow2.add(btnTraDao);
		boxMonRow2.add(Box.createHorizontalStrut(15));
		boxMonRow2.add(btnTraVai);
		boxMonRow2.add(Box.createHorizontalStrut(15));
		boxMonRow2.add(btnMatcha);
		boxMonRow2.add(Box.createHorizontalStrut(15));
		
		boxMonRow3.add(Box.createHorizontalStrut(65));
		boxMonRow3.add(btnTiramisu);
		boxMonRow3.add(Box.createHorizontalStrut(15));
		boxMonRow3.add(btnBanhSungTrau);
		boxMonRow3.add(Box.createHorizontalStrut(15));
		boxMonRow3.add(btnBanhDonut);
		boxMonRow3.add(Box.createHorizontalStrut(15));
		
		boxLabelMonRow1.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxLabelMonRow1.getPreferredSize().height));
		boxMonRow1.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxMonRow1.getPreferredSize().height));
		boxLabelMonRow2.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxLabelMonRow2.getPreferredSize().height));
		boxMonRow2.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxMonRow2.getPreferredSize().height));
		boxLabelMonRow3.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxLabelMonRow3.getPreferredSize().height));
		boxMonRow3.setMaximumSize(new Dimension(Integer.MAX_VALUE, boxMonRow2.getPreferredSize().height));
		
		boxChonMon.add(boxLabelMonRow1);
		boxChonMon.add(Box.createVerticalStrut(10));
		boxChonMon.add(boxMonRow1);
		boxChonMon.add(Box.createVerticalStrut(20));
		boxChonMon.add(boxLabelMonRow2);
		boxChonMon.add(Box.createVerticalStrut(10));
		boxChonMon.add(boxMonRow2);
		boxChonMon.add(Box.createVerticalStrut(20));
		boxChonMon.add(boxLabelMonRow3);
		boxChonMon.add(Box.createVerticalStrut(10));
		boxChonMon.add(boxMonRow3);
		boxChonMon.add(Box.createVerticalGlue());
		
		// Tạo một JPanel làm thanh phân cách
	    JPanel pDivider = new JPanel();
	    pDivider.setBackground(Color.decode("#e2dbd3"));
	    // Cố định chiều rộng là 2px (độ dày của vạch kẻ), chiều cao tự giãn (Integer.MAX_VALUE)
	    pDivider.setMaximumSize(new Dimension(20, Integer.MAX_VALUE)); 
	    pDivider.setPreferredSize(new Dimension(20, 0));
		
	    Box boxMainDatMon = Box.createHorizontalBox();
		boxMainDatMon.add(boxChonBan);
		boxMainDatMon.add(Box.createHorizontalStrut(10));
		// Thêm vạch kẻ có màu vào giữa
	    boxMainDatMon.add(pDivider);
	    boxMainDatMon.add(Box.createHorizontalStrut(10));
		boxMainDatMon.add(boxChonMon);
		pDatMon.add(boxMainDatMon,BorderLayout.CENTER);
		return pDatMon;
	}
	
	public JPanel createGiaoDienDonHang () {
		// 1. PHẦN ĐẦU (Header)
		JPanel pOrder = new JPanel(new BorderLayout());
        JPanel pHeaderOrder = new JPanel(new BorderLayout());
        pHeaderOrder.setBackground(Color.decode("#F3F4F6"));
        pHeaderOrder.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pTitleOrder = new JPanel(new GridLayout(2, 1));
        pTitleOrder.setBackground(Color.decode("#F3F4F6"));
        
        JLabel lblTitleOrder = new JLabel("Đơn hàng");
        lblTitleOrder.setFont(new Font("Arial", Font.BOLD, 18));
        
        lblStatusOrder = new JLabel(" Chưa chọn bàn! ");
        lblStatusOrder.setOpaque(true);
        lblStatusOrder.setBackground(Color.decode("#FEEDDA")); // Nền cam nhạt
        lblStatusOrder.setForeground(Color.decode("#D27832")); // Chữ cam đậm
        
        // Bọc label để không bị kéo giãn
        JPanel pStatusOrder = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pStatusOrder.setBackground(Color.decode("#F3F4F6"));
        pStatusOrder.add(lblStatusOrder);

        pTitleOrder.add(lblTitleOrder);
        pTitleOrder.add(pStatusOrder);

        btnDelete = new JButton("Xóa");
        btnDelete.setBackground(Color.decode("#ff4d4d")); // Nút xóa màu đỏ
        btnDelete.setForeground(Color.WHITE);

        pHeaderOrder.add(pTitleOrder, BorderLayout.CENTER);
        pHeaderOrder.add(btnDelete, BorderLayout.EAST);

        // 2. PHẦN GIỮA (Chưa có món)
        JPanel pCenterOrder = new JPanel(new BorderLayout());
        pCenterOrder.setBackground(Color.decode("#EEEEEE"));
     // Tạo TableModel với khung các cột cơ bản
        String[] columnNames = {"Tên món", "Đơn giá", "Số lượng", "Thành tiền"};
        orderTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Tạm thời khóa edit trực tiếp trên ô, sẽ xử lý logic tăng giảm sau
                return false; 
            }
        };

        // Khởi tạo JTable
        tblOrder = new JTable(orderTableModel);
        tblOrder.setTableHeader(null);
        tblOrder.setRowHeight(50); // Tăng chiều cao dòng để đủ khoảng trống layout giống ảnh
        tblOrder.setShowGrid(false); 
        tblOrder.setIntercellSpacing(new Dimension(0, 0));
        tblOrder.setBackground(Color.decode("#EEEEEE"));

        // Bọc Table trong ScrollPane
        JScrollPane scrollPane = new JScrollPane(tblOrder);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); 
        scrollPane.getViewport().setBackground(Color.decode("#EEEEEE"));

        pCenterOrder.add(scrollPane, BorderLayout.CENTER);

        // 3. PHẦN CUỐI (Thanh toán)
        JPanel pFooterOrder = new JPanel(new BorderLayout());
        pFooterOrder.setBackground(Color.decode("#F3F4F6"));
        pFooterOrder.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box boxFooter = Box.createVerticalBox();

        // Dòng tổng tiền
        JPanel pTotalOrder = new JPanel(new BorderLayout());
        pTotalOrder.setBackground(Color.decode("#F3F4F6"));
        JLabel lblTotalText = new JLabel("Thành tiền:");
        lblTotalText.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel lblTotalValue = new JLabel("0 đ");
        lblTotalValue.setFont(new Font("Arial", Font.BOLD, 22));
        lblTotalValue.setForeground(Color.decode("#AF7341")); // Màu nâu đậm
        
        pTotalOrder.add(lblTotalText, BorderLayout.WEST);
        pTotalOrder.add(lblTotalValue, BorderLayout.EAST);

        // Dòng chọn phương thức
        JPanel pMethodsOrder = new JPanel(new GridLayout(1, 3, 5, 0));
        pMethodsOrder.setBackground(Color.decode("#F3F4F6"));
        
        btnTienMat = new JButton("Tiền mặt");
        btnTienMat.setBackground(Color.decode("#AF7341")); // Đang chọn -> Nền nâu
        btnTienMat.setForeground(Color.WHITE);
        
        btnBanking = new JButton("Banking");
        btnBanking.setBackground(Color.WHITE);
        
        btnVi = new JButton("Ví Điện Tử");
        btnVi.setBackground(Color.WHITE);

        pMethodsOrder.add(btnTienMat);
        pMethodsOrder.add(btnBanking);
        pMethodsOrder.add(btnVi);

        // Nút Thanh toán
        btnCheckout = new JButton("THANH TOÁN");
        btnCheckout.setBackground(Color.decode("#B48C69")); // Màu nâu nhạt
        btnCheckout.setForeground(Color.WHITE);
        btnCheckout.setFont(new Font("Arial", Font.BOLD, 16));

        boxFooter.add(pTotalOrder);
        boxFooter.add(Box.createVerticalStrut(15));
        boxFooter.add(pMethodsOrder);
        boxFooter.add(Box.createVerticalStrut(15));
        boxFooter.add(btnCheckout);

        pFooterOrder.add(boxFooter, BorderLayout.CENTER);
        
        pOrder.add(pHeaderOrder, BorderLayout.NORTH);
        pOrder.add(pCenterOrder, BorderLayout.CENTER);
        pOrder.add(pFooterOrder, BorderLayout.SOUTH);
        
        pOrder.setPreferredSize(new Dimension(315, 0));
        
        return pOrder;
	}
	
	public void chinhSuaButton(JButton button) {
		button.setContentAreaFilled(false); // Xóa nền
		button.setBorderPainted(true);     // Xóa viền button
		button.setFocusPainted(false);      // Xóa vệt highlight khi click chuột
		button.setOpaque(false);// Đảm bảo button hoàn toàn trong suốt
	}
	
	public ImageIcon getScaledIcon(String path, int width, int height) {
	    ImageIcon icon = new ImageIcon(getClass().getResource(path));
	    Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return new ImageIcon(img);
	}

	// 2. Tạo phương thức gán ActionListener từ Controller
	public void addPOSListener(ActionListener listener) {
	    // Gán command để phân biệt nút nào được bấm
	    btnCaPheDen.setActionCommand("Món: Cà phê đen đá"); 
	    btnCaPheDen.addActionListener(listener);
	    btnCaPheSua.setActionCommand("Món: Cà phê sữa đá");
	    btnCaPheSua.addActionListener(listener);
	    btnBacXiu.setActionCommand("Món: Bạc xỉu");
	    btnBacXiu.addActionListener(listener);
	    btnTraDao.setActionCommand("Món: Trà đào");
	    btnTraDao.addActionListener(listener);
	    btnTraVai.setActionCommand("Món: Trà vải");
	    btnTraVai.addActionListener(listener);
	    btnMatcha.setActionCommand("Món: Matcha Latte");
	    btnMatcha.addActionListener(listener);
	    btnTiramisu.setActionCommand("Món: Tiramisu");
	    btnTiramisu.addActionListener(listener);
	    btnBanhSungTrau.setActionCommand("Món: Bánh sừng trâu");
	    btnBanhSungTrau.addActionListener(listener);
	    btnBanhDonut.setActionCommand("Món: Bánh Donut");
	    btnBanhDonut.addActionListener(listener);
	    btnBan1.setActionCommand("Bàn 1");
	    btnBan1.addActionListener(listener);
	    btnBan2.setActionCommand("Bàn 2");
	    btnBan2.addActionListener(listener);
	    btnBan3.setActionCommand("Bàn 3");
	    btnBan3.addActionListener(listener);
	    btnBan4.setActionCommand("Bàn 4");
	    btnBan4.addActionListener(listener);
	    btnBan5.setActionCommand("Bàn 5");
	    btnBan5.addActionListener(listener);
	    btnBan6.setActionCommand("Bàn 6");
	    btnBan6.addActionListener(listener);
	    
	    btnDelete.setActionCommand("Xoa");
	    btnDelete.addActionListener(listener);
	    btnTienMat.setActionCommand("TienMat");
	    btnTienMat.addActionListener(listener);
	    btnTimMon.setActionCommand("TimMon");
	    btnTimMon.addActionListener(listener);
	    btnBanking.setActionCommand("Banking");
	    btnBanking.addActionListener(listener);
	    btnVi.setActionCommand("Vi");
	    btnVi.addActionListener(listener);
	    
	    // Nút thanh toán
	    btnCheckout.setActionCommand("ThanhToan");
	    btnCheckout.addActionListener(listener);
	    
	    cbMangDi.setActionCommand("MangDi");
	    cbMangDi.addActionListener(listener);
	    cbTaiCho.setActionCommand("TaiCho");
	    cbTaiCho.addActionListener(listener);
	}

	public void setTrangThaiDonHang(String text) {
	    lblStatusOrder.setText(text);
	}

	public void setKichHoatBan(boolean isEnable) {
	    btnBan1.setEnabled(isEnable);
	    btnBan2.setEnabled(isEnable);
	    btnBan3.setEnabled(isEnable);
	    btnBan4.setEnabled(isEnable);
	    btnBan5.setEnabled(isEnable);
	    btnBan6.setEnabled(isEnable);
	}
	
} 