package proyecto.conversormoneda.vista;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.Map;

public class ConversionDiaria {

	public static double getConversion(double cantidad, String monedaX, String monedaY) {
		Gson gson = new Gson();
		double resultado = 0;
		try (FileReader reader = new FileReader("src/main/resources/divisas.json")) {
			// Definir el tipo de datos del JSON
			Type type = new TypeToken<Map<String, Object>>() {
			}.getType();
			Map<String, Object> jsonMap = gson.fromJson(reader, type);
			@SuppressWarnings("unchecked")
			Map<String, Double> rates = (Map<String, Double>) jsonMap.get("rates");
			resultado = convert(cantidad, monedaX, monedaY, rates);

		} catch (IOException e) {
			e.printStackTrace();
		}
		DecimalFormat formatoResultado = new DecimalFormat("#.0000");
		resultado = Double.parseDouble(formatoResultado.format(resultado));
		return resultado;
	}

	private static double convert(double amount, String fromCurrency, String toCurrency, Map<String, Double> rates) {
		if (fromCurrency.equals(toCurrency)) {
			return amount;
		}
		if (fromCurrency.equals("EUR")) {
			return amount * rates.get(toCurrency);
		}
		if (toCurrency.equals("EUR")) {
			return amount / rates.get(fromCurrency);
		}

		double amountInBase = amount / rates.get(fromCurrency);
		return amountInBase * rates.get(toCurrency);
	}
}
