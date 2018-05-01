package bookstore.report;

import bookstore.data.entity.Book;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFReport implements Strategy {

    @Override
    public void generateReport(String fileName, List<Book> bookList) throws IOException {
        File file = new File(fileName);
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

        //Adding text in the form of string
        for(int i=0; i<bookList.size(); i++) {
            contentStream.showText(bookList.get(i).getIsbn());
            contentStream.newLine();
        }
        //Ending the content stream
        contentStream.endText();

        //Closing the content stream
        contentStream.close();

        //Saving the document
        doc.save(new File(fileName));

        //Closing the document
        doc.close();

    }
}
