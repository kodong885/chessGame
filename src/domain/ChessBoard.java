package domain;

import java.util.Arrays;

public class ChessBoard {

    ChessPiece[][] chessBoard = new ChessPiece[8][8];
    String player1Name;
    String player2Name;

    public ChessBoard(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    // Instance Initialization Block to set initial chessBoard;
    {
        // set empty spaces ( all 3 ~ 6 line are filled with object named "EmptySpace" )
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece empty = new EmptySpace();
                empty.setCurrentPositionX(j);
                empty.setCurrentPositionY(i);
                empty.setPieceType("Empty");
                empty.setColor("Empty");
                chessBoard[i][j] = empty;
            }
        }
        // set line 1(y) with pawnBlack
        for (int i = 0; i < 8; i++) {
            ChessPiece pawnBlack = new Pawn();
            pawnBlack.setCurrentPositionX(i);
            pawnBlack.setCurrentPositionY(1);
            pawnBlack.setPieceType("Pawn");
            pawnBlack.setColor("Black");
            chessBoard[1][i] = pawnBlack;
        }
        // set line 7(y) with PawnWhite
        for (int i =0; i < 8; i++) {
            ChessPiece PawnWhite = new Pawn();
            PawnWhite.setCurrentPositionX(i);
            PawnWhite.setCurrentPositionY(6);
            PawnWhite.setPieceType("Pawn");
            PawnWhite.setColor("White");
            chessBoard[6][i] = PawnWhite;
        }

        // set Rook ( leftSide, rightSide in order )
        ChessPiece rookWhiteLeft = new Rook();
        ChessPiece rookWhiteRight = new Rook();
        rookWhiteLeft.setCurrentPositionX(0);
        rookWhiteLeft.setCurrentPositionY(7);
        rookWhiteLeft.setPieceType("Rook");
        rookWhiteLeft.setColor("White");
        rookWhiteRight.setCurrentPositionX(7);
        rookWhiteRight.setCurrentPositionY(7);
        rookWhiteRight.setPieceType("Rook");
        rookWhiteRight.setColor("White");
        chessBoard[7][0] = rookWhiteLeft;
        chessBoard[7][7] = rookWhiteRight;
        ChessPiece rookBlackLeft = new Rook();
        ChessPiece rookBlackRight = new Rook();
        rookBlackLeft.setCurrentPositionX(0);
        rookBlackLeft.setCurrentPositionY(0);
        rookBlackLeft.setPieceType("Rook");
        rookBlackLeft.setColor("Black");
        rookBlackRight.setCurrentPositionX(7);
        rookBlackRight.setCurrentPositionY(0);
        rookBlackRight.setPieceType("Rook");
        rookBlackRight.setColor("Black");
        chessBoard[0][0] = rookBlackLeft;
        chessBoard[0][7] = rookBlackRight;

        // set Knight ( leftSide, rightSide in order )
        ChessPiece knightWhiteLeft = new Knight();
        ChessPiece knightWhiteRight = new Knight();
        knightWhiteLeft.setCurrentPositionX(1);
        knightWhiteLeft.setCurrentPositionY(7);
        knightWhiteLeft.setPieceType("Knight");
        knightWhiteLeft.setColor("White");
        knightWhiteRight.setCurrentPositionX(6);
        knightWhiteRight.setCurrentPositionY(7);
        knightWhiteRight.setPieceType("Knight");
        knightWhiteRight.setColor("White");
        chessBoard[7][1] = knightWhiteLeft;
        chessBoard[7][6] = knightWhiteRight;
        ChessPiece knightBlackLeft = new Knight();
        ChessPiece knightBlackRight = new Knight();
        knightBlackLeft.setCurrentPositionX(1);
        knightBlackLeft.setCurrentPositionY(0);
        knightBlackLeft.setPieceType("Knight");
        knightBlackLeft.setColor("Black");
        knightBlackRight.setCurrentPositionX(6);
        knightBlackRight.setCurrentPositionY(0);
        knightBlackRight.setPieceType("Knight");
        knightBlackRight.setColor("Black");
        chessBoard[0][1] = knightBlackLeft;
        chessBoard[0][6] = knightBlackRight;

        // set Bishop ( leftSide, rightSide in order )
        ChessPiece bishopWhiteLeft = new Bishop();
        ChessPiece bishopWhiteRight = new Bishop();
        bishopWhiteLeft.setCurrentPositionX(2);
        bishopWhiteLeft.setCurrentPositionY(7);
        bishopWhiteLeft.setPieceType("Bishop");
        bishopWhiteLeft.setColor("White");
        bishopWhiteRight.setCurrentPositionX(5);
        bishopWhiteRight.setCurrentPositionY(7);
        bishopWhiteRight.setPieceType("Bishop");
        bishopWhiteRight.setColor("White");
        chessBoard[7][2] = bishopWhiteLeft;
        chessBoard[7][5] = bishopWhiteRight;
        ChessPiece bishopBlackLeft = new Bishop();
        ChessPiece bishopBlackRight = new Bishop();
        bishopBlackLeft.setCurrentPositionX(2);
        bishopBlackLeft.setCurrentPositionY(0);
        bishopBlackLeft.setPieceType("Bishop");
        bishopBlackLeft.setColor("Black");
        bishopBlackRight.setCurrentPositionX(5);
        bishopBlackRight.setCurrentPositionY(0);
        bishopBlackRight.setPieceType("Bishop");
        bishopBlackRight.setColor("Black");
        chessBoard[0][2] = bishopBlackLeft;
        chessBoard[0][5] = bishopBlackRight;

        // set Queen ( Black and White in order )
        ChessPiece queenWhite = new Queen();
        queenWhite.setCurrentPositionX(3);
        queenWhite.setCurrentPositionY(7);
        queenWhite.setPieceType("Queen");
        queenWhite.setColor("White");
        chessBoard[7][3] = queenWhite;
        ChessPiece queenBlack = new Queen();
        queenBlack.setCurrentPositionX(3);
        queenBlack.setCurrentPositionY(0);
        queenBlack.setPieceType("Queen");
        queenBlack.setColor("Black");
        chessBoard[0][3] = queenBlack;

        // set King ( Black and White in order )
        ChessPiece kingWhite = new King();
        kingWhite.setCurrentPositionX(4);
        kingWhite.setCurrentPositionY(7);
        kingWhite.setPieceType("King");
        kingWhite.setColor("White");
        chessBoard[7][4] = kingWhite;
        ChessPiece kingBlack = new King();
        kingBlack.setCurrentPositionX(4);
        kingBlack.setCurrentPositionY(0);
        kingBlack.setPieceType("King");
        kingBlack.setColor("Black");
        chessBoard[0][4] = kingBlack;
    }

    public void printChessBoard() {
        System.out.println(String.format("     < %s > (Black)   ", player1Name));
        String chessBoardLine;
        Integer spaceNum;
        for (int i = 0; i < 8; i++) {
            chessBoardLine = "";
            spaceNum = 0;
            for (int j = 0; j < 16; j++) {
                spaceNum ++;
                if (spaceNum % 2 == 0) {
                    chessBoardLine += " ";
                } else {
                    switch (chessBoard[i][j/2].pieceType) { // why this statement cover all case !!!!!!!;
                        case "Pawn" :
                            chessBoardLine += "♟";
                            break;
                        case "Rook" :
                            chessBoardLine += "♜";
                            break;
                        case "Queen" :
                            chessBoardLine += "♛";
                            break;
                        case "King" :
                            chessBoardLine += "♚";
                            break;
                        case "Bishop" :
                            chessBoardLine += "♝";
                            break;
                        case "Knight" :
                            chessBoardLine += "♞";
                            break;
                        case "Empty" :
                            chessBoardLine += "▭";
                            break;
                    }
                }
            }
            System.out.println(chessBoardLine);
        }
        System.out.println(String.format("     < %s > (White)   ", player2Name));
        System.out.println(Arrays.toString(chessBoard[7]));

    }

    public ChessPiece getCurrentPiece(String[] currentPiecePosition) {
        int currentPiecePositionX = 100; // arise error on purpose
        switch (currentPiecePosition[0]) {
            case "a" :
                currentPiecePositionX = 0;
                break;
            case "b" :
                currentPiecePositionX = 1;
                break;
            case "c" :
                currentPiecePositionX = 2;
                break;
            case "d" :
                currentPiecePositionX = 3;
                break;
            case "e" :
                currentPiecePositionX = 4;
                break;
            case "f" :
                currentPiecePositionX = 5;
                break;
            case "g" :
                currentPiecePositionX = 6;
                break;
            case "h" :
                currentPiecePositionX = 7;
                break;
        }
        int currentPiecePositionY = Integer.parseInt(currentPiecePosition[1]);
        return chessBoard[currentPiecePositionY][currentPiecePositionX]; // a/7

    }

    public ChessPiece getPiece(Integer piecePositionX, Integer piecePositionY ) {
        return chessBoard[piecePositionY][piecePositionX];
    }

    public Boolean checkPieceAreSurroundedWithSameColor(Integer surroundingPiecePositionX,
                                                        Integer surroundingPiecePositionY,
                                                        ChessPiece currentPiece
    ) { // this only used in the check currenPieceCanMove method in ServiceChessGame;
        if (
                surroundingPiecePositionX < 0 || surroundingPiecePositionX > 7
                ||  surroundingPiecePositionY < 0 || surroundingPiecePositionY > 7
        ) {
            return true;

        } else {
            if (
            getPiece(surroundingPiecePositionX, surroundingPiecePositionY)
                    .color
                    .equals(currentPiece.getColor())
            ) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionInOneDirection(
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY,
            ChessPiece currentPiece
    ) {

        // Queen, Rook, Bishop
        if (currentPiece.getColor().equals("Queen")) {
            


        } else if (currentPiece.getColor().equals("Rook")) {

        } else if (currentPiece.getColor().equals("Queen")) {

        } else

    }


}



