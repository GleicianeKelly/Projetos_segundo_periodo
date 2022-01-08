package GustavoProjeto;
import java.util.Date;

public class ContratoHorista extends Contrato {

	
	
	private int horasMes;
	private float valorHora;
	
	
	
	public ContratoHorista(Date dataInicio, Date dataEncerramento, Colaborador colaborador, 
			int horasMes, float valorHora) {
		super(dataInicio, dataEncerramento, colaborador);
		this.horasMes = horasMes;
		this.valorHora = valorHora;
	}
	


	public int getHorasMes() {
		return horasMes;
	}



	public void setHorasMes(int horasMes) {
		this.horasMes = horasMes;
	}





	public float getValorHora() {
		return valorHora;
	}




	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}





	public float calcVencimento() {
		return this.valorHora * this.horasMes;
	}
	
	
	
	
	public void calcularSeguro() {
		
		float resultado = 0;
		
		
	
		if(this.calcVencimento() < 5000f){
			resultado = (this.calcVencimento() * 2) / 100;
			}
			else if(this.calcVencimento() > 5000f){
			resultado = (this.calcVencimento() * 2.5f) / 100;
			}
	
		}
			
	}
	
	
	

