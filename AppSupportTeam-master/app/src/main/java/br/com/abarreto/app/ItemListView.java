package br.com.abarreto.app;

public class ItemListView {

    private String chamado;
    private String status;

    public ItemListView() {
        //
    }

    public ItemListView(String chamado, String status)
    {
        this.chamado = chamado;
        this.status = status;
    }

    public String getChamado() {
        return chamado;
    }

    public void setChamado(String chamado) {
        this.chamado = chamado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
