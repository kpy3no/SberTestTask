import com.fasterxml.jackson.databind.ser.Serializers;
import junit.framework.TestCase;
import org.example.domain.*;

import org.example.service.BaseService;
import org.example.utils.HibernateUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kuzmin Evgeny on 17.05.2017.
 */
public class DataBaseTest extends TestCase {

    @Test
    public void testGetData(){
        BaseService baseService = new BaseService();
        List<AnswerVariant> answerVariant = baseService.findAll("AnswerVariant");
        AnswerVariant answerVariant2 = baseService.find(AnswerVariant.class, 1);
        System.out.println(answerVariant2.getAnswer());
        assertNotNull(answerVariant);
        assertNotNull(answerVariant2);
    }

    @Test
    public void testGetData1(){
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        AnswerVariant answerVariant2 = entityManager.find(AnswerVariant.class, 1);
        entityManager.getTransaction().commit();
        entityManager.close();
        assertNotNull(answerVariant2);
    }

    @Test
    public void testGetData2(){
        BaseService baseService = new BaseService();
        Questionnaire questionnaire = new Questionnaire("Simple questionnaire");
        questionnaire.setId(1);
        Questionnaire questionnaire1 = baseService.merge(questionnaire);
        assertNotNull(questionnaire1.getQuestions());
    }

    @Test
    public void testIsExist(){
        BaseService baseService = new BaseService();
        User user = baseService.isExist("user", "123");
        assertNotNull(user);
    }


    @Test
    public void testMyAdd(){
        BaseService baseService = new BaseService();
        
    }

    @Test
    public void testCreateAdmin(){
        BaseService baseService = new BaseService();
        Administrator administrator = new Administrator("admin","123");

        baseService.persist(administrator);

    }
}
