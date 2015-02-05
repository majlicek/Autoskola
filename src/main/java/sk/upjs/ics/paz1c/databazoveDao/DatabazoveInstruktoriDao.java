package sk.upjs.ics.paz1c.databazoveDao;

import sk.upjs.ics.paz1c.databazoveDao.rowMappers.InstruktorRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.ics.paz1c.entity.Instruktor;
import sk.upjs.ics.paz1c.dao.InstruktoriDao;

public class DatabazoveInstruktoriDao implements InstruktoriDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private InstruktorRowMapper instruktorRowMapper = new InstruktorRowMapper();

    public DatabazoveInstruktoriDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public List<Instruktor> dajVsetky() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_INSTRUKTOR, instruktorRowMapper);
    }

    @Override
    public List<Instruktor> hladajPodlaMena(String meno) {
        meno = meno.trim();
        meno = "%" + meno + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_INSTRUKTOR_BY_MENO, instruktorRowMapper, meno);
    }

    @Override
    public List<Instruktor> hladajPodlaPriezviska(String priezvisko) {
        priezvisko = priezvisko.trim();
        priezvisko = "%" + priezvisko + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_INSTRUKTOR_BY_PRIEZVISKO, instruktorRowMapper, priezvisko);
    }

    @Override
    public void uloz(Instruktor instruktor) {
        Map<String, Object> insertMap = new HashMap<String, Object>();
        insertMap.put("meno", instruktor.getMeno());
        insertMap.put("priezvisko", instruktor.getPriezvisko());
        insertMap.put("kontakt", instruktor.getKontakt());

        String sql = "INSERT INTO Instruktor (meno, priezvisko, kontakt)\n"
                + "VALUES (:meno, :priezvisko, :kontakt)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(insertMap), keyHolder);
        Long id = keyHolder.getKey().longValue();
        instruktor.setId(id);
    }

    @Override
    public void uprav(Instruktor instruktor) {
        Map<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("id", instruktor.getId());
        updateMap.put("meno", instruktor.getMeno());
        updateMap.put("priezvisko", instruktor.getPriezvisko());
        updateMap.put("kontakt", instruktor.getKontakt());

        String sql = "UPDATE Instruktor SET meno = :meno, priezvisko = :priezvisko, kontakt = :kontakt WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, updateMap);
    }

    @Override
    public void vymaz(Instruktor instruktor) {
        String sql = "DELETE FROM Instruktor WHERE id = ?";
        jdbcTemplate.update(sql, instruktor.getId());
    }

}
