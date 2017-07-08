package MainGUI.Classes;

import java.io.*;

public class ReportCreator {

    public ReportCreator(int ID) {
        //file path C:\\GeneranlMedical.txt
        try {
            MainGUI.Classes.GeneralMedicalHistory OriginalRecord;
            OriginalRecord = MainGUI.Classes.TestMain.getGeneralMedicalHistory(ID);

            OutputStream output = new BufferedOutputStream(new FileOutputStream("C:\\GeneranlMedical.txt"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            writer.write(OriginalRecord.getPatientID());
            writer.write(",");
            writer.write(OriginalRecord.getEducation());
            writer.write(",");
            writer.write(OriginalRecord.getMaritalStatus());
            writer.write(",");
            writer.write(OriginalRecord.getPregnancies());
            writer.write(",");
            writer.write(OriginalRecord.getAlcohol());
            writer.write(",");
            writer.write(OriginalRecord.getDrug());
            writer.write(",");
            writer.write(OriginalRecord.getTobacco());
            writer.write(",");
            writer.write(OriginalRecord.getTravel());
            writer.write(".");

        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
