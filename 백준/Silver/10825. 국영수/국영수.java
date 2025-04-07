import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        String name;
        int koreanScore;
        int englishScore;
        int mathScore;

        Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int koreanScore = Integer.parseInt(input[1]);
            int englishScore = Integer.parseInt(input[2]);
            int mathScore = Integer.parseInt(input[3]);

            Student student = new Student(name, koreanScore, englishScore, mathScore);
            list.add(student);
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.koreanScore == s2.koreanScore) {
                    if (s1.englishScore == s2.englishScore) {
                        if (s1.mathScore == s2.mathScore) {
                            return s1.name.compareTo(s2.name);
                        } else {
                            return Integer.compare(s2.mathScore, s1.mathScore);
                        }
                    } else {
                        return Integer.compare(s1.englishScore, s2.englishScore);
                    }
                } else {
                    return Integer.compare(s2.koreanScore, s1.koreanScore);
                }
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Student s : list) {
            bw.write(s.name + "\n");
        }
        bw.flush();
        bw.close();
    }
}