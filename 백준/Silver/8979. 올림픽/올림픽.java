import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 데이터 클래스로 메달 정보 저장
    static class Prize {
        int country;
        int gold;
        int silver;
        int bronze;

        public Prize(int country, int gold, int silver, int bronze) {
            this.country = country;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 모든 국가의 메달 정보를 저장하는 배열
        Prize[] countries = new Prize[N];

        // K 국가 메달 정보
        int kGold = 0;
        int kSilver = 0;
        int kBronze = 0;

        // N개의 국가 정보 입력받음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            // 국가 메달 정보 저장
            countries[i] = new Prize(country, gold, silver, bronze);

            // 현재 입력받은 국가가 K라면 따로 또 저장
            if (country == K) {
                kGold = gold;
                kSilver = silver;
                kBronze = bronze;
            }
        }

        // K 보다 더 잘한 국가 수
        int rank = 1;

        // 모든 국가 순회해서 더 잘한 나라 찾기
        for (int i = 0; i < N; i++) {
            Prize that = countries[i];

            // 1. (K나라보다)금이 더 많은 나라
            if (that.gold > kGold) {
                rank++;
            }
            // 2. 금이 같으면 은이 많은 나라
            else if (that.gold == kGold && that.silver > kSilver) {
                rank++;
            }
            // 3. 금, 은이 같으먄 동이 많은 날
            else if (that.gold == kGold && that.silver == kSilver && that.bronze > kBronze) {
                rank++;
            }
        }

        // 최종 등 수
        System.out.println(rank);

    }


}