import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CipherFileManager {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd_MM_yyyy__HH_mm");
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final String DEFAULT_EXTENSION = ".txt";

    public static boolean saveEncryptedMessage(Component parent, String encryptedText, String keyword, String algorithmName) {
        if (encryptedText == null || encryptedText.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Нет текста для сохранения!",
                    "Предупреждение!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (keyword == null || keyword.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Нет ключа для сохранения!",
                    "Предупреждение!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }



        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Сохранить зашифрованный текст");

        String defaultFileName = String.format("%s_%s%s",
                algorithmName.toLowerCase().replace(" ", "_"),
                LocalDateTime.now().format(DATE_FORMAT),
                DEFAULT_EXTENSION);
        fileChooser.setSelectedFile(new File(defaultFileName));
        int userSelection = fileChooser.showSaveDialog(parent);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write("Дата: " + LocalDateTime.now().format(DATE_TIME_FORMAT));
                writer.newLine();
                writer.write("Алгоритм: " + algorithmName);
                writer.newLine();
                writer.write("КЛЮЧ: " + keyword);
                writer.newLine();
                writer.write("=== ------------------ ===");
                writer.newLine();
                writer.newLine();
                writer.write(encryptedText);
                writer.newLine();
                writer.newLine();
                writer.write("=== __________________ ===");

                JOptionPane.showMessageDialog(parent,
                        String.format("Файл успешно сохранён!\n%s\nРазмер: %d символов",
                                fileToSave.getAbsolutePath(),
                                encryptedText.length()),
                        "Сохранение",
                        JOptionPane.INFORMATION_MESSAGE);

                return true;

            } catch (IOException e) {
                JOptionPane.showMessageDialog(parent,
                        "Ошибка при сохранении файла:\n" + e.getMessage(),
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return false;
    }
}
