package utils;

import java.util.Scanner;

public class GetInput {

    public String inputPlayer1Name(Scanner scanner) {
           System.out.println("● Enter player(1) name >> ");
           String player1Name = scanner.nextLine();
           return player1Name;
    }

    public String inputPlayer2Name(Scanner scanner) {
        System.out.println("● Enter player(2) name >> ");
        String player2Name = scanner.nextLine();
        return player2Name;
    }

    public String[] inputChessPiecePosition(Scanner scanner) {
        while (true) {
            try {
                String chessPiecePosition = scanner.nextLine();
                if (chessPiecePosition.split("/").length == 2) {
                    return chessPiecePosition.split("/");
                } else {
                    System.out.println("※ You have to enter like this form !!");
                    System.out.println("※ → ex) a/8 ");
                    System.out.println("※ Please try again !");
                }
            } catch (Exception e) {
                System.out.println("※ You have to enter like this form !!");
                System.out.println("※ → ex) a/8 ");
                System.out.println("※ Please try again !");
            }
        }
    }
}

