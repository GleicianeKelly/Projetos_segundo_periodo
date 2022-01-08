package codChristian;
import java.util.Date;
public class Edicao {

	
	
	//import java.text.SimpleDateFormat;

	
	    private int num;
	    private Date data;
	    private int tiragem;
	    private int vendidas;
	    private boolean reciclagemAtualizada;

	    public Edicao(int num, Date data, int tiragem, int vendidas) {
	        this.num = num;
	        this.data = data;
	        this.tiragem = tiragem;
	        this.vendidas = vendidas;
	        this.reciclagemAtualizada = false;
	    }

	    public int getNum() {
	        return num;
	    }


	    public Date getData() {
	        return data;
	    }

	    public void setData(Date data) {
	        this.data = data;
	    }

	    public int getTiragem() {
	        return tiragem;
	    }

	    public void setTiragem(int tiragem) {
	        this.tiragem = tiragem;
	    }

	    public int getVendidas() {
	        return vendidas;
	    }

	    public void setVendidas(int vendidas) {
	        this.vendidas = vendidas;
	    }

	    public boolean isReciclagemAtualizada() {
	        return reciclagemAtualizada;
	    }

	    public void setReciclagemAtualizada(boolean reciclagemAtualizada) {
	        this.reciclagemAtualizada = reciclagemAtualizada;
	    }

	    public int qtdeRecicladas() {
	        return this.tiragem - this.vendidas;
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
