import java.util.Scanner;
import java.util.Random;

public class TicTacToe{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        //create board
        char[][] board = makeBoard();
        //displays default positions on board
        defaultBoard();

        boolean win = false;
        boolean validPlayerMove = false;
        //tracks turn taken
        int turns = 0;
        //initalized variable to store player's positions 
        int playersMove = 0;
        //initalized variable to store computer's position
        int compMove = 0;

        boolean validMoves = true;

        System.out.println("Player goes first.");
        
        while (!win || validMoves){
            System.out.print("Player's move: ");
            playersMove = input.nextInt();
            validPlayerMove = isValidMove(board, playersMove);
            
            while(!validPlayerMove) {
                System.out.print("Invalid position, try again: ");
                playersMove = input.nextInt();
                validPlayerMove = isValidMove(board, playersMove);
            }

            System.out.println("Valid Move.");
            turn(board, playersMove, 'X');
            printBoard(board);
            turns++;

            //after 5 turns, will begin to check if anyone has won
            if (turns > 4) {
                if(check(board, playersMove)) {
                    win = true;
                    System.out.println("Player Wins!");
                    break;
                }
            }

            //if no one has won after 9 moves, auto draw
            if (turns == 9) {
                System.out.println("Draw, no winner. :(");
                validMoves = false;
                break;
            }

            System.out.print("Computer's move: ");
            
            //will iterate until computer selects an availble position
            while(true){
                compMove = rand.nextInt(9) + 1; //selects value between 1-9
                if (isValidMove(board, compMove)) { //checks computer's move
                    System.out.println(compMove);
                    turns++;
                    break;
                }
            }
            
            //plays computer move
            turn(board, compMove, 'O'); 
            printBoard(board);
            
            if (turns > 4) {
                if(check(board, compMove)) {
                    win = true;
                    System.out.println("Computer wins!");
                    break;
                }
            }

        }
        input.close();
    }

    //creates empty board
    private static char[][] makeBoard() {
        char[][] board = {{' ',' ',' '}, 
                          {' ',' ',' '}, 
                          {' ',' ',' '}};
        return board;
    }

    //default board with position
    private static void defaultBoard() {
        char[][] basicBoard = {{'1','2','3'}, 
                               {'4','5','6'}, 
                               {'7','8','9'}};
        System.out.println("Positions on the board: ");
        printBoard(basicBoard);
    }

    //prints board
    private static void printBoard(char[][] board) {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
            System.out.println("");
            System.out.println("-------");
        }
    }

    //checks if position is available
    private static boolean isValidMove(char[][] board, int position) {
        switch(position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default : 
                return false;
        }
    }

    //inserts character into board
    private static void turn(char[][] board, int position, char symbol) {
        switch(position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default : 
                System.out.println("Not Valid :(");
        }
    }

    //checks for 3 in a rows
    private static boolean check(char[][] board, int position) {
        if (position == 1) {
            if (board[0][0] == board[0][1]) {
                if (board[0][0]==board[0][2]) 
                    return true;
                else 
                    return false;
            }
            else if (board[0][0] == board[1][1]) {
                if (board[0][0]==board[2][2])
                    return true;
                else
                    return false;
            }
            else if (board[0][0] == board[1][0]) {
                if (board[0][0] == board [2][0])
                    return true;
                
                else
                    return false;
            }
            else
                return false;
        }
        else if(position == 2) {
            if (board[0][1] == board[1][1]) {
                if(board[0][1] == board[2][1])
                    return true;
                else
                    return false;
            }
            else if (board[0][1] == board[0][0]) {
                if(board[0][1] == board[0][2])
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else if (position == 3) {
            if (board[0][0] == board[0][1]) {
                if (board[0][0]==board[0][2]) 
                    return true;
                else 
                    return false;
            }
            else if (board[0][2] == board[1][1]) {
                if (board[0][2]==board[2][0])
                    return true;
                else
                    return false;
            }
            else if (board[0][2] == board[1][2]) {
                if (board[0][2] == board [2][2])
                    return true;
                
                else
                    return false;
            }
            else
                return false;
        }
        else if(position == 4) {
            if (board[1][0] == board[0][0]) {
                if(board[1][0] == board[2][0])
                    return true;
                else
                    return false;
            }
            else if (board[1][1] == board[1][0]) {
                if(board[1][1] == board[1][2])
                    return true;
                else
                    return false;
            }
            else
                return false;    
        }
        else if (position == 5) {
            if (board[1][0] == board[1][1]) {
                if (board[1][0]==board[1][2]) 
                    return true;
                else 
                    return false;
            }
            else if (board[0][0] == board[1][1]) {
                if (board[0][0]==board[2][2])
                    return true;
                else
                    return false;
            }
            else if (board[0][1] == board[1][1]) {
                if (board[1][1] == board [2][1])
                    return true;
                
                else
                    return false;
            }
            else if (board[1][1] == board[0][2]) {
                if (board[1][1]==board[2][0])
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else if(position == 6) {
            if (board[1][2] == board[0][2]) {
                if(board[1][2] == board[2][2])
                    return true;
                else
                    return false;
            }
            else if (board[1][2] == board[1][0]) {
                if(board[1][2] == board[1][1])
                    return true;
                else
                    return false;
            }
            else
                return false;
            
        }
        else if (position == 7) {
            if (board[2][0] == board[2][1]) {
                if (board[2][0]==board[2][2]) 
                    return true;
                else 
                    return false;
            }
            else if (board[0][2] == board[1][1]) {
                if (board[0][2]==board[2][0])
                    return true;
                else
                    return false;
            }
            else if (board[0][0] == board[1][0]) {
                if (board[0][0] == board [2][0])
                    return true;
                
                else
                    return false;
            }
            else
                return false;
        }
        else if(position == 8) {
            if (board[2][1] == board[1][1]) {
                if(board[2][1] == board[0][1])
                    return true;
                else
                    return false;
            }
            else if (board[2][1] == board[2][0]) {
                if(board[2][1] == board[2][2])
                    return true;
                else
                    return false;
            }
            else
                return false;
     
        }
        else if (position == 9) {
            if (board[2][0] == board[2][1]) {
                if (board[2][0]==board[2][2]) 
                    return true;
                else 
                    return false;
            }
            else if (board[0][0] == board[1][1]) {
                if (board[0][0]==board[2][2])
                    return true;
                else
                    return false;
            }
            else if (board[0][2] == board[1][2]) {
                if (board[0][2] == board [2][2])
                    return true;
                
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false; 
    }          
}