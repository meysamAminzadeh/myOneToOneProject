package model.BL;

import model.BL.hibernate.HibernateClassicUtil;

import model.BL.to.MobileTO;
import model.BL.to.PersonTO;
import org.hibernate.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;


public class TblPerson {
    Session session;
    Transaction transaction;

    public void insert() {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        PersonTO pTO = new PersonTO();
        pTO.setName("amir");
        pTO.setFamily("aghaei");

        MobileTO mTo = new MobileTO();
        mTo.setMobileNumber("0912224234");

        pTO.setMobileTO(mTo);

        session.saveOrUpdate(pTO);
        transaction.commit();
        session.close();
    }

    public void delete()
    {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        PersonTO pTO = new PersonTO();
        pTO.setId(4);

        MobileTO mTO = new MobileTO();
        mTO.setId(4);

        pTO.setMobileTO(mTO);

        session.delete(pTO);
        transaction.commit();
        session.close();

    }

    public void select()
    {
        session = HibernateClassicUtil.getSession();

        Iterator<PersonTO> iterator = session.createQuery("from PersonTO").iterate();
        while (iterator.hasNext())
        {

            PersonTO pTO = iterator.next();
            System.out.println(pTO.getName());
            System.out.println(pTO.getFamily());
            System.out.println(pTO.getMobileTO().getMobileNumber());
            System.out.println("***************************************");
        }


        session.close();

    }

    public void update(String personName , String family)
    {
        session = HibernateClassicUtil.getSession();
        transaction = session.beginTransaction();

        Iterator<PersonTO> iterator = session.createQuery("from PersonTO a " +
                                  "where a.name = :aaa and a.family = :bbb")
                                 .setParameter("aaa",personName)
                                  .setParameter("bbb",family).iterate();

      while (iterator.hasNext()) {

          PersonTO pTO = iterator.next();

          MobileTO mTO = new MobileTO();

          mTO.setId(pTO.getId());

          mTO.setMobileNumber("888000");

          session.saveOrUpdate(mTO);



      }
        transaction.commit();
        session.close();
    }

public void prepared_statement_hibernate ()
{
    try {
        PreparedStatement statement = HibernateClassicUtil.getSession()
                .connection().prepareStatement("insert into SYSTEM.MOBILE values (?,?)");
        statement.setInt(1,30);
        statement.setString(2,"0987654321");

        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }

}



}
