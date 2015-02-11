package sk.upjs.ics.paz1c.databazoveDao.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.autoskola.BeanFactory;
import sk.upjs.ics.paz1c.dao.StudentiDao;
import sk.upjs.ics.paz1c.entity.Skuska;

public class SkuskaRowMapper implements RowMapper<Skuska> {

    private StudentRowMapper studentRowMapper = new StudentRowMapper();

    private InstruktorRowMapper instruktorRowMapper = new InstruktorRowMapper();
    
    private KomisariRowMapper komisariRowMapper = new KomisariRowMapper();

    private StudentiDao studentiDao = BeanFactory.INSTANCE.getStudentiDao();

    @Override
    public Skuska mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skuska skuska = new Skuska();

        skuska.setId(rs.getLong("SkuskaId"));
        skuska.setDatum(rs.getDate("SkuskaDatum"));
        skuska.setCas(rs.getTime("SkuskaCas"));
        skuska.setInstruktor(instruktorRowMapper.mapRow(rs, rowNum));
        skuska.setKomisar(komisariRowMapper.mapRow(rs, rowNum));
        skuska.setStudenti(studentiDao.dajPodlaSkusky(skuska));

        return skuska;
    }

}
