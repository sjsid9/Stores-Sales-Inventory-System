/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package optimusinventorysystem.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import oracle.sql.*;
import oracle.jdbc.*;
/**
 *
 * @author Rajesh
 */
public class DBOperations {

    //----------------------------------------------------------------------
    //                               Login Related
    //----------------------------------------------------------------------
    public UsermasterBean authenticateUser(String userName, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where Username = ?");
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    objBean = new UsermasterBean();
                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setUsername(rs.getString("Username"));
                    objBean.setPassword(rs.getString("Password"));
                    objBean.setUserType(rs.getString("User_Type"));
                    objBean.setUserStatus(rs.getString("User_Status"));
                    objBean.setSecurityQuestion(rs.getString("Security_Question"));
                    objBean.setSecurityAnswer(rs.getString("Security_Answer"));
                }
            }
        } catch (Exception e) {
            System.out.println("authenticateUser(String userName, String password) : of DBoperations" + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("authenticateUser(String userName, String password) : of DBoperations" + e);
            }
        }
        return objBean;
    }

    public UsermasterBean getUserDetailByUsername(String userName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsermasterBean objBean = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where Username = ?");
            pstmt.setString(1, userName);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                objBean = new UsermasterBean();
                objBean.setUserId(rs.getInt("User_ID"));
                objBean.setUsername(rs.getString("Username"));
                objBean.setPassword(rs.getString("Password"));
                objBean.setUserType(rs.getString("User_Type"));
                objBean.setUserStatus(rs.getString("User_Status"));
                objBean.setSecurityQuestion(rs.getString("Security_Question"));
                objBean.setSecurityAnswer(rs.getString("Security_Answer"));
            }
        } catch (Exception e) {
            System.out.println("getUserDetailByUsername(String userName)  of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getUserDetailByUsername(String userName) of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public String getEmailByUsername(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select email from usermaster um,userpersonaldetail upd where um.user_id=upd.user_id and um.username=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                result = rs.getString("email");
            }
        } catch (Exception e) {
            System.out.println("in getEmailByUsername(username) in dboperation" + e);
            return result;
        } finally {
            try {

                rs.close();
                pstmt.close();
                conn.close();

            } catch (Exception e) {
                System.out.println("in getEmailByUsername(username) in dboperation finally" + e);
                return result;
            }
        }
        return result;
    }

    public int addUserActivity(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int userActivityId = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into useractivitymaster ( User_ID ,Login_Time) values(?,?) ");
            pstmt.setInt(1, userId);
            pstmt.setString(2, getCurrentDateTime());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                pstmt = conn.prepareStatement("select max(Activity_ID) from useractivitymaster");
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    userActivityId = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            System.out.println("addUserActivity(int userId) of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("addUserActivity(int userId) of DBoperations : " + e);
            }
        }
        return userActivityId;
    }

    public void updateUserActivity(int userActivityId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update useractivitymaster set Logout_Time = ? where Activity_ID=?");
            pstmt.setString(1, getCurrentDateTime());
            pstmt.setInt(2, userActivityId);

            int i = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("addUserActivity(int userId) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("addUserActivity(int userId) of DBoperations : " + e);
            }
        }
    }

    public ArrayList getAllUserActivityDetailList() {
        Connection conn = null;
        ArrayList alstUserActivity = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select uam.Activity_ID,uam.User_ID,um.Username, uam.Login_Time,uam.Logout_Time  from usermaster um,useractivitymaster uam where um.User_Id=uam.User_Id");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    UserActivityMasterBean objBean = new UserActivityMasterBean();
                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setActivityId(rs.getInt("Activity_ID"));
                    objBean.setUsername(rs.getString("Username"));
                    objBean.setLoginTime(rs.getString("Login_Time"));
                    objBean.setLogoutTime(rs.getString("Logout_Time"));
                    alstUserActivity.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("getAllUserActivityDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUserActivityDetailList() of DBoperations : " + e);
            }
        }
        return alstUserActivity;
    }

    public ArrayList getAllUserActivityDetailListByUsername(String username) {
        Connection conn = null;
        ArrayList alstUserActivity = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select uam.Activity_ID,uam.User_ID,um.Username, uam.Login_Time,uam.Logout_Time  from usermaster um,useractivitymaster uam where um.User_Id=uam.User_Id and um.Username=?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    UserActivityMasterBean objBean = new UserActivityMasterBean();
                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setActivityId(rs.getInt("Activity_ID"));
                    objBean.setUsername(rs.getString("Username"));
                    objBean.setLoginTime(rs.getString("Login_Time"));
                    objBean.setLogoutTime(rs.getString("Logout_Time"));
                    alstUserActivity.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("getAllUserActivityDetailListByUsername(String username)  of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUserActivityDetailListByUsername(String username)  of DBoperations : " + e);
            }
        }
        return alstUserActivity;
    }
    //-------------------------------------------------------------------------
    //                                 UserAccountDetail Related
    //-------------------------------------------------------------------------

    public ArrayList getAllUserNameList() {
        Connection conn = null;
        ArrayList alstUser = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Username from usermaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                alstUser.add(rs.getString("Username"));
            }
        } catch (Exception e) {
            System.out.println("getAllUserList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUserList() of DBoperations : " + e);
            }
        }
        return alstUser;
    }

    public ArrayList getAllUserDetailList() {
        Connection conn = null;
        ArrayList alstUser = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select um.User_ID,Username,Password,User_Type,User_Status,Security_Question,Security_Answer from usermaster um,userpersonaldetail upd where um.User_Id=upd.User_Id");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    UsermasterBean objBean = new UsermasterBean();
                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setUsername(rs.getString("Username"));
                    objBean.setPassword(rs.getString("Password"));
                    objBean.setUserType(rs.getString("User_Type"));
                    objBean.setUserStatus(rs.getString("User_Status"));
                    objBean.setSecurityQuestion(rs.getString("Security_Question"));
                    objBean.setSecurityAnswer(rs.getString("Security_Answer"));
                    alstUser.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("getAllUserDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllUserDetailList() of DBoperations : " + e);
            }
        }
        return alstUser;
    }

    public UsermasterBean getUserAccountDetailByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UsermasterBean objBean = new UsermasterBean();
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select User_ID,Username,Password,User_Type,User_Status,Security_Question,Security_Answer from usermaster where User_Id = ?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                {

                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setUsername(rs.getString("Username"));
                    objBean.setPassword(rs.getString("Password"));
                    objBean.setUserType(rs.getString("User_Type"));
                    objBean.setUserStatus(rs.getString("User_Status"));
                    objBean.setSecurityQuestion(rs.getString("Security_Question"));
                    objBean.setSecurityAnswer(rs.getString("Security_Answer"));
                }
            }
        } catch (Exception e) {
            System.out.println("getUserDetailByUserId(int userId) of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getUserDetailByUserId(int userId) of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public int getMaxUserId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxUserID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(User_ID) from usermaster");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxUserID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getMaxUserId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getMaxUserId() of DBoperations : " + e);
            }
        }
        return maxUserID;
    }

    public String addUserAccountDetail(UsermasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where Username = ?");
            pstmt.setString(1, objBean.getUsername());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = "exists";
            } else {

                pstmt = conn.prepareStatement("insert into usermaster ( User_ID ,Username ,Password,User_Type, User_Status ,Security_Question , Security_Answer) values(?,?,?,?,?,?,?) ");
                pstmt.setInt(1, objBean.getUserId());
                pstmt.setString(2, objBean.getUsername());
                pstmt.setString(3, objBean.getPassword());
                pstmt.setString(4, objBean.getUserType());
                pstmt.setString(5, objBean.getUserStatus());
                pstmt.setString(6, objBean.getSecurityQuestion());
                pstmt.setString(7, objBean.getSecurityAnswer());

                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    pstmt = conn.prepareStatement("insert into userpersonaldetail ( User_ID) values(?) ");
                    pstmt.setInt(1, objBean.getUserId());
                    int j = pstmt.executeUpdate();
                    if (j > 0) {
                        result = "added";
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("addUserAccountDetail(UsermasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("addUserAccountDetail(UsermasterBean objBean) of DBoperations : " + e);
            }
        }
        return result;
    }

    public String updateUserAccountDetail(UsermasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from usermaster where Username = ? and User_ID !=?");
            pstmt.setString(1, objBean.getUsername());
            pstmt.setInt(2, objBean.getUserId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                result = "exists";
            } else {
                pstmt = conn.prepareStatement("update usermaster set Username = ?,Password=?,User_Type =?, User_Status = ? ,Security_Question = ?, Security_Answer = ? where User_ID=?");
                pstmt.setString(1, objBean.getUsername());
                pstmt.setString(2, objBean.getPassword());
                pstmt.setString(3, objBean.getUserType());
                pstmt.setString(4, objBean.getUserStatus());
                pstmt.setString(5, objBean.getSecurityQuestion());
                pstmt.setString(6, objBean.getSecurityAnswer());
                pstmt.setInt(7, objBean.getUserId());
                System.out.println(pstmt.toString());
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    result = "updated";
                }
            }
        } catch (Exception e) {
            System.out.println("updateUserAccountDetail(UsermasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("updateUserAccountDetail(UsermasterBean objBean) of DBoperations : " + e);
            }
        }
        return result;
    }

    //---------------------------------------------------------------------------------------
    //        UserPersonalDetail Related
    //-----------------------------------------------------------------------------------------------
    public ArrayList getAllUserPersonalDetailList() {
        Connection conn = null;
        ArrayList alstUser = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select upd.User_ID,Name,Date_Of_Birth,Address,Phone,Mobile,Email from usermaster um,userpersonaldetail upd where um.User_Id=upd.User_Id");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    UserPersonalDetailBean objBean = new UserPersonalDetailBean();
                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setName(rs.getString("Name"));
                    objBean.setDateOfBirth(rs.getString("Date_Of_Birth"));
                    objBean.setAddress(rs.getString("Address"));
                    objBean.setPhone(rs.getString("Phone"));
                    objBean.setMobile(rs.getString("Mobile"));
                    objBean.setEmail(rs.getString("Email"));
                    alstUser.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllUserPersonalDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllUserPersonalDetailList() finally of DBoperations : " + e);
            }
        }
        return alstUser;
    }

    public UserPersonalDetailBean getUserPersonalDetailByUserId(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UserPersonalDetailBean objBean = new UserPersonalDetailBean();
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select User_ID,Name,Date_Of_Birth,Address,Phone,Mobile,Email from userpersonaldetail where User_Id=?");
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                {
                    objBean.setUserId(rs.getInt("User_ID"));
                    objBean.setName(rs.getString("Name"));
                    objBean.setDateOfBirth(rs.getString("Date_Of_Birth"));
                    objBean.setAddress(rs.getString("Address"));
                    objBean.setPhone(rs.getString("Phone"));
                    objBean.setMobile(rs.getString("Mobile"));
                    objBean.setEmail(rs.getString("Email"));
                }
            }
        } catch (Exception e) {
            System.out.println("getUserPersonalDetailByUserId(int userId) of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getUserPersonalDetailByUserId(int userId) of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public String updateUserPersonalDetail(UserPersonalDetailBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update userpersonaldetail set Name = ?,Date_Of_Birth=?,Address =?, Phone = ? ,Mobile = ?, Email= ? where User_ID =?");
            pstmt.setString(1, objBean.getName());
            pstmt.setString(2, objBean.getDateOfBirth());
            pstmt.setString(3, objBean.getAddress());
            pstmt.setString(4, objBean.getPhone());
            pstmt.setString(5, objBean.getMobile());
            pstmt.setString(6, objBean.getEmail());
            pstmt.setInt(7, objBean.getUserId());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("updateUserPersonalDetail(UserPersonalDetailBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("updateUserPersonalDetail(UserPersonalDetailBean objBean) of DBoperations : " + e);
            }
        }
        return result;
    }

    /*
     * --------------Client Personal Detail Related-------
     */
    public ArrayList getAllClientPersonalDetailList() {
        Connection conn = null;
        ArrayList alstUser = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from clientpersonal order by Client_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    ClientPersonalBean objBean = new ClientPersonalBean();
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setName(rs.getString("Name"));
                    objBean.setAddress(rs.getString("Address"));

                    objBean.setPhone(rs.getString("Phone"));
                    objBean.setMobile(rs.getString("Mobile"));
                    objBean.setPan(rs.getString("PAN"));
                    alstUser.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllClientPersonalDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllClientPersonalDetailList() finally of DBoperations : " + e);
            }
        }
        return alstUser;
    }

    public int getMaxClientPersonalId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxClientID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(Client_ID) from clientpersonal");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxClientID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getMaxClientPersonalId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getMaxClientPersonalId() of DBoperations : " + e);
            }
        }
        return maxClientID;
    }

    public String addClientPersonalDetail(ClientPersonalBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into  clientpersonal (Client_ID,Name,Address, Phone ,Mobile, PAN) values (?,?,?,?,?,?)");
            pstmt.setInt(1, objBean.getClient_ID());
            pstmt.setString(2, objBean.getName());

            pstmt.setString(3, objBean.getAddress());
            pstmt.setString(4, objBean.getPhone());
            pstmt.setString(5, objBean.getMobile());
            pstmt.setString(6, objBean.getPan());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                pstmt = conn.prepareStatement("insert into  clientresponsibility (Client_ID) values (?)");
                pstmt.setInt(1, objBean.getClient_ID());
                int j = pstmt.executeUpdate();
                if (j > 0) {
                    pstmt = conn.prepareStatement("insert into  clientprofessional (Client_ID) values (?)");
                    pstmt.setInt(1, objBean.getClient_ID());
                    int k = pstmt.executeUpdate();
                    if (k > 0) {
                        result = "Added";
                    }

                }

            }
        } catch (Exception e) {
            System.out.println("Exception in addClientPersonalDetail(ClientPersonalBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in addClientPersonalDetail(ClientPersonalBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    public String updateClientPersonalDetail(ClientPersonalBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update clientpersonal set Name = ?,Address =?, Phone = ? ,Mobile = ?, PAN= ? where Client_ID =?");
            pstmt.setString(1, objBean.getName());

            pstmt.setString(2, objBean.getAddress());
            pstmt.setString(3, objBean.getPhone());
            pstmt.setString(4, objBean.getMobile());
            pstmt.setString(5, objBean.getPan());
            pstmt.setInt(6, objBean.getClient_ID());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateClientPersonalDetail(ClientPersonalBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateClientPersonalDetail(ClientPersonalBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }
    /*
     * --------------Client Professional Detail Related-------
     */

    public ArrayList getAllClientProfessionalDetailList() {
        Connection conn = null;
        ArrayList alstClientProfessional = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from clientprofessional order by Client_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    ClientProfessionalBean objBean = new ClientProfessionalBean();
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setAnnual_Income(rs.getDouble("Annual_Income"));
                    objBean.setDesignation(rs.getString("Designation"));

                    objBean.setIncome_Other(rs.getDouble("Income_Other"));
                    objBean.setOffice_Address(rs.getString("Office_Address"));
                    objBean.setOffice_Phone(rs.getString("Office_Phone"));
                    objBean.setProfession(rs.getString("Profession"));
                    alstClientProfessional.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllClientProfessionalDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllClientProfessionalDetailList() finally of DBoperations : " + e);
            }
        }
        return alstClientProfessional;
    }
    public ClientProfessionalBean getClientProfessionalDetailByClientId(int clientId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
ClientProfessionalBean objBean = new ClientProfessionalBean();
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from clientprofessional where Client_ID=?");
            pstmt.setInt(1, clientId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setAnnual_Income(rs.getDouble("Annual_Income"));
                    objBean.setDesignation(rs.getString("Designation"));

                    objBean.setIncome_Other(rs.getDouble("Income_Other"));
                    objBean.setOffice_Address(rs.getString("Office_Address"));
                    objBean.setOffice_Phone(rs.getString("Office_Phone"));
                    objBean.setProfession(rs.getString("Profession"));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getClientProfessionalDetailByClientId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getClientProfessionalDetailByClientId() finally of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public String updateClientProfessionalDetail(ClientProfessionalBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update clientprofessional set Designation= ?,Office_Address =?, Office_Phone = ? ,Profession = ?, Annual_Income= ?,Income_Other=? where Client_ID =?");
            pstmt.setString(1, objBean.getDesignation());

            pstmt.setString(2, objBean.getOffice_Address());
            pstmt.setString(3, objBean.getOffice_Phone());
            pstmt.setString(4, objBean.getProfession());
            pstmt.setDouble(5, objBean.getAnnual_Income());
            pstmt.setDouble(6, objBean.getIncome_Other());
            pstmt.setInt(7, objBean.getClient_ID());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateClientProfessionalDetail(ClientProfessionalBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateClientProfessionalDetail(ClientProfessionalBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    /*
     * --------------Client Responsibility Detail Related-------
     */
    public ArrayList getAllClientResponsibilityDetailList() {
        Connection conn = null;
        ArrayList alstClientProfessional = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from clientresponsibility order by Client_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    ClientResponsibilityBean objBean = new ClientResponsibilityBean();
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setDependents(rs.getInt("Dependents"));

                    objBean.setHealth_Expenditure(rs.getDouble("Health_Expenditure"));
                    objBean.setHouse_Rent(rs.getDouble("House_Rent"));

                    objBean.setInsurance_EMI(rs.getDouble("Insurance_EMI"));
                    objBean.setLoan_EMI(rs.getDouble("Loan_EMI"));

                    objBean.setPersonal_Expenditure(rs.getDouble("Personal_Expenditure"));
                    objBean.setTax_Deduction(rs.getDouble("Tax_Deduction"));

                    alstClientProfessional.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllClientResponsibilityDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllClientResponsibilityDetailList() finally of DBoperations : " + e);
            }
        }
        return alstClientProfessional;
    }
    public ClientResponsibilityBean getClientResponsibilityDetailByClientID(int clientId) {
        Connection conn = null;
          ClientResponsibilityBean objBean = new ClientResponsibilityBean();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from clientresponsibility where Client_ID = ?");
            pstmt.setInt(1, clientId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setDependents(rs.getInt("Dependents"));

                    objBean.setHealth_Expenditure(rs.getDouble("Health_Expenditure"));
                    objBean.setHouse_Rent(rs.getDouble("House_Rent"));

                    objBean.setInsurance_EMI(rs.getDouble("Insurance_EMI"));
                    objBean.setLoan_EMI(rs.getDouble("Loan_EMI"));

                    objBean.setPersonal_Expenditure(rs.getDouble("Personal_Expenditure"));
                    objBean.setTax_Deduction(rs.getDouble("Tax_Deduction"));

                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getClientResponsibilityDetailByClientID() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getClientResponsibilityDetailByClientID() finally of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public String updateClientResponsibilityDetail(ClientResponsibilityBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update clientresponsibility set Dependents=?,Health_Expenditure= ?,House_Rent =?, Insurance_EMI = ? ,Loan_EMI = ?, Personal_Expenditure= ?,Tax_Deduction=? where Client_ID =?");
            pstmt.setInt(1, objBean.getDependents());

            pstmt.setDouble(2, objBean.getHealth_Expenditure());
            pstmt.setDouble(3, objBean.getHouse_Rent());
            pstmt.setDouble(4, objBean.getInsurance_EMI());
            pstmt.setDouble(5, objBean.getLoan_EMI());
            pstmt.setDouble(6, objBean.getPersonal_Expenditure());
            pstmt.setDouble(7, objBean.getTax_Deduction());


            pstmt.setInt(8, objBean.getClient_ID());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateClientResponsibilityDetail(ClientProfessionalBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateClientResponsibilityDetail(ClientProfessionalBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }
    
    /*
     * --------------------Product Detail Related-------------
     */
    public int getMaxProductId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxProductID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(Product_ID) from productmaster");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxProductID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getMaxProductId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getMaxProductId() of DBoperations : " + e);
            }
        }
        return maxProductID;
    }
    
    public ArrayList getAllProductDetailList() {
        Connection conn = null;
        ArrayList alstClientProfessional = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from productmaster order by Product_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    ProductMasterBean objBean = new ProductMasterBean();
                    objBean.setProduct_ID(rs.getInt("Product_ID"));
                    objBean.setProduct_type(rs.getString("Product_Type"));
                    //objBean.setName(rs.getString("Name"));
                   // objBean.setQuantity(rs.getInt("Quantity"));
                   // objBean.setPrice(rs.getInt("Price"));
                    alstClientProfessional.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllProductDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllProductDetailList() finally of DBoperations : " + e);
            }
        }
        return alstClientProfessional;
    }
    public ProductMasterBean getProductDetailByProductId(int productId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
            ProductMasterBean objBean = new ProductMasterBean();
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from productmaster where Product_ID=?");
            pstmt.setInt(1, productId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                    objBean.setProduct_ID(rs.getInt("Product_ID"));
                    objBean.setProduct_type(rs.getString("Product_Type"));
                    /*objBean.setName(rs.getString("Name"));
                    objBean.setQuantity(rs.getInt("Quantity"));
                    objBean.setPrice(rs.getInt("Price"));*/
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getProductDetailByProductId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getProductDetailByProductId() finally of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public String updateProductDetail(ProductMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update productmaster set Product_Type=?where Product_ID =?");

            pstmt.setString(1, objBean.getProduct_type());
            pstmt.setInt(2, objBean.getProduct_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateProductDetail(PlanMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateProductDetail(PlanMasterBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    public String addProductDetail(ProductMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into  productmaster (Product_Id, Product_Type) values (?,?)");
            pstmt.setInt(1, objBean.getProduct_ID());
            pstmt.setString(2, objBean.getProduct_type());
           
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "added";
            }
        } catch (Exception e) {
            System.out.println("Exception in addProductDetail(PlanMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in addProductDetail(PlanMasterBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }
    /*
     * --------------------Product Category Detail Related-------------
     */
    public int getMaxProductCategoryId() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxProductCategoryID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(product_cat_ID) from productdetails");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxProductCategoryID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getMaxProductCategoryId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getMaxProductCategoryId() of DBoperations : " + e);
            }
        }
        return maxProductCategoryID;
    }
    
    public ArrayList getAllProductCategoryDetailList() {
        Connection conn = null;
        ArrayList alstClientProfessional = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from productdetails order by product_cat_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    ProductDetailBean objBean = new ProductDetailBean();
                    objBean.setProduct_cat_ID(rs.getInt("product_cat_ID"));
                    objBean.setName(rs.getString("Name"));
                    objBean.setQuantity(rs.getInt("Quantity"));
                    objBean.setPrice(rs.getInt("Price"));
                    objBean.setProduct_ID(rs.getInt("Product_ID"));
                    alstClientProfessional.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllProductCategoryDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllProductCategoryDetailList() finally of DBoperations : " + e);
            }
        }
        return alstClientProfessional;
    }
    public ProductDetailBean getProductDetailByProductCategoryId(int productcatId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
            ProductDetailBean objBean = new ProductDetailBean();
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from productdetails where Product_cat_ID=?");
            pstmt.setInt(1, productcatId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                    objBean.setProduct_cat_ID(rs.getInt("Product_Cat_ID"));
                    objBean.setName(rs.getString("Name"));
                    objBean.setQuantity(rs.getInt("Quantity"));
                    objBean.setPrice(rs.getInt("Price"));
                    objBean.setProduct_ID(rs.getInt("Product_ID"));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getProductDetailByProductCategoryId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getProductDetailByProductCategoryId() finally of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public String updateProductCategoryDetail(ProductDetailBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update productdetails set Name=? , Quantity=? , Price=?, Product_ID=? where product_cat_ID =?");

            pstmt.setString(1, objBean.getName());
            pstmt.setInt(2, objBean.getQuantity());
            pstmt.setDouble(3, objBean.getPrice());
            pstmt.setInt(4, objBean.getProduct_ID());
            pstmt.setInt(5, objBean.getProduct_cat_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateProductCategoryDetail(PlanDetailBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateProductCategoryDetail(PlanDetailBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    public String addProductCategoryDetail(ProductDetailBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into  productdetails (product_cat_Id, Name,Quantity,Price,Product_ID) values (?,?,?,?,?)");
            pstmt.setInt(1, objBean.getProduct_cat_ID());
            pstmt.setString(2, objBean.getName());
            pstmt.setInt(3, objBean.getQuantity());
            pstmt.setDouble(4, objBean.getPrice());
             pstmt.setInt(5, objBean.getProduct_ID());
           
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "added";
            }
        } catch (Exception e) {
            System.out.println("Exception in addProductCategoryDetail(ProductDetailBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in addProductCategoryDetail(ProductDetailBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }
    /*
     * --------------LoanIssueDetail--------------------
     */

    public ArrayList getAllLoanIssueDetailList() {
        Connection conn = null;
        ArrayList alstClientProfessional = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from loanissuemaster order by Loan_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    LoanIssueMasterBean objBean = new LoanIssueMasterBean();
                    objBean.setLoan_ID(rs.getInt("Loan_ID"));
                    objBean.setLoan_Duration_Year(rs.getDouble("Loan_Duration_Year"));
                    objBean.setEmi(rs.getDouble("EMI"));
                    objBean.setIssue_Date(rs.getString("Issue_Date"));
                    objBean.setCheck_Bank(rs.getString("Check_Bank"));
                    objBean.setCheck_No(rs.getString("Check_No"));
                    objBean.setFile_ID(rs.getInt("File_ID"));
                    alstClientProfessional.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllLoanIssueDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllLoanIssueDetailList() finally of DBoperations : " + e);
            }
        }
        return alstClientProfessional;
    }
    public LoanIssueMasterBean getLoanIssueDetailByFileID(int fileId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LoanIssueMasterBean objBean = null ;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from loanissuemaster where File_ID=?");
            pstmt.setInt(1, fileId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    objBean = new LoanIssueMasterBean();
                    objBean.setLoan_ID(rs.getInt("Loan_ID"));
                    objBean.setLoan_Duration_Year(rs.getDouble("Loan_Duration_Year"));
                    objBean.setEmi(rs.getDouble("EMI"));
                    objBean.setIssue_Date(rs.getString("Issue_Date"));
                    objBean.setCheck_Bank(rs.getString("Check_Bank"));
                    objBean.setCheck_No(rs.getString("Check_No"));
                    objBean.setFile_ID(rs.getInt("File_ID"));
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getLoanIssueDetailByFileID() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getLoanIssueDetailByFileID() finally of DBoperations : " + e);
            }
        }
        return objBean;
    }

    public ArrayList getLoanIssueReport() {
        Connection conn = null;
        ArrayList alstClientProfessional = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            //select lim.*,loan_amount from loanissuemaster lim,loanfilemaster lfm where lfm.file_id=lim.file_id order by Loan_ID;

            pstmt = conn.prepareStatement("select lim.*,loan_amount from loanissuemaster lim,loanfilemaster lfm where lfm.file_id=lim.file_id order by Loan_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {
                    LoanIssueMasterBean objBean = new LoanIssueMasterBean();
                    objBean.setLoan_ID(rs.getInt("Loan_ID"));
                    objBean.setLoan_Duration_Year(rs.getDouble("Loan_Duration_Year"));
                    objBean.setEmi(rs.getDouble("EMI"));
                    objBean.setIssue_Date(rs.getString("Issue_Date"));
                    objBean.setCheck_Bank(rs.getString("Check_Bank"));
                    objBean.setCheck_No(rs.getString("Check_No"));
                    objBean.setLoan_Amount(rs.getString("loan_amount"));
                    objBean.setFile_ID(rs.getInt("File_ID"));
                    alstClientProfessional.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllLoanIssueDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllLoanIssueDetailList() finally of DBoperations : " + e);
            }
        }
        return alstClientProfessional;
    }

    public String updateLoanIssueDetail(LoanIssueMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update loanissuemaster set Issue_Date=?,Loan_Duration_Year=?,EMI=?," +
                    "Check_No= ?,Check_Bank=? where Loan_ID =? and File_ID=?");

            pstmt.setString(1, objBean.getIssue_Date());
            pstmt.setDouble(2, objBean.getLoan_Duration_Year());
            pstmt.setDouble(3, objBean.getEmi());

            pstmt.setString(4, objBean.getCheck_No());
            pstmt.setString(5, objBean.getCheck_Bank());
            pstmt.setInt(6, objBean.getLoan_ID());
            pstmt.setInt(7, objBean.getFile_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateLoanIssueDetail(LoanIssueMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateLoanIssueDetail(LoanIssueMasterBean  objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }
    public String addLoanIssueDetail(LoanIssueMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into loanissuemaster (Loan_ID,Issue_Date,Loan_Duration_Year,EMI,Check_No,Check_Bank,File_ID) values (?,?,?,?,?,?,?)");
 
            pstmt.setInt(1, objBean.getLoan_ID());
            pstmt.setString(2, objBean.getIssue_Date());
            pstmt.setDouble(3, objBean.getLoan_Duration_Year());
            pstmt.setDouble(4, objBean.getEmi());
            pstmt.setString(5, objBean.getCheck_No());
            pstmt.setString(6, objBean.getCheck_Bank());
            pstmt.setInt(7, objBean.getFile_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "added";
            }
        } catch (Exception e) {
            System.out.println("Exception in addLoanIssueDetail(LoanIssueMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in addLoanIssueDetail(LoanIssueMasterBean  objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    public int getMaxLoanID() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxLoanID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select max(Loan_ID) from loanissuemaster");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxLoanID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getMaxLoanID() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getMaxLoanID() of DBoperations : " + e);
            }
        }
        return maxLoanID;
    }

    public int getInterestRateByFileId(int fileId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int interestRate = -1;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Interest_Rate from planmaster pm,loanfilemaster lfm where lfm.plan_id=pm.plan_id and lfm.File_id=" + fileId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                interestRate = rs.getInt("Interest_Rate");
            }
        } catch (Exception e) {
            System.out.println("Exception in getInterestRateByFileId() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getInterestRateByFileId() of DBoperations : " + e);
            }
        }
        return interestRate;
    }
    /*
     *
     * ------------------LoanFileDetail---------------
     *
     */

    public ArrayList getAllLoanFileDetailList() {
        Connection conn = null;
        ArrayList alstLoanFile = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            //select lfm.*,cp.client_id,cp.Name,pm.Plan_ID,pm.Plan_Name from loanfilemaster lfm,clientpersonal cp,planmaster pm where cp.client_id=lfm.client_Id and lfm.plan_Id=pm.plan_Id order by File_ID
            pstmt = conn.prepareStatement("select lfm.*,cp.Name,pm.Plan_Name from loanfilemaster lfm,clientpersonal cp,planmaster pm where cp.client_id=lfm.client_Id and lfm.plan_Id=pm.plan_Id order by File_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                    LoanFileMasterBean objBean = new LoanFileMasterBean();
                    objBean.setFile_ID(rs.getInt("File_ID"));
                    objBean.setClientName(rs.getString("Client_ID") + ". " + rs.getString("Name"));
                    objBean.setPlanName(rs.getString("Plan_ID") + ". " + rs.getString("Plan_Name"));

                    objBean.setClient_Bank_Statement(rs.getInt("client_Bank_Statement"));
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setClient_ID_Proof(rs.getInt("Client_ID_Proof"));

                    objBean.setClient_Income_Proof(rs.getInt("Client_Income_Proof"));
                    objBean.setClient_Residence_Proof(rs.getInt("Client_Residence_Proof"));
                    objBean.setPlan_ID(rs.getInt("Plan_ID"));

                    objBean.setUser_ID(rs.getInt("User_ID"));
                    objBean.setCreation_Date(rs.getString("Creation_Date"));
                    objBean.setLoan_Status(rs.getString("Loan_Status"));

                    objBean.setRemarks(rs.getString("Remarks"));
                    objBean.setLoan_Amount(rs.getDouble("Loan_Amount"));

                    alstLoanFile.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllLoanFileDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllLoanFileDetailList() finally of DBoperations : " + e);
            }
        }
        return alstLoanFile;
    }

    public ArrayList getAllLoanFileDetailListByPlanId(int planId) {
        Connection conn = null;
        ArrayList alstLoanFile = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            //select lfm.*,cp.client_id,cp.Name,pm.Plan_ID,pm.Plan_Name from loanfilemaster lfm,clientpersonal cp,planmaster pm where cp.client_id=lfm.client_Id and lfm.plan_Id=pm.plan_Id order by File_ID
            pstmt = conn.prepareStatement("select lfm.*,cp.Name,pm.Plan_Name from loanfilemaster lfm,clientpersonal cp,planmaster pm where cp.client_id=lfm.client_Id and lfm.plan_Id=pm.plan_Id and lfm.plan_Id=" + planId + " order by File_ID ");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                    LoanFileMasterBean objBean = new LoanFileMasterBean();
                    objBean.setFile_ID(rs.getInt("File_ID"));
                    objBean.setClientName(rs.getString("Client_ID") + ". " + rs.getString("Name"));
                    objBean.setPlanName(rs.getString("Plan_ID") + ". " + rs.getString("Plan_Name"));

                    objBean.setClient_Bank_Statement(rs.getInt("client_Bank_Statement"));
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setClient_ID_Proof(rs.getInt("Client_ID_Proof"));

                    objBean.setClient_Income_Proof(rs.getInt("Client_Income_Proof"));
                    objBean.setClient_Residence_Proof(rs.getInt("Client_Residence_Proof"));
                    objBean.setPlan_ID(rs.getInt("Plan_ID"));

                    objBean.setUser_ID(rs.getInt("User_ID"));
                    objBean.setCreation_Date(rs.getString("Creation_Date"));
                    objBean.setLoan_Status(rs.getString("Loan_Status"));

                    objBean.setRemarks(rs.getString("Remarks"));
                    objBean.setLoan_Amount(rs.getDouble("Loan_Amount"));

                    alstLoanFile.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllLoanFileDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllLoanFileDetailList() finally of DBoperations : " + e);
            }
        }
        return alstLoanFile;
    }

    public int getMaxFileID() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxFileID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Max(File_ID) from loanfilemaster");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxFileID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("  getMaxFileID of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(" getMaxFileID() of DBoperations : " + e);
            }
        }
        return maxFileID;
    }

    public ArrayList getAllPlanNameList() {
        Connection conn = null;
        ArrayList alstPlanName = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Plan_ID,Plan_Name from planmaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                alstPlanName.add(rs.getString("Plan_ID") + ". " + rs.getString("Plan_Name"));
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllPlanNameList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllPlanNameList() of DBoperations : " + e);
            }
        }
        return alstPlanName;
    }

    public ArrayList getAllClientNameList() {
        Connection conn = null;
        ArrayList alstClientName = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Client_ID,Name from clientpersonal");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                alstClientName.add(rs.getString("Client_ID") + ". " + rs.getString("Name"));
            }
        } catch (Exception e) {
            System.out.println("getAllClientNameList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllClientNameList() of DBoperations : " + e);
            }
        }
        return alstClientName;
    }

    public String addLoanFileDetail(LoanFileMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into loanfilemaster (Creation_Date,Plan_ID,Client_ID," +
                    "Loan_Amount,Loan_Status,Client_ID_Proof," +
                    "Client_Income_Proof,Client_Residence_Proof,Client_Bank_Statement," +
                    "Remarks,User_ID,File_ID)values(?,?,?,?,?,?,?,?,?,?,?,?)");



            pstmt.setString(1, objBean.getCreation_Date());
            pstmt.setInt(2, objBean.getPlan_ID());
            pstmt.setInt(3, objBean.getClient_ID());
            pstmt.setDouble(4, objBean.getLoan_Amount());
            pstmt.setString(5, objBean.getLoan_Status());
            pstmt.setInt(6, objBean.getClient_ID_Proof());
            pstmt.setInt(7, objBean.getClient_Income_Proof());
            pstmt.setInt(8, objBean.getClient_Residence_Proof());
            pstmt.setInt(9, objBean.getClient_Bank_Statement());

            pstmt.setString(10, objBean.getRemarks());
            pstmt.setInt(11, objBean.getUser_ID());
            pstmt.setInt(12, objBean.getFile_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "added";
            }
        } catch (Exception e) {
            System.out.println("Exception in addLoanFileDetail(LoanFileMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in addLoanFileDetail(LoanFileMasterBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    public String updateLoanFileDetail(LoanFileMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update loanfilemaster set Creation_Date=?,Plan_ID=?,Client_ID= ?," +
                    "Loan_Amount=?,Loan_Status=?,Client_ID_Proof=?," +
                    "Client_Income_Proof=?,Client_Residence_Proof=?,Client_Bank_Statement=?," +
                    "Remarks=?,User_ID=? where File_ID =?");

            pstmt.setString(1, objBean.getCreation_Date());
            pstmt.setInt(2, objBean.getPlan_ID());
            pstmt.setInt(3, objBean.getClient_ID());
            pstmt.setDouble(4, objBean.getLoan_Amount());
            pstmt.setString(5, objBean.getLoan_Status());
            pstmt.setInt(6, objBean.getClient_ID_Proof());
            pstmt.setInt(7, objBean.getClient_Income_Proof());
            pstmt.setInt(8, objBean.getClient_Residence_Proof());
            pstmt.setInt(9, objBean.getClient_Bank_Statement());

            pstmt.setString(10, objBean.getRemarks());
            pstmt.setInt(11, objBean.getUser_ID());
            pstmt.setInt(12, objBean.getFile_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateLoanFileDetail(LoanFileMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateLoanFileDetail(LoanFileMasterBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    /*
     *
     * ------------------OrderFileDetail---------------
     *
     */

    public ArrayList getAllOrderFileDetailList() {
        Connection conn = null;
        ArrayList alstOrderFile = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            //select lfm.*,cp.client_id,cp.Name,pm.Plan_ID,pm.Plan_Name from loanfilemaster lfm,clientpersonal cp,planmaster pm where cp.client_id=lfm.client_Id and lfm.plan_Id=pm.plan_Id order by File_ID
            pstmt = conn.prepareStatement("select ofm.*,cp.Name,pm.Product_Type,pcm.Name from orderfilemaster ofm,clientpersonal cp,productmaster pm,productdetails pcm where cp.client_id=ofm.client_Id and ofm.Product_ID=pm.Product_ID and pcm.product_cat_ID=ofm.Product_Cat_ID order by Order_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                    OrderMasterBean objBean = new OrderMasterBean();
                    objBean.setOrder_ID(rs.getInt("Order_ID"));
                    objBean.setClientName(rs.getString("Client_ID") + ". " + rs.getString("Name"));
                    objBean.setProductName(rs.getString("Product_ID") + ". " + rs.getString("Product_Type"));
                    objBean.setProductCategoryName(rs.getString("product_cat_ID") + ". " + rs.getString(10));
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setProduct_ID(rs.getInt("Product_ID"));
                    objBean.setProduct_Cat_ID(rs.getInt("product_cat_ID"));
                    objBean.setQuantity(rs.getInt("Quantity"));
                    objBean.setCreation_Date(rs.getString("Creation_Date"));
                    objBean.setTotal_Price(rs.getDouble("Total_Price"));

                    alstOrderFile.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllOrderFileDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllOrderFileDetailList() finally of DBoperations : " + e);
            }
        }
        return alstOrderFile;
    }

    public ArrayList getAllOrderFileDetailListByProductId(int productId) {
        Connection conn = null;
        ArrayList alstOrderFile = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            //select lfm.*,cp.client_id,cp.Name,pm.Plan_ID,pm.Plan_Name from loanfilemaster lfm,clientpersonal cp,planmaster pm where cp.client_id=lfm.client_Id and lfm.plan_Id=pm.plan_Id order by File_ID
           
            pstmt = conn.prepareStatement("select ofm.*,cp.Name,pm.Product_Type,pcm.Name from orderfilemaster ofm,clientpersonal cp,productmaster pm,productdetails pcm where cp.client_id=ofm.client_Id and ofm.Product_ID=pm.Product_ID and pcm.product_cat_ID=ofm.Product_Cat_ID and ofm.Product_ID=" + productId + " order by Order_ID");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                {

                   OrderMasterBean objBean = new OrderMasterBean();
                    objBean.setOrder_ID(rs.getInt("Order_ID"));
                    objBean.setClientName(rs.getInt("Client_ID") + ". " + rs.getString("Name"));
                    objBean.setProductName(rs.getInt("Product_ID") + ". " + rs.getString("Product_Type"));
                    objBean.setProductCategoryName(rs.getInt("product_cat_ID") + ". " + rs.getString("Name"));
                    objBean.setClient_ID(rs.getInt("Client_ID"));
                    objBean.setProduct_ID(rs.getInt("Product_ID"));
                    objBean.setProduct_Cat_ID(rs.getInt("product_cat_ID"));
                    objBean.setQuantity(rs.getInt("Quantity"));
                    objBean.setCreation_Date(rs.getString("Creation_Date"));
                    objBean.setTotal_Price(rs.getDouble("Total_Price"));
                    alstOrderFile.add(objBean);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllOrderFileDetailList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllOrderFileDetailList() finally of DBoperations : " + e);
            }
        }
        return alstOrderFile;
    }

    public int getMaxOrderID() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxOrderID = 0;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Max(Order_ID) from orderfilemaster");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                maxOrderID = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("  getMaxOrderID of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(" getMaxOrderID() of DBoperations : " + e);
            }
        }
        return maxOrderID;
    }

    public ArrayList getAllProductNameList() {
        Connection conn = null;
        ArrayList alstProductName = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Product_ID,Product_Type from productmaster");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                alstProductName.add(rs.getInt("Product_ID") + ". " + rs.getString("Product_Type"));
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllProductNameList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllProductNameList() of DBoperations : " + e);
            }
        }
        return alstProductName;
    }
 public ArrayList getAllProductCategoryNameList() {
        Connection conn = null;
        ArrayList alstProductCategoryName = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select product_cat_ID,Name from productdetails");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                alstProductCategoryName.add(rs.getInt("product_cat_ID") + ". " + rs.getString("Name"));
            }
        } catch (Exception e) {
            System.out.println("Exception in getAllProductCategoryNameList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in getAllProductNameList() of DBoperations : " + e);
            }
        }
        return alstProductCategoryName;
    }

    public ArrayList getAllClientNameList1() {
        Connection conn = null;
        ArrayList alstClientName = new ArrayList();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select Client_ID,Name from clientpersonal");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                alstClientName.add(rs.getString("Client_ID") + ". " + rs.getString("Name"));
            }
        } catch (Exception e) {
            System.out.println("getAllClientNameList() of DBoperations : " + e);
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("getAllClientNameList() of DBoperations : " + e);
            }
        }
        return alstClientName;
    }

    public String addOrderFileDetail(OrderMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into orderfilemaster (Creation_Date,Client_ID," +
                    "Product_ID,Product_Cat_ID," +
                    "Quantity," +
                    "Total_Price,Order_ID)values(?,?,?,?,?,?,?)");

            pstmt.setString(1, objBean.getCreation_Date());
            pstmt.setInt(2, objBean.getClient_ID());
            pstmt.setInt(3, objBean.getProduct_ID());
            pstmt.setInt(4, objBean.getProduct_Cat_ID());
            pstmt.setInt(5, objBean.getQuantity());
            pstmt.setDouble(6, objBean.getTotal_Price());
            pstmt.setInt(7, objBean.getOrder_ID());

            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "added";
            }
        } catch (Exception e) {
            System.out.println("Exception in addOrderFileDetail(OrderFileMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in addOrderFileDetail(OrderFileMasterBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    public String updateOrderFileDetail(OrderMasterBean objBean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "failed";
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update orderfilemaster set Creation_Date=?,Client_ID= ?,Product_ID=?," +
                    "Product_Cat_ID=?,Quantity=?,Total_Price=? where Order_ID =?" );

            pstmt.setString(1, objBean.getCreation_Date());
            pstmt.setInt(2, objBean.getClient_ID());
            pstmt.setInt(3, objBean.getProduct_ID());
            pstmt.setInt(4, objBean.getProduct_Cat_ID());
            pstmt.setInt(5, objBean.getQuantity());
            pstmt.setDouble(6, objBean.getTotal_Price());
            pstmt.setInt(7, objBean.getOrder_ID());
            System.out.println(pstmt.toString());
            int i = pstmt.executeUpdate();
            if (i > 0) {
                result = "updated";
            }
        } catch (Exception e) {
            System.out.println("Exception in updateOrderFileDetail(OrderFileMasterBean objBean) of DBoperations : " + e);
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Exception in updateOrderFileDetail(OrderFileMasterBean objBean) finally of DBoperations : " + e);
            }
        }
        return result;
    }

    //---------------------------------------------------------------------------------------
    //          Common Methods
    //-----------------------------------------------------------------------------------------------
    public String getCurrentDateTime() {
        java.util.Date dd = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        String strDate = sdf.format(dd);
        return strDate;
    }
}
