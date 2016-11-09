/* Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo #10
 *
 * @author Rodrigo Arriaza, Alejandro Chaclán, Sebastián Galindo
 */
public class MainGUI extends javax.swing.JFrame {
    GraphDB graphdb = new GraphDB();
    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        graphdb.createGraph();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        verGrafo = new javax.swing.JButton();
        grafo6 = new javax.swing.JButton();
        verPagerank = new javax.swing.JButton();
        verMasComunicados = new javax.swing.JButton();
        verMenosComunicados = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        pOrigen = new javax.swing.JComboBox();
        label_origen = new javax.swing.JLabel();
        pDestino = new javax.swing.JComboBox();
        label_destino = new javax.swing.JLabel();
        verCorreos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Correos"));

        verGrafo.setText("Ver Grafo");
        verGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verGrafoActionPerformed(evt);
            }
        });

        grafo6.setText("Ver Grafo de 6 o mas correos");
        grafo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grafo6ActionPerformed(evt);
            }
        });

        verPagerank.setText("Ver PageRank");
        verPagerank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPagerankActionPerformed(evt);
            }
        });

        verMasComunicados.setText("Ver mas comunicados");
        verMasComunicados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMasComunicadosActionPerformed(evt);
            }
        });

        verMenosComunicados.setText("Ver menos comunicados");
        verMenosComunicados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verMenosComunicadosActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        pOrigen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Per 1", "Per 2", "Per 3", "Per 4", "Per 5", "Per 6", "Per 7", "Per 8", "Per 9", "Per 10", "Per 11", "Per 12", "Per 13", "Per 14" }));

        label_origen.setText("Origen");

        pDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Per 1", "Per 2", "Per 3", "Per 4", "Per 5", "Per 6", "Per 7", "Per 8", "Per 9", "Per 10", "Per 11", "Per 12", "Per 13", "Per 14", "Todos" }));

        label_destino.setText("Destino");

        verCorreos.setText("Ver correos");
        verCorreos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCorreosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(verGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(grafo6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(45, Short.MAX_VALUE)
                                .addComponent(verPagerank)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(verMenosComunicados)
                                    .addComponent(verMasComunicados, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_origen)
                                    .addComponent(label_destino))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(verCorreos))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verGrafo)
                    .addComponent(grafo6))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verPagerank)
                        .addGap(26, 26, 26)
                        .addComponent(verMasComunicados)
                        .addGap(35, 35, 35)
                        .addComponent(verMenosComunicados))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_origen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_destino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verCorreos)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    /*
    * Método para controlar la acción del boton ver grafo, al presionarlo se muestra el grafo
    */
    private void verGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verGrafoActionPerformed
        graphdb.mostrarGrafo();
// TODO add your handling code here:
    }//GEN-LAST:event_verGrafoActionPerformed

    /*
    * Método para controlar la acción del boton ver grafo de las personas que
    * se han enviado mas de 6 correos
    */
    private void grafo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grafo6ActionPerformed
        // TODO add your handling code here:
        graphdb.mostrarGrafo6();
    }//GEN-LAST:event_grafo6ActionPerformed
    /*
    * Método para controlar la acción del boton ver page rank, al presionarlo
    * se muestra el page rank de cada persona
    */
    private void verPagerankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPagerankActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
        graphdb.pagerank();
        textArea.setText(graphdb.getRankings());
    }//GEN-LAST:event_verPagerankActionPerformed
    /*
    * Método para controlar la acción del boton ver mas comunicados, 
    * al presionarlo se muestran las personas mas comunicadas
    */
    private void verMasComunicadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMasComunicadosActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
        textArea.setText(graphdb.masComunicados());
    }//GEN-LAST:event_verMasComunicadosActionPerformed
    /*
    * Método para controlar la acción del boton ver menos comunicados, 
    * al presionarlo se muestran las personas menos comunicadas
    */
    private void verMenosComunicadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verMenosComunicadosActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
        textArea.setText(graphdb.menosComunicados());
    }//GEN-LAST:event_verMenosComunicadosActionPerformed
    /*
    * Método para controlar la acción del boton Ver correps, 
    * al presionarlo se muestran la cantidad de correos enviados entre
    * dos personas
    */
    private void verCorreosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCorreosActionPerformed
        // TODO add your handling code here:
        textArea.setText("");
        
        String origen = pOrigen.getSelectedItem().toString();
        String destino = pDestino.getSelectedItem().toString();
        if (!destino.equals("Todos")){
        textArea.setText(graphdb.correos(origen, destino));
        } else {
            String[] destinos = new String[14];
            for (int i = 0; i<14; i++){
                destinos[i] = "Per "+(i+1);
            }
            String res = "";
            for (String str : destinos){
                res = res + graphdb.correos(origen, str) +"\n";
            }
            textArea.setText(res);
        }
    }//GEN-LAST:event_verCorreosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton grafo6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_destino;
    private javax.swing.JLabel label_origen;
    private javax.swing.JComboBox pDestino;
    private javax.swing.JComboBox pOrigen;
    private javax.swing.JTextArea textArea;
    private javax.swing.JButton verCorreos;
    private javax.swing.JButton verGrafo;
    private javax.swing.JButton verMasComunicados;
    private javax.swing.JButton verMenosComunicados;
    private javax.swing.JButton verPagerank;
    // End of variables declaration//GEN-END:variables
}
