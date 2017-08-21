package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

public class RedesController {
	public RedesController() {
		super();
	}

	public void buscaIp(String caminhoProcesso) {
		try {
			Process p = Runtime.getRuntime().exec(caminhoProcesso);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leFluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leFluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	// Apoio para buscar propriedades
	public void propriedades() {
		Properties prop = System.getProperties();
		Set<Object> keys = prop.keySet();
		for (Object obj : keys) {
			System.out.print(obj.toString());
			System.out.print(" ==> ");
			System.out.println(System.getProperty(obj.toString()));
		}
	}

}
