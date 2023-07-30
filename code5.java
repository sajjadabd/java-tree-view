import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class code5
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JTreeFrame();
                frame.setTitle("JTree Demo");               
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}


class JTreeFrame extends JFrame
{
    public JTreeFrame()
    {
        setSize(300, 300);

        DefaultMutableTreeNode country = new DefaultMutableTreeNode("India");
        
        DefaultMutableTreeNode state = new DefaultMutableTreeNode("Maharashtra");
        country.add(state);
        
        DefaultMutableTreeNode city = new DefaultMutableTreeNode("Pune");
        state.add(city);
        city = new DefaultMutableTreeNode("Mumbai");
        state.add(city);
        
        state = new DefaultMutableTreeNode("Madhya Pradesh");
        country.add(state);
        city = new DefaultMutableTreeNode("Indore");
        state.add(city);
        city = new DefaultMutableTreeNode("Bhopal");
        state.add(city);
        
        state = new DefaultMutableTreeNode("Gujrat");
        country.add(state);
        
        city = new DefaultMutableTreeNode("Ahmedabad");
        state.add(city);

        JTree tree = new JTree(country);
        add(new JScrollPane(tree));
    }
}

