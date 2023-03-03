import java.util.*;

public class S6 {
    public static void main(String[] args) {
        MySet set = new MySet();
        set.add(2);
        set.add(3);
        set.add(8);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);

        System.out.println(set);
        System.out.println(set.toArrayList());
        System.out.println(set.tailSet(4));
        System.out.println(set.headSet(4));
        System.out.println(set.subSet(2, 6));
        System.out.println(set.subSetFromArray(7, 3));
        System.out.println(set.subSetFromArray(4, 8));
    }
}

class MySet {
    HashMap<Integer, Object> values = new HashMap<>();
    private static final Object X = new Object();

    public void add(int value) {
        values.put(value, X);
    }


    Boolean contains(int value) {
        return values.containsKey(value);
    }

    public void remove(int value) {
        values.remove(value);
    }

    public String toString() {
        return values.keySet().toString();
    }

    int get(int idx) {
        return (int) values.keySet().toArray()[idx];
    }

    ArrayList<Integer> toArrayList() {
        ArrayList<Integer> array = new ArrayList<>();
        values.forEach((k, v) -> array.add(k));
        return array;
    }

    MySet tailSet(int value) {
        MySet result = new MySet();
        boolean write = false;
        for (int el : values.keySet()) {
            if (el == value) {
                write = true;
            }
            if (write) {
                result.add(el);
            }
        }
        return result;
    }

    MySet headSet(int value) {
        MySet result = new MySet();
        boolean write = true;
        for (int el : values.keySet()) {
            if (write) {
                result.add(el);
            }
            if (el == value) {
                write = false;
            }
        }
        return result;
    }

    MySet subSet(int start, int end) {
        MySet result = new MySet();
        boolean write = false;
        for (int el : values.keySet()) {
            if (el == start) {
                write = true;
            }
            if (write) {
                result.add(el);
            }
            if (el == end) {
                write = false;
            }
        }
        return result;
    }

    MySet subSetFromArray(int val1, int val2) {
        ArrayList<Integer> temp = toArrayList();
        MySet result = new MySet();
        if(!temp.contains(val1)||!temp.contains(val2)){
            return result;
        }
        int start = temp.indexOf(val1) < temp.indexOf(val2) ? val1 : val2;
        int end = start == val1 ? val2 : val1;
        List<Integer> tempSublist = temp.subList(temp.indexOf(start), temp.indexOf(end)+1);
        tempSublist.forEach(result::add);
        return result;
    }
}
