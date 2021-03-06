package by.javatr.service;

import by.javatr.entity.User;
import by.javatr.exception.ServiceException;

import java.util.List;

public interface ClientService {

    boolean signIn(String login, String password) throws ServiceException;

    void registerUser(User user) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    String getUserByLogin(String userLogin)throws ServiceException;

    boolean deleteUserByLogin(String login)throws ServiceException;

    boolean deleteAllUsers()throws ServiceException;


}
