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
    private static final int x = 0; // representing x value of given point coordinate [x, y] -> [0, 1]
    private static final int y = 1; // representing y value as in example above

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
            if (possibleToMoveDiagonally_UpAndRight(points[nextPoint], operatingPoint)) {
                moveDiagonally_UpAndRight(operatingPoint);
                steps++;
            }

            if (possibleToMoveDiagonally_UpAndLeft(points[nextPoint], operatingPoint)) {
                moveDiagonally_UpAndLeft(operatingPoint);
                steps++;
            }

            if (possibleToMoveDiagonally_DownAndRight(points[nextPoint], operatingPoint)) {
                moveDiagonally_DownAndRight(operatingPoint);
                steps++;
            }

            if (possibleToMoveDiagonally_DownAndLEft(points[nextPoint], operatingPoint)) {
                moveDiagonally_DownAndLeft(operatingPoint);
                steps++;
            }

            if (possibleToMove_Left(points[nextPoint], operatingPoint)) {
                move_Left(operatingPoint);
                steps++;
            }

            if (possibleToMove_Right(points[nextPoint], operatingPoint)) {
                move_Right(operatingPoint);
                steps++;
            }

            if (possibleToMove_Up(points[nextPoint], operatingPoint)) {
                move_Up(operatingPoint);
                steps++;
            }

            if (possibleToMove_Down(points[nextPoint], operatingPoint)) {
                move_Down(operatingPoint);
                steps++;
            }

            if (pointFromArrayReached(operatingPoint, points[nextPoint])) {
                if (lastPointReached(operatingPoint, points[lastPointIndex])) {
                    lastPointReachedMessage();
                    return steps;
                }

                pointsVisited++;
                nextPoint++;
                pointReachedMessage();
            }
        }

        return steps;
    }

    /**
     * TODO: consider possibility to delegate all possible methods to separated for single responsibility,
     * TODO: same goes for all move methods
     */

    private static boolean pointFromArrayReached(final int[] operatingPoint, final int[] point) {
        return operatingPoint[x] == point[x] &&
                operatingPoint[y] == point[y];
    }

    private static boolean lastPointReached(final int[] operatingPoint, final int[] point) {
        return operatingPoint[x] == point[x] &&
                operatingPoint[y] == point[y];
    }

    private static boolean possibleToMove_Down(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] == point[x] &&
                operatingPoint[y] > point[y];
    }

    private static boolean possibleToMove_Up(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] == point[x] &&
                operatingPoint[y] < point[y];
    }

    private static boolean possibleToMove_Right(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] < point[x] &&
                operatingPoint[y] == point[y];
    }

    private static boolean possibleToMove_Left(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] > point[x] &&
                operatingPoint[y] == point[y];
    }

    private static boolean possibleToMoveDiagonally_DownAndLEft(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] > point[x] &&
                operatingPoint[y] > point[y];
    }

    private static boolean possibleToMoveDiagonally_DownAndRight(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] < point[x] &&
                operatingPoint[y] > point[y];
    }

    private static boolean possibleToMoveDiagonally_UpAndLeft(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] > point[x] &&
                operatingPoint[y] < point[y];
    }

    private static boolean possibleToMoveDiagonally_UpAndRight(final int[] point, final int[] operatingPoint) {
        return operatingPoint[x] < point[x] &&
                operatingPoint[y] < point[y];
    }

    private static void lastPointReachedMessage() {
        System.out.println("Last point reached!");
    }

    private static void pointReachedMessage() {
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
