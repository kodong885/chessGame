package Utils;

import java.util.Scanner;

public class GetUserInput {
    public String inputUserName(Scanner scanner, int userTure) {
        System.out.println(String.format("userName%d's name >>", userTure));
        return scanner.nextLine();
    }

    public String[] selectCurrentPiece(Scanner scanner) {
        // "a/7" 이런 형식으로 입력 받아야함!!!
        while (true) {
            System.out.println(">>");
            String[] currentPiece = scanner.nextLine().split("/");

            if (
                    currentPiece.length == 2 &&
                            1 <= Integer.parseInt(currentPiece[1]) &&
                            8 >= Integer.parseInt(currentPiece[1]) &&
                            isInputPiecePositionIndex0RightRange(currentPiece[0])
            ) {
                return currentPiece;
            } else {
                System.out.println("● 잘못 입력함 ㅋ 다시 입력하시오~");
                System.out.println("● Please try again !");
            }

        }
    }

    public String[] enterPutPiecePosition(Scanner scanner) {
        while (true) {
            System.out.println(">>");
            String[] currentPiece = scanner.nextLine().split("/");
            if (
                    currentPiece.length == 2 &&
                            1 <= Integer.parseInt(currentPiece[1]) &&
                            8 >= Integer.parseInt(currentPiece[1]) &&
                            isInputPiecePositionIndex0RightRange(currentPiece[0])
            ) {
                return currentPiece;
            } else {
                System.out.println("● 잘못 입력함 ㅋ 다시 입력하시오~");
                System.out.println("● Please try again !");
            }
        }
    }

    public Boolean isInputPiecePositionIndex0RightRange(String piecePositionStringIndex0) {
        if (
                piecePositionStringIndex0.equals("a") ||
                        piecePositionStringIndex0.equals("b") ||
                        piecePositionStringIndex0.equals("c") ||
                        piecePositionStringIndex0.equals("d") ||
                        piecePositionStringIndex0.equals("e") ||
                        piecePositionStringIndex0.equals("f") ||
                        piecePositionStringIndex0.equals("g") ||
                        piecePositionStringIndex0.equals("h")
        ) {
            return true;
        } else {
            return false;
        }


    }

}
