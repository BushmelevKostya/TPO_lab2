package itmo.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.DoubleFunction;

public class CSVWriter {
	public void exportToCsv(String filePath, DoubleFunction<Double> function,
	                               double start, double end, double step, String delimiter, String functionName) {
		try (FileWriter writer = new FileWriter(filePath + functionName + ".csv")) {
			for (double x = start; x <= end; x += step) {
				double result = function.apply(x);
				writer
						.append(String.valueOf(x))
						.append(delimiter)
						.append(String.valueOf(result))
						.append("\n");
			}
			System.out.println("CSV файл успешно создан: " + filePath);
		} catch (IOException e) {
			System.err.println("Ошибка при записи в CSV: " + e.getMessage());
		}
	}
}
