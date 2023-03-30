//Tower Of Honoi Iterative method using Stack
import java.util.Stack;

public class TowerOfHI {
    public static void main(String[] args) {
        int n = 4; // number of disks
        int numMoves = (int) Math.pow(2, n) - 1; // total number of moves
        char source = 'A', destination = 'C', auxiliary = 'B'; // A, B and C are the rod names

        Stack<Integer> s = new Stack<>(); // stack to keep track of disks
        for (int i = n; i > 0; i--) {
            s.push(i);
        }

        if (n % 2 == 0) { // for even number of disks, swap destination and auxiliary
            char temp = destination;
            destination = auxiliary;
            auxiliary = temp;
        }

        for (int i = 1; i <= numMoves; i++) {
            if (i % 3 == 1) {
                move(s, source, destination);
            } else if (i % 3 == 2) {
                move(s, source, auxiliary);
            } else {
                move(s, auxiliary, destination);
            }
        }
    }

    static void move(Stack<Integer> s, char source, char destination) {
        int disk = s.pop();
        System.out.println("Move disk " + disk + " from rod " + source + " to rod " + destination);
    }
}
