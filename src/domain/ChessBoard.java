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
        return chessBoard[currentPiecePositionY][currentPiecePositionX];

    }

    public ChessPiece getPiece(Integer piecePositionX, Integer piecePositionY ) {
        return chessBoard[piecePositionY][piecePositionX];
    }


    public Boolean checkPieceAreSurroundedWithSameColor(Integer currentPiecePositionX,
                                                        Integer currentPiecePositionY,
                                                        ChessPiece currentPiece
    ) { // this only used in the check "currenPieceCanMove" method in ServiceChessGame;

        Boolean isNorthWestPieceSameColorWithCurrentPiece = false; // ↖
        Boolean isUpPieceSameColorWithCurrentPiece = false; // ↑
        Boolean isNorthEastPieceSameColorWithCurrentPiece = false; // ↗
        Boolean isLeftPieceSameColorWithCurrentPiece = false; // ←
        Boolean isRightPieceSameColorWithCurrentPiece = false; // →
        Boolean isSouthWestPieceSameColorWithCurrentPiece = false; // ↙
        Boolean isDownPieceSameColorWithCurrentPiece = false; // ↓
        Boolean isSouthEastPieceSameColorWithCurrentPiece = false; // ↘


        switch (currentPiece.getPieceType()) {
            case "King", "Queen" :

                // set "isNorthWestPieceSameColorWithCurrentPiece"'s value; "↖"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX - 1,
                                currentPiecePositionY - 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX - 1, currentPiecePositionY - 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isNorthWestPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isNorthWestPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isNorthWestPieceSameColorWithCurrentPiece = true;
                }

                // set "isUpPieceSameColorWithCurrentPiece"'s value; "↑"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX,
                                currentPiecePositionY - 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX, currentPiecePositionY - 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isUpPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isUpPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isUpPieceSameColorWithCurrentPiece = true;
                }

                // set "isNorthEastPieceSameColorWithCurrentPiece"'s value; "↗"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX + 1,
                                currentPiecePositionY - 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX + 1, currentPiecePositionY - 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isNorthEastPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isNorthEastPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isNorthEastPieceSameColorWithCurrentPiece = true;
                }

                // set "isLeftPieceSameColorWithCurrentPiece"'s value; "←"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX - 1,
                                currentPiecePositionY
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX - 1, currentPiecePositionY)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isLeftPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isLeftPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isLeftPieceSameColorWithCurrentPiece = true;
                }

                // set "isRightPieceSameColorWithCurrentPiece"'s value; "→"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX + 1,
                                currentPiecePositionY
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX + 1, currentPiecePositionY)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isRightPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isRightPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isRightPieceSameColorWithCurrentPiece = true;
                }

                // set "isSouthWestPieceSameColorWithCurrentPiece"'s value; "↙"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX - 1,
                                currentPiecePositionY + 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX - 1, currentPiecePositionY + 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isSouthWestPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isSouthWestPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isSouthWestPieceSameColorWithCurrentPiece = true;
                }

                // set "isDownPieceSameColorWithCurrentPiece"'s value; "↓"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX,
                                currentPiecePositionY + 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX, currentPiecePositionY + 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isDownPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isDownPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isDownPieceSameColorWithCurrentPiece = true;
                }

                // set "isSouthEastPieceSameColorWithCurrentPiece"'s value; "↘"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX + 1,
                                currentPiecePositionY + 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX + 1, currentPiecePositionY + 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isSouthEastPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isSouthEastPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isSouthEastPieceSameColorWithCurrentPiece = true;
                }


                if (
                        isNorthWestPieceSameColorWithCurrentPiece &&
                                isUpPieceSameColorWithCurrentPiece &&
                                isNorthEastPieceSameColorWithCurrentPiece &&
                                isLeftPieceSameColorWithCurrentPiece &&
                                isRightPieceSameColorWithCurrentPiece &&
                                isSouthWestPieceSameColorWithCurrentPiece &&
                                isDownPieceSameColorWithCurrentPiece &&
                                isSouthEastPieceSameColorWithCurrentPiece
                ) {
                    return true; // This Current Piece is surrounded with these same color piece;

                } else {
                    return false; // This Current Piece isn't surrounded with these same color piece;
                }

                break;


            case "Rook" :

                // set "isUpPieceSameColorWithCurrentPiece"'s value; "↑"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX,
                                currentPiecePositionY - 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX, currentPiecePositionY - 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isUpPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isUpPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isUpPieceSameColorWithCurrentPiece = true;
                }

                // set "isDownPieceSameColorWithCurrentPiece"'s value; "↓"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX,
                                currentPiecePositionY + 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX, currentPiecePositionY + 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isDownPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isDownPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isDownPieceSameColorWithCurrentPiece = true;
                }

                // set "isRightPieceSameColorWithCurrentPiece"'s value; "→"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX + 1,
                                currentPiecePositionY
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX + 1, currentPiecePositionY)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isRightPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isRightPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isRightPieceSameColorWithCurrentPiece = true;
                }

                // set "isLeftPieceSameColorWithCurrentPiece"'s value; "←"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX - 1,
                                currentPiecePositionY
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX - 1, currentPiecePositionY)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isLeftPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isLeftPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isLeftPieceSameColorWithCurrentPiece = true;
                }


                if (
                        isUpPieceSameColorWithCurrentPiece &&
                                isLeftPieceSameColorWithCurrentPiece &&
                                isRightPieceSameColorWithCurrentPiece &&
                                isDownPieceSameColorWithCurrentPiece
                ) {
                    return true; // This Current Piece is surrounded with these same color piece;
                } else {
                    return false; // This Current Piece isn't surrounded with these same color piece;
                }

                break;

            case "Knight" :

                if (
                        checkKnightIsSurroundedWithSameColor(
                                currentPiecePositionX,
                                currentPiecePositionY,
                                currentPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }
                break;

            case "Bishop" :

                // set "isNorthEastPieceSameColorWithCurrentPiece"'s value; "↗"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX + 1,
                                currentPiecePositionY - 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX + 1, currentPiecePositionY - 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isNorthEastPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isNorthEastPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isNorthEastPieceSameColorWithCurrentPiece = true;
                }

                // set "isNorthWestPieceSameColorWithCurrentPiece"'s value; "↖"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX - 1,
                                currentPiecePositionY - 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX - 1, currentPiecePositionY - 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isNorthWestPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isNorthWestPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isNorthWestPieceSameColorWithCurrentPiece = true;
                }

                // set "isSouthEastPieceSameColorWithCurrentPiece"'s value; "↘"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX + 1,
                                currentPiecePositionY + 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX + 1, currentPiecePositionY + 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isSouthEastPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isSouthEastPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isSouthEastPieceSameColorWithCurrentPiece = true;
                }

                // set "isSouthWestPieceSameColorWithCurrentPiece"'s value; "↙"
                if (

                        !checkPiecePositionOutOfChess(
                                currentPiecePositionX - 1,
                                currentPiecePositionY + 1
                        )
                ) {
                    if (
                            getPiece(currentPiecePositionX - 1, currentPiecePositionY + 1)
                                    .getColor().equals(
                                            currentPiece.getColor()
                                    )
                    ) {
                        // same color;
                        isSouthWestPieceSameColorWithCurrentPiece = true;

                    } else {
                        // different color;
                        isSouthWestPieceSameColorWithCurrentPiece = false;
                    }

                } else {
                    isSouthWestPieceSameColorWithCurrentPiece = true;
                }


                 if (
                         isNorthEastPieceSameColorWithCurrentPiece &&
                                 isNorthWestPieceSameColorWithCurrentPiece &&
                                 isSouthEastPieceSameColorWithCurrentPiece &&
                                 isSouthWestPieceSameColorWithCurrentPiece
                 ) {
                     return true; // This Current Piece is surrounded with these same color piece;
                 } else {
                     return false; // This Current Piece isn't surrounded with these same color piece;
                 }

                break;

        }

    }

    public Boolean checkKnightIsSurroundedWithSameColor(
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            ChessPiece currentPiece
    ) {
        Boolean isXPlus2YMinus1PieceSameColorWithCurrentPiece = false; // x+2 / y-1
        Boolean isXPlus2YPlus1PieceSameColorWithCurrentPiece = false; // x+2 / y+1
        Boolean isXMinus2YMinus1PieceSameColorWithCurrentPiece = false; // x-2 / y-1
        Boolean isXMinus2YPlus1PieceSameColorWithCurrentPiece = false; // x-2 / y+1
        Boolean isXPlus1YMinus2PieceSameColorWithCurrentPiece = false; // x+1 / y-2
        Boolean isXPlus1YPlus2PieceSameColorWithCurrentPiece = false; // x+1 / y+2
        Boolean isXMinus1YMinus2PieceSameColorWithCurrentPiece = false; // x-1 / y-2
        Boolean isXMinus1YPlus2PieceSameColorWithCurrentPiece = false; // x-1 / y+2

        // set "isXPlus2YMinus1PieceSameColorWithCurrentPiece"'s value; "x+2 / y-1"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX + 2,
                        currentPiecePositionY - 1
                )
        ) {
            if (
                    getPiece(currentPiecePositionX + 2, currentPiecePositionY - 1)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXPlus2YMinus1PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXPlus2YMinus1PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXPlus2YMinus1PieceSameColorWithCurrentPiece = true;
        }

        // set "isXPlus2YPlus1PieceSameColorWithCurrentPiece"'s value; "x+2 / y+1"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX + 2,
                        currentPiecePositionY + 1
                )
        ) {
            if (
                    getPiece(currentPiecePositionX + 2, currentPiecePositionY + 1)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXPlus2YPlus1PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXPlus2YPlus1PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXPlus2YPlus1PieceSameColorWithCurrentPiece = true;
        }

        // set "isXMinus2YMinus1PieceSameColorWithCurrentPiece"'s value; "x-2 / y-1"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX - 2,
                        currentPiecePositionY - 1
                )
        ) {
            if (
                    getPiece(currentPiecePositionX - 2, currentPiecePositionY - 1)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXMinus2YMinus1PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXMinus2YMinus1PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXMinus2YMinus1PieceSameColorWithCurrentPiece = true;
        }

        // set "isXMinus2YPlus1PieceSameColorWithCurrentPiece"'s value; "x-2 / y+1"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX - 2,
                        currentPiecePositionY + 1
                )
        ) {
            if (
                    getPiece(currentPiecePositionX - 2, currentPiecePositionY + 1)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXMinus2YPlus1PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXMinus2YPlus1PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXMinus2YPlus1PieceSameColorWithCurrentPiece = true;
        }


        // set "isXMinus2YPlus1PieceSameColorWithCurrentPiece"'s value; "x+1 / y-2"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX + 1,
                        currentPiecePositionY - 2
                )
        ) {
            if (
                    getPiece(currentPiecePositionX + 1, currentPiecePositionY - 2)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXPlus1YMinus2PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXPlus1YMinus2PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXPlus1YMinus2PieceSameColorWithCurrentPiece = true;
        }

        // set "isXPlus1YPlus2PieceSameColorWithCurrentPiece"'s value; "x+1 / y+2"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX + 1,
                        currentPiecePositionY + 2
                )
        ) {
            if (
                    getPiece(currentPiecePositionX + 1, currentPiecePositionY + 2)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXPlus1YPlus2PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXPlus1YPlus2PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXPlus1YPlus2PieceSameColorWithCurrentPiece = true;
        }

        // set "isXMinus1YMinus2PieceSameColorWithCurrentPiece"'s value; "x-1 / y-2"
        if (

                !checkPiecePositionOutOfChess(
                        currentPiecePositionX - 1,
                        currentPiecePositionY - 2
                )
        ) {
            if (
                    getPiece(currentPiecePositionX - 1, currentPiecePositionY - 2)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXMinus1YMinus2PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXMinus1YMinus2PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXMinus1YMinus2PieceSameColorWithCurrentPiece = true;
        }

        // set "isXMinus1YMinus2PieceSameColorWithCurrentPiece"'s value; "x-1 / y+2"
        if (
                !checkPiecePositionOutOfChess(
                        currentPiecePositionX - 1,
                        currentPiecePositionY + 2
                )
        ) {
            if (
                    getPiece(currentPiecePositionX - 1, currentPiecePositionY + 2)
                            .getColor().equals(
                                    currentPiece.getColor()
                            )
            ) {
                // same color;
                isXMinus1YPlus2PieceSameColorWithCurrentPiece = true;

            } else {
                // different color;
                isXMinus1YPlus2PieceSameColorWithCurrentPiece = false;
            }

        } else {
            isXMinus1YPlus2PieceSameColorWithCurrentPiece = true;
        }

        if (
                isXPlus2YMinus1PieceSameColorWithCurrentPiece &&
                        isXPlus2YPlus1PieceSameColorWithCurrentPiece &&
                        isXMinus2YMinus1PieceSameColorWithCurrentPiece &&
                        isXMinus2YPlus1PieceSameColorWithCurrentPiece &&
                        isXPlus1YMinus2PieceSameColorWithCurrentPiece &&
                        isXPlus1YPlus2PieceSameColorWithCurrentPiece &&
                        isXMinus1YMinus2PieceSameColorWithCurrentPiece &&
                        isXMinus1YPlus2PieceSameColorWithCurrentPiece
        ) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean checkPutPiecePositionOnOneDirection(
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY,
            ChessPiece currentPiece
    ) {

        // Queen, Rook, Bishop
        if (currentPiece.getColor().equals("Queen")) {
            if (
                    checkPutPiecePositionOnLeftDirection(
                            currentPiecePositionX,
                            currentPiecePositionY,
                            putPiecePositionX,
                            putPiecePositionY
                    ) ||
                            checkPutPiecePositionOnRightDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnUpDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnDownDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnNorthEastDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnNorthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnSouthEastDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnSouthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            )
            ) {
                return true;
            } else {
                System.out.println("● You can't put this Piece(%s) here !");
                return false;
            }


        } else if (currentPiece.getColor().equals("Rook")) {
            if (
                    checkPutPiecePositionOnLeftDirection(
                            currentPiecePositionX,
                            currentPiecePositionY,
                            putPiecePositionX,
                            putPiecePositionY
                    ) ||
                            checkPutPiecePositionOnRightDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnUpDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnDownDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            )
            ) {
                return true;
            } else {
                System.out.println("● You can't put this Piece(%s) here !");
                return false;
            }


        } else if (currentPiece.getColor().equals("Queen")) {
            if (
                    checkPutPiecePositionOnNorthEastDirection(
                            currentPiecePositionX,
                            currentPiecePositionY,
                            putPiecePositionX,
                            putPiecePositionY
                    ) ||
                            checkPutPiecePositionOnNorthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnSouthEastDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPiecePositionOnSouthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    putPiecePositionX,
                                    putPiecePositionY
                            )
            ) {
                return true;
            } else {
                System.out.println("● You can't put this Piece(%s) here !");
                return false;
            }

        } else {
            System.exit(1); // when currentPiece's color is not a one of Bishop and Queen, Rook;
            return null;
        }
    }

    public Boolean checkPutPiecePositionOnLeftDirection(
            // ←
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isLeftPositionXLessThan0;
        while (true) {
            currentPiecePositionX --;
            isLeftPositionXLessThan0 = currentPiecePositionX < 0;
            if (!isLeftPositionXLessThan0) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isLeftPositionXLessThan0 → true;
                return false;
            }

        }
    }

    public Boolean checkPutPiecePositionOnRightDirection(
            // →
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isRightPositionXMoreThan7;
        while (true) {
            currentPiecePositionX ++;
            isRightPositionXMoreThan7 = currentPiecePositionX > 7;
            if (!isRightPositionXMoreThan7) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isRightPositionXMoreThan7 → true;
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionOnUpDirection(
            // ↑
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isUpPositionYLessThan0;
        while (true) {
            currentPiecePositionY --;
            isUpPositionYLessThan0 = currentPiecePositionY < 0;
            if (!isUpPositionYLessThan0) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isUpPositionYLessThan0 → true;
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionOnDownDirection(
            // ↓
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isDownPositionYMoreThan7;
        while (true) {
            currentPiecePositionY ++;
            isDownPositionYMoreThan7 = currentPiecePositionY > 7;
            if (!isDownPositionYMoreThan7) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isDownPositionYMoreThan7 → true;
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionOnNorthWestDirection(
            // ↖
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isLeftPositionXLessThan0;
        Boolean isUpPositionYMoreThan7;
        while (true) {
            currentPiecePositionX --;
            currentPiecePositionY --;
            isLeftPositionXLessThan0 = currentPiecePositionX < 0;
            isUpPositionYMoreThan7 = currentPiecePositionY > 7;

            if (
                    isLeftPositionXLessThan0 &&
                            isUpPositionYMoreThan7
            ) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isDownPositionYMoreThan7 → true;
                return false;
            }
        }

    }

    public Boolean checkPutPiecePositionOnNorthEastDirection(
            // ↗
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isRightPositionXMoreThan7;
        Boolean isUpPositionYLessThan0;
        while (true) {
            currentPiecePositionX ++;
            currentPiecePositionY --;
            isRightPositionXMoreThan7 = currentPiecePositionX > 7;
            isUpPositionYLessThan0 = currentPiecePositionY < 0;

            if (
                    isRightPositionXMoreThan7 &&
                            isUpPositionYLessThan0
            ) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isDownPositionYMoreThan7 → true;
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionOnSouthWestDirection(
            // ↙
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isLeftPositionLessThan0;
        Boolean isDownPositionMoreThan7;
        while (true) {
            currentPiecePositionX --;
            currentPiecePositionY ++;
            isLeftPositionLessThan0 = currentPiecePositionX < 0;
            isDownPositionMoreThan7 = currentPiecePositionY > 7;

            if (
                    isLeftPositionLessThan0 &&
                            isDownPositionMoreThan7
            ) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isDownPositionYMoreThan7 → true;
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionOnSouthEastDirection(
            // ↘
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isRightPositionMoreThan7;
        Boolean isDownPositionMoreThan7;
        while (true) {
            currentPiecePositionX ++;
            currentPiecePositionY ++;
            isRightPositionMoreThan7 = currentPiecePositionX > 7;
            isDownPositionMoreThan7 = currentPiecePositionY > 7;

            if (
                    isRightPositionMoreThan7 &&
                            isDownPositionMoreThan7
            ) {
                if (
                        getPiece(currentPiecePositionX, currentPiecePositionY)
                                .getColor()
                                .equals(
                                        getPiece(putPiecePositionX, putPiecePositionY)
                                                .getColor()
                                )
                ) {
                    return true;
                } else {
                    // a "getPiece" is not the same as "putPiece";
                    continue;
                }
            } else {
                // isDownPositionYMoreThan7 → true;
                return false;
            }
        }
    }

    public Boolean checkPutPiecePositionForKnight(
            Integer knightPiecePositionX,
            Integer knightPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        if (
                !checkPiecePositionOutOfChess(
                        putPiecePositionX,
                        putPiecePositionY
                ) && !checkPiecePositionOutOfChess(
                        knightPiecePositionX,
                        knightPiecePositionY
                )
        ) {
            // 아군이 있는 경우(X), 체스 보드 판을 넘어선 경우(X);
            if (
                    !checkPutPieceHasSameColorWithCurrentPiece(
                            knightPiecePositionX,
                            knightPiecePositionY,
                            putPiecePositionX,
                            putPiecePositionY
                    )
            ) {
                System.out.println("● There isn't on the same color piece here!");
                return true;
            } else {
                // There's a same color piece here;
                return false;
            }

        } else {
            System.out.println("●  You can't put this piece(%s) here !");
            return false;
        }

    }


    public Boolean checkPiecePositionOutOfChess(
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean putPiecePositionXLessThan0 = false;
        Boolean putPiecePositionXMoreThan7 = false;
        Boolean putPiecePositionYLessThan0 = false;
        Boolean putPiecePositionYMoreThan7 = false;

        if (
                putPiecePositionX < 0
        ) {
            putPiecePositionXLessThan0 = true;
        } else {
            // do nothing
        }
        if (
                putPiecePositionX > 7
        ) {
            putPiecePositionXMoreThan7 = true;
        } else {
            // do nothing;
        }
        if (
                putPiecePositionY < 0
        ) {
            putPiecePositionYLessThan0 = true;
        } else {
            // do nothing;
        }
        if (
                putPiecePositionY > 7
        ) {
            putPiecePositionXMoreThan7 = true;
        } else {
            // do nothing;
        }

        if (
                putPiecePositionXLessThan0 ||
                        putPiecePositionXMoreThan7 ||
                        putPiecePositionYLessThan0 ||
                        putPiecePositionYMoreThan7 // um... why does this variable always have false...??
        ) {
            return true;
        } else {
            return false;
        }
    }


    // ㅅㅂ 이 메서드는 왜 만든거지??????????
    public Boolean checkPutPieceHasSameColorWithCurrentPiece(
            Integer piecePositionX,
            Integer piecePositionX,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        // check whether those are same color?!?!?!;

        if (
                getPiece(piecePositionX, piecePositionY)
                        .getColor()
                        .equals(
                                getPiece(putPiecePositionX, putPiecePositionY)
                                        .getColor()
                        )
        ) {
            return true;
        } else {
            return false;
        }
    }


}