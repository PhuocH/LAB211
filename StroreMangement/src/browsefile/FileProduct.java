package browsefile;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import manageproduct.Product;
import util.Validation;

public class FileProduct implements IFile<Product> {

    @Override
    public ArrayList<Product> loadFromFile(String path) {
        ArrayList prList = new ArrayList();
        File f = new File(path);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String line;
            while ((line = bfr.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String type = st.nextToken().trim();
                String productDateStr = st.nextToken().trim();
                String expirationDateStr = st.nextToken().trim();
                int quantity = Integer.parseInt(st.nextToken().trim());
                double price = Double.parseDouble(st.nextToken().trim());

                Date dateOfManufacture = Validation.dF.parse(productDateStr);
                Date expirationDate = Validation.dF.parse(expirationDateStr);

                prList.add(new Product(id, name, type, dateOfManufacture, expirationDate, quantity, price));
            }
            System.out.println("Import data successful!");
        } catch (IOException | NumberFormatException | ParseException e) {
            System.err.println("Load file error!");

        }
        return prList;
    }

    @Override
    public void saveToFile(ArrayList<Product> list, String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}