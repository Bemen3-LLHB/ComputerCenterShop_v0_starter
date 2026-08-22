package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Shop;
import utils.Constants;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

public class ShopView extends JFrame implements ActionListener, KeyListener{

	private static final long serialVersionUID = 1L;
	private Shop shop;
	
	private JPanel contentPane;
	private JButton btnShowCash;
	private JButton btnAddProduct;
	private JButton btnAddStock;
	private JButton btnRemoveProduct;
	
	
	

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopView frame = new ShopView();
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
	public ShopView() {
		setTitle("ComputerCenter - Menú principal");
		// listen key
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		// create shop
		shop = new Shop();
		shop.loadInventory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblShowCash = new JLabel("Seleccioneu o premeu una opció:");
		lblShowCash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblShowCash.setBounds(57, 20, 236, 14);
		contentPane.add(lblShowCash);
		
		// option count cash
		btnShowCash = new JButton("1. Comptar caixa");
		btnShowCash.setHorizontalAlignment(SwingConstants.LEFT);
		btnShowCash.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShowCash.setBounds(99, 40, 236, 40);
		contentPane.add(btnShowCash);
		// listen button
		btnShowCash.addActionListener(this);
		
		// option add product
		btnAddProduct = new JButton("2. Afegir article");
		btnAddProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddProduct.setBounds(99, 90, 236, 40);
		contentPane.add(btnAddProduct);
		// listen button
		btnAddProduct.addActionListener(this);
		
		// option add stock
		btnAddStock = new JButton("3. Afegir estoc");
		btnAddStock.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddStock.setBounds(99, 140, 236, 40);
		contentPane.add(btnAddStock);
		// listen button
		btnAddStock.addActionListener(this);

		// option add product
		btnRemoveProduct = new JButton("9. Eliminar article");
		btnRemoveProduct.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemoveProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemoveProduct.setBounds(99, 190, 236, 40);
		contentPane.add(btnRemoveProduct);
		// listen button
		btnRemoveProduct.addActionListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == '1' ) {
			this.openCashView();	
        }
		if (e.getKeyChar() == '2') {
			this.openProductView(Constants.OPTION_ADD_PRODUCT);	
		}
		if (e.getKeyChar() == '3') {
			this.openProductView(Constants.OPTION_ADD_STOCK);
		}
		if (e.getKeyChar() == '9') {
			this.openProductView(Constants.OPTION_REMOVE_PRODUCT);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnShowCash) {
			this.openCashView();						
		}
		if (e.getSource() == btnAddProduct) {
			this.openProductView(Constants.OPTION_ADD_PRODUCT);						
		}
		if (e.getSource() == btnAddStock) {
			this.openProductView(Constants.OPTION_ADD_STOCK);				
		}
		if (e.getSource() == btnRemoveProduct) {
			this.openProductView(Constants.OPTION_REMOVE_PRODUCT);				
		}
		
	}
	
	/**
	 * open dialog to show shop cash
	 */
	public void openCashView() {
		// create a dialog Box
        CashView dialog = new CashView(shop);  
        // setsize of dialog
        dialog.setSize(400, 400);
        // set visibility of dialog
        dialog.setModal(true);
        dialog.setVisible(true);
	}
	
	/**
	 * open dialog to add/remove/stock product
	 */
	public void openProductView(int option) {
		// create a dialog Box
		ProductView dialog = new ProductView(shop, option);  
        // setsize of dialog
        dialog.setSize(400, 400);
        // set visibility of dialog
        dialog.setModal(true);
        dialog.setVisible(true);
	}
	
	
}
