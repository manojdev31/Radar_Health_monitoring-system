package radar_health_monitoring_system;

import java.awt.Color;
import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Font;

import java.awt.Image;
import java.net.*;
import java.io.*;


import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Server {

	private JFrame frmReceiver;
	private JLabel lblTransmitter;
	private JLabel lblReceiver;
	private JLabel lblRdp;
	private JLabel lbl_plus;
	private JLabel lblHealth;
        public static String recieved;
        public static String str;

	/**
	 * Launch the application.
	 */
	
	


	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}
	
	private void initialize() {
		frmReceiver = new JFrame();
		frmReceiver.setTitle("Receiver");
		frmReceiver.setBounds(100, 100, 667, 409);
		frmReceiver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReceiver.getContentPane().setLayout(null);
		
		JLabel lblAntenna = new JLabel("Antenna");
		lblAntenna.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAntenna.setBounds(29, 125, 77, 14);
		frmReceiver.getContentPane().add(lblAntenna);
		
		lblTransmitter = new JLabel("Transmitter");
		lblTransmitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTransmitter.setBounds(192, 125, 110, 14);
		frmReceiver.getContentPane().add(lblTransmitter);
		
		lblReceiver = new JLabel("Receiver");
		lblReceiver.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblReceiver.setBounds(357, 125, 86, 14);
		frmReceiver.getContentPane().add(lblReceiver);
		
		lblRdp = new JLabel("RDP");
		lblRdp.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRdp.setBounds(507, 125, 86, 14);
		frmReceiver.getContentPane().add(lblRdp);
		
		lbl_plus = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/plus.png")).getImage();
		lbl_plus.setIcon(new ImageIcon(img));
		lbl_plus.setBounds(359, 14, 61, 48);
		frmReceiver.getContentPane().add(lbl_plus);
		
		lblHealth = new JLabel("Health");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHealth.setBounds(369, 73, 46, 14);
		frmReceiver.getContentPane().add(lblHealth);
		
		
		rbtnAntenna2.setBounds(18, 182, 109, 23);
		frmReceiver.getContentPane().add(rbtnAntenna2);
		
		
		rbtnAntenna3.setBounds(18, 208, 109, 23);
		frmReceiver.getContentPane().add(rbtnAntenna3);
		
		
		rbtnTrans1.setBounds(181, 156, 109, 23);
		frmReceiver.getContentPane().add(rbtnTrans1);
		
		
		rbtnTrans2.setBounds(181, 182, 109, 23);
		frmReceiver.getContentPane().add(rbtnTrans2);
		
		
		rbtnTrans3.setBounds(182, 208, 109, 23);
		frmReceiver.getContentPane().add(rbtnTrans3);
		
		
		rbtnRx1.setBounds(346, 156, 109, 23);
		frmReceiver.getContentPane().add(rbtnRx1);
		
		
		rbtnRx2.setBounds(346, 182, 109, 23);
		frmReceiver.getContentPane().add(rbtnRx2);
		
		
		rbtnRx3.setBounds(346, 208, 109, 23);
		frmReceiver.getContentPane().add(rbtnRx3);
		
		
		rbtnRdp1.setBounds(498, 156, 109, 23);
		frmReceiver.getContentPane().add(rbtnRdp1);
		
		
		rbtnRdp2.setBounds(498, 182, 109, 23);
		frmReceiver.getContentPane().add(rbtnRdp2);
		
		
		rbtnRdp3.setBounds(498, 208, 109, 23);
		frmReceiver.getContentPane().add(rbtnRdp3);
		
		
		rdbtnOk.setBounds(445, 10, 109, 23);
		frmReceiver.getContentPane().add(rdbtnOk);
		
		
		rdbtnDown.setBounds(445, 39, 109, 23);
		frmReceiver.getContentPane().add(rdbtnDown);
		
		
		rbtnAntenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		rbtnAntenna.setBounds(18, 156, 109, 23);
		frmReceiver.getContentPane().add(rbtnAntenna);
		
		
		
	}
	// radiobutton variables
	static JRadioButton rbtnAntenna = new JRadioButton("Normal");
	static JRadioButton rbtnAntenna2 = new JRadioButton("Warning");
	static JRadioButton rbtnAntenna3 = new JRadioButton("Critical");
	static JRadioButton rbtnTrans1 = new JRadioButton("Normal");
	static JRadioButton rbtnTrans2 = new JRadioButton("Warning");
	static JRadioButton rbtnTrans3 = new JRadioButton("Critical");
	static JRadioButton rbtnRdp1 = new JRadioButton("Normal");
	static JRadioButton rbtnRdp2 = new JRadioButton("Warning");
	static JRadioButton rbtnRdp3 = new JRadioButton("Critical");
	static JRadioButton rbtnRx1 = new JRadioButton("Normal");
	static JRadioButton rbtnRx2 = new JRadioButton("Warning");
	static JRadioButton rbtnRx3 = new JRadioButton("Critical");
	static JRadioButton rdbtnOk = new JRadioButton("OK");
	static JRadioButton rdbtnDown = new JRadioButton("DOWN");
	
	
	public static void main(String[] args) throws IOException{
        
       	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Server window = new Server();
				window.frmReceiver.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
       	
       	// *************************** try
       	while(true){
       	try(ServerSocket serverSocket = new ServerSocket(5000)){
          	 Socket socket = serverSocket.accept();
          	 System.out.println("client connected");
          	 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          	 PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
          	   String echoString = input.readLine();
          	    
          	   if(!echoString.equals("exit")){
          	   output.println("echo from server" + echoString);
          	   String[]str =echoString.split("@");
          	   recieved=echoString;
          	   seeOutput(str);
          	   }
          	   else{
          		   System.exit(1);
          	   }
          	 }
           catch(IOException e){
        	   
             	 System.out.println("server exception"+ e.getMessage());
              }
       	}
       	//************************************************
      }
	     public static void seeOutput(String[] st) throws MalformedURLException{
	    	   if(st[0].equals("1024")){
	    		   switch(st[1]){
	    		   case "0":
	    			   //color
	    			   rbtnAntenna.setBackground(Color.GREEN);
	    			   rbtnAntenna2.setBackground(Color.lightGray);
	    			   rbtnAntenna3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnAntenna.setSelected(true);
	    			   rbtnAntenna2.setSelected(false);
	    			   rbtnAntenna3.setSelected(false);
	                   // enabled
	                  rbtnAntenna.setEnabled(true);
	                  rbtnAntenna2.setEnabled(false);
		              rbtnAntenna3.setEnabled(false);
		            
	                  break;
	    		   case"1":
	    			   //color
	    			   rbtnAntenna.setBackground(Color.lightGray);
	    			   rbtnAntenna2.setBackground(Color.orange);
	    			   rbtnAntenna3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnAntenna.setSelected(false);
	    			   rbtnAntenna2.setSelected(true);
	    			   rbtnAntenna3.setSelected(false);
	                   // enabled
	                  rbtnAntenna.setEnabled(false);
	                  rbtnAntenna2.setEnabled(true);
		              rbtnAntenna3.setEnabled(false);
		             
		              break;
	    			   
	    		   case "2":
	    			   //color
	    			   rbtnAntenna.setBackground(Color.lightGray);
	    			   rbtnAntenna2.setBackground(Color.lightGray);
	    			   rbtnAntenna3.setBackground(Color.red);
	    			   //selected
	    			   rbtnAntenna.setSelected(false);
	    			   rbtnAntenna2.setSelected(false);
	    			   rbtnAntenna3.setSelected(true);
	                   // enabled
	                  rbtnAntenna.setEnabled(false);
	                  rbtnAntenna2.setEnabled(false);
		              rbtnAntenna3.setEnabled(true);
		               break;
	    			  
	    		   }
	    	   }
	    	   if(st[0].equals("1025")){
	    		   switch(st[1]){
	    		   case "0":
	    			   //color
	    			   rbtnTrans1.setBackground(Color.GREEN);
	    			   rbtnTrans2.setBackground(Color.lightGray);
	    			   rbtnTrans3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnTrans1.setSelected(true);
	    			   rbtnTrans2.setSelected(false);
	    			   rbtnTrans3.setSelected(false);
	                   // enabled
	    			   rbtnTrans1.setEnabled(true);
	    			   rbtnTrans2.setEnabled(false);
	    			   rbtnTrans3.setEnabled(false);
	    			   
	                  break;
	    		   case"1":
	    			   //color
	    			   rbtnTrans1.setBackground(Color.lightGray);
	    			   rbtnTrans2.setBackground(Color.orange);
	    			   rbtnTrans3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnTrans1.setSelected(false);
	    			   rbtnTrans2.setSelected(true);
	    			   rbtnTrans3.setSelected(false);
	                   // enabled
	    			   rbtnTrans1.setEnabled(false);
	    			   rbtnTrans2.setEnabled(true);
	    			   rbtnTrans3.setEnabled(false);
	    			 
		              break;
	    			   
	    		   case "2":
	    			   //color
	    			   rbtnTrans1.setBackground(Color.lightGray);
	    			   rbtnTrans2.setBackground(Color.lightGray);
	    			   rbtnTrans3.setBackground(Color.red);
	    			   //selected
	    			   rbtnTrans1.setSelected(false);
	    			   rbtnTrans2.setSelected(false);
	    			   rbtnTrans3.setSelected(true);
	                   // enabled
	    			   rbtnTrans1.setEnabled(false);
	    			   rbtnTrans2.setEnabled(false);
	    			   rbtnTrans3.setEnabled(true);
	    			 
		              break;
	    			  
	    		   }
	    	   }
	    	   if(st[0].equals("1026")){
	    		   switch(st[1]){
	    		   case "0":
	    			   //color
	    			   rbtnRx1.setBackground(Color.GREEN);
	    			   rbtnRx2.setBackground(Color.lightGray);
	    			   rbtnRx3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnRx1.setSelected(true);
	    			   rbtnRx2.setSelected(false);
	    			   rbtnRx3.setSelected(false);
	                   // enabled
	    			   rbtnRx1.setEnabled(true);
	    			   rbtnRx2.setEnabled(false);
	    			   rbtnRx3.setEnabled(false);
	    			   break;
	    		   case"1":
	    			   //color
	    			   rbtnRx1.setBackground(Color.lightGray);
	    			   rbtnRx2.setBackground(Color.orange);
	    			   rbtnRx3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnRx1.setSelected(false);
	    			   rbtnRx2.setSelected(true);
	    			   rbtnRx3.setSelected(false);
	                   // enabled
	    			   rbtnRx1.setEnabled(false);
	    			   rbtnRx2.setEnabled(true);
	    			   rbtnRx3.setEnabled(false);
	    			 
		              break;
	    			   
	    		   case "2":
	    			   //color
	    			   rbtnRx1.setBackground(Color.lightGray);
	    			   rbtnRx2.setBackground(Color.lightGray);
	    			   rbtnRx3.setBackground(Color.red);
	    			   //selected
	    			   rbtnRx1.setSelected(false);
	    			   rbtnRx2.setSelected(false);
	    			   rbtnRx3.setSelected(true);
	                   // enabled
	    			   rbtnRx1.setEnabled(false);
	    			   rbtnRx2.setEnabled(false);
	    			   rbtnRx3.setEnabled(true);
	    			   
		              break;
	    			  
	    		   }
	    	   }
	    	   if(st[0].equals("1027")){
	    		   switch(st[1]){
	    		   case "0":
	    			   //color
	    			   rbtnRdp1.setBackground(Color.GREEN);
	    			   rbtnRdp2.setBackground(Color.lightGray);
	    			   rbtnRdp3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnRdp1.setSelected(true);
	    			   rbtnRdp2.setSelected(false);
	    			   rbtnRdp3.setSelected(false);
	                   // enabled
	    			   rbtnRdp1.setEnabled(true);
	    			   rbtnRdp2.setEnabled(false);
	    			   rbtnRdp3.setEnabled(false);
	    			  
	                  break;
	    		   case"1":
	    			   //color
	    			   rbtnRdp1.setBackground(Color.lightGray);
	    			   rbtnRdp2.setBackground(Color.orange);
	    			   rbtnRdp3.setBackground(Color.lightGray);
	    			   //selected
	    			   rbtnRdp1.setSelected(false);
	    			   rbtnRdp2.setSelected(true);
	    			   rbtnRdp3.setSelected(false);
	                   // enabled
	    			   rbtnRdp1.setEnabled(false);
	    			   rbtnRdp2.setEnabled(true);
	    			   rbtnRdp3.setEnabled(false);
	    			     
		              break;
	    			   
	    		   case "2":
	    			   //color
	    			   rbtnRdp1.setBackground(Color.lightGray);
	    			   rbtnRdp2.setBackground(Color.lightGray);
	    			   rbtnRdp3.setBackground(Color.red);
	    			   //selected
	    			   rbtnRdp1.setSelected(false);
	    			   rbtnRdp2.setSelected(false);
	    			   rbtnRdp3.setSelected(true);
	                   // enabled
	    			   rbtnRdp1.setEnabled(false);
	    			   rbtnRdp2.setEnabled(false);
	    			   rbtnRdp3.setEnabled(true);
	    			   
		              break;
	    			  
	    		   }
	    	   }
	    		   if(st[0].equals("1028")){
	    			   switch(st[1]){
	    			   case "0": healthOk();
	    			   		     break;
	    			   case "1":
	    				   		healthdown();
	    				   		File down = new File("img/beep.wav");
	    			   			PlaySound(down);
	    			             break;
	    			   }
	    		   }
	    	   
	    		
	    		 
	    	}
	     public static void healthOk(){
	    	 // color
	    	 rdbtnOk.setBackground(Color.green);
	    	 rdbtnDown.setBackground(Color.gray);
	    	 //selected
	    	 rdbtnOk.setSelected(true);
	    	 rdbtnDown.setSelected(false);
	    	 //enabled
	    	 rdbtnOk.setEnabled(true);
	    	 rdbtnDown.setEnabled(false);
	    	 enableAll();
	    	 
	     }
	     public static void healthdown(){
	    	 // color
	    	 rdbtnOk.setBackground(Color.gray);
	    	 rdbtnDown.setBackground(Color.red);
	    	 //selected
	    	 rdbtnOk.setSelected(false);
	    	 rdbtnDown.setSelected(true);
	    	 //enabled
	    	 rdbtnOk.setEnabled(false);
	    	 rdbtnDown.setEnabled(true);
	    	 disableAll();
	     }
	     public static  void disableAll(){
	    	 //disable all
	    	 rbtnAntenna.setSelected(false);
	    	 rbtnAntenna.setEnabled(false);
	    	 rbtnAntenna.setBackground(Color.gray);
	    	 
	    	 rbtnAntenna2.setSelected(false);
	    	 rbtnAntenna2.setEnabled(false);
	    	 rbtnAntenna2.setBackground(Color.gray);
	    	 
	    	 rbtnAntenna3.setSelected(false);
	    	 rbtnAntenna3.setEnabled(false);
	    	 rbtnAntenna3.setBackground(Color.gray);
	    	 
	    	 // trans
	    	 rbtnTrans1.setSelected(false);
	    	 rbtnTrans1.setEnabled(false);
	    	 rbtnTrans1.setBackground(Color.gray);
	    	 
	    	 rbtnTrans2.setSelected(false);
	    	 rbtnTrans2.setEnabled(false);
	    	 rbtnTrans2.setBackground(Color.gray);
	    	 
	    	 rbtnTrans3.setSelected(false);
	    	 rbtnTrans3.setEnabled(false);
	    	 rbtnTrans3.setBackground(Color.gray);
	    	 
	    	 // rx
	    	 rbtnRx1.setSelected(false);
	    	 rbtnRx1.setEnabled(false);
	    	 rbtnRx1.setBackground(Color.gray);
	    	 
	    	 rbtnRx2.setSelected(false);
	    	 rbtnRx2.setEnabled(false);
	    	 rbtnRx2.setBackground(Color.gray);
	    	 
	    	 rbtnRx3.setSelected(false);
	    	 rbtnRx3.setEnabled(false);
	    	 rbtnRx3.setBackground(Color.gray);
	    	 
	    	 //rdp
	    	 rbtnRdp1.setSelected(false);
	    	 rbtnRdp1.setEnabled(false);
	    	 rbtnRdp1.setBackground(Color.gray);
	    	 
	    	 rbtnRdp2.setSelected(false);
	    	 rbtnRdp2.setEnabled(false);
	    	 rbtnRdp2.setBackground(Color.gray);
	    	 
	    	 rbtnRdp3.setSelected(false);
	    	 rbtnRdp3.setEnabled(false);
	    	 rbtnRdp3.setBackground(Color.gray);
	    	 
	    	 
	    	 
	     }
	     public static void enableAll(){
	    	 rbtnAntenna.setSelected(false);
	    	 rbtnAntenna.setEnabled(true);
	    	 rbtnAntenna.setBackground(Color.gray);
	    	 
	    	 rbtnAntenna2.setSelected(false);
	    	 rbtnAntenna2.setEnabled(true);
	    	 rbtnAntenna2.setBackground(Color.gray);
	    	 
	    	 rbtnAntenna3.setSelected(false);
	    	 rbtnAntenna3.setEnabled(true);
	    	 rbtnAntenna3.setBackground(Color.gray);
	    	 
	    	 // trans
	    	 rbtnTrans1.setSelected(false);
	    	 rbtnTrans1.setEnabled(true);
	    	 rbtnTrans1.setBackground(Color.gray);
	    	 
	    	 rbtnTrans2.setSelected(false);
	    	 rbtnTrans2.setEnabled(true);
	    	 rbtnTrans2.setBackground(Color.gray);
	    	 
	    	 rbtnTrans3.setSelected(false);
	    	 rbtnTrans3.setEnabled(true);
	    	 rbtnTrans3.setBackground(Color.gray);
	    	 
	    	 // rx
	    	 rbtnRx1.setSelected(false);
	    	 rbtnRx1.setEnabled(true);
	    	 rbtnRx1.setBackground(Color.gray);
	    	 
	    	 rbtnRx2.setSelected(false);
	    	 rbtnRx2.setEnabled(true);
	    	 rbtnRx2.setBackground(Color.gray);
	    	 
	    	 rbtnRx3.setSelected(false);
	    	 rbtnRx3.setEnabled(true);
	    	 rbtnRx3.setBackground(Color.gray);
	    	 
	    	 //rdp
	    	 rbtnRdp1.setSelected(false);
	    	 rbtnRdp1.setEnabled(true);
	    	 rbtnRdp1.setBackground(Color.gray);
	    	 
	    	 rbtnRdp2.setSelected(false);
	    	 rbtnRdp2.setEnabled(true);
	    	 rbtnRdp2.setBackground(Color.gray);
	    	 
	    	 rbtnRdp3.setSelected(false);
	    	 rbtnRdp3.setEnabled(true);
	    	 rbtnRdp3.setBackground(Color.gray);
	    	
	    	 
	     }
	     public static void PlaySound(File Sound){
	    	 try{
	    		 Clip clip = AudioSystem.getClip();
	    		 clip.open(AudioSystem.getAudioInputStream(Sound));
	    		 clip.start();
	    		 Thread.sleep(clip.getMicrosecondLength()/1000);
	    	 }
	    	 catch(Exception e){
	    		 System.out.println(e);
	    	 }
	     }
}

	

  
  


