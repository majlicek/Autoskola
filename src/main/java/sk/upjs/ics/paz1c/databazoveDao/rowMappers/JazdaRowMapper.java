package sk.upjs.ics.paz1c.databazoveDao.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Jazda;

public class JazdaRowMapper implements RowMapper<Jazda> {

    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    private InstruktorRowMapper instruktorRowMapper = new InstruktorRowMapper();

    private VozidloRowMapper vozidloRowMapper = new VozidloRowMapper();

    @Override
    public Jazda mapRow(ResultSet rs, int rowNum) throws SQLException {
        Jazda jazda = new Jazda();

        jazda.setId(rs.getLong("JazdaId"));
        jazda.setStudent(studentRowMapper.mapRow(rs, rowNum));
        jazda.setInstruktor(instruktorRowMapper.mapRow(rs, rowNum));
        jazda.setVozidlo(vozidloRowMapper.mapRow(rs, rowNum));
        jazda.setDatum(rs.getDate("JazdaDatum"));
        jazda.setCas(rs.getTime("JazdaCas"));
        jazda.setKm(rs.getInt("JazdaKm"));
        jazda.setvPremavke(rs.getBoolean("JazdaVPremavke"));
        jazda.setNaCvicisku(rs.getBoolean("JazdaNaCvicisku"));
        jazda.setsVozikom(rs.getBoolean("JazdaSVozikom"));

        return jazda;
    }

}
