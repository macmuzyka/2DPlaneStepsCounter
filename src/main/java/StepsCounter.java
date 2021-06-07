/**
 * Created by Maciej Muzyka
 * on 06.06.2021
 * Idea of this program is to count number of steps it takes to go from the first to last point(2D plane with x and y coordinates)
 * of an array, visiting all the points in order they occur in array
 * EXPLANATION:
 * Input: points = [[1,1],[3,4],[-1,0]]
 * One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Steps: 7
 */

class StepsCounter {
    private static int x = 0; // representing x value of given point coordinate [x, y] -> [0, 1]
    private static int y = 1; // representing y value as in example above

    static int execute(int[][] points) {
        if (points == null || points.length == 1) {
            return -1;
        }



        int totalPoints = points.length;
        int lastPointIndex = points.length - 1;
        int nextPoint = 1;  // index of a first point that operating point is being compared to until point is met,
                            // incremented when point is reached
        int pointsVisited = 0;

        int[] operatingPoint = {points[0][0], points[0][1]}; // first point of an array to work with
        int steps = 0;

        while (pointsVisited <= totalPoints) {

            if (operatingPoint[x] < points[nextPoint][x] &&
                    operatingPoint[y] < points[nextPoint][y]) {
                moveDiagonally_UpAndRight(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] > points[nextPoint][x] &&
                    operatingPoint[y] < points[nextPoint][y]) {
                moveDiagonally_UpAndLeft(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] < points[nextPoint][x] &&
                    operatingPoint[y] > points[nextPoint][y]) {
                moveDiagonally_DownAndRight(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] > points[nextPoint][x] &&
                    operatingPoint[y] > points[nextPoint][y]) {
                moveDiagonally_DownAndLeft(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] > points[nextPoint][x] &&
                    operatingPoint[y] == points[nextPoint][y]) {
                move_Left(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] < points[nextPoint][x] &&
                    operatingPoint[y] == points[nextPoint][y]) {
                move_Right(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] == points[nextPoint][x] &&
                    operatingPoint[y] < points[nextPoint][y]) {
                move_Up(operatingPoint);
                steps++;
            }

            if (operatingPoint[x] == points[nextPoint][x] &&
                    operatingPoint[y] > points[nextPoint][y]) {
                move_Down(operatingPoint);
                steps++;
            }

            // condition for reaching last from from given array
            if (operatingPoint[x] == points[lastPointIndex][x] &&
                    operatingPoint[y] == points[lastPointIndex][y]) {
                lastPointReachedMessage();
                return steps;
            }

            // condition if point from array is met
            if (operatingPoint[x] == points[nextPoint][x] &&
                    operatingPoint[y] == points[nextPoint][y]) {
                pointsVisited++;
                nextPoint++;
                pointReacedMessage();
            }
        }

        return steps;
    }

    private static void lastPointReachedMessage() {
        System.out.println("Last point reached!");
    }

    private static void pointReacedMessage() {
        System.out.println("Point from array reached!");
    }

    private static void printCurrentPoint(final int[] operatingPoint) {
        System.out.println("Operating point: x = " + operatingPoint[0] + " y = " + operatingPoint[1]);
    }

    private static void move_Up(int[] point) {
        point[y]++;
        printCurrentPoint(point);
    }

    private static void move_Down(int[] point) {
        point[y]--;
        printCurrentPoint(point);
    }

    private static void move_Right(int[] point) {
        point[x]++;
        printCurrentPoint(point);
    }

    private static void move_Left(int[] point) {
        point[x]--;
        printCurrentPoint(point);
    }

    private static void moveDiagonally_DownAndLeft(int[] point) {
        point[x]--;
        point[y]--;
        printCurrentPoint(point);
    }

    private static void moveDiagonally_DownAndRight(int[] point) {
        point[x]++;
        point[y]--;
        printCurrentPoint(point);
    }

    private static void moveDiagonally_UpAndRight(int[] point) {
        point[x]++;
        point[y]++;
        printCurrentPoint(point);

    }

    private static void moveDiagonally_UpAndLeft(int[] point) {
        point[x]--;
        point[y]++;
        printCurrentPoint(point);
    }
}
