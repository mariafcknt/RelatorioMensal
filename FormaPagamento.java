import java.util.ArrayList;
import java.util.List;

public class FormaPagamento {
    private String forma;

    public FormaPagamento(String forma){
        setForma(forma);
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getForma(){
        return forma;
    }

    public static List<FormaPagamento> getFormaPagamento(){
        List<FormaPagamento> ListaFormaPagamento = new ArrayList<>();
        ListaFormaPagamento.add(new FormaPagamento("Cheque"));
        ListaFormaPagamento.add(new FormaPagamento("Pix"));
        ListaFormaPagamento.add(new FormaPagamento("Debito"));
        return ListaFormaPagamento;
    };
}
