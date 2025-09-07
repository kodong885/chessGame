package main;

import domain.ChessBoard;
import service.ServiceChessGame;
import utils.GetInput;
import utils.PrintLoadingString;

import java.util.Random;
import java.util.Scanner;

public class ChessGameApplication {
    public static void main(String[] args) {

        ChessBoard chessBoard = new ChessBoard();
        ServiceChessGame serviceChessGame = new ServiceChessGame();
        GetInput getInput = new GetInput();
        Scanner scanner = new Scanner(System.in);
        PrintLoadingString printLoadingString = new PrintLoadingString();
        Random random = new Random();

        Console console = new Console();
        console.startRunning(
                chessBoard,
                serviceChessGame,
                getInput,
                scanner,
                printLoadingString,
                random
        );
    }
}

// < chessGame >
//  Pawn → ●
//  Rook → ▮
//  Queen → ※
//  King → ★
//  Bishop → ♠
//  Knight → £
//  the empty place → □
//  telling an available place user can put piece → ▨