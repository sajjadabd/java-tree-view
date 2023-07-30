import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.Vector;
//from  ww w. ja v a2 s  .c  o m
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

class TreeNodeVectorA<E> extends Vector<E> {
  private String name;

  TreeNodeVectorA(String name) {
    this.name = name;
  }

  TreeNodeVectorA(String name, E elements[]) {
    this.name = name;
    for (int i = 0, n = elements.length; i < n; i++) {
      add(elements[i]);
    }
  }

  @Override
  public String toString() {
    return "[" + name + "]";
  }
}

class Employee {
  public String firstName;
  public String lastName;
  public float salary;

  Employee(String f, String l, float s) {
    this.firstName = f;
    this.lastName = l;
    this.salary = s;
  }
}

class EmployeeCellRenderer implements TreeCellRenderer {
  JLabel firstNameLabel = new JLabel(" ");
  JLabel lastNameLabel = new JLabel(" ");
  JLabel salaryLabel = new JLabel(" ");
  JPanel renderer = new JPanel();
  DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
  Color backgroundSelectionColor;
  Color backgroundNonSelectionColor;

  EmployeeCellRenderer() {
    renderer.add(firstNameLabel);
    renderer.add(lastNameLabel);
    renderer.add(salaryLabel);
    backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
    backgroundNonSelectionColor = defaultRenderer
        .getBackgroundNonSelectionColor();
  }

  @Override
  public Component getTreeCellRendererComponent(JTree tree, Object value,
      boolean selected, boolean expanded, boolean leaf, int row,
      boolean hasFocus) {
    Component returnValue = null;
    if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
      Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
      if (userObject instanceof Employee) {
        Employee e = (Employee) userObject;
        firstNameLabel.setText(e.firstName);
        lastNameLabel.setText(e.lastName);
        salaryLabel.setText("" + e.salary);
        if (selected) {
          renderer.setBackground(backgroundSelectionColor);
        } else {
          renderer.setBackground(backgroundNonSelectionColor);
        }
        renderer.setEnabled(tree.isEnabled());
        returnValue = renderer;
      }
    }
    if (returnValue == null) {
      returnValue = defaultRenderer.getTreeCellRendererComponent(tree, value,
          selected, expanded, leaf, row, hasFocus);
    }
    return returnValue;
  }
}
public class code3 {
  public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Employee javaBooks[] = { new Employee("A", "F", 9.99f),
        new Employee("B", "E", 4.99f), new Employee("C", "D", 9.95f) };
    Employee netBooks[] = { new Employee("AA", "CC", 9.99f),
        new Employee("BB", "DD", 9.99f) };
    Vector<Employee> javaVector = new TreeNodeVectorA<Employee>("A", javaBooks);
    Vector<Employee> netVector = new TreeNodeVectorA<Employee>("As", netBooks);
    Object rootNodes[] = { javaVector, netVector };
    Vector<Object> rootVector = new TreeNodeVectorA<Object>("Root", rootNodes);
    JTree tree = new JTree(rootVector);
    TreeCellRenderer renderer = new EmployeeCellRenderer();
    tree.setCellRenderer(renderer);
    JScrollPane scrollPane = new JScrollPane(tree);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

}