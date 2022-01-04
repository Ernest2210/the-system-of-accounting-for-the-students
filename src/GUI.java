import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    static public ArrayList<GUITables> tables = new ArrayList<>();
    static public JPanel mainPanel;
    static public JFrame jFrame;
    static public JPanel addPanel;
    static public JButton saveButton;
    static public JButton addClearTableButton;
    static public JButton addTableButton;
    static public JButton openFileButton;
    static public JScrollPane scrollPane;
    static public JPanel scrollPanel;

    static public int width = 900;
    static public int height = 500;

    public static void start(){
        jFrame = getFrame();
        mainPanel = new JPanel();
        addPanel = new JPanel();
        scrollPanel = new JPanel();
        saveButton = new JButton("Сохранить");
        addClearTableButton = new JButton("Добавить таблицу");
        addTableButton = new JButton("Добавить таблицу из файла");
        openFileButton = new JButton("Открыть файл");
        scrollPane = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        addClearTableButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                printEmptyTable();
                SwingUtilities.updateComponentTreeUI(jFrame);
            }
        });

        BoxLayout boxLayout = new BoxLayout(scrollPanel, BoxLayout.Y_AXIS);

        scrollPanel.setLayout(boxLayout);
        addPanel.setLayout(new FlowLayout());
        mainPanel.setLayout(new BorderLayout());

        addPanel.add(saveButton);
        addPanel.add(addClearTableButton);
        addPanel.add(addTableButton);
        addPanel.add(openFileButton);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        jFrame.add(mainPanel, BorderLayout.CENTER);
        jFrame.add(addPanel, BorderLayout.PAGE_START);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    protected static void printEmptyTable(){
        ArrayList<String> _five = new ArrayList<>();
        ArrayList<String> _four = new ArrayList<>();
        ArrayList<String> _three = new ArrayList<>();
        ArrayList<String> _two = new ArrayList<>();
        ArrayList<String> _notcert = new ArrayList<>();
        _five.add("0");
        _five.add("0");
        _five.add("0");
        _five.add("0");
        _five.add("0");
        _four.add("0");
        _four.add("0");
        _four.add("0");
        _four.add("0");
        _four.add("0");
        _three.add("0");
        _three.add("0");
        _three.add("0");
        _three.add("0");
        _three.add("0");
        _two.add("0");
        _two.add("0");
        _two.add("0");
        _two.add("0");
        _two.add("0");
        _notcert.add("0");
        _notcert.add("0");
        _notcert.add("0");
        _notcert.add("0");
        _notcert.add("0");


        GUITables table = new GUITables(" ", " ", " ", "0", _five, _four, _three, _two, _notcert);
        table.printEmptyTable();
        tables.add(table);
    }

    public static void printTables(String FIO, String lesson, String grade,
                                   String numOfStud, ArrayList<String> fives,
                                   ArrayList<String> fours, ArrayList<String> threes,
                                   ArrayList<String> twos, ArrayList<String> notcert){
        GUITables table = new GUITables(FIO, lesson, grade, numOfStud, fives, fours, threes,twos,notcert);
        table.printEmptyTable();
        tables.add(table);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    private static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setResizable(true);
        jFrame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - width/2,dimension.height/2 - height/2,width,height);
        jFrame.setMinimumSize(new Dimension(width,height));
        jFrame.setLayout(new BorderLayout());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return jFrame;
    }
}
