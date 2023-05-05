//import java.util.ArrayList;
import java.util.List;

public class Ganho {
    private String dataGanho;
    private float valorGanho;
    private TipoGanho tipo;

    public Ganho (String dataGanho, float valorGanho, TipoGanho tipo){
        setData(dataGanho);
        setValor(valorGanho);
        setTipoGanho(tipo);
    }

    public void setData(String dataGanho){
        this.dataGanho = dataGanho;
    }
    public void setValor(float valorGanho){
        this.valorGanho = valorGanho;
    }

    public String getData(){
        return dataGanho;
    }
    public float getValor(){
        return valorGanho;
    }

    public void setTipoGanho(TipoGanho tipo){
        this.tipo = tipo;
    }
    public TipoGanho getTipo(){
        return tipo;
    }

    public void RelatorioGanho(List<Ganho> listaGanho){
        List<TipoGanho> ListaTiposGanho = TipoGanho.getListaGanho();
        float[] relatorioGanho = new float[ListaTiposGanho.size()];
    
        for(int i = 0; i < ListaTiposGanho.size(); i++){
            TipoGanho tipo = ListaTiposGanho.get(i);
            float total = 0;

            Banco banco = new Banco();
            List<Ganho> ListaGanho = banco.getListaGanho();  
    
            for(Ganho ganho : ListaGanho){
                if(ganho.getTipo().equals(tipo)){
                    total += ganho.getValor();
                }
            }
            relatorioGanho[i] = total;
        }
    
        System.out.println("Relatório Mensal de Ganhos");
        for(int i = 0; i < ListaTiposGanho.size(); i++){
            TipoGanho tipo = ListaTiposGanho.get(i);
            System.out.println(tipo.getTipo());
    
            float total = relatorioGanho[i];
            System.out.printf("\tR$ %.2f\n", total);
        }
    }
}