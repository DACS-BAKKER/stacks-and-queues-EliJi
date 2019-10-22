/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 10-15-19
 *  Description: This class is the runner for solving the Josephus
 *  Problem. Method used is in the queue class.
 **************************************************************************** */

public class JosephusProblem {
    public static void main(String[] args) {
        System.out.println("This program solves the Josephus Problem.");
        System.out.println("Number of people? ");
        int n = StdIn.readInt();
        System.out.println("Number of people to skip? ");
        int s = StdIn.readInt();
        Queue<Integer> q = new Queue<Integer>();
        q.Josephus(n,s);
    }
}
