import java.util.ArrayList;
import java.util.List;

public class TipoGasto {
    private String tipo;

    public TipoGasto(String tipo){
        setTipo(tipo);
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public static List<TipoGasto> getListaGasto(){
        List<TipoGasto> ListaTiposGasto = new ArrayList<>();
        ListaTiposGasto.add(new TipoGasto("Habitacao"));
        ListaTiposGasto.add(new TipoGasto("Entretenimento"));
        ListaTiposGasto.add(new TipoGasto("Alimentacao"));
        ListaTiposGasto.add(new TipoGasto("Transporte"));
        return ListaTiposGasto;
    };
}
