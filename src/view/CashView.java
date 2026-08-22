package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Shop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CashView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCash;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ShowCashGUI dialog = new ShowCashGUI();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public CashView(Shop shop) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Caixa");
		
		JLabel lblCash = new JLabel("Diners en caixa:");
		lblCash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCash.setBounds(49, 36, 196, 28);
		contentPanel.add(lblCash);
		
		textFieldCash = new JTextField();
		textFieldCash.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldCash.setEnabled(false);
		textFieldCash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCash.setBounds(117, 75, 86, 20);
		contentPanel.add(textFieldCash);
		textFieldCash.setColumns(10);
		textFieldCash.setText(shop.getCash().toString());
//		{
//			JPanel buttonPane = new JPanel();
//			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
//			getContentPane().add(buttonPane, BorderLayout.SOUTH);
//			{
//				JButton okButton = new JButton("OK");
//				okButton.setActionCommand("OK");
//				buttonPane.add(okButton);
//				getRootPane().setDefaultButton(okButton);
//			}
//			{
//				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
//				buttonPane.add(cancelButton);
//			}
//		}
	}
}
