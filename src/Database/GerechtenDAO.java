/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Domain.Gerechten;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sirch
 */
public class GerechtenDAO {
    
    
    public GerechtenDAO()
    {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }
    
    /**
     * Tries to find the member identified by the given membership number
     * in the persistent data store, in this case a MySQL database. All loans
     * and reservations for the member are loaded as well. In this POC, the
     * reserved books and/or lend copies of the books are not loaded - it is
     * out of scope for now.
     * 
     * @param gerechtNummer identifies the member to be loaded from the database
     * 
     * @return the Member object to be found. In case member could not be found,
     * null is returned.
     */
    public Gerechten findgerechtNummer(int gerechtNummer)
    {
        Gerechten gerechten = null;
        
        // First open a database connnection
        Connection connection = new Connection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                "SELECT * FROM gerechten WHERE gerechtNummer = " + gerechtNummer + ";");

            if(resultset != null)
            {
                try
                {
                    // The membershipnumber for a member is unique, so in case the
                    // resultset does contain data, we need its first entry.
                    if(resultset.next())
                    {
                        int gerechtNummerDb = resultset.getInt("gerechtNummer");
                        String naamDb = resultset.getString("naam");
                        String prijsDb = resultset.getString("prijs");

                        gerechten = new Gerechten(
                            gerechtNummerDb,
                            naamDb,
                            prijsDb);
                        

                    }
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                    gerechten = null;
                }
            }
            // else an error occurred leave 'member' to null.
            
            // We had a database connection opened. Since we're finished,
            // we need to close it.
            connection.closeConnection();
        }
        
        return gerechten;
    } }