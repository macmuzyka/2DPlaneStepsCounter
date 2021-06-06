/**
 * Created by Maciej Muzyka
 * on 06.06.2021
 */

class Main {
    public static void main(String[] args) {
        int[][] testArray1 = new int[][] {{1,1},{3,4},{-1,0}};
        System.out.println(StepsCounter.execute(testArray1));

        int[][] testArray2 = new int[][] {{3,2},{-2,2}};
        System.out.println(StepsCounter.execute(testArray2));
    }
}
