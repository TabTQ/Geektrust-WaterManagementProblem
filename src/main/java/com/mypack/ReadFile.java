package com.mypack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("rf")
public class ReadFile{
	public List<String> inputCommands(String filePath) throws IOException {
		List<String> input = new ArrayList<>();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String s;
		while ((s = br.readLine()) != null) {
			input.add(s);
		}
		br.close();
		return input;
	}
}
