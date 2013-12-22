import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class JarvisGUIV2 extends JFrame
{ 
  private JTextArea gui_Text;
  private Container gui_Container;
  private BorderLayout gui_Layout;
  private JTextField gui_Enter;
  private JPanel south_Panel;
  private JPanel mid_Panel;
  private JTextArea output_Text;
  
  //GRAPHICS MAGIC NUMBERS
  private static int width = 335;
  private static int height = 150;
  
  private static int thickness = 5;
  private static int left_bound = 5;
  private static int right_bound = 330;
  private static Color dark_blue = new Color(14,24,63);
  private static Color light_blue = new Color(15,138,244);
  private static int top_start = 2;
  private static int accent_line = 25;
  private static int bottom_start = 30;
  private static int num_columns = 30;
  private static int bottom_buffer = 2;
  
  //TITLE
  private static String title = " JARVIS  -  MAINFRAME";
  
  private String spacer = new String("                                                                                          ");
  
  public JarvisGUIV2 (String title)
  {
    super(title);
    init();
  }
  
  public void init()
  {
    setTheme();
    gui_Container = getContentPane();
    
    //TITLE SECTION
    gui_Text = new JTextArea(title)
    {
      public void paint(Graphics g)
      {
        super.paint(g);
        g.setColor(dark_blue);
        
        //TOP LINE
        for (int count = 0; count < thickness; count++)
        {
          g.drawLine(left_bound, top_start + count, right_bound, top_start + count);
        }
        
        //TITLE ACCENT
        g.drawLine(left_bound, accent_line, right_bound, accent_line);
        
        //BOTTOM LINE
        for (int count = 0; count < thickness; count++)
        {
          g.drawLine(left_bound, bottom_start + count, right_bound, bottom_start + count);
        }
        
        //SECOND BOTTOM LINE
        for (int count = 0; count < thickness; count++)
        {
          g.drawLine(left_bound, bottom_start + thickness + count, right_bound, bottom_start + thickness + count);
        }
      }
    };
    
    //TEXT SECTION
    gui_Text.setEditable(false);
    Font font = new Font("Arial Black", Font.BOLD, 24);
    gui_Text.setFont(font);
    
    //ENTER TEXT SECTION
    gui_Enter = new JTextField("");
    gui_Enter.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        JarvisVersion1.input_Phrase(gui_Enter.getText());
        JarvisVersion1.process_Phrase();
        JarvisVersion1.clear_List();
        gui_Enter.setText("");
        output_Text.setText(JarvisVersion1.output);
      }
    });
      
    gui_Enter.setColumns(num_columns);
    gui_Enter.setEditable(true);
    Font font2 = new Font("Arial Black", Font.BOLD, 10);
    gui_Enter.setFont(font2);
    
    south_Panel = new javax.swing.JPanel()
    {
      public void paint(Graphics g)
      {
        super.paint(g);
        g.setColor(dark_blue);
        for (int count = 0; count < thickness; count++)
        {
          g.drawLine(left_bound, count, right_bound, count);
        }
        
        for (int count = 0; count < thickness; count++)
        {
          g.drawLine(left_bound, bottom_start + bottom_buffer + count, right_bound, bottom_start + bottom_buffer + count);
        } 
      }
    };
    south_Panel.setBackground(Color.BLACK);
    south_Panel.add(gui_Enter);
    
    //OUTPUT PANEL
    output_Text = new JTextArea("");
    output_Text.setFont(font2);
    output_Text.setForeground(light_blue);
    output_Text.setBackground(Color.BLACK);
    output_Text.setText(JarvisVersion1.output);
    
    //MIDDLE PANEL
    mid_Panel = new JPanel();
    mid_Panel.setBackground(Color.BLACK);
    mid_Panel.add(output_Text, BorderLayout.WEST);
    
    //LAYOUT OF GUI
    gui_Layout = new BorderLayout();
    gui_Container.setLayout(gui_Layout);
    gui_Container.add(gui_Text, BorderLayout.NORTH);
    gui_Container.add(south_Panel, BorderLayout.SOUTH);
    gui_Container.add(mid_Panel,BorderLayout.CENTER);
    gui_Container.setBackground(Color.BLACK);
   
    setVisible(true);
    pack();
    setSize(width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    gui_Text.setBackground(Color.BLACK);
    gui_Text.setForeground(light_blue);
    gui_Container.setBackground(Color.BLACK);
  }
  
  public void setTheme()
  {
    try
    {
      String theme = UIManager.getSystemLookAndFeelClassName();
      UIManager.setLookAndFeel(theme);
    }
    catch (Exception e)
    {
    }
  }
  
  public static void main(String [] args)
  {
    JarvisGUIV2 jar = new JarvisGUIV2("");
  }
  
}