public class ManageAttendance {
    private No inicio, fim;
    public int cont = 0;
    public int contIdoso = 0;

    public ManageAttendance(int size) {
        inicio = fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void addClient(String name, int age) {
        No novo = new No(name, age);
        cont++;
        if(age >= 60){
            contIdoso ++;
        }
        if(isEmpty()) {
            inicio = fim = novo;
        }else{
            //aponta o próximo do último para o novo No
            fim.setProx(novo);
            // movo o "fim" para o novo No
            fim = novo;

        }
    }
    public int numClients(){
        return cont;
    }
    public String showNext() {
        if(isEmpty()) {
            return "";
        }
        String tipoClient;
        if(inicio.getClient().isElderly()){
            tipoClient = "idoso:";
        }else{
            tipoClient = "normal:";
        }
        return tipoClient + inicio.getClient().getName() + ":" + inicio.getClient().getAge();
    }

    public String getNext() {
        if(isEmpty()) {
            return "";
        }

        No aux = inicio;
        // aponta o "inicio" para o próximo No
        inicio = inicio.getProx();

        if(inicio == null) { // se a fila ficou vazia
            fim = null;
        }
        String tipoClient;
        if(aux.getClient().isElderly()){
            tipoClient = "idoso:";
        }else{
            tipoClient = "normal:";
        }
        return tipoClient + aux.getClient().getName() + ":" + aux.getClient().getAge();
    }

    public String showQueues() {
        String saida = "Fila: ";
        No aux = inicio;

        while( aux != null) {
            if(aux.getClient().isElderly()){
                saida += "idoso:" + aux.getClient().getName() + ":" + aux.getClient().getAge() + "-";
                contIdoso ++;
            }else{
                saida += "normal:" + aux.getClient().getName() + ":" + aux.getClient().getAge() + "-";
            }

            aux = aux.getProx();
        }
        return saida;
    }
    public int numElderlyClients(){
        return contIdoso;
    }
}