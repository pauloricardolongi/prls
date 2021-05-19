package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre com os dados do cliente");
		System.out.print("Nome");
		String nome = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("data nascimento (DD/MM/YYYY)");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(nome, email, birthDate);
		System.out.println("Entre com status-PROCESSING");
		System.out.print("Status: ");
		OrderStatus status= OrderStatus.valueOf(sc.next());
		
		Order order= new Order(new Date(), status, client);
		
        System.out.println("Quantos itens o pedido vai ter");
        int N= sc.nextInt();
        for (int i=0; i<N; i++) {
        	System.out.println("Entre #"+ (i+1)+ " dados item");
        	System.out.print("Nome do produto:");
        	sc.nextLine();
        	String productName= sc.nextLine();
        	System.out.print("Informe o preço do produto");
        	double productPrice= sc.nextDouble();
        	System.out.print("Quantidade");
        	int quanty= sc.nextInt();
        	//instanciar o produto
        	Product product = new Product(productName, productPrice);
        	//instanciar o ItemPedido associado a objeto produto
        	OrderItem it= new OrderItem(quanty, productPrice, product); 
        	//adicionar ItemPedido dentro da lista de itens do meu pedido
        	//instanciar depois do OrderStatus
        	
        	order.addItem(it);
        }
        System.out.println();
        System.out.println(order);
        
		sc.close();
	}

}
