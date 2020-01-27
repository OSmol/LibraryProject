package by.javatr.controller.command.impl.book;

import by.javatr.controller.command.Command;
import by.javatr.entity.Book;
import by.javatr.entity.User;
import by.javatr.service.BookService;
import by.javatr.service.exception.ServiceException;
import by.javatr.service.factory.ServiceFactory;

import java.util.List;

public class GetAllBooks implements Command {
    @Override
    public String execute(String request) {
        List<String> list = null;
        StringBuilder response  = new StringBuilder();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BookService bookService = serviceFactory.getBookService();

        try{
            list = bookService.getBooksList();
            response.append("List of books:\n");
            for (String book : list) {
                response.append(book);
                response.append("\n");
            }
        }catch(ServiceException e){
            response.append("Could not show all books");
        }
        return response.toString();
    }
}