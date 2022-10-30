package DAO;

import model.SubCategory;

import java.util.List;

public class SubCategoryDao extends AbstractHibernateDao<SubCategory>{

    public SubCategoryDao(){
        tableName="subcategory";
        setClazz(SubCategory.class);
    }

    public List getAllCategories(){
        return findAll();
    }

    public SubCategory getCategoryById(long id){
        return findOne(id);
    }


    public boolean createCategory(SubCategory cat){
        return create(cat);
    }


    public static void main(String[] args) {
        SubCategory s = new SubCategory();

        s.setName("electro");

        SubCategoryDao sub = new SubCategoryDao();

        sub.create(s);
    }
}
