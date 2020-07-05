package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

enum GameState {
    START, PLAY, DRAW, XWIN, OWIN, INPROGRESS
}

public class Main {


    public static void main(String[] args) {

        TicTacToeGame game = new TicTacToeGame();

        GameState gameState = GameState.START;
        char[][] matrix = new char[3][3];
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }

        //matrix[0][0] = 'X';
        //matrix[1][0] = 'X';
        //matrix[0][1] = 'O';
        //matrix[1][1] = 'O';
        //matrix[2][1] = 'X';
        //matrix[2][2] = 'X';


        while (gameState == GameState.START) {
            System.out.print("Input command: ");
            String[] commands = scanner.nextLine().split(" ");

            if (game.startGame(commands)) {
                gameState = GameState.PLAY;
            }
        }

        game.printGameField(matrix);

        while (gameState == GameState.PLAY) {
            gameState = game.playGame(matrix);
        }

        switch (gameState) {
            case XWIN:
                System.out.println("X wins");
                break;
            case OWIN:
                System.out.println("O wins");
                break;
            case DRAW:
                System.out.println("Draw");
                break;
            case INPROGRESS:
                System.out.println("Game not finished");
        }
    }

}


class TicTacToeGame {
    private static int countOfSpaces = 9;
    Player player1;
    Player player2;

    public boolean startGame(String[] commands) {
        ArrayList<String> acceptedCommands = new ArrayList<>(Arrays.asList("user", "easy", "medium", "hard"));

        if (commands.length == 3 && acceptedCommands.contains(commands[1]) && acceptedCommands.contains(commands[2])) {
            if ("user".equals(commands[1])) {
                player1 = new User('X');
            } else if ("easy".equals(commands[1])) {
                player1 = new ComputerEasyMode('X');
            } else if ("medium".equals(commands[1])) {
                player1 = new ComputerMediumMode('X');
            } else if ("hard".equals(commands[1])) {
                player1 = new ComputerHardMode('X');
            }

            if ("user".equals(commands[2])) {
                player2 = new User('O');
            } else if ("easy".equals(commands[2])) {
                player2 = new ComputerEasyMode('O');
            } else if ("medium".equals(commands[2])) {
                player2 = new ComputerMediumMode('O');
            } else if ("hard".equals(commands[2])) {
                player2 = new ComputerHardMode('O');
            }
            return true;
        } else {
            System.out.println("Bad parameters!");
            return false;
        }
    }

    public GameState playGame(char[][] matrix) {
        GameState state = GameState.PLAY;

        while (state == GameState.PLAY) {
            boolean player1Turn = player1.makeNextTurn(matrix);
            while (!player1Turn) {
                player1Turn = player1.makeNextTurn(matrix);
            }
            countOfSpaces--;
            printGameField(matrix);
            state = checkGameState(matrix, countOfSpaces);
            if (state != GameState.PLAY) {
                return state;
            }

            boolean player2Turn = player2.makeNextTurn(matrix);
            while (!player2Turn) {
                player2Turn = player2.makeNextTurn(matrix);
            }
            countOfSpaces--;
            printGameField(matrix);
            state = checkGameState(matrix, countOfSpaces);
        }
        return state;
    }


    public void printGameField(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public GameState checkGameState(char[][] matrix, int countOfSpaces) {
        boolean isXWin = false;
        boolean isOWin = false;

        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2]) {
                if (matrix[i][0] == 'X') {
                    isXWin = true;
                }
                if (matrix[i][0] == 'O') {
                    isOWin = true;
                }
            }
        }

        for (int j = 0; j < 3; j++) {
            if (matrix[0][j] == matrix[1][j] && matrix[0][j] == matrix[2][j]) {
                if (matrix[0][j] == 'X') {
                    isXWin = true;
                }
                if (matrix[0][j] == 'O') {
                    isOWin = true;
                }
            }
        }

        if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
            if (matrix[0][0] == 'X') {
                isXWin = true;
            }
            if (matrix[0][0] == 'O') {
                isOWin = true;
            }
        }

        if (matrix[2][0] == matrix[1][1] && matrix[2][0] == matrix[0][2]) {
            if (matrix[2][0] == 'X') {
                isXWin = true;
            }
            if (matrix[2][0] == 'O') {
                isOWin = true;
            }
        }

        if (isXWin) {
            return GameState.XWIN;
        } else if (isOWin) {
            return GameState.OWIN;
        } else if (countOfSpaces == 0) {
            return GameState.DRAW;
        } //else {
        //return GameState.INPROGRESS; //to remove
        //}
        return GameState.PLAY;
    }

}




abstract class Player {
    char userMarker;

    public Player(char userMarker) {
        this.userMarker = userMarker;
    }

    abstract boolean makeNextTurn(char[][] matrix);

}


class User extends Player {

    public User(char userMarker) {
        super(userMarker);
    }

    @Override
    public boolean makeNextTurn(char[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        int i;
        int j;

        System.out.print("Enter the coordinates: ");
        String[] coordinates = scanner.nextLine().split(" ");

        try {
            int coordX = Integer.parseInt(coordinates[0]);
            int coordY = Integer.parseInt(coordinates[1]);

            switch (coordX) {
                case 1:
                    j = 0;
                    break;
                case 2:
                    j = 1;
                    break;
                case 3:
                    j = 2;
                    break;
                default:
                    System.out.println("Coordinates should be from 1 to 3!");
                    return false;
            }

            switch (coordY) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 0;
                    break;
                default:
                    System.out.println("Coordinates should be from 1 to 3!");
                    return false;
            }

            if (matrix[i][j] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }

            matrix[i][j] = userMarker;
        } catch (NumberFormatException nfe) {
            System.out.println("You should enter numbers!");
            return false;
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("You should enter TWO numbers!");
            return false;
        }
        return true;
    }
}


class ComputerEasyMode extends Player {

    public ComputerEasyMode(char userMarker) {
        super(userMarker);
    }

    @Override
    public boolean makeNextTurn(char[][] matrix) {
        System.out.println("Making move level \"easy\"");
        Random randomTurn = new Random();

        int i = randomTurn.nextInt(3);
        int j = randomTurn.nextInt(3);

        while (matrix[i][j] != ' ') {
            i = randomTurn.nextInt(3);
            j = randomTurn.nextInt(3);
        }
        matrix[i][j] = userMarker;
        return true;
    }
}

class ComputerMediumMode extends Player {

    public ComputerMediumMode(char userMarker) {
        super(userMarker);
    }

    @Override
    public boolean makeNextTurn(char[][] matrix) {
        char opponentMarker;
        if (userMarker == 'X') {
            opponentMarker = 'O';
        } else {
            opponentMarker = 'X';
        }

        System.out.println("Making move level \"medium\"");


        //1. If it can win in one move (if it has two in a row), it places a third to get three in a row and win.
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == userMarker && matrix[i][0] == matrix[i][1] && matrix[i][2] == ' ') {
                matrix[i][2] = userMarker;
                return true;
            } else if (matrix[i][0] == userMarker && matrix[i][0] == matrix[i][2] && matrix[i][1] == ' ') {
                matrix[i][1] = userMarker;
                return true;
            } else if (matrix[i][1] == userMarker && matrix[i][1] == matrix[i][2] && matrix[i][0] == ' ') {
                matrix[i][0] = userMarker;
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (matrix[0][j] == userMarker && matrix[0][j] == matrix[1][j] && matrix[2][j] == ' ') {
                matrix[2][j] = userMarker;
                return true;
            } else if (matrix[0][j] == userMarker && matrix[0][j] == matrix[2][j] && matrix[1][j] == ' ') {
                matrix[1][j] = userMarker;
                return true;
            } else if (matrix[1][j] == userMarker && matrix[1][j] == matrix[2][j] && matrix[0][j] == ' ') {
                matrix[0][j] = userMarker;
                return true;
            }
        }

        if (matrix[0][0] == userMarker && matrix[0][0] == matrix[1][1] && matrix[2][2] == ' ') {
            matrix[2][2] = userMarker;
            return true;
        } else if (matrix[0][0] == userMarker && matrix[0][0] == matrix[2][2] && matrix[1][1] == ' ') {
            matrix[1][1] = userMarker;
            return true;
        } else if (matrix[1][1] == userMarker && matrix[1][1] == matrix[2][2] && matrix[0][0] == ' ') {
            matrix[0][0] = userMarker;
            return true;
        }

        if (matrix[2][0] == userMarker && matrix[2][0] == matrix[1][1] && matrix[0][2] == ' ') {
            matrix[0][2] = userMarker;
            return true;
        } else if (matrix[2][0] == userMarker && matrix[2][0] == matrix[0][2] && matrix[1][1] == ' ') {
            matrix[1][1] = userMarker;
            return true;
        } else if (matrix[1][1] == userMarker && matrix[1][1] == matrix[0][2] && matrix[2][0] == ' ') {
            matrix[2][0] = userMarker;
            return true;
        }

        //2. If the opponent can win in one move, it plays the third itself to block the opponent to win.
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == opponentMarker && matrix[i][0] == matrix[i][1] && matrix[i][2] == ' ') {
                matrix[i][2] = userMarker;
                return true;
            } else if (matrix[i][0] == opponentMarker && matrix[i][0] == matrix[i][2] && matrix[i][1] == ' ') {
                matrix[i][1] = userMarker;
                return true;
            } else if (matrix[i][1] == opponentMarker && matrix[i][1] == matrix[i][2] && matrix[i][0] == ' ') {
                matrix[i][0] = userMarker;
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (matrix[0][j] == opponentMarker && matrix[0][j] == matrix[1][j] && matrix[2][j] == ' ') {
                matrix[2][j] = userMarker;
                return true;
            } else if (matrix[0][j] == opponentMarker && matrix[0][j] == matrix[2][j] && matrix[1][j] == ' ') {
                matrix[1][j] = userMarker;
                return true;
            } else if (matrix[1][j] == opponentMarker && matrix[1][j] == matrix[2][j] && matrix[0][j] == ' ') {
                matrix[0][j] = userMarker;
                return true;
            }
        }

        if (matrix[0][0] == opponentMarker && matrix[0][0] == matrix[1][1] && matrix[2][2] == ' ') {
            matrix[2][2] = userMarker;
            return true;
        } else if (matrix[0][0] == opponentMarker && matrix[0][0] == matrix[2][2] && matrix[1][1] == ' ') {
            matrix[1][1] = userMarker;
            return true;
        } else if (matrix[1][1] == opponentMarker && matrix[1][1] == matrix[2][2] && matrix[0][0] == ' ') {
            matrix[0][0] = userMarker;
            return true;
        }

        if (matrix[2][0] == opponentMarker && matrix[2][0] == matrix[1][1] && matrix[0][2] == ' ') {
            matrix[0][2] = userMarker;
            return true;
        } else if (matrix[2][0] == opponentMarker && matrix[2][0] == matrix[0][2] && matrix[1][1] == ' ') {
            matrix[1][1] = userMarker;
            return true;
        } else if (matrix[1][1] == opponentMarker && matrix[1][1] == matrix[0][2] && matrix[2][0] == ' ') {
            matrix[2][0] = userMarker;
            return true;
        }

        //3. Otherwise, it makes a random move.
        Random randomTurn = new Random();

        int i = randomTurn.nextInt(3);
        int j = randomTurn.nextInt(3);

        while (matrix[i][j] != ' ') {
            i = randomTurn.nextInt(3);
            j = randomTurn.nextInt(3);
        }
        matrix[i][j] = userMarker;
        return true;
    }
}


class ComputerHardMode extends Player {
    public ComputerHardMode(char userMarker) {
        super(userMarker);
    }

    TicTacToeGame game = new TicTacToeGame();

    @Override
    public boolean makeNextTurn(char[][] matrix) {
        System.out.println("Making move level \"hard\"");
        int bestScore = -100;
        int[] bestMove = new int[2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ') {
                    matrix[i][j] = userMarker;
                    int score = miniMax(matrix, userMarker, 0, false);
                    matrix[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                    //System.out.println(bestScore + " " + bestMove[0] + ", " + bestMove[1]);
                }
            }
        }
        matrix[bestMove[0]][bestMove[1]] = userMarker;
        return true;
    }

    public int miniMax(char[][] matrix, char userMarker, int depth, boolean isMaximising) {
        int availSpots = listOfAvailableSpots(matrix);
        GameState result = game.checkGameState(matrix, availSpots);
        if (result == GameState.XWIN && userMarker == 'X') {
            return 10;
        } else if (result == GameState.XWIN && userMarker == 'O') {
            return -10;
        } else if (result == GameState.OWIN && userMarker == 'X') {
            return -10;
        } else if (result == GameState.OWIN && userMarker == 'O') {
            return 10;
        } else if (result == GameState.DRAW) {
            return 0;
        }

        char opponentMarker = userMarker == 'X' ? 'O' : 'X';

        if (isMaximising) {
            int bestScore = -100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] == ' ') {
                        matrix[i][j] = userMarker;
                        int score = miniMax(matrix, userMarker, depth + 1, false);
                        matrix[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] == ' ') {
                        matrix[i][j] = opponentMarker;
                        int score = miniMax(matrix, userMarker, depth + 1, true);
                        matrix[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }


    public int listOfAvailableSpots(char[][] matrix) {
        int availSpots = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == ' ') {
                    availSpots++;
                }
            }
        }
        return availSpots;
    }
}