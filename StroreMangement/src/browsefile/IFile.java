package browsefile;

import java.util.ArrayList;

public interface IFile<T> {
    public ArrayList<T> loadFromFile(String path);
    public void saveToFile(ArrayList<T> list, String path);
}
