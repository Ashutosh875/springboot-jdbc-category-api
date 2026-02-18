package com.ashutosh.categoryapi.repository;

import com.ashutosh.categoryapi.exceptions.DatabaseException;
import com.ashutosh.categoryapi.exceptions.ResourceNotFoundException;
import com.ashutosh.categoryapi.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDB implements CategoryRepo {

    private final String url = "jdbc:postgresql://localhost:5432/category-app";
    private final String uName = "postgres";
    private final String password = "";


    @Override
    public List<Category> findAll() {

        String sql = "SELECT * FROM categories";

        List<Category> categories = new ArrayList<>();

        try(Connection con = DriverManager.getConnection(url,uName,password);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){
                Category category = new Category();
                category.setCategoryId(rs.getInt(1));
                category.setCategoryName(rs.getString(2));
                categories.add(category);
            }
            return categories;

        } catch (SQLException e){
            throw new DatabaseException("Internal error while fetching" , e);
        }
    }

    @Override
    public String save(Category category) {

        String sql = "INSERT INTO categories (categoryname) VALUES (?)";

        try (Connection con = DriverManager.getConnection(url, uName, password);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, category.getCategoryName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw  new DatabaseException("Internal Error while saving" , e);
        }
        return "Category created successfully";
    }

    @Override
    public String delete(long id) {

        String sql = "DELETE FROM categories WHERE categoryid = ?";
        try( Connection con = DriverManager.getConnection(url,uName,password);
             PreparedStatement ps = con.prepareStatement(sql)){
                ps.setLong(1 , id);
                int status = ps.executeUpdate();
                if(status >= 1){
                    return "Category with id : " + id + " deleted successfully";
                }else throw new ResourceNotFoundException("Category not found with id : " + id);
        }catch (SQLException e){
            throw new DatabaseException("Internal error while deleting" , e);
        }
    }

    @Override
    public String update(Category category) {
        String sql = "UPDATE categories SET categoryname = ? WHERE categoryid = ?";

        try(Connection con = DriverManager.getConnection(url,uName,password);
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,category.getCategoryName());
            ps.setLong(2,category.getCategoryId());
            int status = ps.executeUpdate();
            if(status >= 1){
                return "Category with id : " + category.getCategoryId() + " updated successfully";
            }else throw new ResourceNotFoundException("Category not found with id : " + category.getCategoryId());
        }catch (SQLException e){
            throw  new DatabaseException("Internal error while updating" , e);
        }
    }

    @Override
    public Category findById(long id) {
        String sql = "SELECT * FROM categories WHERE categoryid = ?";

        try(Connection con = DriverManager.getConnection(url,uName,password);
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Category category = new Category();
                category.setCategoryId(rs.getInt(1));
                category.setCategoryName(rs.getString(2));
                return category;
            } else throw new ResourceNotFoundException("Category not found with id : " + id);

        } catch (SQLException e){
            throw new DatabaseException("Database error while fetching" , e);
        }
    }

}
