import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Gasto> ListaGasto;
    private List<Ganho> ListaGanho;

    public Banco() {
        ListaGasto = new ArrayList<>();
        ListaGanho = new ArrayList<>();
    }

    public void armazenarGasto(Gasto gasto){
        ListaGasto.add(gasto);
    }

    public List<Gasto> getListaGasto(){
        return ListaGasto;
    }

    public void armazenarGanho(Ganho ganho){
        ListaGanho.add(ganho);
    }

    public List<Ganho> getListaGanho(){
        return ListaGanho;
    }
}
