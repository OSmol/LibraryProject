package by.javatr.controller.command.impl.user;

import by.javatr.controller.command.Command;
import by.javatr.service.ClientService;
import by.javatr.service.exception.ServiceException;
import by.javatr.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String text = request.trim();
        String[] words = text.split(" ");
        //if (words.length<3) throw new Exception(" ");
        String login = words[1];
        String password = words[2];
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getUserService();

        try{
            clientService.signIn(login, password);
            response= "Welcome";
        }
        catch(ServiceException e){
            response = "Error during login procedure";
        }
        return response;
    }
}