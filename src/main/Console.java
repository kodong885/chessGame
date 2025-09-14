package main;

import Utils.GetUserInput;
import Utils.PrintLoadingString;
import domain.ChessBoard;
import domain.ChessPiece;
import service.ServiceChessGame;

import java.util.Random;
import java.util.Scanner;

public class Console {
    public void startGame(
            Scanner scanner,
            GetUserInput getUserInput,
            PrintLoadingString printLoadingString,
            Random random,
            ServiceChessGame serviceChessGame
    ) {
        String startMessage =
                "< ------------ Ko-ChessGame is On ------------> " +
                        System.lineSeparator() +
                        "● Before start this game, you should set user name!";
        System.out.println(startMessage);

        // set player name;
        System.out.println("● Please enter user name here");
        String player1Name = getUserInput.inputUserName(scanner);
        String player2Name = getUserInput.inputUserName(scanner);
        ChessBoard chessBoard = new ChessBoard(player1Name, player2Name); // initialize chessBoard
        chessBoard.printChessBoard();

        System.out.println("● Who goes first ?");
        printLoadingString.PrintLoadingString();
        int gameTurn = random.nextInt(2) + 1; // a random number of 1 or 2;
        if (gameTurn == 1 ) {
            System.out.println(String.format("▶ '%s'(player1) will attack first !", player1Name));
            System.out.println("● select piece ( ex → a/7 ) >>");
            ChessPiece currentPiece;
            while (true) {
                currentPiece = chessBoard.getCurrentPiece(
                        getUserInput.selectCurrentPiece(scanner)
                );
                if (serviceChessGame.checkCurrentPieceCanMove(currentPiece)) {
                    System.out.println("What you selected is ~~");
                    break;
                } else {
                    System.out.println("● This piece(%s) can't move anywhere !");
                    System.out.println("● Please try again! ");
                }
            }

            System.out.println("● Where do you want to move your(%s) piece? ");
            System.out.println("● select piece ( ex → a/7 ) >>");
            String[] putPiecePosition;
            while (true) {
                putPiecePosition = getUserInput.enterPutPiecePosition(scanner);
                if (serviceChessGame.checkPutPieceCanMoveHere(putPiecePosition, currentPiece)) {
                    break;
                } else {
                    System.out.println("● This piece(%s) can't move here(%s) !");
                    System.out.println("● Please try again !");
                }
            }
            serviceChessGame.attack(currentPiece, putPiecePosition);
        } else {

        }

        while (true) {

        }




    }


}