import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int age;
        String name;
        int index;
        
        Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Person> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            
            list.add(new Person(age, name, i));
        }
        
        list.sort((p1, p2) -> {
           if (p1.age != p2.age)
               return Integer.compare(p1.age, p2.age);
            
            return Integer.compare(p1.index, p2.index);
        });
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Person p : list) {
            bw.write(p.age + " " + p.name + "\n");
        }
        bw.flush();
        bw.close();
    }
}