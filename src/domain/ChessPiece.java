package domain;

abstract public class ChessPiece {
    protected Integer currentPositionX;
    protected Integer currentPositionY;
    protected String pieceType;
    protected String color; // Black / White / Empty

    public void setCurrentPositionX(Integer currentPositionX) {
        this.currentPositionX = currentPositionX;
    }

    public void setCurrentPositionY(Integer currentPositionY) {
        this.currentPositionY = currentPositionY;
    }

    public void setPieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public void setColor(String owner) {
        this.color = owner;
    }

    public Integer getCurrentPositionX() {
        return this.currentPositionX;
    }

    public Integer getCurrentPositionY() {
        return this.currentPositionY;
    }

    public String getPieceType() {
        return this.pieceType;
    }

    public String getColor() {
        return this.color;
    }



    // 잠시만 주석처리....... abstract void public attack(); // implement this!!!

}

class EmptySpace extends ChessPiece {

}

class Pawn extends ChessPiece {

}

class Queen extends ChessPiece {

}

class Rook extends ChessPiece {

}

class King extends ChessPiece {

}

class Bishop extends ChessPiece {

}

class Knight extends ChessPiece {

}


