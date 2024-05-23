
import javax.swing.SwingUtilities;

import db.MyJDBC;
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFormGUI().setVisible(true);
                System.out.println(MyJDBC.register("username1235", "passwords"));
        }
        });
    }
}
