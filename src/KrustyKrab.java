import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.text.NumberFormat;


public class KrustyKrab extends JFrame

{
	private static final long serialVersionUID = 1L;

	public double customer_price;
	private double kp_value = 2.99, dkp_value = 3.50, ks_value = 0.99, f_value = 1.99;
	private ImageIcon squidward;
	private JButton krabby_patty, double_krabby_patty, kelp_shake, fries, clear;
	private JTextField total_price;
	private JLabel kp_price, dkp_price, kelp_price, fries_price, total_label, squid_label;

	public KrustyKrab() {

		createView();
		
		setSize(285, 350);
		setTitle("The Krusty Krab Simulator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);	
	}

	public void createView() {
		JPanel panel = new JPanel(new FlowLayout());
		getContentPane().add(panel);

		krabby_patty = new JButton("Krabby Patty");
		krabby_patty.addActionListener(new KrabbyCounterActionListener());
		panel.add(krabby_patty);

		kp_price = new JLabel("$2.99");
		kp_price.setPreferredSize(new Dimension(100, 30));
		panel.add(kp_price);

		double_krabby_patty = new JButton("Double Krabby Patty");
		double_krabby_patty.addActionListener(new DoubleKrabbyCounterActionListener());
		panel.add(double_krabby_patty);

		dkp_price = new JLabel("$3.50");
		dkp_price.setPreferredSize(new Dimension(100, 30));
		panel.add(dkp_price);

		kelp_shake = new JButton("Kelp Shake");
		kelp_shake.addActionListener(new KelpCounterActionListener());
		panel.add(kelp_shake);

		kelp_price = new JLabel("$0.99");
		kelp_price.setPreferredSize(new Dimension(100, 30));
		panel.add(kelp_price);

		fries = new JButton("Fries");
		fries.addActionListener(new FriesCounterActionListener());
		panel.add(fries);

		fries_price = new JLabel("$1.99");
		fries_price.setPreferredSize(new Dimension(100, 30));
		panel.add(fries_price);

		total_label = new JLabel("Total:");
		total_label.setPreferredSize(new Dimension(100, 30));
		panel.add(total_label);

		total_price = new JTextField();
		total_price.setPreferredSize(new Dimension(80, 40));
		total_price.setEditable(false);
		panel.add(total_price);

		clear = new JButton("Clear");
		clear.addActionListener(new ClearCounterActionListener());
		panel.add(clear);
		
		squidward = new ImageIcon(getClass().getResource("squidward.jpg"));
		squid_label = new JLabel(squidward);
		panel.add(squid_label);

	}


	public class ClearCounterActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			customer_price = 0;
			total_price.setText("$" + customer_price);
			System.out.println(customer_price);
		}
	}

	public class FriesCounterActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			customer_price += f_value;
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setGroupingUsed(true);
			nf.setMaximumFractionDigits(2);
			nf.setMinimumIntegerDigits(1);
			String totalOut = nf.format(customer_price);
			total_price.setText("$" + totalOut);
			System.out.println(customer_price);

		}

	}

	public class KelpCounterActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			customer_price += ks_value;
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setGroupingUsed(true);
			nf.setMaximumFractionDigits(2);
			nf.setMinimumIntegerDigits(1);
			String totalOut = nf.format(customer_price);
			total_price.setText("$" + totalOut);
			System.out.println(customer_price);

		}

	}

	public class DoubleKrabbyCounterActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			customer_price += dkp_value;
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setGroupingUsed(true);
			nf.setMaximumFractionDigits(2);
			nf.setMinimumIntegerDigits(1);
			String totalOut = nf.format(customer_price);
			total_price.setText("$" + totalOut);
			System.out.println(customer_price);

		}

	}

	public class KrabbyCounterActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			customer_price += kp_value;
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setGroupingUsed(true);
			nf.setMaximumFractionDigits(2);
			nf.setMinimumIntegerDigits(1);
			String totalOut = nf.format(customer_price);
			total_price.setText("$" + totalOut);
			System.out.println(customer_price);

		}

	}

	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new KrustyKrab().setVisible(true);
				;
			}

		});

	}

}
