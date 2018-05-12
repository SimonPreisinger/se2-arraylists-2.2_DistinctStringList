import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class DistinctStringList extends ArrayList<String>  {

    private static DistinctStringList distinctStringList;

    @Override
    public boolean add(String s) {
        if(this.contains(s)){
            throw new IllegalArgumentException();
        }
        return super.add(s);
    }

    @Override
    public String set(int i, String s) {
        if(this.size() > i){
            if(this.contains(s))
                throw new IllegalArgumentException();
            return super.set(i, s);

        }
        this.add(s);
        return super.set(i, s);
    }

    @Override
    public void add(int i, String s) {
        if(this.contains(s))
        {}
        super.add(i, s);
    }

    @Override
    public boolean addAll(Collection<? extends String> list) {
        boolean hasChanged = false;
        for(String element:list){
        if(this.contains(element)){
            throw new IllegalArgumentException();
        }
        else{
            hasChanged = true;
            this.add(element);
        }
    }
        return hasChanged;
    }
}
