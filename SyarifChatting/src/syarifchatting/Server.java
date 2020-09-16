/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package syarifchatting;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.Normalizer.Form;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 5442
 */
public class ThreadServer {
  public static void main(String[] args) throws IOException {
        final int PORT = 8080;
        ServerSocket serverSocket = new ServerSocket(PORT);
        
        System.out.println("Server started...");
        System.out.println("Wating for clients...");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread() {
                public void run() {
                    try (
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        Scanner in = new Scanner(clientSocket.getInputStream());
                    ) {
                        while (in.hasNextLine()) {
                            String input = in.nextLine();
                            if (input.equalsIgnoreCase("exit")) {
                                break;
                            }
                            System.out.println("Received radius from client: " + input);
                            
//                            double radius = Double.valueOf(input);
//                            double area = Math.PI* radius *radius ;
//                            out.println(area);
                        }
                    } catch (IOException e) { }
                }
            };
            t.start();
        }
    }   
}
/**
 * @author MhdSyarif
 * Monday, 13 January 2014, 20 : 52 : 20 WIB 
 * Tugas III Matakulia Java2SE
 * Mhd. Syarif | 49013075
 * TKJMD - STEI - ITB
 */
public class Server extends javax.swing.JFrame implements Runnable{
    int port=8080;
    Socket client;
    ServerSocket server;
    BufferedReader Server_Reader, Client_Reader;
    BufferedWriter Server_Writer, Client_Writer;

    /**
     * Creates new form Server
     */
    
    public Server() {
        super("www.mhdsyarif.com"); //SetTitle
        initComponents();
        //Menampilkan hasil ditengah window
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }
    
    //Pilihan ComboBox
    private void getComboBox(){
        if(ComboBox.getSelectedItem().equals("Server")){
            ButtonOn.setText("On");
            Username.setText("Server");
        }else{
            ButtonOn.setText("Connect");
            Username.setText("Client");
        }
    }
    
    //Koneksi client ke server
    private void getClientConnec(){
        try {
            String ip = JOptionPane.showInputDialog(" Input IP Address");
            client = new Socket(ip, port);
            ComboBox.setEnabled(false);
            ButtonOn.setText("Disconnect");
            Server_Reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Server_Writer = new BufferedWriter (new OutputStreamWriter(client.getOutputStream()));
        } catch (UnknownHostException ex) {
           System.out.println("Accept Failed");
           System.exit(-1);
        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    private void getReadConnec(){
        try {
            try {
                try {
                    server = new ServerSocket(port);
                    this.setTitle("Please Wait");
                } catch (IOException ex) {
                    System.out.println("Could not listen");
                    System.exit(-1);
                }
                client = server.accept();
                this.setTitle("Connected" + client.getInetAddress());
            } catch (IOException ex) {
               System.out.println("Accept Failed");
               System.exit(-1);
            }
            Server_Reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Server_Writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException ex) {
           System.out.println("Read Failed");
           System.exit(-1);
        }
    }
    
    private void getDisconnectedClient(){
        try {
            client.close();
            Server_Reader.close();
            Server_Writer.close();
            ComboBox.setEnabled(true);
            ButtonOn.setText("Connect");
        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getDisconnectedServer(){
        try {
            Server_Reader.close();
            Server_Writer.close();
            ButtonOn.setText("On");
            this.setTitle("Disconected");
        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getButtonOn(){                                          
        if(ButtonOn.getText().equals("Connect"))
        {
            ButtonOn.setText("DIsconnect");
            getClientConnec();
            Thread thread1= new Thread(this);
            Thread thread2= new Thread(this);
            Thread thread3= new Thread(this);
            Thread thread4= new Thread(this);
            Thread thread5= new Thread(this);
            Thread thread6= new Thread(this);
            Thread thread7= new Thread(this);
            Thread thread8= new Thread(this);
            Thread thread9= new Thread(this);
            Thread thread10= new Thread(this);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
            thread9.start();
            thread10.start();
        } else if(ComboBox.getSelectedItem().equals("Server")){
            ButtonOn.setText("Off");
            getReadConnec();
            Thread thread1= new Thread(this);
            Thread thread2= new Thread(this);
            Thread thread3= new Thread(this);
            Thread thread4= new Thread(this);
            Thread thread5= new Thread(this);
            Thread thread6= new Thread(this);
            Thread thread7= new Thread(this);
            Thread thread8= new Thread(this);
            Thread thread9= new Thread(this);
            Thread thread10= new Thread(this);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
            thread9.start();
            thread10.start();
        }else if(ButtonOn.getText().equals("Disconnect")){
            getDisconnectedClient();
        }else if(ButtonOn.getText().equals("Off")){
            getDisconnectedServer();
        }
    }  
    
    private void getSend(){
        try {
            Server_Writer.write(Username.getText()+ ": " +TextChat.getText());
            Server_Writer.newLine();
            Server_Writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
            ListChat.add(Username.getText()+ ": " +TextChat.getText());
            //jClient.setText(Username.getText());
            TextChat.setText("");  
    }
    
    //Background color
    public void getBackgroundColor(){
        Color c = JColorChooser.showDialog(null,"Background Color",jPanel.getBackground());
        jPanel.setBackground(c);
    }
    
    //Konfirmasi keluar
    public void getExit(){
        int confirm =JOptionPane.showConfirmDialog(this,"Are you sure will exit this application ?","Exit Application",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION){
            System.exit(0);
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialog = new javax.swing.JDialog();
        ColorChooser = new javax.swing.JColorChooser();
        jPanel = new javax.swing.JPanel();
        ComboBox = new javax.swing.JComboBox();
        ButtonOn = new javax.swing.JButton();
        Send = new javax.swing.JToggleButton();
        JUsername = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        TextChat = new java.awt.TextArea();
        ListChat = new java.awt.List();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        BackgroundColor = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        About = new javax.swing.JMenuItem();

        javax.swing.GroupLayout DialogLayout = new javax.swing.GroupLayout(Dialog.getContentPane());
        Dialog.getContentPane().setLayout(DialogLayout);
        DialogLayout.setHorizontalGroup(
            DialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DialogLayout.setVerticalGroup(
            DialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel.setBackground(new java.awt.Color(204, 204, 204));

        ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Server", "Client" }));
        ComboBox.setToolTipText("");
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        ButtonOn.setText("On");
        ButtonOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOnActionPerformed(evt);
            }
        });

        Send.setText("SEND");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        JUsername.setText("Username");

        Username.setText("Server");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(JUsername)
                                .addGap(18, 18, 18)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonOn, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                    .addComponent(ListChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(TextChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonOn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JUsername)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListChat, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextChat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        File.setText("File");

        BackgroundColor.setText("Background Color");
        BackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackgroundColorActionPerformed(evt);
            }
        });
        File.add(BackgroundColor);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Help.setText("Help");

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        About a = new About();
        a.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_AboutActionPerformed

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        getSend();// TODO add your handling code here:
    }//GEN-LAST:event_SendActionPerformed

    private void ButtonOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOnActionPerformed
        getButtonOn();
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonOnActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        getComboBox();
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        getExit();// TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed

    private void BackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackgroundColorActionPerformed
        getBackgroundColor();// TODO add your handling code here:
    }//GEN-LAST:event_BackgroundColorActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem BackgroundColor;
    private javax.swing.JButton ButtonOn;
    private javax.swing.JColorChooser ColorChooser;
    private javax.swing.JComboBox ComboBox;
    private javax.swing.JDialog Dialog;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JLabel JUsername;
    private java.awt.List ListChat;
    private javax.swing.JToggleButton Send;
    private java.awt.TextArea TextChat;
    private javax.swing.JTextField Username;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
 @Override
    public void run()
    {
        try {
            ListChat.add(Server_Reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
