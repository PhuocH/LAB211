package browsefile;

import java.io.*;
import java.util.*;
import static managewarehouse.ManagerWareHouse.whList;
import managewarehouse.WareHouse;
import util.ValidationProduct;

public class FileWareHouse implements IFile<WareHouse> {

    @Override
    public ArrayList<WareHouse> loadFromFile(String path) {
        ArrayList<WareHouse> whList = new ArrayList<>();
        File f = new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) { // Check if there are 4 parts
                    String code = parts[1].trim();
                    String dateStr = parts[2].trim();
                    Date date = ValidationProduct.dF.parse(dateStr);

                    String mapString = parts[3].trim();
                    Map<String, Integer> mapData = new HashMap<>();
                    mapString = mapString.substring(1, mapString.length() - 1); // Remove curly braces {}
                    String[] keyValuePairs = mapString.split(",");
                    for (String keyValue : keyValuePairs) {
                        String[] keyValueArr = keyValue.trim().split("=");
                        String key = keyValueArr[0].trim();
                        int value = Integer.parseInt(keyValueArr[1].trim());
                        mapData.put(key, value);
                    }

                    WareHouse wh = new WareHouse(code, date, mapData);
                    whList.add(wh);
                }
            }
            System.out.println(whList.size());
            System.out.println("Import data warehouse.dat successful!");
        } catch (Exception e) {
            System.out.println("warehouse.dat error!");
            e.printStackTrace();
        }
        return whList;
    }

    @Override
    public void saveToFile(ArrayList<WareHouse> list, String path) {
        if (path.isEmpty()) {
            System.out.println(path + " is emty.");
        }
        try {
            FileWriter fw = new FileWriter(new File(path));
            for (WareHouse wh : whList) {
                fw.write(wh + "\n");
            }
            fw.close();
            System.out.println("\u001B[1mSave to file warehouse.dat successfull.\u001B[0m");
        } catch (IOException e) {
            System.out.println("Error saving file warehouse.dat error!");
        }
    }

}
