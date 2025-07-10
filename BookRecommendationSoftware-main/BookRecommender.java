import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class BookRecommender {
    private static final int width = 1000;
    private static final int height = 500;

    private static ArrayList<Book> archivedBooks;
    private static ArrayList<Book> userBooks;
    private static ArrayList<Book> recs;

    private static JFrame jFrame;
    private static JPanel jPanel;
    private static JLabel jLabelName;
    private static JTextField jTextFieldName;
    private static JLabel jLabelGenre;
    private static JTextField jTextFieldGenre;
    private static JButton jButtonAdd;
    private static JButton jButtonRecommend;
    private static JButton jButtonWrite;
    private static JLabel jLabelWarning;
    private static JLabel jLabelYourBooks;
    private static JLabel jLabelRecommend;
    private static JPanel jPanel2;

    private static FileWriter fileWriter;
    private static DefaultListModel defaultListModelYourBooks;
    private static JList jListYourBooks;
    private static DefaultListModel defaultListModelRecommend;
    private static JList jListRecommend;

    public static void main(String[] args) {
        jFrame = new JFrame("Book Recommender");
        jFrame.setSize(width,height);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout());
        jFrame.setLocationRelativeTo(null);
        jPanel = new JPanel();
        jPanel.setSize(width, height);
        jPanel.setBackground(Color.lightGray);

        AddBooks.addBooks();
        archivedBooks = AddBooks.getArchs();
        userBooks = AddBooks.getUsers();
        recs = AddBooks.getRec();
        SetupFiles.setupFiles();
        fileWriter = SetupFiles.getFileWriter();

        defaultListModelYourBooks = new DefaultListModel();
        jListYourBooks = new JList(defaultListModelYourBooks);
        jListYourBooks.setVisibleRowCount(2);
        jListYourBooks.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        defaultListModelRecommend = new DefaultListModel();
        jListRecommend = new JList(defaultListModelRecommend);

        jLabelName = new JLabel("Name: ");
        jTextFieldName = new JTextField("", 10);
        jTextFieldName.setToolTipText("Enter the name of your book");
        jLabelGenre = new JLabel("Genre: ");
        jTextFieldGenre = new JTextField("", 10);
        jTextFieldGenre.setToolTipText("Enter the genre of your book");
        jButtonAdd = new JButton("Add");
        jButtonRecommend = new JButton("Recommend");
        jButtonWrite = new JButton("Write");
        jButtonWrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    fileWriter.write("User Books:");
                    fileWriter.write("\n");
                    for (int i = 0; i < userBooks.size(); i++) {
                        fileWriter.write(userBooks.get(i).title);
                        fileWriter.write("\n");
                    }
                    if (recs.size() != 0) {
                        fileWriter.write("Recommendations:");
                        fileWriter.write("\n");
                        for (int i = 0; i < recs.size(); i++) {
                            fileWriter.write(recs.get(i).title);
                            fileWriter.write("\n");
                        }
                    }
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        });
        jLabelWarning = new JLabel("Do not click \"write\" until done adding and recommending books!");
        jLabelYourBooks = new JLabel("Your Books: ");
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Book book = new Book();
                book.title = jTextFieldName.getText();
                book.genre = jTextFieldGenre.getText();
                userBooks.add(book);
                defaultListModelYourBooks.addElement(book.title);
            }
        });
        jLabelRecommend = new JLabel("We Recommend: ");
        jButtonRecommend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Book b1 : archivedBooks) {
                    for (Book b2 : userBooks ) {
                        if (b1.genre.equals(b2.genre)) {
                            recs.add(b1);
                        }
                    }
                }
                for (Book book : recs) {
                    defaultListModelRecommend.addElement(book.title);
                }
            }
        });
        jPanel2 = new JPanel();
        jPanel2.setBackground(Color.orange);
        jFrame.setMenuBar(new MenuBar());
        jPanel.add(jLabelName); //maybe extract
        jPanel.add(jTextFieldName);
        jPanel.add(jLabelGenre);
        jPanel.add(jTextFieldGenre);
        jPanel.add(jButtonAdd);
        jPanel.add(jButtonRecommend);
        jPanel.add(jButtonWrite);
        jPanel2.add(jLabelWarning);
        jPanel.add(jLabelYourBooks);
        jPanel.add(jListYourBooks);
        jPanel.add(jLabelRecommend);
        jPanel.add(jListRecommend);
        jFrame.add(jPanel);
        jFrame.add(jPanel2);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
