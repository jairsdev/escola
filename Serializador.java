import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serializador {
    public static void gravar(ArrayList<Object> objeto, String caminho) 
            throws FileNotFoundException, IOException {
        File arq = new File(caminho);
        arq.delete();
        arq.createNewFile();

        FileOutputStream outFile = new FileOutputStream(caminho);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        s.writeObject(objeto);
        s.close();
    }

    public static ArrayList<Object> ler(String caminho)
            throws FileNotFoundException, IOException, ClassNotFoundException {
        File arq = new File(caminho);
        ArrayList<Object> lista = new ArrayList<>();
        if (arq.exists()) {
            FileInputStream inFile = new FileInputStream(caminho);
            ObjectInputStream s = new ObjectInputStream(inFile);
            lista = (ArrayList<Object>)s.readObject();
            s.close();
        }
        return lista;
    }
}