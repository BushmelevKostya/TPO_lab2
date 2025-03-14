package itmo;

import itmo.logarithm.Ln;
import itmo.service.CSVWriter;
import itmo.trigonometry.Sin;

import java.util.function.DoubleFunction;

public class Main {
	public static void main(String[] args) {
		int accuracy = 5;
		Sin func = new Sin(accuracy);
		
		String filePath = "src/main/resources/";
		DoubleFunction<Double> function = func::calculate;
		double start = Math.PI / 4;
		double end = 2 * Math.PI;
		double step = Math.PI / 4;
		String delimiter = ",";
		String functionName = "sin";
		CSVWriter csvWriter = new CSVWriter();
		csvWriter.exportToCsv(filePath, function, start, end, step, delimiter, functionName);
	}
}