package commande;

public interface CommandCreate<T> extends Icommande {
	T execute();
}
