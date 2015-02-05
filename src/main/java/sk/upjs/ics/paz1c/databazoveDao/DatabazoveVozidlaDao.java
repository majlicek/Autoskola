package sk.upjs.ics.paz1c.databazoveDao;

import sk.upjs.ics.paz1c.databazoveDao.rowMappers.VozidloRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.ics.paz1c.dao.VozidlaDao;
import sk.upjs.ics.paz1c.entity.Vozidlo;

public class DatabazoveVozidlaDao implements VozidlaDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private VozidloRowMapper vozidloRowMapper = new VozidloRowMapper();

    public DatabazoveVozidlaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public List<Vozidlo> dajVsetky() {
        return jdbcTemplate.query(SqlQueries.SELECT_ALL_VOZIDLO, vozidloRowMapper);
    }

    @Override
    public List<Vozidlo> hladajPodlaSpz(String spz) {
        spz = spz.trim();
        spz = "%" + spz + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_VOZIDLO_BY_SPZ, vozidloRowMapper, spz);
    }

    @Override
    public List<Vozidlo> hladajPodlaZnacky(String znacka) {
        znacka = znacka.trim();
        znacka = "%" + znacka + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_VOZIDLO_BY_ZNACKA, vozidloRowMapper, znacka);
    }

    @Override
    public List<Vozidlo> hladajPodlaKategorie(String kategoria) {
        kategoria = kategoria.trim();
        kategoria = "%" + kategoria + "%";
        return jdbcTemplate.query(SqlQueries.SELECT_VOZIDLO_BY_KATEGORIA, vozidloRowMapper, kategoria);
    }

    @Override
    public void uloz(Vozidlo vozidlo) {
        Map<String, Object> insertMap = new HashMap<String, Object>();
        insertMap.put("spz", vozidlo.getSpz());
        insertMap.put("znacka", vozidlo.getZnacka());
        insertMap.put("typ", vozidlo.getTyp());
        insertMap.put("farba", vozidlo.getFarba());
        insertMap.put("kategoria", vozidlo.getKategoria());

        String sql = "INSERT INTO Vozidlo (spz, znacka, typ, farba, kategoria)\n"
                + "VALUES(:spz, :znacka, :typ, :farba, :kategoria)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(insertMap), keyHolder);
        Long id = keyHolder.getKey().longValue();
        vozidlo.setId(id);
    }

    @Override
    public void uprav(Vozidlo vozidlo) {
        Map<String, Object> updateMap = new HashMap<String, Object>();
        updateMap.put("id", vozidlo.getId());
        updateMap.put("spz", vozidlo.getSpz());
        updateMap.put("znacka", vozidlo.getZnacka());
        updateMap.put("typ", vozidlo.getTyp());
        updateMap.put("farba", vozidlo.getFarba());
        updateMap.put("kategoria", vozidlo.getKategoria());

        String sql = "UPDATE Vozidlo SET spz = :spz, znacka = :znacka, typ = :typ, farba = :farba, kategoria = :kategoria WHERE id = :id";

        namedParameterJdbcTemplate.update(sql, updateMap);
    }

    @Override
    public void vymaz(Vozidlo vozidlo) {
        String sql = "DELETE FROM Vozidlo WHERE id = ?";
        jdbcTemplate.update(sql, vozidlo.getId());
    }

}
