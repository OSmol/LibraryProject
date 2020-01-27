package by.javatr.controller.command.impl.user;

import by.javatr.controller.command.Command;
import by.javatr.service.ClientService;
import by.javatr.service.exception.ServiceException;
import by.javatr.service.factory.ServiceFactory;

public class GetUserByLogin implements Command {
    @Override
    public String execute(String request) {
        String text = request.trim();
        String[] words = text.split(" ");
        //if (words.length<3) throw new Exception(" ");
        String login = words[1];
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getUserService();

        try {
            response = "User info:\n" + clientService.getUserByLogin(login);
        } catch (ServiceException e) {
            response = "No user info";
        }
        return response;
    }
}