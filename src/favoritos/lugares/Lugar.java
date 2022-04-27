package favoritos.lugares;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Lugar {

	private String nome;
	private List<Integer> avaliacoes = new ArrayList<Integer>();
	
	public Lugar(String nome) {
		this.nome = nome.toUpperCase();
	}

	public void mostraNoMapa() throws IOException, URISyntaxException {
		String nomeUrl = this.nome.replace(" ","%20");
		Desktop.getDesktop().browse(new URI("https://www.google.com/maps/search/?api=1&query="+nomeUrl));
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public void addAvaliacao(int avaliacao) {
		if (avaliacao < 0 || avaliacao > 5) {
			throw new RuntimeException("Avaliação deve ter 1 a 5 estrelas!");
		}
		this.avaliacoes.add(avaliacao);
		
	}

	public Integer totalDeAvaliacoes() {
		return avaliacoes.size();
	}

	public double avaliacaoMedia() {
		return somaDasAvaliacoes() / totalDeAvaliacoes();
	}

	private double somaDasAvaliacoes() {
		double soma = 0d;
		for (Integer avaliacao : avaliacoes) {
			soma += avaliacao;
		
		}
		return soma;
	}

	
	
	public String avaliacaoStatus() {
		double media = avaliacaoMedia();
		if (media < 3) {
			return "Ruim";
		}
		else if (media >= 3 && media <= 4) {
			return "Bom";
		}
		else{
			return "Otimo";
		}
		
		
	}

	@Override
	public String toString() {
		return "nome: " + nome + "\n"+"Avaliações: " + totalDeAvaliacoes() +"\n"+ "Media: "
				+ avaliacaoMedia() + "\n"+ "Status: " + avaliacaoStatus();
	}

		
	
}
 