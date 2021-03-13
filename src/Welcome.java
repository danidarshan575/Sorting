import javax.swing.*;

public class Welcome extends JFrame{

    private JPanel JPanelMain;
    private JTextField textFieldWelcome;
    private JComboBox comboBoxAlgo;
    private JTextField TextFieldAlgo;
    private JTextField textFieldMethodofElementInsertion;
    private JComboBox comboBoxMethodofInsertion;
    private JButton okButton;

    public Welcome(){
        add(JPanelMain);
        setTitle("Welcome to the sorter");
        setSize(500,700);
    }

}
