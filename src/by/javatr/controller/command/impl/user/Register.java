package by.javatr.controller.command.impl.user;

import by.javatr.controller.command.Command;
import by.javatr.entity.Role;
import by.javatr.entity.User;
import by.javatr.service.ClientService;
import by.javatr.exception.ServiceException;
import by.javatr.factory.ServiceFactory;

public class Register implements Command {
    @Override
    public String execute(String request) throws ServiceException {
        String text = request.trim();
        String[] words = text.split(" ");
        String name = words[1];
        String surname = words[2];
        String login = words[3];
        String password = words[4];
        Role role;
        User user;

        text = text.toUpperCase();
        if (text.contains("ADMIN")) {
            role = Role.ADMIN;
        }
        else role = Role.READER;

        user = new User(name, surname, login, password, role);

        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getUserService();

        try {
            clientService.registerUser(user);
            response = "You are registered";

        } catch (ServiceException e) {
            throw new ServiceException(e);

        }
        return response;
    }
}
