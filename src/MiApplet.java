
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MiApplet extends Applet implements ActionListener {

    Button boton;
    Label etiqueta;
    @Override
    public void init() {
        boton = new Button("Presióname");   
        etiqueta = new Label(" ");

        add(boton);
        add(etiqueta);

        boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        etiqueta.setText("El botón ha sido presionado.");
    }
}
