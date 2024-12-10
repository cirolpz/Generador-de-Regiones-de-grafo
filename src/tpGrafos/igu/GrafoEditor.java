package tpGrafos.igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

import tpGrafos.logica.AProvincia;
import tpGrafos.logica.ControladoraLogica;
import tpGrafos.logica.NProvincia;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.Dimension;

public class GrafoEditor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox<NProvincia> provinciaBox;
	private JComboBox<NProvincia> limitrofeBox;
	private JTextField textSimilitud;
	private JTable table;
	private ControladoraLogica controladora;
	private JTextField textRegiones;
	private JMapViewer mapViewer;
	private JLabel lblLabelRegiones;
	private JPanel panel;
	private JButton btnCrearRegiones;
	private JButton btnAgregarSimilitud;

	public GrafoEditor() {
		super("Diseñando Regiones");

		controladora = new ControladoraLogica();        

		crearGrafica();

		crearTabla();

		crearEventosAcciones();

		controladora.cargarGrafoPonderado(); //Para probar el programa sin poner peso por peso
		controladora.cargarCoordenadasProvincias();

		crearMapa();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1086, 600);
		setLocationRelativeTo(null);

		cargarProvincias();
	}

	private void crearEventosAcciones() {
		provinciaBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarLimitrofes();
				tieneSimilitud();
			}
		});
		
		limitrofeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tieneSimilitud();
            }
        });

		btnAgregarSimilitud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NProvincia provincia = (NProvincia) provinciaBox.getSelectedItem();
				NProvincia limitrofe = (NProvincia) limitrofeBox.getSelectedItem();
				if(esNumero(textSimilitud.getText())) {

					int similitud = Integer.parseInt(textSimilitud.getText());
					controladora.actualizarSimilitud(provincia, limitrofe, similitud);
					controladora.conectarProvincias(provincia.getNombre(), limitrofe.getNombre(), mapViewer);

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);


					model.setColumnIdentifiers(new String[] {"Limitrofe", "Provincia", "Peso"});


					for (AProvincia arista : controladora.getGrafoPonderado()) {
						model.addRow(new Object[]{arista.getProv1(), arista.getProv2(), arista.getPeso()});
					}}
				
				if(controladora.grafoEsConexo()) {
					btnCrearRegiones.setEnabled(true);
				}
			}
		});

		btnCrearRegiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(esNumero(textRegiones.getText())) {
					int cantRegionesInput = Integer.parseInt(textRegiones.getText());
					if(cantRegionesInput<=23&&cantRegionesInput>0) {
						mapViewer.removeAllMapPolygons();
						controladora.conectarRegiones(cantRegionesInput, mapViewer);
						lblLabelRegiones.setText("<html>" + controladora.regionString().replaceAll("\n", "<br>") + "</html>");
					}
				}
			};
		});
		
		
	}

	private void crearMapa() {
		mapViewer = new JMapViewer();
		mapViewer.setBorder(new LineBorder(new Color(0, 0, 0)));
		mapViewer.setBounds(352, 74, 467, 476);
		mapViewer.setDisplayPosition(new Coordinate(-38.4161, -63.6167), 4);
		controladora.agregarMarcadores(mapViewer);
		panel.add(mapViewer);

	}

	private void crearGrafica() {
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);

		JLabel provinciaLabel = new JLabel("Seleccione la Provincia:");
		provinciaLabel.setBounds(10, 50, 287, 26);
		panel.add(provinciaLabel);

		provinciaBox = new JComboBox<>();
		provinciaBox.setBounds(10, 74, 303, 26);
		panel.add(provinciaBox);

		JLabel limitrofeLabel = new JLabel("Seleccione la Provincia limítrofe:");
		limitrofeLabel.setBounds(10, 110, 287, 26);
		panel.add(limitrofeLabel);

		limitrofeBox = new JComboBox<>();
		limitrofeBox.setBounds(10, 133, 303, 26);
		panel.add(limitrofeBox);

		JLabel lblAgregueSuSimilitud = new JLabel("Agregue su similitud:");
		lblAgregueSuSimilitud.setBounds(10, 165, 129, 26);
		panel.add(lblAgregueSuSimilitud);

		textSimilitud = new JTextField();
		textSimilitud.setBounds(10, 189, 107, 26);
		panel.add(textSimilitud);
		textSimilitud.setColumns(10);

		JLabel labelTitulo = new JLabel("TP GRAFOS");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 39));
		labelTitulo.setBounds(10, 0, 1050, 39);
		panel.add(labelTitulo);

		textRegiones = new JTextField();
		textRegiones.setColumns(10);
		textRegiones.setBounds(964, 74, 96, 26);
		panel.add(textRegiones);

		JLabel lblRegiones = new JLabel("Cantidad de regiones:");
		lblRegiones.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRegiones.setBounds(829, 74, 129, 26);
		panel.add(lblRegiones);

		btnCrearRegiones = new JButton("Crear Regiones");
		btnCrearRegiones.setEnabled(false);
		btnCrearRegiones.setBounds(884, 112, 127, 23);
		panel.add(btnCrearRegiones);

		JLabel lblRegionesTitulo = new JLabel("Regiones:");
		lblRegionesTitulo.setBounds(829, 56, 231, 14);
		panel.add(lblRegionesTitulo);

		JLabel lblMapa = new JLabel("Mapa:");
		lblMapa.setBounds(352, 56, 46, 14);
		panel.add(lblMapa);

		lblLabelRegiones = new JLabel("");
		lblLabelRegiones.setVerticalAlignment(SwingConstants.TOP);
		lblLabelRegiones.setHorizontalTextPosition(SwingConstants.LEADING);
		lblLabelRegiones.setPreferredSize(new Dimension(210, 1200));
		lblLabelRegiones.setMaximumSize(new Dimension(225, 0));
		lblLabelRegiones.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane labelScrollPane = new JScrollPane(lblLabelRegiones);
		labelScrollPane.setPreferredSize(new Dimension(227, 0));
		labelScrollPane.setBounds(829, 146, 231, 404);
		panel.add(labelScrollPane);

		btnAgregarSimilitud = new JButton("Agregar");
		btnAgregarSimilitud.setBounds(127, 189, 186, 25);
		panel.add(btnAgregarSimilitud);

	}

	private void crearTabla() {
		table = new JTable();
		table.setEnabled(false);
		table.setEditingRow(0);
		table.setEditingColumn(0);
		table.setUpdateSelectionOnSort(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowSelectionAllowed(false);


		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(10, 226, 303, 324);
		panel.add(tableScrollPane);
	}

	private void cargarProvincias() {
		List<NProvincia> provincias = controladora.getProvincias();
		for (NProvincia provincia : provincias) {
			provinciaBox.addItem(provincia);
		}
	}

	private void cargarLimitrofes() {
		NProvincia selectedProvincia = (NProvincia) provinciaBox.getSelectedItem();
		List<NProvincia> limitrofes = controladora.getProvinciasLimitrofes(selectedProvincia);
		limitrofeBox.removeAllItems();
		for (NProvincia limitrofe : limitrofes) {
			limitrofeBox.addItem(limitrofe);
		}
	}
	public void mostrarMensaje(String mensaje, String tipo, String titulo){
		JOptionPane optionPane = new JOptionPane(mensaje);
		if (tipo.equals("Info")){
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		}else if (tipo.equals("Error")) {
			optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
		}
		JDialog dialog = optionPane.createDialog(titulo);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
	}
	
	private void tieneSimilitud() { //Se agrego para poder insertar el valor de la similitud en textSimilitud y poder ver si este ya tiene una similitud y cual es
        NProvincia provincia = (NProvincia) provinciaBox.getSelectedItem();
        NProvincia limitrofe = (NProvincia) limitrofeBox.getSelectedItem();

        if (provincia != null && limitrofe != null) {
            Integer similitud = controladora.obtenerSimilitud(provincia, limitrofe);
            textSimilitud.setText(Integer.toString(similitud));
        } else {
            textSimilitud.setText("0");
        }
    }
	
	private boolean esNumero(String e) { //se modifico para que sea mas claro
		if (e.isEmpty()) {
			mostrarMensaje("La entrada está vacía.", "Error", "Error");
			return false;
		}
		try {
			int numero = Integer.parseInt(e);
			if (numero > 0) {
				return true;
			} else {
				mostrarMensaje("El número debe ser positivo.", "Error", "Error");
				return false;
			}
		} catch (NumberFormatException ex) {
			mostrarMensaje("La entrada solo permite números.", "Error", "Error");
			return false;
		}
	}

}
