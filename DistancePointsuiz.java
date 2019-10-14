/*
 This program gets the distances between sets of points. And displys all the distances
as well as the largest, and the smallest.
 */
package distancepointsuiz;

import java.util.Scanner;

/**
 *
 * @author fadlabdelaziz
 * @date Sunday, September 29, 2019.
 */
public class DistancePointsuiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // For input
        System.out.print("Enter the number of points you want: "); // Get number of points
        int numberOfPoints = input.nextInt(); // Assign number of points
        int factorialsSum = 0; // For the size of the array that is going to hold all distances
        int counter = 0; // Used to help with filling the distance array
        double distance = 0; //Default value for distance

        int holder = numberOfPoints;
        /**
         * Holder is a variable that I used to hold the value of numberOfPoints
         * because it is going to be decremented in the process and I want to
         * keep the value of numberOfPoints unchanged
         */
        
        
        while (holder > 0) {
            holder--;
            factorialsSum += holder;
        }
        /**
         * While loop to get the sum of all the factorials of numberOfPoints to
         * get the size of the distance array
         */

        int[][] points = new int[numberOfPoints][2];
        double[] allDistances = new double[factorialsSum];
        System.out.println("Enter " + numberOfPoints + " points: ");   // Getting the values of the points
        for (int[] point : points) {
            System.out.println("X:");
            point[0] = input.nextInt();
            System.out.println("Y:");
            point[1] = input.nextInt();
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                System.out.print("Calculating distance between pair " + (i + 1) + " "
                        + "(" + points[i][0] + "," + points[i][1] + ")" + " "
                        + "and " + (j + 1) + " (" + points[j][0] + "," + points[j][1] + ")" + ": ");
                distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]);
                System.out.println(String.format("%.2f", distance));  // Displaying distances 

                allDistances[counter] = distance; //Array to hold all the distances
                counter++;
            }
        }

        maxDistance(allDistances); // Function call to display tha maximum distance

        minDistance(allDistances); // Function call to display tha minimum distance

    }

    // Function to calculate distance
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    // Function to get maximum distance
    public static void maxDistance(double[] x) {
        double maxDistance = x[0];

        for (int i = 0; i < x.length; i++) {
            if (x[i] > maxDistance) {
                maxDistance = x[i];
            }
        }
        System.out.print("The greatest distance between points is ");
        System.out.println(String.format("%.2f", maxDistance));
    }

    // Function to get minimum distance
    public static void minDistance(double[] x) {
        double minDistance = x[0];

        for (int i = 0; i < x.length; i++) {
            if (x[i] < minDistance) {
                minDistance = x[i];
            }
        }
        System.out.print("The least distance between points is ");
        System.out.println(String.format("%.2f", minDistance));

    }
}
