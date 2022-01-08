package codChristian;
import java.util.ArrayList;
import java.util.List;

public class Revista {

	
	
	    private int codigo;
	    private String titulo;
	    private List<Edicao> edicoes;
	    private int reciclagemProduzida;

	    public Revista(int codigo, String titulo) {
	        this.codigo = codigo;
	        this.titulo = titulo;
	        this.edicoes = new ArrayList<Edicao>();
	        this.reciclagemProduzida = 0;
	    }

	    public int getCodigo() {
	        return codigo;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public List<Edicao> getEdicoes() {
	        return this.edicoes;
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

	    public void adicionaEdicao(Edicao ed) {
	        this.edicoes.add(ed);
	    }

	    public void removeEdicao(Edicao ed) {
	        this.edicoes.remove(ed);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	