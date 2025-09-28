package main;

import Utils.ChangePieceIndexToChessPosition;
import Utils.GetUserInput;
import Utils.PrintLoadingString;
import domain.Checkmate;
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
            ServiceChessGame serviceChessGame,
            Checkmate checkmate,
            ChangePieceIndexToChessPosition changePieceIndexToChessPosition
    ) {
        String startMessage =
                "< ------------ Ko-ChessGame is On ------------> " +
                        System.lineSeparator() +
                        "● Before start this game, you should set user name!";
        System.out.println(startMessage);

        // set player name;
        System.out.println("● Please enter user name here");
        String blackPlayerName = getUserInput.inputUserName(scanner, "Black"); // black
        String whitePlayerName = getUserInput.inputUserName(scanner, "White"); // white
        ChessBoard chessBoard = new ChessBoard(blackPlayerName, whitePlayerName); // initialize chessBoard

        printLoadingString.PrintLoadingString();

        int gameTurn = random.nextInt(2) + 1; // a random number of 1 or 2;
        String attackUser = null;
        chessBoard.printChessBoard();

        while (true) {
            gameTurn++;
            if (gameTurn % 2 == 1) {
                attackUser = "Black";
            } else {
                attackUser = "White";
            }

            System.out.println(String.format("🍔'%s'(%s) turn🍔", blackPlayerName, attackUser));
            ChessPiece currentPiece;
            while (true) {
                while (true) {
                    System.out.println("● (select) >>");
                    currentPiece = chessBoard.getCurrentPiece(
                            getUserInput.selectCurrentPiece(scanner)
                    );
                    if (
                            currentPiece.getColor().equals(attackUser)
                    ) {
                        break;
                    } else {
                        System.out.println(String.format("● %s(%s) is not your piece!", currentPiece.getPieceType(), currentPiece.getColor()));
                        System.out.println("● Please try again! ");
                    }
                }

                if (serviceChessGame.checkCurrentPieceCanMove(chessBoard, currentPiece)) {
                    System.out.println(String.format("< %s(%s/%s) is selected >",
                            currentPiece.getPieceType(),
                            changePieceIndexToChessPosition
                                    .changePieceIndexXToChessPositionX(
                                            currentPiece.getCurrentPositionX()
                                    ),
                            changePieceIndexToChessPosition
                                    .changePieceIndexYToChessPositionY(
                                            currentPiece.getCurrentPositionY()
                                    )
                            )
                    );
                    break;
                } else {
                    System.out.println(String.format("● This piece(%s) can't move anywhere !", currentPiece.getPieceType()));
                    System.out.println("● Please select again! ");
                }
            }

            chessBoard.printChessBoard();
            System.out.println("● (put) >>");
            String[] putPiecePosition;
            while (true) {
                putPiecePosition = getUserInput.enterPutPiecePosition(scanner);
                if (serviceChessGame.checkPutPieceCanMoveHere(putPiecePosition, currentPiece, chessBoard)) {
                    break;
                } else {
                    System.out.println("● This piece(%s) can't move here(%s) !");
                    System.out.println("● Please try again !");
                }
            }
            // put or attack piece;
            serviceChessGame.attack(currentPiece, putPiecePosition, chessBoard);
            chessBoard.printChessBoard();

            // check check-mate !! ( 어떤 color의 턴이냐에 따라서 checkmate도 다르게 설정해야함!!
            if (attackUser.equals("White")) {
                if (serviceChessGame.isCheckMate(chessBoard, checkmate, "Black")) {
                    System.out.println(String.format(" ⭐⭐ checkmate! ( %s win ) ⭐⭐", blackPlayerName));
                    break;
                } else {
                    continue;
                }
            } else {
                // attackUser.equals("Black")
                if (serviceChessGame.isCheckMate(chessBoard, checkmate, "White")) {
                    System.out.println(String.format(" ⭐⭐ checkmate! ( %s win ) ⭐⭐", whitePlayerName));
                    break;
                } else {
                    continue;
                }
            }

        }
    }


}

