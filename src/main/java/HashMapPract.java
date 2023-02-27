import java.util.HashMap;

public class HashMapPract {
    public static void main(String[] args) {
//        HashMap<Integer,String> hmap = new HashMap<>();
//        hmap.put(0,"first");
//        hmap.putIfAbsent(1, "second");
//        hmap.putIfAbsent(1, "third");
//
//        System.out.println(hmap.get(1));
//        System.out.println(hmap.getOrDefault(3, "no value"));
//        for(Integer key:hmap.keySet()){
//            System.out.println(key);
//        }
//        hmap.compute(1,(k,v)->v+"!");
//        hmap.computeIfAbsent(3, v->"newValue"+"!");
//        hmap.merge(1,"$",(v1,v2)->v1+v2);
//        for(String val:hmap.values()){
//            System.out.println(val);
//        }
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);

        hm.forEach((k,v)-> System.out.printf("%s : %d\n",k,v));
        System.out.println("*".repeat(15));
        for (String key:hm.keySet()){
            hm.compute(key,(k,v)->v*2);
//            System.out.println(key+" : "+hm.get(key));
        }
        System.out.println(hm);
        HashMap<String,Integer> newMap = new HashMap<>();
        newMap.put("one", 1);
        newMap.put("eleven", 11);
        newMap.put("three", 3);
        newMap.put("four", 4);
        newMap.put("five", 5);
        newMap.put("twelve", 12);
        newMap.put("seven", 7);
        for (String key:newMap.keySet()){
            newMap.merge(key,hm.getOrDefault(key, -1), (v1,v2)->v1*v2);
//            System.out.println(key+" : "+hm.get(key));
        }
        System.out.println("*".repeat(15));

        System.out.println(newMap);
    }
}
