import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

class mainclass {
    /**
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {

        // String file_name;

        System.out.println("\n\n**********************************************************************************");
        System.out.println("\t\t EXAMINATION SITTING ARRANGEMENT SYSTEM \t\t\t\t");
        System.out.println("**********************************************************************************");
        System.out.println("\n >>> Input the Class Occupany File : ");
        JFileChooser chooser_co = new JFileChooser();
        FileNameExtensionFilter filter_co = new FileNameExtensionFilter(
                "JPG & GIF Images", ".csv", ".txt");
        chooser_co.setFileFilter(filter_co);
        int returnVal_co = chooser_co.showOpenDialog(null);
        if (returnVal_co == JFileChooser.APPROVE_OPTION) {
            System.out.println("You choose to open this file: " +
                    chooser_co.getSelectedFile().getName());
            // file_name = chooser.getSelectedFile().getPath();

        }
        File f1_co = new File(chooser_co.getSelectedFile().getPath());
        FileReader f1r_co = new FileReader(f1_co);
        BufferedReader br_co = new BufferedReader(f1r_co);

        ArrayList<classOccupancy> data_co = new ArrayList<>();
        String str;
        int i = 0;
        int iteration = 0;
        try {
            while ((str = br_co.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] ssplit = str.split(",");
                classOccupancy obj = new classOccupancy(ssplit[0], Integer.parseInt(ssplit[1]));
                data_co.add(obj);
                i = i + 1;
            }
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> SeatNo = new ArrayList<>();
        for (classOccupancy ob : data_co) {
            for (int num = 1; num <= ob.capacity; num++) {
                allotment atm = new allotment();
                String seat = atm.SEAT(ob, num);
                SeatNo.add(seat);
            }

        }//Test :
        // System.out.println("Room Number " + "Capacity");
        // for (classOccupancy co : data_co){
        // co.display();
        // }
        /*---------------------------------------------------------------------------------------------------------------- */
        System.out.println("\n >>> Input the total number of Files ( Sections' Data file ) : ");
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int nf = Integer.parseInt(sc.readLine());
        sc.close();
        System.out.println("Start Choosing Files from your system .....");

        ArrayList<File> File_data = new ArrayList<>();

        while (nf != 0) {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "JPG & GIF Images", ".csv", ".txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                System.out.println("You choose to open this file: " +
                        chooser.getSelectedFile().getName());
                // file_name = chooser.getSelectedFile().getPath();

            }
            File f1 = new File(chooser.getSelectedFile().getPath());

            File_data.add(f1);
            nf = nf - 1;

        }

        ArrayList<section> even = new ArrayList<>();
        ArrayList<section> odd = new ArrayList<>();
        int itr = 0;
        for (File file : File_data) {
            FileReader f1r = new FileReader(file);
            BufferedReader br = new BufferedReader(f1r);
            String name = file.getName();
            //String [] ssplit= name.split(String.valueOf('.'));
            String ssplit = "";
            int strs = 0;
            while(name.charAt(strs) != '.'){
                ssplit+=String.valueOf(name.charAt(strs));
                strs++;
            }
            // ArrayList<section> data_sec = new ArrayList<>();
            if (itr % 2 == 0) {
                String strg;
                int j = 0;

                try {
                    while ((strg = br.readLine()) != null) {
                        //System.out.println(sssplit.length);
                       section ob1 = new section(strg, ssplit);
                        even.add(ob1);
                        j = j + 1;
                    }
                } catch (EOFException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                String strg;
                int j = 0;

                try {
                    while ((strg = br.readLine()) != null) {

                        //String[] sssplit = file.getName().split(".");
                       section ob1 = new section(strg, ssplit);
                        odd.add(ob1);
                        j = j + 1;
                    }
                } catch (EOFException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            itr++;
            // allSections.add(data_sec);
        }

        if(even.size() < odd.size()){
            for (int j = 0 ; j< (odd.size()-even.size());j++){
                section ob1 = new section();
                ob1.roll = " NA ";
                ob1.sectionName = "";
                even.add(ob1);
            }
        }
        else{
            for (int j = 0 ; j< (even.size()-odd.size());j++){
                section ob1 = new section();
                ob1.roll = " NA ";
                ob1.sectionName = "";
                odd.add(ob1);
            }
        }

        /*--------------------------------------------------------------------------------------------------------------- */
        System.out.println("SAVE YOUR FILE !!");
        File finalFile;
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            finalFile = fileChooser.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(finalFile));

            // save to file
            bw.append("Seat Number,Roll No 1st Student,Roll No 2nd Student\n");

            int smallest = 0;
            int a = SeatNo.size();
            int b = even.size();
            int c = odd.size();

            if (a<b){
                if (c<a){
                    smallest = c;
                }
                else{
                    smallest = a;
                }
            }
            else{
                smallest = b;
            }
            if (smallest == SeatNo.size()) {
                System.out.println("The Capacity of Classes as mentioned in Class Occupancy File is INSUFFICIENT !! ");
            } 
            for (int k = 0; k < smallest; k++) {
                String row = String.valueOf(SeatNo.get(k)) + "," + String.valueOf(even.get(k).sectionName) + 
                             String.valueOf(even.get(k).roll) + ","
                            + String.valueOf(odd.get(k).sectionName) + 
                            String.valueOf(odd.get(k).roll) + "\n";
                bw.append(row);
            }
            bw.close();
           
        }

    }
}
