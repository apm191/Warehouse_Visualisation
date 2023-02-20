package com.example.warehouse_visual.Dao;

import com.example.warehouse_visual.Models.Tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TrackerRepository_JDBC
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Tracker> findByIdStation(String Id,String flag)
    {
        String query;
        if(flag.equals("station"))
            query = "select * from tracker where station_id=?";
        else if(flag.equals("date"))
            query = "select * from tracker where date=?";
        else if(flag.equals("container"))
            query = "select * from tracker where container_id=?";
        else
            query = "select * from tracker where time=?";
        List<Tracker> trackerList = this.jdbcTemplate.query(query, new ResultSetExtractor<List<Tracker>>() {
            @Override
            public List<Tracker> extractData(ResultSet rs) throws SQLException, DataAccessException
            {
                List<Tracker> trackerList = new ArrayList<>();
                while(rs.next())
                {
                    Tracker tracker = new Tracker();
                    tracker.setId(rs.getInt("status_id"));
                    tracker.setFromScanner(rs.getString("from_scanner"));
                    tracker.setToScanner(rs.getString("to_scanner"));
                    tracker.setContainerId(rs.getString("container_id"));
                    tracker.setCreatedAt(rs.getTimestamp("date"));
                    tracker.setColor(rs.getString("color"));

                    trackerList.add(tracker);
                }
                return trackerList;
            }
        },Id);
        return trackerList;
    }
}
