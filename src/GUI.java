import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

        addTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ans = fileChooser.showOpenDialog(mainPanel);
                ArrayList<GUITables> newTables = new ArrayList<>();
                if (ans != 1){
                    File file = fileChooser.getSelectedFile();
                    try {
                        newTables = FileManager.readFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(newTables.size());
                    //TODO написать очистку оставшихся с прошлой работы таблиц
                    for(int i = 0; i < newTables.size(); i++){
                        printTables(newTables.get(i));
                    }
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(mainPanel);
                File file = fileChooser.getSelectedFile();
                String directory = file.getParent();
                String fileName = file.getName();
                try {
                    FileManager.saveFile(directory,fileName,tables);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int ans = fileChooser.showOpenDialog(mainPanel);
                ArrayList<GUITables> newTables = new ArrayList<>();
                if (tables.size() != 0){
                    scrollPanel.removeAll();
                    scrollPanel.revalidate();
                    scrollPanel.repaint();
                    tables = new ArrayList<>();
                }
                if (ans != 1){
                    File file = fileChooser.getSelectedFile();
                    try {
                        newTables = FileManager.readFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(newTables.size());
                    //TODO написать очистку оставшихся с прошлой работы таблиц
                    for(int i = 0; i < newTables.size(); i++){
                        printTables(newTables.get(i));
                    }
                }
            }
        });

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
        if(!(tables.isEmpty())){
            tables.get(tables.size()-1).tablePanel.setBorder(new EmptyBorder(0,0,5,0));
        }
        tables.add(table);
        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    public static void printTables(GUITables guiTables){
        guiTables.printEmptyTable();
        if(!(tables.isEmpty())){
            tables.get(tables.size()-1).tablePanel.setBorder(new EmptyBorder(0,0,5,0));
        }
        tables.add(guiTables);

        SwingUtilities.updateComponentTreeUI(jFrame);
    }

    public static void printTables(String FIO, String lesson, String grade,
                                   String numOfStud, ArrayList<String> fives,
                                   ArrayList<String> fours, ArrayList<String> threes,
                                   ArrayList<String> twos, ArrayList<String> notcert){
        GUITables table = new GUITables(FIO, lesson, grade, numOfStud, fives, fours, threes,twos,notcert);
        table.printEmptyTable();
        if(!(tables.isEmpty())){
            tables.get(tables.size()-1).tablePanel.setBorder(new EmptyBorder(0,0,5,0));
        }
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
