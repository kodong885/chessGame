package domain;

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
        System.out.println(String.format("   < '%s' > (Black)   ", player1Name));
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
                    ChessPiece chessPiece = chessBoard[i][j/2];
                    switch (chessPiece.pieceType) { // why this statement cover all case !!!!!!!;
                        case "Pawn" :
                            if (chessPiece.getColor().equals("Black")) {
                                chessBoardLine += "♙";
                            } else if (chessPiece.getColor().equals("White")) {
                                chessBoardLine += "♟";
                            } else {
                                System.out.println("Error (ChessBoard.java:173)");
                            }
                            break;
                        case "Rook" :
                            if (chessPiece.getColor().equals("Black")) {
                                chessBoardLine += "♖";
                            } else if (chessPiece.getColor().equals("White")) {
                                chessBoardLine += "♜";
                            } else {
                                System.out.println("Error (ChessBoard.java:182)");
                            }
                            break;
                        case "Queen" :
                            if (chessPiece.getColor().equals("Black")) {
                                chessBoardLine += "♕";
                            } else if (chessPiece.getColor().equals("White")) {
                                chessBoardLine += "♛";
                            } else {
                                System.out.println("Error (ChessBoard.java:191)");
                            }
                            break;
                        case "King" :
                            if (chessPiece.getColor().equals("Black")) {
                                chessBoardLine += "♔";
                            } else if (chessPiece.getColor().equals("White")) {
                                chessBoardLine += "♚";
                            } else {
                                System.out.println("Error (ChessBoard.java:200)");
                            }
                            break;
                        case "Bishop" :
                            if (chessPiece.getColor().equals("Black")) {
                                chessBoardLine += "♗";
                            } else if (chessPiece.getColor().equals("White")) {
                                chessBoardLine += "♝";
                            } else {
                                System.out.println("Error (ChessBoard.java:209)");
                            }
                            break;
                        case "Knight" :
                            if (chessPiece.getColor().equals("Black")) {
                                chessBoardLine += "♘";
                            } else if (chessPiece.getColor().equals("White")) {
                                chessBoardLine += "♞";
                            } else {
                                System.out.println("Error (ChessBoard.java:218)");
                            }
                            break;
                        case "Empty" :
                            chessBoardLine += "▭";
                            break;
                    }
                }
            }
            System.out.println(chessBoardLine);
        }
        System.out.println(String.format("   < '%s' > (White)   ", player2Name));

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
        int currentPiecePositionY = Integer.parseInt(currentPiecePosition[1])-1;
        return chessBoard[currentPiecePositionY][currentPiecePositionX];
    }

    public ChessPiece getPiece(Integer piecePositionX, Integer piecePositionY ) {
        return chessBoard[piecePositionY][piecePositionX];
    }

    public ChessPiece getWhiteKingPiece() {
        ChessPiece whiteKingPiece;

        for (int i = 0; i <  8; i++) {
            for (int j = 0; j < 8; j++) {
                if (
                        chessBoard[i][j]
                                .getPieceType()
                                .equals("King") &&
                                chessBoard[i][j]
                                        .getColor()
                                        .equals("White")
                ) {
                    whiteKingPiece = chessBoard[i][j];
                    return whiteKingPiece;
                } else {
                    continue;
                }
            }
        }
        throw new RuntimeException("ChessBoard.java:298");

    }

    public ChessPiece getBlackKingPiece() {
        ChessPiece blackKingPiece;

        for (int i = 0; i <  8; i++) {
            for (int j = 0; j < 8; j++) {
                if (
                        chessBoard[i][j]
                                .getPieceType()
                                .equals("King") &&
                                chessBoard[i][j]
                                        .getColor()
                                        .equals("Black")
                ) {
                    blackKingPiece = chessBoard[i][j];
                    return blackKingPiece;
                } else {
                    continue;
                }
            }
        }
        throw new RuntimeException("ChessBoard.java:313");
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
            case "King", "Queen":

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


            case "Rook":

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

            case "Knight":

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

            case "Bishop":

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

        }
        System.out.println("ChessBoard.java:711");
        System.exit(1); // this statement never execute because at the switch statement, this method will end!!
        return true;
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

    public Boolean checkPutPieceCanBePutOnPutPiecePosition(
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY,
            ChessPiece currentPiece
    ) {

        // Queen, Rook, Bishop, Pawn
        if (currentPiece.getPieceType().equals("Queen")) {
            if (
                    checkPutPieceCanBePutOnLeftDirection(
                            currentPiecePositionX,
                            currentPiecePositionY,
                            currentPiece.getColor(),
                            putPiecePositionX,
                            putPiecePositionY
                    ) ||
                            checkPutPieceCanBePutOnRightDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnUpDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnDownDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnNorthEastDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnNorthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnSouthEastDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnSouthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            )
            ) {
                return true;
            } else {
                return false;
            }


        } else if (currentPiece.getPieceType().equals("Rook")) {
            if (
                    checkPutPieceCanBePutOnLeftDirection(
                            currentPiecePositionX,
                            currentPiecePositionY,
                            currentPiece.getColor(),
                            putPiecePositionX,
                            putPiecePositionY
                    ) ||
                            checkPutPieceCanBePutOnRightDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnUpDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnDownDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            )
            ) {
                return true;
            } else {
                return false;
            }

        } else if (currentPiece.getPieceType().equals("Bishop")) {
            if (
                    checkPutPieceCanBePutOnNorthEastDirection(
                            currentPiecePositionX,
                            currentPiecePositionY,
                            currentPiece.getColor(),
                            putPiecePositionX,
                            putPiecePositionY
                    ) ||
                            checkPutPieceCanBePutOnNorthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnSouthEastDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            ) ||
                            checkPutPieceCanBePutOnSouthWestDirection(
                                    currentPiecePositionX,
                                    currentPiecePositionY,
                                    currentPiece.getColor(),
                                    putPiecePositionX,
                                    putPiecePositionY
                            )
            ) {
                return true;
            } else {
                return false;
            }

        } else if (currentPiece.getPieceType().equals("Pawn")) {

            if (currentPiece.getColor().equals("White")) {
                if (
                    // When Pawn is located at the line2 or line7;
                    // it can move 2 space;
                        currentPiecePositionY.equals(1)
                                || currentPiecePositionY.equals(6)
                ) {

                    if (
                            currentPiecePositionX.equals(putPiecePositionX)
                    ) {
                        if (
                                currentPiecePositionY - putPiecePositionY <= 2 &&
                                        currentPiecePositionY - putPiecePositionY >= 1 &&
                                        getPiece(
                                                putPiecePositionX,
                                                putPiecePositionY
                                        ).getColor().equals("Empty")
                        ) {
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        // !currentPiecePositionX.equals(putPiecePositionX)
                        if (
                                (
                                        (
                                                putPiecePositionX.equals(currentPiecePositionX + 1) &&
                                                        putPiecePositionY.equals(currentPiecePositionY - 1)
                                        ) &&
                                                (
                                                        getPiece(
                                                                currentPiecePositionX + 1,
                                                                currentPiecePositionY - 1
                                                        ).getColor().equals("Black")
                                                )
                                ) ||
                                        (
                                                (
                                                        putPiecePositionX.equals(currentPiecePositionX - 1) &&
                                                                putPiecePositionY.equals(currentPiecePositionY - 1)
                                                ) &&
                                                        (
                                                                getPiece(
                                                                        currentPiecePositionX - 1,
                                                                        currentPiecePositionY - 1
                                                                ).getColor().equals("Black")
                                                        )
                                        )
                        ) {
                            return true;
                        } else {
                            return false;
                        }
                    }

                } else {
                    // when Pawn is located at some line except line2 or line7;
                    // it can move 1 space;
                    if (
                            currentPiecePositionX.equals(putPiecePositionX)
                    ) {
                        if (
                                currentPiecePositionY - putPiecePositionY == 1 &&
                                        getPiece(
                                                putPiecePositionX,
                                                putPiecePositionY
                                        ).getColor().equals("Empty")
                        ) {
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        // !currentPiecePositionX.equals(putPiecePositionX)
                        if (
                                (
                                        (
                                                putPiecePositionX.equals(currentPiecePositionX + 1) &&
                                                        putPiecePositionY.equals(currentPiecePositionY - 1)
                                        ) &&
                                                (
                                                        getPiece(
                                                                currentPiecePositionX + 1,
                                                                currentPiecePositionY - 1
                                                        ).getColor().equals("Black")
                                                )
                                ) ||
                                        (
                                                (
                                                        putPiecePositionX.equals(currentPiecePositionX - 1) &&
                                                                putPiecePositionY.equals(currentPiecePositionY - 1)
                                                ) &&
                                                        (
                                                                getPiece(
                                                                        currentPiecePositionX - 1,
                                                                        currentPiecePositionY - 1
                                                                ).getColor().equals("Black")
                                                        )
                                        )
                        ) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }

            } else if (currentPiece.getColor().equals("Black")) {
                if (
                    // When Pawn is located at the line2 or line7;
                    // it can move 2 space;
                        currentPiecePositionY.equals(1)
                                || currentPiecePositionY.equals(6)
                ) {

                    if (
                            currentPiecePositionX.equals(putPiecePositionX)
                    ) {
                        if (
                                putPiecePositionY - currentPiecePositionY <= 2  &&
                                        putPiecePositionY - currentPiecePositionY >= 1 &&
                                        getPiece(
                                                putPiecePositionX,
                                                putPiecePositionY
                                        ).getColor().equals("Empty")
                        ) {
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        // !currentPiece.getCurrentPositionX().equals(putPiecePositionX)
                        if (
                                (
                                        (
                                                putPiecePositionX.equals(currentPiecePositionX + 1) &&
                                                        putPiecePositionY.equals(currentPiecePositionY + 1)
                                        ) &&
                                                (
                                                        getPiece(
                                                                currentPiecePositionX + 1,
                                                                currentPiecePositionY - 1
                                                        ).getColor().equals("White")
                                                )
                                ) ||
                                        (
                                                (
                                                        putPiecePositionX.equals(currentPiecePositionX - 1) &&
                                                                putPiecePositionY.equals(currentPiecePositionY + 1)
                                                ) &&
                                                        (
                                                                getPiece(
                                                                        currentPiecePositionX - 1,
                                                                        currentPiecePositionY - 1
                                                                ).getColor().equals("White")
                                                        )
                                        )
                        ) {
                            return true;
                        } else {
                            return false;
                        }
                    }

                } else {
                    // when Pawn is located at some line except line2 or line7;
                    // it can move 1 space;
                    if (
                            currentPiecePositionX.equals(putPiecePositionX)
                    ) {
                        if (
                                putPiecePositionY - currentPiecePositionY == 1 &&
                                        getPiece(
                                                putPiecePositionX,
                                                putPiecePositionY
                                        ).getColor().equals("Empty")
                        ) {
                            return true;
                        } else {
                            return false;
                        }

                    } else {
                        // !currentPiecePositionX.equals(putPiecePositionX)
                        if (
                                (
                                        (
                                                putPiecePositionX.equals(currentPiecePositionX + 1) &&
                                                        putPiecePositionY.equals(currentPiecePositionY + 1)
                                        ) &&
                                                (
                                                        getPiece(
                                                                currentPiecePositionX + 1,
                                                                currentPiecePositionY + 1
                                                        ).getColor().equals("White")
                                                )
                                ) ||
                                        (
                                                (
                                                        putPiecePositionX.equals(currentPiecePositionX - 1) &&
                                                                putPiecePositionY.equals(currentPiecePositionY + 1)
                                                ) &&
                                                        (
                                                                getPiece(
                                                                        currentPiecePositionX - 1,
                                                                        currentPiecePositionY + 1
                                                                ).getColor().equals("White")
                                                        )
                                        )
                        ) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }

            } else {
                // This means this piece's color is "Empty", but this will never happen!
                throw new RuntimeException();
            }

        } else {
            System.out.println("ChessBoard.java:1418");
            System.exit(1); // when currentPiece's type is not a one of "Bishop" and "Queen, "Rook";
            return null;
        }

    }

    public Boolean checkPutPieceCanBePutOnLeftDirection(
            // ←
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnLeftDirection = false;
        Boolean isLeftPositionXLessThan0;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionX --;
            isLeftPositionXLessThan0 = piecePositionX < 0;
            if (
                    !isLeftPositionXLessThan0 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnLeftDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnLeftDirection;
    }

    public Boolean checkPutPieceCanBePutOnRightDirection(
            // →
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnRightDirection = false;
        Boolean isRightPositionXMoreThan7;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionX ++;
            isRightPositionXMoreThan7 = piecePositionX > 7;
            if (
                    !isRightPositionXMoreThan7 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnRightDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnRightDirection;
    }

    public Boolean checkPutPieceCanBePutOnUpDirection(
            // ↑
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnUpDirection = false;
        Boolean isUpPositionYLessThan0;
        Integer piecePositionX = currentPiecePositionX; // ???????????;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionY --;
            isUpPositionYLessThan0 = piecePositionY < 0;
            if (
                    !isUpPositionYLessThan0 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnUpDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnUpDirection;
    }

    public Boolean checkPutPieceCanBePutOnDownDirection(
            // ↓
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnDownDirection = false;
        Boolean isDownPositionYMoreThan7;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionY ++;
            isDownPositionYMoreThan7 = piecePositionY > 7;
            if (
                    !isDownPositionYMoreThan7 &&
                    !currentPieceColor.equals(
                            getPiece(piecePositionX, piecePositionY)
                                    .getColor()
                    )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnDownDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnDownDirection;
    }

    public Boolean checkPutPieceCanBePutOnNorthWestDirection(
            // ↖
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnNorthWestDirection = false;
        Boolean isLeftPositionXLessThan0;
        Boolean isUpPositionYLessThan0;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionX --;
            piecePositionY --;
            isLeftPositionXLessThan0 = piecePositionX < 0;
            isUpPositionYLessThan0 = piecePositionY < 0;

            if (
                    !isLeftPositionXLessThan0 &&
                            !isUpPositionYLessThan0 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnNorthWestDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnNorthWestDirection;

    }

    public Boolean checkPutPieceCanBePutOnNorthEastDirection(
            // ↗
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnNorthEastDirection = false;
        Boolean isRightPositionXMoreThan7;
        Boolean isUpPositionYLessThan0;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionX ++;
            piecePositionY --;
            isRightPositionXMoreThan7 = piecePositionX > 7;
            isUpPositionYLessThan0 = piecePositionY < 0;

            if (
                    !isRightPositionXMoreThan7 &&
                            !isUpPositionYLessThan0 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnNorthEastDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnNorthEastDirection;
    }

    public Boolean checkPutPieceCanBePutOnSouthWestDirection(
            // ↙
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnSouthWestDirection = false;
        Boolean isLeftPositionLessThan0;
        Boolean isDownPositionMoreThan7;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionX --;
            piecePositionY ++;
            isLeftPositionLessThan0 = piecePositionX < 0;
            isDownPositionMoreThan7 = piecePositionY > 7;

            if (
                    !isLeftPositionLessThan0 &&
                            !isDownPositionMoreThan7 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnSouthWestDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnSouthWestDirection;
    }

    public Boolean checkPutPieceCanBePutOnSouthEastDirection(
            // ↘
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            String currentPieceColor,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        Boolean isPutPieceCanBePutOnSouthEastDirection = false;
        Boolean isRightPositionMoreThan7;
        Boolean isDownPositionMoreThan7;
        Integer piecePositionX = currentPiecePositionX;
        Integer piecePositionY = currentPiecePositionY;
        while (true) {
            piecePositionX ++;
            piecePositionY ++;
            isRightPositionMoreThan7 = piecePositionX > 7;
            isDownPositionMoreThan7 = piecePositionY > 7;

            if (
                    !isRightPositionMoreThan7 &&
                            !isDownPositionMoreThan7 &&
                            !currentPieceColor.equals(
                                    getPiece(piecePositionX, piecePositionY)
                                            .getColor()
                            )
            ) {
                if (
                        !currentPieceColor.equals(
                                getPiece(putPiecePositionX, putPiecePositionY).getColor()
                        ) &&
                                piecePositionX.equals(putPiecePositionX) &&
                                piecePositionY.equals(putPiecePositionY)
                ) {
                    isPutPieceCanBePutOnSouthEastDirection = true;
                } else {

                }
            } else {
                break;
            }
        }
        return isPutPieceCanBePutOnSouthEastDirection;
    }


    public Boolean isKnightPieceCanBePutHere(
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        if (
            // 체스 보드 판을 넘어서지 않은 경우 &&
            // a position where a knight is to be able to put &&
            // putPiece color is different with currentKnight color
                !checkPiecePositionOutOfChess(
                        putPiecePositionX,
                        putPiecePositionY
                ) &&
                        isKnightPieceAvailablePosition(
                                currentPiecePositionX,
                                currentPiecePositionY,
                                putPiecePositionX,
                                putPiecePositionY
                        ) &&
                        !checkPutPieceHasSameColorWithCurrentKnight(
                                currentPiecePositionX,
                                currentPiecePositionY,
                                putPiecePositionX,
                                putPiecePositionY
                        )
        ) {
            return true;
        } else {
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
            putPiecePositionYMoreThan7 = true;
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

    public Boolean checkPutPieceHasSameColorWithCurrentKnight(
            Integer currentPiecePositionX,
            Integer currentPiecePositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
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
            return false;
        }
    }

    public Boolean isKnightPieceAvailablePosition(
            Integer currentKnightPositionX,
            Integer currentKnightPositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        if (
                (
                        currentKnightPositionX + 2 == putPiecePositionX &&
                                currentKnightPositionY - 1 == putPiecePositionY
                        ) ||
                        (
                                currentKnightPositionX + 2 == putPiecePositionX &&
                                        currentKnightPositionY + 1 == putPiecePositionY
                                ) ||
                        (
                                currentKnightPositionX - 2 == putPiecePositionX &&
                                        currentKnightPositionY - 1 == putPiecePositionY
                                ) ||
                        (
                                currentKnightPositionX - 2 == putPiecePositionX &&
                                        currentKnightPositionY + 1 == putPiecePositionY
                                ) ||
                        (
                                currentKnightPositionX + 1 == putPiecePositionX &&
                                        currentKnightPositionY - 2 == putPiecePositionY
                                ) ||
                        (
                                currentKnightPositionX + 1 == putPiecePositionX &&
                                        currentKnightPositionY + 2 == putPiecePositionY
                                ) ||
                        (
                                currentKnightPositionX - 1 == putPiecePositionX &&
                                        currentKnightPositionY - 2 == putPiecePositionY
                                ) ||
                        (
                                currentKnightPositionX - 1 == putPiecePositionX &&
                                        currentKnightPositionY + 2 == putPiecePositionY
                                )
        ) {
            return true;
        } else {
            return false;
        }


    }

    public Boolean checkKingPieceCanPutHere(

            Integer currentKingPositionX,
            Integer currentKingPositionY,
            Integer putPiecePositionX,
            Integer putPiecePositionY
    ) {
        // 놓는 위치(putPosition)에 same color piece가 위치하는지 판변하는 로직만 짬 ( king이 못놓는 위치인지는 확인 안 함.. )
        String putPieceColor = getPiece(
                putPiecePositionX, putPiecePositionY
                ).getColor();

        Boolean isXMinus1YMinus1PositionAvailable = false;
        Boolean isYMinus1PositionAvailable = false;
        Boolean isXPlus1YMinus1PositionAvailable = false;
        Boolean isXMinus1PositionAvailable = false;
        Boolean isXPlus1PositionAvailable = false;
        Boolean isXMinus1YPlus1PositionAvailable = false;
        Boolean isYPlus1PositionAvailable = false;
        Boolean isXPlus1YPlus1PositionAvailable = false;

        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX - 1,
                        currentKingPositionY - 1
                ) &&    // 안 && 다color → true;
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX - 1,
                                        currentKingPositionY - 1
                                ).getColor()
                        )
        ) {
            isXMinus1YMinus1PositionAvailable = true;
        } else {
            isXMinus1YMinus1PositionAvailable = false;
        }

        // y-1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX,
                        currentKingPositionY - 1
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX,
                                        currentKingPositionY - 1
                                ).getColor()
                        )
        ) {
            isYMinus1PositionAvailable = true;
        } else {
            isYMinus1PositionAvailable = false;
        }

        // x+1 / y-1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX + 1,
                        currentKingPositionY - 1
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX + 1,
                                        currentKingPositionY - 1
                                ).getColor()
                        )
        ) {
            isXPlus1YMinus1PositionAvailable = true;
        } else {
            isXPlus1YMinus1PositionAvailable = false;
        }

        // x-1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX + 1,
                        currentKingPositionY - 1
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX - 1,
                                        currentKingPositionY
                                ).getColor()
                        )
        ) {
            isXMinus1PositionAvailable = true;
        } else {
            isXMinus1PositionAvailable = false;
        }

        // x+1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX + 1,
                        currentKingPositionY
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX + 1,
                                        currentKingPositionY
                                ).getColor()
                        )
        ) {
            isXPlus1PositionAvailable = true;
        } else {
            isXPlus1PositionAvailable = false;
        }

        // x-1 / y+1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX - 1,
                        currentKingPositionY + 1
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX - 1,
                                        currentKingPositionY + 1
                                ).getColor()
                        )
        ) {
            isXMinus1YPlus1PositionAvailable = true;
        } else {
            isXMinus1YPlus1PositionAvailable = false;
        }

        // y+1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX,
                        currentKingPositionY + 1
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX,
                                        currentKingPositionY + 1
                                ).getColor()
                        )
        ) {
            isYPlus1PositionAvailable = true;
        } else {
            isYPlus1PositionAvailable = false;
        }

        // x+1 / y+1
        if (
                !checkPiecePositionOutOfChess(
                        currentKingPositionX + 1,
                        currentKingPositionY + 1
                ) &&
                        !putPieceColor.equals(
                                getPiece(
                                        currentKingPositionX + 1,
                                        currentKingPositionY + 1
                                ).getColor()
                        )
        ) {
            isXPlus1YPlus1PositionAvailable = true;
        } else {
            isXPlus1YPlus1PositionAvailable = false;
        }


        if (
                isXMinus1YMinus1PositionAvailable ||
                        isYMinus1PositionAvailable ||
                        isXPlus1YMinus1PositionAvailable ||
                        isXMinus1PositionAvailable ||
                        isXPlus1PositionAvailable ||
                        isXMinus1YPlus1PositionAvailable ||
                        isYPlus1PositionAvailable ||
                        isXPlus1YPlus1PositionAvailable
        ) {
            return true;
        } else {
            return false;
        }

    }
}
