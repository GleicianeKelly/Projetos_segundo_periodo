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
            System.out.println("\n*** Seletor de Opções ***");
            System.out.println();
            System.out.println("1 - Adicionar Revista");
            System.out.println("2 - Adicionar Edição na Revista");
            System.out.println("3 - Remover Edição de uma Revista");
            System.out.println("4 - Reciclar Edição");
            System.out.println("5 - Destruir Revista");
            System.out.println("0 - Finalizar");

            System.out.print("\nOpção: ");
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
                    System.out.println("\n--- Opção não existente  ---");
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
            System.out.print("Insira um código (ou '0' para finalizar função): ");
            int codigo = ler.nextInt();
            if (codigo == 0) {
                return;
            }

            if (pesquisarRevista(codigo) != null) {
                System.out.println("\n\n--- Revista já adicionada ---\n");
                continue;
            }

            ler.nextLine();
            System.out.print("Título da Revista: ");
            String titulo = ler.nextLine();

            revistas.add(new Revista(codigo, titulo));
            System.out.println("\n\n--- A revista foi adicionada ---\n");
        }
    }

    public static void adicionarEdicaoRevista() {
        System.out.println("\n\n*** Adicionar Edição da Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a função '1' do menu ---\n");
            return;
        }
        while(true) {
            System.out.print("\nInsira o código da revista desejada (ou '0' para finalizar função): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                return;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);
            if ( revistaEncontrada == null) {
                System.out.println("\n\n--- Este código não existe ---\n");
                continue;
            }

            while(true) {
                ler.nextLine();
                System.out.print("Número da Edição (ou '0' para finalizar função): ");
                int numero = ler.nextInt();
                if (numero == 0) {
                    break;
                }
                
                if (pesquisarEdicao(numero, revistaEncontrada ) != null) {
                   System.out.println("\n\n--- O número de edição passado já existe na revista ---\n");
                   continue;
                }
                
                System.out.print("Tiragem: ");
                int tiragem = ler.nextInt();
                System.out.print("Vendidas: ");
                int vendidas = ler.nextInt();

                Edicao edicao = new Edicao(numero, new Date(), tiragem, vendidas);
                revistaEncontrada.adicionaEdicao(edicao);

                System.out.println("\n\n--- A edição foi adicionada ---\n");
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
        System.out.println("\n\n*** Remover Edição da Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a função '1' do menu ---\n");
            return;
        }

        while(true) {
            System.out.print("\nInsira o código da revista desejada (ou '0' para finalizar função): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                break;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);

            if ( revistaEncontrada == null) {
                System.out.println("\n\n--- Este código não existe ---\n");
                continue;
            }

            if (revistaEncontrada.getEdicoes().size() == 0) {
                System.out.println("\n\n--- Nenhuma edição foi adicionada à esta revista ---\n");
                System.out.println("\n--- Utilize a função '2' do menu ---\n");
                return;
            }

            while(true) {
                System.out.print("\nInsira o número da edição que deseja remover (ou '0' para finalizar): ");
                int numero = ler.nextInt();
                if (numero == 0) {
                	break;
                }

                Edicao edicaoEncontrada = pesquisarEdicao(numero, revistaEncontrada);

                if (edicaoEncontrada == null) {
                    System.out.println("\n\n--- Esta edição não existe ---\n");
                    continue;
                }
                else {
                    revistaEncontrada.removeEdicao(edicaoEncontrada);
                    System.out.println("\n\n--- A edição foi removida ---");
                    break;
                }
            }
        }
    }

    public static void reciclarEdicao() {
        System.out.println("\n\n*** Reciclar Edição da Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a função '1' do menu ---\n");
            return;
        }

        while(true) {
            System.out.print("\nInsira o código da revista onde o exemplar será reciclado (ou '0' para finalizar função): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                break;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);

            if (revistaEncontrada == null) {
                System.out.println("\n\n--- Este código não existe ---\n");
                continue;
            }

            if (revistaEncontrada.getEdicoes().size() == 0) {
                System.out.println("\n\n--- Nenhuma edição foi adicionada à esta revista ---\n");
                System.out.println("\n--- Utilize a função '2' do menu ---\n");
                return;
            }

            while (true) {
                System.out.print("\nInsira o número da edição que deseja reciclar (ou '0' para finalizar): ");
                int numero = ler.nextInt();
                if (numero == 0) {
                	break;
                }

                Edicao edicaoEncontrada = pesquisarEdicao(numero, revistaEncontrada);

                if (edicaoEncontrada == null) {
                    System.out.println("\n\n--- Esta edição não existe ---\n");
                    continue;
                }
                if (edicaoEncontrada.isReciclagemAtualizada() == true) {
                    System.out.println("\n\n--- Você não pode reciclar uma edição que já foi reciclada ---\n");
                    continue;
                }

                System.out.println("\n\n--- A quantidade de reciclagem desta edição é: " + edicaoEncontrada.qtdeRecicladas() + " ---\n");

                revistaEncontrada.setReciclagemProduzida(revistaEncontrada.getReciclagemProduzida() + edicaoEncontrada.qtdeRecicladas());

                System.out.println("\n\n--- A quantidade de reciclagem produzida pela revista foi incrementada ---\n");
                System.out.println("--- Agora a quantidade é: " + revistaEncontrada.getReciclagemProduzida() + " ---\n");

                edicaoEncontrada.setReciclagemAtualizada(true);
                System.out.println("\n\n--- A reciclagem desta edição foi atualizada ---\n");
            }
        }
    }

    public static void destruirRevista() {
        System.out.println("\n\n*** Destruir Revista ***\n");
        if (revistas.size() == 0) {
            System.out.println("\n\n--- Nenhuma revista foi adicionada ainda ---\n");
            System.out.println("\n--- Utilize a função '1' do menu ---\n");
            return;
        }

        while(true) {
            System.out.print("\nInsira o código da revista desejada (ou '0' para finalizar função): ");
            int codigo = ler.nextInt();

            if (codigo == 0) {
                break;
            }

            Revista revistaEncontrada = pesquisarRevista(codigo);

            if (revistaEncontrada == null) {
                System.out.println("\n\n--- Este código não existe ---\n");
                continue;
            }

            revistas.remove(revistaEncontrada);
            System.out.println("\n\n--- A revista foi destruída ---\n");
        }
    }
}
