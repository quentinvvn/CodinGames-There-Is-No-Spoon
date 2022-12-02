import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char[][] board = new char[height][width];
        for (int y = 0; y < height; y++) {
            board[y] = in.nextLine().toCharArray();
        }

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if(board[y][x] == '0') {
                    Node currentNode = new Node(x, y);                    
                    Node rightNode = getRightNode(board, currentNode);
                    Node bottomNode = getBottomNode(board, currentNode);

                    System.out.println(currentNode + " " + rightNode + " " + bottomNode);
                }
            }
        }
    }

    private static Node getRightNode(char[][] board, Node currentNode) {
        int i = currentNode.x + 1;
        
        while(i < board[currentNode.y].length && board[currentNode.y][i] != '0') {
            i++;
        }

        if(i == board[currentNode.y].length) {
            return new Node(-1, -1);
        }
        return new Node(i, currentNode.y);
    }

    private static Node getBottomNode(char[][] board, Node currentNode) {
        int i = currentNode.y + 1;
        
        while(i < board.length && board[i][currentNode.x] != '0') {
            i++;
        }

        if(i == board.length) {
            return new Node(-1, -1);
        }
        return new Node(currentNode.x, i);
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
