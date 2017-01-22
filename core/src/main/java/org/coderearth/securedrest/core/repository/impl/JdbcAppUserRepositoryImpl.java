package org.coderearth.securedrest.core.repository.impl;

import org.coderearth.securedrest.core.model.AppUser;
import org.coderearth.securedrest.core.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * Created by kunal_patel on 1/21/17.
 */
@Repository
public class JdbcAppUserRepositoryImpl implements AppUserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppUserRepository.class);
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAppUserRepositoryImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AppUser findByUsername(final String username) {
        return null;
    }

    @PostConstruct
    public void postInitChecks() throws SQLException {
        LOGGER.debug("{}", this.jdbcTemplate.getDataSource().getConnection().toString());
    }
}
