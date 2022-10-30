package DAO;

import model.AdminCenter;
import utils.SendMail;

import java.util.List;

import static utils.Security.checkPassword;
import static utils.Security.hashPassword;

public class AdminCenterDao extends AbstractHibernateDao<AdminCenter>{

    public AdminCenterDao(){
        tableName = "admincenter";
        setClazz(AdminCenter.class);
    }

    public List getAllAdmins() {
        return findAll();
    }

    public AdminCenter getAdminById(long id){
        return findOne(id);
    }

    //getadmin by email
    public AdminCenter getAdminByEmail(String email){
        return jpaService.runInTransaction(entityManager -> {
          return  entityManager.createQuery("select a from AdminCenter a where  a.email = :email",AdminCenter.class)
                    .setParameter(1,email)
                    .getSingleResult();
        });
    }


    //Verify login

    public AdminCenter validateAdminLogin(String email ,String password){
        AdminCenter admin = getAdminByEmail(email);
        if(admin == null){
            return null;
        }
        if(checkPassword(password, admin.getPassword())){
            return admin;
        }else{
            return null;
        }
    }

    //create admin center

    public boolean createAdmin(AdminCenter admin) throws Exception {
        String message = "Your password is : "+admin.getPassword();
        SendMail.sendMail(admin.getEmail(),message);
        admin.setPassword(hashPassword(admin.getPassword()));
        return create(admin);
    }


    //test functions
    public static void main(String[] args) throws Exception {
        AdminCenter ad = new AdminCenter();
        ad.setFirstname("koukou");
        ad.setLastname("teeeest");
        ad.setEmail("laghrissi.reda123@gmail.com");
        ad.setPassword("test");
        AdminGeneralDao aaa= new AdminGeneralDao();
        ad.setAdminGeneral(aaa.getAdminById(1));
        AdminCenterDao a = new AdminCenterDao();
        a.createAdmin(ad);
    }

}
