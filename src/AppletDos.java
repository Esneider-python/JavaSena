
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AppletDos extends Applet implements ActionListener {

    // Declaración de variables
    Label dias = new Label("Ingrese la cantidad de días: ");
    Label horas = new Label("Horas: ");
    Label minutos = new Label("Minutos: ");
    Label segundos = new Label("Segundos: ");

    Label horasResult = new Label("");
    Label minutosResult = new Label("");
    Label segundosResult = new Label("");

    Button boton = new Button("CALCULAR");

    Label resultado = new Label("");

    Label titulo = new Label("Horas - Minutos y Segundos");

    SpinnerNumberModel modelo = new SpinnerNumberModel(0, 0, 365, 1);
    JSpinner diasInput = new JSpinner(modelo);

    @Override
    public void init() {

        setLayout(new BorderLayout());

        // PANEL SUPERIOR 
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        panelSuperior.add(titulo);

        // PANEL ENTRADA 
        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dias.setFont(new Font("Arial", Font.BOLD, 16));
        diasInput.setFont(new Font("Arial", Font.BOLD, 16));

        panelEntrada.add(dias);
        panelEntrada.add(diasInput);

        // PANEL BOTÓN
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        panelBoton.add(boton);

        // PANEL RESULTADOS 
        JPanel panelResultados = new JPanel(new GridLayout(3, 2, 5, 10));

        horas.setFont(new Font("Arial", Font.BOLD, 16));
        minutos.setFont(new Font("Arial", Font.BOLD, 16));
        segundos.setFont(new Font("Arial", Font.BOLD, 16));

        horasResult.setFont(new Font("Arial", Font.BOLD, 16));
        minutosResult.setFont(new Font("Arial", Font.BOLD, 16));
        segundosResult.setFont(new Font("Arial", Font.BOLD, 16));

        panelResultados.add(horas);
        panelResultados.add(horasResult);

        panelResultados.add(minutos);
        panelResultados.add(minutosResult);

        panelResultados.add(segundos);
        panelResultados.add(segundosResult);

        // PANEL FINAL
        JPanel panelFinal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        resultado.setFont(new Font("Arial", Font.BOLD, 14));
        panelFinal.add(resultado);

        // AGREGAR TODO AL APPLET
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central 
        JPanel panelCentro = new JPanel(new GridLayout(3, 1));
        panelCentro.add(panelEntrada);
        panelCentro.add(panelBoton);
        panelCentro.add(panelResultados);

        add(panelCentro, BorderLayout.CENTER);

        add(panelFinal, BorderLayout.SOUTH);

        // Evento del botón
        boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int valueHora = 24;
        int valueMinutos = 60;
        int valueSegundos = 60;

        //calcular las cantidad de horas por la cantidad de dias
        int cantidadDias = (int) diasInput.getValue();
        int horasTotales = cantidadDias * valueHora;

        //calcular la cantidad de minutos por las horas dadas
        int minutosTotales = horasTotales * valueMinutos;

        //calcular segundos por la cantidad de minutos dado
        int segundosTotales = minutosTotales * valueSegundos;

        //asignar valores a los campos a mostrar 
        horasResult.setText(String.valueOf(horasTotales));

        minutosResult.setText(String.valueOf(minutosTotales));

        segundosResult.setText(String.valueOf(segundosTotales));

        resultado.setText(String.valueOf(cantidadDias) + " dias " + " tienen " + horasTotales + "horas . " + minutosTotales + "  minutos . " + segundosTotales + " segundos");

    }
}
