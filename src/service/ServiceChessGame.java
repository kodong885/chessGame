package service;

import domain.ChessBoard;

public class ServiceChessGame {

    public void attack(
            String currentPieceX,
            String currentPieceY,
            String putPieceX,
            String putPieceY
    ) {
        // currentPieceX, currentPieceY 로 체스 선택 --> 어떤 종류 체스인지 식별
        // 해당 종류 체스에 따라서
        // 공격 옵션 보여주고,
        // putPieceX, putPieceY 로 이동!
    }

    public void showWherePieceMove(String[] currentPiecePosition, ChessBoard chessBoard) {
        String currentPieceX = currentPiecePosition[0];
        String currentPieceY = currentPiecePosition[1];

        String chessPiece = chessBoard.getChessPiece(currentPieceX, currentPieceY); // select chess piece and ...???
        switch (chessPiece) {
            case "♝" :
                break;
            case "♜" :
                break;
            case "♞" :
                break;
            case "♛" :
                break;
            case "♚" :
                break;
            case "♟" :
                break;
            default:
                throw new Exception("Invalid chess piece"); // 예외처리...!!!
                break;
        }
    }

    public void attack(String[] putPiecePosition, String[] currentPiecePosition, ChessBoard chessBoard) {

    }

}


