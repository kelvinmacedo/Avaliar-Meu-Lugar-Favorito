package favoritos.lugares;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		String nomeDoLugar = tela("Qual o Nome do Lugar?");
		Lugar lugar = new Lugar(nomeDoLugar);	
		
		while(true) {
			try {
				String avalicaoString = tela("Qual a avalição?");
				Integer avaliacao = Integer.parseInt(avalicaoString);
				lugar.addAvaliacao(avaliacao);
			}catch (NumberFormatException e) {
				break;
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
				break;
			}
		}
		
		telaMessage(lugar);
		lugar.mostraNoMapa();
		
	}

	private static void telaMessage(Lugar lugar) {
		JOptionPane.showMessageDialog(null, lugar);
	}

	private static String tela(String stringDisplay) {
		return JOptionPane.showInputDialog(stringDisplay);
	}

}
