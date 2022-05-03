package dao;

import model.Item;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * Singleton class to store the Data
 */
public class Repository {
    private static Repository repository;
    private  HashSet<String> cardsStorage = new HashSet<String>();
    private  HashMap<String, Item> itemStorage = new HashMap<String, Item>();
    //Implementation of singleton design pattern
    private Repository() {
    }
    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public HashSet<String> getCards() {
        return this.cardsStorage;
    }

    public Item getItem(String itemName) {
        return this.itemStorage.get(itemName);
    }

    public HashMap<String, Item> getItemStorage() {
        return this.itemStorage;
    }
}
