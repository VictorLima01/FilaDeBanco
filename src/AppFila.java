import java.util.Scanner;

public class AppFila {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        boolean isFinished = false;
        String name;
        int age;
        int cont = 0;
        ManageAttendance fila = new ManageAttendance(5);
        while(!isFinished){
            System.out.println("<---------------------------------Sumário----------------------->\n" +
                    "1 – Chegada do cliente na agência\n" +
                    "2 – Verificar quem é o próximo a ser atendido\n" +
                    "3 – Atender um cliente (ao atender o cliente, o nomee a idade dele deve ser apresentada)\n" +
                    "4 – Exibir as filas (idoso e não idoso)\n" +
                    "5 – Finalizar o programa (que só poderá ser finalizadocaso não tenha mais clientes aguardando)\n");
            System.out.print("Opção:" );
            opcao = scanner.nextInt();
            if(opcao == 1){

                System.out.print("Name: ");
                name = scanner.next();
                System.out.print("Idade: ");
                age = scanner.nextInt();
                if(age < 16){
                    age = 18;
                }
                cont++;
                if(cont > fila.size){
                    System.out.println("A fila está cheia, novo cliente não foi inserido ");
                }else{
                    fila.addClient(name, age);
                }

            }else if(opcao == 2){
                System.out.println("Primeiro da fila: " + fila.showNext());
            }else if(opcao == 3){
                while (!fila.isEmpty()) {
                    System.out.println("Cliente "+ fila.getNext() + " foi atendido");
                }
            }else if(opcao == 4){
                if(fila.isEmpty()){
                    System.out.println(fila.showQueues() + "vazia");
                }else{
                    System.out.println("Na fila temos: " + fila.numClients() + " clientes");
                    System.out.println("Na fila temos: " + fila.numElderlyClients() + " clientes idosos");
                    System.out.println(fila.showQueues());
                }

            }else if(opcao == 5){
                if(!fila.isEmpty()){
                    isFinished = false;
                    System.out.println("Não pode terminar enquanto há clientes para atender");
                }else{
                    isFinished = true;
                }

            }else if(opcao != 1 || opcao != 2 || opcao != 3 || opcao != 4 || opcao != 5){
                System.out.println("Digite uma opção válida");
            }

        }

    }
}