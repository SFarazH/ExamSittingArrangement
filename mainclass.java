/* Problem Statement : 
>>>> Inputs : Admin i/o , 
2 types of csv txt files : 
1)Roll Lists of sections appearing for exam. 
(User I/P ki kitne sections h >> while/for loop >> data read for each file )
2)Classes available(Total classes ) plus class occupancy.<class no,no of seats>

>>>> Outputs : In csv file that can be openend in excel.
1. Make a file (write/append mode).
2. Write csv data in file for classes in foll way : 

Room No: 108
Seat No.,Roll No. of Student 1 from sec A,Roll No. of Student from sec B
001,5A1,4A1
.
 .
 .
 .
 025,425,525
 .
 Class No. : 02
 001,5A26,4A26

 015,5A40,4A40
 016,5B01,4A41
 .
 .
 .
 .
 --------------------

 BufferFileInput = .....(new (".txt"))
 */
import java.util.*;
import java.lang.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
class mainclass{
    /**
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String args[]) throws FileNotFoundException , IOException{

        //String file_name;
        
        System.out.println("\n**********************EXAMINATION SITTING ARRANGEMENT SYSTEM**********************");

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", ".csv", ".txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
            //file_name = chooser.getSelectedFile().getPath();
        
        }
        File f1 = new File(chooser.getSelectedFile().getPath());
        FileReader f1r = new FileReader(f1);
        BufferedReader br = new BufferedReader(f1r);

        ArrayList class_data = new ArrayList();


        
    }
}


/*ROUGH CODE :
 * >>>>For Window Dialogue box :
 *  FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
    dialog.setMode(FileDialog.LOAD);
    dialog.setVisible(true);
    String file = dialog.getFile();
    System.out.println(file + " chosen.");
 * 
 */