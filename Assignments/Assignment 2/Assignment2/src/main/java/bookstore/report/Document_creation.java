package bookstore.report;

import bookstore.business.service.BookService;
import bookstore.data.entity.Book;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Document_creation {

    public static void main (String args[]) throws IOException {
        //"C:/Projects/NewHope3/my_doc.pdf
        //C:/Projects/NewHope4/my_doc.pdf
        //Creating PDF document object
        //Loading an existing document
        //Loading an existing document
        BookService bookService=null;
        File file = new File("C:/Projects/NewHope4/my_doc.pdf");
        PDDocument doc = PDDocument.load(file);

        //Creating a PDF Document
        PDPage page = doc.getPage(1);

        PDPageContentStream contentStream = new PDPageContentStream(doc, page);

        //Begin the Content stream
        contentStream.beginText();

        //Setting the font to the Content stream
        contentStream.setFont( PDType1Font.TIMES_ROMAN, 16 );

        //Setting the leading
        contentStream.setLeading(14.5f);

        //Setting the position for the line
        contentStream.newLineAtOffset(25, 725);

        List<Book> bookList = bookService.getAll();

        String text1 = "This is an example of adding text to a page in the pdf document. we can add as many lines";
        String text2 = "as we want like this using the ShowText()  method of the ContentStream class";

        //Adding text in the form of string
        contentStream.showText(text1);
        contentStream.newLine();
        contentStream.showText(text2);
        //Ending the content stream
        contentStream.endText();

        System.out.println("Content added");

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File("C:/Projects/NewHope4/my_doc.pdf"));

        //Closing the document
        doc.close();


        //Creating PDF document object
        /*PDDocument document = new PDDocument();

        for (int i=0; i<10; i++) {
            //Creating a blank page
            PDPage blankPage = new PDPage();

            //Adding the blank page to the document
            document.addPage( blankPage );
        }

        //Saving the document
        document.save("C:/Projects/NewHope4/my_doc.pdf");
        System.out.println("PDF created");

        //Closing the document
        document.close();
        */
    }

}


