package com.liferay.forms.util;

import java.io.File;

public class CSVReader {

	public static String[][] readCSV(File file) {
		String[] lines = FileUtil.readLinesFromFile(file);

		if ((lines == null) || (lines.length == 0)) {
			return null;
		}

		String[] s = lines[0].split(",");

		String[][] results = new String[lines.length][s.length];

		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];

			String[] columns = line.split(",");

			for (int t = 0; t < columns.length; t++) {
				results[i][t] = columns[t];
			}
		}

		return results;
	}

}