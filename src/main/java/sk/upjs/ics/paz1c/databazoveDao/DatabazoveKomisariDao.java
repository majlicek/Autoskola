/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.databazoveDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.ics.paz1c.dao.KomisariDao;
import sk.upjs.ics.paz1c.databazoveDao.rowMappers.KomisariRowMapper;
import sk.upjs.ics.paz1c.entity.Komisari;

/**
 *
 * @author Majlo
 */
public class DatabazoveKomisariDao implements KomisariDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private KomisariRowMapper komisariRowMapper = new KomisariRowMapper();

    public DatabazoveKomisariDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public List<Komisari> dajVsetky() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_KOMISARI, komisariRowMapper);
    }

    @Override
    public List<Komisari> hladajPodlaMena(String meno) {
        meno = meno.trim();
        meno = "%" + meno + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_KOMISARI_BY_MENO, komisariRowMapper, meno);
    }

    @Override
    public List<Komisari> hladajPodlaPriezviska(String priezvisko) {
        priezvisko = priezvisko.trim();
        priezvisko = "%" + priezvisko + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_KOMISARI_BY_PRIEZVISKO, komisariRowMapper, priezvisko);
    }

    @Override
    public List<Komisari> hladajPodlaHodnosti(String hodnost) {
        hodnost = hodnost.trim();
        hodnost = "%" + hodnost + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_KOMISARI_BY_HODNOST, komisariRowMapper, hodnost);
    }

    @Override
    public void uloz(Komisari komisar) {
        Map<String, Object> insertMap = new HashMap<String, Object>();
        insertMap.put("meno", komisar.getMeno());
        insertMap.put("priezvisko", komisar.getPriezvisko());
        insertMap.put("hodnost", komisar.getHodnost());

        String sql = "INSERT INTO Komisari (meno, priezvisko, hodnost)\n"
                + "VALUES (:meno, :priezvisko, :hodnost)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(insertMap), keyHolder);
        Long id = keyHolder.getKey().longValue();
        komisar.setId(id);
    }

    @Override
    public void uprav(Komisari komisar) {
        Map<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("id", komisar.getId());
        updateMap.put("meno", komisar.getMeno());
        updateMap.put("priezvisko", komisar.getPriezvisko());
        updateMap.put("hodnost", komisar.getHodnost());

        String sql = "UPDATE Komisari SET meno = :meno, priezvisko = :priezvisko, hodnost = :hodnost WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, updateMap);
    }

    @Override
    public void vymaz(Komisari komisar) {
        String sql = "DELETE FROM Komisari WHERE id = ?";
        jdbcTemplate.update(sql, komisar.getId());
    }

}
