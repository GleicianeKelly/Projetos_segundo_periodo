package GustavoProjeto;
import java.util.Date;

public class ContratoComissionado extends Contrato {

	
	
	private float percComissao;
	private float ajudaCusto;
	
	
	
	
	public ContratoComissionado( Date dataInicio, Date dataEncerramento, Colaborador colaborador, 
			float percComissao, float ajudaCusto) {
		super (dataInicio, dataEncerramento, colaborador);
		this.percComissao = percComissao;
		this.ajudaCusto = ajudaCusto;
	}

	
	



	public float getPercComissao() {
		return percComissao;
	}




	public void setPercComissao(float percComissao) {
		this.percComissao = percComissao;
	}




	public float getAjudaCusto() {
		return ajudaCusto;
	}




	public void setAjudaCusto(float ajudaCusto) {
		this.ajudaCusto = ajudaCusto;
	}
	

	public float calcVencimento(float vlFaturamento) {
		
		return (vlFaturamento * this.percComissao) / 100 + this.ajudaCusto;
	}



	public float calcularSeguro(float vlFaturamento){
		
		float resultado = 0;
		
		float calculo = this.getAjudaCusto() * 0.005f + (this.ajudaCusto - (this.calcVencimento(vlFaturamento) * 0.01f));
		
		
			
		if(calculo <= 25){
			resultado = 25;
			
		}
		else {
			resultado = calculo;
		}

		return resultado;
	
	}
	
	
}	
