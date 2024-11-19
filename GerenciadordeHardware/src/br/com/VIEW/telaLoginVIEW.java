package br.com.VIEW;

import br.com.DAO.conexaoDAO;
import br.com.DAO.usuarioDAO;
import br.com.DTO.UsuarioDTO;
import javax.swing.*;

public class telaLoginVIEW extends JFrame {

    // Declaração dos componentes
    private JPanel painelSuperior;
    private JLabel lblStatusConexao;
    private JLabel lblUsuario;
    private JTextField txtUsuario;  // Usando JTextField para usuário
    private JLabel lblSenha;
    private JPasswordField txtSenha;  // Usando JPasswordField para senha
    private JButton btnEntrar;

    public telaLoginVIEW() {
        initComponents();
        verificarConexao();
    }

    // Verifica a conexão com o banco de dados
    private void verificarConexao() {
        if (conexaoDAO.conector() != null) {
            lblStatusConexao.setIcon(new ImageIcon("src/img/certo.png")); // Ícone para conexão bem-sucedida
            lblStatusConexao.setToolTipText("Conectado com sucesso");
        } else {
            lblStatusConexao.setIcon(new ImageIcon("src/img/erro.png")); // Ícone para falha na conexão
            lblStatusConexao.setToolTipText("Erro na conexão");
        }
    }

    // Realiza o login
    private void logar() {
        String loginUsuario = txtUsuario.getText();
        String senhaUsuario = new String(txtSenha.getPassword());

        // Verifica se os campos estão preenchidos
        if (loginUsuario.isEmpty() || senhaUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Configura o DTO para autenticação
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome_usu(loginUsuario);
        usuario.setSenha_usu(senhaUsuario);

        usuarioDAO udao = new usuarioDAO();
        boolean autenticado = udao.logar(usuario);

        if (autenticado) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtusuario = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        btnentrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtsenha = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TELA LOGIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Usuario");

        jScrollPane1.setViewportView(txtusuario);

        jLabel4.setText("Senha");

        btnentrar.setBackground(new java.awt.Color(255, 255, 255));
        btnentrar.setForeground(new java.awt.Color(153, 255, 153));
        btnentrar.setText("Entrar");
        btnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentrarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtsenha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
      private void initcomponents() {
    
        painelSuperior = new javax.swing.JPanel();
        lblStatusConexao = new javax.swing.JLabel("Status: ");
        lblUsuario = new javax.swing.JLabel("Usuário:");
        txtUsuario = new javax.swing.JTextField(20);  // Usando JTextField
        lblSenha = new javax.swing.JLabel("Senha:");
        txtSenha = new javax.swing.JPasswordField(20);  // Usando JPasswordField
        btnEntrar = new javax.swing.JButton("Entrar");

        // Configuração do painel superior
        painelSuperior.setBackground(new java.awt.Color(105, 137, 233));
        painelSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        painelSuperior.add(lblStatusConexao);

        // Configuração do botão "Entrar"
        btnEntrar.addActionListener(evt -> logar());

        // Configuração do layout principal
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

        // Adiciona os componentes ao layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(painelSuperior, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        add(lblUsuario, gbc);

        gbc.gridx = 1;
        add(txtUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(lblSenha, gbc);

        gbc.gridx = 1;
        add(txtSenha, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(btnEntrar, gbc);

        // Configuração final da janela
        pack();
        setLocationRelativeTo(null);
    }
  
    // Método principal para iniciar o programa
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();  // Exibe o erro no console caso o look and feel falhe
        }
        java.awt.EventQueue.invokeLater(() -> new telaLoginVIEW().setVisible(true));
    }

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {
      // Obtém os valores dos campos de texto
    String loginUsuario = txtusuario.getText();  // Corrigido para o nome correto do campo
    String senhaUsuario = new String(txtsenha.getPassword());  // Usando getPassword() corretamente para a senha

    // Cria o objeto DTO para enviar os dados
    UsuarioDTO udto = new UsuarioDTO();
    udto.setNome_usu(loginUsuario);
    udto.setSenha_usu(senhaUsuario);

    // Cria o objeto do DAO e chama o método de login
    usuarioDAO udao = new usuarioDAO();

    // Realiza a autenticação
    if (udao.logar(udto)) {
        JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();  // Fecha a tela de login
    } else {
        JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
    private void btnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentrarActionPerformed
        String loginUsuario = txtusuario.getText();
        String senhaUsuario = txtSenha.getText();

        UsuarioDTO udto = new UsuarioDTO();

        udto.setNome_usu(loginUsuario);
        udto.setSenha_usu(senhaUsuario);

        usuarioDAO udao = new usuarioDAO();

        udao.logar(udto);
        this.dispose();//fechar a tela de login

    }

    private static class lblStatus {

        private static void setIcon(ImageIcon imagm) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void setToolTipText(String conectado_com_sucesso) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public lblStatus() {
        }
    }

    private static class txtUsuario {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public txtUsuario() {
        }
    }

    private static class txtSenha {

        private static String getpassword() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static String getPassword() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public txtSenha() {
        }
    }

    private static class txtusuario {

        private static String getText() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public txtusuario() {
        }
    }

    private static class txtsenha {

        private static String getPassword() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public txtsenha() {
        }
    }

    }//GEN-LAST:event_btnentrarActionPerformed
   private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnentrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane txtsenha;
    private javax.swing.JTextPane txtusuario;
    // End of variables declaration//GEN-END:variables

