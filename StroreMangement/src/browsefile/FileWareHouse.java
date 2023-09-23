package browsefile;

import java.io.*;
import java.util.*;
import managewarehouse.WareHouse;
import util.Validation;

public class FileWareHouse implements IFile<WareHouse>{

    @Override
    public ArrayList<WareHouse> loadFromFile(String path) {
        ArrayList<WareHouse> whList = new ArrayList<>();
        File f = new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bfr.readLine()) != null) {                
                StringTokenizer st = new StringTokenizer(line, "|");
                String code = st.nextToken().trim();
                String dateStr = st.nextToken().trim();
                Date date = Validation.dF.parse(dateStr);
                String mapString = st.nextToken().trim();
                
                Map<String, Integer> mapData = new HashMap();
                String[] keyValue = mapString.substring(1, mapString.length() - 1).split(", ");
                for (String x : keyValue) {
                    String[] keyX = x.trim().split(":");
                    String key = keyX[0].trim();
                    int value = Integer.parseInt(keyX[1].trim());
                    mapData.put(key, value);
                }
                WareHouse wh = new WareHouse(code, date, mapData);
                whList.add(wh);                
            }
            System.out.println("Import data warehouse.dat successful!");
        } catch (Exception e) {
            System.out.println("warehouse.dat error!");
        }
        return whList;
    }

    @Override
    public void saveToFile(ArrayList<WareHouse> list, String fileName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
