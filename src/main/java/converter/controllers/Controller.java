package converter.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private TextField dirPathTextField;

    private Stage primaryStage;

    private DirectoryChooser directoryChooser;

    private File dir;

    public void additionalInit(Stage primaryStage) {
        this.primaryStage = primaryStage;

        directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Some Directories");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    public void startAction() {
        if (dir != null) {
            File[] filesList = dir.listFiles(); // записываем файлы из папки в массив объектов типа File

            progressBar.setProgress(0);

            for (int i = 0; i < filesList.length; i++) {
                File aFilesList = filesList[i];
                String buf = aFilesList.getName(); // читаем текущее имя файла
                StringBuilder sb = new StringBuilder(buf.length() * 2);
                for (char ch : buf.toCharArray()) {
                    sb.append(cyr2lat(ch));
                }

                buf = sb.toString();
                String filePath = dir.getAbsolutePath() + "\\" + buf;

                aFilesList.renameTo(new File(filePath));

                progressBar.setProgress(i / (100 * filesList.length));
            }

            progressBar.setProgress(1);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Renaming is complete");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Set directory");
            alert.showAndWait();
        }
    }


    public void chooseDirectoryAction() {
        try {
            dir = directoryChooser.showDialog(primaryStage);
            if (dir != null) {
                dirPathTextField.setText(dir.getAbsolutePath());
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Error" + ex);
            alert.showAndWait();
        }
    }

    private String cyr2lat(char ch) {
        switch (ch) {
            case 'А':
                return "A";
            case 'Б':
                return "B";
            case 'В':
                return "V";
            case 'Г':
                return "G";
            case 'Д':
                return "D";
            case 'Е':
                return "E";
            case 'Ё':
                return "Je";
            case 'Ж':
                return "Zh";
            case 'З':
                return "Z";
            case 'И':
                return "I";
            case 'Й':
                return "Y";
            case 'К':
                return "K";
            case 'Л':
                return "L";
            case 'М':
                return "M";
            case 'Н':
                return "N";
            case 'О':
                return "O";
            case 'П':
                return "P";
            case 'Р':
                return "R";
            case 'С':
                return "S";
            case 'Т':
                return "T";
            case 'У':
                return "U";
            case 'Ф':
                return "F";
            case 'Х':
                return "Kh";
            case 'Ц':
                return "C";
            case 'Ч':
                return "Ch";
            case 'Ш':
                return "Sh";
            case 'Щ':
                return "Jsh";
            case 'Ъ':
                return "Hh";
            case 'Ы':
                return "Ih";
            case 'Ь':
                return "Jh";
            case 'Э':
                return "Eh";
            case 'Ю':
                return "Ju";
            case 'Я':
                return "Ja";
            case 'а':
                return "a";
            case 'б':
                return "b";
            case 'в':
                return "v";
            case 'г':
                return "g";
            case 'д':
                return "d";
            case 'е':
                return "e";
            case 'ё':
                return "je";
            case 'ж':
                return "zh";
            case 'з':
                return "z";
            case 'и':
                return "i";
            case 'й':
                return "y";
            case 'к':
                return "k";
            case 'л':
                return "l";
            case 'м':
                return "m";
            case 'н':
                return "n";
            case 'о':
                return "o";
            case 'п':
                return "p";
            case 'р':
                return "r";
            case 'с':
                return "s";
            case 'т':
                return "t";
            case 'у':
                return "u";
            case 'ф':
                return "f";
            case 'х':
                return "kh";
            case 'ц':
                return "c";
            case 'ч':
                return "ch";
            case 'ш':
                return "sh";
            case 'щ':
                return "jsh";
            case 'ъ':
                return "hh";
            case 'ы':
                return "ih";
            case 'ь':
                return "jh";
            case 'э':
                return "eh";
            case 'ю':
                return "ju";
            case 'я':
                return "ja";
            default:
                return String.valueOf(ch);
        }
    }

}
