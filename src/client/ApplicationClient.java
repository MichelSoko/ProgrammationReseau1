package client;

public class ApplicationClient {

	public static void main(String args[]) {

		// 2) EXECUTER ApplicationClient (NE PAS OUBLIER DE LANCER ApplicationServeur AVANT)
		
		// paramètres à indiquer lors de l'execution
		// args[0] = localhost
		// args[1] = Nom de la personne recherché
		
		if (args.length != 2) {
			System.exit(0);
		}
		new Client(args[0], args[1]);

	}

}