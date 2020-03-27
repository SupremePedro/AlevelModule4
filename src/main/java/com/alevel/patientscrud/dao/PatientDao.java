package com.alevel.patientscrud.dao;

import com.alevel.patientscrud.model.Patient;
import com.alevel.patientscrud.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PatientDao {

    private SessionFactory sessionFactory  = HibernateUtil.getSessionFactory();

    public void save(Patient patient) {
        Session currentSession = sessionFactory.openSession();
        Transaction tx = currentSession.getTransaction();
        try{
            tx.begin();
            currentSession.save(patient);
            tx.commit();
        }
        catch (Exception sqlException){
            tx.rollback();
            sqlException.printStackTrace();
        }finally {
            currentSession.close();
        }
    }

    public void update(Patient patient) {
        Session currentSession = sessionFactory.openSession();
        Transaction tx = currentSession.getTransaction();
        try{
            tx.begin();
            currentSession.update(patient);
            tx.commit();
        }
        catch (Exception sqlException){
            tx.rollback();
            sqlException.printStackTrace();
        }finally {
            currentSession.close();
        }
    }

    public List<Patient> findAll(){
        Session currentSession = sessionFactory.openSession();
        try{
            Query query = currentSession.createQuery("from Patient");
            return query.list();
        }finally {
            currentSession.close();
        }
    }

    public Patient findById(Long id) {
        Session currentSession = sessionFactory.openSession();
        Patient patient = null;

        try{
            patient = (Patient) currentSession.get(Patient.class, id);
        }
        catch (Exception sqlException){
            sqlException.printStackTrace();
        }finally {
            currentSession.close();
            return patient;
        }
    }

    public void delete(Long id){
        Session currentSession = sessionFactory.getCurrentSession();
        Transaction tx  = currentSession.getTransaction();
        try {
            tx.begin();
            Patient patient = (Patient) currentSession.get(Patient.class, id);
            currentSession.delete(patient);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            currentSession.close();
        }
    }
}
