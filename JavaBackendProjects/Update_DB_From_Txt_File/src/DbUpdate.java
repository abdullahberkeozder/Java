import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class DbUpdate extends DbConnect {
    private String phoneNo = "";
    private String tc = "";
    private String ttID = "";
    private String name = "";

    private int digit_phoneNo;
    private int digit_tc;
    private int digit_ttId;
    private int digit_name;

    public int getDigit_phoneNo() {
        return digit_phoneNo;
    }

    public void setDigit_phoneNo(int digit_phoneNo) {
        this.digit_phoneNo = digit_phoneNo;
    }

    public int getDigit_tc() {
        return digit_tc;
    }

    public void setDigit_tc(int digit_tc) {
        this.digit_tc = digit_tc;
    }

    public int getDigit_ttId() {
        return digit_ttId;
    }

    public void setDigit_ttId(int digit_ttId) {
        this.digit_ttId = digit_ttId;
    }

    public int getDigit_name() {
        return digit_name;
    }

    public void setDigit_name(int digit_name) {
        this.digit_name = digit_name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTtID() {
        return ttID;
    }

    public void setTtID(String ttID) {
        this.ttID = ttID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Connection connect() {
        Connection conn = null;
        Statement st = null;
        try {
            // Connect to database
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            // get data from tt_getinfos table
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM tt_getinfos");

            // print data to screen
            while (resultSet.next()) {
                System.out.print("ID : " + resultSet.getInt("id") + " ");
                this.digit_phoneNo = resultSet.getInt("ttowners_getphoneno");
                System.out.print("Phone Number : " + resultSet.getString("ttowners_getphoneno") + " ");
                this.digit_tc = resultSet.getInt("ttowners_gettcid");
                System.out.print("TC : " + resultSet.getString("ttowners_gettcid") + " ");
                this.digit_ttId = resultSet.getInt("ttowners_getemployeeid");
                System.out.print("Employee Id : " + resultSet.getInt("ttowners_getemployeeid") + " ");
                this.digit_name = resultSet.getInt("ttowners_getname");
                System.out.print("Name : " + resultSet.getInt("ttowners_getname"));
            }
            try (BufferedReader reader = new BufferedReader(new FileReader("ttowners.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    char[] charArray = line.toCharArray();

                    // Parse the data fields from the line
                    String phoneNo = new String(charArray, 0, this.getDigit_phoneNo());
                    String tc = new String(charArray, this.getDigit_phoneNo(), this.getDigit_tc());
                    String ttID = new String(charArray, (this.getDigit_phoneNo() + this.getDigit_tc()),
                            this.getDigit_ttId());
                    String name = new String(new String(charArray,
                            (this.getDigit_phoneNo() + this.getDigit_tc() + getDigit_ttId()),
                            charArray.length - (this.getDigit_phoneNo() + this.getDigit_tc() + getDigit_ttId())));

                    // Insert the data into the database
                    PreparedStatement pr = conn.prepareStatement(
                            "INSERT INTO tt_infos (ttowners_phoneno, ttowners_tcid, ttowners_employeeid, ttowners_name) VALUES (?, ?, ?, ?)");
                    pr.setString(1, phoneNo);
                    pr.setString(2, tc);
                    pr.setString(3, ttID);
                    pr.setString(4, name);
                    pr.executeUpdate();
                    pr.close();
                }
                // Close the database connection
                conn.close();
            } catch (IOException e) {
                System.err.println("An IO exception occurred: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("A SQL exception occurred: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
