

/**
 *
 * @author Hernanmauricio
 */
import org.hibernate.Criteria;
import org.hibernate.Session;
import Hibernatenormal.*;

        
public class Main {
    
    
    public static void main(String[] args){
    
    
    String [] people = {"Paco", "Juan","MARIO"};
    String [] people2 = {"Maria", "Ana","MARIO"};
    
        getPeople ();
        addPeople ( people );
        getPeople ();
        addPeople ( people2 );
        getPeople ();
    
    
    }
    
    
     public static void addPeople (String [] people) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        
            session.beginTransaction ();
            Contacto person_obj = new Contacto( people );
            session.save ( person_obj );
        }
    
    
     
     public static void getPeople () {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction ();
        Criteria criteria = session.createCriteria ( Contacto.class );
        System.out.println ("Personas encontradas:" + criteria.list ().size ());
        for ( Object persona_obj : criteria.list () )
        {
            Contacto persona = (Contacto) persona_obj;
            System.out.println ( " - " + persona.getNombre () );
        }
        session.getTransaction ().commit ();
    }
}
