import complex.Complex;
import matrix.Matrix;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TestComplex();
        TestMatrix();
    }
    public static void PrintComplex(Complex complex){
        System.out.println();
        System.out.print("Complex number algebraic form:");
        complex.print();

        System.out.print("Complex number trigonometric form:");
        complex.printTrigonometric();
        System.out.println();
    }

    public static void TestComplex(){
        System.out.println("Test Complex");
        Scanner in = new Scanner(System.in);
        System.out.print("Write parameter a:");
        double a = in.nextDouble();
        System.out.print("Write parameter b:");
        double b = in.nextDouble();

        Complex complex = new Complex(a, b);

        PrintComplex(complex);

        System.out.print("Change parameter a:");
        a = in.nextDouble();
        complex.setReal(a);

        PrintComplex(complex);

        System.out.print("Change parameter b:");
        b = in.nextDouble();
        complex.setImage(b);

        PrintComplex(complex);

        System.out.print("Write new parameter a:");
        double a2 = in.nextDouble();
        System.out.print("Write new parameter b:");
        double b2 = in.nextDouble();

        Complex complex2 = new Complex(a2, b2);

        PrintComplex(complex2);

        System.out.println();
        System.out.println("Sum of 1 and 2 number:");
        Complex complexSum = complex.sumComplex(complex2);
        PrintComplex(complexSum);

        System.out.println();
        System.out.println("Product of 1 and 2 number:");
        Complex complexMulti = complex.multiComplex(complex2);
        PrintComplex(complexMulti);
    }
    public static void TestMatrix() throws IOException {
        System.out.println("Test Matrix");
        Matrix matrix1 = new Matrix();
        matrix1.inputMatrix();
        System.out.println();
        System.out.println("Introduced matrix:");
        matrix1.printMatrix();

        System.out.println("Transposed matrix:");
        Matrix matrixtrans = new Matrix();
        matrixtrans = matrix1.trnsposeMatrix();
        matrixtrans.printMatrix();

        Matrix matrix2 = new Matrix();
        matrix2.inputMatrix();
        System.out.println();
        System.out.println("Introduced matrix:");
        matrix2.printMatrix();

        System.out.println("Sum of two matrices:");
        Matrix matrixsum = new Matrix();
        matrixsum = matrix1.sumMatrix(matrix2);
        if(matrixsum != null){matrixsum.printMatrix();}

        System.out.println("Product of two matrices:");
        Matrix matrixmulti = new Matrix();
        matrixmulti = matrix1.multiMatrix(matrix2);
        if(matrixmulti != null){matrixmulti.printMatrix();}
    }
}
