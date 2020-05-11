/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg5;

/**
 *
 * @author JUAN
 */
public class Matriz {

    /**
     * Sum of matrices
     *
     * @param matA Matrix A
     * @param matB Matrix B
     * @param filA Matrix A Rows count
     * @param colA Matrix A Columns count
     * @param filB Matrix B Rows count
     * @param colB Matrix B Columns count
     * @return Matrix resulting from the sum of A and B
     */
    public static String[][] AplusB(String[][] matA, String[][] matB, int filA, int colA, int filB, int colB) {

        String[][] matC = new String[filA][colA];
        for (int i = 0; i < colA; i++) {
            for (int j = 0; j < filA; j++) {
                matC[j][i] = String.valueOf(Integer.parseInt(matA[j][i]) + Integer.parseInt(matB[j][i]));
            }
        }
        return matC;
    }

    /**
     * Substraction of matrices
     *
     * @param matA Matrix A
     * @param matB Matrix B
     * @param filA Matrix A Rows count
     * @param colA Matrix A Columns count
     * @param filB Matrix B Rows count
     * @param colB Matrix B Columns count
     * @return Matrix resulting from the substraction of A and B
     */
    public static String[][] AsubstB(String[][] matA, String[][] matB, int filA, int colA, int filB, int colB) {
        String[][] matC = new String[filA][colA];
        for (int i = 0; i < colA; i++) {
            for (int j = 0; j < filA; j++) {
                matC[j][i] = String.valueOf(Integer.parseInt(matA[j][i]) - Integer.parseInt(matB[j][i]));
            }
        }
        return matC;
    }

    /**
     * multiplation of matrices
     *
     * @param matA Matrix A
     * @param matB Matrix B
     * @param filA Matrix A Rows count
     * @param colA Matrix A Columns count
     * @param filB Matrix B Rows count
     * @param colB Matrix B Columns count
     * @return Matrix resulting from the multiplication of A and B
     */
    public static String[][] AppB(String[][] matA, String[][] matB, int filA, int colA, int filB, int colB) {
        String[][] matC = new String[filA][colA];
        for (int i = 0; i < colA; i++) {
            for (int j = 0; j < filA; j++) {
                matC[j][i] = String.valueOf(Integer.parseInt(matA[j][i]) * Integer.parseInt(matB[j][i]));
            }
        }
        return matC;
    }

    /**
     * product of matrices
     *
     * @param matA Matrix A
     * @param matB Matrix B
     * @param filA Matrix A Rows count
     * @param colA Matrix A Columns count
     * @param filB Matrix B Rows count
     * @param colB Matrix B Columns count
     * @return Matrix resulting from the product of A and B
     */
    public static String[][] AdpB(String[][] matA, String[][] matB, int filA, int colA, int filB, int colB) {
        String[][] matC = new String[filA][colB];
        fillZero(matC, filA, colB);
        for (int j = 0; j < filA; j++) {
            for (int i = 0; i < colB; i++) {
                for (int k = 0; k < colA; k++) {
                    matC[j][i] = String.valueOf(Integer.parseInt(matC[j][i]) + (Integer.parseInt(matA[j][k]) * Integer.parseInt(matB[k][i])));
                }
            }
        }
        return matC;
    }

    /**
     * transpose a matrix
     *
     * @param mat The matrix to be transposed
     * @param fil The matrix Rows count
     * @param col The matrix Columns count
     * @return The matrix "mat" transposed
     */
    public static String[][] MatTrans(String[][] mat, int fil, int col) {
        String[][] matC = new String[col][fil];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                matC[j][i] = mat[i][j]; 
            }
        }
        return matC;
    }

    public static String[][] fillZero(String[][] mat, int fil, int col) {
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = String.valueOf(0);
            }
        }
        return mat;
    }
}
