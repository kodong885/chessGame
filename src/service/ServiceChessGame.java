package service;

import domain.ChessBoard;
import domain.ChessPiece;

public class ServiceChessGame {

    public Boolean checkCurrentPieceCanMove(ChessBoard chessBoard, ChessPiece currentChessPiece) {
        Integer currentChessPieceX = currentChessPiece.getCurrentPositionX(); // if I use this value again, I should declare out of switch statement;
        Integer currentChessPieceY = currentChessPiece.getCurrentPositionY();

        switch (currentChessPiece.getPieceType()) {

            case "Pawn" :
                // 앞에 piece가 있을 때
                // 1. 아군 piece
                // 2. 적군 piece
                // 대각선 공격 가능 → true;
                if (currentChessPiece.getColor().equals("Black")) {
                    if (chessBoard.
                            getPiece(currentChessPieceX, currentChessPieceY + 1)
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
                break;

            case "King" :
                // king 주변 space가 모두 공격 가능 지역일 경우


                break;

            case "Queen" :
                // 1. 적군 piece 제한 없음!
                // 2. 아군 piece가 주변 space를 모두 둘어싸고 있을 때
                if (
                        // 아군 piece가 주변 space를 모두 둘어싸고 있을 때
                        // 가로/세로
                        chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX + 1,
                                currentChessPieceY,
                                currentChessPiece
                        ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX,
                                        currentChessPieceY + 1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                ) && // 대각선
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX + 1,
                                        currentChessPieceY + 1,
                                                    currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX + 1,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY + 1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                )
                ) {
                    return false;
                } else {
                    return true;
                }
                break;

            case "Rook" :
                // 적군 piece 제한 X
                // Rook을 기준으로 가로 세로 모두 아군Piece가 둘어싸고 있을 때
                if (
                    // Rook을 기준으로 가로/세로 모두 아군Piece가 둘어싸고 있을 때
                        chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX + 1,
                                currentChessPieceY,
                                currentChessPiece
                        ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX,
                                        currentChessPieceY + 1,
                                   currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                )

                ) {
                    return false;
                } else {
                    return true;
                }
                break;

            case "Knight" :
                // 적군 piece 제한 X
                // Knight가 이동할 수 있는 지역에 모두 아군Piece가 둘러싸고 있을 때
                // I'll fill this part!!!
                if (
                        chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX + 2,
                                currentChessPieceY + 1,
                                currentChessPiece
                        ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX + 2,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 2,
                                        currentChessPieceY +1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 2,
                                        currentChessPieceY + 1,
                                        currentChessPiece
                                ) && // 대각선
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX + 1,
                                        currentChessPieceY + 2,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX + 1,
                                        currentChessPieceY - 2,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY + 2,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY - 2,
                                        currentChessPiece
                                )
                ) {
                    return false;
                } else {
                    return true;
                }
                break;

            case "Bishop" :
                // 적군 piece제한 X
                // Bishop이 이동할 수 있는 지역에 모두 아군Piece가 둘러싸고 있을 때
                if (
                        chessBoard.checkPieceAreSurroundedWithSameColor(
                                currentChessPieceX + 1,
                                currentChessPieceY + 1,
                                currentChessPiece
                        ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX + 1,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY + 1,
                                        currentChessPiece
                                ) &&
                                chessBoard.checkPieceAreSurroundedWithSameColor(
                                        currentChessPieceX - 1,
                                        currentChessPieceY - 1,
                                        currentChessPiece
                                )
                ) {
                    return false;
                } else {
                    return true;
                }
                break;
        }
    }

    public Boolean checkPutPieceCanMoveHere(String[] putPiecePosition,
                                            ChessPiece currentPiece,
                                            ChessBoard chessBoard
    ) {
        Integer putPiecePositionX = 100; // i set like this on purpose;
        Integer putPiecePositionY = Integer.valueOf(putPiecePosition[1]);
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
                // Pawn이 갈 수 없는 position일 경우 → false
                // Pawn이 갈 수 있는 position이지만, 아군 piece가 있는 경우
                // ( line2, line7 에서는 두 칸 이동 가능 )
                if (currentPiece.getColor().equals("White")) {
                    if (
                            // When Pawn is located at the line2 or line7;
                            // it can move 2 space;
                            currentPiece.getCurrentPositionY().equals(1)
                            || currentPiece.getCurrentPositionY().equals(6)
                    ) {
                        if (
                            // ★ A case where a pawn moves more than 2 squares forward from its current position.
                                currentPiece.getCurrentPositionY() - putPiecePositionY > 2
                        ) {
                            System.out.println("● Pawn moves more than 2 squares forward from it's current position !");
                            System.out.println("● Please try again !");
                            return false;
                        } else if (
                            // 1,2 칸 중, 입력한 position에 해당하는 piece의 color가 current piece와 같은지.
                                chessBoard.getPiece(putPiecePositionX, putPiecePositionY)
                                        .getColor().equals(currentPiece.getColor())
                        ) {
                            System.out.println("White is located here too!");
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        // when Pawn is located at some line except line2 or line7;
                        // it can move 1 space;
                        if (
                                currentPiece.getCurrentPositionY() - putPiecePositionY > 1
                        ) {
                            System.out.println("● Pawn moves more than 1 squares forward from it's current position !");
                            System.out.println("● Please try again !");
                            return false;
                        } else if (
                                chessBoard.getPiece(putPiecePositionX, putPiecePositionY)
                                        .getColor().equals(currentPiece.getColor())
                        ) {
                            System.out.println("● Pawn is already located here !");
                            return false;
                        } else {
                            return true;
                        }
                    }

                } else if (currentPiece.getColor().equals("Black")) {
                    if (
                        // When Pawn is located at the line2 or line7;
                        // it can move 2 space;
                            currentPiece.getCurrentPositionY().equals(1)
                                    || currentPiece.getCurrentPositionY().equals(6)
                    ) {
                        if (
                            // ★ A case where a pawn moves more than 2 squares forward from its current position.
                                putPiecePositionY - currentPiece.getCurrentPositionY() > 2
                        ) {
                            System.out.println("● Pawn moves more than 2 squares forward from it's current position !");
                            System.out.println("● Please try again !");
                            return false;
                        } else if (
                            // 1,2 칸 중, 입력한 position에 해당하는 piece의 color가 current piece와 같은지.
                                chessBoard.getPiece(putPiecePositionX, putPiecePositionY)
                                        .getColor().equals(currentPiece.getColor())
                        ) {
                            System.out.println("White is located here too!");
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        // when Pawn is located at some line except line2 or line7;
                        // it can move 1 space;
                        if (
                                putPiecePositionY - currentPiece.getCurrentPositionY() > 1
                        ) {
                            System.out.println("● Pawn moves more than 1 squares forward from it's current position !");
                            System.out.println("● Please try again !");
                            return false;
                        } else if (
                                chessBoard.getPiece(putPiecePositionX, putPiecePositionY)
                                        .getColor().equals(currentPiece.getColor())
                        ) {
                            System.out.println("● Pawn is already located here !");
                            return false;
                        } else {
                            return true;
                        }
                    }

                } else {
                    // This means this piece's color is "Empty", but this will never happen!
                    System.exit(1);
                }
                break;

            case "King" :
                // King이 갈 수 없는 position일 경우 → false
                // King이 갈 수 있는 position이지만, 아군 piece가 있는 경우
                // + 해당 position으로 이동하면 capture 당할 수 있음 (false)
                break;

            case "Queen" :
                // Queen이 갈 수 없는 position일 경우 → false
                // Queen이 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                
                break;

            case "Rook" :
                // Rook이 갈 수 없는 position일 경우 → false
                // Rook이 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                break;

            case "Knight" :
                // Knight가 갈 수 없는 position일 경우 → false
                // Knight가 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                break;

            case "Bishop" :
                // Bishop이 갈 수 없는 position일 경우 → false
                // Bishop이 갈 수 있는 position이지만, 아군 piece가 있는 경우 (false)
                break;
        }

    }


    public void attack(ChessPiece currentPiece, String[] putPiecePosition) {
        // ...
    }

}
