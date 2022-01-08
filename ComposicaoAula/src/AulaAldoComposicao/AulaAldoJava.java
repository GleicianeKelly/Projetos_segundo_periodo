package AulaAldoComposicao;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class AulaAldoJava {

	
	static Scanner ler = new Scanner(System.in);
	static List<Revista> listaRevista = new ArrayList<Revista>();
	public static void main(String[] args) {
		
		
		int opcao = 0;
		
		while(true) {
		System.out.println("Escolha uma das op��es: ");
		System.out.println("Adicionar Revistas 1");
		System.out.println("Adicionar edi��o 2 ");
		System.out.println("Remover edi��o 3 ");
		System.out.println("Reciclar edi��o 4");
		
		opcao = ler.nextInt();
		
		
			switch(opcao) {
			
			case 1: 
				break;
				
				
			case 2:
				
				break;
					
			case 3:
				break;
				
			case 4: 
				break;
				
				
			default: 
				System.out.println("Opcao incorreta! ");
				break;
			
			
			}
			
		
		
		
		}
		
		
		
	}
	
	
	
		public static Revista pesquisarRevista(int codRevista){
			for(Revista revista : listaRevista){
				if(revista.getCod() == codRevista) {
					return revista;
				}
				
			}
			return null;
		}
	
		public static Edicao pesquisarEdicao (int numEdicao, Revista revistaEncontrada) {
		     for (Edicao edicao : revistaEncontrada.getEdicoes()) {
		         if(edicao.getNum() == numEdicao) {
		              return edicao;
		         }
		     }
		        return null;
		}
		
		
		public static void adicionarRevista() {
			
			
			while(true){
				
				int codRevista;
				String titulo;
				System.out.println("Digite o id da revista: ");
				codRevista = ler.nextInt();
				
				System.out.println("Digite o t�tulo da revista: ");
				titulo = ler.next();
				
				
				Revista revistaEncontrada = pesquisarRevista(codRevista);
				
				if(revistaEncontrada != null) {
					System.out.println("Revista j� cadastrada!");
					continue;
				}
				
				
				
				Revista revista = new Revista (codRevista, titulo);
				listaRevista.add(revista);
				
			}
			
			
			
		}
	
		public static void adicionarEdicaoRevista() throws ParseException {
			
			while(true) {
				
				
				int codRevista;
				String titulo;
				int numEdicao;
				int tiragem;
				int quantVendidas;
				System.out.println("Digite o id da revista: ");
				codRevista = ler.nextInt();
				
				System.out.println("Digite o t�tulo da revista: ");
				titulo = ler.next();
				
				
				Revista revistaEncontrada = pesquisarRevista(codRevista);
				
				if(revistaEncontrada == null) {
					System.out.println("Revista n�o cadastrada!");
					continue;
				}
				
				System.out.println("Digite o n�mero da edi��o: ");
				numEdicao = ler.nextInt();
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Digite a data da manuten��o: ");
	            System.out.println("Formato da data dd/MM/yyyy");
	            String dataInformada = ler.next();
	            Date data = formato.parse(dataInformada);
	                
	                
				
				System.out.println("Digite a tiragem da edi��o: ");
				tiragem = ler.nextInt();
				
				System.out.println("Quantas foram vendidas: ");
				quantVendidas = ler.nextInt();
				
				
				Edicao edicao = new Edicao(numEdicao, data,tiragem, quantVendidas);
				
				revistaEncontrada.adicionaEdicao(edicao);
				
				
				
				
			}	
			
			
		}
	
	
		public static void RemoverEdicao(){
					
					while(true) {
						
						
						int codRevista;
						int numEdicao;
						System.out.println("Digite o id da revista: ");
						codRevista = ler.nextInt();
						
						
						Revista revistaEncontrada = pesquisarRevista(codRevista);
						
						if(revistaEncontrada == null) {
							System.out.println("Revista n�o cadastrada!");
							continue;
						}
						
						System.out.println("Digite o n�mero da edi��o: ");
						numEdicao = ler.nextInt();
						
						
						Edicao edicaoEncontrada = pesquisarEdicao (numEdicao, revistaEncontrada);
						
						if(edicaoEncontrada == null) {
							System.out.println("Edi��o n�o cadastrada! ");
						}
						
						revistaEncontrada.removeEdicao(edicaoEncontrada);
						
						
					}	
					
					
				}
			
		
			public static void reciclarEdicao() {
				
				while(true) {
					
					

					int codRevista;
					int numEdicao;
					System.out.println("Digite o id da revista: ");
					codRevista = ler.nextInt();
					
					
					Revista revistaEncontrada = pesquisarRevista(codRevista);
					
					if(revistaEncontrada == null) {
						System.out.println("Revista n�o cadastrada!");
						continue;
					}
					
					System.out.println("Digite o n�mero da edi��o: ");
					numEdicao = ler.nextInt();
					
					
					Edicao edicaoEncontrada = pesquisarEdicao (numEdicao, revistaEncontrada);
					
					if(edicaoEncontrada == null) {
						System.out.println("Edi��o n�o cadastrada! ");
					}
					
					if (edicaoEncontrada.isReciclagemAtualizada() == true) {
	                    System.out.println("\n\n--- Voc� n�o pode reciclar uma edi��o que j� foi reciclada ---\n");
	                    continue;
	                }
					
					
					edicaoEncontrada.quantRecicladas();
					
					revistaEncontrada.setReciclagemProduzida(revistaEncontrada.getReciclagemProduzida()  +   edicaoEncontrada.quantRecicladas());
					
					edicaoEncontrada.setReciclagemAtualizada(true);
					
					
				}
				
				
				
				
				
			}
			
			public static void destruirRevista(){
				
				while(true) {
					int codRevista;
					
					System.out.println("Digite o id da revista: ");
					codRevista = ler.nextInt();
					
					
					Revista revistaEncontrada = pesquisarRevista(codRevista);
					
					if(revistaEncontrada == null) {
						System.out.println("Revista n�o cadastrada!");
						continue;
					}
					
					
					listaRevista.remove(revistaEncontrada);
					
					
					
					
				}
			}

}
