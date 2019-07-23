package radar_health_monitoring_system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;

//import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.net.Socket;

import java.awt.event.ActionEvent;
import java.io.*;

public class Sender {

	static String tosend = "";
//	static String header;
//	static String flag;

	private JFrame frmSender;
	private JLabel lbl_ant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sender window = new Sender();
					window.frmSender.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Sender() {
		initialize();

		// serverIP = s;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSender = new JFrame();
		frmSender.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frmSender.setOpacity(1.0f);
		frmSender.setTitle("SENDER ");
		frmSender.getContentPane().setBackground(Color.WHITE);
		frmSender.setBackground(Color.PINK);
		frmSender.setBounds(100, 100, 664, 512);
		frmSender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSender.getContentPane().setLayout(null);

		// variables
		// radio buttons initializes
		JRadioButton rbtna1 = new JRadioButton("Normal\r\n"); // antenna
		JRadioButton rbtna2 = new JRadioButton("Warning");
		JRadioButton rbtna3 = new JRadioButton("Critical");

		JRadioButton rbtnt1 = new JRadioButton("Normal\r\n"); // transmitter
		JRadioButton rbtnt2 = new JRadioButton("Warning");
		JRadioButton rbtnt3 = new JRadioButton("Critical");

		JRadioButton rbtnr1 = new JRadioButton("Normal\r\n"); // receiver
		JRadioButton rbtnr2 = new JRadioButton("Warning");
		JRadioButton rbtnr3 = new JRadioButton("Critical");

		JRadioButton rbtnrd1 = new JRadioButton("Normal\r\n"); // rdp
		JRadioButton rbtnrd2 = new JRadioButton("Warning");
		JRadioButton rbtnrd3 = new JRadioButton("Critical");

		JRadioButton rdbtnOk = new JRadioButton("OK"); // health
		JRadioButton rdbtnDown = new JRadioButton("Down");

		// **********************

		// send button action for Antenna
		JButton btn_ant = new JButton("Send");

		btn_ant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Antenna an = new Antenna();
				if (rbtna1.isSelected()) {
					an.flag = 0;
					// System.out.println("selected: header"+an.header+
					// an.flag);
				} else if (rbtna2.isSelected()) {
					an.flag = 1;
					// System.out.println("selected: header"+an.header+
					// an.flag);
				} else if (rbtna3.isSelected()) {
					an.flag = 2;
					// System.out.println("selected: header"+an.header+
					// an.flag);
				} else {
					JOptionPane.showMessageDialog(frmSender, "nothing selected");

				}
				tosend = an.header + "@" + an.flag;
				sendData(tosend); // function to send data to server see def: in
									// line 571
			}
		});
		// Transmitter button send action
		JButton btn_trans = new JButton("Send");
		btn_trans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transmitter tm = new Transmitter();
				if (rbtnt1.isSelected()) {
					tm.flag = 0;
					System.out.println("selected: header" + tm.header + tm.flag);
				} else if (rbtnt2.isSelected()) {
					tm.flag = 1;
					System.out.println("selected: header" + tm.header + tm.flag);
				} else if (rbtnt3.isSelected()) {
					tm.flag = 2;
					System.out.println("selected: header" + tm.header + tm.flag);
				} else {
					JOptionPane.showMessageDialog(frmSender, "nothing selected");

				}
				tosend = tm.header + "@" + tm.flag;
				sendData(tosend);

			}
		});
		// receiver send button action

		JButton btn_rx = new JButton("Send");
		btn_rx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receiver rx = new Receiver();
				if (rbtnr1.isSelected()) {
					rx.flag = 0;
					System.out.println("selected: header" + rx.header + rx.flag);
				} else if (rbtnr2.isSelected()) {
					rx.flag = 1;
					System.out.println("selected: header" + rx.header + rx.flag);
				} else if (rbtnr3.isSelected()) {
					rx.flag = 2;
					System.out.println("selected: header" + rx.header + rx.flag);
				} else {
					JOptionPane.showMessageDialog(frmSender, "nothing selected");

				}
				tosend = rx.header + "@" + rx.flag;
				sendData(tosend);

			}
		});

		// rdp send button action

		JButton btn_rdp = new JButton("Send");
		btn_rdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rdp rd = new Rdp();
				if (rbtnrd1.isSelected()) {
					rd.flag = 0;
					System.out.println("selected: header" + rd.header + rd.flag);
				} else if (rbtnrd2.isSelected()) {
					rd.flag = 1;
					System.out.println("selected: header" + rd.header + rd.flag);
				} else if (rbtnrd3.isSelected()) {
					rd.flag = 2;
					System.out.println("selected: header" + rd.header + rd.flag);
				} else {
					JOptionPane.showMessageDialog(frmSender, "nothing selected");

				}

				tosend = rd.header + "@" + rd.flag;
				sendData(tosend); // function used to reuse

			}
		});

		// health send button action

		JButton btn_health = new JButton("Send");
		btn_health.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Health ht = new Health();
				if (rdbtnOk.isSelected()) {
					ht.flag = 0;
					System.out.println("selected: header" + ht.header + ht.flag);
				} else if (rdbtnDown.isSelected()) {
					ht.flag = 1;
					System.out.println("selected: header" + ht.header + ht.flag);
				}

				else {
					JOptionPane.showMessageDialog(frmSender, "nothing selected");

				}

				tosend = ht.header + "@" + ht.flag;
				sendData(tosend);

			}
		});

		// ***********************************************

		// variables used and gui material

		lbl_ant = new JLabel("");
		lbl_ant.setBackground(new Color(0, 0, 0));
		// adding image of antenna
		Image img = new ImageIcon(this.getClass().getResource("/ant.png")).getImage();
		lbl_ant.setIcon(new ImageIcon(img));
		lbl_ant.setBounds(29, 21, 117, 109);
		frmSender.getContentPane().add(lbl_ant);

		JLabel title_ant = new JLabel("Antenna");
		title_ant.setFont(new Font("Tahoma", Font.BOLD, 16));
		title_ant.setBackground(Color.GRAY);
		title_ant.setBounds(42, 153, 104, 20);
		frmSender.getContentPane().add(title_ant);

		btn_ant.setFont(new Font("Tahoma", Font.BOLD, 11));
		Image bimg = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btn_ant.setIcon(new ImageIcon(bimg));
		btn_ant.setBounds(29, 261, 98, 23);
		frmSender.getContentPane().add(btn_ant);

		JLabel lbl_trans = new JLabel("");
		Image img_trans = new ImageIcon(this.getClass().getResource("/trans.jpg")).getImage();
		lbl_trans.setIcon(new ImageIcon(img_trans));

		lbl_trans.setBounds(215, 21, 117, 109);
		frmSender.getContentPane().add(lbl_trans);

		JLabel title_trans = new JLabel("Transmitter");
		title_trans.setFont(new Font("Tahoma", Font.BOLD, 16));
		title_trans.setBounds(234, 158, 98, 14);
		frmSender.getContentPane().add(title_trans);

		Image bimg2 = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btn_trans.setIcon(new ImageIcon(bimg2));
		btn_trans.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_trans.setBounds(215, 261, 89, 23);
		frmSender.getContentPane().add(btn_trans);

		JLabel lbl_rx = new JLabel("");
		Image img_rx = new ImageIcon(this.getClass().getResource("/reciever.jpg")).getImage();
		lbl_rx.setIcon(new ImageIcon(img_rx));

		lbl_rx.setBounds(385, 21, 117, 109);
		frmSender.getContentPane().add(lbl_rx);

		JLabel title_rx = new JLabel("Receiver");
		title_rx.setFont(new Font("Tahoma", Font.BOLD, 16));
		title_rx.setBounds(407, 158, 79, 14);
		frmSender.getContentPane().add(title_rx);

		Image bimg3 = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btn_rx.setIcon(new ImageIcon(bimg3));

		btn_rx.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_rx.setBounds(385, 261, 89, 23);
		frmSender.getContentPane().add(btn_rx);

		JLabel lbl_rdp = new JLabel("");
		Image img_rdp = new ImageIcon(this.getClass().getResource("/rdp.jpg")).getImage();
		lbl_rdp.setIcon(new ImageIcon(img_rdp));

		lbl_rdp.setBounds(10, 320, 117, 109);
		frmSender.getContentPane().add(lbl_rdp);

		JLabel title_rdp = new JLabel("   RDP");
		title_rdp.setFont(new Font("Tahoma", Font.BOLD, 16));
		title_rdp.setBounds(29, 440, 98, 14);
		frmSender.getContentPane().add(title_rdp);

		Image bimg4 = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btn_rdp.setIcon(new ImageIcon(bimg4));

		btn_rdp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_rdp.setBounds(137, 406, 89, 23);
		frmSender.getContentPane().add(btn_rdp);

		JLabel lbl_health = new JLabel("");
		Image img_health = new ImageIcon(this.getClass().getResource("/health.jpg")).getImage();
		lbl_health.setIcon(new ImageIcon(img_health));

		lbl_health.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_health.setBounds(317, 302, 128, 127);
		frmSender.getContentPane().add(lbl_health);

		JLabel title_health = new JLabel("Health");
		title_health.setFont(new Font("Tahoma", Font.BOLD, 16));
		title_health.setBounds(358, 440, 84, 14);
		frmSender.getContentPane().add(title_health);

		Image bimg5 = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btn_health.setIcon(new ImageIcon(bimg5));

		btn_health.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_health.setBounds(455, 382, 89, 23);
		frmSender.getContentPane().add(btn_health);

		// gui ends

		// antenna radio button actions

		rbtna1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtna1.isSelected()) {
					rbtna2.setSelected(false);
					rbtna3.setSelected(false);

				}

			}
		});
		rbtna1.setBackground(Color.GREEN);
		rbtna1.setBounds(18, 179, 109, 23);
		frmSender.getContentPane().add(rbtna1);

		rbtna2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtna2.isSelected()) {
					rbtna1.setSelected(false);
					rbtna3.setSelected(false);
				}

			}
		});
		rbtna2.setBackground(Color.ORANGE);
		rbtna2.setBounds(18, 205, 109, 23);
		frmSender.getContentPane().add(rbtna2);

		rbtna3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rbtna3.isSelected()) {
					rbtna1.setSelected(false);
					rbtna2.setSelected(false);
				}
				Antenna a3 = new Antenna();
				a3.flag = 2;
			}
		});
		rbtna3.setBackground(Color.RED);
		rbtna3.setBounds(18, 231, 109, 23);
		frmSender.getContentPane().add(rbtna3);

		// transmitter radio button action
		rbtnt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnt1.isSelected()) {
					rbtnt2.setSelected(false);
					rbtnt3.setSelected(false);
				}
			}
		});
		rbtnt1.setBackground(Color.GREEN);
		rbtnt1.setBounds(223, 179, 109, 23);
		frmSender.getContentPane().add(rbtnt1);

		rbtnt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnt2.isSelected()) {
					rbtnt1.setSelected(false);
					rbtnt3.setSelected(false);
				}
			}
		});

		rbtnt2.setBackground(Color.ORANGE);
		rbtnt2.setBounds(223, 205, 109, 23);
		frmSender.getContentPane().add(rbtnt2);

		rbtnt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnt3.isSelected()) {
					rbtnt1.setSelected(false);
					rbtnt2.setSelected(false);
				}
			}
		});
		rbtnt3.setBackground(Color.RED);
		rbtnt3.setBounds(223, 231, 109, 23);
		frmSender.getContentPane().add(rbtnt3);

		// receiver radio button action

		rbtnr1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnr1.isSelected()) {
					rbtnr2.setSelected(false);
					rbtnr3.setSelected(false);
				}
			}
		});

		rbtnr1.setBackground(Color.GREEN);
		rbtnr1.setBounds(385, 179, 109, 23);
		frmSender.getContentPane().add(rbtnr1);

		rbtnr2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnr2.isSelected()) {
					rbtnr1.setSelected(false);
					rbtnr3.setSelected(false);
				}
			}
		});

		rbtnr2.setBackground(Color.ORANGE);
		rbtnr2.setBounds(385, 205, 109, 23);
		frmSender.getContentPane().add(rbtnr2);

		rbtnr3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnr3.isSelected()) {
					rbtnr1.setSelected(false);
					rbtnr2.setSelected(false);
				}
			}
		});

		rbtnr3.setBackground(Color.RED);
		rbtnr3.setBounds(385, 231, 109, 23);
		frmSender.getContentPane().add(rbtnr3);

		// RDP radio button
		rbtnrd1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnrd1.isSelected()) {
					rbtnrd2.setSelected(false);
					rbtnrd3.setSelected(false);
				}
			}
		});

		rbtnrd1.setBackground(Color.GREEN);
		rbtnrd1.setBounds(147, 320, 109, 23);
		frmSender.getContentPane().add(rbtnrd1);

		rbtnrd2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnrd2.isSelected()) {
					rbtnrd3.setSelected(false);
					rbtnrd1.setSelected(false);
				}
			}
		});

		rbtnrd2.setBackground(Color.ORANGE);
		rbtnrd2.setBounds(147, 346, 109, 23);
		frmSender.getContentPane().add(rbtnrd2);

		rbtnrd3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbtnrd3.isSelected()) {
					rbtnrd2.setSelected(false);
					rbtnrd1.setSelected(false);
				}
			}
		});

		rbtnrd3.setBackground(Color.RED);
		rbtnrd3.setBounds(147, 372, 109, 23);
		frmSender.getContentPane().add(rbtnrd3);

		// radar health radio button action

		rdbtnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnOk.isSelected()) {
					rdbtnDown.setSelected(false);

				}
			}
		});

		rdbtnOk.setBackground(Color.GREEN);
		rdbtnOk.setBounds(451, 320, 109, 23);
		frmSender.getContentPane().add(rdbtnOk);

		rdbtnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnDown.isSelected()) {
					rdbtnOk.setSelected(false);

				}
			}
		});

		rdbtnDown.setBackground(Color.RED);
		rdbtnDown.setBounds(451, 346, 109, 23);
		frmSender.getContentPane().add(rdbtnDown);

		// exit button
		JButton btnExit = new JButton("Exit");

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tosend = "exit";
				sendData(tosend);
			}
		});
		btnExit.setBounds(518, 43, 89, 23);
		frmSender.getContentPane().add(btnExit);
	}

	public static void sendData(String send) {
		try (Socket socket = new Socket("localhost", 5000)) {
			BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
			String response;
			String s = send;
			stringToEcho.println(s);
			if (!s.equals("exit")) {
				response = echoes.readLine();
				System.out.println("client side " + response);
			}
		} catch (IOException e) {
			System.out.println("error" + e);

		}

	}

	public class Antenna {
		short header;
		short flag;

		Antenna() {
			header = 0x400;
		}

	}

	public class Transmitter {
		short header;
		short flag;

		Transmitter() {
			header = 0x401;
		}

	}

	public class Receiver {
		short header;
		short flag;

		Receiver() {
			header = 0x402;
		}

	}

	public class Rdp {
		short header;
		short flag;

		Rdp() {
			header = 0x403;
		}
	}

	public class Health {
		short header;
		short flag;

		Health() {
			header = 0x404;
		}
	}
}
