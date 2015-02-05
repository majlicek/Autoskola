package sk.upjs.ics.paz1c.databazoveDao.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();

        student.setId(rs.getLong("StudentId"));
        student.setMeno(rs.getString("StudentMeno"));
        student.setPriezvisko(rs.getString("StudentPriezvisko"));
        student.setDatumNarodenia(rs.getDate("StudentDatumNarodenia"));
        student.setBydlisko(rs.getString("StudentBydlisko"));
        student.setKontakt(rs.getString("StudentKontakt"));
        student.setPrvaPomoc(rs.getBoolean("StudentPrvaPomoc"));
        student.setPocetPokusov(rs.getInt("StudentPocetPokusov"));
        student.setPocetBodov(rs.getInt("StudentPocetBodov"));
        student.setCvicisko(rs.getBoolean("StudentCvicisko"));
        student.setJazda(rs.getBoolean("StudentJazda"));

        return student;
    }

}
