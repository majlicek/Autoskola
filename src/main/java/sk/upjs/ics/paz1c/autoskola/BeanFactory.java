package sk.upjs.ics.paz1c.autoskola;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.dao.*;
import sk.upjs.ics.paz1c.databazoveDao.*;

public enum BeanFactory {

    INSTANCE;
    
    public static final int PRVY_ROK = 2014;
    
    public static final int PRVY_ROK_NARODENIA = 1900;

    private StudentiDao studentiDao;

    private VozidlaDao vozidlaDao;

    private InstruktoriDao instruktoriDao;

    private JazdyDao jazdyDao;

    private SkuskyDao skuskyDao;
    
    private KomisariDao komisariDao;

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;    

    public StudentiDao getStudentiDao() {
        if (studentiDao == null) {
            studentiDao = new DatabazoveStudentiDao(jdbcTemplate());
        }
        return this.studentiDao;
    }

    public VozidlaDao getVozidlaDao() {
        if (vozidlaDao == null) {
            vozidlaDao = new DatabazoveVozidlaDao(jdbcTemplate());
        }
        return this.vozidlaDao;
    }

    public InstruktoriDao getInstruktoriDao() {
        if (instruktoriDao == null) {
            instruktoriDao = new DatabazoveInstruktoriDao(jdbcTemplate());
        }
        return this.instruktoriDao;
    }

    public JazdyDao getJazdyDao() {
        if (jazdyDao == null) {
            jazdyDao = new DatabazoveJazdyDao(jdbcTemplate());
        }
        return this.jazdyDao;
    }

    public SkuskyDao getSkuskyDao() {
        if (skuskyDao == null) {
            skuskyDao = new DatabazoveSkuskyDao(jdbcTemplate());
        }
        return this.skuskyDao;
    }
    
    public KomisariDao getKomisariDao() {
        if (komisariDao == null) {
            komisariDao = new DatabazoveKomisariDao(jdbcTemplate());
        }
        return this.komisariDao;
    }

    public JdbcTemplate jdbcTemplate() {
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(dataSource());
        }
        return this.jdbcTemplate;
    }

    private DataSource dataSource() {
        if (this.dataSource == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
//            Properties properties = getProperties();
//            if ("test".equals(properties.get("rezim"))) {
//                dataSource.setUrl("jdbc:mysql://db4free.net:3306/autoskolapaztest?zeroDateTimeBehavior=convertToNull");
//                dataSource.setUser("autoskolapaztest");
//            } else {
                dataSource.setUrl("jdbc:mysql://sql3.freemysqlhosting.net:3306/sql366530?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
                dataSource.setUser("sql366530");
                dataSource.setPassword("qH2%gA5%");
//            }
//            dataSource.setPassword(properties.getProperty("heslo"));
            this.dataSource = dataSource;
        }

        return this.dataSource;
    }

    private Properties getProperties() {
        try {
            String propertiesFile;

            if ("true".equals(System.getProperty("testovaciRezim"))) {
                propertiesFile = "/autoskola-test.properties";
            } else {
                propertiesFile = "/autoskola.properties";
            }

            InputStream in = BeanFactory.class.getResourceAsStream(propertiesFile);

            Properties properties = new Properties();
            properties.load(in);

            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Nenasiel sa konfiguracny subor");
        }
    }

}
