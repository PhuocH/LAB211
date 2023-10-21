package filehandle;

import data.Vehicle;
import java.io.*;
import java.util.*;

public class ReadFile {
    public static void loadFromFile(String path, ArrayList<Vehicle> vList) {
        File f = new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bfr.readLine()) != null) {                
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String color = st.nextToken().trim();
                String brand = st.nextToken().trim();
                String type = st.nextToken().trim();
                int productYear = Integer.parseInt(st.nextToken().trim());
                double price = Double.parseDouble(st.nextToken().trim());
                
                vList.add(new Vehicle(id, name, color, brand, type, productYear, price));                
            }
            System.out.println("Import data successful!");
        } catch (Exception e) {
            System.err.println("Load file error!");
        }
    }
}
