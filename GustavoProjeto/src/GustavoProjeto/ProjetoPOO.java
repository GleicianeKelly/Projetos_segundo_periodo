package GustavoProjeto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ProjetoPOO {

	


	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	static List<VendaComissionada> listaVendas = new ArrayList<VendaComissionada>();
	static List<Colaborador> listaColaborador = new ArrayList<Colaborador>();  
	static List<Contrato> listaContrato = new ArrayList<Contrato>();
	static Scanner ler = new Scanner (System.in);
	public static void main(String[] args) throws ParseException {
		
		
		
		
		
		int opcao = 0;
		
		while(true) {
			
			System.out.println("** Cadastro de colaboradores** ");
			System.out.println(" 1 cadastrar colaborador ");
			System.out.println(" 2 registrar contrato Assalariado ");
			System.out.println(" 3 registrar contrato Comissionado ");
			System.out.println(" 4 registrar contrato Horista ");	
			System.out.println(" 5 consultar contrato ");
			System.out.println(" 6 encerrar contrato ");
			System.out.println(" 7 listar colaboradores ativos ");
			System.out.println(" 8 consultar contrato do colaborador ");
			System.out.println(" 9 lançar vendas comissionadas ");
			System.out.println(" 10 emitir folha de pagamento");
			System.out.println("0 encerrar");
			
			opcao = ler.nextInt();
			
			switch(opcao) {
			
			case 0:
				System.out.println("** finalizado** ");
				break;
			
			case 1: 
				inserirColaborador();
				break;
				
			case 2:
				registrarContratoAssalariado();
				break;
				
			case 3: 
				registrarContratoComissionado();
				break;
				
			case 4:
				registrarContratoHorista();
				break;
				
				
			case 5:
				consultarContrato();
				break;
				
				
			case 6:
				encerrarContrato();
				break;
				
				
			case 7:
				listarColaboradoresAtivos();
				break;
				
			case 8:
				consultarContratoColaborador();
				break;
				
			case 9:
				lancarVendaComissionada();
				break;
				
			case 10:
				emitirFolhaPagamento();
				break;
				
			
			default:
				System.out.println("Número inválido! Digite novamente: ");
				break;
					
			}
			
			
		}
		
		
		
		
		
		
	
	}
		
		public static Colaborador pesquisarColaborador(String matriculaColaborador) {
			for(Colaborador colaborador : listaColaborador) {
				if(colaborador.getMatricula().equals(matriculaColaborador)) {
					return colaborador;
				}
			}
			return null;
		}
		
		
		public static Contrato pesquisarContrato(int IdContrato) {
			for(Contrato contrato : listaContrato) {
				if(contrato.getId() == IdContrato) {
					return contrato;
				}
			}return null;
		}
		
		
		public static Contrato pesquisarContratoColaborador (String matricula){
			for(Contrato contrato : listaContrato) {
				if(contrato.getColaborador().getMatricula().equals(matricula)) {
					return contrato;
				}
			}
			return null;
		}
		
		
		public static String pesquisarClasse(Contrato contratoEncontrado){

		String contrato = "";
	
			if(contratoEncontrado instanceof ContratoAssalariado){
				contrato = " **Contrato Assalariado** ";
			}
			else if(contratoEncontrado instanceof ContratoComissionado){
				contrato = " **Contrato Comissionado** ";
			}
			else{
				contrato = " **Contrato Horista** ";
			}
				return contrato;
		}

		
		public static boolean validarCpf(String cpf) {
	        
	        if (cpf.equals("00000000000") ||
	                cpf.equals("11111111111") ||
	                cpf.equals("22222222222") || cpf.equals("33333333333") ||
	                cpf.equals("44444444444") || cpf.equals("55555555555") ||
	                cpf.equals("66666666666") || cpf.equals("77777777777") ||
	                cpf.equals("88888888888") || cpf.equals("99999999999") ||
	                (cpf.length() != 11)) {
	            return(false);
	        }

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        try {
	            // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	                num = (int)(cpf.charAt(i) - 48);
	                sm = sm + (num * peso);
	                peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11)) {
	                dig10 = '0';
	            } else {
	                dig10 = (char)(r + 48); // converte no respectivo caractere numerico
	            }
	            // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	                num = (int)(cpf.charAt(i) - 48);
	                sm = sm + (num * peso);
	                peso = peso - 1;
	            }
	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11)) {
	                dig11 = '0';
	            }
	            else {
	                dig11 = (char)(r + 48);
	            }
	            // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
	                return (true);
	            }
	            else {
	                return (false);
	            }
	        } catch (InputMismatchException erro) {
	            return(false);
	        }
	    } 
		
		
		
		public static int retornarIdade(String data) throws ParseException {
			Date atual = new Date();
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar c = Calendar.getInstance();
			Calendar cAtual = Calendar.getInstance();

			c.setTime(date);
			cAtual.setTime(atual);

			int idade = cAtual.get(Calendar.YEAR) - c.get(Calendar.YEAR);

			if (cAtual.get(Calendar.MONTH) + 1 == c.get(Calendar.MONTH) + 1) {
				if (cAtual.get(Calendar.DATE) + 1 >= c.get(Calendar.DATE)) {

				} else {
					idade--;
				}
			} else {
				if (cAtual.get(Calendar.MONTH) + 1 > c.get(Calendar.MONTH) + 1) {
				} else {
					idade--;
				}
			}
			return idade;
		}
		

		
		public static boolean validarMatricula(String matriculaColaborador) {
			
			boolean validarMatricula = false;
			
			for(int c = 0 ; c < matriculaColaborador.length() ; c++) {
				if(matriculaColaborador.charAt(c) == '1' || matriculaColaborador.charAt(c) == '2'
					||	matriculaColaborador.charAt(c) == '3' || matriculaColaborador.charAt(c) == '4' || matriculaColaborador.charAt(c) == '5'
					|| matriculaColaborador.charAt(c) == '6' || matriculaColaborador.charAt(c) == '7' ||
					matriculaColaborador.charAt(c) ==  '8' || matriculaColaborador.charAt(c) == '9'
					|| matriculaColaborador.charAt(c) == '0') {
					
					return validarMatricula = true;
					
				}
				else {
					return validarMatricula = false;
				}
			}return validarMatricula;
		}
		
		
		
		public static void inserirColaborador() throws ParseException{
			
			System.out.println(" **Inserir colaborador** ");
			
			
			while(true) {
				
				String matriculaColaborador = "", cpf, nome;
				
				
				System.out.println("Digite a matrícula do colaborador: ");
				matriculaColaborador = ler.next();
				
				if(validarMatricula(matriculaColaborador) == false) {
					System.out.println("Digite um número válido!! ");
					continue;
				}
					
			
				Colaborador registroColaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(registroColaboradorEncontrado != null) {
					System.out.println("Colaborador já cadastrado!! ");
					continue;
				}
				
				System.out.println("Digite o CPF do colaborador: ");
				cpf = ler.next();
				
				if(validarCpf(cpf) == false ) {
					System.out.println("CPF inválido!! ");
					continue;
				}
				
				System.out.println("Digite o nome do colaborador: ");
				nome = ler.next();
					
				
				System.out.println("Digite a data de nascimento do colaborador: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformada = ler.next();
	            Date data= formato.parse(dataInformada);
	            
	            
	            
	            if(retornarIdade(dataInformada) < 18) {
	            	System.out.println("Impossível cadastrar, menor de 18 anos! ");
	            	continue;
	           	
	            }
	            
	            Colaborador colaborador = new Colaborador(matriculaColaborador, cpf, nome, data);
	            colaborador.validarCpf();
	            listaColaborador.add(colaborador);
	            
	            
	            System.out.println(listaColaborador.toString());
	            
	            System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
	            
	            
			}
			
			
			
			
			
		}
		
		
		public static void  registrarContratoAssalariado() throws ParseException {
			
			System.out.println("** Registrar Contrato assalariado **");
			
			if(listaColaborador.isEmpty()) {
				System.out.println("Não há colaborador na lista! ");
				return;
			}
			
			while(true) {
					
				String matriculaColaborador = "";
				float salarioMensal, percentualInsalubridade, percentualPericulosidade;
				
				
				
				System.out.println("Digite a data de início: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaInicio = ler.next();
	            Date dataInicio= formato.parse(dataInformadaInicio);
	            
	            
	            if(dataInicio.equals("0")) {
	            	System.out.println("Data digitada no formato incorreto!! ");
	            	break;
	            }
	            
	            if(dataInicio.before(new Date())) {
	            	System.out.println("Data de início errada, anterior a data atual! ");
	            }
				
				
				System.out.println("Digite a data de Encerramento: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformadaEncerramento = ler.next();
	            Date dataEncerramento= formato.parse(dataInformadaEncerramento);
	            
	            if(dataEncerramento.equals("0")) {
	            	System.out.println("Data digitada no formato incorreto!! ");
	            	continue;
	            }
	            
	           
	     
	            System.out.println("Digite a matrícula do colaborador: ");
				matriculaColaborador = ler.next();
			

				if(validarMatricula(matriculaColaborador) == false) {
					System.out.println("Digite um número válido!! ");
					continue;
				}
				
				
				Colaborador registroColaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
				
				if(registroColaboradorEncontrado == null) {
					System.out.println("Colaborador não cadastrado!! ");
					continue;
				}
				
				System.out.println("Digite o salário mensal: ");
				salarioMensal = ler.nextFloat();
				
				
				System.out.println("Digite o percentual de insalubridade: ");
				percentualInsalubridade = ler.nextFloat();
				
				System.out.println("Digite o percentual de periculosidade: ");
				percentualPericulosidade = ler.nextFloat();
				
				ContratoAssalariado contratoAssalariado = (new ContratoAssalariado(dataInicio, dataEncerramento, registroColaboradorEncontrado, 
						 salarioMensal, percentualInsalubridade, percentualPericulosidade));
				
				contratoAssalariado.setAtivo(true);
				registroColaboradorEncontrado.ativar();
				
				System.out.println("O id do contrato é: " + contratoAssalariado.getId()); 
				
				listaContrato.add(contratoAssalariado);
				
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
				
			}
			
			
		}
	
		public static void  registrarContratoComissionado() throws ParseException {
					
					System.out.println("** Registrar Contrato comissionado**");
					
					if(listaColaborador.isEmpty()) {
						System.out.println("Não há colaborador na lista! ");
						return;
					}
					
					while(true) {
						System.out.println("Para sair digite 0");
						
						
						String matriculaColaborador = "";
						float percentualComissao, ajudaCusto;
						
						
						System.out.println("Digite a data de início: ");
			            System.out.println("Formato da data dd/MM/yyyy");
			            String dataInformadaInicio = ler.next();
			            Date dataInicio= formato.parse(dataInformadaInicio);
						

			            if(dataInicio.equals("0")) {
			            	System.out.println("Data digitada no formato incorreto!! ");
			            	break;
			            }
			            
			            if(dataInicio.before(new Date())) {
			            	System.out.println("Data de início errada, anterior a data atual! ");
			            }
						
			            
						System.out.println("Digite a data de Encerramento: ");
			            System.out.println("Formato da data dd/MM/yyyy");
			            String dataInformadaEncerramento = ler.next();
			            Date dataEncerramento= formato.parse(dataInformadaEncerramento);
			            
			           
						
			            
						System.out.println("Digite a matrícula do colaborador: ");
						matriculaColaborador = ler.next();
						
		
						if(validarMatricula(matriculaColaborador) == false) {
							System.out.println("Digite um número válido!! ");
							continue;
						}
						
						
						Colaborador registroColaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
						
						if(registroColaboradorEncontrado == null) {
							System.out.println("Colaborador não cadastrado!! ");
							continue;
						}
						
						
						System.out.println("Digite o percentual de comissão: ");
						percentualComissao = ler.nextFloat();
						
						System.out.println("Digite a ajuda de custo: ");
						ajudaCusto = ler.nextFloat();
						
						ContratoComissionado contratoComissionado = (new ContratoComissionado(dataInicio, dataEncerramento, registroColaboradorEncontrado, 
								 percentualComissao, ajudaCusto));
						
						System.out.println("O id do contrato é: " + contratoComissionado.getId()); 
						
						listaContrato.add(contratoComissionado);
						
						System.out.println("Deseja sair do programa? [S] ou [N]");
						String resposta = ler.next();
						
						if(resposta.equalsIgnoreCase("S")) {
							System.out.println("Programa Encerrado! ");
							return;
						}
						else {
							continue;
						}
						
						
					}
					
					
				}
			
		
		public static void  registrarContratoHorista() throws ParseException {
				
			System.out.println("** Registrar Contrato comissionado**");
				
			if(listaColaborador.isEmpty()) {
				System.out.println("Não há colaborador na lista! ");
				return;
			}
				
				while(true) {
					System.out.println("Para sair digite 0");
					
					
					String matriculaColaborador = "";
					int horaMes;
					float valorHora;
					Date dataAtual = new Date();
					
					
					System.out.println("Digite a data de início: ");
		            System.out.println("Formato da data dd/MM/yyyy");
		            String dataInformadaInicio = ler.next();
		            Date dataInicio= formato.parse(dataInformadaInicio);
		            

		            if(dataInicio.equals("0")) {
		            	System.out.println("Data digitada no formato incorreto!! ");
		            	break;
		            }
		            
		            if(dataInicio.before(new Date())) {
		            	System.out.println("Data de início errada, anterior a data atual! ");
		            }
					
					
		            
					System.out.println("Digite a data de Encerramento: ");
		            System.out.println("Formato da data dd/MM/yyyy");
		            String dataInformadaEncerramento = ler.next();
		            Date dataEncerramento= formato.parse(dataInformadaEncerramento);
		            
		          
					
		            
					System.out.println("Digite a matrícula do colaborador: ");
					matriculaColaborador = ler.next();
					
					

					if(validarMatricula(matriculaColaborador) == false) {
						System.out.println("Digite um número válido!! ");
						continue;
					}
						
										
					Colaborador registroColaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
					
					if(registroColaboradorEncontrado == null) {
						System.out.println("Colaborador não cadastrado!! ");
						continue;
					}
					
					
					
					System.out.println("Digite o percentual de comissão: ");
					horaMes = ler.nextInt();
					
					System.out.println("Digite a ajuda de custo: ");
					valorHora = ler.nextFloat();
					
					ContratoHorista contratoHorista = (new ContratoHorista(dataInicio, dataEncerramento, registroColaboradorEncontrado, 
							 horaMes, valorHora));
					
					System.out.println("O id do contrato é: " + contratoHorista.getId()); 
					
					listaContrato.add(contratoHorista);
					
					System.out.println("Deseja sair do programa? [S] ou [N]");
					String resposta = ler.next();
					
					if(resposta.equalsIgnoreCase("S")) {
						System.out.println("Programa Encerrado! ");
						return;
					}
					else {
						continue;
					}
					
					
				}
				
				
			}

		public static void consultarContrato() {
				
			System.out.println(" **Consultar contrato** ");
				
			while(true) {
					
				int idContrato;
					
				System.out.println("Digite o Id do contrato");
				idContrato = ler.nextInt();
					
				Contrato contratoColaboradorEncontrado = pesquisarContrato(idContrato);	
					
				if(contratoColaboradorEncontrado == null) {
						System.out.println("Contrato não existe!! ");
						return;
				}
					

	           
				
				System.out.println(contratoColaboradorEncontrado.getId()); 
				System.out.println(formato.format(contratoColaboradorEncontrado.getDataInicio()));						
				System.out.println(formato.format(contratoColaboradorEncontrado.getDataEncerramento()));		
				System.out.println(contratoColaboradorEncontrado.isAtivo());	;
				System.out.println(contratoColaboradorEncontrado.getColaborador().getMatricula());	
				System.out.println(contratoColaboradorEncontrado.getColaborador().getNome());	
				System.out.println(contratoColaboradorEncontrado.getColaborador().getCpf());	
				System.out.println(contratoColaboradorEncontrado.getColaborador().isSituacao());	
					
				String classeEncontrada = pesquisarClasse(contratoColaboradorEncontrado);

				System.out.println(classeEncontrada);
					
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
			}
				
				
				
		}
	
		
			
		
		
		public static void encerrarContrato() throws ParseException {
				
			System.out.println(" **Encerrar contrato** ");
				
			while(true) {
					
				int idContrato;
					
					
				System.out.println("Digite o Id do contrato: ");
				idContrato = ler.nextInt();
					
				Contrato contratoColaboradorEncontrado = pesquisarContrato(idContrato);
					
				if(contratoColaboradorEncontrado == null) {
					System.out.println("Contrato não existe!!");
					return;
				}
					
				if(contratoColaboradorEncontrado.isAtivo() == false) {
					System.out.println("Contrato já encerrado!! ");
					return;
				}
					
				
				System.out.println("Digite a data de encerramento: ");
		        System.out.println("Formato da data dd/MM/yyyy");
		        String dataInformadaEncerramento = ler.next();
		        Date dataEncerramento= formato.parse(dataInformadaEncerramento);
					
					
					
		        if(dataEncerramento.after(new Date())) {
					System.out.println("Data de encerramento posterior a data atual! ");
					continue;
				}
					
				contratoColaboradorEncontrado.encerrarContrato();
					
				contratoColaboradorEncontrado.getColaborador().desativar();
					
				contratoColaboradorEncontrado.setDataEncerramento(dataEncerramento);
				
				System.out.println(contratoColaboradorEncontrado.isAtivo());
				System.out.println(contratoColaboradorEncontrado.getColaborador().isSituacao());
				System.out.println(contratoColaboradorEncontrado.getDataEncerramento());
					
				
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
			}
				
			
		}
			
			
		
		public static void listarColaboradoresAtivos() {
				
			System.out.println(" **Listar colaboradores ativos** ");
				
			if(listaColaborador.isEmpty()) {
				System.out.println("Não há colaboradores na lista!! ");
				return;
			}
				
				
			for(Colaborador colaborador : listaColaborador) {
				if(colaborador.isSituacao()) {
					System.out.println(colaborador.getMatricula());
					System.out.println(colaborador.getNome());
					System.out.println(colaborador.getCpf());
						
				}else {
					System.out.println("Não há colaboradores ativos!! ");
							break;
						}	
				
			}
				
				while(true) {
					
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
			}
				
				
		}
			
		
		
		public static void consultarContratoColaborador() {
			System.out.println(" **Consultar colaborador** ");
				
			while(true) {
					
				String matriculaColaborador = "";
					
				System.out.println("Digite a matrícula do funcionário: ");
				matriculaColaborador = ler.next();
					

				if(validarMatricula(matriculaColaborador) == false) {
					System.out.println("Digite um número válido!! ");
					continue;
				}
					
					
				Colaborador registroColaboradorEncontrado = pesquisarColaborador(matriculaColaborador);
					
				if(registroColaboradorEncontrado == null) {
					System.out.println("Colaborador não cadastrado!! ");
				}
					
				System.out.println(registroColaboradorEncontrado.getMatricula()); 
				System.out.println(registroColaboradorEncontrado.getCpf()); 
				System.out.println(registroColaboradorEncontrado.isSituacao()); 
					
					
				Contrato  contratoColaboradorEncontrado =  pesquisarContratoColaborador (matriculaColaborador);
					
					
				System.out.println(contratoColaboradorEncontrado.getId()); 
				System.out.println(contratoColaboradorEncontrado.getDataInicio());
				System.out.println(contratoColaboradorEncontrado.getDataEncerramento());
				System.out.println(contratoColaboradorEncontrado.isAtivo());
					

				String classeEncontrada = pesquisarClasse(contratoColaboradorEncontrado);

				System.out.println(classeEncontrada);
					
					
				System.out.println("Deseja sair do programa? [S] ou [N]");
				String resposta = ler.next();
				
				if(resposta.equalsIgnoreCase("S")) {
					System.out.println("Programa Encerrado! ");
					return;
				}
				else {
					continue;
				}
				
			}
		}
			
		
		public static void lancarVendaComissionada () {
			
			System.out.println(" **Lançar vendas comissionadas** ");
			
			while(true) {
				
				int idContrato;
				int mes, ano;
				float valor;
				
				try {
				System.out.println("Digite o ID do contrato: ");
				idContrato = ler.nextInt();
				}
				catch(Exception e) {
					System.out.println("Número incorreto! Digite novamente: ");
					ler.nextLine();
					continue;
				}
				
				Contrato contratoColaboradorEncontrado = pesquisarContrato(idContrato);
				
				if(contratoColaboradorEncontrado == null) {
					System.out.println("Contrato não cadastrado!! ");
					continue;
				}
				
				if(contratoColaboradorEncontrado.isAtivo() == false) {
					System.out.println("Contrato já encerrado!! ");
					continue;
				}
				
				if(!(contratoColaboradorEncontrado instanceof ContratoComissionado)) {
					System.out.println("Contrato digitado não é de "
							+ "contrato comissionado! ");
					continue;
				}
				
				System.out.println("Digite o mês: ");
				System.out.println("Ex: 01...");
				mes = ler.nextInt();
				
				System.out.println("Digite o ano: ");
				System.out.println("Ex: 2021");
				ano = ler.nextInt();
				
				System.out.println("Digite o valor total das vendas: ");
				valor = ler.nextFloat();
				
				VendaComissionada vendaComissionada = new VendaComissionada (mes, ano, valor, (ContratoComissionado)contratoColaboradorEncontrado);
				
				listaVendas.add(vendaComissionada);
				
				
			}
			
			
			
			
		}
		
		
		public static void emitirFolhaPagamento() {

			System.out.println(" **Emitir folha de pagamento** ");


			while(true) {

				int mes, ano;
	
				String dadosContrato = "";
				
				System.out.println("Digite o mês da folha a ser emitida: ");
				mes = ler.nextInt();
	
				System.out.println("Digite o ano da folha a ser emitida: ");
				ano = ler.nextInt();
	
				for(Contrato contrato : listaContrato) {
					if(contrato.isAtivo()) { 
	
						dadosContrato = "\nId: " + contrato.getId() +
						"\n Matrícula: " + contrato.getColaborador().getMatricula() +
						"\n Nome: " + contrato.getColaborador().getNome() +
						"\nSalário: " ;
					}
				
		
				if(contrato instanceof ContratoAssalariado){
					dadosContrato += ((ContratoAssalariado) contrato).calcVencimento();
					
				}
	
	
				else if(contrato instanceof ContratoComissionado){
					for(VendaComissionada vendaComissionada : listaVendas) {
							if(vendaComissionada.getContrComissionado().equals(contrato)){
								dadosContrato += ((ContratoComissionado) contrato).calcVencimento(vendaComissionada.getValor());
						
							}
					}
				}

			
			else if(contrato instanceof ContratoHorista){
				dadosContrato += ((ContratoHorista) contrato).calcVencimento();
			}

			System.out.println(dadosContrato);

			}

			
		}

		}


			
}
		

