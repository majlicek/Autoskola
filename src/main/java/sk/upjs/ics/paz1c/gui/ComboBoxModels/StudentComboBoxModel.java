package sk.upjs.ics.paz1c.gui.ComboBoxModels;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.StudentiDao;
import sk.upjs.ics.paz1c.entity.Student;

public class StudentComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private StudentiDao studentiDao = BeanFactory.INSTANCE.getStudentiDao();
    private List<Student> studenti = studentiDao.dajVsetky();

    Student student;

    @Override
    public int getSize() {
        return studenti.size();
    }

    @Override
    public Object getElementAt(int index) {
        return studenti.get(index);
    }

    @Override
    public void setSelectedItem(Object objekt) {
        student = (Student) objekt;
    }

    @Override
    public Object getSelectedItem() {
        return student;
    }

}
