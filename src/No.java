public class No {
    private Client pessoa;
    private No prox;

    public No(String name, int age) {
        pessoa = new Client(name, age);
        prox = null;
    }

    public Client getClient() {
        return pessoa;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}