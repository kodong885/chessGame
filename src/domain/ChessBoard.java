package domain;

public class ChessBoard {

    String player1Name = "";
    String player2Name = "";

    // String[][] chessBoard = new String[8][8];
    String[][] chessBoard = {
            {"8)", "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"},
            {"7)", "♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"},
            {"6)", "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭"},
            {"5)", "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭"},
            {"4)", "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭"},
            {"3)", "▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭"},
            {"2)", "♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"},
            {"1)", "♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"},
    };

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public void printChessBoard() {
        System.out.println(String.format("     < %s >", player1Name));
        for (int i = 0; i < 8; i++) {
            String row = "";
            int spaceNum = 0;
            for (int k = 0; k < 17; k++) {
                spaceNum ++;
                if (spaceNum % 2 == 0) {
                    row += " ";
                } else {
                    row += chessBoard[i][k/2];
                }

            }
            System.out.println(row);
        }
        System.out.println("   a  b c  d  e f  g  h");
        System.out.println(String.format("     < %s >", player2Name));
    }

    public String getChessPiece(String chessPiecePositionX, String chessPiecePositionY) {
        Integer chessPieceX;
        Integer chessPieceY;
        switch (chessPiecePositionX) {
            case "a" :
                chessPieceX = 1;
                break;
            case "b" :
                chessPieceX = 2;
                break;
            case "c" :
                chessPieceX = 3;
                break;
            case "d" :
                chessPieceX = 4;
                break;
            case "e" :
                chessPieceX = 5;
                break;
            case "f" :
                chessPieceX = 6;
                break;
            case "g" :
                chessPieceX = 7;
                break;
            case "h" :
                chessPieceX = 8;
                break;
            default:
                chessPieceX = null; // I just left it on purpose to cause an error !
                break;
        }

        switch (chessPiecePositionY) {
            case "1" :
                chessPieceY = 7;
                break;
            case "2" :
                chessPieceY = 6;
                break;
            case "3" :
                chessPieceY = 5;
                break;
            case "4" :
                chessPieceY = 4;
                break;
            case "5" :
                chessPieceY = 3;
                break;
            case "6" :
                chessPieceY = 2;
                break;
            case "7" :
                chessPieceY = 1;
                break;
            case "8" :
                chessPieceY = 0;
                break;
            default:
                chessPieceY = null; // I just left it on purpose to cause an error !
                break;
        }

        String chessPiece =  chessBoard[chessPieceY][chessPieceX];
        return chessPiece;
    }

    public void setChessBoard(String chessPiece, Integer originX, Integer originY, Integer enteredX, Integer enteredY) {
        // originX, originY 는 □로, enteredX, enteredY는 chessPiece로 //

    }


}

// // 🙿▭□◻■☐
/// /    {"🙿", "🙿", "🙿", "🙿", "🙿", "🙿", "🙿", "🙿"},
/// /    {"☐", "☐", "☐", "☐", "☐", "☐", "☐", "☐"},
/// /    {"▭", "▭", "▭", "▭", "▭", "▭", "▭", "▭"},
/// /    {"□", "□", "□", "□", "□", "□", "□", "□"},