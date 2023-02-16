package matrix;

import complex.Complex;

import java.io.IOException;
import java.util.Scanner;


public class Matrix {
    private int rows;
    private int cols;
    private Complex[][]matrix;

    public Matrix(){
        rows = 0;
        cols = 0;
    }

    public Matrix(Complex[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Complex getElement(int i, int j) {
        return matrix[i][j];
    }

    public void inputMatrix() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Print number of rows:");
        rows = in.nextInt();
        System.out.print("Print number of columns:");
        cols = in.nextInt();
        matrix = new Complex[rows][cols];

        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < cols; ++j){
                System.out.print("Is " + i + " " + j + " number complex?(y/n)");
                char IsComplex = (char) System.in.read ();

                if (IsComplex == 'y'){
                    System.out.print("Write parameter a:");
                    double a = in.nextDouble();
                    System.out.print("Write parameter b:");
                    double b = in.nextDouble();
                    Complex complex = new Complex(a, b);
                    matrix[i][j] = complex;
                }
                else if (IsComplex == 'n'){
                    System.out.print("Write number:");
                    double a = in.nextDouble();
                    Complex complex = new Complex(a, 0);
                    matrix[i][j] = complex;
                }
                else{
                    System.out.println("You entered neither y nor n, so your element will be a normal number :)");
                    System.out.print("Write number:");
                    double a = in.nextDouble();
                    Complex complex = new Complex(a, 0);
                    matrix[i][j] = complex;
                }
            }
        }
    }

    public Matrix sumMatrix(Matrix b){
        if (rows!= b.getRows() || cols!=b.getCols()){
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        Complex[][] matrixSum = new Complex[rows][cols];

        for(int i = 0; i < rows; ++i){
            for(int j =0; j < cols; ++j){
                matrixSum[i][j] = (this.getElement(i,j)).sumComplex(b.getElement(i,j));
            }
        }
        return new Matrix(matrixSum);
    }

    public Matrix multiMatrix(Matrix b){
        if(this.cols != b.getRows()){
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        Complex[][] matrixMulti = new Complex[rows][b.getCols()];
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < b.getCols(); ++j) {
                matrixMulti[i][j] = new Complex();
                for (int k = 0; k < cols; ++k)
                    matrixMulti[i][j] = matrixMulti[i][j].sumComplex(matrix[i][k].multiComplex(b.getElement(k, j)));
            }
        return new Matrix(matrixMulti);
    }

    public Matrix trnsposeMatrix(){
        Complex[][] matrixTranspose = new Complex[this.cols][this.rows];
        for(int i = 0; i < this.rows; ++i){
            for(int j = 0; j < this.cols; ++j){
                matrixTranspose[j][i] = this.getElement(i, j);
            }
        }
        return new Matrix(matrixTranspose);
    }

    public void printMatrix(){
        for(int i = 0; i < this.rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(matrix[i][j].getImage() > 0){System.out.print(matrix[i][j].getReal() + " + " + matrix[i][j].getImage() + "i\t");}
                else if(matrix[i][j].getImage() < 0){System.out.print(matrix[i][j].getReal() + "" + matrix[i][j].getImage() + "i\t");}
                else{System.out.print(matrix[i][j].getReal()+"\t");}
            }
            System.out.println();
        }
        System.out.println();
    }
}
