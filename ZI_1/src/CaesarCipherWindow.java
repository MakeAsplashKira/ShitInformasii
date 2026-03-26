import javax.swing.*;
import java.awt.*;

public class CaesarCipherWindow extends JFrame {
    private static final Color DARK_BACKGROUND = new Color(18, 18, 18);
    private static final Color PANEL_BACKGROUND = new Color(30, 30, 30);
    private static final Color TEXT_PRIMARY = new Color(255, 255, 255);
    private static final Color TEXT_SECONDARY = new Color(180, 180, 180);
    private static final Color INPUT_BACKGROUND = new Color(45, 45, 45);

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JSpinner keySpinner;
    private JComboBox<String> modeComboBox;

    public CaesarCipherWindow() {
        setTitle("Шифр Цезаря");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 650);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(DARK_BACKGROUND);
        mainPanel.setLayout(new BorderLayout());


        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);


        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);


        mainPanel.add(createControlPanel(), BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(PANEL_BACKGROUND);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Шифр Цезаря");
        titleLabel.setForeground(TEXT_PRIMARY);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        JLabel subtitleLabel = new JLabel("Введите текст и ключ для шифрования/расшифровки");
        subtitleLabel.setForeground(TEXT_SECONDARY);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));

       //nazad
        JButton backButton = new JButton("← Назад");
        backButton.setBackground(new Color(60, 60, 60));
        backButton.setForeground(TEXT_PRIMARY);
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.addActionListener(e -> {
            dispose();
            new EncryptionSelector();
        });

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(PANEL_BACKGROUND);
        topPanel.add(backButton, BorderLayout.WEST);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(PANEL_BACKGROUND);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(titleLabel);
        textPanel.add(subtitleLabel);

        topPanel.add(textPanel, BorderLayout.CENTER);
        panel.add(topPanel, BorderLayout.NORTH);

        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(DARK_BACKGROUND);
        panel.setLayout(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Панель ввода текста
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBackground(DARK_BACKGROUND);

        JLabel inputLabel = new JLabel("Входной текст:");
        inputLabel.setForeground(TEXT_PRIMARY);
        inputLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        inputTextArea = new JTextArea(8, 50);
        inputTextArea.setBackground(INPUT_BACKGROUND);
        inputTextArea.setForeground(TEXT_PRIMARY);
        inputTextArea.setCaretColor(TEXT_PRIMARY);
        inputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);
        inputTextArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane inputScroll = new JScrollPane(inputTextArea);
        inputScroll.setBackground(INPUT_BACKGROUND);
        inputScroll.setBorder(BorderFactory.createEmptyBorder());

        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputScroll, BorderLayout.CENTER);

        // Панель вывода текста
        JPanel outputPanel = new JPanel(new BorderLayout(5, 5));
        outputPanel.setBackground(DARK_BACKGROUND);

        JLabel outputLabel = new JLabel("Результат:");
        outputLabel.setForeground(TEXT_PRIMARY);
        outputLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        outputTextArea = new JTextArea(8, 50);
        outputTextArea.setBackground(INPUT_BACKGROUND);
        outputTextArea.setForeground(new Color(100, 255, 100)); // Зеленый для результата
        outputTextArea.setCaretColor(TEXT_PRIMARY);
        outputTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputTextArea.setLineWrap(true);
        outputTextArea.setWrapStyleWord(true);
        outputTextArea.setEditable(false);
        outputTextArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JScrollPane outputScroll = new JScrollPane(outputTextArea);
        outputScroll.setBackground(INPUT_BACKGROUND);
        outputScroll.setBorder(BorderFactory.createEmptyBorder());

        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(outputScroll, BorderLayout.CENTER);

        panel.add(inputPanel);
        panel.add(outputPanel);

        return panel;
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(PANEL_BACKGROUND);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        // шифрование/расшифровка
        JPanel modePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        modePanel.setBackground(PANEL_BACKGROUND);

        JLabel modeLabel = new JLabel("Режим:");
        modeLabel.setForeground(TEXT_PRIMARY);
        modeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        String[] modes = {"Шифрование", "Расшифровка"};
        modeComboBox = new JComboBox<>(modes);
        modeComboBox.setBackground(new Color(0,0,0));
        modeComboBox.setForeground(new Color(0,0,0));
        modeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        modePanel.add(modeLabel);
        modePanel.add(modeComboBox);

        // ключ(сдвиг)
        JPanel keyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        keyPanel.setBackground(PANEL_BACKGROUND);

        JLabel keyLabel = new JLabel("Ключ (сдвиг):");
        keyLabel.setForeground(TEXT_PRIMARY);
        keyLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(3, -100, 100, 1);
        keySpinner = new JSpinner(spinnerModel);
        keySpinner.setBackground(INPUT_BACKGROUND);
        keySpinner.setForeground(TEXT_PRIMARY);
        keySpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        keySpinner.setEditor(new JSpinner.NumberEditor(keySpinner, "#"));

        keyPanel.add(keyLabel);
        keyPanel.add(keySpinner);

        // копирование
        JButton copyButton = new JButton("Копировать");
        copyButton.setBackground(new Color(60, 60, 60));
        copyButton.setForeground(TEXT_PRIMARY);
        copyButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        copyButton.setFocusPainted(false);
        copyButton.setBorderPainted(false);

        // очистка
        JButton clearButton = new JButton("Очистить");
        clearButton.setBackground(new Color(60, 60, 60));
        clearButton.setForeground(TEXT_PRIMARY);
        clearButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        clearButton.setFocusPainted(false);
        clearButton.setBorderPainted(false);

        // выполениен
        JButton executeButton = new JButton("Выполнить");
        executeButton.setBackground(new Color(60, 60, 60));
        executeButton.setForeground(TEXT_PRIMARY);
        executeButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        executeButton.setFocusPainted(false);
        executeButton.setBorderPainted(false);

        // листенеры
        executeButton.addActionListener(e -> processText());

        copyButton.addActionListener(e -> {
            outputTextArea.selectAll();
            outputTextArea.copy();
            JOptionPane.showMessageDialog(this, "Результат скопирован в буфер обмена!");
        });

        clearButton.addActionListener(e -> {
            inputTextArea.setText("");
            outputTextArea.setText("");
        });


        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        leftPanel.setBackground(PANEL_BACKGROUND);
        leftPanel.add(modePanel);
        leftPanel.add(keyPanel);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        rightPanel.setBackground(PANEL_BACKGROUND);
        rightPanel.add(executeButton);
        rightPanel.add(copyButton);
        rightPanel.add(clearButton);

        panel.setLayout(new BorderLayout());
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);

        return panel;
    }

    private void processText() {
        String input = inputTextArea.getText();
        if (input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Введите текст для обработки!",
                    "Предупреждение",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int key = (Integer) keySpinner.getValue();
        boolean encrypt = modeComboBox.getSelectedItem().equals("Шифрование");

        // отрицательный ключ для дешифровки
        int shift = encrypt ? key : -key;

        String result = CaesarCipher.shift(input, shift);
        outputTextArea.setText(result);
        if(encrypt) {
            CipherFileManager.saveEncryptedMessage(this, result, Integer.toString(key), "Caesar");
        }
    }
}
