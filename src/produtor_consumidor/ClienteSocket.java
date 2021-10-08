package produtor_consumidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket {
	
	public static void main (String[] args) throws IOException {
		//Leitura do teclado
		Scanner entrada = new Scanner(System.in);
		
		//Armazenar texto digitado
		String texto = "";
		
		//Socket cliente
		Socket cliente = null;
		
		//Stream saída de dados
		PrintStream saida = null;
		
		try {
			cliente = new Socket("127.0.0.1", 7000);
			
			saida = new PrintStream(cliente.getOutputStream());
			
			do {
				texto = entrada.nextLine();
				
				saida.println(texto);
			}while (!"sair".equals(texto));
			
		}catch (IOException e) {
			System.out.println("Algo de errado aconteceu");
		}finally {
			cliente.close();
		}
		
		entrada.close();
	}
}
