import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookManagement {
    public static void main(String[] args) {
        // For JSON file
        readDataFromJSONFile("D:\\Afridah\\Booklist.json");
    }

    // JSON file reader method
    static void readDataFromJSONFile(String filepath) {
        int count = 0;
        int totalPages = 0;
        try {
            // Creating ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Reading the JSON file and converting it to a list of Book objects
            List<Book> books = objectMapper.readValue(new File(filepath), new TypeReference<List<Book>>() {});

            // Calculating total books and total pages
            for (Book book : books) {
                count++;
                totalPages += book.getPages();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Number of books she read in a year: " + count);
        System.out.println("Average length: " + totalPages / count);
    }
}