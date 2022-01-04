import javax.swing.*;
import java.awt.*;
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

    static public int width = 850;
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

        scrollPanel.setBackground(Color.MAGENTA);
        mainPanel.setBackground(Color.BLUE);

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
