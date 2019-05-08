package com.qq.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.qq.regist.Regist;
import com.qq.regist.UserInformation;

/**
士大夫
 * 问问
 * 删了123
 * QQ��������
 * 凑合在浏览器改改
 * @param args
 */

public class Main extends JFrame {

	private JLabel userId;
	private JLabel userPassword;
	private JTextField inputId;
	private JPasswordField inputPassword;
	private JButton btLogin;
	private JButton btRegist;

	Main() {
		userId = new JLabel("�ʺ�");
		userPassword = new JLabel("����");
		inputId = new JTextField(6);// ���ʣ�����
		inputPassword = new JPasswordField();
		btLogin = new JButton("��½");
		btRegist = new JButton("ע��");

		// ���ô�������
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		int x = (int) screenSize.getWidth();
		int y = (int) screenSize.getHeight();
		this.setBounds((x - 240) / 2, (y - 600) / 2, 240, 600);
		this.setResizable(false);
		this.setLayout(null);

		this.setBackground(Color.BLACK);// ���ʣ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ����JLabel����
		userId.setBounds(30, 160, 40, 20);
		userPassword.setBounds(30, 200, 40, 20);
		// �����ı�������
		inputId.setBounds(90, 160, 100, 20);
		inputPassword.setBounds(90, 200, 100, 20);
		inputPassword.setEchoChar('*');
		// ����JButton����
		btLogin.setBounds(50, 240, 60, 20);
		btRegist.setBounds(120, 240, 60, 20);

		// ע�ᡶ��½����ť������
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation user = new UserInformation();
				String userName = inputId.getText();
				String userPassword = new String(inputPassword.getPassword());
				if (userName.equals("")) {
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				} else if ("".equals(userPassword)) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
				} else if (user.isExist(userName)
						&& user.userInfomation.getProperty(userName).equals(
								userPassword)) {
					// �жϳɹ���newһ��Ⱥ�Ĵ���
					new AllTalkFrame(userName).setVisible(true);
					Main.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "���û��������ڻ������벻��ȷ");
				}
			}
		});

		// ע�ᡶע�ᡷ��ť������
		btRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Regist();
			}
		});
		this.add(userId);
		this.add(userPassword);
		this.add(inputId);
		this.add(inputPassword);
		this.add(btLogin);
		this.add(btRegist);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}
