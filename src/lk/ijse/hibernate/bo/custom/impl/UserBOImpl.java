package lk.ijse.hibernate.bo.custom.impl;

import lk.ijse.hibernate.bo.custom.UserBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.UserDAO;
import lk.ijse.hibernate.dto.LoginDTO;
import lk.ijse.hibernate.entity.Loging;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public ArrayList<LoginDTO> getAllUsers() throws SQLException, ClassNotFoundException {
        ArrayList<Loging> all = userDAO.getAllUsers();
        ArrayList<LoginDTO> allUSer = new ArrayList<>();
        for (Loging users : all) {
            allUSer.add(new LoginDTO(users.getUserID(), users.getName(), users.getAddress(), users.getContact_no(), users.getPassword(), users.getGender()));
        }
        return allUSer;
    }

    @Override
    public ArrayList<LoginDTO> searchAllUser(String id) throws SQLException, ClassNotFoundException {
        Loging all = userDAO.search(id);
        ArrayList<LoginDTO> allUsersSearch = new ArrayList<>();
        allUsersSearch.add(new LoginDTO(all.getUserID(), all.getName(), all.getAddress(), all.getContact_no(), all.getPassword(), all.getGender()));
        return allUsersSearch;
    }

    @Override
    public boolean saveUser(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new Loging(dto.getUserID(), dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getPassword(), dto.getGender()));
    }

    @Override
    public boolean updateUser(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new Loging(dto.getUserID(), dto.getName(), dto.getAddress(), dto.getContact_no(), dto.getPassword(), dto.getGender()));
    }

    @Override
    public boolean deleteUser(String id) throws SQLException, ClassNotFoundException {
        return userDAO.delete(id);
    }

    @Override
    public boolean existUser(String id) throws SQLException, ClassNotFoundException {
        return userDAO.exist(id);
    }
}
