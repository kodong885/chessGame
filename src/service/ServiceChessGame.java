package service;

import domain.Checkmate;
import domain.ChessBoard;
import domain.ChessPiece;

public class ServiceChessGame {

    public Boolean checkCurrentPieceCanMove(ChessBoard chessBoard, ChessPiece currentChessPiece) {
        Integer currentChessPieceX = currentChessPiece.getCurrentPositionX(); // if I use this value again, I should declare out of switch statement;
        Integer currentChessPieceY = currentChessPiece.getCurrentPositionY();

        switch (currentChessPiece.getPieceType()) {

            case "Pawn" :

                if (currentChessPiece.getColor().equals("Black")) {
                    if (
                            chessBoard.getPiece(currentChessPieceX, currentChessPieceY + 1)
                            .getColor()
                            .equals("Empty")
                    ) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    // pieceColor == "White";
                    if (chessBoard.
                            getPiece(currentChessPieceX, currentChessPieceY - 1).
                            getColor().
                            equals("Empty")
                    ) {
                        return true;
                    } else {
                        return false;
                    }
                }

            case "King" :
                // king 주변 square에 같은 color piece가 쌓여있을때 → false;
                // 그 외의 경우 → true;
                if (
                        !chessBoard.checkPieceAreSurroundedWithSameColor(
                            currentChessPieceX,
                            currentChessPieceY,
                            currentChessPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }


            case "Queen" :
                // 1. 적군 piece 제한 없음!
                // 2. 아군 piece가 주변 space를 모두 둘어싸고 있을 때
                if (
                        !chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX,
                                currentChessPieceY,
                                currentChessPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "Rook" :
                // 적군 piece 제한 X
                // Rook을 기준으로 가로 세로 모두 아군Piece가 둘어싸고 있을 때
                if (
                        !chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX,
                                currentChessPieceY,
                                currentChessPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "Knight" :
                // 적군 piece 제한 X
                // Knight가 이동할 수 있는 지역에 모두 아군Piece가 둘러싸고 있을 때
                // I'll fill this part!!!

                if (
                        !chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX,
                                currentChessPieceY,
                                currentChessPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "Bishop" :
                // 적군 piece제한 X
                // Bishop이 이동할 수 있는 지역에 모두 아군Piece가 둘러싸고 있을 때

                if (
                        !chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX,
                                currentChessPieceY,
                                currentChessPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

        }

        System.exit(1); // This statement never execute because this method will end in this switch statement
        return false;
    }


    public Boolean checkPutPieceCanMoveHere(String[] putPiecePosition,
                                            ChessPiece currentPiece,
                                            ChessBoard chessBoard
    ) {
        Integer putPiecePositionX = 100; // I set like this on purpose;
        Integer putPiecePositionY = Integer.valueOf(putPiecePosition[1]) - 1;
        switch (putPiecePosition[0]) {
            case "a" :
                putPiecePositionX = 0;
                break;

            case "b" :
                putPiecePositionX = 1;
                break;

            case "c" :
                putPiecePositionX = 2;
                break;

            case "d" :
                putPiecePositionX = 3;
                break;

            case "e" :
                putPiecePositionX = 4;
                break;

            case "f" :
                putPiecePositionX = 5;
                break;

            case "g" :
                putPiecePositionX = 6;
                break;

            case "h" :
                putPiecePositionX = 7;
                break;
        }

        switch (currentPiece.getPieceType()) {

            case "Pawn" :
                if (
                        chessBoard.checkPutPieceCanBePutOnPutPiecePosition(
                                currentPiece.getCurrentPositionX(),
                                currentPiece.getCurrentPositionY(),
                                putPiecePositionX,
                                putPiecePositionY,
                                currentPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "Queen" :
                // Queen이 갈 수 없는 position일 경우 → false
                // Queen이 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                // ★★★★ queen은 어떻게 해야하지....??? !!!!!!
                // ---------
                // 가로 / 세로 / 왼쪽 / 오른쪽 / 대각선(4방향) 방향 square에
                // putPiecePosition이 위치(or 연산자 사용) → true;
                if (
                        chessBoard.checkPutPieceCanBePutOnPutPiecePosition(
                                currentPiece.getCurrentPositionX(),
                                currentPiece.getCurrentPositionY(),
                                putPiecePositionX,
                                putPiecePositionY,
                                currentPiece
                        )
                ) {
                    // User can put piece here!
                    return true;
                } else {
                    return false;
                }

            case "Rook" :
                // Rook이 갈 수 없는 position일 경우 → false
                // Rook이 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                if (
                        chessBoard.checkPutPieceCanBePutOnPutPiecePosition(
                                currentPiece.getCurrentPositionX(),
                                currentPiece.getCurrentPositionY(),
                                putPiecePositionX,
                                putPiecePositionY,
                                currentPiece
                        )
                ) {
                    // User can put piece here!
                    return true;
                } else {
                    return false;
                }

            case "Bishop" :
                // Bishop이 갈 수 없는 position일 경우 → false
                // Bishop이 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                if (
                        chessBoard.checkPutPieceCanBePutOnPutPiecePosition(
                                currentPiece.getCurrentPositionX(),
                                currentPiece.getCurrentPositionY(),
                                putPiecePositionX,
                                putPiecePositionY,
                                currentPiece
                        )
                ) {
                    //
                    // User can put piece here!
                    return true;
                } else {
                    return false;
                }

            case "Knight" :
                // Knight가 갈 수 없는 position일 경우 → false
                // Knight가 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                if (
                        chessBoard.isKnightPieceCanBePutHere(
                                currentPiece.getCurrentPositionX(),
                                currentPiece.getCurrentPositionY(),
                                putPiecePositionX,
                                putPiecePositionY
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "King" :
                // ( 다른 color piece가 공격 가능한 범위랑
                // putKing 위치가 한 개라도 같은 경우 → false )
                if (
                        chessBoard.checkKingPieceCanPutHere(
                                currentPiece.getCurrentPositionX(),
                                currentPiece.getCurrentPositionY(),
                                putPiecePositionX,
                                putPiecePositionY
                        )
                ) {
                    return true;
                } else {
                    return false;
                }
        }
        System.exit(1); // This statement never execute because this method will end in this switch statement
        return false;
    }

    public void attack(ChessPiece currentPiece, String[] putPiecePosition, ChessBoard chessBoard) {

        String currentPieceType = currentPiece.getPieceType();
        String currentPieceColor = currentPiece.getColor();

        currentPiece.setPieceType("Empty");
        currentPiece.setColor("Empty");

        Integer putPiecePositionX = 100; // I set this value to occur error in purpose;
        switch (putPiecePosition[0]) {
            case "a" :
                putPiecePositionX = 0;
                break;
            case "b" :
                putPiecePositionX = 1;
                break;
            case "c" :
                putPiecePositionX = 2;
                break;
            case "d" :
                putPiecePositionX = 3;
                break;
            case "e" :
                putPiecePositionX = 4;
                break;
            case "f" :
                putPiecePositionX = 5;
                break;
            case "g" :
                putPiecePositionX = 6;
                break;
            case "h" :
                putPiecePositionX = 7;
                break;
        }
        Integer putPiecePositionY = Integer.valueOf(putPiecePosition[1])-1;

        ChessPiece putPiece = chessBoard.getPiece(putPiecePositionX, putPiecePositionY);
        putPiece.setColor(currentPieceColor);
        putPiece.setPieceType(currentPieceType);

    }

    public Boolean isCheckMate(
            ChessBoard chessBoard,
            Checkmate checkmate,
            String attackUser
    ) {

        if (attackUser.equals("White")) {
            ChessPiece blackKingPiece = chessBoard.getBlackKingPiece();
            if (checkmate.isCheckmate(blackKingPiece, chessBoard)) {
                return true;
            } else {
                return false;
            }
        } else {
            // attackUser.equals("Black")
            ChessPiece whiteKingPiece = chessBoard.getWhiteKingPiece();
            if (checkmate.isCheckmate(whiteKingPiece, chessBoard)) {
                return true;
            } else {
                return false;
            }
        }
    }

}

