package main;

import domain.ChessBoard;
import service.ServiceChessGame;
import utils.GetInput;
import utils.PrintLoadingString;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.lineSeparator;


public class Console {

    public void startRunning(ChessBoard chessBoard,
                             ServiceChessGame serviceChessGame,
                             GetInput getInput,
                             Scanner scanner,
                             PrintLoadingString printLoadingString,
                             Random random)
    {
        String startMessage =
                "------------ Ko-ChessGame is On ------------" +
                        lineSeparator() +
                        "● Before start this game, you should set user name!";
        System.out.println(startMessage);
        String player1 = getInput.inputPlayer1Name(scanner);
        String player2 = getInput.inputPlayer2Name(scanner);
        chessBoard.setPlayer1Name(player1);
        chessBoard.setPlayer2Name(player2);
        chessBoard.printChessBoard();

        System.out.println("● Who goes first ?");
        printLoadingString.PrintLoadingString();

        Integer gameTurn = random.nextInt(2) + 1; // a random number of 0 or 1;
        if (gameTurn % 2 == 1) {
            System.out.println(String.format("▶ '%s'(player1) will attack first !", player1));
            System.out.println("● select piece ( ex → a/7 ) >>");
            String[] currentPiecePosition = getInput.inputChessPiecePosition(scanner); // get a piece selected!
            serviceChessGame.showWherePieceMove(
                            currentPiecePosition,
                            chessBoard
            ); // show where currentPiece can move
            System.out.println("● Where do you want to move?");
            System.out.println("● select position ( ex → a/7 ) >>");
            String[] putPiecePosition = getInput.inputChessPiecePosition(scanner);
            serviceChessGame.attack(
                    putPiecePosition,
                    currentPiecePosition,
                    chessBoard
            );



        } else {
            System.out.println(String.format("▶ '%s'(player2) will attack first !", player2));
            System.out.println("● select piece ( ex → a/7 ) >>");
        }
        Boolean isRunning = true;
        while (isRunning) {
            gameTurn ++;
            if (gameTurn % 2 == 1) {
                // player 2's turn

            } else {
                // player 1's turn
            }
            System.out.println();

        }

    }
}
