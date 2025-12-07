
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AppletUno extends Applet implements ActionListener {

    Label lblCliente;
    TextField txtCliente;

    Label[] lblNameProducto = new Label[3];
    TextField[] txtNameProducto = new TextField[3];

    Label[] lblValorUnitario = new Label[3];
    TextField[] txtValorUnitario = new TextField[3];

    Label[] lblCantidadProducto = new Label[3];
    TextField[] txtCantidadProducto = new TextField[3];

    Label[] lblValorTotal = new Label[3];
    TextField[] txtValorTotal = new TextField[3];

    Label lblTotalFactura;
    TextField txtTotalFactura;

    Button botonCalcular;
    Label mensajeFactura = new Label();

    @Override
    public void init() {

        setLayout(new GridLayout(0, 1, 5, 5));  //Configuracion distribucion de pantalla

        //Titulo interfaz
        Label titulo = new Label("ORDEN DE COMPRA");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo);

        //Datos cliente
        Panel filaCliente = new Panel(new FlowLayout(FlowLayout.LEFT));
        lblCliente = new Label("Cliente: ");
        lblCliente.setFont(new Font("Arial", Font.BOLD, 14));

        txtCliente = new TextField(20);
        filaCliente.add(lblCliente);
        filaCliente.add(txtCliente);
        add(filaCliente);

        //Encabezados
        Panel encabezados = new Panel(new GridLayout(1, 4));

        //coloco en negrita los encabezados
        encabezados.setFont(new Font("Arial", Font.BOLD, 14));

        encabezados.add(new Label("Producto"));
        encabezados.add(new Label("Vlr. Unitario"));
        encabezados.add(new Label("Cantidad"));
        encabezados.add(new Label("Vlr. Total"));
        add(encabezados);

        //Productos 
        for (int i = 0; i < 3; i++) {
            Panel fila = new Panel(new GridLayout(1, 4, 5, 5));

            txtNameProducto[i] = new TextField(10);
            txtValorUnitario[i] = new TextField(7);
            txtCantidadProducto[i] = new TextField(5);
            txtValorTotal[i] = new TextField(7);
            txtValorTotal[i].setEditable(false);

            fila.add(txtNameProducto[i]);
            fila.add(txtValorUnitario[i]);
            fila.add(txtCantidadProducto[i]);
            fila.add(txtValorTotal[i]);
            add(fila);
        }

        Panel filaTotal = new Panel(new FlowLayout(FlowLayout.RIGHT));
        lblTotalFactura = new Label("Valor Total:");
        lblTotalFactura.setFont(new Font("Arial", Font.BOLD, 14));
        txtTotalFactura = new TextField(10);
        txtTotalFactura.setEditable(false);
        filaTotal.add(lblTotalFactura);
        filaTotal.add(txtTotalFactura);
        add(filaTotal);

        //Mensaje de factura
        mensajeFactura.setFont(new Font("Arial", Font.BOLD, 14));
        add(mensajeFactura);

        //Boton calcular
        Panel filaBtn = new Panel();
        botonCalcular = new Button("CALCULAR");
        botonCalcular.setFont(new Font("Arial", Font.BOLD, 16));
        botonCalcular.addActionListener(this);
        filaBtn.add(botonCalcular);
        add(filaBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double totalFactura = 0;

        for (int i = 0; i < 3; i++) {

            try {
                double valor = Double.parseDouble(txtValorUnitario[i].getText());
                int cant = Integer.parseInt(txtCantidadProducto[i].getText());

                double total = valor * cant;

                txtValorTotal[i].setText(String.valueOf(total));

                totalFactura += total;
                mensajeFactura.setText("Señor@ " + txtCliente.getText() + " el total de su compra es:   " + "$" + totalFactura);

            } catch (Exception ex) {
                txtValorTotal[i].setText("0");
            }
        }

        txtTotalFactura.setText(String.valueOf(totalFactura));
    }

}
