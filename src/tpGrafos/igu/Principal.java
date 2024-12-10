package tpGrafos.igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPeso;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEjecutarAlgoritmo = new JButton("Ejecutar Algoritmo");
		btnEjecutarAlgoritmo.setBounds(38, 265, 121, 23);
		contentPane.add(btnEjecutarAlgoritmo);
		
		JButton btnVerRegiones = new JButton("Ver regiones");
		btnVerRegiones.setBounds(38, 319, 121, 23);
		contentPane.add(btnVerRegiones);
		
		JComboBox cmbProvincias = new JComboBox();
		cmbProvincias.setBounds(38, 75, 89, 22);
		contentPane.add(cmbProvincias);
		
		JLabel lblSelecProv = new JLabel("Seleccionar provincia :");
		lblSelecProv.setBounds(38, 50, 142, 14);
		contentPane.add(lblSelecProv);
		
		JLabel lblSelecArista = new JLabel("Seleccionar Arista :");
		lblSelecArista.setBounds(38, 108, 142, 14);
		contentPane.add(lblSelecArista);
		
		JComboBox cmbAristas = new JComboBox();
		cmbAristas.setBounds(38, 129, 89, 22);
		contentPane.add(cmbAristas);
		
		JLabel lblInserteSimilaridad = new JLabel("Inserte similaridad :");
		lblInserteSimilaridad.setBounds(38, 162, 142, 14);
		contentPane.add(lblInserteSimilaridad);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(38, 187, 86, 20);
		contentPane.add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(134, 186, 46, 23);
		contentPane.add(btnOK);
	}
}
