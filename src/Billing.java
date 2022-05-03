import dao.DataReader;
import factory.ReaderFactory;

import java.util.Scanner;

public class Billing {

    private static final String itemFilePath ="/home/aishu/CMPE202/individual-project-aishwarya95698/resources/stock.csv";
    private static final String cardFilePath ="/home/aishu/CMPE202/individual-project-aishwarya95698/resources/cards.csv";
    private static final String outputFilePath ="/home/aishu/CMPE202/individual-project-aishwarya95698/resources/";

    public static void main(String[] args) {
        ReaderFactory readerFactory = new ReaderFactory();
        DataReader itemDataReader = readerFactory.getInstance("ITEM");
        DataReader cardDataReader = readerFactory.getInstance("CARD");
        itemDataReader.readFile(itemFilePath);
        cardDataReader.readFile(cardFilePath);
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter Input File Path");
        String inputFile = in.nextLine();
        ExecuteOrderHelper helper = new ExecuteOrderHelper();
        helper.processOrder(inputFile, outputFilePath);
    }

}
