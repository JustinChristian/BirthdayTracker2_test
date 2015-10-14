//<editor-fold defaultstate="collapsed" desc="Package and Imports">
package birthdaytracker2.UI;
import birthdaytracker2.Logic.BinaryTree.BinaryTreeNode;
import birthdaytracker2.Main;
import birthdaytracker2.Models.Birthday;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//Package and Imports </editor-fold>

public class FrameMain extends JFrame
{
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public FrameMain()
    // Constructor does nothing but activate the initalize method.
    {
        Main.windows.add(frameMain);
        intialize_frameMain();
    }
    //Constructors </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Fields">
    // Swing component definitions. Indentations indicate the component is a child of the above.
    private final FrameMain frameMain = this; // Originally used to reference "this" where not in scope, now has replaced "this" throughout the class.
    private JPanel panelMain; // Base container for all other components.
        private JPanel panelTitle; // Container and background for all items on the title bar.
            private JLabel labelTitle; // Label to display the program title.
            private JButton buttonClose; // Buttons that exits the program.
        private JPanel panelContent; // Container for all components apart from the title bar.
            private JPanel panelInformation; // Container for components that provide feedback.
                private JLabel labelInformation; // Displays feedback and information to the user.
                private JButton buttonHelp; // Displays help on the information label.
                private JButton buttonHelpPrevious; // Displays the previous help message.
                private JButton buttonHelpNext; // Displays the next help message.
                private JButton buttonHelpStop; // Returns the information label to it's normal state.
            private JPanel panelTable; // Displaus the table of birthdays and it's controls.
                private JPanel panelTableControls;   // Contains buttons and textfields that relate to the birthdays table.
                    private JTextField textfieldSearch; // Field to enter a value to search for.
                    private JButton buttonViewEntry; // Displays the data of a selected entry.
                    private JButton buttonNewEntry; // Create a new entry.
                    private JButton buttonDeleteEntry; // Delete the currently selected entry.
                    private JButton buttonSaveAll; // Save all entries in the table to file.
                    private JButton buttonMonthSearch; // List birthdays in the target month.
                    private JButton buttonNameSearch; // List all entries with the target name.
                    private JButton buttonReset; // Reset JFrame to it's default state.
                private JScrollPane scrollTable; // Contains the birthdays table and allows it to scroll.
                    private JTable tableBirthdays; // Displays a table of birthday details.
            private JPanel panelEntry; // Displays the details of a single entry and allows editing of it's data.
                private JPanel panelEntryDisplay;
                    private JLabel labelName;
                    private JLabel labelDate;
                    private JLabel labelLikes;
                    private JLabel labelDislikes;
                    private JTextField textfieldName;
                    private JTextField textfieldDate;
                    private JTextField textfieldLikes;
                    private JTextField textfieldDislikes;
                private JPanel panelEntryControls;
                    private JButton buttonSaveEntry;
                    private JButton buttonClear;
                    private JButton buttonBack;
    private final Border borderNone = BorderFactory.createEmptyBorder(); // Removes any border.
    private final Border borderBlack = new LineBorder(Color.black, 1); // Thin black line border.
    private final Color myRed = new Color(200, 0, 0);
    private final Color myGreen = new Color(0, 160, 0);
    private final Color myBlue = new Color(0, 0, 240);
    private Color informationColor;
    private Timer informationTimer;
    
    private final String[] columns = new String[] {"Name", "Date"};
    private String informationText;
    List<String> helpList = null;
    int helpIndex;
    // Fields </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    //<editor-fold defaultstate="collapsed" desc="Component Initializations">
    private void intialize_frameMain()
    {
        frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMain.setSize(530, 320);
        frameMain.setLocation(centerComponent(frameMain));
        frameMain.setResizable(false);
        frameMain.setUndecorated(true);
        frameMain.setLayout(null);
        frameMain.setBackground(Color.white);
        
        initialize_panelMain(frameMain);
        
        frameMain.setVisible(true);
    }
    
    private void initialize_panelMain(Container parent)
    {
        panelMain = new JPanel();
        panelMain.setLayout(null);
        panelMain.setBackground(Color.white);
        panelMain.setLocation(0, 0);
        panelMain.setSize(frameMain.getWidth(), frameMain.getHeight());
        
        parent.add(panelMain);
        
        initialize_panelTitle(panelMain);
        initialize_panelContent(panelMain);
    }
    
    private void initialize_panelTitle(Container parent)
    {
        panelTitle = new JPanel();
        panelTitle.setLayout(null);
        panelTitle.setBackground(Color.black);
        panelTitle.setLocation(0, 0);
        panelTitle.setSize(frameMain.getWidth(), 25);
        
        parent.add(panelTitle);
        
        initialize_labelTitle(panelTitle);
        initialize_buttonClose(panelTitle);
    }
    
    private void initialize_panelContent(Container parent)
    {
        panelContent = new JPanel();
        panelContent.setLayout(null);
        panelContent.setBorder(borderBlack);
        panelContent.setBackground(Color.white);
        panelContent.setLocation(0, panelTitle.getHeight());
        panelContent.setSize(panelMain.getWidth(), panelMain.getHeight() - panelTitle.getHeight());
        
        parent.add(panelContent);
        
        initialize_panelInformation(panelContent);
        initialize_panelTable(panelContent);
        initialize_panelEntry(panelContent);
    }
    
    private void initialize_panelInformation(Container parent)
    {
        panelInformation = new JPanel();
        panelInformation.setLayout(null);
        panelInformation.setSize(panelContent.getWidth() - 20, 20);
        panelInformation.setLocation(10, 10);
        panelInformation.setBackground(Color.white);
        
        parent.add(panelInformation);
        
        initialize_labelInformation(panelInformation);
        initialize_buttonHelp(panelInformation);
        initialize_buttonHelpPrevious(panelInformation);
        initialize_buttonHelpNext(panelInformation);
        initialize_buttonHelpStop(panelInformation);
    }
    
    private void initialize_panelTable(Container parent)
    {
        panelTable = new JPanel();
        panelTable.setLayout(null);
        panelTable.setLocation(10, panelInformation.getHeight() + 20);
        panelTable.setSize(panelContent.getWidth() - 20, panelContent.getHeight() - panelInformation.getHeight() - 30);
        panelTable.setBackground(Color.white);
        
        parent.add(panelTable);
        
        initialize_panelTableControls(panelTable);
        initialize_scrollTable(panelTable);
    }
    
    private void initialize_panelTableControls(Container parent)
    {
        panelTableControls = new JPanel();
        panelTableControls.setLayout(null);
        panelTableControls.setBackground(Color.white);
        panelTableControls.setSize(100, parent.getHeight());
        panelTableControls.setLocation(parent.getWidth() - panelTableControls.getWidth(),  0);
        
        parent.add(panelTableControls);
        
        initialize_buttonViewEntry(panelTableControls);
        initialize_buttonNewEntry(panelTableControls);
        initialize_buttonDeleteEntry(panelTableControls);
        initialize_buttonSaveAll(panelTableControls);
        initialize_textfieldSearch(panelTableControls);
        initialize_buttonNameSearch(panelTableControls);
        initialize_buttonMonthSearch(panelTableControls);
        initialize_buttonReset(panelTableControls);
    }
    
    private void initialize_panelEntry(Container parent)
    {
        panelEntry = new JPanel();
        panelEntry.setLayout(null);
        panelEntry.setBackground(myGreen);
        panelEntry.setSize(parent.getWidth() - 20, parent.getHeight() - panelInformation.getHeight() - 30);
        panelEntry.setLocation(10, panelInformation.getHeight() + 20);
        panelEntry.setVisible(false);
        
        parent.add(panelEntry);
    }
    
    private void initialize_scrollTable(Container parent)
    {
        initialize_tableBirthdays(Main.data.getData());
        scrollTable = new JScrollPane(tableBirthdays);
        scrollTable.setLocation(0, 0);
        scrollTable.setSize(panelTable.getWidth() - panelTableControls.getWidth() - 10, panelContent.getHeight() - 50);
        scrollTable.setBackground(Color.white);
        
        parent.add(scrollTable);
    }
    
    private void initialize_tableBirthdays(String[][] input)
    {
        DefaultTableModel model = new DefaultTableModel(input, columns)
        {
            @Override
            public boolean isCellEditable (int row, int column)
            {
                return false;
            }
        };
        
        tableBirthdays = new JTable(model);
        tableBirthdays.setSelectionModel(new BirthdayTableSelectionModel());
        tableBirthdays.setDefaultRenderer(Object.class, new BorderLessTableCellRenderer() );
    }
    
    private void initialize_labelTitle(Container parent)
    {
        labelTitle = new JLabel();
        labelTitle.setText("BirthdayTracker");
        labelTitle.setOpaque(true);
        labelTitle.setBackground(Color.black);
        labelTitle.setForeground(Color.white);
        labelTitle.setSize(panelTitle.getWidth() - 15, panelTitle.getHeight());
        labelTitle.setLocation(10, 0);
        
        parent.add(labelTitle);
    }
    
    private void initialize_labelInformation(Container parent)
    {
        int count;
        
        if (Main.data.currentBirthdays == null)
        {
            count = 0;
        }
        else
        {
            count = Main.data.currentBirthdays.getSize();
        }
        
        informationText = "Showing " + Integer.toString(count) + " entries.";
        labelInformation = new JLabel();
        labelInformation.setOpaque(true);
        labelInformation.setBackground(myBlue);
        labelInformation.setForeground(Color.white);
        labelInformation.setHorizontalAlignment(SwingConstants.CENTER);
        labelInformation.setLocation(0, 0);
        labelInformation.setSize(parent.getWidth() - 110, 20);
        labelInformation.setText(informationText);
        
        parent.add(labelInformation);
    }
    
    private void initialize_textfieldSearch(Container parent)
    {
        textfieldSearch = new JTextField();
        textfieldSearch.setText("Search...");
        textfieldSearch.setSize(100, 20);
        textfieldSearch.setLocation(0, buttonSaveAll.getLocation().y + 50);
        
        parent.add(textfieldSearch);
    }
    
    private void initialize_buttonViewEntry(Container parent)
    {
        buttonViewEntry = new JButton();
        buttonViewEntry.setText("View Entry");
        setStyle_StandardButton(buttonViewEntry);
        buttonViewEntry.setLocation(0, 0);
        
        buttonViewEntry.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                viewEntry();
            }
        });
        
        parent.add(buttonViewEntry);
    }
    
    private void initialize_buttonNewEntry(Container parent)
    {
        buttonNewEntry = new JButton();
        buttonNewEntry.setText("New Entry");
        setStyle_StandardButton(buttonNewEntry);
        buttonNewEntry.setLocation(0, buttonViewEntry.getLocation().y + 25);
        
        buttonNewEntry.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                newEntry();
            }
        });
        
        parent.add(buttonNewEntry);
    }
    
    private void initialize_buttonDeleteEntry(Container parent)
    {
        buttonDeleteEntry = new JButton();
        buttonDeleteEntry.setText("Delete Entry");
        setStyle_StandardButton(buttonDeleteEntry);
        buttonDeleteEntry.setLocation(0, buttonNewEntry.getLocation().y + 25);
        
        buttonDeleteEntry.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                deleteEntry(this);
            }
        });
        
        parent.add(buttonDeleteEntry);
    }
    
    private void initialize_buttonSaveAll(Container parent)
    {
        buttonSaveAll = new JButton();
        buttonSaveAll.setText("Save All");
        setStyle_StandardButton(buttonSaveAll);
        buttonSaveAll.setLocation(0, buttonDeleteEntry.getLocation().y  +25);
        
        buttonSaveAll.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                saveAll();
            }
        });
        
        parent.add(buttonSaveAll);
    }
    
    private void initialize_buttonNameSearch(Container parent)
    {
        buttonNameSearch = new JButton();
        buttonNameSearch.setText("By Name");
        setStyle_StandardButton(buttonNameSearch);
        buttonNameSearch.setLocation(0, textfieldSearch.getLocation().y + 25);
        
        buttonNameSearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEVent)
            {
                nameSearch();
            }
        });
        
        parent.add(buttonNameSearch);
    }
    
    private void initialize_buttonMonthSearch(Container parent)
    {
        buttonMonthSearch = new JButton();
        buttonMonthSearch.setText("By Month");
        setStyle_StandardButton(buttonMonthSearch);
        buttonMonthSearch.setLocation(0, buttonNameSearch.getLocation().y + 25);
        
        buttonMonthSearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                monthSearch();
            }
        });
        
        parent.add(buttonMonthSearch);
    }
    
    private void initialize_buttonReset(Container parent)
    {
        buttonReset = new JButton();
        buttonReset.setText("Reset");
        setStyle_StandardButton(buttonReset);
        buttonReset.setLocation(0, panelTableControls.getHeight() - 20);
        
        buttonReset.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                reset();
                buttonReset.updateUI();
            }
        });
        
        parent.add(buttonReset);
    }
    
    private void initialize_buttonHelp(Container parent)
    {
        buttonHelp = new JButton();
        buttonHelp.setText("Help");
        setStyle_StandardButton(buttonHelp);
        buttonHelp.setLocation(parent.getWidth() - 100, 0);
        
        buttonHelp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                startHelp();
            }
        });
        
        parent.add(buttonHelp);
    }
    
    private void initialize_buttonHelpPrevious(Container parent)
    {
        buttonHelpPrevious = new JButton();
        buttonHelpPrevious.setText("<");
        setStyle_StandardButton(buttonHelpPrevious);
        buttonHelpPrevious.setSize(25, 20);
        buttonHelpPrevious.setLocation(buttonHelp.getLocation());
        buttonHelpPrevious.setVisible(false);
        
        buttonHelpPrevious.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                previousHelp();
            }
        });
        
        parent.add(buttonHelpPrevious);
    }
    
    private void initialize_buttonHelpNext(Container parent)
    {
        buttonHelpNext = new JButton();
        buttonHelpNext.setText(">");
        setStyle_StandardButton(buttonHelpNext);
        buttonHelpNext.setSize(25, 20);
        buttonHelpNext.setLocation(buttonHelp.getLocation().x + 75, 0);
        buttonHelpNext.setVisible(false);
        
        buttonHelpNext.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                nextHelp();
            }
        });
        
        parent.add(buttonHelpNext);
    }
    
    private void initialize_buttonHelpStop(Container parent)
    {
        buttonHelpStop = new JButton();
        buttonHelpStop.setText("Stop");
        setStyle_StandardButton(buttonHelpStop);
        buttonHelpStop.setSize(50, 20);
        buttonHelpStop.setLocation(buttonHelp.getLocation().x + 25, 0);
        buttonHelpStop.setVisible(false);
        
        buttonHelpStop.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                stopHelp();
            }
        });
        
        parent.add(buttonHelpStop);
    }
    
    private void initialize_buttonClose(Container parent)
    {
        buttonClose = new JButton("X");
        buttonClose.setBackground(Color.black);
        buttonClose.setForeground(myRed);
        buttonClose.setBorder(borderNone);
        buttonClose.setMargin(new Insets(0, 0, 0, 0));
        buttonClose.setFocusPainted(false);
        buttonClose.setSize(25, 25);
        buttonClose.setLocation(panelTitle.getWidth() - 25, 0);
        
        // Click event code.
        buttonClose.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Main.endProgram();
            }
        });
        
       parent.add(buttonClose);
    }
    
    private void setStyle_StandardButton(JComponent target)
    {
        target.setSize(100, 20);
        target.setBackground(Color.white);
        target.setForeground(Color.black);
        target.setBorder(borderBlack);
        target.setFocusable(false);
    }
    
    private Point centerComponent(Container target)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = ((screenSize.width - target.getWidth()) / 2);
        int yPos = ((screenSize.height - target.getHeight()) / 2);
        return new Point(xPos, yPos);
    }
    
    private void setInformation(String text)
    {
        labelInformation.setText(text);
    }
    
    private String getDefaultInformation()
    {
        return "Information";
    }
    
    private void startHelp()
    {
        if (helpList == null)
        {
            helpList = new ArrayList<>();
            helpList.add("Press the \"< >\" buttons to cycle help.");
            helpList.add("Press the \"stop\" button to return.");
            helpList.add("Press \"reset\" to reset the program");
        }
        
        labelInformation.setBackground(Color.magenta);
        helpIndex = 0;
        labelInformation.setText(helpList.get(helpIndex));
        
        buttonHelp.setVisible(false);
        buttonHelpPrevious.setVisible(true);
        buttonHelpNext.setVisible(true);
        buttonHelpStop.setVisible(true);
    }
    
    private void previousHelp()
    {
        if (helpIndex > 0)
        {
            helpIndex -= 1;
        }
        else
        {
            helpIndex = helpList.size() - 1;
        }
        
        displayHelp();
    }
    
    private void nextHelp()
    {
        if (helpIndex < helpList.size() - 1)
        {
            helpIndex += 1;
        }
        else
        {
            helpIndex = 0;
        }
        
        displayHelp();
    }
    
    private void stopHelp()
    {
        labelInformation.setBackground(Color.blue);
        setInformation(getDefaultInformation());
        
        buttonHelpStop.setVisible(false);
        buttonHelpPrevious.setVisible(false);
        buttonHelpNext.setVisible(false);
        buttonHelp.setVisible(true);
    }
    //Component Initializations </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Button Event Code">
    private void displayHelp()
    {
        labelInformation.setText(helpList.get(helpIndex));
    }
    
    private void viewEntry()
    {
        
    }
    
    private void newEntry()
    {
        
    }
    
    private void deleteEntry(ActionListener actionListener)
    {
        if (tableBirthdays.getRowCount() > 0)
        {
            if (tableBirthdays.getSelectedRowCount() == 1)
            {
                    int row = tableBirthdays.getSelectedRow();
                    String name = tableBirthdays.getValueAt(row, 0).toString();
                    Birthday birthday = (Birthday) Main.data.currentBirthdays.findNode(Main.data.currentBirthdays.getRoot(), name).getItem(0);
                    Main.data.allBirthdays.deleteNode(birthday);
                    Main.data.updateCurrentBirthdays();
                    ((DefaultTableModel) tableBirthdays.getModel()).setDataVector(Main.data.getData(), columns);
            }
            else
            {
                informationFail("Select one row.", 3000);
            }
        }
        else
        {
            informationFail("No data!", 3000);
        }
    }
    
    private void nameSearch()
    {
        
    }
    
    private void monthSearch()
    {
        
    }
    
    private void saveAll()
    {
        Main.data.saveBirthdays();
    }
    
    private void reset()
    {
        frameMain.remove(panelMain);
        initialize_panelMain(frameMain);
        informationSuccess("Reset!", 2000);
    }
    
    private void informationSuccess(String message, int time)
    {
        informationText = labelInformation.getText();
        labelInformation.setBackground(new Color(0, 160, 0));
        labelInformation.setText(message);
        
        ActionListener taskPerformer = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                labelInformation.setBackground(Color.blue);
                labelInformation.setText(informationText);
                informationTimer.stop();
            }
        };
        
        informationTimer = new Timer(0, taskPerformer);
        informationTimer.setInitialDelay(time);
        informationTimer.start();
    }
    
    private void informationFail(String message, int time)
    {
        informationText = labelInformation.getText();
        labelInformation.setBackground(new Color(200, 0, 0));
        labelInformation.setText(message);
        
        ActionListener taskPerformer = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                labelInformation.setBackground(Color.blue);
                labelInformation.setText(informationText);
                informationTimer.stop();
            }
        };
        
        informationTimer = new Timer(0, taskPerformer);
        informationTimer.setInitialDelay(time);
        informationTimer.start();
    }
    //Button Event Code" </editor-fold>
    //Methods </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Private Classes">
    private class BirthdayTableSelectionModel extends DefaultListSelectionModel
    {
        public BirthdayTableSelectionModel ()
        {
            setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

        @Override
        public void clearSelection()
        {
        
        }

        @Override
        public void removeSelectionInterval(int index0, int index1) 
        {
        
        }
    }
    
    private static class BorderLessTableCellRenderer extends DefaultTableCellRenderer 
    {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int col) 
        {
            final boolean showFocusedCellBorder = false; // change this to see the behavior change
            final Component c = super.getTableCellRendererComponent(table, value, isSelected, showFocusedCellBorder && hasFocus, row, col);
            return c;
        }
    }
    //Private Classes </editor-fold>
}