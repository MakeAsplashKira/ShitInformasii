import javax.swing.*;
import java.awt.*;

public class EncryptionSelector extends JFrame {

    public EncryptionSelector() {

        setTitle("Выбор алгоритма шифрования");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(30, 30, 30));


        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel titleLabel = new JLabel("Выберите алгоритм шифрования:");
        titleLabel.setForeground(new Color(200, 200, 200));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JRadioButton cesButton = new JRadioButton("Алгоритм цезаря");
        JRadioButton desButton = new JRadioButton("В разработке");
        JRadioButton rsaButton = new JRadioButton("В разработке");
        JRadioButton blowfishButton = new JRadioButton("В разработке");


        JRadioButton[] buttons = {cesButton, desButton, rsaButton, blowfishButton};
        for (JRadioButton button : buttons) {
            button.setBackground(new Color(30, 30, 30));
            button.setForeground(new Color(180, 180, 180));
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.setFocusPainted(false);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }


        ButtonGroup algorithmGroup = new ButtonGroup();
        algorithmGroup.add(cesButton);
        algorithmGroup.add(desButton);
        algorithmGroup.add(rsaButton);
        algorithmGroup.add(blowfishButton);


        cesButton.setSelected(true);


        JButton confirmButton = new JButton("Продолжить");
        confirmButton.setBackground(new Color(0, 0, 0));
        confirmButton.setForeground(new Color(43, 42, 42));
        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmButton.setFocusPainted(false);
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.setMaximumSize(new Dimension(200, 40));

        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(cesButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(desButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(rsaButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(blowfishButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        mainPanel.add(confirmButton);

        confirmButton.addActionListener(e -> {
            dispose();

            if (cesButton.isSelected()) {
                new CaesarCipherWindow();
            }
            //
        });

        add(mainPanel);
        setVisible(true);
    }
}