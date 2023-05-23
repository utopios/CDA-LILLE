package org.example.services;

import org.example.entities.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService(){
        super();
    }

    @Override
    public boolean create(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        session = sessionFactory.openSession();
        produit = (Produit) session.get(Produit.class, id);
        session.close();
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produitList = null;
      //  session = sessionFactory.openSession();
        Query<Produit> produitQuery = session.createQuery("from Produit");
        produitList = produitQuery.list();
       // session.close();
        return produitList;
    }

    public List<Produit> filterByPrice(double min) throws Exception{
        if (min >= 0){
         //   session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :min");
            produitQuery.setParameter("min",min);
         //   session.close();
            return produitQuery.list();
        }
        throw new Exception("erreur valeur");
    }

    public List<Produit> filterByDate(Date min, Date max) throws Exception{
        if(min.before(max)){
         //   session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :min and dateAchat <= :max ");
            produitQuery.setParameter("min",min);
            produitQuery.setParameter("max",max);
        //    session.close();
            return produitQuery.list();
        }
        throw new Exception("erreur date");
    }

    public List<Produit> filterByStockMax(int max) throws Exception{
        if (max >= 0){
            //   session = sessionFactory.openSession();
            Query<Produit> produitQuery = session.createQuery("from Produit where stock < :max");
            produitQuery.setParameter("max",max);
            //   session.close();
            return produitQuery.list();
        }
        throw new Exception("erreur valeur");
    }



    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){
        session.close();
    }
}
