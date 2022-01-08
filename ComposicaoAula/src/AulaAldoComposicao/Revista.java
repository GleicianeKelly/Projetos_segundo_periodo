package AulaAldoComposicao;
import java.util.ArrayList;
import java.util.List;
public class Revista {

	
	private int cod;
	private String titulo;
	private List<Edicao> edicoes;
	private int reciclagemProduzida;
	
	
	
	public Revista(int cod, String titulo) {
		
		this.cod = cod;
		this.titulo = titulo;
		this.edicoes = new ArrayList<Edicao>();
		this.reciclagemProduzida = reciclagemProduzida;
	}
	
	
	
	

	public int getCod() {
		return cod;
	}



	public void setCod(int cod) {
		this.cod = cod;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public List<Edicao> getEdicoes() {
		return edicoes;
	}


	public void setEdicoes(List<Edicao> edicoes) {
		this.edicoes = edicoes;
	}




	public int getReciclagemProduzida() {
		return reciclagemProduzida;
	}




	public void setReciclagemProduzida(int reciclagemProduzida) {
		this.reciclagemProduzida = reciclagemProduzida;
	}



	public void adicionaEdicao(Edicao edicao) {
		
		this.edicoes.add(edicao);
		
	}
	
	

	public void removeEdicao(Edicao edicao) {
		
		this.edicoes.add(edicao);
		
	}
	
	
	
	
}
