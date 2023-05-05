import java.util.ArrayList;
import java.util.List;

public class TipoGanho {
    private String tipo;

    public TipoGanho(String tipo){
        setTipo(tipo);
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public static List<TipoGanho> getListaGanho(){
        List<TipoGanho> ListaTiposGanho = new ArrayList<>();
        ListaTiposGanho.add(new TipoGanho("Salario"));
        ListaTiposGanho.add(new TipoGanho("Freelancer"));
        ListaTiposGanho.add(new TipoGanho("Dividendos"));
        return ListaTiposGanho;
    };
}


