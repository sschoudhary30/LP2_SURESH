import java.util.Scanner;

public class JobScheduling {

    static void selectionSort(int[][] jobs, int n) {
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (jobs[j][1] > jobs[maxIndex][1]) {
                    maxIndex = j;
                }
            }
            // Swap the jobs
            int[] temp = jobs[maxIndex];
            jobs[maxIndex] = jobs[i];
            jobs[i] = temp;
        }
    }

    static void jobScheduling(int[][] jobs, int n) {
        selectionSort(jobs, n); // Sort jobs based on profits

        // Finding max deadline
        int maxD = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // For max deadline
            if (maxD < jobs[i][0]) {
                maxD = jobs[i][0];
            }
        }

        int[] ans = new int[maxD];

        // Initialize it with -1
        for (int j = 0; j < maxD; j++) {
            ans[j] = -1;
        }

        // Sequencing jobs according to profit and within deadline
        for (int k = 0; k < n; k++) {
            for (int m = maxD; m >= 0; m--) {
                // If job deadline is within limit and no other max profit job has taken place then only allocate the job
                if (m < jobs[k][0] && ans[m] == -1) {
                    ans[m] = jobs[k][1];
                    break; // We are storing profit
                }
            }
        }

        // Print the answer, we are printing profits of that job as output
        for (int h = 0; h < maxD; h++) {
            System.out.print(ans[h] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of Jobs : ");
        int n = scanner.nextInt();

        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("\nFor job " + (i + 1) + ": ");
            System.out.print("Enter deadline: ");
            jobs[i][0] = scanner.nextInt();
            System.out.print("Enter profit: ");
            jobs[i][1] = scanner.nextInt();
        }

        jobScheduling(jobs, n);
        scanner.close();
    }
}
