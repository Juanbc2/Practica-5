/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg5;

import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUAN
 */
public class GUI extends javax.swing.JFrame {

    private static String[][] matrixA;
    private static String[][] matrixB;
    private static int filA;
    private static int colA;
    private static int filB;
    private static int colB;
    private static int randomMinA = 0;
    private static int randomMaxA = 100;
    private static int randomMinB = 0;
    private static int randomMaxB = 100;
    private static boolean AGenerated = false;
    private static boolean BGenerated = false;
    private static DefaultTableModel modelA;
    private static DefaultTableModel modelB;
    private static DefaultTableModel modelC;

    public GUI() {
        initComponents();
        matriz1.setEnabled(false);
        matriz2.setEnabled(false);
        matriz3.setEnabled(false);
        AplusB.setEnabled(false);
        AsubstB.setEnabled(false);
        AppB.setEnabled(false);
        AdpB.setEnabled(false);
        AAA.setEnabled(false);
        Atrans.setEnabled(false);
        BBB.setEnabled(false);
        Btrans.setEnabled(false);
        asignA.setEnabled(false);
        asignB.setEnabled(false);
        asignA.setEnabled(false);
        finishA.setEnabled(false);
        finishB.setEnabled(false);
        filasA.setTransferHandler(null);
        filasB.setTransferHandler(null);
        columA.setTransferHandler(null);
        columB.setTransferHandler(null);
        filasA1.setTransferHandler(null);
        columA1.setTransferHandler(null);
        filasB1.setTransferHandler(null);
        columB1.setTransferHandler(null);
        valorA.setTransferHandler(null);
        valorB.setTransferHandler(null);
        ranMaxA.setTransferHandler(null);
        ranMaxB.setTransferHandler(null);
        ranMinA.setTransferHandler(null);
        ranMinB.setTransferHandler(null);
        modelA = (DefaultTableModel) matriz1.getModel();
        modelB = (DefaultTableModel) matriz2.getModel();
        modelC = (DefaultTableModel) matriz3.getModel();

    }

    /**
     * Disable The input of characters != Digits
     *
     * @param evt The Key event
     * @param num 1 for no minus, 2 to accept minus
     */
    private void onlyNumbers(java.awt.event.KeyEvent evt, int num) {
        char c = evt.getKeyChar();
        if (num == 1) {
            if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                evt.consume();
            }
        }
        if (num == 2) {
            if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
                if (c != KeyEvent.VK_MINUS) {
                    evt.consume();
                }
            }
        }
    }

    /**
     * Fill a matrix with random numbers
     *
     * @param fil Matrix Rows Count
     * @param col Matrix Columns Count
     * @return A Matrix random-filled
     */
    private String[][] fill(int fil, int col, int numMat) {
        String[][] matrix = new String[fil][col]; //crear matriz
        for (int i = 0; i < col; i++) //ciclo para agregar número aleatorio a cada posición de la matriz
        {
            for (int j = 0; j < fil; j++) {
                if (numMat == 1) {
                    matrix[j][i] = String.valueOf(getRandomNumberInRange(randomMinA, randomMaxA));
                }
                if (numMat == 2) {
                    matrix[j][i] = String.valueOf(getRandomNumberInRange(randomMinB, randomMaxB));
                }

                //System.out.println("fila "+(1+j)+" columna "+(i+1)+"="+matrix[j][i]);
            }
        }
        return matrix; //devuelve el vector lleno       
    }

    /**
     * Get a random number in a specified range
     *
     * @param min Minimum value of the range
     * @param max Maximum value of the range
     * @return The random number
     */
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Generate random-filled A matrix
     *
     *
     */
    private void generateA() {
        filA = Integer.parseInt(filasA.getText());
        colA = Integer.parseInt(columA.getText());
        String[][] matA = new String[filA][colA];
        matrixA = matA;
        matrixA = fill(filA, colA, 1);

    }

    /**
     * Generate random-filled B matrix
     *
     *
     */
    private void generateB() {
        filB = Integer.parseInt(filasB.getText());
        colB = Integer.parseInt(columB.getText());
        String[][] matB = new String[filB][colB];
        matrixB = matB;
        matrixB = fill(filB, colB, 2);

    }

    /**
     * Set the random matrix to Jtable
     *
     *
     * @param filA The Rows count
     * @param colA The Columns count
     */
    private void setToTableA(int filA, int colA) {
        generateA();
        modelA.setRowCount(0); //para limpiar la tabla
        modelA.setColumnCount(colA + 1);
        modelA.setRowCount(filA);
        for (int i = 0; i <= colA; i++) {
            matriz1.getColumnModel().getColumn(i).setResizable(false);
            matriz1.getColumnModel().getColumn(i).setPreferredWidth(35);
            matriz1.getColumnModel().getColumn(i).setHeaderValue("C" + i);
            for (int j = 0; j < filA; j++) {
                if (i == 0) {
                    modelA.setValueAt("F" + (j + 1), j, i);

                } else {
                    modelA.setValueAt(matrixA[j][i - 1], j, i);
                }

            }
            matriz1.getColumnModel().getColumn(0).setHeaderValue("");
        }

    }

    /**
     * Set the random matrix to Jtable
     *
     *
     * @param filB The Rows count
     * @param colB The Columns count
     */
    private void setToTableB(int filB, int colB) {
        generateB();
        modelB.setRowCount(0); //para limpiar la tabla
        modelB.setColumnCount(colB + 1);
        modelB.setRowCount(filB);
        for (int i = 0; i <= colB; i++) {
            matriz2.getColumnModel().getColumn(i).setResizable(false);
            matriz2.getColumnModel().getColumn(i).setPreferredWidth(35);
            matriz2.getColumnModel().getColumn(i).setHeaderValue("C" + i);
            for (int j = 0; j < filB; j++) {
                if (i == 0) {
                    modelB.setValueAt("F" + (j + 1), j, i);

                } else {
                    modelB.setValueAt(matrixB[j][i - 1], j, i);
                }

            }
            matriz2.getColumnModel().getColumn(0).setHeaderValue("");
        }
    }

    /**
     * Set the matrix to Jtable
     *
     *
     * @param mat matrix that contains the values to put into each cell
     * @param filC The Rows count
     * @param colC The Columns count
     */
    private void setToTableC(String[][] mat, int filC, int colC) {
        modelC.setRowCount(0); //para limpiar la tabla
        modelC.setColumnCount(colC + 1);
        modelC.setRowCount(filC);
        for (int i = 0; i <= colC; i++) {
            matriz3.getColumnModel().getColumn(i).setResizable(false);
            matriz3.getColumnModel().getColumn(i).setPreferredWidth(50);
            matriz3.getColumnModel().getColumn(i).setHeaderValue("C" + i);
            for (int j = 0; j < filC; j++) {
                if (i == 0) {
                    modelC.setValueAt("F" + (j + 1), j, i);

                } else {
                    modelC.setValueAt(mat[j][i - 1], j, i);
                }

            }
            matriz3.getColumnModel().getColumn(0).setHeaderValue("");
        }
    }

    /**
     * Fill the matrix with empty strings
     *
     * @param fil Matrix Row count
     * @param col Matrix Column count
     * @return The matrix with empty fields
     */
    private String[][] fillEmpty(int fil, int col) {
        String[][] matrix = new String[fil][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < fil; j++) {
                matrix[j][i] = String.valueOf("");
            }
        }
        return matrix;
    }

    /**
     * Display the matrix of null values
     *
     * @param numMat 1 for A matrix, 2 for B matrix
     */
    private void setNullMatrix(int numMat) {
        if (numMat == 1) {
            modelA.setRowCount(0); //para limpiar la tabla
            modelA.setColumnCount(colA + 1);
            modelA.setRowCount(filA);
            matrixA = new String[filA][colA];
            for (int i = 0; i <= colA; i++) {
                matriz1.getColumnModel().getColumn(i).setResizable(false);
                matriz1.getColumnModel().getColumn(i).setPreferredWidth(50);
                matriz1.getColumnModel().getColumn(i).setHeaderValue("C" + i);
                matrixA = fillEmpty(filA, colA);
                for (int j = 0; j < filA; j++) {
                    if (i == 0) {
                        modelA.setValueAt("F" + (j + 1), j, i);
                    } else {
                        modelA.setValueAt(matrixA[j][i - 1], j, i);
                    }
                }
            }
            matriz1.getColumnModel().getColumn(0).setHeaderValue("");
        }
        if (numMat == 2) {
            modelB.setRowCount(0); //para limpiar la tabla
            modelB.setColumnCount(colB + 1);
            modelB.setRowCount(filB);
            matrixB = new String[filB][colB];
            for (int i = 0; i <= colB; i++) {
                matriz2.getColumnModel().getColumn(i).setResizable(false);
                matriz2.getColumnModel().getColumn(i).setPreferredWidth(50);
                matriz2.getColumnModel().getColumn(i).setHeaderValue("C" + i);
                matrixB = fillEmpty(filB, colB);
                for (int j = 0; j < filB; j++) {
                    if (i == 0) {
                        modelB.setValueAt("F" + (j + 1), j, i);
                    } else {
                        modelB.setValueAt(matrixB[j][i - 1], j, i);
                    }
                }
            }
            matriz2.getColumnModel().getColumn(0).setHeaderValue("");
        }
    }

    /**
     * Check if the matrix is filled or not
     *
     * @param numMat 1 for A matrix, 2 for B matrix
     * @param fill if true, fill the empty cells with zeros
     */
    private void isFilled(int numMat, boolean fill) {
        if (numMat == 1) {
            for (int i = 0; i < filA; i++) {
                for (int j = 0; j < colA; j++) {
                    if (matrixA[i][j].compareTo("") == 0) {
                        if (fill) {
                            modelA.setValueAt(0, i, j + 1);
                            matrixA[i][j] = String.valueOf(0);
                        } else {
                            AGenerated = false;
                            showOption();
                            break;
                        }
                    } else {
                        AGenerated = true;
                        showOption();

                    }
                }
            }

        }
        if (numMat == 2) {
            for (int i = 0; i < filB; i++) {
                for (int j = 0; j < colB; j++) {
                    if (matrixB[i][j].compareTo("") == 0) {
                        if (fill) {
                            modelB.setValueAt(0, i, j + 1);
                            matrixB[i][j] = String.valueOf(0);
                        } else {
                            BGenerated = false;
                            showOption();
                            break;
                        }
                    } else {
                        BGenerated = true;
                        showOption();

                    }
                }
            }

        }
    }

    /**
     * Enable the buttons depending if A is generated or/and B is generated
     */
    private void showOption() {
        if (AGenerated && BGenerated) {
            AplusB.setEnabled(true);
            AsubstB.setEnabled(true);
            AppB.setEnabled(true);
            AdpB.setEnabled(true);
            asignA.setEnabled(true);
            asignB.setEnabled(true);
        }
        if (AGenerated) {
            asignA.setEnabled(true);
            AAA.setEnabled(true);
            Atrans.setEnabled(true);
        }
        if (BGenerated) {
            asignB.setEnabled(true);
            BBB.setEnabled(true);
            Btrans.setEnabled(true);
        }
        if (!BGenerated) {
            AplusB.setEnabled(false);
            AsubstB.setEnabled(false);
            AppB.setEnabled(false);
            AdpB.setEnabled(false);
            BBB.setEnabled(false);
            Btrans.setEnabled(false);
        }
        if (!AGenerated) {
            AplusB.setEnabled(false);
            AsubstB.setEnabled(false);
            AppB.setEnabled(false);
            AdpB.setEnabled(false);
            AAA.setEnabled(false);
            Atrans.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        matriz1 = new javax.swing.JTable();
        AplusB = new javax.swing.JButton();
        AppB = new javax.swing.JButton();
        AsubstB = new javax.swing.JButton();
        AdpB = new javax.swing.JButton();
        AAA = new javax.swing.JButton();
        Atrans = new javax.swing.JButton();
        BBB = new javax.swing.JButton();
        Btrans = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        matriz3 = new javax.swing.JTable();
        matCLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        filasA = new javax.swing.JTextField();
        genA = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        columA = new javax.swing.JTextField();
        filasB = new javax.swing.JTextField();
        genB = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        columB = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        matriz2 = new javax.swing.JTable();
        columA1 = new javax.swing.JTextField();
        filasA1 = new javax.swing.JTextField();
        valorA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        asignA = new javax.swing.JButton();
        columB1 = new javax.swing.JTextField();
        filasB1 = new javax.swing.JTextField();
        valorB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        asignB = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        finishA = new javax.swing.JButton();
        finishB = new javax.swing.JButton();
        ranMaxA = new javax.swing.JTextField();
        ranMinA = new javax.swing.JTextField();
        setRanA = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        ranMaxB = new javax.swing.JTextField();
        ranMinB = new javax.swing.JTextField();
        setRanB = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Operaciones de Matrices"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Operaciones de matrices");

        matriz1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        matriz1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        matriz1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(matriz1);

        AplusB.setText("A + B");
        AplusB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplusBActionPerformed(evt);
            }
        });

        AppB.setText("A · B");
        AppB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppBActionPerformed(evt);
            }
        });

        AsubstB.setText("A - B");
        AsubstB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsubstBActionPerformed(evt);
            }
        });

        AdpB.setText("A x B");
        AdpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdpBActionPerformed(evt);
            }
        });

        AAA.setText("A*A*A");
        AAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAAActionPerformed(evt);
            }
        });

        Atrans.setText("A Transpuesta");
        Atrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtransActionPerformed(evt);
            }
        });

        BBB.setText("B*B*B");
        BBB.setToolTipText("");
        BBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBBActionPerformed(evt);
            }
        });

        Btrans.setText("B Transpuesta");
        Btrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtransActionPerformed(evt);
            }
        });

        matriz3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        matriz3.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        matriz3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(matriz3);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Matriz A");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Matriz B");

        filasA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        filasA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filasAKeyTyped(evt);
            }
        });

        genA.setText("Generar");
        genA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genAActionPerformed(evt);
            }
        });

        jLabel5.setText("Número de filas");

        jLabel6.setText("Número de Columnas");

        columA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                columAKeyTyped(evt);
            }
        });

        filasB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filasBKeyTyped(evt);
            }
        });

        genB.setText("Generar");
        genB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genBActionPerformed(evt);
            }
        });

        jLabel7.setText("Número de filas");

        jLabel8.setText("Número de Columnas");

        columB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                columBKeyTyped(evt);
            }
        });

        matriz2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        matriz2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        matriz2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(matriz2);

        columA1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                columA1KeyTyped(evt);
            }
        });

        filasA1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        filasA1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filasA1KeyTyped(evt);
            }
        });

        valorA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorAKeyTyped(evt);
            }
        });

        jLabel9.setText("Fila");

        jLabel10.setText("Columna");

        jLabel11.setText("Valor");

        asignA.setText("Asignar");
        asignA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignAActionPerformed(evt);
            }
        });

        columB1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                columB1KeyTyped(evt);
            }
        });

        filasB1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        filasB1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filasB1KeyTyped(evt);
            }
        });

        valorB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorBKeyTyped(evt);
            }
        });

        jLabel12.setText("Fila");

        jLabel13.setText("Columna");

        jLabel14.setText("Valor");

        asignB.setText("Asignar");
        asignB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignBActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setText("Cambiar valor de celda en B");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("Rango de aleatorios de A");

        finishA.setText("Finalizar");
        finishA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishAActionPerformed(evt);
            }
        });

        finishB.setText("Finalizar");
        finishB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBActionPerformed(evt);
            }
        });

        ranMaxA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ranMaxAActionPerformed(evt);
            }
        });
        ranMaxA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ranMaxAKeyTyped(evt);
            }
        });

        ranMinA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ranMinA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ranMinAActionPerformed(evt);
            }
        });
        ranMinA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ranMinAKeyTyped(evt);
            }
        });

        setRanA.setText("Ok");
        setRanA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setRanAActionPerformed(evt);
            }
        });

        jLabel17.setText("valor máximo");

        jLabel18.setText("valor mínimo");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel19.setText("Cambiar valor de celda en A");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setText("Rango de aleatorios de B");

        ranMaxB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ranMaxBKeyTyped(evt);
            }
        });

        ranMinB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ranMinB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ranMinBKeyTyped(evt);
            }
        });

        setRanB.setText("Ok");
        setRanB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setRanBActionPerformed(evt);
            }
        });

        jLabel21.setText("valor máximo");

        jLabel22.setText("valor mínimo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AAA, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Atrans))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AppB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AplusB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AdpB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AsubstB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BBB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Btrans, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGap(5, 5, 5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filasA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(columA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(genA)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filasB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(columB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(genB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel9)
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valorA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel11))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(filasA1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(columA1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(asignA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(finishA))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ranMinA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ranMaxA, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(setRanA, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17))
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addComponent(matCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ranMinB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ranMaxB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(setRanB, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel12)
                                    .addGap(61, 61, 61)
                                    .addComponent(jLabel13))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(filasB1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(columB1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(valorB, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel14))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(asignB)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(finishB))))
                        .addComponent(jLabel15)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel20))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AplusB)
                            .addComponent(AsubstB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AppB)
                            .addComponent(AdpB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Atrans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AAA)
                        .addGap(34, 34, 34)
                        .addComponent(Btrans)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BBB))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filasA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(columA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filasB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(columB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genB)
                            .addComponent(genA))))
                .addGap(16, 16, 16)
                .addComponent(matCLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ranMaxB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ranMinB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(setRanB))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(filasB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(columB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(valorB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(asignB)
                                    .addComponent(finishB))))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ranMaxA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ranMinA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setRanA))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filasA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(columA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(valorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(asignA)
                            .addComponent(finishA))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filasAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filasAKeyTyped
        onlyNumbers(evt, 1);

    }//GEN-LAST:event_filasAKeyTyped

    private void columAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_columAKeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_columAKeyTyped

    private void filasBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filasBKeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_filasBKeyTyped

    private void columBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_columBKeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_columBKeyTyped

    private void genAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genAActionPerformed
        try {
            filA = Integer.parseInt(filasA.getText());
            colA = Integer.parseInt(columA.getText());
            if (filA > 0 && colA > 0) {
                int answer = JOptionPane.showConfirmDialog(null, "¿Desea que la matriz sea llenada automáticamente?");
                if (answer == JOptionPane.YES_OPTION) {
                    setToTableA(filA, colA);
                    AGenerated = true;
                    showOption();
                } else if (answer == JOptionPane.NO_OPTION) {

                    setNullMatrix(1);
                    AGenerated = false;
                    asignA.setEnabled(true);
                    showOption();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese posiciones mayores a 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese posiciones enteras mayores a 0.");
        }
    }//GEN-LAST:event_genAActionPerformed

    private void genBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genBActionPerformed
        try {
            filB = Integer.parseInt(filasB.getText());
            colB = Integer.parseInt(columB.getText());
            if (filB > 0 && colB > 0) {
                int answer = JOptionPane.showConfirmDialog(null, "¿Desea que la matriz sea llenada automáticamente?");
                if (answer == JOptionPane.YES_OPTION) {
                    setToTableB(filB, colB);
                    BGenerated = true;
                    showOption();

                } else if (answer == JOptionPane.NO_OPTION) {
                    setNullMatrix(2);
                    BGenerated = false;
                    asignB.setEnabled(true);
                    showOption();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese posiciones mayores a 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese posiciones enteras mayores a 0.");
        }
    }//GEN-LAST:event_genBActionPerformed

    private void AplusBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplusBActionPerformed
        if (filA == filB && colA == colB) {
            matCLabel.setText("Matriz Resultante de sumar A y B");
            String[][] matC = Matriz.AplusB(matrixA, matrixB, filA, colA, filB, colB);
            setToTableC(matC, filA, colA);
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos,no puede sumar matrices con dimensiones distintas.");
        }
    }//GEN-LAST:event_AplusBActionPerformed

    private void AsubstBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsubstBActionPerformed
        if (filA == filB && colA == colB) {
            matCLabel.setText("Matriz Resultante de restar A y B");
            String[][] matC = Matriz.AsubstB(matrixA, matrixB, filA, colA, filB, colB);
            setToTableC(matC, filA, colA);
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos,no puede restar matrices con dimensiones distintas.");
        }
    }//GEN-LAST:event_AsubstBActionPerformed

    private void AppBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppBActionPerformed
        if (filA == filB && colA == colB) {
            matCLabel.setText("Matriz Resultante de multiplicar A y B");
            String[][] matC = Matriz.AppB(matrixA, matrixB, filA, colA, filB, colB);
            setToTableC(matC, filA, colA);
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos,no puede multiplicar matrices con dimensiones distintas.");
        }
    }//GEN-LAST:event_AppBActionPerformed

    private void AdpBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdpBActionPerformed
        if (colA == filB) {
            matCLabel.setText("Matriz Resultante del producto entre A y B");
            String[][] matC = Matriz.AdpB(matrixA, matrixB, filA, colA, filB, colB);
            setToTableC(matC, filA, colB);
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos,no puede hacer producto de matrices,la"
                    + " cantidad de columnas de la matriz A debe ser igual a la cantidad de filas de la matriz B.");
        }
    }//GEN-LAST:event_AdpBActionPerformed

    private void AtransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtransActionPerformed
        String[][] matC = Matriz.MatTrans(matrixA, filA, colA);
        matCLabel.setText("Matriz Resultante de la transpuesta de A");
        setToTableC(matC, colA, filA);
    }//GEN-LAST:event_AtransActionPerformed

    private void BtransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtransActionPerformed
        String[][] matC = Matriz.MatTrans(matrixB, filB, colB);
        matCLabel.setText("Matriz Resultante de la transpuesta de B");
        setToTableC(matC, colB, filB);
    }//GEN-LAST:event_BtransActionPerformed

    private void BBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBBActionPerformed
        if (colB == filB) {
            matCLabel.setText("Matriz Resultante de B*B*B");
            String[][] matC = Matriz.AdpB(matrixB, matrixB, filB, colB, filB, colB);
            String[][] matD = Matriz.AdpB(matC, matrixB, filB, colB, filB, colB);
            setToTableC(matD, filB, colB);
            for (int i = 1; i <= colB; i++) {
                matriz3.getColumnModel().getColumn(i).setPreferredWidth(60 + colB);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos,sólo puedes elevar al cubo una matriz cuadrada.");
        }
    }//GEN-LAST:event_BBBActionPerformed

    private void AAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AAAActionPerformed
        if (colA == filA) {
            matCLabel.setText("Matriz Resultante de A*A*A");
            String[][] matC = Matriz.AdpB(matrixA, matrixA, filA, colA, filA, colA);
            String[][] matD = Matriz.AdpB(matC, matrixA, filA, colA, filA, colA);
            setToTableC(matD, filA, colA);
            for (int i = 1; i <= colA; i++) {
                matriz3.getColumnModel().getColumn(i).setPreferredWidth(60 + colA);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lo sentimos,sólo puedes elevar al cubo una matriz cuadrada.");
        }
    }//GEN-LAST:event_AAAActionPerformed

    private void columA1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_columA1KeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_columA1KeyTyped

    private void filasA1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filasA1KeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_filasA1KeyTyped

    private void valorAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorAKeyTyped
        onlyNumbers(evt, 2);
    }//GEN-LAST:event_valorAKeyTyped

    private void asignAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignAActionPerformed
        try {
            int fA = Integer.parseInt(filasA1.getText());
            int cA = Integer.parseInt(columA1.getText());
            int vA = Integer.parseInt(valorA.getText());
            if (fA > 0 && cA > 0) {
                matrixA[fA - 1][cA - 1] = String.valueOf(vA);
                modelA.setValueAt(matrixA[fA - 1][cA - 1], fA - 1, cA);
                isFilled(1, false);
                finishA.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese posiciones enteras mayores a 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos pedidos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "La posición ingresada está fuera de la matriz, por favor verifíquela.");

        }
    }//GEN-LAST:event_asignAActionPerformed

    private void columB1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_columB1KeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_columB1KeyTyped

    private void filasB1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filasB1KeyTyped
        onlyNumbers(evt, 1);
    }//GEN-LAST:event_filasB1KeyTyped

    private void valorBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorBKeyTyped
        onlyNumbers(evt, 2);
    }//GEN-LAST:event_valorBKeyTyped

    private void asignBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignBActionPerformed
        try {
            int fB = Integer.parseInt(filasB1.getText());
            int cB = Integer.parseInt(columB1.getText());
            int vB = Integer.parseInt(valorB.getText());
            if (fB > 0 && cB > 0) {
                matrixB[fB - 1][cB - 1] = String.valueOf(vB);
                modelB.setValueAt(matrixB[fB - 1][cB - 1], fB - 1, cB);
                isFilled(2, false);
                finishB.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese posiciones enteras mayores a 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, llene todos los campos pedidos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "La posición ingresada está fuera de la matriz, por favor verifíquela.");

        }
    }//GEN-LAST:event_asignBActionPerformed

    private void finishAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishAActionPerformed
        if (!AGenerated) {
            int answer = JOptionPane.showConfirmDialog(null, "Si tiene campos vacíos, éstos serán llenados con ceros (0). ¿Está deacuerdo?");
            if (answer == JOptionPane.YES_OPTION) {
                isFilled(1, true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, llene todas las celdas de la matriz.");
            }
        }


    }//GEN-LAST:event_finishAActionPerformed

    private void finishBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBActionPerformed
        if (!BGenerated) {
            int answer = JOptionPane.showConfirmDialog(null, "Si tiene campos vacíos, éstos serán llenados con ceros (0). ¿Está deacuerdo?");
            if (answer == JOptionPane.YES_OPTION) {
                isFilled(2, true);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, llene todas las celdas de la matriz.");
            }
        }
    }//GEN-LAST:event_finishBActionPerformed

    private void ranMaxAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ranMaxAKeyTyped
        onlyNumbers(evt, 2);        // TODO add your handling code here:
    }//GEN-LAST:event_ranMaxAKeyTyped

    private void ranMinAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ranMinAKeyTyped
        onlyNumbers(evt, 2);        // TODO add your handling code here:
    }//GEN-LAST:event_ranMinAKeyTyped

    private void setRanAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setRanAActionPerformed
        try {
            int minA = Integer.parseInt(ranMinA.getText());
            int maxA = Integer.parseInt(ranMaxA.getText());
            if (minA <= maxA) {
                randomMaxA = maxA;
                randomMinA = minA;
            } else {
                JOptionPane.showMessageDialog(null, "El rango mínimo no puede ser mayor al rango máximo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese el rango para los números aleatorios.");
        }
    }//GEN-LAST:event_setRanAActionPerformed

    private void ranMaxBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ranMaxBKeyTyped
        onlyNumbers(evt, 2);        // TODO add your handling code here:
    }//GEN-LAST:event_ranMaxBKeyTyped

    private void ranMinBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ranMinBKeyTyped
        onlyNumbers(evt, 2);        // TODO add your handling code here:
    }//GEN-LAST:event_ranMinBKeyTyped

    private void setRanBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setRanBActionPerformed
        try {
            int minB = Integer.parseInt(ranMinB.getText());
            int maxB = Integer.parseInt(ranMaxB.getText());
            if (minB <= maxB) {
                randomMaxB = maxB;
                randomMinB = minB;
            } else {
                JOptionPane.showMessageDialog(null, "El rango mínimo no puede ser mayor al rango máximo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese el rango para los números aleatorios.");
        }
    }//GEN-LAST:event_setRanBActionPerformed

    private void ranMinAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ranMinAActionPerformed

    }//GEN-LAST:event_ranMinAActionPerformed

    private void ranMaxAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ranMaxAActionPerformed

    }//GEN-LAST:event_ranMaxAActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

 /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AAA;
    private javax.swing.JButton AdpB;
    private javax.swing.JButton AplusB;
    private javax.swing.JButton AppB;
    private javax.swing.JButton AsubstB;
    private javax.swing.JButton Atrans;
    private javax.swing.JButton BBB;
    private javax.swing.JButton Btrans;
    private javax.swing.JButton asignA;
    private javax.swing.JButton asignB;
    private javax.swing.JTextField columA;
    private javax.swing.JTextField columA1;
    private javax.swing.JTextField columB;
    private javax.swing.JTextField columB1;
    private javax.swing.JTextField filasA;
    private javax.swing.JTextField filasA1;
    private javax.swing.JTextField filasB;
    private javax.swing.JTextField filasB1;
    private javax.swing.JButton finishA;
    private javax.swing.JButton finishB;
    private javax.swing.JButton genA;
    private javax.swing.JButton genB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel matCLabel;
    private javax.swing.JTable matriz1;
    private javax.swing.JTable matriz2;
    private javax.swing.JTable matriz3;
    private javax.swing.JTextField ranMaxA;
    private javax.swing.JTextField ranMaxB;
    private javax.swing.JTextField ranMinA;
    private javax.swing.JTextField ranMinB;
    private javax.swing.JButton setRanA;
    private javax.swing.JButton setRanB;
    private javax.swing.JTextField valorA;
    private javax.swing.JTextField valorB;
    // End of variables declaration//GEN-END:variables
}
