package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import exception.LimitLoginException;
import model.Employee;
import utils.Constants;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmployeeId;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private int counterErrorLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("ComputerCenter - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmployeeId = new JLabel("Número d'empleat");
		lblEmployeeId.setBounds(55, 50, 130, 14);
		contentPane.add(lblEmployeeId);

		textFieldEmployeeId = new JTextField();
		textFieldEmployeeId.setBounds(65, 75, 176, 20);
		contentPane.add(textFieldEmployeeId);
		textFieldEmployeeId.setColumns(10);

		JLabel lblPassword = new JLabel("Contrasenya");
		lblPassword.setBounds(55, 115, 130, 14);
		contentPane.add(lblPassword);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(65, 140, 176, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);

		btnLogin = new JButton("Accedir");
		btnLogin.setBounds(308, 208, 89, 23);
		contentPane.add(btnLogin);
		// listen button 
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			// in case clicks button
			String employeeId = textFieldEmployeeId.getText();
			String password = textFieldPassword.getText();

			if (employeeId.isEmpty() || password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Usuari i contrasenya són obligatoris", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				Employee employee = new Employee();
				try {
					boolean logged = employee.login(Integer.parseInt(employeeId), password);
					
					if (Constants.MAX_LOGIN_TIMES <= counterErrorLogin) {
						throw new LimitLoginException("Error login superado", counterErrorLogin);
					}
					if (logged) {
						// redirect to shop window
						ShopView shop = new ShopView();
						shop.setExtendedState(NORMAL);
						shop.setVisible(true);
						
						// release current screen
						dispose();					
						
					} else {
						counterErrorLogin++;
						JOptionPane.showMessageDialog(null, "Usuari o contrasenya incorrectes ", "Error",
								JOptionPane.ERROR_MESSAGE);
						
						// clean login form
						textFieldEmployeeId.setText("");
						textFieldPassword.setText("");
					}
				} catch (LimitLoginException ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, ("Error de login, superats els " + counterErrorLogin + " intents"), "Error",
							JOptionPane.ERROR_MESSAGE);
					// release current screen
					dispose();
				}
				
			}

		}
	}
}
