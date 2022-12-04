import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CreateSortList {
    private List list = new ArrayList();

    <T extends Number> CreateSortList (T ... nums) {
        Collections.addAll(list, nums);
        Collections.sort(list, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });
    }

    public List getList() {
        return list;
    }
}
