import java.util.HashMap;

public class S5 {
    public static void main(String[] args) {
        HashMap<String, String> team1 = new HashMap<>();
        team1.put("Pitcher", "one");
        team1.put("Catcher", "two");
        team1.put("FirstBase", "three");
        team1.put("SecondBase", "four");
        team1.put("ThirdBase", "five");
        team1.put("ShortBase", "six");

        team1.forEach((k,v)-> System.out.printf("%s : %s\n",k,v));
        System.out.println("*".repeat(15));

        HashMap<String, String> team2 = new HashMap<>();
        team2.put("Pitcher", "eleven");
        team2.put("Catcher", "eight");
        team2.put("LeftField", "seven");
        team2.put("FirstBase", "nine");
        team2.put("CenterField", "twelve");
        team2.put("ThirdBase", "zero");

        team2.forEach((k,v)-> System.out.printf("%s : %s\n",k,v));
        System.out.println("*".repeat(15));

        team1.forEach((k, v) -> team1.compute(k, (key, val) -> val + "!"));
        team1.forEach((k,v)-> System.out.printf("%s : %s\n",k,v));
        System.out.println("*".repeat(15));

        for(String key : team1.keySet()){
            team1.merge(key, team2.getOrDefault(key,""), (v1,v2)-> v1+v2);
            System.out.println(key+" : "+team1.get(key));
        }
    }


}
