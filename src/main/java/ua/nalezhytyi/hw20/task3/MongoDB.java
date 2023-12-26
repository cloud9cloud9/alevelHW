package ua.nalezhytyi.hw20.task3;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.BSON;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDB {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://admin:admin123@localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("humans");
        Document doc = new Document();
        //create human
        doc.append("name", "Zoya")
                .append("age", 21)
                .append("city", "London")
                .append("profession", "Manager")
                .append("Sex", "female");
        //collection.insertOne(doc);

        //read human
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.cursor();
        while (cursor.hasNext()) {
            Document next = cursor.next();
            System.out.println(next);
        }
//update
        Document search = collection.find(new Document("name", "Max Zivert")).first();
        if(search != null){
            System.out.println("Document found: " + search);
            Bson updateValue = new Document("age", "33");
            Bson updateOperation = new Document("$set", updateValue);
            collection.updateOne(search, updateOperation);
            System.out.println("user updated: " + search);
        }
//delete
        Document delete = collection.find(new Document("name", "Zoya")).first();
        DeleteResult result = collection.deleteOne(delete);
    }
}
