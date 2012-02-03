/*
 * F_IniciarSesion.java
 * @author Alexis Leiva http://alexisleiva.com
 * Created on 01-12-2008, 05:35:42 PM
 */

package lab.distribuidos;

/**
 *
 * @author Alexis Leiva http://alexisleiva.com
 */
public class IniciarSesion extends javax.swing.JFrame {

    private Conexion conexion;
    public boolean inicio = false;

    public IniciarSesion() {
        initComponents();
        this.setVisible(true);
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        T_Servidor = new javax.swing.JTextField();
        T_Usuario = new javax.swing.JTextField();
        B_Aceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        T_Contrasena = new javax.swing.JPasswordField();
        T_Puerto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");

        jLabel1.setText("Servidor pop3:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Contraseña:");

        T_Servidor.setText("localhost");
        T_Servidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_ServidorActionPerformed(evt);
            }
        });

        T_Usuario.setText("receptor@prueba.com");
        T_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_UsuarioActionPerformed(evt);
            }
        });

        B_Aceptar.setText("Aceptar");
        B_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AceptarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Ingrese la información Requerida");

        T_Contrasena.setText("receptor");

        T_Puerto.setText("110");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(B_Aceptar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(T_Usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                    .addComponent(T_Contrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(T_Servidor, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(T_Puerto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(206, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(T_Servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T_Puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(T_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(T_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("T_Servidor");
        jLabel2.getAccessibleContext().setAccessibleName("T_Usuario");
        jLabel3.getAccessibleContext().setAccessibleName("T_Contrasena");
        T_Servidor.getAccessibleContext().setAccessibleName("T_Servidor");
        T_Servidor.getAccessibleContext().setAccessibleDescription("T_Servidor");
        T_Usuario.getAccessibleContext().setAccessibleName("T_Usuario");
        B_Aceptar.getAccessibleContext().setAccessibleName("B_Aceptar");
        jLabel4.getAccessibleContext().setAccessibleName("T_Titulo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_AceptarActionPerformed

        String servidor = this.T_Servidor.getText().trim();
        String usuario = this.T_Usuario.getText().trim();
        String contrasena = this.T_Contrasena.getText();

        int puerto = 0;

        try
        {
            puerto=Integer.parseInt(T_Puerto.getText().trim());
        }
        catch(Exception ex)
        {

        }

        if(servidor.length()>0 && usuario.length()>0 && contrasena.length() >0 && puerto >0)
        {   
            conexion=new Conexion(servidor,puerto);
            conexion.iniciarSesion(usuario,contrasena);
            
            if(conexion.estaConectado()){
                   inicio = true;
                   Principal p = new Principal(conexion);
                   this.dispose();
            }else{
                System.out.println("Eror : No se ha podido establecer conexión con: "+ servidor);
            }
        }
        else
        {
            System.out.println("Error: Por favor ingrese todos los datos solicitados");
        }
}//GEN-LAST:event_B_AceptarActionPerformed

    private void T_ServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_ServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_ServidorActionPerformed

    private void T_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_UsuarioActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Aceptar;
    private javax.swing.JPasswordField T_Contrasena;
    private javax.swing.JTextField T_Puerto;
    private javax.swing.JTextField T_Servidor;
    private javax.swing.JTextField T_Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

}
