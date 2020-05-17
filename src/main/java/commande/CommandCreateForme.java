package commande;
/**
 * interface CommandCreate pour c.
 * @author rabahallah yasmine.
 *
 * @param <T> un objet.
 */

public interface CommandCreateForme<T> extends Icommande {
  T execute();
}
