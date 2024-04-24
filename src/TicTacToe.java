import java.util.Scanner;

public class TicTacToe
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        //Declarations
        String currentPlayer = "X";

        do
        {
            clearBoard();   //To Initialize, clear and start a new game board
            display();
            startGame(in, currentPlayer);

        } while (SafeInput.getYNConfirm(in, "Do you want to play the game again?"));

        System.out.println("Thanks, Hope you enjoyed the game!");
    }
    private static void clearBoard()
    {
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                board[i][j] = " ";
            }
        }
    }
    private static void display()
    {
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                System.out.print(board[i][j]);
                if (j < COL - 1)
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < ROW - 1)
            {
                System.out.println("---------");
            }
        }
        System.out.println();
    }
    private static void startGame(Scanner in, String currentPlayer)
        {

            while (true)
            {
                int rowMove = SafeInput.getRangedInt(in, "Enter your row", 1, 3);
                int colMove = SafeInput.getRangedInt(in, "Enter your column", 1, 3);

                if (isValidMove(rowMove, colMove))
                {
                    board[rowMove - 1][colMove - 1] = currentPlayer;
                    display();

                    if (isWin(currentPlayer))
                    {
                        System.out.println(currentPlayer + " wins!");
                        break;
                    } else if (isTie())
                    {
                        System.out.println("It's a tie!");
                        break;
                    }

                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                } else
                {
                    System.out.println("You made an Invalid move. Please try again.");
                }
            }
        }

        private static boolean isValidMove( int row, int col)
        {
            return board[row - 1][col - 1].equals(" ");
        }

        private static boolean isWin(String player)
        {
            return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
        }

        private static boolean isColWin(String player)
        {
            for (int i = 0; i < COL; i++)
            {
                if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))
                {
                    return true;
                }
            }
            return false;
        }

        private static boolean isRowWin(String player)
        {
            for (int i = 0; i < ROW; i++)
            {
                if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
                {
                    return true;
                }
            }
            return false;
        }

        private static boolean isDiagonalWin(String player)
        {
            return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                    (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
        }

        private static boolean isTie()
        {
            for (int i = 0; i < ROW; i++)
            {
                for (int j = 0; j < COL; j++)
                {
                    if (board[i][j].equals(" "))
                    {
                        return false;
                    }
                }
            }
            return true;
        }
}

