package cartesianPlane.view;

import javax.swing.JOptionPane;

public class ViewFrame extends javax.swing.JFrame implements ViewPanel.CoordsListener {

    private ViewPanel panel;

    public ViewFrame() {
        initComponents();
        configFrame();
        configPanel();
    }

    private void configFrame() {
        setTitle("Cartesian Plane");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void configPanel() {
        panel = new ViewPanel(this);
        panel.setBounds(0, 0, getWidth(), getHeight() - 100);
        add(panel);
    }

    @Override
    public void onCoordsChanged(int x, int y) {
        String coords = "X = " + x + ", Y = " + y;

        coordsLabel.setText(coords);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        coordsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Trasladar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        coordsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        coordsLabel.setText("x = 0, y = 0");
        coordsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(coordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String x = JOptionPane.showInputDialog(this, "Ingresa un valor para  X", null);
        String y = JOptionPane.showInputDialog(this, "Ingresa un valor para  Y", null);

        if (x != null && y != null && panel != null) {

            try {
                panel.animateFigure(Integer.parseInt(x), Integer.parseInt(y));
                panel.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error debes escribir un numero");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coordsLabel;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}
