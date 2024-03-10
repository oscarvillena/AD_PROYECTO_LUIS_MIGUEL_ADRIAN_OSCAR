/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Pantallas.Principal.Paneles;

import Herramientas.PanelProducto;
import Tablas.*;
import Tablas.Compras;
import Tablas.Factura;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import logica.Main;

/**
 *
 * @author LUIS MIGUEL
 */
public class PanelTienda2 extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form PanelTienda2
     */
    
    private  ArrayList <PanelProducto> productos;
    private  float precio;
    
    
    
    
    public PanelTienda2() {
        initComponents();
        this.precio = 0;
        this.productos = new ArrayList<>();
        for(Producto p: Main.shop.devolverTodosProductos()){
           productos.add(new PanelProducto(p));
        }
          if(!Pantallas.Principal.PantallaPrincipal.getUser().getAdmin()){
            jPanelAdmin.setVisible(false);
            }  
        
        ajustarProductos();
        
        new Thread(this).start();
        
        
    }
    
    public  void ajustarProductos(){
        for (PanelProducto producto : productos) {
            PannelLista.add(producto);    
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

        jPanel2 = new javax.swing.JPanel();
        precioCarrito = new javax.swing.JLabel();
        btnCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ScrollProductos = new javax.swing.JScrollPane();
        PannelLista = new javax.swing.JPanel();
        jPanelAdmin = new javax.swing.JPanel();
        btnAdmProductos1 = new javax.swing.JButton();
        btnAdmCompras1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        precioCarrito.setBackground(new java.awt.Color(0, 0, 0));
        precioCarrito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        precioCarrito.setForeground(new java.awt.Color(255, 255, 0));
        precioCarrito.setText("hola");

        btnCompra.setBackground(new java.awt.Color(255, 255, 0));
        btnCompra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCompra.setForeground(new java.awt.Color(0, 0, 0));
        btnCompra.setText("Comprar");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(precioCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(precioCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tienda");

        ScrollProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        PannelLista.setLayout(new javax.swing.BoxLayout(PannelLista, javax.swing.BoxLayout.PAGE_AXIS));
        ScrollProductos.setViewportView(PannelLista);

        jPanelAdmin.setBackground(new java.awt.Color(0, 0, 0));

        btnAdmProductos1.setBackground(new java.awt.Color(255, 255, 0));
        btnAdmProductos1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdmProductos1.setForeground(new java.awt.Color(0, 0, 0));
        btnAdmProductos1.setText("Adm productos");
        btnAdmProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmProductos1ActionPerformed(evt);
            }
        });

        btnAdmCompras1.setBackground(new java.awt.Color(255, 255, 0));
        btnAdmCompras1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdmCompras1.setForeground(new java.awt.Color(0, 0, 0));
        btnAdmCompras1.setText("Adm compras");
        btnAdmCompras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCompras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdmProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdmCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(btnAdmProductos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdmCompras1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ScrollProductos)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ScrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(56, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        Compras compra = new Compras(Pantallas.Principal.PantallaPrincipal.getUser());
        ArrayList <Factura>fac = new <Factura>ArrayList();
        for(PanelProducto p: productos){
            if(p.getCantidad()>0){
                System.out.println("lo he recorrido");
                fac.add(new Factura(compra, p.getProducto(), p.getCantidad()));
            }
        }
        int num = JOptionPane .showConfirmDialog(this, "Deseas finalizar la compra por" +precio +" €", "Confirmacion de pago", JOptionPane.YES_NO_OPTION);
        if (num == JOptionPane.YES_OPTION){
            Main.shop.cerrarCompra(compra, fac);
        }else{
            
        }
        
        //ConfirmarCompra aux = new  ConfirmarCompra((Frame) SwingUtilities.getWindowAncestor(this), true, precio);
        //aux.setVisible(true);
        for (PanelProducto producto : productos) {
            producto.setCantidad(0);
        }
        PannelLista.removeAll();
        ajustarProductos();
        PannelLista.revalidate();
        PannelLista.repaint();
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnAdmProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmProductos1ActionPerformed
        AdminProductos vista = new AdminProductos((Frame) SwingUtilities.getWindowAncestor(this), true);
        vista.setVisible(true);
    }//GEN-LAST:event_btnAdmProductos1ActionPerformed

    private void btnAdmCompras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCompras1ActionPerformed
        AdminCompras vista = new AdminCompras((Frame) SwingUtilities.getWindowAncestor(this), true);
        vista.setVisible(true);
    }//GEN-LAST:event_btnAdmCompras1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PannelLista;
    private javax.swing.JScrollPane ScrollProductos;
    private javax.swing.JButton btnAdmCompras1;
    private javax.swing.JButton btnAdmProductos1;
    private javax.swing.JButton btnCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JLabel precioCarrito;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true){
            
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            float aux = 0;
            for (PanelProducto producto : productos) {
                aux = (float) (aux + (producto.getCantidad()* producto.getProducto().getPrecio()));
            } 
            precioCarrito.setText(aux+"€");
            precioCarrito.repaint();
            precio = aux;
        }
        
        
    }

  
}
