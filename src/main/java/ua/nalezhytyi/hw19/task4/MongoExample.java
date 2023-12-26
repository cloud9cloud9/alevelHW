package ua.nalezhytyi.hw19.task4;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoExample {
    public static void main(String[] args) {
        MongoCollection<Document> table = createTable(getConnection());
        Address address = new Address("New York", "Brain st.");
        create(table, "Oleksiy", 22, address);
        //read(table);
        //update(table, 48, null, "Oleksiy");
        //delete(table,"Oleksiy");


    }

    private static MongoDatabase getConnection() {
        MongoClient mongoClient = MongoClients.create("mongodb://admin:admin123@localhost:27017");
        return mongoClient.getDatabase("test");
    }

    private static MongoCollection<Document> createTable(MongoDatabase database) {
        return database.getCollection("person");
    }

    private static void create(MongoCollection<Document> collection, String name, int age, Address address) {
        Document doc = new Document();
        doc.append("name", name)
                .append("age", age)
                .append("address", new Document("city", address.getCity())
                        .append("street", address.getStreet()));
        collection.insertOne(doc);
    }

    private static void read(MongoCollection collection) {
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.cursor();
        while (cursor.hasNext()) {
            Document next = cursor.next();
            System.out.println(next);
        }
    }

    private static void update(MongoCollection<Document> collection, Integer newAge, String newName, String name) {
        Document search = collection.find(new Document("name", name)).first();

        if (search != null) {
            Bson updateFields = new Document();

            if (newAge != null) {
                ((Document) updateFields).put("age", newAge);
            }
            if (newName != null) {
                ((Document) updateFields).put("name", newName);
            }
            Bson updateOperation = new Document("$set", updateFields);

            if (!((Document) updateFields).isEmpty()) {
                collection.updateOne(search, updateOperation);
            }
        }
    }

    private static void delete(MongoCollection<Document> collection, String name) {
        Document delete = collection.find(new Document("name", name)).first();
        DeleteResult result = collection.deleteOne(delete);
    }
}
