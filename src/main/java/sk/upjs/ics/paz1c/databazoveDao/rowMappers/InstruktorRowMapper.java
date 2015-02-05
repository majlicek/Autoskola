package sk.upjs.ics.paz1c.databazoveDao.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Instruktor;

public class InstruktorRowMapper implements RowMapper<Instruktor> {

    @Override
    public Instruktor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Instruktor instruktor = new Instruktor();

        instruktor.setId(rs.getLong("InstruktorId"));
        instruktor.setMeno(rs.getString("InstruktorMeno"));
        instruktor.setPriezvisko(rs.getString("InstruktorPriezvisko"));
        instruktor.setKontakt(rs.getString("InstruktorKontakt"));

        return instruktor;
    }

}
