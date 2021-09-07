package com.company;

import java.util.Scanner;

public class Game {
    private static final char[][] gameBoard =
            {{' ', '|', ' ', '|', ' '},
             {'-', '+', '-', '+', '-'},
             {' ', '|', ' ', '|', ' '},
             {'-', '+', '-', '+', '-'},
             {' ', '|', ' ', '|', ' '}};

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean inGame = true;
    private static int counter = 1;

    private static void printGameBoard() {
        for (char[] line : gameBoard) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int position) {
       return position > 0 && position < 10;
    }

    private static boolean isPositionIsEmpty(int position) {
        return switch (position) {
            case 1 -> gameBoard[0][0] == ' ';
            case 2 -> gameBoard[0][2] == ' ';
            case 3 -> gameBoard[0][4] == ' ';
            case 4 -> gameBoard[2][0] == ' ';
            case 5 -> gameBoard[2][2] == ' ';
            case 6 -> gameBoard[2][4] == ' ';
            case 7 -> gameBoard[4][0] == ' ';
            case 8 -> gameBoard[4][2] == ' ';
            case 9 -> gameBoard[4][4] == ' ';
            default -> false;
        };
    }

    private static void insertSymbol(int position, char symbol) {
        switch (position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    private static void checkVictory() {
        if (gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][0] == gameBoard[0][4] && gameBoard[0][0] != ' ') {
            if (gameBoard[0][0] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][0] == gameBoard[2][4] && gameBoard[2][0] != ' ') {
            if (gameBoard[2][0] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[4][0] == gameBoard[4][2] && gameBoard[4][0] == gameBoard[4][4] && gameBoard[4][0] != ' ') {
            if (gameBoard[4][0] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[0][0] == gameBoard[2][0] && gameBoard[0][0] == gameBoard[4][0] && gameBoard[0][0] != ' ') {
            if (gameBoard[0][0] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[0][2] == gameBoard[2][2] && gameBoard[0][2] == gameBoard[4][2] && gameBoard[0][2] != ' ') {
            if (gameBoard[0][2] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[0][4] == gameBoard[2][4] && gameBoard[0][4] == gameBoard[4][4] && gameBoard[0][4] != ' ') {
            if (gameBoard[0][4] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] == gameBoard[4][4] && gameBoard[0][0] != ' ') {
            if (gameBoard[0][0] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        } else if (gameBoard[0][4] == gameBoard[2][2] && gameBoard[0][4] == gameBoard[4][0] && gameBoard[0][4] != ' ') {
            if (gameBoard[0][4] == 'X') {
                System.out.println("You wins!");
            } else {
                System.out.println("You lose!");
            }
            printGameBoard();
            inGame = false;
        }

    }

    private static void playerMove() {
        System.out.print("Enter number from 1 to 9: ");
        int position = scanner.nextInt();
        if (isInBounds(position) && isPositionIsEmpty(position))
            insertSymbol(position, 'X');
        else
            playerMove();
    }

    private static void computerMove() {
        int position = (int)(Math.random() * 9 + 1);
        if (isInBounds(position) && isPositionIsEmpty(position))
            insertSymbol(position, '0');
        else
            computerMove();
    }

    public static void play(){
        printGameBoard();
        while (inGame) {
            if (counter % 2 == 1) {
                playerMove();
            }
            checkVictory();

            if (counter % 2 == 0) {
                computerMove();
                checkVictory();
                printGameBoard();
            }
            counter++;
        }
    }
}