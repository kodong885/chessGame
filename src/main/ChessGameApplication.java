package main;

import Utils.ChangePieceIndexToChessPosition;
import Utils.GetUserInput;
import Utils.PrintLoadingString;
import domain.Checkmate;
import service.ServiceChessGame;

import java.util.Random;
import java.util.Scanner;

public class ChessGameApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GetUserInput getUserInput = new GetUserInput();
        PrintLoadingString printLoadingString = new PrintLoadingString();
        Random random = new Random();
        ServiceChessGame serviceChessGame = new ServiceChessGame();
        Checkmate checkmate = new Checkmate();
        ChangePieceIndexToChessPosition changePieceIndexToChessPosition = new ChangePieceIndexToChessPosition();


        Console console = new Console();
        console.startGame(
                scanner,
                getUserInput,
                printLoadingString,
                random,
                serviceChessGame,
                checkmate,
                changePieceIndexToChessPosition
        );

    }
}
