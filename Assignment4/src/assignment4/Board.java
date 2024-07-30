package assignment4;
import java.util.ArrayList;
import java.util.Arrays;

import static assignment4.Constants.*;
public class Board {
    public Piece[][] my_matrix;
    public int board_Size;
    ArrayList<Piece> Pieces;
    public Piece[][] getUnderlyingMatrix() {
        return this.my_matrix;
    }

    public Board() {
        this.board_Size = 7;
        this.my_matrix = new Piece[board_Size][board_Size];
        this.Pieces = new ArrayList<>();

    }
    public Board(int Size) {
        this.board_Size = Size;
        this.my_matrix = new Piece[Size][Size];
        this.Pieces = new ArrayList<>();
    }
    public Board(Piece[][] board) {
        this.board_Size = board.length;
        this.Pieces = new ArrayList<>();
        this.my_matrix = new Piece[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null) {
                    this.my_matrix[i][j] = board[i][j];
                    this.Pieces.add(this.my_matrix[i][j]);
                }

            }
        }
    }
    //return all the pices with the same color
    public ArrayList<Piece> getPieces(PieceColor color) {
        ArrayList<Piece> pieces = new ArrayList<>();

        for (int i = 0; i < board_Size; i++) {
            for (int j = 0; j < board_Size; j++) {
                if (my_matrix[i][j] != null && my_matrix[i][j].getColor() == color) {
                    pieces.add(my_matrix[i][j]);
                }
            }
        }

        return pieces;
    }
    //get the piece in the position
    public Piece getPiece(Position position) {
        //check if the postion is valid
        if (!ValidPosition(position)) {
            return null;
        }

        int my_row = position.getRow();
        int my_col = position.getCol();


        return my_matrix[my_row][my_col];
    }


//help function to check if the position is valid
    public boolean ValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();

        return row >= 0 && row <board_Size && col >= 0 && col < board_Size;
    }
    //add piece to the board
    public void addPiece(Piece piece) {
        Position position = piece.getPosition();
        this.Pieces.add(piece);

        int row = position.getRow();
        int col = position.getCol();
        Position position1= new Position(row,col);
        if (ValidPosition(position1)){
            my_matrix[row][col] = piece;

        }
    }
    public void removePiece(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        Position position1= new Position(row,col);
        if( ValidPosition(position1)){
            my_matrix[row][col] = null;
            Pieces.remove(getPiece(position));
        }
    }
    //update the position of the peice (if he move)
    public void updatePosition(Position oldPos, Position newPos) {
        Piece piece = getPiece(oldPos);

        if (piece != null) {
            Piece targPiece = getPiece(newPos);

            if (ValidPosition(newPos) && targPiece != null) {
                if (targPiece instanceof Tank || targPiece.getColor() == piece.getColor()) {
                    return;
                }
            }

            piece.setPosition(newPos);
            int old_Row = oldPos.getRow();
            int old_Col = oldPos.getCol();
            int new_Row = newPos.getRow();
            int new_Col = newPos.getCol();

            if (ValidPosition(oldPos)) {
                my_matrix[new_Row][new_Col] = piece;
            }

            if (ValidPosition(newPos)) {
                my_matrix[new_Row][new_Col] = piece;
                my_matrix[old_Row][old_Col] = null;
            }

            if (piece.getMarker() == 'T') {
                if (piece.my_position.getCol() > 0) {
                    ((Tank) piece).setCooldown(((Tank) piece).getCooldown() - 1);
                }
            }

            // Handle pawn promotion
            if (piece.getMarker() == 'P') {

                if ((piece.getColor() == PieceColor.White && new_Row == 0) ||
                        (piece.getColor() == PieceColor.Black && new_Row == board_Size-1)) {

                    Piece promotedPiece = new Tank(newPos, piece.getColor());
                    removePiece(piece.my_position);
                    my_matrix[new_Row][new_Col] = promotedPiece;
                    Pieces.add(promotedPiece);
                }
            }
        }
    }







//count the number of piece in this color
    public int getPieceCount(PieceColor pieceColor) {
        int count = 0;

        for (int i = 0; i < board_Size; i++) {
            for (int j = 0; j < board_Size; j++) {
                if (my_matrix[i][j] != null && my_matrix[i][j].getColor() == pieceColor) {
                    count++;
                }
            }
        }

        return count;
    }
    //check if the piece can get promte
    public boolean verifyPromotion(Piece piece) {

        return piece.getMarker() == 'P' && piece.getPossibleMoves(this).isEmpty();
        }

    public void promote(Piece piece) {
        try {
            //  if the promotion is valid using the verifyPromotion
            if (verifyPromotion(piece)) {
                // If the promotion is valid, proceed with promotion
                Position old_pos = piece.getPosition();
                PieceColor old_color = piece.getColor();
                removePiece(old_pos);

                //  a new Tank piece with the same position and color a
                Tank newPiece = new Tank(old_pos, old_color);

                // Add the new Tank piece to the board
                addPiece(newPiece);

            } else {
                // If the promotion is not valid throw an IllegalArgumentException
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            // If any other exception occurs during promotion, re-throw an IllegalArgumentException
            throw new IllegalArgumentException();
        }
    }

        public int getBoardSize() {
        return board_Size;
    }
    public boolean equals(Object obj) {
        //check if this is the same board
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Board otherBoard = (Board) obj;
        return board_Size == otherBoard.board_Size && Arrays.deepEquals(my_matrix, otherBoard.my_matrix);

    }


}
