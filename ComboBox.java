import javax.swing.*; //Importing needed Swing and event listener libraries.
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JFrame {//Begnning JCombo class that extends the JFrame class.

    public static void main (String args[]){ //Main class
  SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run(){
          new ComboBox();
      } //Running comboBox

  });

    }
    public ComboBox() { //Combobox constructor.
        JFrame jframe = new JFrame(); //New JFrame or pop up
        jframe.setLayout(new BorderLayout()); //Layout manager, dictates the rules for how layout of objects will work on the frame.
        jframe.setSize(600,400); //Dimensions of pop up
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Clicking the x closes the pop up
        this.setTitle("Country Selection"); //Title of pop up program.
        this.setLocationRelativeTo(null); //Location of pop up is not decided by the location of anything else.
        JLabel jlabel = new JLabel("Choose Selection Mode:"); //Text that's on the JFrame, asknig user to select which type of selection they would like to make.
        JLabel jlabel2 = new JLabel();
        String[] modeChoices = {"SINGLE", "MULTIPLE"}; //List of different modes of program.
        JList<String> countries; //List of countries that will be in the program, and be selected by the user.
        DefaultListModel<String> listModel = new DefaultListModel<>(); //Sets format of countries list
        listModel.addElement("China");//Adding countries to the list.
        listModel.addElement("Japan");
        listModel.addElement("Korea");
        listModel.addElement("India");
        listModel.addElement("Malaysia");
        listModel.addElement("Vietnam");
        countries = new JList<>(listModel);
        countries.setFixedCellHeight(45); //Declaring dimensions of the list itself.
        countries.setFixedCellWidth(400);
       JPanel bottomPanel = new JPanel(new BorderLayout()); //Making a bottom panel to use to properly position the countries list.
        bottomPanel.setVisible(true); //Setting this panel as Visible.
        bottomPanel.add(countries, BorderLayout.PAGE_END); //Adding countries to this panel.
        JPanel jpanel = new JPanel(new BorderLayout()); //Creating the main panel
        JPanel jpanel2 = new JPanel(); //Making extra JPanels
        JPanel jpanel4 = new JPanel();
        jpanel.add(bottomPanel, BorderLayout.LINE_START); //Adding bottom panel  to main.
        jpanel.add(jlabel, BorderLayout.NORTH); //Adding label telling the user to pick the mode of the panel to the top of the frame.
        jpanel.setVisible(true); //Making main panel visible.
        jframe.getContentPane().add(jpanel); //Making this panel the main panel.
        jframe.setVisible(true); //Making the main panel visible.
        final JComboBox<String> modeSetter = new JComboBox<String>(modeChoices); //Making drop down box , with mode choices for the program.
        modeSetter.setVisible(true); //Making dropdown visible
        jpanel2.add(modeSetter); //Adding dropdown to seperate panel to position it properly.
        jpanel4.add(jlabel2); //Adding second line of text for the frame to a seperate Jpanel.
        jpanel.add(jpanel2, BorderLayout.EAST); //Adding both of these panels to the main, using BorderLayouit to set the positions.
        jpanel.add(jpanel4, BorderLayout.SOUTH);
        jpanel2.setVisible(true);
        JPanel jpanel3 = new JPanel(); //Adding top label and dropdown to a seperate panel for positioning
        jpanel3.add(jlabel);
        jpanel3.add(jpanel2);
        jpanel.add(jpanel3, BorderLayout.NORTH); //Adding this panel to the main panel.
        countries.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //Since the program starts in Single mode, I amd setting the program on Single mode to begin with.
        try {
            modeSetter.addActionListener(new ActionListener(){ //Setting a click listener that changes mode according to the mode that is selected.
                public void actionPerformed(ActionEvent event){
                JComboBox jcombo1 = (JComboBox) event.getSource();
                    Object selected = modeSetter.getSelectedItem();

                    if (selected.toString().equals("SINGLE")) {

                        ;

                    }
                    else if (selected.toString().equals("MULTIPLE")){

                        countries.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

                    }


                    }
            });
        } catch (Exception e) { //Trappnig any errors the listener brings up and getting the information on them.
            e.printStackTrace();
        }

        try {
            countries.addListSelectionListener(new ListSelectionListener() {// Adding a click listener for the List
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    JList list = (JList) e.getSource(); //Getting the text of the list.
                    int selections[] = list.getSelectedIndices(); //Getting a read of which items were clicked.
                    String selectedValues = list.getSelectedValuesList().toString(); //Putting those items clicked on into a list, converted into a string.

                   jlabel2.setText("Selected items are:  " + selectedValues.toString()); //You now get those values clicked dispalyed in the second Jlabel or line of text in the program, along with a "Selected items" line to come before this list.
                }
            });
        } catch (Exception e) { //Get and report any errors that come up..
            e.printStackTrace();
        }


    }

}
