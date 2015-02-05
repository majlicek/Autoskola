package sk.upjs.ics.paz1c.databazoveDao;

import java.util.Arrays;
import sk.upjs.ics.paz1c.databazoveDao.rowMappers.JazdaRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.ics.paz1c.dao.JazdyDao;
import sk.upjs.ics.paz1c.entity.Jazda;
import sk.upjs.ics.paz1c.filtre.JazdyFilter;

public class DatabazoveJazdyDao implements JazdyDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private JazdaRowMapper jazdaRowMapper = new JazdaRowMapper();

    public DatabazoveJazdyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public List<Jazda> dajVsetky() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_JAZDA, jazdaRowMapper);
    }

    @Override
    public List<Jazda> hladajPodlaDatumu(String datum) {
        datum = datum.trim();
        return jdbcTemplate.query(SqlQueries.SELECT_JAZDA_BY_DATUM, jazdaRowMapper, datum);
    }

    @Override
    public List<Jazda> hladajPodlaStudenta(String student) {
        student = student.trim();
        String[] studentTokens = student.split(" ");
        String studentMeno = studentTokens[0];
        studentMeno = "%" + studentMeno + "%";
        if (studentTokens.length == 1) {
            return jdbcTemplate.query(SqlQueries.SELECT_JAZDA_BY_STUDENT, jazdaRowMapper, studentMeno, studentMeno);
        } else {
            String studentPriezvisko = studentTokens[1];
            studentPriezvisko = "%" + studentPriezvisko + "%";
            return jdbcTemplate.query(SqlQueries.SELECT_JAZDA_BY_STUDENT, jazdaRowMapper, studentMeno, studentPriezvisko);
        }
    }

    @Override
    public List<Jazda> hladajPodlaInstruktora(String instruktor) {
        instruktor = instruktor.trim();
        String[] instruktorTokens = instruktor.split(" ");
        String instruktorMeno = instruktorTokens[0];
        instruktorMeno = "%" + instruktorMeno + "%";
        if (instruktorTokens.length == 1) {
            return jdbcTemplate.query(SqlQueries.SELECT_JAZDA_BY_INSTRUKTOR, jazdaRowMapper, instruktorMeno, instruktorMeno);
        } else {
            String instruktorPriezvisko = instruktorTokens[1];
            instruktorPriezvisko = "%" + instruktorPriezvisko + "%";
            return jdbcTemplate.query(SqlQueries.SELECT_JAZDA_BY_INSTRUKTOR, jazdaRowMapper, instruktorMeno, instruktorPriezvisko);
        }
    }

    @Override
    public List<Jazda> hladajPodlaFiltra(JazdyFilter filter) {
        boolean where = false;
        int usedArgs = 0;
        Object[] args = new Object[12];
        StringBuilder sql = new StringBuilder(SqlQueries.SELECT_ALL_JAZDA + "\n");

        if (filter.getStudent() != null) {
            String student = filter.getStudent().trim();
            String[] studentTokens = student.split(" ");
            String studentMeno = studentTokens[0];
            studentMeno = "%" + studentMeno + "%";
            if (!where) {
                sql.append("WHERE (Student.meno LIKE ? OR Student.priezvisko LIKE ?)\n");
                where = true;
            } else {
                sql.append("AND (Student.meno LIKE ? OR Student.priezvisko LIKE ?)\n");
            }
            if (studentTokens.length == 1) {
                args[usedArgs] = studentMeno;
                args[usedArgs + 1] = studentMeno;
                usedArgs += 2;
            } else {
                String studentPriezvisko = studentTokens[1];
                studentPriezvisko = "%" + studentPriezvisko + "%";
                args[usedArgs] = studentMeno;
                args[usedArgs + 1] = studentPriezvisko;
                usedArgs += 2;
            }
        }

        if (filter.getInstruktor() != null) {
            String instruktor = filter.getInstruktor().trim();
            String[] instruktorTokens = instruktor.split(" ");
            String instruktorMeno = instruktorTokens[0];
            instruktorMeno = "%" + instruktorMeno + "%";
            if (!where) {
                sql.append("WHERE (Instruktor.meno LIKE ? OR Instruktor.priezvisko LIKE ?)\n");
                where = true;
            } else {
                sql.append("AND (Instruktor.meno LIKE ? OR Instruktor.priezvisko LIKE ?)\n");
            }
            if (instruktorTokens.length == 1) {
                args[usedArgs] = instruktorMeno;
                args[usedArgs + 1] = instruktorMeno;
                usedArgs += 2;
            } else {
                String instruktorPriezvisko = instruktorTokens[1];
                instruktorPriezvisko = "%" + instruktorPriezvisko + "%";
                args[usedArgs] = instruktorMeno;
                args[usedArgs + 1] = instruktorPriezvisko;
                usedArgs += 2;
            }
        }

        if (filter.getVozidlo() != null) {
            String vozidlo = filter.getVozidlo().trim();
            vozidlo = "%" + vozidlo + "%";
            if (!where) {
                sql.append("WHERE Vozidlo.spz LIKE ?\n");
                where = true;
            } else {
                sql.append("AND Vozidlo.spz LIKE ?\n");
            }
            args[usedArgs] = vozidlo;
            usedArgs++;
        }

        if (filter.getDatumOd() != null) {
            if (!where) {
                sql.append("WHERE Jazda.datum >= ?\n");
                where = true;
            } else {
                sql.append("AND Jazda.datum >= ?\n");
            }
            args[usedArgs] = filter.getDatumOd();
            usedArgs++;
        }

        if (filter.getDatumDo() != null) {
            if (!where) {
                sql.append("WHERE Jazda.datum <= ?\n");
                where = true;
            } else {
                sql.append("AND Jazda.datum <= ?\n");
            }
            args[usedArgs] = filter.getDatumDo();
            usedArgs++;
        }

        if (filter.getCasOd() != null) {
            if (!where) {
                sql.append("WHERE Jazda.cas >= ?\n");
                where = true;
            } else {
                sql.append("AND Jazda.cas >= ?\n");
            }
            args[usedArgs] = filter.getCasOd();
            usedArgs++;
        }

        if (filter.getCasDo() != null) {
            if (!where) {
                sql.append("WHERE Jazda.cas <= ?\n");
                where = true;
            } else {
                sql.append("AND Jazda.cas <= ?\n");
            }
            args[usedArgs] = filter.getCasDo();
            usedArgs++;
        }

        if (filter.getKmOd() != null) {
            if (!where) {
                sql.append("WHERE Jazda.km >= ?\n");
                where = true;
            } else {
                sql.append("AND Jazda.km >= ?\n");
            }
            args[usedArgs] = filter.getKmOd();
            usedArgs++;
        }

        if (filter.getKmDo() != null) {
            if (!where) {
                sql.append("WHERE Jazda.km <= ?\n");
                where = true;
            } else {
                sql.append("AND Jazda.km <= ?\n");
            }
            args[usedArgs] = filter.getKmDo();
            usedArgs++;
        }

        if (filter.getvPremavke() != null) {
            if (!where) {
                if (Boolean.TRUE.equals(filter.getvPremavke())) {
                    sql.append("WHERE Jazda.vPremavke\n");
                } else {
                    sql.append("WHERE NOT Jazda.vPremavke\n");
                }
                where = true;
            } else {
                if (Boolean.TRUE.equals(filter.getvPremavke())) {
                    sql.append("AND Jazda.vPremavke\n");
                } else {
                    sql.append("AND NOT Jazda.vPremavke\n");
                }
            }
        }

        if (filter.getNaCvicisku() != null) {
            if (!where) {
                if (Boolean.TRUE.equals(filter.getNaCvicisku())) {
                    sql.append("WHERE Jazda.naCvicisku\n");
                } else {
                    sql.append("WHERE NOT Jazda.naCvicisku\n");
                }
                where = true;
            } else {
                if (Boolean.TRUE.equals(filter.getNaCvicisku())) {
                    sql.append("AND Jazda.naCvicisku\n");
                } else {
                    sql.append("AND NOT Jazda.naCvicisku\n");
                };
            }
        }

        if (filter.getsVozikom() != null) {
            if (!where) {
                if (Boolean.TRUE.equals(filter.getsVozikom())) {
                    sql.append("WHERE Jazda.sVozikom\n");
                } else {
                    sql.append("WHERE NOT Jazda.sVozikom\n");
                }
                where = true;
            } else {
                if (Boolean.TRUE.equals(filter.getsVozikom())) {
                    sql.append("AND Jazda.sVozikom\n");
                } else {
                    sql.append("AND NOT Jazda.sVozikom\n");
                }
            }
        }

        if (filter.getKategoria() != null) {
            if (!where) {
                sql.append("WHERE Vozidlo.kategoria = ?\n");
                where = true;
            } else {
                sql.append("AND Vozidlo.kategoria = ?\n");
            }
            args[usedArgs] = filter.getKategoria();
            usedArgs++;
        }

        return jdbcTemplate.query(sql.toString(), Arrays.copyOfRange(args, 0, usedArgs), jazdaRowMapper);
    }

    @Override
    public void uloz(Jazda jazda) {
        Map<String, Object> insertMap = new HashMap<String, Object>();
        insertMap.put("studentId", jazda.getStudent().getId());
        insertMap.put("instruktorId", jazda.getInstruktor().getId());
        insertMap.put("vozidloId", jazda.getVozidlo().getId());
        insertMap.put("datum", jazda.getDatum());
        insertMap.put("cas", jazda.getCas());
        insertMap.put("km", jazda.getKm());
        insertMap.put("vPremavke", jazda.isvPremavke());
        insertMap.put("naCvicisku", jazda.isNaCvicisku());
        insertMap.put("sVozikom", jazda.issVozikom());

        String sql = "INSERT INTO Jazda (studentId, instruktorId, vozidloId, datum, cas, km, vPremavke, naCvicisku, sVozikom)\n"
                + "VALUES (:studentId, :instruktorId, :vozidloId, :datum, :cas, :km, :vPremavke, :naCvicisku, :sVozikom)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(insertMap), keyHolder);
        Long id = keyHolder.getKey().longValue();
        jazda.setId(id);
    }

    @Override
    public void uprav(Jazda jazda) {
        Map<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("id", jazda.getId());
        updateMap.put("studentId", jazda.getStudent().getId());
        updateMap.put("instruktorId", jazda.getInstruktor().getId());
        updateMap.put("vozidloId", jazda.getVozidlo().getId());
        updateMap.put("datum", jazda.getDatum());
        updateMap.put("cas", jazda.getCas());
        updateMap.put("km", jazda.getKm());
        updateMap.put("vPremavke", jazda.isvPremavke());
        updateMap.put("naCvicisku", jazda.isNaCvicisku());
        updateMap.put("sVozikom", jazda.issVozikom());

        String sql = "UPDATE Jazda SET studentId = :studentId, instruktorId = :instruktorId, vozidloId = :vozidloId, datum = :datum, cas = :cas, km = :km, vPremavke = :vPremavke, naCvicisku = :naCvicisku, sVozikom = :sVozikom WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, updateMap);
    }

    @Override
    public void vymaz(Jazda jazda) {
        String sql = "DELETE FROM Jazda WHERE id = ?";
        jdbcTemplate.update(sql, jazda.getId());
    }

}
