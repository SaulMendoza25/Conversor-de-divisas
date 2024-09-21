package proyecto.conversormoneda.vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaminaPrincipal extends JPanel {

	private static final long serialVersionUID = -4659736133384830922L;

	public LaminaPrincipal() {
		resultado.setFont(new Font("Serial", Font.BOLD, 20));
		add(cajaPrincipal());

	}

	private Box cajaPrincipal() {
		Box cajaPrincipal = Box.createVerticalBox();

		cajaPrincipal.add(Box.createVerticalStrut(10));
		for (int i = 1; i <= 2; i++) {
			Box generarCaja = Box.createHorizontalBox();
			if (i == 1) {
				JLabel rotulo = new JLabel("Elija la moneda a convertir e ingrese la cantidad:");
				generarCaja.add(rotulo);
				generarCaja.add(Box.createHorizontalStrut(30));
				generarCaja.add(moneda_a_convertir);
				generarCaja.add(Box.createHorizontalStrut(10));
				generarCaja.add(cantidadConvertir);
				generarCaja.add(Box.createHorizontalStrut(10));
				JLabel rotulo2 = new JLabel("a");
				generarCaja.add(rotulo2);
				generarCaja.add(Box.createHorizontalStrut(10));
				generarCaja.add(convertir_a);
			} else if (i == 2) {
				botonConvertir.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (cantidadConvertir.getText().isEmpty()) {
							cantidadConvertir.setText("0");
						}
						resultado.setText(
								"" + ConversionDiaria.getConversion(Double.parseDouble(cantidadConvertir.getText()),
										moneda_a_convertir.getSelectedItem() + "", convertir_a.getSelectedItem() + ""));
					}
				});
				generarCaja.add(botonConvertir);
				generarCaja.add(Box.createGlue());
				generarCaja.add(resultado);

				generarCaja.add(Box.createGlue());
//				generarCaja.add(Box.createGlue());
				botonRestablecer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						cantidadConvertir.setText("0");
						resultado.setText("0");

					}
				});
				generarCaja.add(botonRestablecer);
			}
			cajaPrincipal.add(Box.createVerticalStrut(50));
			cajaPrincipal.add(generarCaja);
		}

		return cajaPrincipal;
	}

	private String[] tiposMoneda = { "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD",
			"BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYN", "BYR", "BZD",
			"CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "CNH", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK",
			"DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF",
			"GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP",
			"JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR",
			"LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR",
			"MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP",
			"PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
			"SLE", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
			"TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VES", "VND", "VUV", "WST", "XAF", "XAG", "XAU",
			"XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMK", "ZMW", "ZWL" };
	private final JLabel resultado = new JLabel("0");
	private final JComboBox<String> moneda_a_convertir = new JComboBox<String>(tiposMoneda);
	private final JComboBox<String> convertir_a = new JComboBox<String>(tiposMoneda);
	private final JTextField cantidadConvertir = new JTextField(20);
	private final JButton botonConvertir = new JButton("Convertir");
	private final JButton botonRestablecer = new JButton("Restablecer");
}
