package dao;

import model.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ItemDataReader implements DataReader {
    private Repository repository = Repository.getInstance();
    private static final String DELIMITER = ",";

    @Override
    public void readFile(String filePath) {
        String currentLine = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            //Skipping CSV Header
            bufferedReader.readLine();
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] itemData = currentLine.split(DELIMITER);
                String itemName = itemData[0].toLowerCase();
                //Creating an Object using builder design pattern
                Item item = new Item.ItemBuilder()
                        .category(itemData[1]).itemName(itemName)
                        .quantity(Integer.parseInt(itemData[2]))
                        .price(Double.parseDouble(itemData[3])).build();
                repository.getItemStorage().put(itemName, item);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
