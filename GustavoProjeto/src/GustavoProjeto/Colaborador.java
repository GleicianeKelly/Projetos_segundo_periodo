package GustavoProjeto;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Colaborador{

	
	private String matricula;
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private boolean situacao;
	
	
	
	
	
	public Colaborador(String matricula, String cpf, String nome, Date dataNascimento) {
		super();
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.situacao = false;
	}
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	
	
	public boolean validarCpf() {
		
		return true;
		
	}
	
	
	public void ativar() {
		
		this.setSituacao(true);
		
	}
	
	
	public void desativar() {
		
		this.setSituacao(false);
		
	}



	@Override
	public String toString() {
		
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		
		return "\nColaborador " + this.getNome() + 
				"\nMatrícula " + this.getMatricula() + 
				"\nCPF " + this.getCpf() +
				"\nData de nascimento: " + formatarData.format(this.getDataNascimento()) + 
				"\nSituação " + this.isSituacao();
	}
		
	
	
	
}
