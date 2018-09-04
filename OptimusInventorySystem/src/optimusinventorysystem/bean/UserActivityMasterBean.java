/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package optimusinventorysystem.bean;

/**
 *
 * @author Rajesh
 */
public class UserActivityMasterBean {
    private int userId;
    private int activityId;
    private String username;
    private String loginTime;
    private String logoutTime;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
