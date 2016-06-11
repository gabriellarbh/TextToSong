
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriellabarbieri
 */
public class FileHandler {
    private String txtMusic;
    private JFileChooser fileChooser;
    private File txtFile;
    private static String pickTxt;
    private static String pickDir;
    
    public FileHandler(){
        fileChooser = new JFileChooser();
        txtMusic = "";
        pickTxt = "Load - Choose a .txt File";
        pickDir = "Save - Choose a directory";
    }
    
    public String OpenFile () {
        fileChooser.setDialogTitle(pickTxt);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            txtFile = fileChooser.getSelectedFile();
            try{
                txtMusic = fileToString(txtFile);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "File could not be read");
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Invalid file!");
        return txtMusic;
    }
    
    public void SaveFile(JTextArea saveTxt){
        String savePath;
        fileChooser.setDialogTitle(pickDir);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = fileChooser.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            savePath = fileChooser.getCurrentDirectory().getAbsolutePath();
            
        }
        
    }
    
    private String fileToString(File file) throws IOException{
        String content = readFile(file, StandardCharsets.UTF_8);
        return content;
    }
    
    static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
}
    
    
}
