import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Banco banco = new Banco();
        while (true) {
            System.out.println("");
            System.out.println("1 - Adicionar Gasto");
            System.out.println("2 - Adicionar Ganho");
            System.out.println("3 - Relatório de Gastos");
            System.out.println("4 - Relatório de Ganhos");
            System.out.println("5 - Relatório Mensal");
            System.out.println("0 - Sair");
            int opcao = input.nextInt();
            input.nextLine();
            System.out.println("");
            switch (opcao) {
                case 1:
                    System.out.println("Digite a data do gasto: ");
                    String data = input.nextLine();
                    System.out.println("Digite o valor do gasto: ");
                    float valor = input.nextFloat();
                    input.nextLine();

                    System.out.println("Digite o tipo de gasto (Habitação, Entretenimento, Alimentação, Transporte): ");
                    //String tipoGasto = input.nextLine();

                    String tipoGasto = "";

                    System.out.println("");
                    System.out.println("1 - Habitação");
                    System.out.println("2 - Entretenimento");
                    System.out.println("3 - Alimentação");
                    System.out.println("4 - Transporte");
                    int opcaoTipoGasto = input.nextInt();
                    input.nextLine();
                    System.out.println("");

                    switch (opcaoTipoGasto) {
                        case 1:
                            tipoGasto = "Habitacao";
                            break;
                        case 2:
                            tipoGasto = "Entretenimento";
                            break;
                        case 3:
                            tipoGasto = "Alimentacao";
                            break;
                        case 4:
                            tipoGasto = "Transporte";
                            break;
                    }

                    System.out.println("Digite a forma de pagamento: ");
                    //String formaPagamento = input.nextLine();

                    String formaPagamento = "";

                    System.out.println("");
                    System.out.println("1 - Cheque");
                    System.out.println("2 - Pix");
                    System.out.println("3 - Débito");
                    int opcaoFormaGasto = input.nextInt();
                    input.nextLine();
                    System.out.println("");

                    switch (opcaoFormaGasto) {
                        case 1:
                            formaPagamento = "Cheque";
                            break;
                        case 2:
                            formaPagamento = "Pix";
                            break;
                        case 3:
                            formaPagamento = "Debito";
                            break;
                    }
                    
                    //System.out.println("");
                    Gasto gasto = new Gasto(data, valor, new TipoGasto(tipoGasto), new FormaPagamento(formaPagamento));
                    banco.armazenarGasto(gasto);
                    break;

                case 2:
                    System.out.println("Digite a data do ganho (Salário, Freelancer, Dividendos): ");
                    String dataGanho = input.nextLine();

                    System.out.println("Digite o valor do ganho: ");
                    float valorGanho = input.nextFloat();

                    input.nextLine(); 

                    System.out.println("Digite o tipo de ganho: ");

                    String tipoGanho = "";

                    System.out.println("");
                    System.out.println("1 - Salário");
                    System.out.println("2 - Freelancer");
                    System.out.println("3 - Dividendos");
                    int opcaoTipoGanho = input.nextInt();
                    input.nextLine();
                    System.out.println("");

                    switch (opcaoTipoGanho) {
                        case 1:
                            tipoGanho = "Salario";
                            break;
                        case 2:
                            tipoGanho = "Freelancer";
                            break;
                        case 3:
                            tipoGanho = "Dividendos";
                            break;
                    }

                    Ganho ganho = new Ganho(dataGanho, valorGanho, new TipoGanho(tipoGanho));
                    banco.armazenarGanho(ganho);
                    break;
            
                case 3:
                    System.out.println("Relatório Mensal de Gastos");
                    System.out.println("--------------------------");
                    List<Gasto> listaGastos = banco.getListaGasto();
                    for (TipoGasto tipo : TipoGasto.getListaGasto()) {
                        System.out.println(tipo.getTipo());
                        for (FormaPagamento forma : FormaPagamento.getFormaPagamento()) {
                            float totalGasto = 0;
                            for (Gasto g : listaGastos) {
                                if (g.getTipo().getTipo().equals(tipo.getTipo()) && g.getForma().getForma().equals(forma.getForma())) {
                                    totalGasto += g.getValor();
                                }
                            }
                            System.out.printf("\t%s: R$ %.2f\n", forma.getForma(), totalGasto);
                        }
                    }
                    System.out.println("");
                    System.out.println("Histórico de Gastos");
                    System.out.println("--------------------");
                    List<Gasto> listaGasto = banco.getListaGasto();
                    for(Gasto g : listaGasto){
                        System.out.printf("%s - Tipo: %s, Valor: R$ %.2f\n", g.getData(), g.getTipo().getTipo(), g.getValor());
                    }
                    break;
                    
                case 4:
                    System.out.println("Relatório Mensal de Ganhos");
                    System.out.println("--------------------------");
                    List<Ganho> listaGanhos = banco.getListaGanho();
                    for (TipoGanho tipo : TipoGanho.getListaGanho()) {
                        System.out.println(tipo.getTipo());
                        float totalGanho = 0;
                        for (Ganho g : listaGanhos) {
                            if (g.getTipo().getTipo().equals(tipo.getTipo())) {
                                totalGanho += g.getValor();
                            }
                        }
                        System.out.printf("\tTotal: R$ %.2f\n", totalGanho);
                    }
                    System.out.println("");
                    System.out.println("Histórico de Ganhos");
                    System.out.println("-------------------");
                    List<Ganho> listaGanho = banco.getListaGanho();
                    for(Ganho g : listaGanho){
                        System.out.printf("%s - Tipo: %s, Valor: R$ %.2f\n", g.getData(), g.getTipo().getTipo(), g.getValor());
                    }
                    break;

                case 5:
                    Relatorio.saldoMensal(banco);
                    break;
                 
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
