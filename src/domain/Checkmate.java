package domain;

public class Checkmate {

    public Boolean isCheckmate(
            ChessPiece kingPiece,
            ChessBoard chessBoard
    ) {
        Integer kingPiecePositionX = kingPiece.getCurrentPositionX();
        Integer kingPiecePositionY = kingPiece.getCurrentPositionY();
        String otherPieceColor = null;
        if (kingPiece.getColor().equals("White")) {
            otherPieceColor = "Black";
        } else if (kingPiece.getColor().equals("Black")) {
            otherPieceColor = "White";
        } else {
            System.out.println("에러남 ㅅㅂ:17L"); // 수정하기!!!!!!:
        }

        if (
                isKingCanBeCaptured( // x-1/y-1
                        chessBoard,
                        otherPieceColor,
                        kingPiecePositionX,
                        kingPiecePositionY,
                        - 1,
                        - 1
                ) &&
                        isKingCanBeCaptured( // y-1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                0,
                                - 1
                        ) &&
                        isKingCanBeCaptured( // x+1/y-1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                + 1,
                                - 1
                        ) &&
                        isKingCanBeCaptured( // x-1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                - 1,
                                0
                        ) &&
                        isKingCanBeCaptured( // x+1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                + 1,
                                0
                        ) &&
                        isKingCanBeCaptured( // x-1/y+1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                - 1,
                                + 1
                        ) &&
                        isKingCanBeCaptured( // y+1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                0,
                                + 1
                        ) &&
                        isKingCanBeCaptured( // x+1/y+1
                                chessBoard,
                                otherPieceColor,
                                kingPiecePositionX,
                                kingPiecePositionY,
                                + 1,
                                + 1
                        )
        ) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean isKingCanBeCaptured(
            ChessBoard chessBoard,
            String otherPieceColor,
            Integer kingPiecePositionX,
            Integer kingPiecePositionY,
            Integer xValueKingPieceCanMove,
            Integer yValueKingPieceCanMove
    ) {
        if (
                0 <= kingPiecePositionX + xValueKingPieceCanMove &&
                        7 >= kingPiecePositionX + xValueKingPieceCanMove &&
                        0 <= kingPiecePositionY + yValueKingPieceCanMove &&
                        7 >= kingPiecePositionY + yValueKingPieceCanMove
        ) {
            ChessPiece otherColorPiece = null;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (
                            chessBoard.chessBoard[i][j].getColor().equals(otherPieceColor)
                    ) {
                        otherColorPiece = chessBoard.chessBoard[i][j];
                        if (
                                canOtherPieceCaptureKingPiece(
                                        otherColorPiece.getCurrentPositionX(),
                                        otherColorPiece.getCurrentPositionY(),
                                        kingPiecePositionX + xValueKingPieceCanMove,
                                        kingPiecePositionY + yValueKingPieceCanMove,
                                        otherColorPiece,
                                        chessBoard
                                )
                        ) {
                            return true;
                        } else {
                            continue;
                        }
                    }  else {
                        continue;
                    }
                }
            }
            return false;
        } else {
            return false;
        }

    }

    public Boolean canOtherPieceCaptureKingPiece(
            Integer otherColorPiecePositionX,
            Integer otherColorPiecePositionY,
            Integer putKingPiecePositionX,
            Integer putKingPiecePositionY,
            ChessPiece otherColorPiece,
            ChessBoard chessBoard
    ) {

        switch (otherColorPiece.getPieceType()) {
            case "Bishop":
            case "Queen" :
            case "Rook" :
            case "Pawn" :
                if (
                        chessBoard.checkPutPieceCanBePutOnPutPiecePosition(
                                otherColorPiecePositionX,
                                otherColorPiecePositionY,
                                putKingPiecePositionX,
                                putKingPiecePositionY,
                                otherColorPiece
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "Knight" :
                if (
                        chessBoard.isKnightPieceCanBePutHere(
                                otherColorPiecePositionX,
                                otherColorPiecePositionY,
                                putKingPiecePositionX,
                                putKingPiecePositionY
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

            case "King" :
                if (
                        chessBoard.checkKingPieceCanPutHere(
                                otherColorPiecePositionX,
                                otherColorPiecePositionY,
                                putKingPiecePositionX,
                                putKingPiecePositionY
                        )
                ) {
                    return true;
                } else {
                    return false;
                }

        }
        throw new RuntimeException();
    }

}

