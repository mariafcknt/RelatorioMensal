//import java.util.ArrayList;
import java.util.List;

public class Gasto {
    private String data;
    private float valor;
    private TipoGasto tipo;
    private FormaPagamento forma;

    public Gasto (String data, float valor, TipoGasto tipo, FormaPagamento forma){
        setData(data);
        setValor(valor);
        setTipoGasto(tipo);
        setFormaPagamento(forma);
    }

    public void setData(String data){
        this.data = data;
    }
    public void setValor(float valor){
        this.valor = valor;
    }

    public String getData(){
        return data;
    }
    public float getValor(){
        return valor;
    }

    public void setTipoGasto(TipoGasto tipo){
        this.tipo = tipo;
    }
    public TipoGasto getTipo(){
        return tipo;
    }

    public void setFormaPagamento(FormaPagamento forma){
        this.forma = forma;
    }
    public FormaPagamento getForma(){
        return forma;
    }

    public void RelatorioGasto(List<Gasto> listaGasto){
        List<TipoGasto> ListaTiposGasto = TipoGasto.getListaGasto();
        List<FormaPagamento> ListaFormaPagamento = FormaPagamento.getFormaPagamento();
        float[][] relatorioGasto = new float[ListaTiposGasto.size()][ListaFormaPagamento.size()];
    
        for(int i = 0; i < ListaTiposGasto.size(); i++){
            TipoGasto tipo = ListaTiposGasto.get(i);
    
            for(int j = 0; j < ListaFormaPagamento.size(); j++){
                FormaPagamento forma = ListaFormaPagamento.get(j);
                float total = 0;

                Banco banco = new Banco();
                List<Gasto> ListaGasto = banco.getListaGasto();  
    
                for(Gasto gasto : ListaGasto){
                    if(gasto.getTipo().equals(tipo) && gasto.getForma().equals(forma)){
                        total += gasto.getValor();
                    }
                }
                relatorioGasto[i][j] = total;
            }
        }
    
        System.out.println("Relatório Mensal de Gastos");
        for(int i = 0; i < ListaTiposGasto.size(); i++){
            TipoGasto tipo = ListaTiposGasto.get(i);
            System.out.println(tipo.getTipo());
    
            for(int j = 0; j < ListaFormaPagamento.size(); j++){
                FormaPagamento forma = ListaFormaPagamento.get(j);
                float total = relatorioGasto[i][j];
                System.out.printf("\t%s: R$ %.2f\n", forma.getForma(), total);
            }
        }
    }
}
