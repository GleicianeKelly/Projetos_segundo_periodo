package codChristian;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class codChristianAgregacao{

    static List<Revista> revistas = new ArrayList<Revista>();
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println("\n*** Seletor de Op��es ***");
            System.out.println();
            System.out.println("1 - Adicionar Revista");
            System.out.println("2 - Adicionar Edi��o na Revista");
            System.out.println("3 - Remover Edi��o de uma Revista");
            System.out.println("4 - Reciclar Edi��o");
            System.out.println("5 - Destruir Revista");
            System.out.println("0 - Finalizar");

            System.out.print("\nOp��o: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    adicionarRevista();
                    break;
                case 2:
                    adicionarEdicaoRevista();
                    break;
                case 3:
                    removerEdicaoRevista();
                    break;
                case 4:
                    reciclarEdicao();
                    break;
                case 5:
                    destruirRevista();
                    break;
                case 0:
                    System.out.println("\n--- PROGRAMA FINALIZADO  ---");
                    return;
                default:
                    System.out.println("\n--- Op��o n�o existente  ---");
                    break;

            }
        } while (true);
    }

    public static Revista pesquisarRevista (int codigo) {
        for ( Revista revista : revistas) {
            if (revista.getCodigo() == codigo) {
                return revista;
            }
        }
        return null;
    }

    public static void adicionarRevista() {
        System.out.println("\n\n*** Adicionar Revista ***\n");

        while (true) {
            System.out.print("Insira um c�digo (ou '0' para finalizar fun��o): ");
            int codigo = ler.nextInt();
            if (codigo == 0) {
                return;
            }

            if (pesquisarRevista(codigo) != null) {
                System.out.println("\n\n--- Revista j� adicionada ---\n");
                continue;
            }

            ler.nextLine();
            System.out.print("T�tulo da Revista: ");
            String titulo = ler.nextLine();

            revistas.add(new Revista(codigo, titulo));
            System.out.println("\n\n--- A revista foi adicionada ---\n");
        }
    }

    public static void adicionarEdicaoRevista() {
        System.out.println("\n\n*** Adicionar Edi��o da Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a fun��o '1' do menu ---\n");
            return;
        }
        while(true) {
            System.out.print("\nInsira o c�digo da revista desejada (ou '0' para finalizar fun��o): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                return;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);
            if ( revistaEncontrada == null) {
                System.out.println("\n\n--- Este c�digo n�o existe ---\n");
                continue;
            }

            while(true) {
                ler.nextLine();
                System.out.print("N�mero da Edi��o (ou '0' para finalizar fun��o): ");
                int numero = ler.nextInt();
                if (numero == 0) {
                    break;
                }
                
                if (pesquisarEdicao(numero, revistaEncontrada ) != null) {
                   System.out.println("\n\n--- O n�mero de edi��o passado j� existe na revista ---\n");
                   continue;
                }
                
                System.out.print("Tiragem: ");
                int tiragem = ler.nextInt();
                System.out.print("Vendidas: ");
                int vendidas = ler.nextInt();

                Edicao edicao = new Edicao(numero, new Date(), tiragem, vendidas);
                revistaEncontrada.adicionaEdicao(edicao);

                System.out.println("\n\n--- A edi��o foi adicionada ---\n");
            }
        }
    }

    public static Edicao pesquisarEdicao (int numEdicao, Revista revista) {
        for (Edicao edicao : revista.getEdicoes()) {
            if(edicao.getNum() == numEdicao) {
                return edicao;
            }
        }
        return null;
    }

    public static void removerEdicaoRevista() {
        System.out.println("\n\n*** Remover Edi��o da Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a fun��o '1' do menu ---\n");
            return;
        }

        while(true) {
            System.out.print("\nInsira o c�digo da revista desejada (ou '0' para finalizar fun��o): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                break;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);

            if ( revistaEncontrada == null) {
                System.out.println("\n\n--- Este c�digo n�o existe ---\n");
                continue;
            }

            if (revistaEncontrada.getEdicoes().size() == 0) {
                System.out.println("\n\n--- Nenhuma edi��o foi adicionada � esta revista ---\n");
                System.out.println("\n--- Utilize a fun��o '2' do menu ---\n");
                return;
            }

            while(true) {
                System.out.print("\nInsira o n�mero da edi��o que deseja remover (ou '0' para finalizar): ");
                int numero = ler.nextInt();
                if (numero == 0) {
                	break;
                }

                Edicao edicaoEncontrada = pesquisarEdicao(numero, revistaEncontrada);

                if (edicaoEncontrada == null) {
                    System.out.println("\n\n--- Esta edi��o n�o existe ---\n");
                    continue;
                }
                else {
                    revistaEncontrada.removeEdicao(edicaoEncontrada);
                    System.out.println("\n\n--- A edi��o foi removida ---");
                    break;
                }
            }
        }
    }

    public static void reciclarEdicao() {
        System.out.println("\n\n*** Reciclar Edi��o da Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a fun��o '1' do menu ---\n");
            return;
        }

        while(true) {
            System.out.print("\nInsira o c�digo da revista onde o exemplar ser� reciclado (ou '0' para finalizar fun��o): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                break;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);

            if (revistaEncontrada == null) {
                System.out.println("\n\n--- Este c�digo n�o existe ---\n");
                continue;
            }

            if (revistaEncontrada.getEdicoes().size() == 0) {
                System.out.println("\n\n--- Nenhuma edi��o foi adicionada � esta revista ---\n");
                System.out.println("\n--- Utilize a fun��o '2' do menu ---\n");
                return;
            }

            while (true) {
                System.out.print("\nInsira o n�mero da edi��o que deseja reciclar (ou '0' para finalizar): ");
                int numero = ler.nextInt();
                if (numero == 0) {
                	break;
                }

                Edicao edicaoEncontrada = pesquisarEdicao(numero, revistaEncontrada);

                if (edicaoEncontrada == null) {
                    System.out.println("\n\n--- Esta edi��o n�o existe ---\n");
                    continue;
                }
                if (edicaoEncontrada.isReciclagemAtualizada() == true) {
                    System.out.println("\n\n--- Voc� n�o pode reciclar uma edi��o que j� foi reciclada ---\n");
                    continue;
                }

                System.out.println("\n\n--- A quantidade de reciclagem desta edi��o �: " + edicaoEncontrada.qtdeRecicladas() + " ---\n");

                revistaEncontrada.setReciclagemProduzida(revistaEncontrada.getReciclagemProduzida() + edicaoEncontrada.qtdeRecicladas());

                System.out.println("\n\n--- A quantidade de reciclagem produzida pela revista foi incrementada ---\n");
                System.out.println("--- Agora a quantidade �: " + revistaEncontrada.getReciclagemProduzida() + " ---\n");

                edicaoEncontrada.setReciclagemAtualizada(true);
                System.out.println("\n\n--- A reciclagem desta edi��o foi atualizada ---\n");
            }
        }
    }

    public static void destruirRevista() {
        System.out.println("\n\n*** Destruir Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a fun��o '1' do menu ---\n");
            return;
        }

        while(true) {
            System.out.print("\nInsira o c�digo da revista desejada (ou '0' para finalizar fun��o): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                break;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);

            if (revistaEncontrada == null) {
                System.out.println("\n\n--- Este c�digo n�o existe ---\n");
                continue;
            }

            revistas.remove(revistaEncontrada);
            System.out.println("\n\n--- A revista foi destru�da ---\n");
        }
    }
}
