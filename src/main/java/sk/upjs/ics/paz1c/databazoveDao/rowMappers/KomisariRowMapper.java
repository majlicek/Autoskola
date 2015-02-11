/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.databazoveDao.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.ics.paz1c.entity.Komisari;

/**
 *
 * @author Majlo
 */
public class KomisariRowMapper implements RowMapper<Komisari>{

    @Override
    public Komisari mapRow(ResultSet rs, int rowNum) throws SQLException {
        Komisari komisar = new Komisari();
        
        komisar.setId(rs.getLong("KomisarId"));
        komisar.setMeno(rs.getString("KomisarMeno"));
        komisar.setPriezvisko(rs.getString("KomisarPriezvisko"));
        komisar.setHodnost(rs.getString("KomisarHodnost"));
        
        return komisar;
    }
    
}
