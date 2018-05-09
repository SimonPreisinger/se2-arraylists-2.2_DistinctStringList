import java.util.ArrayList;
import java.util.Collection;

public class DistinctStringList extends ArrayList<String>  {

    public DistinctStringList(){

    }

    @Override
    public boolean add(String s) {
        return super.add(s);
    }

    @Override
    public String set(int i, String s) {
        return super.set(i, s);
    }

    @Override
    public void add(int i, String s) {
        super.add(i, s);
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        return super.addAll(collection);
    }
}
