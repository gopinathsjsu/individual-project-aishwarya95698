package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardDataReader implements DataReader {
    private Repository repository = Repository.getInstance();
    @Override
    public void readFile(String filePath) {
        String cardNumber = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));) {
            //Skipping CSV Header
            bufferedReader.readLine();
            while ((cardNumber = bufferedReader.readLine()) != null)
            {
                repository.getCards().add(cardNumber);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
