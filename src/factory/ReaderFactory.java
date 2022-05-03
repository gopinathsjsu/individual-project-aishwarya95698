package factory;

import dao.CardDataReader;
import dao.DataReader;
import dao.ItemDataReader;

/**
 * Implementation of Factory Design Pattern
 */
public class ReaderFactory {

    public DataReader getInstance(String readerType){
        if (readerType.equals("ITEM")){
            return new ItemDataReader();
        }else if(readerType.equals("CARD")){
            return new CardDataReader();
        }else {
            throw new RuntimeException("Instance of of type not supported"+ readerType);
        }
    }
}
