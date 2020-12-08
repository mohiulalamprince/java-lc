import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignTicTacToe {
    public static void main(String args[]) {

    }

    class Player {
        int[] row;
        int[] col;
        int[] dig;

        Player(int n) {
            row = new int[n];
            col = new int[n];
            dig = new int[n];
        }
    }

    Player p1 = null;
    Player p2 = null;
    int target = 0;

    public DesignTicTacToe(int n) {
        p1 = new Player(n);
        p2 = new Player(n);
        target = n;
    }

    public int move(int row, int col, int player) {
        Player nowp = null;
        if (player == 1) {
            nowp = this.p1;
        } else {
            nowp = this.p2;
        }

        nowp.row[row] += 1;
        nowp.col[col] += 1;

        if (row == col) {
            nowp.dig[0] += 1;
        }
        if (row + col == target - 1) {
            nowp.dig[1] += 1;
        }

        List<Integer> l = new ArrayList(Arrays.asList(nowp.dig[0], nowp.dig[1], nowp.row[row], nowp.col[col]));

        if (l.contains(target)) {
            return player;
        } else {
            return 0;
        }
    }
}
