import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class main {
    public static void main(String[] args)
    {
        new log();
    }
}
public class log implements ActionListener {
    JFrame frame;
   JLabel usernameLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField usernameTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton forgetButton=new JButton("FORGET");
  log()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
      {
        frame=new JFrame();
        frame.setTitle("LOGIN Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
  public void setLocationAndSize()
    {
        usernameLabel.setBounds(20,140,100,70);
        passwordLabel.setBounds(20,170,100,70);
        usernameTextField.setBounds(180,153,165,23);
        passwordField.setBounds(180,193,165,23);
       loginButton.setBounds(70,400,100,35);
        forgetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
         frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(usernameTextField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(forgetButton);
    }
    public void actionEvent()
    {
        loginButton.addActionListener(this);
        forgetButton.addActionListener(this);
    }
  @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==loginButton)
        {
           
                 
                String username=usernameTextField.getText();
               String password=passwordField.getText();
             
         try
         {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
              Statement st=con.createStatement();
              ResultSet rs=st.executeQuery("select *from student where username='"+username+"' and password='"+password+"'");
               if(rs.next())
             {
                
             }
              else
             {
                JOptionPane.showMessageDialog(null,"Wrong password");
             }
                 
        }
        catch(Exception ep)
        {
            JOptionPane.showMessageDialog(null,"Error in Connection");
        }
    }
      
    }
}
