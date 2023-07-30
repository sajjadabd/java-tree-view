import javax.swing.JFrame;
import javax.swing.JTree;
/*from  ww w.  j a  v  a2 s . com*/
public class code2 {
  public static void main(String[] args) throws Exception {
    JFrame f = new JFrame("Test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JTree tree = new JTree();
    tree.putClientProperty("JTree.lineStyle", "Angled");
    // tree.putClientProperty("JTree.lineStyle", "Horizontal");
    // tree.putClientProperty("JTree.lineStyle", "None");
    for (int i = 0; i < tree.getRowCount(); i++) {
      tree.expandRow(i);
    }
    f.add(tree);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);

  }
}