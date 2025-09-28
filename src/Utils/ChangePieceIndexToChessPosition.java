package Utils;

public class ChangePieceIndexToChessPosition {

    public String changePieceIndexXToChessPositionX(Integer pieceIndexX) {
        switch (pieceIndexX) {
            case 0 :
                return "a";
            case 1 :
                return "b";
            case 2 :
                return "c";

            case 3 :
                return "d";

            case 4 :
                return "e";

            case 5 :
                return "f";

            case 6 :
                return "g";

            case 7 :
                return "h";
        }
        return "error"; // this return statement will not execute!!;
    }

    public String changePieceIndexYToChessPositionY(Integer pieceIndexY) {

        switch (pieceIndexY) {
            case 0 :
                return "1";

            case 1 :
                return "2";

            case 2 :
                return "3";

            case 3 :
                return "4";

            case 4 :
                return "5";

            case 5 :
                return "6";

            case 6 :
                return "7";

            case 7 :
                return "8";

        }
        throw new RuntimeException(); // this statement will not execute!!;
    }


}
