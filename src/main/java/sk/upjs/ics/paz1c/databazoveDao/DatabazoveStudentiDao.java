package sk.upjs.ics.paz1c.databazoveDao;

import java.util.Arrays;
import sk.upjs.ics.paz1c.databazoveDao.rowMappers.StudentRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.ics.paz1c.entity.Student;
import sk.upjs.ics.paz1c.dao.StudentiDao;
import sk.upjs.ics.paz1c.entity.Skuska;
import sk.upjs.ics.paz1c.filtre.StudentiFilter;

public class DatabazoveStudentiDao implements StudentiDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    public DatabazoveStudentiDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public List<Student> dajVsetky() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_STUDENT, studentRowMapper);
    }

    @Override
    public List<Student> dajPodlaSkusky(Skuska skuska) {
        return jdbcTemplate.query(SqlQueries.SELECT_STUDENT_BY_SKUSKA, studentRowMapper, skuska.getId());
    }

    @Override
    public List<Student> hladajPodlaMena(String meno) {
        meno = meno.trim();
        meno = "%" + meno + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_STUDENT_BY_MENO, studentRowMapper, meno);
    }

    @Override
    public List<Student> hladajPodlaPriezviska(String priezvisko) {
        priezvisko = priezvisko.trim();
        priezvisko = "%" + priezvisko + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_STUDENT_BY_PRIEZVISKO, studentRowMapper, priezvisko);
    }

    @Override
    public List<Student> hladajPodlaFiltra(StudentiFilter filter) {
        boolean where = false;
        int usedArgs = 0;
        Object[] args = new Object[10];
        StringBuilder sql = new StringBuilder(SqlQueries.SELECT_STUDENT_BY_FILTER + "\n");

        if (filter.getMeno() != null) {
            String meno = filter.getMeno().trim();
            meno = "%" + meno + "%";
            if (!where) {
                sql.append("WHERE StudentMeno LIKE ?\n");
                where = true;
            } else {
                sql.append("AND StudentMeno LIKE ?\n");
            }
            args[usedArgs] = meno;
            usedArgs++;
        }

        if (filter.getPriezvisko() != null) {
            String priezvisko = filter.getPriezvisko().trim();
            priezvisko = "%" + priezvisko + "%";
            if (!where) {
                sql.append("WHERE StudentPriezvisko LIKE ?\n");
                where = true;
            } else {
                sql.append("AND StudentPriezvisko LIKE ?\n");
            }
            args[usedArgs] = priezvisko;
            usedArgs++;
        }

        if (filter.getBydlisko() != null) {
            String bydlisko = filter.getBydlisko().trim();
            bydlisko = "%" + bydlisko + "%";
            if (!where) {
                sql.append("WHERE StudentBydlisko LIKE ?\n");
                where = true;
            } else {
                sql.append("AND StudentBydlisko LIKE ?\n");
            }
            args[usedArgs] = bydlisko;
            usedArgs++;
        }

        if (filter.getDatumNarodeniaOd() != null) {
            if (!where) {
                sql.append("WHERE StudentDatumNarodenia >=  ?\n");
                where = true;
            } else {
                sql.append("AND StudentDatumNarodenia >=  ?\n");
            }
            args[usedArgs] = filter.getDatumNarodeniaOd();
            usedArgs++;
        }

        if (filter.getDatumNarodeniaDo() != null) {
            if (!where) {
                sql.append("WHERE StudentDatumNarodenia <=  ?\n");
                where = true;
            } else {
                sql.append("AND StudentDatumNarodenia <=  ?\n");
            }
            args[usedArgs] = filter.getDatumNarodeniaDo();
            usedArgs++;
        }

        if (filter.getPocetJazdOd() != null) {
            if (!where) {
                sql.append("WHERE PocetJazd >= ?\n");
                where = true;
            } else {
                sql.append("AND PocetJazd >= ?\n");
            }
            args[usedArgs] = filter.getPocetJazdOd();
            usedArgs++;
        }

        if (filter.getPocetJazdDo() != null) {
            if (!where) {
                sql.append("WHERE PocetJazd <= ?\n");
                where = true;
            } else {
                sql.append("AND PocetJazd <= ?\n");
            }
            args[usedArgs] = filter.getPocetJazdDo();
            usedArgs++;
        }

        if (filter.getPrejdeneKmOd() != null) {
            if (!where) {
                sql.append("WHERE PrejdeneKm >= ?\n");
                where = true;
            } else {
                sql.append("AND PrejdeneKm >= ?\n");
            }
            args[usedArgs] = filter.getPrejdeneKmOd();
            usedArgs++;
        }

        if (filter.getPrejdeneKmDo() != null) {
            if (!where) {
                sql.append("WHERE PrejdeneKm <= ?\n");
                where = true;
            } else {
                sql.append("AND PrejdeneKm <= ?\n");
            }
            args[usedArgs] = filter.getPrejdeneKmDo();
            usedArgs++;
        }

        if (filter.getPrvaPomoc() != null) {
            if (!where) {
                if (Boolean.TRUE.equals(filter.getPrvaPomoc())) {
                    sql.append("WHERE StudentPrvaPomoc\n");
                } else {
                    sql.append("WHERE NOT StudentPrvaPomoc\n");
                }
            } else {
                if (Boolean.TRUE.equals(filter.getPrvaPomoc())) {
                    sql.append("AND StudentPrvaPomoc\n");
                } else {
                    sql.append("AND NOT StudentPrvaPomoc\n");
                }
            }
        }

        if (filter.getTest() != null) {
            if (!where) {
                if (Boolean.TRUE.equals(filter.getTest())) {
                    sql.append("WHERE StudentPocetBodov >= 50\n");
                } else {
                    sql.append("WHERE StudentPocetBodov < 50\n");
                }
            } else {
                if (Boolean.TRUE.equals(filter.getTest())) {
                    sql.append("AND StudentPocetBodov >= 50\n");
                } else {
                    sql.append("AND StudentPocetBodov < 50\n");
                }
            }
        }

        if (filter.getCvicisko() != null) {
            if (!where) {
                if (Boolean.TRUE.equals(filter.getCvicisko())) {
                    sql.append("WHERE StudentCvicisko\n");
                } else {
                    sql.append("WHERE NOT StudentCvicisko\n");
                }
            } else {
                if (Boolean.TRUE.equals(filter.getCvicisko())) {
                    sql.append("AND StudentCvicisko\n");
                } else {
                    sql.append("AND NOT StudentCvicisko\n");
                }
            }
        }

        if (filter.getKategoria() != null) {
            if (!where) {
                sql.append("WHERE VozidloKategoria = ?\n");
                where = true;
            } else {
                sql.append("AND VozidloKategoria = ?\n");
            }
            args[usedArgs] = filter.getKategoria();
            usedArgs++;
        }

        return jdbcTemplate.query(sql.toString(), Arrays.copyOfRange(args, 0, usedArgs), studentRowMapper);
    }

    @Override
    public void uloz(Student student
    ) {
        Map<String, Object> insertMap = new HashMap<String, Object>();
        insertMap.put("meno", student.getMeno());
        insertMap.put("priezvisko", student.getPriezvisko());
        insertMap.put("datumNarodenia", student.getDatumNarodenia());
        insertMap.put("bydlisko", student.getBydlisko());
        insertMap.put("kontakt", student.getKontakt());
        insertMap.put("prvaPomoc", student.isPrvaPomoc());
        insertMap.put("pocetPokusov", student.getPocetPokusov());
        insertMap.put("pocetBodov", student.getPocetBodov());
        insertMap.put("cvicisko", student.isCvicisko());
        insertMap.put("jazda", student.isJazda());

        String sql = "INSERT INTO Student (meno, priezvisko, datumNarodenia, bydlisko, kontakt, prvaPomoc, pocetPokusov, pocetBodov, cvicisko, jazda)\n"
                + "VALUES (:meno, :priezvisko, :datumNarodenia, :bydlisko, :kontakt, :prvaPomoc, :pocetPokusov, :pocetBodov, :cvicisko, :jazda)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(insertMap), keyHolder);
        Long id = keyHolder.getKey().longValue();
        student.setId(id);
    }

    @Override
    public void uprav(Student student
    ) {
        Map<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("id", student.getId());
        updateMap.put("meno", student.getMeno());
        updateMap.put("priezvisko", student.getPriezvisko());
        updateMap.put("datumNarodenia", student.getDatumNarodenia());
        updateMap.put("bydlisko", student.getBydlisko());
        updateMap.put("kontakt", student.getKontakt());
        updateMap.put("prvaPomoc", student.isPrvaPomoc());
        updateMap.put("pocetPokusov", student.getPocetPokusov());
        updateMap.put("pocetBodov", student.getPocetBodov());
        updateMap.put("cvicisko", student.isCvicisko());
        updateMap.put("jazda", student.isJazda());

        String sql = "UPDATE Student SET meno = :meno, priezvisko = :priezvisko, datumNarodenia = :datumNarodenia, bydlisko = :bydlisko, kontakt = :kontakt, prvaPomoc = :prvaPomoc, pocetPokusov = :pocetPokusov, pocetBodov = :pocetBodov, cvicisko = :cvicisko, jazda = :jazda WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, updateMap);
    }

    @Override
    public void vymaz(Student student
    ) {
        String sql = "DELETE FROM Student WHERE id = ?";
        jdbcTemplate.update(sql, student.getId());
    }

}
