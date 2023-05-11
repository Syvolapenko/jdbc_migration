package com.Goit11.Client;


import com.Goit11.Databases.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ClientService {
    public Database database;
    public static final String SELECT = "SELECT * FROM CLIENT";
    public static final String CREATE = "INSERT INTO CLIENT (name) VALUES (?)";
    public static final String MAX_ID = "SELECT max(id) AS maxId FROM CLIENT";
    public static final String GET_NAME_BY_ID = "SELECT name FROM CLIENT WHERE id = ?";
    public static final String UPDATE_NAME = "UPDATE client SET name = ? WHERE id = ?";
    public static final String DELETE_CLIENT = "DELETE FROM client WHERE id = ?";

    public ClientService(Database database) {
        this.database = database;
    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getInt("id");
                String name = rs.getString("name");
                clients.add(new Client(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    public long create(String name) {
        long id = 0;
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE)) {
            if(name.length()>=3) {
                preparedStatement1.setString(1, name);
            }
            preparedStatement1.executeUpdate();
            PreparedStatement preparedStatement2 = connection.prepareStatement(MAX_ID);
            ResultSet rs = preparedStatement2.executeQuery();
            while (rs.next()) {
                id = rs.getLong("maxId");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Invalid name");
        }
        return id;
    }

//    public void createClient(Client client) {
//        try (Connection connection = database.getConnection();
//             PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE)) {
//            preparedStatement1.setString(1, client.getName());
//            preparedStatement1.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public String getById(long id) {
        String a = null;
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement3 = connection.prepareStatement(GET_NAME_BY_ID)) {
            preparedStatement3.setLong(1, id);
            ResultSet rs = preparedStatement3.executeQuery();
            while (rs.next()) {
                 a = rs.getString("name");
            }
            return a;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getByIdVersion2(long id) throws RuntimeException {
        String a = null;
        long maxId = 0;
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                maxId = rs.getLong("maxId");
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement(GET_NAME_BY_ID);
            preparedStatement2.setLong(1, id);
            ResultSet resultSet = preparedStatement2.executeQuery();
            while (resultSet.next()) {
                a = resultSet.getString("name");
            }
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        return (id <= maxId) ? a : null;
    }
    public void setName(long id, String name){
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement2 = connection.prepareStatement(UPDATE_NAME)) {
            long maxId = 0;
            PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                maxId = rs.getLong("maxId");
            }
            if(maxId >= id && name.length()>=3) {
                preparedStatement2.setString(1, name);
                preparedStatement2.setLong(2, id);
                preparedStatement2.executeUpdate();
                System.out.println("Client was changed");
            } preparedStatement2.executeUpdate();
    }catch (SQLException e) {
            throw new RuntimeException("Client Does Not Exist");
        }
    }

    public void deleteById(long id) {
        try (Connection connection = database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(MAX_ID)) {
            long maxId = 0;
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                maxId = rs.getLong("maxId");
            }
            PreparedStatement preparedStatement2 = connection.prepareStatement(DELETE_CLIENT);
            if (maxId >= id) {
                preparedStatement2.setLong(1, id);
                preparedStatement2.executeUpdate();
                System.out.println("Delete client index " + id);
            } preparedStatement2.executeUpdate();
            }catch(Exception e){
                throw new RuntimeException("id not found");
            }
        }
    }
