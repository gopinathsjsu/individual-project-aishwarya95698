import dao.Repository;
import model.Item;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExecuteOrderHelper {
    private Repository repository = Repository.getInstance();
    private double totalAmount = 0;
    private List<String> errorMessages = new ArrayList<>();
    private Map<String, Integer> order = new LinkedHashMap<String, Integer>();
    //Setting the capLimits of the category
    private int essential = 3;
    private int luxury =4;
    private int misc = 6;
    public void processOrder(String filePath, String outputFilePath){
        System.out.println("Processing Order");
        System.out.println("Stock repository: "+repository);
        int recordNumber =1;
        String cardNumber = "";
        String orderRecord = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));) {
            //Skipping Header
            bufferedReader.readLine();
            while ((orderRecord = bufferedReader.readLine()) != null)
            {
                String[] orderItem = orderRecord.split(",");
                String  itemName= orderItem[0].toLowerCase();
                int  requestedQuantity= Integer.parseInt(orderItem[1]);
                //Reading all the input orders to a Hash map
                order.put(itemName, order.getOrDefault(itemName, 0)+ requestedQuantity);
                if(recordNumber ==1){
                    cardNumber = orderItem[2];
                    recordNumber++;
                }
            }
            validateOrder();
            placeFinalOrder(cardNumber, outputFilePath);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

private void validateOrder(){
        for (Map.Entry<String, Integer> record :
                order.entrySet()){
            String itemName = record.getKey();
            int requestedQuantity = record.getValue();
            Item item = repository.getItem(itemName);
            if(item==null){
                errorMessages.add("Requested Item::"+itemName +"is not Available");
                break;
            }
            if(!validateStock(requestedQuantity, item)){
                break;
            }
            if(!validateCapLimit(requestedQuantity, item)){
                break;
            }
        }
}


    private boolean validateCapLimit(int requestedQuantity, Item item){
        String category = item.getCategory();
        boolean res = true;
        switch (category){
            case "Essentials": if(requestedQuantity > essential) {
                res=false;
            }else {
                    essential=essential-requestedQuantity;
                }
            break;
            case "Luxury":if(requestedQuantity > luxury) {
                res=false;
            }else {
                luxury=luxury-requestedQuantity;
            }
                break;
            case "Misc": if(requestedQuantity > misc) {
                res=false;
            }else {
                misc=misc-requestedQuantity;
            }
                break;
        }
        if(!res){
            String  error ="ItemName=== "+ item.getItemName()+ " === category: " + category
                   +" Can not me more than the Allowed Cap Limit";
            errorMessages.add(error);
        }
        return res;
    }

    private boolean validateStock(int requestedQuantity, Item item){
        if(item.getQuantity()<requestedQuantity) {
            String  error ="ItemName==="+ item.getItemName()
                    +"=== stock not available";
            errorMessages.add(error);
            return false;
        }
        return true;
    }

    private void placeFinalOrder(String cardNumber,
                                 String outputFilePath){
        String outPutFile = errorMessages.size()==0?"output.csv":"output.txt";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath+outPutFile))) {
        if(errorMessages.size()==0){
            //Adding Card to Repo if card is not present
            if (!repository.getCards().contains(cardNumber)){
                repository.getCards().add(cardNumber);
                String addCard ="CardNumber not present in database Added Card to database CardNumber:" + cardNumber;
                System.out.println(addCard);
                System.out.println("Available Cards in DataBase");
                for (String cardNo: repository.getCards()){
                    System.out.println(cardNo);
                }
            }
            bufferedWriter.write("itemName,requestedQuantity,total\n");
            for (Map.Entry<String, Integer> record :
                    order.entrySet()){
                String itemName = record.getKey();
                int requestedQuantity = record.getValue();
                Item item = repository.getItem(itemName);
                totalAmount =totalAmount+item.getPrice()*requestedQuantity;
                item.setQuantity(item.getQuantity()-requestedQuantity);
                bufferedWriter.write(itemName+","+requestedQuantity+","+item.getPrice()*requestedQuantity+"\n");
            }
            bufferedWriter.write("Amount Paid\n");
            bufferedWriter.write(""+totalAmount);
            System.out.println("Amount Paid");
            System.out.println(totalAmount);
        }else {
            System.out.println("Please correct the following Item");
            bufferedWriter.write("Please correct the following Item\n");
            for (String errorMessage:errorMessages){
                bufferedWriter.write(errorMessage+"\n");
                System.out.println(errorMessage);
            }
        }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}

