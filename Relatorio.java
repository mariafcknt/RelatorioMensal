import java.util.List;

public class Relatorio {
    public static void saldoMensal(Banco banco) {
        List<Gasto> gastos = banco.getListaGasto();
        List<Ganho> ganhos = banco.getListaGanho();

        float totalGastos = 0;
        float totalGanhos = 0;

        for (Gasto gasto : gastos) {
            totalGastos += gasto.getValor();
        }

        for (Ganho ganho : ganhos) {
                totalGanhos += ganho.getValor();
        }
 
        float saldoMensal = totalGanhos - totalGastos;

        System.out.println("Relatório Mensal");
        System.out.println("----------------");
        System.out.printf("Total de Gastos: R$ %.2f\n", totalGastos);
        System.out.printf("Total de Ganhos: R$ %.2f\n", totalGanhos);
        System.out.printf("Saldo Mensal: R$ %.2f\n", saldoMensal);
    }
}

