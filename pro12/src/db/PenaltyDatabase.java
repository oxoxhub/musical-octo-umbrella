package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class PenaltyDatabase {

	private File file = new File("C:/Users/YULH/up_down.penalty.txt");
	private String[] datas;
	
	public PenaltyDatabase() {
		this._load();
	}
	
	public void add(String input) {
		datas = Arrays.copyOf(datas, datas.length + 1);
		datas[datas.length - 1] = input;
		// this._save();
	}
	
	private void _load() {
		if(file.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				StringBuilder sb = new StringBuilder();
				while(br.ready()) {
					String line = br.readLine();
					sb.append(line + "\n");
				}
				this.datas = sb.toString().split("\n");
//				System.out.println(Arrays.toString(this.datas));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	public String load() {
		return String.join("\n", datas);
	}

	public void modify(int number, String input) {
		datas[number - 1] = input;
		// this._save();
	}

	public void remove(int number) {
		number -= 1;
		String[] temp = Arrays.copyOf(datas, datas.length - 1);
		System.arraycopy(datas, 0, temp, 0, number);
		System.arraycopy(datas, number + 1, temp, number, temp.length - number);
		datas = temp;
		// this._save();
	}
	
	public void save() {
		_save();
	}
	
	private void _save() {
		try (FileWriter fw = new FileWriter(file)) {
			for(int i = 0; i < datas.length; i++) {
				fw.write(datas[i] + "\n");						
			}
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
