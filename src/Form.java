import javax.swing.JFrame;

import constants.CommonConstants;

public class Form extends JFrame {
    public Form(String title){
        super(title);

        setSize(500, 800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(null);

        setLocationRelativeTo(null);

        setResizable(false);

        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);
    }
}
