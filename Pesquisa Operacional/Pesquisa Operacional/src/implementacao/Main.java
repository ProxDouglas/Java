/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementacao;

public class Main extends java.awt.Frame {

    private static final double _75 = 0.75;
    private static final double _50 = 0.50;
    private static final double _25 = 0.25;
    
    private int[][] matrizA = new int[4][2];
    private int[][] matrizB = new int[4][1];
    private int[][] matrizC = new int[1][2];
    
    private double salto = 50;
    
    private double x = 0 , y = 0;
    
    public Main() {
        initComponents();
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        valorYFuncaoObjetiva = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valorXFuncaoObjetiva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        campoParametroX1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoParametroY1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoRestricaoResultado1 = new javax.swing.JTextField();
        campoParametroX2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campoParametroY2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoRestricaoResultado2 = new javax.swing.JTextField();
        campoParametroX3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campoParametroY3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        campoRestricaoResultado3 = new javax.swing.JTextField();
        campoParametroX4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        campoParametroY4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        campoRestricaoResultado4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Parâmetros da função objetiva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        valorYFuncaoObjetiva.setText("25");

        jLabel5.setText("Y");

        jLabel6.setText(" = ");

        valorXFuncaoObjetiva.setText("50");

        jLabel3.setText("X");

        jLabel4.setText("+");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(valorXFuncaoObjetiva, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valorYFuncaoObjetiva, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jLabel6)
                .addContainerGap(242, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorYFuncaoObjetiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(valorXFuncaoObjetiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Parâmetros das funções de restrição", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        campoParametroX1.setText("1");

        jLabel1.setText("X");

        jLabel2.setText("+");

        campoParametroY1.setText("3");

        jLabel7.setText("Y");

        jLabel8.setText("= ");

        campoRestricaoResultado1.setText("8");

        campoParametroX2.setText("3");

        jLabel9.setText("X");

        jLabel10.setText("+");

        campoParametroY2.setText("4");

        jLabel11.setText("Y");

        jLabel12.setText("=");

        campoRestricaoResultado2.setText("19");

        campoParametroX3.setText("3");

        jLabel13.setText("X");

        jLabel14.setText("+");

        campoParametroY3.setText("1");

        jLabel15.setText("Y");

        jLabel16.setText("=");

        campoRestricaoResultado3.setText("7");

        jLabel17.setText("X");

        jLabel18.setText("+");

        jLabel19.setText("Y");

        jLabel20.setText("=");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoParametroX4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(campoParametroX3)
                    .addComponent(campoParametroX2)
                    .addComponent(campoParametroX1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoParametroY1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(campoParametroY2)
                    .addComponent(campoParametroY3)
                    .addComponent(campoParametroY4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(98, 98, 98)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(3, 3, 3))
                        .addComponent(jLabel8)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel20))
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoRestricaoResultado1)
                    .addComponent(campoRestricaoResultado2)
                    .addComponent(campoRestricaoResultado3)
                    .addComponent(campoRestricaoResultado4, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoRestricaoResultado1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoParametroX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(campoParametroY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoParametroX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(campoParametroY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(campoRestricaoResultado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoRestricaoResultado3)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoParametroX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14)
                        .addComponent(campoParametroY3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campoRestricaoResultado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoParametroX4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20))
                            .addComponent(campoParametroY4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Trabalho Prático Pesquisa Operacional");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void calcularValor(){
        double resultFuncaoObjetiva = matrizC[0][0] * x + matrizC[0][1] * y;
        //calcularRedondezas();
        while(resultFuncaoObjetiva < calcularRedondezas()){
            //System.out.println("x = " + x + " y = " + y);
            if(quebraRestricoes()){
                x = x/2;
                y = y/2;
                salto = salto/2;
            }else{
                resultFuncaoObjetiva = matrizC[0][0] * x + matrizC[0][1] * y;
            }   
        }
        System.out.println("VALOR ENCONTRADO x = " + x + " y = " + y + " TOTAL = " + resultFuncaoObjetiva);
    }
    
    public double calcularRedondezas(){
        double sumx = 0, sumy = 0;
        double result = 0,sum;
        
//        sum = matrizC[0][0] * (x+1) + matrizC[0][1] * y;
//        System.out.println("sum = " + sum);
//        if(sum > result){
//            result = sum;
//            sumx = salto;
//            sumy = 0;
//        }
        
        sum = matrizC[0][0] * (x+_75) + matrizC[0][1] * (y + _25);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = salto * _75;
            sumy = salto * _25;
        }
        
        sum = matrizC[0][0] * (x+_50) + matrizC[0][1] * (y + _50);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = salto * _50;
            sumy = salto * _50;
        }
        
        sum = matrizC[0][0] * (x+_25) + matrizC[0][1] * (y + _75);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = salto * _25;
            sumy = salto * _75;
        }
        
//        sum = matrizC[0][0] * x + matrizC[0][1] * (y + 1);
//        System.out.println("sum = " + sum);
//        if(sum > result){
//            result = sum;
//            sumx = 0;
//            sumy = salto;
//        }
        
        sum = matrizC[0][0] * (x - _25) + matrizC[0][1] * (y + _75);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = -(salto * _25);
            sumy = salto * _75;
        }
        
        sum = matrizC[0][0] * (x - _50) + matrizC[0][1] * (y + _50);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = -(salto * _50);
            sumy = salto * _50;
        }
        
        sum = matrizC[0][0] * (x - _75) + matrizC[0][1] * (y + _25);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = -(salto * _75);
            sumy = salto * _25;
        }
        
//        sum = matrizC[0][0] * (x - 1) + matrizC[0][1] * y ;
//        System.out.println("sum = " + sum);
//        if(sum > result){
//            result = sum;
//            sumx = -salto;
//            sumy = 0;
//        }
        
        sum = matrizC[0][0] * (x - _75) + matrizC[0][1] * (y - _25) ;
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = -(salto * _75);
            sumy = -(salto * _25);
        }
        
        sum = matrizC[0][0] * (x - _50) + matrizC[0][1] * (y - _50);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = -(salto * _50);
            sumy = -(salto * _50);
        }
        
        sum = matrizC[0][0] * (x - _25) + matrizC[0][1] * (y - _75);
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = -(salto * _25);
            sumy = -(salto * _75);
        }
        
//        sum = matrizC[0][0] * x + matrizC[0][1] * (y - 1) ;
//        System.out.println("sum = " + sum);
//        if(sum > result){
//            result = sum;
//            sumx = 0;
//            sumy = -salto;
//        }
        
        sum = matrizC[0][0] * (x + _25) + matrizC[0][1] * (y - _75) ;
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = salto * _25;
            sumy = -(salto * _75);
        }
        
        sum = matrizC[0][0] * (x + _50) + matrizC[0][1] * (y - _50) ;
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = salto * _50;
            sumy = -(salto * _50);
        }
        
        sum = matrizC[0][0] * (x + _75) + matrizC[0][1] * (y - _25) ;
        System.out.println("sum = " + sum);
        if(sum > result){
            result = sum;
            sumx = salto * _75;
            sumy = -(salto * _25);
        }
        
        x = x + sumx;
        y = y + sumy;
        
        return result;
    }
    
    public boolean quebraRestricoes(){
        if(testarLinhasValidas(1))
            if(matrizA[0][0] * x + matrizA[0][1] * y > matrizB[0][0])
                return true;
        
        if(testarLinhasValidas(2))
            if(matrizA[1][0] * x + matrizA[1][1] * y > matrizB[1][0])
                return true;
        
        if(testarLinhasValidas(3))
            if(matrizA[2][0] * x + matrizA[2][1] * y > matrizB[2][0])
                return true;
        
        if(testarLinhasValidas(4))
           if(matrizA[3][0] * x + matrizA[3][1] * y > matrizB[3][0])
               return true;
        
        return false;
    }
    
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    public void desativarCampos(boolean valor){
        campoParametroX1.setEnabled(valor);
        campoParametroX2.setEnabled(valor);
        campoParametroX3.setEnabled(valor);
        campoParametroX4.setEnabled(valor);
        campoParametroY1.setEnabled(valor);
        campoParametroY2.setEnabled(valor);
        campoParametroY3.setEnabled(valor);
        campoParametroY4.setEnabled(valor);
        campoRestricaoResultado1.setEnabled(valor);
        campoRestricaoResultado2.setEnabled(valor);
        campoRestricaoResultado3.setEnabled(valor);
        campoRestricaoResultado4.setEnabled(valor);
        valorXFuncaoObjetiva.setEnabled(valor);
        valorYFuncaoObjetiva.setEnabled(valor);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        desativarCampos(false);
        if(testarValoresFuncaoObjetiva()){
           matrizC[0][0] = Integer.parseInt(valorXFuncaoObjetiva.getText());
           matrizC[0][1] = Integer.parseInt(valorYFuncaoObjetiva.getText());
           
           if(testarValoresRestricoes(1)){
               matrizA[0][0] = Integer.parseInt(campoParametroX1.getText());
               matrizA[0][1] = Integer.parseInt(campoParametroY1.getText());
               matrizB[0][0] = Integer.parseInt(campoRestricaoResultado1.getText());
               //System.out.println("A¹ = " + matrizA[0][0] + " , " + matrizA[0][1] + " B = " + matrizB[0][0]);
           }
           if(testarValoresRestricoes(2)){
               matrizA[1][0] = Integer.parseInt(campoParametroX2.getText());
               matrizA[1][1] = Integer.parseInt(campoParametroY2.getText());
               matrizB[1][0] = Integer.parseInt(campoRestricaoResultado2.getText());
               //System.out.println("A² = " + matrizA[1][0] + " , " + matrizA[1][1] + " B = " + matrizB[1][0]);
           }
           if(testarValoresRestricoes(3)){
               matrizA[2][0] = Integer.parseInt(campoParametroX3.getText());
               matrizA[2][1] = Integer.parseInt(campoParametroY3.getText());
               matrizB[2][0] = Integer.parseInt(campoRestricaoResultado3.getText());
               //System.out.println("A³ = " + matrizA[2][0] + " , " + matrizA[2][1] + " B = " + matrizB[2][0]);
           }
           if(testarValoresRestricoes(4)){
               matrizA[3][0] = Integer.parseInt(campoParametroX4.getText());
               matrizA[3][1] = Integer.parseInt(campoParametroY4.getText());
               matrizB[3][0] = Integer.parseInt(campoRestricaoResultado4.getText());
               //System.out.println("A£ = " + matrizA[3][0] + " , " + matrizA[3][1] + " B = " + matrizB[3][0]);
           }
           calcularValor();
           desativarCampos(true);
       }else{
           System.out.println("VALORES DA FUNÇÃO OBJETIVA NÃO FORAM INFORMADOS!");
       }       
    }//GEN-LAST:event_jButton1ActionPerformed

    public boolean testarValoresRestricoes(int i){
        if(i == 1){
            if(campoRestricaoResultado1.getText().equals("") || campoParametroX1.getText().equals("") || campoParametroY1.equals("")){
                return false;
            }
        }
        if(i == 2){
            if(campoRestricaoResultado2.getText().equals("") || campoParametroX2.getText().equals("") || campoParametroY2.equals("")){
                return false;
            }
        }
        if(i == 3){
            if(campoRestricaoResultado3.getText().equals("") || campoParametroX3.getText().equals("") || campoParametroY3.equals("")){
                return false;
            }
        }
        if(i == 4){
            if(campoRestricaoResultado4.getText().equals("") || campoParametroX4.getText().equals("") || campoParametroY4.equals("")){
                return false;
            }
        }
        return true;
    }
    
    public boolean testarLinhasValidas(int i){
        if(i == 1){
            if(matrizA[0][0] == 0 && matrizA[0][1] == 0){
                return false;
            }
        }
        if(i == 2){
            if(matrizA[1][0] == 0 && matrizA[1][1] == 0){
                return false;
            }
        }
        if(i == 3){
            if(matrizA[2][0] == 0 && matrizA[2][1] == 0){
                return false;
            }
        }
        if(i == 4){
            if(matrizA[3][0] == 0 && matrizA[3][1] == 0){
                return false;
            }
        }
        return true;
    }
        
    public boolean testarValoresFuncaoObjetiva(){
        if(valorXFuncaoObjetiva.getText().equals("") || valorYFuncaoObjetiva.getText().equals("")){
            return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoParametroX1;
    private javax.swing.JTextField campoParametroX2;
    private javax.swing.JTextField campoParametroX3;
    private javax.swing.JTextField campoParametroX4;
    private javax.swing.JTextField campoParametroY1;
    private javax.swing.JTextField campoParametroY2;
    private javax.swing.JTextField campoParametroY3;
    private javax.swing.JTextField campoParametroY4;
    private javax.swing.JTextField campoRestricaoResultado1;
    private javax.swing.JTextField campoRestricaoResultado2;
    private javax.swing.JTextField campoRestricaoResultado3;
    private javax.swing.JTextField campoRestricaoResultado4;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField valorXFuncaoObjetiva;
    private javax.swing.JTextField valorYFuncaoObjetiva;
    // End of variables declaration//GEN-END:variables
}
